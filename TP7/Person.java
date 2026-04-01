/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 9
 *
 * Exercise 2: Person class with equivalence checking and deep cloning.
 *
 * A Person stores a last name, a first name, and an optional short bio.
 */

public class Person implements Cloneable
{
    private String lastName;
    private String firstName;
    private String bio; // Optional; empty string means no bio

    /*
     * Constructor with bio provided.
     */
    public Person(String lastName, String firstName, String bio)
    {
        this.lastName  = lastName;
        this.firstName = firstName;
        this.bio       = (bio != null) ? bio : "";
    }

    /*
     * Constructor without bio (defaults to empty string).
     */
    public Person(String lastName, String firstName)
    {
        this(lastName, firstName, "");
    }

    // Getters
    public String getLastName()  { return lastName;  }
    public String getFirstName() { return firstName; }
    public String getBio()       { return bio;       }

    // Bio setter (bio is modifiable after instantiation)
    public void setBio(String bio)
    {
        this.bio = (bio != null) ? bio : "";
    }

    /*
     * Returns a human-readable description of the person.
     */
    public String toString()
    {
        String result = firstName + " " + lastName;
        if (!bio.isEmpty())
            result += " (" + bio + ")";
        return result;
    }

    /*
     * Two Person objects are equivalent if they share the same last name,
     * first name, and bio.
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Person))
            return false;

        Person other = (Person) obj;
        return lastName.equals(other.lastName)
            && firstName.equals(other.firstName)
            && bio.equals(other.bio);
    }

    /*
     * hashCode must be consistent with equals.
     */
    public int hashCode()
    {
        return lastName.hashCode() + firstName.hashCode() + bio.hashCode();
    }

    /*
     * Deep clone of Person.
     * String fields are immutable in Java, so super.clone() already gives us
     * independent copies of them — no extra work is needed here.
     */
    public Object clone()
    {
        Person myClone = null;
        try
        {
            myClone = (Person) super.clone();
            // String fields (lastName, firstName, bio) are immutable, so the
            // shallow copy produced by super.clone() is already a deep copy.
        }
        catch (CloneNotSupportedException e)
        {
            throw new InternalError("Unable to clone a Person");
        }
        return myClone;
    }
}
