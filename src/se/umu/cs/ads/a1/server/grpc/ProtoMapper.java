package se.umu.cs.ads.a1.server.grpc;

import java.util.List;

import com.google.protobuf.ByteString;
import se.umu.cs.ads.a1.types.*;
import se.umu.cs.ads.a1.grpc.MessengerProto;

public final class ProtoMapper {
    private ProtoMapper () {}

    public static MessengerProto.Message toProto(Message message) {
        MessengerProto.Message.Builder builder = MessengerProto.Message.newBuilder()
            .setId(message.getId().getValue())
            .setTimestamp(message.getTimestamp().getValue())
            .setUsername(message.getUsername().getValue())
            .setTopic(message.getTopic().toString())
            .setContent(message.getContent().getValue());

        if (message.getData() != null) {
            builder.setData(ByteString.copyFrom(message.getData().getValue()));
        }
        return builder.build();
    }

    public static MessengerProto.MessageId toProto(MessageId messageId) {
        return MessengerProto.MessageId.newBuilder()
            .setId(messageId.getValue())
            .build();
    }

    public static MessengerProto.Username toProto(Username username) {
        return MessengerProto.Username.newBuilder()
            .setValue(username.getValue())
            .build();
    }

    public static MessengerProto.Topic toProto(Topic topic) {
        return MessengerProto.Topic.newBuilder()
            .setValue(topic.toString())
            .build();
    }

    public static MessengerProto.RetrieveResponse toProto(Message[] messages) {
        MessengerProto.RetrieveResponse.Builder builder = MessengerProto.RetrieveResponse.newBuilder();
        if (messages != null) {
            for (Message message : messages) builder.addMessages(toProto(message));
        }
        return builder.build();
    }

    public static MessengerProto.TopicList toProtoTopics(Topic[] topics) {
        MessengerProto.TopicList.Builder builder = MessengerProto.TopicList.newBuilder();
        if (topics != null) {
            for (Topic topic : topics) builder.addTopics(toProto(topic));
        }
        return builder.build();
    }

    public static MessengerProto.UsernameList toProtoUsers(Username[] users) {
        MessengerProto.UsernameList.Builder builder = MessengerProto.UsernameList.newBuilder();
        if (users != null) {
            for (Username user : users) builder.addUsers(toProto(user));
        }
        return builder.build();
    }

    public static MessengerProto.MessageIdList toProtoMessageIds(MessageId[] messageIds) {
        MessengerProto.MessageIdList.Builder builder = MessengerProto.MessageIdList.newBuilder();
        if (messageIds != null) {
            for (MessageId messageId : messageIds) builder.addIds(toProto(messageId));
        }
        return builder.build();
    }

    public static Message toDomain(MessengerProto.Message protoMessage) {
        return new Message(
            new MessageId(protoMessage.getId()),
            new Timestamp(protoMessage.getTimestamp()),
            new Username(protoMessage.getUsername()),
            new Topic(protoMessage.getTopic()),
            new Content(protoMessage.getContent()),
            new Data(protoMessage.getData().toByteArray())
        );
    }

    public static Message[] toDomainMessages(List<MessengerProto.Message> messageList) {
        Message[] messages = new Message[messageList.size()];
        for (int i = 0; i < messageList.size(); i++) messages[i] = toDomain(messageList.get(i));
        return messages;
    }

    public static MessageId toDomain(MessengerProto.MessageId protoMessageId) {
        return new MessageId(protoMessageId.getId());
    }

    public static MessageId[] toDomainMessageIds(List<MessengerProto.MessageId> messageIdList) {
        MessageId[] messageIds = new MessageId[messageIdList.size()];
        for (int i = 0; i < messageIdList.size(); i++) messageIds[i] = toDomain(messageIdList.get(i));
        return messageIds;
    }

    public static Username toDomain(MessengerProto.Username protoUsername) {
        return new Username(protoUsername.getValue());
    }

    public static Topic toDomain(MessengerProto.Topic protoTopic) {
        return new Topic(protoTopic.getValue());
    }
}
