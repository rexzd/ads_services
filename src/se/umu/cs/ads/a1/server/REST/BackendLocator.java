package se.umu.cs.ads.a1.server.REST;

import se.umu.cs.ads.a1.backend.InMemoryMessengerBackEnd;
import se.umu.cs.ads.a1.interfaces.Messenger;

public class BackendLocator {
    private static final Messenger BACKEND = new InMemoryMessengerBackEnd();
    private BackendLocator() {}
    
    public static Messenger getMessenger() {
        return BACKEND;
    }
}
