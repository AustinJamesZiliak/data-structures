import java.util.List;
import java.util.ArrayList;

/**
    Add a method void depthFirst(Visitor v) to the Tree class of
    Section 17.4 (below).
    Keep visiting until the visit method returns false.
*/
public class Tree
{
    private Node root;

    class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 0;
            for (Node child : children) { sum = sum + child.size(); }
            return 1 + sum;
        }
    }

    /**
        Constructs an empty tree.
    */
    public Tree()
    {
        root = null;
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size()
    {
        if (root == null) { return 0; }
        else { return root.size(); }
    }

    // Additional methods will be added in later sections.

    /**
     * print a string of data from the tree starting at 
     * top then going down one level at a time
     */
    public void depthFirst(){
        System.out.print("output:   "+root.data +" ");
        depthFirst(this.root, 0);
    }
    
    
    public static void depthFirst(Node node, int depth){
        if (depth > 0){
            for (Node n: node.children){
                depthFirst(n, depth-1);
            }
        }
        else
            System.out.print(node.data);
            for (Node n: node.children){
                depthFirst(n, depth+1);
            }
    }
    
    public static void depthFirst(Node node){
        for (Node n: node.children){
            System.out.print(n);
        }
        for (Node n: node.children){
            for (Node n: node.children){
                System.out.print(n);
            }
        }
        for (Node n: node.children){
            System.out.print(n);
            for (Node n: node.children){
                System.out.print(n);
                for (Node n: node.children){
                    System.out.print(n);
                }
            }
        }
    }

}
