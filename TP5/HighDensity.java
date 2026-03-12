import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HighDensity {

    public static Location getHighDensityLocation(String filename)
            throws FileNotFoundException, InvalidFormatException {

        Scanner sc = null;
        Location maxLocation = null;
        int lineNumber = 0;

        try {

            sc = new Scanner(new File(filename));

            while (sc.hasNextLine()) {

                lineNumber++;
                String line = sc.nextLine();
                String[] parts = line.split(";");

                int type;

                if(!parts[0].matches("\\d+")) {
                    throw new InvalidFormatException(
                        "Invalid type at line " + lineNumber
                    );
                }

                type = Integer.parseInt(parts[0]);

                if(type != 1 && type != 2) {
                    throw new InvalidFormatException(
                        "Type must be 1 or 2 at line " + lineNumber
                    );
                }

                if(!parts[2].matches("\\d+") || !parts[3].matches("\\d+")) {
                    throw new InvalidFormatException(
                        "Area or population must contain only digits at line " + lineNumber
                    );
                }

                int area = Integer.parseInt(parts[2]);
                int population = Integer.parseInt(parts[3]);

                if(type == 1) {

                    if(!parts[4].matches("\\+\\d+")) {
                        throw new InvalidFormatException(
                            "Invalid calling code at line " + lineNumber
                        );
                    }

                    int code = Integer.parseInt(parts[4].substring(1));

                    Country country =
                        new Country(parts[1], area, population, code);

                    if(maxLocation == null ||
                       country.getPopDensity() > maxLocation.getPopDensity()) {
                        maxLocation = country;
                    }

                }

                else if(type == 2) {

                    City city =
                        new City(parts[1], area, population, parts[4]);

                    if(maxLocation == null ||
                       city.getPopDensity() > maxLocation.getPopDensity()) {
                        maxLocation = city;
                    }
                }

            }

        } finally {

            if(sc != null) {
                sc.close();
            }
        }

        return maxLocation;
    }

    public static void main(String args[]) {

        try {

            Location loc = getHighDensityLocation(args[0]);
            System.out.println("Highest density location: " + loc);

        }

        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        catch(InvalidFormatException e) {
            System.out.println(e.getMessage());
        }

    }
}
