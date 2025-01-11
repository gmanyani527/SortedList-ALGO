import java.util.Iterator;

public class DriverClasss {

    // Display the contents of the sorted list
    public static void DisplayList(SortedList<Integer> list) {
        System.out.print("Sorted List:");
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.print(" " + iterator.next());
        }
        System.out.println(" \n");
    }

    public static void main(String[] args) {
        // Create a SortedList instance
        SortedList<Integer> values = new SortedList<>();

        // Insert values into the list
        values.insert(80);
        values.insert(20);
        values.insert(10);

        // Display the list
        DisplayList(values);

        // Remove a value
        System.out.println("Removing the value 10 from the list.");
        values.remove(Integer.valueOf(10)); // Explicitly wrap 10 as an Integer
        DisplayList(values);

        // Insert new values
        System.out.println("Inserting the value 50 to the list.");
        values.insert(50);

        System.out.println("Inserting the value 30 to the list.");
        values.insert(30);

        // Display the updated list
        DisplayList(values);

        // Retrieve values by index
        System.out.println("Value at index 2 is: " + values.retrieve(2));
        System.out.println("Value at index 10 is: " + values.retrieve(10) + "\n");

        // Search for a value in the list
        System.out.println("Searching for the value 50: " + values.search(50) + "\n");

        // Final display of the list
        DisplayList(values);
    }
}