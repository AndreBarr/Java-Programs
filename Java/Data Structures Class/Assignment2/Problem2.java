 /*********************************************************************
 Purpose/Description: Binary Search Tree Implementation
 Author’s Panther ID: 5443095
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 Comments: PART E) All the values in the left subtree of a node in a BST are less than
 *                  the value in the node itself. All the values in the right subtree
 *                  of a node in a BST are greater than the value in the node itself.
 *                  Because of these two facts then the statement in question is correct, since
 *                  A contains all the elements in the left sub tree, C all the elements in the
 *                  right sub tree and B all the elements in between.
 * (The operator used can be switched to simply less than if the BST does not contain duplicates)
 ********************************************************************/ 

class BinarySearchTreeNode
{
    public int key;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;
}

class BinarySearchTree
{
    private BinarySearchTreeNode root;

    public void insert(int key) {}

    public void delete(int key) {}

    public boolean find(int key) {return true;}

    public int keySum()
    {
        return sum(root);
    }

    public int sum(BinarySearchTreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        int sum = sum(node.left) + sum(node.right) + node.key;
        return sum;
    }

    public void deleteMin()
    {
        BinarySearchTreeNode parentNode = root;
        if (parentNode == null)
        {
            return;
        }
        int minValue = parentNode.key;
        while (parentNode.left != null)
        {
            minValue = parentNode.left.key;
            parentNode = parentNode.left;
        }
        delete(minValue);
    }

    public void printTree()
    {
        printSubTree(root);
        System.out.println();
    }

    public void printSubTree(BinarySearchTreeNode root)
    {
        if (root.left != null)
        {
            printSubTree(root.left);
        }
        System.out.print(root.key + " ");
        if (root.right != null)
        {
            printSubTree(root.right);
        }
    }

    public void printPostorder()
    {
        printSubTreePostorder(root);
        System.out.println();
    }

    public void printSubTreePostorder(BinarySearchTreeNode root)
    {
        if (root.left != null)
        {
            printSubTreePostorder(root.left);
        }
        if (root.right != null)
        {
            printSubTreePostorder(root.right);
        }
        System.out.print(root.key + " ");
    }
}