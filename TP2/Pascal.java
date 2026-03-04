import java.math.BigInteger;
import java.util.Vector;

public class Pascal {
    // We define EXTENSION_LIMIT to be the limit of the extension allowed
    // If the user asks n= 24 and we have n= 20, it will extend the n up to 24.
    // If the user asks n=1000, the program will just compute the coefficient.
    private static final int EXTENSION_LIMIT = 10; // Allowed gap

    // Static field for the triangle (shared by all instances)
    private static Vector<BigInteger[]> triangle;

    // Default constructor
    // Initialize an empty triangle
    public Pascal() {
        if (triangle == null) {
            triangle = new Vector<>();
            BigInteger[] firstRow = new BigInteger[1];
            firstRow[0] = BigInteger.ONE;
            triangle.add(firstRow);
        }
    }

    // Constructor with initial rows
    public Pascal(int n) {
        this();
        if (n > 0) {
            buildUpToRow(n);
        }
    }

    // Returns binomial coefficient C(n, k)
    public BigInteger binomial(int n, int k) {
        // Error of indices
        if (n < 0 || k < 0 || k > n) {
            return BigInteger.ZERO;
        }

        int currentMaxRow = triangle.size() - 1;

        // Case 1: if the result is inside the triangle
        // Thus we just need to return the value
        // .get(n) for the vector to retrieve the array 
        // and [k] to select the k element in the array
        if (n <= currentMaxRow) {
            return triangle.get(n)[k];
        }

        // Case 2: n is close -> extend triangle
        if (n <= currentMaxRow + EXTENSION_LIMIT) {
            buildUpToRow(n);
            return triangle.get(n)[k];
        }

        // Case 3: if too far, just compute it
        return computeDirect(n, k);
    }

    // Builds rows up to n
    private static void buildUpToRow(int n) {
        // To compute a value on the triangle we can use 
        // X Y
        //   Z 
        // Z = X + Y
        for (int i = triangle.size(); i <= n; i++) {
            BigInteger[] previousRow = triangle.get(i - 1);
            BigInteger[] newRow = new BigInteger[i + 1];

            newRow[0] = BigInteger.ONE;
            newRow[i] = BigInteger.ONE;

            for (int j = 1; j < i; j++) {
                newRow[j] = previousRow[j - 1].add(previousRow[j]);
            }

            triangle.add(newRow);
        }
    }

    // Only used for larger values that cannot be computed easily
    private BigInteger computeDirect(int n, int k) {
        // Use symmetry C(n, k) = C(n, n - k)
        if (k > n - k) {
            k = n - k;
        }

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= k; i++) {
            result = result
                    .multiply(BigInteger.valueOf(n - i + 1))
                    .divide(BigInteger.valueOf(i));
        }

        return result;
    }

    // Displays the first n rows
    public void display(int n) {
        if (n <= 0) return;

        buildUpToRow(n - 1);

        for (int i = 0; i < n; i++) {
            for (BigInteger value : triangle.get(i)) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Reset the triangle (if needed)
    public static void resetTriangle() {
        triangle = new Vector<>();
        BigInteger[] firstRow = new BigInteger[1];
        firstRow[0] = BigInteger.ONE;
        triangle.add(firstRow);
    }
}
