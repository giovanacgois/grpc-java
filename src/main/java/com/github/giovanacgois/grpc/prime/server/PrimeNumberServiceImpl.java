package com.github.giovanacgois.grpc.prime.server;

import com.proto.greet.PrimeNumberGrpc;
import com.proto.greet.PrimeNumberMultipleResponse;
import com.proto.greet.PrimeNumberRequest;
import io.grpc.stub.StreamObserver;

public class PrimeNumberServiceImpl extends PrimeNumberGrpc.PrimeNumberImplBase {

    @Override
    public void primeNumberDecomposition(PrimeNumberRequest request, StreamObserver<PrimeNumberMultipleResponse> responseObserver) {
        int divisor = 2;
        int number = request.getNumber();

        while (number > 1) {
            if (number % divisor == 0) {
                number = number / divisor;
                responseObserver.onNext(PrimeNumberMultipleResponse.newBuilder()
                        .setNumber(divisor)
                        .build());
            } else {
                divisor = divisor +1;
            }
        }
        responseObserver.onCompleted();
    }
}
