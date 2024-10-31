/**
   This program tests the binary search tree class.
*/
public class TreeTester
{ 
   public static void main(String[] args)
   {  


      Tree newTree = new Tree("helo");
      Tree leftTree = new Tree("asd");
      Tree rightTree = new Tree("asdasdasd");
      newTree.addSubtree(leftTree);
      newTree.addSubtree(rightTree);

      int leafCounter = newTree.leafCount(); 
      System.out.println("EXPECETED: 2"); 
      System.out.println("ACTUAL: "+leafCounter); 

      
      /* 
      Tree t1 = new Tree("Anne");
      Tree t2 = new Tree("Peter");
      t1.addSubtree(t2);
      Tree t3 = new Tree("Zara");
      t1.addSubtree(t3);
      Tree t4 = new Tree("Savannah");
      t2.addSubtree(t4);
      System.out.println("Size: " + t1.size());
       */
   }
}

