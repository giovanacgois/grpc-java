package com.github.giovanacgois.grpc.prime.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class PrimeNumberServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Servidor iniciado!");

        Server server = ServerBuilder.forPort(50053)
                .addService(new PrimeNumberServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Vou desligar...");
            server.shutdown();
            System.out.println("Servidor parado com sucesso");
        }));

        server.awaitTermination();
    }

}
