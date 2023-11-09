import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class MathServer {
    private int port = 50051;
    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
            .addService(new MathServiceImpl())
            .build()
            .start();

        System.out.println("Math Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** Shutting down gRPC server since JVM is shutting down");
            MathServer.this.stop();
            System.err.println("*** Server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final MathServer server = new MathServer();
        server.start();
        server.blockUntilShutdown();
    }

    private static class MathServiceImpl extends MathServiceGrpc.MathServiceImplBase {
        @Override
        public void calculateFactorial(FactorialRequest request, StreamObserver<FactorialResponse> responseObserver) {
            int number = request.getNumber();
            long result = calculateFactorial(number);

            FactorialResponse response = FactorialResponse.newBuilder().setResult(result).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void calculatePower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
            int base = request.getBase();
            int exponent = request.getExponent();
            long result = calculatePower(base, exponent);

            PowerResponse response = PowerResponse.newBuilder().setResult(result).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        private long calculateFactorial(int number) {
            if (number < 0) {
                return -1;  // Handle invalid input.
            } else if (number <= 1) {
                return 1;
            } else {
                long result = 1;
                for (int i = 2; i <= number; i++) {
                    result *= i;
                }
                return result;
            }
        }

        private long calculatePower(int base, int exponent) {
            return (long) Math.pow(base, exponent);
        }
    }
}
