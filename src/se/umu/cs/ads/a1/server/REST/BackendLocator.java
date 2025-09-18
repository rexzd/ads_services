package se.umu.cs.ads.a1.server.REST;

import se.umu.cs.ads.a1.backend.InMemoryMessengerBackEnd;
import se.umu.cs.ads.a1.interfaces.Messenger;

/**
 * Utility class for locating the active backend implementation.
 * Provides a globally accessible Messenger instance backed by an in-memory store.
 */
public class BackendLocator {
    private static final Messenger BACKEND = new InMemoryMessengerBackEnd();
    private BackendLocator() {}
    
    public static Messenger getMessenger() {
        return BACKEND;
    }
}
