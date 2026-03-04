/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 3
 *
 * Exercise 1: reading the code of a simple Java program.
 *
 * @author: J.-F. Grailet
 */

public class CoordinatesTest
{
    public static void main(String[] args)
    {
        Coordinates a = new Coordinates(1, 2);
        //Coordinates b = a;
        Coordinates b = new Coordinates(a.getX(),a.getY());
        
        a.translate(3, 4);
        
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
