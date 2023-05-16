public class IntTreeNode
{
    private int data;
    private IntTreeNode left;
    private IntTreeNode right;

    // constructs a leaf node with given data
    public IntTreeNode(int data)
    {
        this(data, null, null);
    }

    // constructs a branch node with given data, left subtree, right subtree
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData()
    {
        return data;
    }

    public IntTreeNode getLeft()
    {
        return left;
    }

    public IntTreeNode getRight()
    {
        return right;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public void setLeft(IntTreeNode left)
    {
        this.left = left;
    }

    public void setRight(IntTreeNode right)
    {
        this.right = right;
    }
}