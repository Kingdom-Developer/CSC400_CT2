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
        // Create two instances of the "Bag" class
        Bag<Integer> testBag1 = new Bag<Integer>();
        Bag<Integer> testBag2 = new Bag<Integer>();

        // Add items to testBag1, including duplicates
        testBag1.add(10);
        testBag1.add(20);
        testBag1.add(10);
        testBag1.add(40);

        // Add items to testBag2, including duplicates
        testBag2.add(5);
        testBag2.add(20);
        testBag2.add(20);

        // Print the size of each bag using the "size" method
        System.out.println("The size of testBag1 is: " + testBag1.size());
        System.out.println("The size of testBag2 is: " + testBag2.size());

        // Merge the two bags together using the "merge" method
        testBag1.merge(testBag2);

        // Print the merged bag contents
        System.out.print("Items of the merged bag: ");
        for (Integer item : testBag1) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Create a new bag containing only the distinct elements using the "distinct" method
        Bag<Integer> distinctBag = testBag1.distinct();

        // Print the distinct bag contents
        System.out.print("Items of the distinct bag: ");
        for (Integer item : distinctBag) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}