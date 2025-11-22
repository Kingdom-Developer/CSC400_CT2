package com.CT2_Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Bag class that implements Iterable interface
 * @author Nolan Hill
 * @param <T>
 */
public class Bag<T> implements Iterable<T> {
    // Declare private attributes
    private Node<T> head;
    private int numItems;

    /**
     * Getter method for numItems
     * @return numItems in Bag
     */
     public int getNumItems() {
        return numItems;
    }

    /**
     * Getter method for head
     * @return head node
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Constructor to initialize an empty Bag
     */
    public Bag() {
        head = null;
        numItems = 0;
    }

    /**
     * Method to check if Bag is empty
     * @return boolean value of whether bag is empty
     */
    public boolean isEmpty() {
        // Return boolean value based on the number of items
        return numItems == 0;
    }

    /**
     * Method to add item to Bag
     * @param item to add
     * @throws IllegalArgumentException if item to add is null
     */
    public void add(T item) throws IllegalArgumentException {
        // Check if item to add is null
        if (item == null) {
            throw new IllegalArgumentException("Item to add cannot be null.");
        }

        // Store head to tempNode
        Node<T> tempNode = head;

        // Create a new empty node to be stored as the head
        head = new Node<T>(item);

        // Set the nextItem to be the original firstNode
        head.setNextItem(tempNode);

        // Increment numItems
        numItems += 1;
    }

    /**
     * Method to remove item from Bag
     * @param item to remove
     * @throws IllegalArgumentException if item to remove is null
     */
    public void remove(T item) throws IllegalArgumentException {
        // Check if item to remove is null
        if (item == null) {
            throw new IllegalArgumentException("Item to remove cannot be null.");
        }

        // Create temporary node and set it equal to the head
        Node<T> currentItem = head;

        // Check if bag is empty
        if (isEmpty()) {
            return;
        }

        // Handle situation if the head is the item to be removed
        if (head.getItem().equals(item)) {
            head = head.getNextItem();
            numItems -= 1;
            return;
        }

        // Traverse through the linked list
        while (currentItem.getNextItem() != null) {

            // Check if item matches currentItem's next item
            if (currentItem.getNextItem().getItem().equals(item)) {

                // Remove the currentItem's next item
                currentItem.setNextItem(currentItem.getNextItem().getNextItem());

                // Decrement the numItems and return
                numItems -= 1;
                return;
            }

            // No item was removed, continue through the linked list
            currentItem = currentItem.getNextItem();
        }
    }

    /**
     * Method to check if Bag contains item
     * @param item the item to search for
     * @throws IllegalArgumentException if item searched for is null
     * @return boolean value of whether Bag contains the item
     */
    public boolean contains(T item) throws IllegalArgumentException {
        // Check if item searched for is null
        if (item == null) {
            throw new IllegalArgumentException("Item to search for cannot be null.");
        }

        // Create temporary node and set it equal to the head
        Node<T> currentItem = head;

        // Traverse through list to check if it contains item
        while (currentItem != null) {

            // Check if currentItem equals the item being searched for
            if (currentItem.getItem().equals(item)) {
                return true;
            }

            // No match, continue through the linked list
            currentItem = currentItem.getNextItem();
        }

        // Return false to indicate no match in the linked list
        return false;
    }

    /**
     * Method to return number of occurrences for given item
     * @param item to check occurrences of
     * @throws IllegalArgumentException if item to count occurrences of is null
     * @return number of occurrences
     */
    public int count(T item) throws IllegalArgumentException {
        // Check if item to count occurrences of is null
        if (item == null) {
            throw new IllegalArgumentException("Item to count occurrences of cannot be null.");
        }

        // Declare and initialize occurrences variable
        int occurrences = 0;

        // Create temporary node and set it equal to the head
        Node<T> currentItem = head;

        // Traverse through list to check if it contains item
        while (currentItem != null) {

            // Check if currentItem equals the item being searched for
            if (currentItem.getItem().equals(item)) {

                // Increment occurrences
                occurrences += 1;
            }

            // No match, continue through the linked list
            currentItem = currentItem.getNextItem();
        }

        // Return total occurrences of item
        return occurrences;
    }

    /**
     * Method to count number of items in the Bag
     * @return size of Bag including duplicates
     */
    public int size() {
        // Declare and initialize size variable to 0
        int bagSize = 0;

        // Create temporary node and set it equal to the head
        Node<T> currentItem = head;

        // Traverse through list to keep count of total items in Bag
        while (currentItem != null) {
            // Increment bagSize by one
            bagSize ++;

            // Continue to next item in bag
            currentItem = currentItem.getNextItem();
        }

        // Return the size of the bag
        return bagSize;
    }


    /**
     * Override iterator method
     * @return BagIterator object that starts at head node
     */
    @Override
    public Iterator<T> iterator() {
        // Return new BagIterator starting at the head
        return new BagIterator(head);
    }

    /**
     * Inner class to create BagIterator that implements iterator
     * @author Nolan Hill
     */
    private class BagIterator implements Iterator<T> {
        // Declare private attribute
        private Node<T> currentItem;

        /**
         * Parameterized constructor
         * @param head node to be placed at beginning
         */
        public BagIterator(Node<T> head) {
            // Set currentItem to head of linked list
            currentItem = head;
        }

        /**
         * Override hasNext method
         * @return boolean value of whether there is another item
         */
        @Override
        public boolean hasNext() {
            // Check if currentItem is the tail
            return currentItem != null;
        }

        /**
         * Override next
         * @throws NoSuchElementException if there are no more items
         * @return next item
         */
        @Override
        public T next() throws NoSuchElementException {
            // Check if there is next item
            if (!hasNext()) {
                // If no next item, throw exception
                throw new NoSuchElementException("There are no more items left.");
            }

            // Store current item to temporary variable
            T returnItem = currentItem.getItem();

            // Set currentItem to the next item of the linked list
            currentItem = currentItem.getNextItem();

            // Return the item that was stored in temporary variable
            return returnItem;
        }
    }
}
