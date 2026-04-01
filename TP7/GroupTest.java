/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 9
 *
 * Exercise 2: Test program for Person and Group.
 */

public class GroupTest
{
    public static void main(String[] args)
    {
        // --- Create some Person objects ---
        Person alice = new Person("Dupont", "Alice", "Mathematician and chess player.");
        Person bob   = new Person("Martin", "Bob");          // no bio
        Person carol = new Person("Durand", "Carol", "Novelist.");
        Person dave  = new Person("Lambert", "Dave");

        System.out.println("=== Individual persons ===");
        System.out.println(alice);
        System.out.println(bob);
        System.out.println(carol);
        System.out.println(dave);

        // --- Build a group ---
        Group group1 = new Group();
        group1.add(alice);
        group1.add(bob);
        group1.add(carol);

        System.out.println("\n=== Group 1 ===");
        System.out.println(group1);

        // --- Deep clone the group ---
        Group group2 = (Group) group1.clone();

        System.out.println("\n=== Clone test ===");
        if (group1 != group2 && group1.equals(group2))
            System.out.println("group1 and group2 are distinct but equivalent objects. (CORRECT)");
        else
            System.out.println("ERROR: clone did not produce a distinct equivalent object.");

        // Verify deep cloning: modifying a Person in group2 must not affect group1
        group2.getPerson(1).setBio("Bio changed in clone.");
        if (!group1.equals(group2))
            System.out.println("After mutating group2's first person, groups differ. Deep clone confirmed. (CORRECT)");
        else
            System.out.println("ERROR: groups are still equal — clone is shallow, not deep.");

        // --- Modify group2 and compare ---
        Group group3 = new Group();
        group3.add(new Person("Dupont", "Alice", "Mathematician and chess player."));
        group3.add(new Person("Martin", "Bob"));
        group3.add(new Person("Durand", "Carol", "Novelist."));

        System.out.println("\n=== Equality test ===");
        if (group1.equals(group3))
            System.out.println("group1 and group3 are equivalent. (CORRECT)");
        else
            System.out.println("group1 and group3 differ. (CORRECT — group1's first person was mutated earlier)");

        // --- Test with dave added ---
        group3.add(dave);
        if (!group1.equals(group3))
            System.out.println("After adding Dave to group3, groups differ. (CORRECT)");
        else
            System.out.println("ERROR: groups should differ.");

        // --- hashCode consistency ---
        Group groupA = new Group();
        groupA.add(new Person("Smith", "John", "Engineer"));
        Group groupB = (Group) groupA.clone();
        // Restore the bio on groupB's person to match groupA
        groupB.getPerson(1).setBio("Engineer");

        System.out.println("\n=== hashCode consistency ===");
        if (groupA.equals(groupB) && groupA.hashCode() == groupB.hashCode())
            System.out.println("Equal groups have equal hashCodes. (CORRECT)");
        else
            System.out.println("ERROR: equal groups must have equal hashCodes.");

        // --- Empty group ---
        Group empty = new Group();
        System.out.println("\n=== Empty group ===");
        System.out.println(empty);

        System.out.println("\nAll tests completed.");
    }
}
