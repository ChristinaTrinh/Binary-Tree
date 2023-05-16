import java.util.ArrayList;
import java.util.Arrays;

public class IntTreeClient
{
    public static void main(String[]args)
    {
        System.out.println("Exercise 1: countLeftNodes");
        IntTree tree1 = buildRefTree1();
        System.out.println("The tree1 has " + tree1.countLeftNodes() + " left children");
        System.out.println();

        System.out.println("Exercise 2: countEmpty");
        IntTree tree2 = buildRefTree1();
        System.out.println("The tree1 has " + tree2.countEmpty() + " empty branches");
        System.out.println();

        System.out.println("Exercise 3: depthSum");
        IntTree tree3 = buildRefTree1();
        System.out.println("The depth sum of the tree1 is " + tree3.depthSum());
        System.out.println();

        System.out.println("Exercise 4: countEvenBranches");
        IntTree tree4 = buildRefTree2();
        System.out.println("The number of even branches of tree2 is " + tree4.countEvenBranches());
        System.out.println();

        System.out.println("Exercise 5: printLevel");
        IntTree tree5 = buildRefTree2();
        System.out.println("Printing the nodes in level 3 of tree5: ");
        tree5.printLevel(3);
        System.out.println();

        System.out.println("Exercise 6: printLeaves");
        IntTree tree6 = buildRefTree2();
        System.out.println("Printing the leaves of tree6: ");
        tree6.printLeaves();
        System.out.println();

        System.out.println("Exercise 7: isFull");
        IntTree tree7a = buildRefTree1();
        IntTree tree7b = buildRefTree2();
        IntTree tree7c = buildRefTree3();
        System.out.println("tree7a is full: " + tree7a.isFull());
        System.out.println("tree7b is full: " + tree7b.isFull());
        System.out.println("tree7c is full: " + tree7c.isFull());
        System.out.println();

        System.out.println("Exercise 8: toString");
        IntTree tree8 = buildRefTree2();
        System.out.println("The toString of tree8 is: " + tree8.toString());
        System.out.println();

        System.out.println("Exercise 9: equals");
        IntTree tree9a = buildRefTree2();
        IntTree tree9b = buildRefTree2();
        IntTree tree9c = buildRefTree3();
        System.out.println("tree9a is equal to tree9b: " + tree9a.equals(tree9b));
        System.out.println("tree9a is equal to tree9c: " + tree9a.equals(tree9c));
        System.out.println();

        System.out.println("Exercise 10: doublePositives");
        IntTree tree10 = buildRefTree2();
        System.out.println("The original values of tree10 is: ");
        tree10.printSideways();
        System.out.println("After doubling the values of tree10 is: ");
        tree10.doublePositives();
        tree10.printSideways();
        System.out.println();

        System.out.println("Exercise 11: numberNodes");
        IntTree tree11= buildRefTree1();
        System.out.println("The original values of tree11 is: ");
        tree11.printSideways();
        System.out.println("The tree11 after calling numberNodes is: ");
        tree11.numberNodes();
        tree11.printSideways();
        System.out.println();

        System.out.println("Exercise 12: removeLeaves");
        IntTree tree12= buildRefTree2();
        System.out.println("The original values of tree12 is: ");
        tree12.printSideways();
        System.out.println("The tree12 after removing leaves is: ");
        tree12.removeLeaves();
        tree12.printSideways();
        System.out.println();

        System.out.println("Exercise 13: copy");
        IntTree tree13a = buildRefTree2();
        System.out.println("The original tree13a is: ");
        tree13a.printSideways();
        System.out.println("The copy version of tree13a is: ");
        IntTree tree13b = tree13a.copy();
        tree13b.printSideways();
        System.out.println();

        System.out.println("Exercise 14: completeToLevel");
        IntTree tree14 = buildRefTree2();
        System.out.println("The original tree14 is: ");
        tree14.printSideways();
        System.out.println("The tree14 after calling completeToLevel method is: ");
        tree14.completeToLevel(4);
        tree14.printSideways();
        System.out.println();

        System.out.println("Exercise 15: trim");
        IntTree tree15 = buildRefTree4();
        System.out.println("The original tree15 is: ");
        tree15.printSideways();
        System.out.println("The tree15 after trimming is: ");
        tree15.trim(15, 70);
        tree15.printSideways();
        System.out.println();

        System.out.println("Exercise 16: tighten");
        IntTree tree16 = buildRefTree2();
        System.out.println("The original tree16 is: ");
        tree16.printSideways();
        System.out.println("The tree16 after tightening is: ");
        tree16.tighten();
        tree16.printSideways();
        System.out.println();

        System.out.println("Exercise 17: combineWith");
        IntTree tree17a = buildRefTree2();
        IntTree tree17b = buildRefTree3();
        System.out.println("The original tree17a is: ");
        tree17a.printSideways();
        System.out.println("The original tree17b is: ");
        tree17b.printSideways();
        System.out.println("The combined tree is: ");
        IntTree tree17c = tree17a.combineWith(tree17b);
        tree17c.printSideways();
        System.out.println();

        System.out.println("Exercise 18: inOrderList");
        IntTree tree18 = buildRefTree3();
        ArrayList<Integer> list = tree18.inOrderList();
        System.out.println("The in order traversal list is: ");
        if(list.size()>0)
        {
            System.out.print("[" + list.get(0));
            for(int i = 1; i<list.size(); i++)
                System.out.print(", " + list.get(i));
            System.out.print("]");                                                           
        }
        else
            System.out.print("[]");
        System.out.println();
        System.out.println();


        System.out.println("Exercise 19: evenLevels");
        IntTree tree19 = buildRefTree2();
        System.out.println("The original tree19 is: ");
        tree19.printSideways();
        System.out.println("The tree19 after calling evenLevels is: ");
        tree19.evenLevels();
        tree19.printSideways();
        System.out.println();

        System.out.println("Exercise 20: makePerfect");
        IntTree tree20 = buildRefTree2();
        System.out.println("The original tree20 is: ");
        tree20.printSideways();
        System.out.println("The tree20 after making perfect is: ");
        tree20.makePerfect();
        tree20.printSideways();
        System.out.println();
    }

    public static IntTree buildRefTree1()
    {
        IntTreeNode refTree1 = new IntTreeNode(3);        
        refTree1.setLeft(new IntTreeNode(5));
        refTree1.getLeft().setLeft(new IntTreeNode(1));    
        refTree1.setRight(new IntTreeNode(2));
        refTree1.getRight().setLeft(new IntTreeNode(4));  
        refTree1.getRight().setRight(new IntTreeNode(6)); 
        IntTree tree1 = new IntTree(refTree1);
        return tree1;
    }

    public static IntTree buildRefTree2()
    {
        IntTreeNode refTree2 = new IntTreeNode(2);        
        refTree2.setLeft(new IntTreeNode(8));
        refTree2.getLeft().setLeft(new IntTreeNode(0));    
        refTree2.setRight(new IntTreeNode(1));
        refTree2.getRight().setLeft(new IntTreeNode(7));  
        refTree2.getRight().getLeft().setLeft(new IntTreeNode(4));  
        refTree2.getRight().setRight(new IntTreeNode(6));   
        refTree2.getRight().getRight().setRight(new IntTreeNode(9)); 
        IntTree tree2 = new IntTree(refTree2);
        return tree2;
    }

    public static IntTree buildRefTree3()
    {
        IntTreeNode refTree3 = new IntTreeNode(2);        
        refTree3.setLeft(new IntTreeNode(3));
        refTree3.getLeft().setLeft(new IntTreeNode(8));    
        refTree3.getLeft().setRight(new IntTreeNode(7));              
        refTree3.setRight(new IntTreeNode(1));
        IntTree tree3 = new IntTree(refTree3);
        return tree3;
    }

    public static IntTree buildRefTree4()
    {
        IntTreeNode refTree4 = new IntTreeNode(42);
        refTree4.setLeft(new IntTreeNode(9));
        refTree4.getLeft().setLeft(new IntTreeNode(7));
        refTree4.getLeft().getLeft().setLeft(new IntTreeNode(4));
        refTree4.getLeft().setRight(new IntTreeNode(18));
        refTree4.getLeft().getRight().setLeft(new IntTreeNode(15));
        refTree4.setRight(new IntTreeNode(55));
        refTree4.getRight().setRight(new IntTreeNode(108));
        refTree4.getRight().getRight().setLeft(new IntTreeNode(70));
        refTree4.getRight().getRight().setRight(new IntTreeNode(203));
        IntTree tree4 = new IntTree(refTree4);
        return tree4;
    }
}