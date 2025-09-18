package se.umu.cs.ads.a1.server.REST;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import se.umu.cs.ads.a1.server.REST.resources.TopicResource;
import se.umu.cs.ads.a1.server.REST.resources.TopicsResource;
import se.umu.cs.ads.a1.server.REST.resources.UserMessagesResource;
import se.umu.cs.ads.a1.server.REST.resources.UsersResource;
import se.umu.cs.ads.a1.server.REST.resources.SubscriptionsResource;
import se.umu.cs.ads.a1.server.REST.resources.TopicMessagesResource;
import se.umu.cs.ads.a1.server.REST.resources.MessageBatchResource;
import se.umu.cs.ads.a1.server.REST.resources.MessageCollectionResource;
import se.umu.cs.ads.a1.server.REST.resources.MessageResource;
import se.umu.cs.ads.a1.server.REST.resources.SubscribersResource;
import se.umu.cs.ads.a1.server.REST.resources.MessageBatchRetrieveResource;

public class RESTApp extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/users/{username}/topics", TopicResource.class);
        router.attach("/users/{username}/messages", UserMessagesResource.class);
        router.attach("/topics/{topic*}/subscribers", SubscribersResource.class);
        router.attach("/topics/{topic*}/messages", TopicMessagesResource.class);
        router.attach("/topics", TopicsResource.class);
        router.attach("/users", UsersResource.class);
        router.attach("/subscriptions", SubscriptionsResource.class);
        router.attach("/messages/batch/retrieve", MessageBatchRetrieveResource.class);
        router.attach("/messages/batch", MessageBatchResource.class);
        router.attach("/messages", MessageCollectionResource.class);
        router.attach("/messages/{id}", MessageResource.class);
        return router;
    }
}