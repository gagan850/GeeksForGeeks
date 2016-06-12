/**
 * The Class ListNode.
 */
public class ListNode {

    /** The data. */
    int data;
    
    /** The next. */
    ListNode next;
    
    /**
     * List noe.
     *
     * @param data the data
     */
    public ListNode(final int data) {
        this.data = data;
    }
    
    public ListNode() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Gets the data.
     *
     * @return the data
     */
    public int getData() {
        return data;
    }
    
    /**
     * Sets the data.
     *
     * @param data the data to set
     */
    public void setData(final int data) {
        this.data = data;
    }
    
    /**
     * Gets the next.
     *
     * @return the next
     */
    public ListNode getNext() {
        return next;
    }
    
    /**
     * Sets the next.
     *
     * @param next the next to set
     */
    public void setNext(final ListNode next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.valueOf(data);
    }
}
