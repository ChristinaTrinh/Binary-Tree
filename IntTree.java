import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner14;

public class IntTree {
    private IntTreeNode overallRoot;
    private int count = 1; //used in numberNodes method
    private int greatestLevel = 1; //used in makePerfect method

    public IntTree(IntTreeNode overallRoot)
    {
        this.overallRoot = overallRoot;
    }

    public IntTreeNode getOverallRoot()
    {
        return overallRoot;
    }

    public void setOverallRoot(IntTreeNode overallRoot)
    {
        this.overallRoot = overallRoot;
    }

    public void printSideways()
    {
        helperPrintSideways(overallRoot, 0);
    }

    private void helperPrintSideways(IntTreeNode root, int level)
    {
        if(root != null)
        {
            helperPrintSideways(root.getRight(), level + 1);
            for(int i = 0; i < level; i++)
                System.out.print("    ");
            System.out.println(root.getData());
            helperPrintSideways(root.getLeft(), level + 1);
        }
    }

    public int countLeftNodes()
    {
        return helperCountLeftNodes(this.overallRoot);
    }    

    private int helperCountLeftNodes(IntTreeNode root)
    {
        if(root == null)
            return 0;
        else 
        {
            if(root.getLeft()!=null)
                return 1+helperCountLeftNodes(root.getRight())+helperCountLeftNodes(root.getLeft());
            else
                return helperCountLeftNodes(root.getRight())+helperCountLeftNodes(root.getLeft());
        }
    }

    public int countEmpty()
    {
        return helperCountEmpty(this.overallRoot);
    }

    private int helperCountEmpty(IntTreeNode root)
    {
        if(root == null)
            return 1;
        else
            return helperCountEmpty(root.getLeft())+helperCountEmpty(root.getRight());
    }

    public int depthSum()
    {
        return helperDepthSum(this.overallRoot, 1);
    }

    private int helperDepthSum(IntTreeNode root, int level)
    {
        if(root == null)
            return 0;
        else
        {
            int sum1 = helperDepthSum(root.getLeft(), level + 1);
            int sum2 = helperDepthSum(root.getRight(), level + 1);
            return sum1 + sum2 + (level*root.getData());
        }
    }

    public int countEvenBranches()
    {
        return helperCountEvenBranches(this.overallRoot);
    }

    private int helperCountEvenBranches(IntTreeNode root)
    {
        if(root == null)
            return 0;
        else
        {
            if(root.getData()%2 == 0 && (root.getLeft()!= null || root.getRight()!=null))
                return 1+helperCountEvenBranches(root.getLeft())+helperCountEvenBranches(root.getRight());
            else
                return helperCountEvenBranches(root.getLeft())+helperCountEvenBranches(root.getRight());
        }
    }

    public void printLevel(int level)
    {
        if(level<1)
            throw new IllegalArgumentException("The level is not acceptable");
        else
            helperPrintLevel(this.overallRoot, 1, level);
    }

    private void helperPrintLevel(IntTreeNode root, int currentLevel, int targetLevel)
    {
        if(currentLevel == targetLevel && root != null)
            System.out.println(root.getData());
        else if(currentLevel != targetLevel && root != null)
        {
            helperPrintLevel(root.getLeft(), currentLevel+1, targetLevel);
            helperPrintLevel(root.getRight(),currentLevel+1, targetLevel);
        }
    }

    public void printLeaves()
    {
        if(this.overallRoot == null)
            System.out.println("No leaves");
        else
            helperPrintLeaves(this.overallRoot);
    }

    private void helperPrintLeaves(IntTreeNode root)
    {
        if(root.getLeft()==null && root.getRight()==null)
            System.out.println(root.getData());
        else
        {
            if(root.getRight() != null)
                helperPrintLeaves(root.getRight());
            if(root.getLeft() != null)
                helperPrintLeaves(root.getLeft());
        }
    }

    public boolean isFull()
    {
        return helperIsFull(this.overallRoot);
    }

    private boolean helperIsFull(IntTreeNode root)
    {
        //if one branch has only one child then return false
        if((root.getLeft()!=null && root.getRight()==null) || (root.getLeft()==null && root.getRight()!=null))
            return false;
        else
        {
            if(root.getLeft() != null)
                return helperIsFull(root.getLeft());
            if(root.getRight() != null)
                return helperIsFull(root.getRight());
            return true;
        }
    }

    public String toString()
    {
        return helperToString(this.overallRoot);
    }

    private String helperToString(IntTreeNode root)
    {
        if(root==null)
            return "empty";
        else if(root.getLeft()==null && root.getRight()==null)
            return String.valueOf(root.getData());
        else
            return "("+String.valueOf(root.getData())+", "+helperToString(root.getLeft())+", "+helperToString(root.getRight())+")";
    }

    public boolean equals(IntTree other)
    {
        return helperEquals(this.overallRoot, other.overallRoot);
    }

    private boolean helperEquals(IntTreeNode thisRoot, IntTreeNode otherRoot)
    {
        if(thisRoot == null && otherRoot == null) //if they are the same return true
            return true;
        else if(thisRoot.getData() != otherRoot.getData()) //if data is different then return false
            return false;
        else if((thisRoot==null && otherRoot!=null) || (thisRoot!=null && otherRoot==null)) //if one exists and the other is null return false
            return false;
        else
        {
            if(thisRoot!=null && otherRoot!=null)
                return helperEquals(thisRoot.getLeft(), otherRoot.getLeft()) && helperEquals(thisRoot.getRight(), otherRoot.getRight());
            return true;
        }
    }

    public void doublePositives()
    {
        helperDoublePositives(this.overallRoot);

    }

    private void helperDoublePositives(IntTreeNode root)
    {
        if(root!=null)
        {
            if(root.getData()>0)
                root.setData(root.getData()*2);
            helperDoublePositives(root.getLeft());
            helperDoublePositives(root.getRight());
        }
    }

    public void numberNodes()
    {
        helperNumberNodes(this.overallRoot);
    }

    private void helperNumberNodes(IntTreeNode root)
    {
        if(root != null)
        {
            root.setData(count);
            count++;
            if(root.getLeft() != null)
                helperNumberNodes(root.getLeft());
            if(root.getRight() != null)
                helperNumberNodes(root.getRight());
        }
    }

    public void removeLeaves()
    {
        helperRemoveLeaves(this.overallRoot);
    }

    private void helperRemoveLeaves(IntTreeNode root)
    {
        //remove the left leave
        if(root!=null && root.getLeft()!= null && root.getLeft().getLeft()==null && root.getLeft().getRight()==null)
            root.setLeft(null);
        //remove the right leave
        if(root!=null && root.getRight()!= null && root.getRight().getLeft()==null && root.getRight().getRight()==null)
            root.setRight(null);
        if(root!=null)
        {
            helperRemoveLeaves(root.getLeft());
            helperRemoveLeaves(root.getRight());
        }
    }

    public IntTree copy()
    {
        //IntTree tree = new IntTree(new IntTreeNode(this.overallRoot.getData()));
        IntTreeNode node = new IntTreeNode(this.overallRoot.getData());
        helperCopy(this.overallRoot, node);
        return new IntTree(node);
    }

    private void helperCopy(IntTreeNode originalRoot, IntTreeNode copyRoot)
    {
        if(originalRoot != null)
        {
            if(originalRoot.getLeft() != null)
            {
                copyRoot.setLeft(new IntTreeNode(originalRoot.getLeft().getData()));
                helperCopy(originalRoot.getLeft(), copyRoot.getLeft());
            }
            if(originalRoot.getRight() != null)
            {
                copyRoot.setRight(new IntTreeNode(originalRoot.getRight().getData()));
                helperCopy(originalRoot.getRight(), copyRoot.getRight());
            }
        }
    }

    public void completeToLevel(int n)
    {
        helperCompleteToLevel(this.overallRoot, 1, n);
    }

    private void helperCompleteToLevel(IntTreeNode root, int currLevel, int n)
    {
        if(currLevel <= n && root != null)
        {
            if(root.getLeft()!=null && root.getRight()==null)
                root.setRight(new IntTreeNode(-1));
            else if(root.getLeft()==null && root.getRight()!=null)
                root.setLeft(new IntTreeNode(-1));
            helperCompleteToLevel(root.getLeft(), currLevel+1, n);
            helperCompleteToLevel(root.getRight(), currLevel+1, n);
        }
    }

    public void trim(int min, int max)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        helperTrim1(this.overallRoot, list, min, max);
        this.setOverallRoot(null);
        for(int n : list)
            this.setOverallRoot(helperTrim2(this.overallRoot, n));
    }

    private void helperTrim1(IntTreeNode root, ArrayList<Integer> list, int min, int max)
    {
        if(root!=null)
        {
            if(root.getData()>=min && root.getData()<=max)
                list.add(root.getData());
            helperTrim1(root.getLeft(), list, min, max);
            helperTrim1(root.getRight(), list, min, max);
        }
    }

    private IntTreeNode helperTrim2(IntTreeNode root, int value)
    {
        if(root == null)
            root = new IntTreeNode(value);
        else if(value <= root.getData())
            root.setLeft(helperTrim2(root.getLeft(), value));
        else
            root.setRight(helperTrim2(root.getRight(), value));
        return root;
    }

    public void tighten()
    {
        helperTighten1(this.overallRoot);
    }

    private void helperTighten1(IntTreeNode root) //recursively call both subtrees
    {
        if(root != null)
        {
            helperTighten1(root.getLeft());
            helperTighten2(root);
            helperTighten1(root.getRight());
            helperTighten2(root);
        }
    }

    private void helperTighten2(IntTreeNode root)
    {
        if(root.getLeft()!=null && root.getRight()==null)//for when the only child is on the left
            {
                root.setData(root.getLeft().getData()); //set to the left child
                root.setLeft(null);
            }
        if(root.getLeft()==null && root.getRight()!=null) //for when the only child is on the right
        {
            root.setData(root.getRight().getData()); //set to the right child
            root.setRight(null);
        }
    }

    public ArrayList<Integer> inOrderList()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        helperInOrderList(this.overallRoot, list);
        return list;
    }

    private void helperInOrderList(IntTreeNode root, ArrayList<Integer> list)
    {
        if(root != null) //Inorder traversal
        {
            helperInOrderList(root.getLeft(), list);
            list.add(root.getData());
            helperInOrderList(root.getRight(), list);
        }
    }

    public IntTree combineWith(IntTree other)
    {
        IntTreeNode node = new IntTreeNode(3);
        helperCombineWith(this.overallRoot, other.getOverallRoot(), node);
        return new IntTree(node);
    }

    private void helperCombineWith(IntTreeNode firstRoot, IntTreeNode secondRoot, IntTreeNode thirdRoot)
    {
        if(firstRoot != null || secondRoot != null) //for the left side when both trees have
        {
            if(firstRoot!=null && secondRoot!=null && firstRoot.getLeft()!=null && secondRoot.getLeft()!=null)
            {
                thirdRoot.setLeft(new IntTreeNode(3));
                helperCombineWith(firstRoot.getLeft(), secondRoot.getLeft(), thirdRoot.getLeft());
            }
            
            //for the left side when tree 1 has but not tree 2
            else if((firstRoot!=null) && 
                    ((firstRoot.getLeft()!=null && secondRoot==null)||
                     (firstRoot.getLeft()!=null && secondRoot.getLeft()==null)))
            {
                thirdRoot.setLeft(new IntTreeNode(1));
                helperCombineWith(firstRoot.getLeft(), null, thirdRoot.getLeft());
            }

            //for the left side when tree 2 has but not tree 1
            else if((secondRoot!=null) &&
                    ((firstRoot==null && secondRoot.getLeft()!=null) ||
                     (firstRoot!=null && secondRoot!=null && firstRoot.getLeft()==null && secondRoot.getLeft()!=null)))
            {
                thirdRoot.setLeft(new IntTreeNode(2));
                helperCombineWith(null, secondRoot.getLeft(), thirdRoot.getLeft());
            }

            //for the right side when both trees have
            if(firstRoot!=null && secondRoot!=null && firstRoot.getRight()!=null && secondRoot.getRight()!=null)
            {
                thirdRoot.setRight(new IntTreeNode(3));
                helperCombineWith(firstRoot.getRight(), secondRoot.getRight(), thirdRoot.getRight());
            }

            //for the right side when tree 1 has but not tree 2
            else if((firstRoot!=null) &&
                    ((firstRoot.getRight()!=null && secondRoot==null) ||
                     (firstRoot!=null && secondRoot!=null && firstRoot.getRight()!=null && secondRoot.getRight()==null)))
            {
                thirdRoot.setRight(new IntTreeNode(1));
                helperCombineWith(firstRoot.getRight(), null, thirdRoot.getRight());
            }

            //for the right side when tree 2 has but not tree 1
            else if((secondRoot!=null) && 
                    ((firstRoot==null && secondRoot.getRight()!=null) ||
                     (firstRoot!=null && secondRoot!=null && firstRoot.getRight()==null && secondRoot.getRight()!=null)))
            {
                thirdRoot.setRight(new IntTreeNode(2));
                helperCombineWith(null, secondRoot.getRight(), thirdRoot.getRight());
            }
        }
    }

    public void evenLevels()
    {
        helperEvenLevels(this.overallRoot, 1);
    }

    private void helperEvenLevels(IntTreeNode root, int level)
    {
        if(root!=null)
        {
            //for the left side
            if(root.getLeft()!=null && root.getLeft().getLeft()==null && root.getLeft().getRight()==null && ((level+1)%2!=0))
                root.setLeft(null);

            //for the right side
            if(root.getRight()!=null && root.getRight().getLeft()==null && root.getRight().getRight()==null && ((level+1)%2!=0))
                root.setRight(null);

            helperEvenLevels(root.getLeft(), level+1);
            helperEvenLevels(root.getRight(), level+1);
        }
    }

    public void makePerfect()
    {
        helperMakePerfect2(this.overallRoot, 1);
        helperMakePerfect1(this.overallRoot, 1);
    }

    private void helperMakePerfect1(IntTreeNode root, int level) //recursively add until it reaches the deepestLevel
    {
        if(root!=null)
        {
            if(level<greatestLevel && root.getLeft()==null)
                root.setLeft(new IntTreeNode(0));
            if(level<greatestLevel && root.getRight()==null)
                root.setRight(new IntTreeNode(0));

            helperMakePerfect1(root.getLeft(), level+1);
            helperMakePerfect1(root.getRight(), level+1);
        }
    }

    private void helperMakePerfect2(IntTreeNode root, int level) // this method helps find the deepest level of the tree
    {
        if(root!=null)
        {
            if(level>greatestLevel)
                greatestLevel = level;
            helperMakePerfect2(root.getLeft(), level+1);
            helperMakePerfect2(root.getRight(), level+1);
        }
    }
}
