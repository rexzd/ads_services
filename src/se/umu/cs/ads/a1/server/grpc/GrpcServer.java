package se.umu.cs.ads.a1.server.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import se.umu.cs.ads.a1.interfaces.Messenger;
import se.umu.cs.ads.a1.server.REST.BackendLocator;

public class GrpcServer {
    public static void main(String[] args) throws Exception {
            int port = (args.length >= 1) ? Integer.parseInt(args[0]) : 9000;
            Messenger backend = BackendLocator.getMessenger(); 
            Server server = ServerBuilder.forPort(port)
                    .maxInboundMessageSize(128 * 1024 * 1024)
                    .addService(new MessengerServiceImpl(backend))
                    .build()
                    .start();
            System.out.println("gRPC server started on port " + port);
            server.awaitTermination();
        }
}
