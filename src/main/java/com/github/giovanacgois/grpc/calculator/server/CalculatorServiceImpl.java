package com.github.giovanacgois.grpc.calculator.server;

import com.proto.calculator.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;


public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void calculator(CalculatorRequest request, StreamObserver<CalculatorResponse> responseObserver) {

        Calculator calculator = request.getCalculator();
        long firstNumber = calculator.getFirstNumber();
        long lastNumber = calculator.getLastNumber();

        CalculatorResponse response = CalculatorResponse.newBuilder()
                .setResult(firstNumber + lastNumber)
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ComputeAverageRequest> computeAverage(StreamObserver<ComputeAverageResponse> responseObserver) {

        StreamObserver<ComputeAverageRequest> requestObserver = new StreamObserver<ComputeAverageRequest>() {

            int sum = 0;
            int count = 0;
            List<Long> numbers = new ArrayList<>();

            @Override
            public void onNext(ComputeAverageRequest value) {
                // quando recebermos uma nova request do servidor
                sum += value.getNumber();
                count++;
            }

            @Override
            public void onError(Throwable t) {
                // quando receber um erro ..
            }

            @Override
            public void onCompleted() {
                // quando terminar de receber requests ..
                double result = ((double) sum / count);

                responseObserver.onNext(
                        ComputeAverageResponse.newBuilder()
                                .setAverageComputed(result)
                                .build()
                );
                responseObserver.onCompleted();
            }
        };
        // retornamos streamObserver porque é síncrono e o cliente manda diversas requests.
        return requestObserver;
    }

    @Override
    public StreamObserver<FindMaximumRequest> findMaximum(StreamObserver<FindMaximumResponse> responseObserver) {
        StreamObserver<FindMaximumRequest> requestObserver = new StreamObserver<FindMaximumRequest>() {

            Long maximo = null;

            @Override
            public void onNext(FindMaximumRequest value) {
                // Quando recebermos uma request...
                if (maximo == null || value.getNumber() > maximo) {
                    maximo = value.getNumber();
                }

                responseObserver.onNext(FindMaximumResponse.newBuilder()
                        .setMaximo(maximo)
                        .build());
            }

            @Override
            public void onError(Throwable t) {
                //to do ...
            }

            @Override
            public void onCompleted() {

                responseObserver.onNext(FindMaximumResponse.newBuilder()
                        .setMaximo(maximo)
                        .build());
                responseObserver.onCompleted();
            }
        };
        return requestObserver;
    }

    @Override
    public void squareRoot(SquareRootRequest request, StreamObserver<SquareRootResponse> responseObserver) {
        Integer number = request.getNumber();

        if (number >= 0) {
            responseObserver.onNext(
                    SquareRootResponse.newBuilder()
                            .setNumberRoot(Math.sqrt(number))
                            .build()
            );
            responseObserver.onCompleted();
        } else {
            // construção da exceção
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("O número enviado não é positivo.")
                            .augmentDescription("Número enviado: " + number) //descrição adicional
                            .asRuntimeException()
            );
        }
    }
}
