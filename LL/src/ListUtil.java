
/**
 * The Class ListUtil.
 */
public class ListUtil {

    /** The Constant BEGINING. */
    public static final int BEGINING = 0;
    
    /** The Constant END. */
    public static final int END = 1;
    
    /**
     * Adds the node.
     *
     * @param header the header
     * @param data the data
     * @param position the position
     */
    public static void addNode(ListNode header, int data, int position) {
        if (BEGINING == position) {
            if (header == null) {
                header = new ListNode();
                header.data = data;
                header.next = null;
            } else {
                ListNode newNode = new ListNode();
                newNode.data= header.data;
                newNode.next = header.next;
                header.data = data;
                header.next = newNode;
            }
        } else if (END == position ) {
            if (header == null) {
                header = new ListNode();
                header.data = data;
                header.next = null;
            } else {
                ListNode newNode = new ListNode();
                newNode.data= data;
                newNode.next = null;
                ListNode currentNode = header;
                ListNode parentNode = null;
                while (currentNode != null) {
                    parentNode = currentNode;
                    currentNode = currentNode.next;
                }
                parentNode.next = newNode;
            }
        } else {
            if (header == null) {
                header = new ListNode();
                header.data = data;
                header.next = null;
            } else {
                int index = 0;
                ListNode newNode = new ListNode();
                newNode.data= data;
                newNode.next = null;
                ListNode currentNode = header;
                ListNode parentNode = null;
                while (currentNode != null || index == position) {
                    if (index == position) break;
                    parentNode = currentNode;
                    currentNode = currentNode.next;
                    index ++;
                }
                parentNode.next = newNode;
                newNode.next = currentNode;
            }
        }
    }

    public static void traverse(ListNode header) {

        if (header == null) {
            System.out.println("Linked List is Empty");
            
        } else {
            
            ListNode currentNode = header;
            while(currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }

}
