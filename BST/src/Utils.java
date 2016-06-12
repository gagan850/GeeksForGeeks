import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Utils {

    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getData());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData());
            inOrder(node.getRight());
        }
    }

    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData());

        }
    }

    public static void levelOrder(TreeNode node) {
        if (node != null) {

            final Queue queue = new LinkedList<>();
            queue.offer(node);

            while (!queue.isEmpty()) {
                final TreeNode currentNode = (TreeNode)queue.poll();
                System.out.println(currentNode);

                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
        }
    }

    public static int noOfLeafNodes(TreeNode node) {

        int count = 0;

        if (node != null) {

            final Queue queue = new LinkedList<>();
            queue.offer(node);

            while (!queue.isEmpty()) {
                final TreeNode currentNode = (TreeNode)queue.poll();

                if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    count++;
                }

                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
        }
        return count;
    }


    public static int noOfLevels(TreeNode node) {

        int count = 0;

        if (node != null) {

            final Queue queue = new LinkedList<>();
            queue.offer(node);
            queue.offer(null);

            while (!queue.isEmpty()) {
                final TreeNode currentNode = (TreeNode)queue.poll();


                if (currentNode == null) {
                    count++;
                    if (queue.isEmpty()) {
                        break;
                    }
                    queue.offer(null);
                    continue;
                }

                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
        }
        return count;
    }


    public static void levelSum(TreeNode node) {

        int count = 0;
        int sum = 0;

        if (node != null) {

            final Queue queue = new LinkedList<>();
            queue.offer(node);
            queue.offer(null);

            while (!queue.isEmpty()) {
                final TreeNode currentNode = (TreeNode)queue.poll();


                if (currentNode == null) {
                    count++;
                    System.out.println("Level " + count + " : " + sum);
                    if (queue.isEmpty()) {
                        break;
                    }

                    sum = 0;

                    queue.offer(null);
                    continue;
                }

                sum +=currentNode.getData();

                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
        }

    }

    public static void preOrderIterative(TreeNode rootNode) {
        if (rootNode != null) {

            final Stack<TreeNode> stack = new Stack<TreeNode>();
            //Insert root node in stack, process that node, insert right node than left node
            stack.push(rootNode);

            while (!stack.isEmpty()) {

                final TreeNode node = stack.pop();
                System.out.println(node.getData());

                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }

                if (node.getLeft() != null) {
                    stack.push(node.getLeft());

                }
            }
        }
    }
}