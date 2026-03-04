import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Walter {

    public static void main(String args[]) throws IOException {
        Boolean running = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (running) {
            System.out.println("Say my name !");
            String answer = br.readLine();
            if (answer == "Heisenberg") running = false;
         }

        System.out.println("You're goddamn right !");
    }

}
