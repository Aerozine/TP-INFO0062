import java.util.HashMap;

public class City extends Location {

    private Country country;

    private static HashMap<String, Country> countries = new HashMap<>();

    public City(String name, int area, int population, String countryName) {

        super(name, area, population);

        if(countries.containsKey(countryName)) {
            this.country = countries.get(countryName);
        } else {
            Country newCountry = new Country(countryName);
            countries.put(countryName, newCountry);
            this.country = newCountry;
        }
    }

    public Country getCountry() {
        return country;
    }
}
