
package Exceptions;

/**
 * Exception class for when trying to compare collection elements that
 * haven't implemented Comparable (and don't have a compareTo(..) method)
 * 
 * @author clatulip
 */
public class QueueOverFlowException extends Exception {

    public QueueOverFlowException() {
        super("The queue has overflown");
    }

}
