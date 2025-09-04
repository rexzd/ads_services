package se.umu.cs.ads.a1.server.REST;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import se.umu.cs.ads.a1.server.REST.resources.TopicResource;

public class RESTApp extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/{username}/topics", TopicResource.class);
        return router;
}
}
