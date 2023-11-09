import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.1)",
    comments = "Source: math_operations.proto")
public class MathServiceGrpc {

  private MathServiceGrpc() {}

  public static final String SERVICE_NAME = "MathService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<FactorialRequest,
      FactorialResponse> METHOD_CALCULATE_FACTORIAL =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "MathService", "CalculateFactorial"),
          io.grpc.protobuf.ProtoUtils.marshaller(FactorialRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(FactorialResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<PowerRequest,
      PowerResponse> METHOD_CALCULATE_POWER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "MathService", "CalculatePower"),
          io.grpc.protobuf.ProtoUtils.marshaller(PowerRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(PowerResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MathServiceStub newStub(io.grpc.Channel channel) {
    return new MathServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MathServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MathServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static MathServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MathServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MathServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculateFactorial(FactorialRequest request,
        io.grpc.stub.StreamObserver<FactorialResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CALCULATE_FACTORIAL, responseObserver);
    }

    /**
     */
    public void calculatePower(PowerRequest request,
        io.grpc.stub.StreamObserver<PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CALCULATE_POWER, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CALCULATE_FACTORIAL,
            asyncUnaryCall(
              new MethodHandlers<
                FactorialRequest,
                FactorialResponse>(
                  this, METHODID_CALCULATE_FACTORIAL)))
          .addMethod(
            METHOD_CALCULATE_POWER,
            asyncUnaryCall(
              new MethodHandlers<
                PowerRequest,
                PowerResponse>(
                  this, METHODID_CALCULATE_POWER)))
          .build();
    }
  }

  /**
   */
  public static final class MathServiceStub extends io.grpc.stub.AbstractStub<MathServiceStub> {
    private MathServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MathServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MathServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MathServiceStub(channel, callOptions);
    }

    /**
     */
    public void calculateFactorial(FactorialRequest request,
        io.grpc.stub.StreamObserver<FactorialResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_FACTORIAL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void calculatePower(PowerRequest request,
        io.grpc.stub.StreamObserver<PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_POWER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MathServiceBlockingStub extends io.grpc.stub.AbstractStub<MathServiceBlockingStub> {
    private MathServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MathServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MathServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MathServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public FactorialResponse calculateFactorial(FactorialRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CALCULATE_FACTORIAL, getCallOptions(), request);
    }

    /**
     */
    public PowerResponse calculatePower(PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CALCULATE_POWER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MathServiceFutureStub extends io.grpc.stub.AbstractStub<MathServiceFutureStub> {
    private MathServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MathServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MathServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MathServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FactorialResponse> calculateFactorial(
        FactorialRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_FACTORIAL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PowerResponse> calculatePower(
        PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_POWER, getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_FACTORIAL = 0;
  private static final int METHODID_CALCULATE_POWER = 1;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MathServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(MathServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_FACTORIAL:
          serviceImpl.calculateFactorial((FactorialRequest) request,
              (io.grpc.stub.StreamObserver<FactorialResponse>) responseObserver);
          break;
        case METHODID_CALCULATE_POWER:
          serviceImpl.calculatePower((PowerRequest) request,
              (io.grpc.stub.StreamObserver<PowerResponse>) responseObserver);
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

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_CALCULATE_FACTORIAL,
        METHOD_CALCULATE_POWER);
  }

}
