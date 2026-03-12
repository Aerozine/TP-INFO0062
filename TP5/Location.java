public class Location {

    protected String name;
    protected int area;
    protected int population;

    public Location(String name) {
        this.name = name;
        this.area = -1;
        this.population = -1;
    }

    public Location(String name, int area, int population) {
        this.name = name;
        this.area = area;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public float getPopDensity() {
        if(area <= 0) return 0;
        return (float) population / area;
    }

    public String toString() {
        return name + " density: " + getPopDensity();
    }
}
