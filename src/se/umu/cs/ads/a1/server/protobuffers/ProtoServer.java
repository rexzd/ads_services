package se.umu.cs.ads.a1.server.protobuffers;

import java.net.*;
import java.io.*;
import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.types.*;
import se.umu.cs.ads.a1.grpc.MessengerProto;
import se.umu.cs.ads.a1.server.REST.BackendLocator;
import se.umu.cs.ads.a1.server.grpc.ProtoMapper;

/**
 * Standalone Protocol Buffers server.
 * Accepts socket connections, handles protobuf-encoded requests
 * and provides all operations to the backend Messenger.
 */
public class ProtoServer {
    public static void main(String[] args) throws Exception {
        int port = (args.length > 0) ? Integer.parseInt(args[0]) : 10000;
        Messenger backend = BackendLocator.getMessenger();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("ProtoServer started on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> handleClient(socket, backend)).start();
            }
        }
    }

    private static void handleClient(Socket socket, Messenger backend) {
        try (InputStream in = socket.getInputStream(); OutputStream out = socket.getOutputStream()) {
            MessengerProto.Request req;
            while ((req = MessengerProto.Request.parseDelimitedFrom(in)) != null) {
                MessengerProto.Response resp = handleRequest(req, backend);
                resp.writeDelimitedTo(out);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Client disconnected: " + e.getMessage());
        }
    }

    private static MessengerProto.Response handleRequest(MessengerProto.Request req, Messenger backend) {
        try {
            if (req.hasStore()) {
                MessengerProto.StoreRequest storeReq = req.getStore();
                if (storeReq.getMessagesCount() == 1) {
                    MessengerProto.Message protoMsg = storeReq.getMessages(0);
                    Message domainMsg = ProtoMapper.toDomain(protoMsg);
                    backend.store(domainMsg);
                } else {
                    java.util.List<MessengerProto.Message> protoMsgs = storeReq.getMessagesList();
                    Message[] domainMsgs = ProtoMapper.toDomainMessages(protoMsgs);
                    backend.store(domainMsgs);
                }
                return MessengerProto.Response.newBuilder().setEmpty(com.google.protobuf.Empty.getDefaultInstance()).build();
            }

            if (req.hasRetrieve()) {
                MessengerProto.RetrieveRequest retrieveReq = req.getRetrieve();
                if (retrieveReq.getIdsCount() == 1) {
                    MessengerProto.MessageId protoId = retrieveReq.getIds(0);
                    MessageId domainId = ProtoMapper.toDomain(protoId);
                    Message domainMsg = backend.retrieve(domainId);
                    MessengerProto.Message protoMsg = ProtoMapper.toProto(domainMsg);
                    MessengerProto.RetrieveResponse retrieveResp = MessengerProto.RetrieveResponse.newBuilder().addMessages(protoMsg).build();
                    return MessengerProto.Response.newBuilder().setRetrieveResp(retrieveResp).build();

                } else {
                    java.util.List<MessengerProto.MessageId> protoIds = retrieveReq.getIdsList();
                    MessageId[] domainIds = ProtoMapper.toDomainMessageIds(protoIds);
                    Message[] domainMsgs = backend.retrieve(domainIds);
                    MessengerProto.RetrieveResponse retrieveResp = ProtoMapper.toProto(domainMsgs);
                    return MessengerProto.Response.newBuilder().setRetrieveResp(retrieveResp).build();
                }
            }

            if (req.hasDelete()) {
                MessengerProto.DeleteRequest deleteReq = req.getDelete();
                if (deleteReq.getIdsCount() == 1) {
                    MessengerProto.MessageId protoId = deleteReq.getIds(0);
                    MessageId domainId = ProtoMapper.toDomain(protoId);
                    backend.delete(domainId);
                } else {
                    java.util.List<MessengerProto.MessageId> protoIds = deleteReq.getIdsList();
                    MessageId[] domainIds = ProtoMapper.toDomainMessageIds(protoIds);
                    backend.delete(domainIds);
                }
                return MessengerProto.Response.newBuilder().setEmpty(com.google.protobuf.Empty.getDefaultInstance()).build();
            }

            if (req.hasSubscribe()) {
                MessengerProto.SubscriptionRequest subReq = req.getSubscribe();
                Username domainUser = ProtoMapper.toDomain(subReq.getUsername());
                Topic domainTopic = ProtoMapper.toDomain(subReq.getTopic());
                Topic[] domainTopics = backend.subscribe(domainUser, domainTopic);
                MessengerProto.TopicList protoTopics = ProtoMapper.toProtoTopics(domainTopics);
                return MessengerProto.Response.newBuilder().setTopicList(protoTopics).build();
            }

            if (req.hasUnsubscribe()) {
                MessengerProto.SubscriptionRequest unsubReq = req.getUnsubscribe();
                Username domainUser = ProtoMapper.toDomain(unsubReq.getUsername());
                Topic domainTopic = ProtoMapper.toDomain(unsubReq.getTopic());
                Topic[] domainTopics = backend.unsubscribe(domainUser, domainTopic);
                MessengerProto.TopicList protoTopics = ProtoMapper.toProtoTopics(domainTopics);
                return MessengerProto.Response.newBuilder().setTopicList(protoTopics).build();
            }

            if (req.hasListUsers()) {
                Username[] users = backend.listUsers();
                MessengerProto.UsernameList protoUsers = ProtoMapper.toProtoUsers(users);
                return MessengerProto.Response.newBuilder().setUsernameList(protoUsers).build();
            }

            if (req.hasListTopics()) {
                Topic[] topics = backend.listTopics();
                MessengerProto.TopicList protoTopics = ProtoMapper.toProtoTopics(topics);
                return MessengerProto.Response.newBuilder().setTopicList(protoTopics).build();
            }

            if (req.hasListUserTopics()) {
                MessengerProto.Username protoUser = req.getListUserTopics();
                Username domainUser = ProtoMapper.toDomain(protoUser);
                Topic[] topics = backend.listTopics(domainUser);
                MessengerProto.TopicList protoTopics = ProtoMapper.toProtoTopics(topics);
                return MessengerProto.Response.newBuilder().setTopicList(protoTopics).build();
            }

            if (req.hasListSubscribers()) {
                MessengerProto.Topic protoTopic = req.getListSubscribers();
                Topic domainTopic = ProtoMapper.toDomain(protoTopic);
                Username[] users = backend.listSubscribers(domainTopic);
                MessengerProto.UsernameList protoUsers = ProtoMapper.toProtoUsers(users);
                return MessengerProto.Response.newBuilder().setUsernameList(protoUsers).build();
            }

            if (req.hasListUserMessages()) {
                MessengerProto.Username protoUser = req.getListUserMessages();
                Username domainUser = ProtoMapper.toDomain(protoUser);
                MessageId[] ids = backend.listMessages(domainUser);
                MessengerProto.MessageIdList protoIds = ProtoMapper.toProtoMessageIds(ids);
                return MessengerProto.Response.newBuilder().setMessageIdList(protoIds).build();
            }

            if (req.hasListTopicMessages()) {
                MessengerProto.Topic protoTopic = req.getListTopicMessages();
                Topic domainTopic = ProtoMapper.toDomain(protoTopic);
                MessageId[] ids = backend.listMessages(domainTopic);
                MessengerProto.MessageIdList protoIds = ProtoMapper.toProtoMessageIds(ids);
                return MessengerProto.Response.newBuilder().setMessageIdList(protoIds).build();
            }

            return MessengerProto.Response.newBuilder().setEmpty(com.google.protobuf.Empty.getDefaultInstance()).build();

        } catch (IllegalArgumentException e) {
            return MessengerProto.Response.newBuilder()
                    .setEmpty(com.google.protobuf.Empty.getDefaultInstance())
                    .build();
        } catch (Exception e) {
            return MessengerProto.Response.newBuilder()
                    .setEmpty(com.google.protobuf.Empty.getDefaultInstance())
                    .build();
        }
    }

}
