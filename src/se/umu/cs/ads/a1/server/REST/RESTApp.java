package se.umu.cs.ads.a1.server.REST;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import se.umu.cs.ads.a1.server.REST.resources.TopicResource;
import se.umu.cs.ads.a1.server.REST.resources.SubscriptionsResource;
import se.umu.cs.ads.a1.server.REST.resources.MessageBatchResource;
import se.umu.cs.ads.a1.server.REST.resources.MessageCollectionResource;
import se.umu.cs.ads.a1.server.REST.resources.MessageResource;

public class RESTApp extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/users/{username}/topics", TopicResource.class);
        router.attach("/subscriptions", SubscriptionsResource.class);
        router.attach("/messages/batch", MessageBatchResource.class);
        router.attach("/messages", MessageCollectionResource.class);
        router.attach("/messages/{id}", MessageResource.class);
        return router;
    }
}