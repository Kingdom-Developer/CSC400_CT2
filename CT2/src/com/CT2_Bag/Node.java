package com.CT2_Bag;

/**
 * Node class to be used in Bag class
 * @author Nolan Hill
 */
public class Node<T> {

    // Declare private attributes
    private T item;
    private Node<T> nextItem;

    /**
     * Parameterized constructor for node
     * @param item item to be stored as node's data
     */
    public Node(T item) {
        this.item = item;
        this.nextItem = null;
    }

    /**
     * Getter method for item
     * @return the data of the node
     */
    public T getItem() {
        return this.item;
    }

    /**
     * Getter method for nextItem
     * @return Node's next item
     */
    public Node<T> getNextItem() {
        return nextItem;
    }

    /**
     * Setter method for nextItem
     * @param nextItem the next item to be pointed to by this node
     */
    public void setNextItem(Node<T> nextItem) {
        this.nextItem = nextItem;
    }
}


