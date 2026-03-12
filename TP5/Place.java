import java.util.Objects;
public abstract class Place {

    private final String name;
    private final int    area; 
    private final int    population;

    protected Place(String name, int area, int population) {
        this.name        = Objects.requireNonNull(name);
        this.area        = area;
        this.population  = population;
    }

    public String getName()               { return name; }

    public float getPopDensity() {
        return area == 0 ? 0f : (float) population / area;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[name=" + name +
                ", area=" + area +
                ", population=" + population +
                ", density=" + String.format("%.2f", getPopDensity()) + "]";
    }
}
