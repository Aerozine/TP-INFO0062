/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 1
 *
 * Exercise 2: review of a small program.
 *
 * Remark: items are stored in a "Vector". Vector is a class from the Java library which is 
 * designed to store collections of objects. Its interface can be reviewed online in the official 
 * Java documentation.
 *
 * @author: J.-F. Grailet
 */

import java.util.Vector;

public class Groceries
{
    private Vector<Item> items;
    
    public Groceries()
    {
        items = new Vector<Item>();
    }
    
    public void insert(Item content)
    {
        items.add(content);
    }
    
    public String toString()
    {
        String res = "";
        float finalPrice = 0.0f;
        for(int i = 0; i < items.size(); i++)
        {
            float curPrice = items.get(i).getTotalPrice();
            res += items.get(i).toString();
            res += " = " + curPrice + " EUR\n";
            finalPrice += curPrice;
        }
        res += "Total cost: " + finalPrice + " EUR";
        return res;
    }
}
