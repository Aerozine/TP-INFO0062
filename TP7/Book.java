/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 9
 *
 * Exercise 1: reading a code and understanding it w.r.t. cloning and equivalence checking.
 *
 * The Book class models a book (a pair of String objects: author and title of the book) that can 
 * be stored in a log (see BookLog class).
 *
 * @author: J.-F. Grailet
 */

public class Book implements Cloneable
{
    private String author, title;
    
    public Book(String author, String title)
    {
        this.author = author;
        this.title = title;
    }
    
    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    
    public String toString()
    {
        return author + " - " + title;
    }
    
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Book)) // N.B.: "null instanceof Book" is also false
            return false;
        
        Book bis = (Book) obj;
        return bis.author.equals(author) && bis.title.equals(title);
    }
    
    public int hashCode()
    {
        return author.hashCode() + title.hashCode();
    }
    
    public Object clone()
    {
        Book myClone = null;
        try
        {
            myClone = (Book) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new InternalError("Unable to clone a book");
        }
        return myClone;
    }
}
