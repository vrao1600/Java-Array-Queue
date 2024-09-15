package DataStructures;

import Exceptions.*;
import ADTs.*;

/**
 * Implementation of a queue using a circular array.
 * @param <T> the type of elements held in this queue, which must implement {@link Comparable}
 */
public class ArrayQueue<T extends Comparable<T>> implements QueueADT<T> {
    /**
     * The default capacity of the queue
     */
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * The number of elements in the queue
     */
    private int front;

    /**
     * The number of elements in the queue
     */
    private int rear;

    /**
     * The number of elements in the queue
     */
    private int count;

    /**
     * The queue
     */
    private T[] queue;

    /**
     * Creates an empty queue
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty queue with the specified initial capacity
     * @param initialCapacity the initial capacity of the queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        queue = (T[]) new Comparable[initialCapacity];
        front = 0;
        rear = 0;
        count = 0;
    }

    public void enqueue(T element) throws QueueOverFlowException {
        if (size() == queue.length) {
            throw new QueueOverFlowException();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = queue[front];
        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(queue[(front + i) % queue.length]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}