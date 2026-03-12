public class Country extends Location {

    private final int callingCode;

    public Country(String name) {
        super(name);
        this.callingCode = -1;
    }

    public Country(String name, int area, int population, int callingCode) {
        super(name, area, population);
        this.callingCode = callingCode;
    }

    public String getCallingCode() {
        return "+" + callingCode;
    }
}
