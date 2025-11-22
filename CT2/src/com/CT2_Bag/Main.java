package com.CT2_Bag;

/**
 * Main class to demonstrate Bag data structure
 *
 *  @author Nolan Hill
 */
public class Main {
    /**
     * Main method that creates Bag data structure and calls on its methods
     */
    public static void main(String[] args) {
        // Create an instance of the 'Bag' class
        Bag<Integer> testBag = new Bag<Integer>();

        // Add several elements to the bag, including duplicates
        testBag.add(10);
        testBag.add(40);
        testBag.add(33);
        testBag.add(15);
        testBag.add(40);
        testBag.add(33);
        testBag.add(4);

        // Print the bag contents
        System.out.print("Items: ");

        // Iterate through bag and print each item
        for (Integer item : testBag) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Test the 'contains' method for a few elements
        System.out.println("Does the bag contain 15? " + testBag.contains(15));
        System.out.println("Does the bag contain 4? " + testBag.contains(4));
        System.out.println("Does the bag contain 7? " + testBag.contains(7));
        System.out.println("Does the bag contain 33? " + testBag.contains(33));
        System.out.println("Does the bag contain 1? " + testBag.contains(1));

        // Test the 'count' method for a few elements
        System.out.println("Number 10 appears " + testBag.count(10) + " times.");
        System.out.println("Number 40 appears " + testBag.count(40) + " times.");
        System.out.println("Number 1 appears " + testBag.count(1) + " times.");


        Bag<Integer> testBag2 = new Bag<Integer>();
        System.out.println("Bag size is: " + testBag2.size());
        System.out.println("Bag size is: " + testBag.size());

        // Remove an element from the bag
        testBag.remove(10);
        testBag.remove(199); // Test removal of item that does not exist in the linked list


        // Print the bag contents again
        System.out.print("Items: ");

        // Iterate through bag and print each item
        for (Integer item : testBag) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Test the 'contains' method for the removed element
        System.out.println("Does the bag contain the removed value of 10? " + testBag.contains(10));

        // Test the 'count' method for the removed element
        System.out.println("The removed value of 10 appears " + testBag.count(10) + " times now.");
    }
}