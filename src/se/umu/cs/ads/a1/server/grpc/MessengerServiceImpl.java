package se.umu.cs.ads.a1.server.grpc;

import com.google.protobuf.Empty;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import se.umu.cs.ads.a1.grpc.MessengerProto;
import se.umu.cs.ads.a1.grpc.MessengerServiceGrpc;
import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.types.*;

public class MessengerServiceImpl extends MessengerServiceGrpc.MessengerServiceImplBase {
    private final Messenger backend;

    public MessengerServiceImpl(Messenger backend) {
        this.backend = backend;
    }

    @Override
    public void store(MessengerProto.StoreRequest req, StreamObserver<Empty> obs) {
        try {
            if (req.getMessagesCount() == 1) {
                backend.store(ProtoMapper.toDomain(req.getMessages(0)));
            } else {
                backend.store(ProtoMapper.toDomainMessages(req.getMessagesList()));
            }
            obs.onNext(Empty.getDefaultInstance());
            obs.onCompleted();
        } catch (IllegalArgumentException e) {
            obs.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException());
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void retrieve(MessengerProto.RetrieveRequest req, StreamObserver<MessengerProto.RetrieveResponse> obs) {
        try {
            if (req.getIdsCount() == 1) {
                Message m = backend.retrieve(ProtoMapper.toDomain(req.getIds(0)));
                obs.onNext(MessengerProto.RetrieveResponse.newBuilder().addMessages(ProtoMapper.toProto(m)).build());
            } else {
                Message[] messages = backend.retrieve(ProtoMapper.toDomainMessageIds(req.getIdsList()));
                obs.onNext(ProtoMapper.toProto(messages));
            }
            obs.onCompleted();
        } catch (IllegalArgumentException notFound) {
            obs.onError(Status.NOT_FOUND.withDescription(notFound.getMessage()).asRuntimeException());
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void delete(MessengerProto.DeleteRequest req, StreamObserver<Empty> obs) {
        try {
            if (req.getIdsCount() == 1) {
                backend.delete(ProtoMapper.toDomain(req.getIds(0)));
            } else {
                backend.delete(ProtoMapper.toDomainMessageIds(req.getIdsList()));
            }
            obs.onNext(Empty.getDefaultInstance());
            obs.onCompleted();
        } catch (IllegalArgumentException notFound) {
            obs.onError(Status.NOT_FOUND.withDescription(notFound.getMessage()).asRuntimeException());
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void subscribe(MessengerProto.SubscriptionRequest req, StreamObserver<MessengerProto.TopicList> obs) {
        try {
            Topic[] topics = backend.subscribe(
                ProtoMapper.toDomain(req.getUsername()),
                ProtoMapper.toDomain(req.getTopic())
            );
            obs.onNext(ProtoMapper.toProtoTopics(topics));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void unsubscribe(MessengerProto.SubscriptionRequest req, StreamObserver<MessengerProto.TopicList> obs) {
        try {
            Topic[] topics = backend.unsubscribe(
                ProtoMapper.toDomain(req.getUsername()),
                ProtoMapper.toDomain(req.getTopic())
            );
            obs.onNext(ProtoMapper.toProtoTopics(topics));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void listUsers(Empty req, StreamObserver<MessengerProto.UsernameList> obs) {
        try {
            obs.onNext(ProtoMapper.toProtoUsers(backend.listUsers()));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void listTopics(Empty req, StreamObserver<MessengerProto.TopicList> obs) {
        try {
            obs.onNext(ProtoMapper.toProtoTopics(backend.listTopics()));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void listUserTopics(MessengerProto.Username req, StreamObserver<MessengerProto.TopicList> obs) {
        try {
            obs.onNext(ProtoMapper.toProtoTopics(backend.listTopics(ProtoMapper.toDomain(req))));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void listSubscribers(MessengerProto.Topic req, StreamObserver<MessengerProto.UsernameList> obs) {
        try {
            obs.onNext(ProtoMapper.toProtoUsers(backend.listSubscribers(ProtoMapper.toDomain(req))));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void listUserMessages(MessengerProto.Username req, StreamObserver<MessengerProto.MessageIdList> obs) {
        try {
            obs.onNext(ProtoMapper.toProtoMessageIds(backend.listMessages(ProtoMapper.toDomain(req))));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }

    @Override
    public void listTopicMessages(MessengerProto.Topic req, StreamObserver<MessengerProto.MessageIdList> obs) {
        try {
            obs.onNext(ProtoMapper.toProtoMessageIds(backend.listMessages(ProtoMapper.toDomain(req))));
            obs.onCompleted();
        } catch (Exception e) {
            obs.onError(Status.INTERNAL.withDescription(e.getMessage()).asRuntimeException());
        }
    }
}
