package com.github.giovanacgois.grpc.calculator.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatorServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Servidor de cálculos iniciado.");
        Server server = ServerBuilder.forPort(50052)
                .addService(new CalculatorServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Recebi uma ordem para desligar.");
            //desliga o servidor
            server.shutdown();
            System.out.println("Servidor parado com sucesso.");
        }));

        server.awaitTermination();
    }

}
