package com.github.giovanacgois.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.*;
import io.grpc.*;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.net.ssl.SSLException;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {


    public static void main(String[] args) throws SSLException {
        System.out.println("Olá! Eu sou um cliente gRPC. =) ");

        GreetingClient main = new GreetingClient();
        main.run();

    }

    private void run() throws SSLException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() // força o SSL a ficar ativo durante o desenvolvimento - não usar em prod!
                .build();

        // Comunicação com servidor via SSL/TLS;
        ManagedChannel secureChannel = NettyChannelBuilder.forAddress("localhost", 50051)
                .sslContext(GrpcSslContexts.forClient().trustManager(new File("ssl/ca.crt")).build())
                .build();

        //doUnaryCall(channel);
        //doServerStreamingCall(channel);
        //doClientStreamingCall(channel);
        //doBiDiStreamingCall(channel);
        //doUnaryCallWithDeadline(channel);
        doUnaryCall(secureChannel);

        // Desliga o canal
        System.out.println("Desligando o canal");
        channel.shutdown();
    }

    private void doUnaryCall(ManagedChannel channel) {
        System.out.println("Criando Stub");

        // Cria um cliente GreetService (bloqueante - síncrono)
        GreetServiceGrpc.GreetServiceBlockingStub greetingClient = GreetServiceGrpc.newBlockingStub(channel);

        // Cria um protocol buffer da mensagem
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Giovana")
                .setLastName("Gois")
                .build();

        // faz o mesmo para GreetRequest
        GreetRequest greetRequest = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

        // Chama RPC e pega a referência
        GreetResponse greetResponse = greetingClient.greet(greetRequest);

        // faz alguma coisa aqui
        System.out.println(greetResponse.getResult());
    }

    private void doServerStreamingCall(ManagedChannel channel) {
        // Cria um cliente GreetService (bloqueante - síncrono)
        GreetServiceGrpc.GreetServiceBlockingStub greetingClient = GreetServiceGrpc.newBlockingStub(channel);

        // Preparando a request
        GreetManyTimesRequest greetManyTimesRequest = GreetManyTimesRequest.newBuilder()
                .setGreeting(Greeting.newBuilder().setFirstName("Giovana"))
                .build();

        // Streaming das responses (síncrono/bloqueante)
        greetingClient.greetManyTimes(greetManyTimesRequest)
                .forEachRemaining(greetManyTimesResponse -> {
                    System.out.println(greetManyTimesResponse.getResult());
                });
    }

    private void doClientStreamingCall(ManagedChannel channel) {
        //Cria um cliente assíncrono
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> requestObserver = asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {

            // O que fazemos quando recebos uma resposta do servidor
            @Override
            public void onNext(LongGreetResponse value) {
                System.out.println("Recebi uma resposta do servidor");
                System.out.println(value.getResult());
            }

            // O que fazemos quando um erro do servidor
            @Override
            public void onError(Throwable t) {

            }

            // O que fazemos quando nos manda os dados
            @Override
            public void onCompleted() {
                System.out.println("Servidor terminou de enviar mensagens.");
                latch.countDown();
            }
        });

        // mensagem #1
        System.out.println("Enviando mensagem 1...");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Yoda")
                        .build())
                .build()
        );

        // mensagem #2
        System.out.println("Enviando mensagem 2...");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Luke")
                        .build())
                .build()
        );

        // mensagem #3
        System.out.println("Enviando mensagem 3...");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Leia")
                        .build())
                .build()
        );

        // mensagem #4
        System.out.println("Enviando mensagem 4...");
        requestObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("Chewe")
                        .build())
                .build()
        );

        // Dizemos ao servidor que o cliente já está pronto para receber dados
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doBiDiStreamingCall(ManagedChannel channel) {
        //Cria um cliente assíncrono
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetEveryoneRequest> requestObserver = asyncClient.greetEveryone(new StreamObserver<GreetEveryoneResponse>() {
            @Override
            public void onNext(GreetEveryoneResponse value) {
                // toda vez que recebermos uma resposta, o que faremos?
                System.out.println("Resposta do servidor: " + value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Servidor terminou de enviar os dados.");
                latch.countDown();
            }
        });

        // Envia mensagens para os servidor
        Arrays.asList("Leia", "Luke", "Han", "Rey").forEach(
                name -> {
                    System.out.println("Enviando: " + name);
                    requestObserver.onNext(GreetEveryoneRequest.newBuilder()
                            .setGreeting(Greeting.newBuilder()
                                    .setFirstName(name)
                                    .build())
                            .build());

                    // delay para testar respostas assíncronas
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        // Avisa o servidor que terminamos de enviar os dados
        requestObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doUnaryCallWithDeadline(ManagedChannel channel) {
        GreetServiceGrpc.GreetServiceBlockingStub blockingStub = GreetServiceGrpc.newBlockingStub(channel);

        //primeira chamada (3000ms deadline)
        try {
            System.out.println("Enviando request com deadline de 3000ms");
            GreetWithDeadlineResponse response = blockingStub
                    .withDeadlineAfter(3000, TimeUnit.MILLISECONDS)
                    .greetWithDeadline(GreetWithDeadlineRequest.newBuilder()
                            .setGreeting(Greeting.newBuilder()
                                    .setFirstName("Giovana"))
                            .build());
            System.out.println(response.getResult());
        } catch (StatusRuntimeException e) {
            if (e.getStatus() == Status.DEADLINE_EXCEEDED) {
                System.out.println("Excedeu o deadline, não obteremos resposta.");
            } else {
                e.printStackTrace();
            }
        }

        //primeira chamada (3000ms deadline)
        try {
            System.out.println("Enviando request com deadline de 100ms");
            GreetWithDeadlineResponse response = blockingStub
                    .withDeadlineAfter(100, TimeUnit.MILLISECONDS)
                    .greetWithDeadline(GreetWithDeadlineRequest.newBuilder()
                            .setGreeting(Greeting.newBuilder()
                                    .setFirstName("Giovana"))
                            .build());
            System.out.println(response.getResult());
        } catch (StatusRuntimeException e) {
            if (e.getStatus() == Status.DEADLINE_EXCEEDED) {
                System.out.println("Excedeu o deadline, não obteremos resposta.");
            } else {
                e.printStackTrace();
            }
        }
    }


}
