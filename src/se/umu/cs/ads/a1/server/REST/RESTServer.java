package se.umu.cs.ads.a1.server.REST;

import org.restlet.Component;
import org.restlet.data.Protocol;;

/**
 * Standalone REST server.
 * Launches the REST application on HTTP port 8000
 * and starts listening for incoming requests.
 */
public class RESTServer {
    public static void main(String[] args) throws Exception {
        int port = 8000;
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, port);
        component.getDefaultHost().attach(new RESTApp());
        component.start();
        System.out.println("[RESTlet] listening on http://localhost:" + port);
    }
}
