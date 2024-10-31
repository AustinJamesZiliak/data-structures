import javax.swing.text.Position.Bias;

/**
   This class demonstrates the tree class.
*/
public class TreeDemo
{
   public static void main(String[] args)
   {
      BinarySearchTree t = new BinarySearchTree();
      t.add("D");
      t.add("B");
      t.add("A");
      t.add("C");
      t.add("F");
      t.add("E");
      t.add("I");
      t.add("G");
      t.add("H");
      t.add("J");
      t.remove("A"); // Removing leaf
      t.remove("B"); // Removing element with one child
      t.remove("F"); // Removing element with two children
      t.remove("D"); // Removing root
      t.print();
      System.out.println("Expected: C E G H I J");

      
 
      /*
       *        1
       *      2    3
       *    4  5     6
       *   7    8     9
       */
      BinaryTree one = new BinaryTree();
      BinaryTree seven = new BinaryTree();
      BinaryTree four = new BinaryTree(null, seven, null);
      BinaryTree eight = new BinaryTree();
      BinaryTree five = new BinaryTree(null, null, eight);
      BinaryTree two = new BinaryTree(one, four, five);
      BinaryTree nine = new BinaryTree();
      BinaryTree six = new BinaryTree(null, null, nine);
      BinaryTree three = new BinaryTree(one, null, six);
      
      
      
      
      

      BinaryTree tree = new BinaryTree(one, two, three);

      int leafCounter = tree.countNodesWithOneChild(); 
      System.out.println("EXPECETED: 4"); 
      System.out.println("ACTUAL: "+leafCounter); 
   }
}
