package ADTs;

import Exceptions.EmptyCollectionException;
import Exceptions.QueueOverFlowException;

public interface QueueADT<T> extends CollectionADT<T> {
    public void enqueue(T element) throws QueueOverFlowException;

    public T dequeue() throws EmptyCollectionException;

    public T peek() throws EmptyCollectionException;
}
