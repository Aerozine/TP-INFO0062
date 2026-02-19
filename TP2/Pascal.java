import java.math.BigInteger;
import java.util.Vector;

public class Pascal {
  // we define EXTENSION_LIMIT to be the limit of the extension allowed
  // If the user ask n= 24 and we have n= 20 it will extend the n up to 24
  // if the user ask n=1000 the program will just simply compute the coeficient

    private static final int EXTENSION_LIMIT = 10; // allowed gap
    // Actual structure of the triangle
    // < 
    // [ . ],
    // [ . . ],
    // [ . . . ]
    // >
    // (<> for vector and [] for array)
    // Each line has known size so we can simply use array
    // Due to the fact that we would like to add a line at the end 
    // we cannot consider using array ( the cost to add a value is too high)
    // Insead we can use resizable-Array like Vector
    // And according to the documentation we can use .add and .get 
    private Vector<BigInteger[]> triangle;

    // Default constructor
    // Init an empty triangle
    public Pascal() {
        triangle = new Vector<>();

        BigInteger[] firstRow = new BigInteger[1];
        firstRow[0] = BigInteger.ONE;
        triangle.add(firstRow);
    }

    // Constructor with initial rows
    public Pascal(int n) {
        this();
        if (n > 0) {
            buildUpToRow(n);
        }
    }

    // Returns binomial coefficient C(n,k)
    public BigInteger binomial(int n, int k) {
        // eror of indices
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
        // Case 3: if too far , just compute it
        return computeDirect(n, k);
    }

    // Builds rows up to n
    private void buildUpToRow(int n) {
       // to compute a value on the triangle we can use 
       // X Y
       //   Z 
       //   Z= + X + Y
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

    //only used for larger value that cannot be compute easily
    private BigInteger computeDirect(int n, int k) {

        // Use symmetry C(n,k) = C(n,n-k)
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

    // Displays first n rows
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
}
