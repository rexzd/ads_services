package se.umu.cs.ads.a1.clients;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

import se.umu.cs.ads.a1.grpc.MessengerProto;
import se.umu.cs.ads.a1.types.*;
import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.grpc.ProtoMapper;


/**
 * Client implementation of the Messenger interface using Protocol Buffers
 * over raw TCP sockets. Requests and responses are serialized using
 * MessengerProto and sent directly without an RPC framework.
 */
public class ProtoMessenger implements Messenger {
    private final String host;
    private final int port;

    public ProtoMessenger() {
        this("localhost", 10000);
    }

    public ProtoMessenger(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private MessengerProto.Response sendRequest(MessengerProto.Request req) throws IOException {
        try (Socket socket = new Socket(host, port); OutputStream out = socket.getOutputStream(); InputStream in = socket.getInputStream()) {
            req.writeDelimitedTo(out);
            out.flush();
            return MessengerProto.Response.parseDelimitedFrom(in);
        }
    }

    @Override
    public void store(Message message) {
        try {
            MessengerProto.StoreRequest storeReq = MessengerProto.StoreRequest.newBuilder().addMessages(ProtoMapper.toProto(message)).build();
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setStore(storeReq).build();
            sendRequest(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void store(Message[] messages) {
        try {
            MessengerProto.StoreRequest.Builder builder = MessengerProto.StoreRequest.newBuilder();
            for (Message m : messages) {
                builder.addMessages(ProtoMapper.toProto(m));
            }
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setStore(builder.build()).build();
            sendRequest(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message retrieve(MessageId id) {
        try {
            MessengerProto.RetrieveRequest retrieveReq = MessengerProto.RetrieveRequest.newBuilder().addIds(ProtoMapper.toProto(id)).build();
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setRetrieve(retrieveReq).build();
            MessengerProto.Response resp = sendRequest(req);
            return ProtoMapper.toDomain(resp.getRetrieveResp().getMessages(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Message[] retrieve(MessageId[] ids) {
        try {
            MessengerProto.RetrieveRequest.Builder builder = MessengerProto.RetrieveRequest.newBuilder();
            for (MessageId id : ids) {
                builder.addIds(ProtoMapper.toProto(id));
            }
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setRetrieve(builder.build()).build();
            MessengerProto.Response resp = sendRequest(req);
            return ProtoMapper.toDomainMessages(resp.getRetrieveResp().getMessagesList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(MessageId id) {
        try {
            MessengerProto.DeleteRequest deleteReq = MessengerProto.DeleteRequest.newBuilder().addIds(ProtoMapper.toProto(id)).build();
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setDelete(deleteReq).build();
            sendRequest(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(MessageId[] ids) {
        try {
            MessengerProto.DeleteRequest.Builder builder = MessengerProto.DeleteRequest.newBuilder();
            for (MessageId id : ids) {
                builder.addIds(ProtoMapper.toProto(id));
            }
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setDelete(builder.build()).build();
            sendRequest(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] subscribe(Username username, Topic topic) {
        try {
            MessengerProto.SubscriptionRequest subReq = MessengerProto.SubscriptionRequest.newBuilder()
                    .setUsername(ProtoMapper.toProto(username)).setTopic(ProtoMapper.toProto(topic)).build();
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setSubscribe(subReq).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getTopicList().getTopicsList().stream().map(ProtoMapper::toDomain).toArray(Topic[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] unsubscribe(Username username, Topic topic) {
        try {
            MessengerProto.SubscriptionRequest unsubReq = MessengerProto.SubscriptionRequest.newBuilder()
                    .setUsername(ProtoMapper.toProto(username)).setTopic(ProtoMapper.toProto(topic)).build();
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setUnsubscribe(unsubReq).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getTopicList().getTopicsList().stream().map(ProtoMapper::toDomain).toArray(Topic[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Username[] listUsers() {
        try {
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setListUsers(com.google.protobuf.Empty.getDefaultInstance()).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getUsernameList().getUsersList().stream().map(ProtoMapper::toDomain).toArray(Username[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] listTopics() {
        try {
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setListTopics(com.google.protobuf.Empty.getDefaultInstance()).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getTopicList().getTopicsList().stream().map(ProtoMapper::toDomain).toArray(Topic[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic[] listTopics(Username username) {
        try {
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setListUserTopics(ProtoMapper.toProto(username)).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getTopicList().getTopicsList().stream().map(ProtoMapper::toDomain).toArray(Topic[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Username[] listSubscribers(Topic topic) {
        try {
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setListSubscribers(ProtoMapper.toProto(topic)).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getUsernameList().getUsersList().stream().map(ProtoMapper::toDomain).toArray(Username[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageId[] listMessages(Username username) {
        try {
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setListUserMessages(ProtoMapper.toProto(username)).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getMessageIdList().getIdsList().stream().map(ProtoMapper::toDomain).toArray(MessageId[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageId[] listMessages(Topic topic) {
        try {
            MessengerProto.Request req = MessengerProto.Request.newBuilder().setListTopicMessages(ProtoMapper.toProto(topic)).build();
            MessengerProto.Response resp = sendRequest(req);
            return resp.getMessageIdList().getIdsList().stream().map(ProtoMapper::toDomain).toArray(MessageId[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
