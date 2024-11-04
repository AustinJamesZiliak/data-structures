import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    Node root;
    static class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int num = 1;
            for(Node node: this.children){
                num += node.size();
            }
            return num;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return this.root.size();
    }

    public int leafCount(){
        return leafCounter(this.root); 
    }

    private int leafCounter(Node node){
        if (node.children.size() == 0){
            return 1; 
        }
        else{
            int data = 0; 

            for (Node givenNode : node.children){
                data += leafCounter(givenNode); 
            }

            return data; 
        }
    }

    // Additional methods will be added in later sections.
    public interface Visitor {
        public void visit(Object data); 
    }

    public void preorder(Visitor v){
        Tree.preorder(this.root, v);
    }
    private static void preorder(Node n, Visitor v){
        if (n == null){
            return;
        }
        
        v.visit(n.data);
        
        for(Node child: n.children){
            Tree.preorder(child, v);
        }
    }

}

//"e3e433f54t53r5trc32323es2se32sw2d54f4rr4frd4dr4ft4f4ft4ft4ft4f4ft4f32ww" (Jack 10/30/2024 1:59p.m.)
/*
 * 
 * BOOO RECURSION
 * MID AF
 * 
 */