package com.proto.greet;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: prime/prime.proto")
public final class PrimeNumberGrpc {

  private PrimeNumberGrpc() {}

  public static final String SERVICE_NAME = "greet.PrimeNumber";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.greet.PrimeNumberRequest,
      com.proto.greet.PrimeNumberMultipleResponse> getPrimeNumberDecompositionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "primeNumberDecomposition",
      requestType = com.proto.greet.PrimeNumberRequest.class,
      responseType = com.proto.greet.PrimeNumberMultipleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.greet.PrimeNumberRequest,
      com.proto.greet.PrimeNumberMultipleResponse> getPrimeNumberDecompositionMethod() {
    io.grpc.MethodDescriptor<com.proto.greet.PrimeNumberRequest, com.proto.greet.PrimeNumberMultipleResponse> getPrimeNumberDecompositionMethod;
    if ((getPrimeNumberDecompositionMethod = PrimeNumberGrpc.getPrimeNumberDecompositionMethod) == null) {
      synchronized (PrimeNumberGrpc.class) {
        if ((getPrimeNumberDecompositionMethod = PrimeNumberGrpc.getPrimeNumberDecompositionMethod) == null) {
          PrimeNumberGrpc.getPrimeNumberDecompositionMethod = getPrimeNumberDecompositionMethod =
              io.grpc.MethodDescriptor.<com.proto.greet.PrimeNumberRequest, com.proto.greet.PrimeNumberMultipleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "primeNumberDecomposition"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.greet.PrimeNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.greet.PrimeNumberMultipleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrimeNumberMethodDescriptorSupplier("primeNumberDecomposition"))
              .build();
        }
      }
    }
    return getPrimeNumberDecompositionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrimeNumberStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimeNumberStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimeNumberStub>() {
        @java.lang.Override
        public PrimeNumberStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimeNumberStub(channel, callOptions);
        }
      };
    return PrimeNumberStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrimeNumberBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimeNumberBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimeNumberBlockingStub>() {
        @java.lang.Override
        public PrimeNumberBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimeNumberBlockingStub(channel, callOptions);
        }
      };
    return PrimeNumberBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrimeNumberFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimeNumberFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimeNumberFutureStub>() {
        @java.lang.Override
        public PrimeNumberFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimeNumberFutureStub(channel, callOptions);
        }
      };
    return PrimeNumberFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PrimeNumberImplBase implements io.grpc.BindableService {

    /**
     */
    public void primeNumberDecomposition(com.proto.greet.PrimeNumberRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.PrimeNumberMultipleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrimeNumberDecompositionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPrimeNumberDecompositionMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.greet.PrimeNumberRequest,
                com.proto.greet.PrimeNumberMultipleResponse>(
                  this, METHODID_PRIME_NUMBER_DECOMPOSITION)))
          .build();
    }
  }

  /**
   */
  public static final class PrimeNumberStub extends io.grpc.stub.AbstractAsyncStub<PrimeNumberStub> {
    private PrimeNumberStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeNumberStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimeNumberStub(channel, callOptions);
    }

    /**
     */
    public void primeNumberDecomposition(com.proto.greet.PrimeNumberRequest request,
        io.grpc.stub.StreamObserver<com.proto.greet.PrimeNumberMultipleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getPrimeNumberDecompositionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PrimeNumberBlockingStub extends io.grpc.stub.AbstractBlockingStub<PrimeNumberBlockingStub> {
    private PrimeNumberBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeNumberBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimeNumberBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.greet.PrimeNumberMultipleResponse> primeNumberDecomposition(
        com.proto.greet.PrimeNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getPrimeNumberDecompositionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrimeNumberFutureStub extends io.grpc.stub.AbstractFutureStub<PrimeNumberFutureStub> {
    private PrimeNumberFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeNumberFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimeNumberFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_PRIME_NUMBER_DECOMPOSITION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrimeNumberImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrimeNumberImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRIME_NUMBER_DECOMPOSITION:
          serviceImpl.primeNumberDecomposition((com.proto.greet.PrimeNumberRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.greet.PrimeNumberMultipleResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrimeNumberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrimeNumberBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.greet.Prime.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrimeNumber");
    }
  }

  private static final class PrimeNumberFileDescriptorSupplier
      extends PrimeNumberBaseDescriptorSupplier {
    PrimeNumberFileDescriptorSupplier() {}
  }

  private static final class PrimeNumberMethodDescriptorSupplier
      extends PrimeNumberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrimeNumberMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrimeNumberGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrimeNumberFileDescriptorSupplier())
              .addMethod(getPrimeNumberDecompositionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
