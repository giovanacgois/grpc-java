package com.github.giovanacgois.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.File;
import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Oi! Eu sou um servidor gRPC. =)");

        // Servidor sem SSL - plaintext server
//        Server server = ServerBuilder.forPort(50051)
//                .addService(new GreetServiceImpl())
//                .build();
//        server.start();

        // Servidor seguro
        Server server = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImpl())
                .addService(ProtoReflectionService.newInstance()) //reflection
                .useTransportSecurity(
                        new File("ssl/server.crt"),
                        new File("ssl/server.pem"))
                .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Recebi request para desligar.");
            //desliga o servidor
            server.shutdown();
            System.out.println("Servidor parado com sucesso.");
        }));

        // se não fizermos isso, o servidor starta e o programa termina
        // isso bloqueia para a thread do main
        // após o server.shutdown, esse passo é completado e o programa parado.
        server.awaitTermination();


    }
}
