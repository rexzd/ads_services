package se.umu.cs.ads.a1.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: Messenger.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MessengerServiceGrpc {

  private MessengerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "messenger.MessengerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest,
      com.google.protobuf.Empty> getStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Store",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest,
      com.google.protobuf.Empty> getStoreMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest, com.google.protobuf.Empty> getStoreMethod;
    if ((getStoreMethod = MessengerServiceGrpc.getStoreMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getStoreMethod = MessengerServiceGrpc.getStoreMethod) == null) {
          MessengerServiceGrpc.getStoreMethod = getStoreMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Store"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("Store"))
              .build();
        }
      }
    }
    return getStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest,
      se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse> getRetrieveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Retrieve",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest,
      se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse> getRetrieveMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest, se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse> getRetrieveMethod;
    if ((getRetrieveMethod = MessengerServiceGrpc.getRetrieveMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getRetrieveMethod = MessengerServiceGrpc.getRetrieveMethod) == null) {
          MessengerServiceGrpc.getRetrieveMethod = getRetrieveMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest, se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Retrieve"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("Retrieve"))
              .build();
        }
      }
    }
    return getRetrieveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest,
      com.google.protobuf.Empty> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest,
      com.google.protobuf.Empty> getDeleteMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest, com.google.protobuf.Empty> getDeleteMethod;
    if ((getDeleteMethod = MessengerServiceGrpc.getDeleteMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getDeleteMethod = MessengerServiceGrpc.getDeleteMethod) == null) {
          MessengerServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("Delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getSubscribeMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getSubscribeMethod;
    if ((getSubscribeMethod = MessengerServiceGrpc.getSubscribeMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getSubscribeMethod = MessengerServiceGrpc.getSubscribeMethod) == null) {
          MessengerServiceGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("Subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Unsubscribe",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getUnsubscribeMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getUnsubscribeMethod;
    if ((getUnsubscribeMethod = MessengerServiceGrpc.getUnsubscribeMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getUnsubscribeMethod = MessengerServiceGrpc.getUnsubscribeMethod) == null) {
          MessengerServiceGrpc.getUnsubscribeMethod = getUnsubscribeMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Unsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("Unsubscribe"))
              .build();
        }
      }
    }
    return getUnsubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> getListUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsers",
      requestType = com.google.protobuf.Empty.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> getListUsersMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> getListUsersMethod;
    if ((getListUsersMethod = MessengerServiceGrpc.getListUsersMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getListUsersMethod = MessengerServiceGrpc.getListUsersMethod) == null) {
          MessengerServiceGrpc.getListUsersMethod = getListUsersMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("ListUsers"))
              .build();
        }
      }
    }
    return getListUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getListTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTopics",
      requestType = com.google.protobuf.Empty.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getListTopicsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getListTopicsMethod;
    if ((getListTopicsMethod = MessengerServiceGrpc.getListTopicsMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getListTopicsMethod = MessengerServiceGrpc.getListTopicsMethod) == null) {
          MessengerServiceGrpc.getListTopicsMethod = getListTopicsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTopics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("ListTopics"))
              .build();
        }
      }
    }
    return getListTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Username,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getListUserTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserTopics",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.Username.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Username,
      se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getListUserTopicsMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Username, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> getListUserTopicsMethod;
    if ((getListUserTopicsMethod = MessengerServiceGrpc.getListUserTopicsMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getListUserTopicsMethod = MessengerServiceGrpc.getListUserTopicsMethod) == null) {
          MessengerServiceGrpc.getListUserTopicsMethod = getListUserTopicsMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.Username, se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserTopics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.Username.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.TopicList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("ListUserTopics"))
              .build();
        }
      }
    }
    return getListUserTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Topic,
      se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> getListSubscribersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubscribers",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.Topic.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Topic,
      se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> getListSubscribersMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Topic, se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> getListSubscribersMethod;
    if ((getListSubscribersMethod = MessengerServiceGrpc.getListSubscribersMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getListSubscribersMethod = MessengerServiceGrpc.getListSubscribersMethod) == null) {
          MessengerServiceGrpc.getListSubscribersMethod = getListSubscribersMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.Topic, se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubscribers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.Topic.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("ListSubscribers"))
              .build();
        }
      }
    }
    return getListSubscribersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Username,
      se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> getListUserMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserMessages",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.Username.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Username,
      se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> getListUserMessagesMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Username, se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> getListUserMessagesMethod;
    if ((getListUserMessagesMethod = MessengerServiceGrpc.getListUserMessagesMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getListUserMessagesMethod = MessengerServiceGrpc.getListUserMessagesMethod) == null) {
          MessengerServiceGrpc.getListUserMessagesMethod = getListUserMessagesMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.Username, se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.Username.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("ListUserMessages"))
              .build();
        }
      }
    }
    return getListUserMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Topic,
      se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> getListTopicMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTopicMessages",
      requestType = se.umu.cs.ads.a1.grpc.MessengerProto.Topic.class,
      responseType = se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Topic,
      se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> getListTopicMessagesMethod() {
    io.grpc.MethodDescriptor<se.umu.cs.ads.a1.grpc.MessengerProto.Topic, se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> getListTopicMessagesMethod;
    if ((getListTopicMessagesMethod = MessengerServiceGrpc.getListTopicMessagesMethod) == null) {
      synchronized (MessengerServiceGrpc.class) {
        if ((getListTopicMessagesMethod = MessengerServiceGrpc.getListTopicMessagesMethod) == null) {
          MessengerServiceGrpc.getListTopicMessagesMethod = getListTopicMessagesMethod =
              io.grpc.MethodDescriptor.<se.umu.cs.ads.a1.grpc.MessengerProto.Topic, se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTopicMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.Topic.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList.getDefaultInstance()))
              .setSchemaDescriptor(new MessengerServiceMethodDescriptorSupplier("ListTopicMessages"))
              .build();
        }
      }
    }
    return getListTopicMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessengerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessengerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessengerServiceStub>() {
        @java.lang.Override
        public MessengerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessengerServiceStub(channel, callOptions);
        }
      };
    return MessengerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessengerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessengerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessengerServiceBlockingStub>() {
        @java.lang.Override
        public MessengerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessengerServiceBlockingStub(channel, callOptions);
        }
      };
    return MessengerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessengerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessengerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessengerServiceFutureStub>() {
        @java.lang.Override
        public MessengerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessengerServiceFutureStub(channel, callOptions);
        }
      };
    return MessengerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void store(se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStoreMethod(), responseObserver);
    }

    /**
     */
    default void retrieve(se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetrieveMethod(), responseObserver);
    }

    /**
     */
    default void delete(se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    default void subscribe(se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    default void unsubscribe(se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnsubscribeMethod(), responseObserver);
    }

    /**
     */
    default void listUsers(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUsersMethod(), responseObserver);
    }

    /**
     */
    default void listTopics(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTopicsMethod(), responseObserver);
    }

    /**
     */
    default void listUserTopics(se.umu.cs.ads.a1.grpc.MessengerProto.Username request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUserTopicsMethod(), responseObserver);
    }

    /**
     */
    default void listSubscribers(se.umu.cs.ads.a1.grpc.MessengerProto.Topic request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSubscribersMethod(), responseObserver);
    }

    /**
     */
    default void listUserMessages(se.umu.cs.ads.a1.grpc.MessengerProto.Username request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUserMessagesMethod(), responseObserver);
    }

    /**
     */
    default void listTopicMessages(se.umu.cs.ads.a1.grpc.MessengerProto.Topic request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTopicMessagesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MessengerService.
   */
  public static abstract class MessengerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MessengerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MessengerService.
   */
  public static final class MessengerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MessengerServiceStub> {
    private MessengerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessengerServiceStub(channel, callOptions);
    }

    /**
     */
    public void store(se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void retrieve(se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribe(se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUsers(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listTopics(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUserTopics(se.umu.cs.ads.a1.grpc.MessengerProto.Username request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listSubscribers(se.umu.cs.ads.a1.grpc.MessengerProto.Topic request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubscribersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUserMessages(se.umu.cs.ads.a1.grpc.MessengerProto.Username request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listTopicMessages(se.umu.cs.ads.a1.grpc.MessengerProto.Topic request,
        io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTopicMessagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MessengerService.
   */
  public static final class MessengerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MessengerServiceBlockingStub> {
    private MessengerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessengerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty store(se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse retrieve(se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty delete(se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.TopicList subscribe(se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.TopicList unsubscribe(se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList listUsers(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.TopicList listTopics(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicsMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.TopicList listUserTopics(se.umu.cs.ads.a1.grpc.MessengerProto.Username request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserTopicsMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList listSubscribers(se.umu.cs.ads.a1.grpc.MessengerProto.Topic request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscribersMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList listUserMessages(se.umu.cs.ads.a1.grpc.MessengerProto.Username request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList listTopicMessages(se.umu.cs.ads.a1.grpc.MessengerProto.Topic request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MessengerService.
   */
  public static final class MessengerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MessengerServiceFutureStub> {
    private MessengerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessengerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessengerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> store(
        se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse> retrieve(
        se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> delete(
        se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> subscribe(
        se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> unsubscribe(
        se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> listUsers(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> listTopics(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTopicsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList> listUserTopics(
        se.umu.cs.ads.a1.grpc.MessengerProto.Username request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserTopicsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList> listSubscribers(
        se.umu.cs.ads.a1.grpc.MessengerProto.Topic request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubscribersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> listUserMessages(
        se.umu.cs.ads.a1.grpc.MessengerProto.Username request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserMessagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList> listTopicMessages(
        se.umu.cs.ads.a1.grpc.MessengerProto.Topic request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTopicMessagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STORE = 0;
  private static final int METHODID_RETRIEVE = 1;
  private static final int METHODID_DELETE = 2;
  private static final int METHODID_SUBSCRIBE = 3;
  private static final int METHODID_UNSUBSCRIBE = 4;
  private static final int METHODID_LIST_USERS = 5;
  private static final int METHODID_LIST_TOPICS = 6;
  private static final int METHODID_LIST_USER_TOPICS = 7;
  private static final int METHODID_LIST_SUBSCRIBERS = 8;
  private static final int METHODID_LIST_USER_MESSAGES = 9;
  private static final int METHODID_LIST_TOPIC_MESSAGES = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STORE:
          serviceImpl.store((se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RETRIEVE:
          serviceImpl.retrieve((se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>) responseObserver);
          break;
        case METHODID_LIST_USERS:
          serviceImpl.listUsers((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList>) responseObserver);
          break;
        case METHODID_LIST_TOPICS:
          serviceImpl.listTopics((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>) responseObserver);
          break;
        case METHODID_LIST_USER_TOPICS:
          serviceImpl.listUserTopics((se.umu.cs.ads.a1.grpc.MessengerProto.Username) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>) responseObserver);
          break;
        case METHODID_LIST_SUBSCRIBERS:
          serviceImpl.listSubscribers((se.umu.cs.ads.a1.grpc.MessengerProto.Topic) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList>) responseObserver);
          break;
        case METHODID_LIST_USER_MESSAGES:
          serviceImpl.listUserMessages((se.umu.cs.ads.a1.grpc.MessengerProto.Username) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList>) responseObserver);
          break;
        case METHODID_LIST_TOPIC_MESSAGES:
          serviceImpl.listTopicMessages((se.umu.cs.ads.a1.grpc.MessengerProto.Topic) request,
              (io.grpc.stub.StreamObserver<se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.StoreRequest,
              com.google.protobuf.Empty>(
                service, METHODID_STORE)))
        .addMethod(
          getRetrieveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveRequest,
              se.umu.cs.ads.a1.grpc.MessengerProto.RetrieveResponse>(
                service, METHODID_RETRIEVE)))
        .addMethod(
          getDeleteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.DeleteRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE)))
        .addMethod(
          getSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest,
              se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>(
                service, METHODID_SUBSCRIBE)))
        .addMethod(
          getUnsubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.SubscriptionRequest,
              se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>(
                service, METHODID_UNSUBSCRIBE)))
        .addMethod(
          getListUsersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList>(
                service, METHODID_LIST_USERS)))
        .addMethod(
          getListTopicsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>(
                service, METHODID_LIST_TOPICS)))
        .addMethod(
          getListUserTopicsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.Username,
              se.umu.cs.ads.a1.grpc.MessengerProto.TopicList>(
                service, METHODID_LIST_USER_TOPICS)))
        .addMethod(
          getListSubscribersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.Topic,
              se.umu.cs.ads.a1.grpc.MessengerProto.UsernameList>(
                service, METHODID_LIST_SUBSCRIBERS)))
        .addMethod(
          getListUserMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.Username,
              se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList>(
                service, METHODID_LIST_USER_MESSAGES)))
        .addMethod(
          getListTopicMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              se.umu.cs.ads.a1.grpc.MessengerProto.Topic,
              se.umu.cs.ads.a1.grpc.MessengerProto.MessageIdList>(
                service, METHODID_LIST_TOPIC_MESSAGES)))
        .build();
  }

  private static abstract class MessengerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessengerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return se.umu.cs.ads.a1.grpc.MessengerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessengerService");
    }
  }

  private static final class MessengerServiceFileDescriptorSupplier
      extends MessengerServiceBaseDescriptorSupplier {
    MessengerServiceFileDescriptorSupplier() {}
  }

  private static final class MessengerServiceMethodDescriptorSupplier
      extends MessengerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MessengerServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessengerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessengerServiceFileDescriptorSupplier())
              .addMethod(getStoreMethod())
              .addMethod(getRetrieveMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getSubscribeMethod())
              .addMethod(getUnsubscribeMethod())
              .addMethod(getListUsersMethod())
              .addMethod(getListTopicsMethod())
              .addMethod(getListUserTopicsMethod())
              .addMethod(getListSubscribersMethod())
              .addMethod(getListUserMessagesMethod())
              .addMethod(getListTopicMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
