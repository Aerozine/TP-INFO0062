/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 3
 *
 * This Coordinates class involved in all exercises of this series and isn't supposed to be 
 * edited.
 *
 * @author: J.-F. Grailet
 */

public class Coordinates
{
    private int x, y;
    
    public Coordinates()
    {
        x = 0;
        y = 0;
    }
    
    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    public void translate(int dx, int dy)
    {
        x += dx;
        y += dy;
    }
    
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}
