/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 9
 *
 * Exercise 1: reading a code and understanding it w.r.t. cloning and equivalence checking.
 * 
 * This BooksTest class just provides a main() method to test the two other classes.
 *
 * @author: J.-F. Grailet
 */

public class BooksTest
{
    public static void main(String[] args)
    {
        Book b1 = new Book("Jonas Jonasson", "The Hundred-Year-Old Man Who Climbed Out the Window and Disappeared");
        Book b2 = new Book("Jonas Jonasson", "The Girl Who Saved the King of Sweden");
        Book b3 = new Book("Jonas Jonasson", "Hitman Anders and the Meaning of It All");
        Book b4 = new Book("Jonas Jonasson", "The Accidental Further Adventures of the Hundred-Year-Old Man");
        Book b5 = new Book("Jules Verne", "From the Earth to the Moon");
        Book b6 = new Book("Jules Verne", "Twenty Thousand Leagues Under the Sea");
        
        BookLog log1 = new BookLog();
        log1.addBook(b1);
        log1.addBook(b2);
        log1.addBook(b3);
        log1.addBook(b4);
        
        System.out.println(log1); // println() calls "public String toString()" automatically
        BookLog log2 = (BookLog) log1.clone();
        if(log1 != log2 && log1.equals(log2))
            System.out.println("The two book logs are distinct and equivalent objects.");
        else
            System.out.println("The two book logs are the same object.");
        
        log2.removeBook(1);
        log2.removeBook(1);
        log2.addBook(b5);
        log2.addBook(b6);
        System.out.println(log2); // println() calls "public String toString()" automatically
        if(!log1.equals(log2))
            System.out.println("The two book logs are now different.");
        else
            System.out.println("The two book logs are still identical.");
    }
}
