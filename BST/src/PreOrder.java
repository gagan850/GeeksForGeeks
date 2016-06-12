public class PreOrder {

    public static void main(final String[] s) {

        //       7
        //    3     6
        //  1  2   4  5
        //
        //
        final TreeNode a = new TreeNode(null, null, 1);
        final TreeNode b = new TreeNode(null, null, 2);
        final TreeNode c = new TreeNode(a, b, 3);
        final TreeNode d = new TreeNode(null, null, 4);
        final TreeNode e = new TreeNode(null, null, 5);
        final TreeNode f = new TreeNode(d, e, 6);
        final TreeNode g = new TreeNode(c, f, 7);
        //        Utils.preOrder(g);
        //        System.out.println();
        //        Utils.postOrder(g);
        //        System.out.println();
        //        Utils.inOrder(g);
        //        System.out.println();
        //        Utils.levelOrder(g);
        Utils.levelSum(g);


    }
}
