package com.github.giovanacgois.grpc.greeting.server;

import com.proto.greet.*;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        // pega os campos necessários
        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();

        // cria a resposta
        String result = "Hello " + firstName;

        GreetResponse response = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        // return response; //não podemos utilizar isso porque o servidor é assíncrono

        // envia a resposta
        responseObserver.onNext(response);

        // completa a chamada RPC
        responseObserver.onCompleted();

        //super.greet(request, responseObserver);
    }

    @Override
    public void greetManyTimes(GreetManyTimesRequest request, StreamObserver<GreetManyTimesResponse> responseObserver) {
        String firstName = request.getGreeting().getFirstName();

        try {
            for (int i = 0; i < 10; i++) {
                String result = ("Hello " + firstName + ", response number: " + i);
                GreetManyTimesResponse response = GreetManyTimesResponse.newBuilder()
                        .setResult(result)
                        .build();

                responseObserver.onNext(response);

                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {
        StreamObserver<LongGreetRequest> requestObserver = new StreamObserver<LongGreetRequest>() {

            String result = "";

            // O que fazer quando recebemos uma nova mensagem
            @Override
            public void onNext(LongGreetRequest value) {
                result += (" Hello " + value.getGreeting().getFirstName() + "! ");
            }

            // O que fazer quando recebemos um erro
            @Override
            public void onError(Throwable t) {

            }

            // O que fazer quando as requests finalizarem
            // quando desejamos retornar uam resposta (responseObserver)
            @Override
            public void onCompleted() {
                responseObserver.onNext(
                        LongGreetResponse.newBuilder()
                                .setResult(result)
                                .build()
                );
                responseObserver.onCompleted();
            }
        };

        return requestObserver;
    }

    @Override
    public StreamObserver<GreetEveryoneRequest> greetEveryone(StreamObserver<GreetEveryoneResponse> responseObserver) {
        StreamObserver<GreetEveryoneRequest> requestObserver = new StreamObserver<GreetEveryoneRequest>() {
            @Override
            public void onNext(GreetEveryoneRequest value) {
                // Quando recebermos uma nova request, vamos retornar uma response.
                // Obs.: Faremos isso neste exemplo, mas não é obrigatório ter uma response para cada request numa API BiDi.

                String result = "Hello, " + value.getGreeting().getFirstName();
                GreetEveryoneResponse greetEveryoneResponse = GreetEveryoneResponse.newBuilder()
                        .setResult(result)
                        .build();

                responseObserver.onNext(greetEveryoneResponse);
            }

            @Override
            public void onError(Throwable t) {
                // to do...
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
        return requestObserver;
    }

    @Override
    public void greetWithDeadline(GreetWithDeadlineRequest request, StreamObserver<GreetWithDeadlineResponse> responseObserver) {
        Context current = Context.current();

        try {
            for (int i = 0; i < 3; i++) {
                if (!current.isCancelled()) { //Informa se o cliente não cancelou a request
                    System.out.println("Thread sleeping por 100ms");
                    Thread.sleep(100);
                } else {
                    return;
                }

            }
            System.out.println("Enviando resposta...");
            responseObserver.onNext(GreetWithDeadlineResponse.newBuilder()
                    .setResult("Hello, " + request.getGreeting().getFirstName())
                    .build());

            responseObserver.onCompleted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
