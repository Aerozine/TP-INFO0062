public class LineSegment
{
    private Coordinates p1;
    private Coordinates p2;
    
    // Constructor
    public LineSegment(int x1, int y1, int x2, int y2)
    {
        p1 = new Coordinates(x1, y1);
        p2 = new Coordinates(x2, y2);
    }
    
    // Translate the segment
    public void translate(int dx, int dy)
    {
        p1.translate(dx, dy);
        p2.translate(dx, dy);
    }
    
    // Compute length
    public double length()
    {
        int dx = p2.getX() - p1.getX();
        int dy = p2.getY() - p1.getY();
        return Math.hypot(dx, dy);
    }
    
    // String representation
    public String toString()
    {
        return "[" + p1.toString() + ", " + p2.toString() + "]";
    }
}
