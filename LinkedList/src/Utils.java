

public class Utils {

    //To Traverse the linked list
    public static int traverseList(final ListNode list) {
        
        int length = 0;
        ListNode currentNode = list;
        
        //if list is empty
        if (currentNode == null) {
            length = 0;
        } else {
            length++;
            System.out.print(currentNode.getData());
            
            //if list contain more than one element
            while (currentNode.next != null) {
                length++;
                currentNode = currentNode.next;
                System.out.print(currentNode.getData());

            }
        }
        System.out.println();
        return length;             
    }
    
    
    public static ListNode insertLast(final int data, ListNode list) {
        
        ListNode currentNode = list;
        
        ListNode nodeToAdd = new ListNode(data);
        if (currentNode == null) {
         list = nodeToAdd;   
        } else {
            
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            
            currentNode.next =nodeToAdd;
        }
        return list;
    }

    
    /**
     * Delete.
     *
     * @param data the data
     * @param list the list
     * @return the list node
     */
    public static ListNode delete(final int data, final ListNode list) {

        ListNode currentNode = list;

        if (list != null) {

            if (currentNode.getData() == data) {
                return null;
            }
            while (currentNode.getNext() != null) {
                if (currentNode.getNext().getData() == data) {
                    currentNode.setNext(currentNode.getNext().getNext());
                } else {
                    currentNode = currentNode.getNext();
                }

            }
        }
        return list;
    }
     
    
    public static void add(final int data, final ListNode a) {
        a.setData(data);
        a.next = new ListNode(7);
    }
}
