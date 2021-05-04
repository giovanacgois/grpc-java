package com.github.giovanacgois.grpc.calculator.client;

import com.github.giovanacgois.grpc.greeting.client.GreetingClient;
import com.proto.calculator.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class CalculatorClient {

    public static void main(String[] args) {
        System.out.println("Iniciando o cliente gRPC... =)");

        CalculatorClient calculatorClient = new CalculatorClient();
        calculatorClient.run();
    }

    private void run() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        //doUnaryCall(channel);
        //doClientStreamingCall(channel);
        //doBiDiStreamingCall(channel);
        doErrorCAll(channel);

        System.out.println("Desligando o canal.");
        channel.shutdown();
    }

    private void doUnaryCall(ManagedChannel channel) {
        System.out.println("Criando stub...");
        CalculatorServiceGrpc.CalculatorServiceBlockingStub calculatorClient = CalculatorServiceGrpc.newBlockingStub(channel);

        Calculator calculator = Calculator.newBuilder()
                .setFirstNumber(3)
                .setLastNumber(10)
                .build();

        CalculatorRequest request = CalculatorRequest.newBuilder()
                .setCalculator(calculator)
                .build();

        CalculatorResponse response = calculatorClient.calculator(request);

        System.out.println("A soma dos números " +
                request.getCalculator().getFirstNumber() + " e " +
                request.getCalculator().getLastNumber() + " é: " +
                response.getResult());

    }

    private void doClientStreamingCall(ManagedChannel channel) {

        //Criamos um cliente assíncrono
        CalculatorServiceGrpc.CalculatorServiceStub asyncClient = CalculatorServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<ComputeAverageRequest> requestObserver = asyncClient.computeAverage(new StreamObserver<ComputeAverageResponse>() {
            @Override
            public void onNext(ComputeAverageResponse value) {
                // Quando recebemos uma resposta do Servidor
                System.out.println("Recebi resposta do servidor:");
                System.out.println(value.getAverageComputed());
            }

            @Override
            public void onError(Throwable t) {
                //Quando receber um erro...
            }

            @Override
            public void onCompleted() {
                System.out.println("Servidor terminou de enviar mensagens com sucesso.");
                latch.countDown();
            }
        });


        // Enviando múltiplos números para média...
        for (int i = 0; i < 10000; i++) {
            requestObserver.onNext(ComputeAverageRequest.newBuilder()
                    .setNumber(i)
                    .build());

        }

        //Informamos ao Servidor que o cliente já pode receber a resposta.
        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doBiDiStreamingCall(ManagedChannel channel) {
        CalculatorServiceGrpc.CalculatorServiceStub asynClient = CalculatorServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<FindMaximumRequest> requestObserver = asynClient.findMaximum(new StreamObserver<FindMaximumResponse>() {
            @Override
            public void onNext(FindMaximumResponse value) {
                System.out.println("Resposta do Servidor: " + value.getMaximo());
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

        // Envio das mensagens para o servidor:
        Arrays.asList(1L, 5L, 3L, 6L, 2L, 20L).forEach(number -> {
            System.out.println("Enviando número: " + number);
            requestObserver.onNext(FindMaximumRequest.newBuilder()
                    .setNumber(number)
                    .build());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doErrorCAll(ManagedChannel channel) {
        CalculatorServiceGrpc.CalculatorServiceBlockingStub blockingStub = CalculatorServiceGrpc.newBlockingStub(channel);

        try {
            blockingStub.squareRoot(SquareRootRequest.newBuilder()
                    .setNumber(-1)
                    .build());
        } catch (StatusRuntimeException e) {
            System.out.println("Recebi uma exceção para raíz quadrada.");
            e.printStackTrace();
        }
    }
}
