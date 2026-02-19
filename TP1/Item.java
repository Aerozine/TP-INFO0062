/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 1
 *
 * Exercise 2: review of a small program.
 *
 * @author: J.-F. Grailet
 */

public class Item
{
    private String label;
    private int quantity;
    private float unitPrice;
    
    public Item(String l, int q, float p)
    {
        label = l;
        quantity = q;
        unitPrice = p;
    }
    
    public void setQuantity(int q)
    {
        quantity = q;
    }
    
    public float getTotalPrice()
    {
        return quantity * unitPrice;
    }
    
    public String toString()
    {
        return label + " (unit: " + unitPrice + " EUR) X " + quantity;
    }
}
