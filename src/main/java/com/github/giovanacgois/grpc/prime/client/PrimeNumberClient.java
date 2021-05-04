package com.github.giovanacgois.grpc.prime.client;

import com.github.giovanacgois.grpc.prime.server.PrimeNumberServiceImpl;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.PrimeNumberGrpc;
import com.proto.greet.PrimeNumberRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class PrimeNumberClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Cliente iniciado");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        PrimeNumberGrpc.PrimeNumberBlockingStub primeNumberClient = PrimeNumberGrpc.newBlockingStub(channel);

        PrimeNumberRequest primeNumberRequest = PrimeNumberRequest.newBuilder()
                .setNumber(120)
                .build();

        primeNumberClient.primeNumberDecomposition(primeNumberRequest)
                .forEachRemaining(primeNumberMultipleResponse -> {
                    System.out.println(primeNumberMultipleResponse.getNumber());
                });

        System.out.println("Desligando!");
        channel.shutdown();
    }
}
