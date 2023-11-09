import io.grpc.stub.StreamObserver;


public class MathServiceImpl extends MathServiceGrpc.MathServiceImplBase {
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
