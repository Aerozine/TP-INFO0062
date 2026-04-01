/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 9
 *
 * Exercise 1: reading a code and understanding it w.r.t. cloning and equivalence checking.
 *
 * The BookLog class models a list of books, stored in an ArrayList object (this class is part of 
 * the Java native library).
 *
 * @author: J.-F. Grailet
 */

import java.util.ArrayList;

public class BookLog implements Cloneable
{
    private ArrayList<Book> log;
    
    public BookLog()
    {
        log = new ArrayList<Book>();
    }
    
    public int getLogSize()
    {
        return log.size();
    }
    
    /*
     * Adds a new book to the log, at the end of the list.
     */
    
    public void addBook(Book b)
    {
        log.add(b);
    }
    
    /*
     * Gets a book at a specified index (indexing starts at 1). Returns null if index is out.
     */
    
    public Book getBook(int index)
    {
        if(index <= 0 || index > log.size())
            return null; // We could also throw an exception here, but won't (to simplify)
        return log.get(index - 1);
    }
    
    /*
     * Removes a book at a specified index (indexing starts at 1) and returns it (if it exists).
     */
    
    public Book removeBook(int index)
    {
        if(index <= 0 || index > log.size())
            return null; // Same as above
        return log.remove(index - 1); // remove() from ArrayList returns the removed object
    }
    
    /*
     * Writes the complete log into a single String for display.
     */
    
    public String toString()
    {
        String res = "";
        for(Book b : log) // Simplified way to visit an ArrayList (and other List classes)
        {
            if(res.length() > 0)
                res += "\n";
            res += b.toString();
        }
        return res;
    }
    
    public boolean equals(Object obj)
    {
        if(!(obj instanceof BookLog)) // N.B.: "null instanceof BookLog" is also false
            return false;
        
        BookLog other = (BookLog) obj;
        if(other.log.size() != log.size())
            return false;
        
        for(int i = 0; i < log.size(); i++)
            if(!log.get(i).equals(other.log.get(i)))
                return false;
        return true;
    }
    
    public int hashCode()
    {
        int res = 0;
        for(Book b : log) // Simplified way to visit an ArrayList (and other List classes)
            res += b.hashCode();
        return res;
    }
    
    /*
     * Next tag ("@SuppressWarnings("...")") is meant to avoid a warning caused by the cast of 
     * log.clone() into the type ArrayList<Book>. Such a warning is typically only issued when you 
     * cast the result of a cloning into a template class (you won't have the same warning, for 
     * instance, with the line "myClone = (BookLog) super.clone();".
     */
    
    @SuppressWarnings("unchecked")
    public Object clone()
    {
        BookLog myClone = null;
        try
        {
            myClone = (BookLog) super.clone();
            
            myClone.log = (ArrayList<Book>) log.clone();
            for(int i = 0; i < log.size(); i++)
                myClone.log.set(i, (Book) log.get(i).clone());
        }
        catch(CloneNotSupportedException e)
        {
            throw new InternalError("Unable to clone a book log");
        }
        return myClone;
    }
}
