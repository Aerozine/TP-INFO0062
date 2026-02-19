/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 1
 *
 * Exercise 2: review of a small program.
 *
 * Remark: constants for float values are suffixed with "f" because they are, usually, interpreted 
 * as double values.
 *
 * @author: J.-F. Grailet
 */

public class GroceriesList
{
    public static void main(String[] args)
    {
        Groceries g = new Groceries();
        
        Item m = new Item("Mineral water", 8, 0.50f);
        Item a = new Item("Apples", 6, 0.40f);
        Item e = new Item("Egg", 6, 0.16f);
        
        g.insert(m);
        g.insert(a);
        g.insert(e);
        e.setQuantity(12);
        

        
        System.out.println(g.toString());
    }
}
