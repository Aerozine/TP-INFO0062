/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 9
 *
 * Exercise 2: Group class with equivalence checking and deep cloning.
 *
 * A Group stores an ordered list of Person objects (insertion order).
 */

import java.util.ArrayList;

public class Group implements Cloneable
{
    private ArrayList<Person> members;

    public Group()
    {
        members = new ArrayList<Person>();
    }

    /*
     * Adds a Person to the end of the group.
     */
    public void add(Person p)
    {
        members.add(p);
    }

    /*
     * Returns the number of members in the group.
     */
    public int size()
    {
        return members.size();
    }

    /*
     * Gets the Person at a given index (1-based). Returns null if out of range.
     */
    public Person getPerson(int index)
    {
        if (index <= 0 || index > members.size())
            return null;
        return members.get(index - 1);
    }

    /*
     * Returns a human-readable description of the group.
     */
    public String toString()
    {
        if (members.isEmpty())
            return "(empty group)";

        String result = "";
        for (Person p : members)
        {
            if (result.length() > 0)
                result += "\n";
            result += p.toString();
        }
        return result;
    }

    /*
     * Two Group objects are equivalent if they have the same size and their
     * Person objects are pairwise equivalent in the same order.
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Group))
            return false;

        Group other = (Group) obj;
        if (other.members.size() != members.size())
            return false;

        for (int i = 0; i < members.size(); i++)
            if (!members.get(i).equals(other.members.get(i)))
                return false;

        return true;
    }

    /*
     * hashCode must be consistent with equals.
     */
    public int hashCode()
    {
        int result = 0;
        for (Person p : members)
            result += p.hashCode();
        return result;
    }

    /*
     * Deep clone: produces a new Group whose ArrayList and all Person objects
     * are independently cloned (so mutations in one do not affect the other).
     */
    @SuppressWarnings("unchecked")
    public Object clone()
    {
        Group myClone = null;
        try
        {
            myClone = (Group) super.clone();

            // Clone the ArrayList itself (shallow copy of the list structure)
            myClone.members = (ArrayList<Person>) members.clone();

            // Clone each Person so the two groups share no Person references
            for (int i = 0; i < members.size(); i++)
                myClone.members.set(i, (Person) members.get(i).clone());
        }
        catch (CloneNotSupportedException e)
        {
            throw new InternalError("Unable to clone a Group");
        }
        return myClone;
    }
}
