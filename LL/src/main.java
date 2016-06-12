
public class main {

    public static void main(String...args) {
       ListNode header = new ListNode();
       ListUtil.addNode(header, 5, ListUtil.BEGINING);
       ListUtil.addNode(header, 4, ListUtil.BEGINING);
       ListUtil.addNode(header, 3, ListUtil.BEGINING);
       ListUtil.addNode(header, 2, ListUtil.END);
       ListUtil.addNode(header, 8, 2);
       ListUtil.traverse(header);
    }
}
