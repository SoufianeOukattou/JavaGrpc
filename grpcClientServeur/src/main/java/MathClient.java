import java.util.Scanner;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MathClient {
    private final ManagedChannel channel;
    private final MathServiceGrpc.MathServiceBlockingStub blockingStub;

    public MathClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()  // Insecure channel, for testing only
            .build();

        blockingStub = MathServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() {
        channel.shutdown();
    }

    public void testFactorial(int number) {
        FactorialRequest request = FactorialRequest.newBuilder()
            .setNumber(number)
            .build();

        FactorialResponse response = blockingStub.calculateFactorial(request);

        System.out.println("Factorial of " + number + " is: " + response.getResult());
    }

    public void testPower(int base, int exponent) {
        PowerRequest request = PowerRequest.newBuilder()
            .setBase(base)
            .setExponent(exponent)
            .build();

        PowerResponse response = blockingStub.calculatePower(request);

        System.out.println(base + " raised to the power of " + exponent + " is: " + response.getResult());
    }

    public static void main(String[] args) {
        MathClient client = new MathClient("localhost", 50051);  // Replace with your server host and port

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to calculate its factorial: ");
        int factorialNumber = scanner.nextInt();
        client.testFactorial(factorialNumber);

        System.out.print("Enter the base number for the power operation: ");
        int base = scanner.nextInt();
        
        System.out.print("Enter the exponent for the power operation: ");
        int exponent = scanner.nextInt();
        client.testPower(base, exponent);

        client.shutdown();
    }
}
