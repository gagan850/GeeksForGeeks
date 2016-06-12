
/**
 * The Class TreeNode.
 */
public class TreeNode {

    /** The left. */
    private TreeNode left;

    /** The right. */
    private TreeNode right;

    /** The data. */
    private int data;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return data + "";
    }
    /**
     * Gets the left.
     *
     * @return the left
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Sets the left.
     *
     * @param left the left to set
     */
    public void setLeft(final TreeNode left) {
        this.left = left;
    }

    /**
     * Gets the right.
     *
     * @return the right
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Sets the right.
     *
     * @param right the right to set
     */
    public void setRight(final TreeNode right) {
        this.right = right;
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
     * @param left
     * @param right
     * @param data
     */
    public TreeNode(final TreeNode left, final TreeNode right, final int data) {
        super();
        this.left = left;
        this.right = right;
        this.data = data;
    }


}
