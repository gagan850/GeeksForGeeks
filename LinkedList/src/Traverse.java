
public class Traverse {

    public static void main(final String s[]) {
        
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        b.setNext(a);
        ListNode c = new ListNode(3);
        c.setNext(b);
        ListNode d = new ListNode(4);
        d.setNext(c);
        ListNode e = new ListNode(5);
        e.setNext(d);
        
        Utils.traverseList(e);
        Utils.insertLast(78, e);
        Utils.traverseList(e);
        e = Utils.delete(4, e);
        Utils.traverseList(e);

    }
    

    
}
