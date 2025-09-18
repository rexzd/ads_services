package se.umu.cs.ads.a1.clients;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import se.umu.cs.ads.a1.grpc.MessengerProto;
import se.umu.cs.ads.a1.grpc.MessengerServiceGrpc;
import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.grpc.ProtoMapper;
import se.umu.cs.ads.a1.types.*;

/**
 * Client implementation of the Messenger interface using gRPC.
 * Relies on the generated stubs from Messenger.proto, where all
 * requests and responses are serialized with Protocol Buffers.
 */
public class GrpcMessenger implements Messenger {
    private final ManagedChannel channel;
    private final MessengerServiceGrpc.MessengerServiceBlockingStub stub;

    public GrpcMessenger() {
        this("localhost", 9000);
    }

    public GrpcMessenger(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .maxInboundMessageSize(128 * 1024 * 1024)
                .build();
        this.stub = MessengerServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() {
        channel.shutdown();
    }

    @Override
    public void store(Message message) {
        MessengerProto.StoreRequest req = MessengerProto.StoreRequest.newBuilder()
                .addMessages(ProtoMapper.toProto(message))
                .build();
        stub.store(req);
    }

    @Override
    public void store(Message[] messages) {
        MessengerProto.StoreRequest.Builder req = MessengerProto.StoreRequest.newBuilder();
        for (Message m : messages) {
            req.addMessages(ProtoMapper.toProto(m));
        }
        stub.store(req.build());
    }

    @Override
    public Message retrieve(MessageId id) {
        MessengerProto.RetrieveRequest req = MessengerProto.RetrieveRequest.newBuilder()
                .addIds(ProtoMapper.toProto(id))
                .build();
        MessengerProto.RetrieveResponse resp = stub.retrieve(req);
        return ProtoMapper.toDomain(resp.getMessages(0));
    }

    @Override
    public Message[] retrieve(MessageId[] ids) {
        MessengerProto.RetrieveRequest.Builder req = MessengerProto.RetrieveRequest.newBuilder();
        for (MessageId id : ids) {
            req.addIds(ProtoMapper.toProto(id));
        }
        MessengerProto.RetrieveResponse resp = stub.retrieve(req.build());
        return ProtoMapper.toDomainMessages(resp.getMessagesList());
    }

    @Override
    public void delete(MessageId id) {
        MessengerProto.DeleteRequest req = MessengerProto.DeleteRequest.newBuilder()
                .addIds(ProtoMapper.toProto(id))
                .build();
        stub.delete(req);
    }

    @Override
    public void delete(MessageId[] ids) {
        MessengerProto.DeleteRequest.Builder req = MessengerProto.DeleteRequest.newBuilder();
        for (MessageId id : ids) {
            req.addIds(ProtoMapper.toProto(id));
        }
        stub.delete(req.build());
    }

    @Override
    public Topic[] subscribe(Username username, Topic topic) {
        MessengerProto.SubscriptionRequest req = MessengerProto.SubscriptionRequest.newBuilder()
                .setUsername(ProtoMapper.toProto(username))
                .setTopic(ProtoMapper.toProto(topic))
                .build();
        MessengerProto.TopicList resp = stub.subscribe(req);
        return resp.getTopicsList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(Topic[]::new);
    }

    @Override
    public Topic[] unsubscribe(Username username, Topic topic) {
        MessengerProto.SubscriptionRequest req = MessengerProto.SubscriptionRequest.newBuilder()
                .setUsername(ProtoMapper.toProto(username))
                .setTopic(ProtoMapper.toProto(topic))
                .build();
        MessengerProto.TopicList resp = stub.unsubscribe(req);
        return resp.getTopicsList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(Topic[]::new);
    }

    @Override
    public Username[] listUsers() {
        MessengerProto.UsernameList resp = stub.listUsers(com.google.protobuf.Empty.getDefaultInstance());
        return resp.getUsersList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(Username[]::new);
    }

    @Override
    public Topic[] listTopics() {
        MessengerProto.TopicList resp = stub.listTopics(com.google.protobuf.Empty.getDefaultInstance());
        return resp.getTopicsList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(Topic[]::new);
    }

    @Override
    public Topic[] listTopics(Username username) {
        MessengerProto.TopicList resp = stub.listUserTopics(ProtoMapper.toProto(username));
        return resp.getTopicsList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(Topic[]::new);
    }

    @Override
    public Username[] listSubscribers(Topic topic) {
        MessengerProto.UsernameList resp = stub.listSubscribers(ProtoMapper.toProto(topic));
        return resp.getUsersList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(Username[]::new);
    }

    @Override
    public MessageId[] listMessages(Username username) {
        MessengerProto.MessageIdList resp = stub.listUserMessages(ProtoMapper.toProto(username));
        return resp.getIdsList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(MessageId[]::new);
    }

    @Override
    public MessageId[] listMessages(Topic topic) {
        MessengerProto.MessageIdList resp = stub.listTopicMessages(ProtoMapper.toProto(topic));
        return resp.getIdsList().stream()
                .map(ProtoMapper::toDomain)
                .toArray(MessageId[]::new);
    }
}
