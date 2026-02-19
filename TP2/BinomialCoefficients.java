
import java.math.BigInteger;

public class BinomialCoefficients {

    public static void main(String[] args) {

        Pascal pascal = new Pascal();

        // Test single coefficient
        BigInteger result = pascal.binomial(10, 5);
        System.out.println("C(10,5) = " + result);

        // Display first 10 rows
        System.out.println("\nFirst 10 rows of Pascal's Triangle:");
        pascal.display(10);

        // Test large value
        BigInteger large = pascal.binomial(100, 50);
        System.out.println("\nC(100,50) = " + large);
    }
}
