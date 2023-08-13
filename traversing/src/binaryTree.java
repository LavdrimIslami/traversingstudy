/* binaryTree.java
this will instantiate a binary tree
last edited 7/30/23 by Lavdrim Islami
 */

import java.util.Random;

public class binaryTree {

    //setting properties
    private treeNode root = null;
    private int size = 0;

    public binaryTree(){
        //null constructor
    }

    public treeNode getRoot() {
        return root;
    }

    public binaryTree(int[] array){
        for(int i = 0; i < array.length; i++){ //for loop to insert number from array into tree
            insert(array[i]);
        }

    }

    public void insert(int i){
        treeNode node = new treeNode(i, null, null);

        if(root == null){//first case
        root = node; //root points to new node
        size++; //update size of tree
            return;
        }//end if

        //NO LEFT ADD NEW NODE LEFT
        treeNode curr = root; //current pointer
        boolean cont = true;

        while (cont){
            if(curr.getleft() == null){
                curr.setleft(node);
                cont = false;
                size++;
                return;
            }//end if

            //HAS LEFT, NO RIGHT, ADD NEW NODE RIGHT
            else if (curr.getright() == null) {
                curr.setright(node);
                cont = false;
                size++;
                return;
            }//end else if
            //BOTH HAS LEFT RIGHT, PICK RANDOM SIDE AND REPEAT
            else{

                Random rand = new Random();
                int random = rand.nextInt(2);
                if(random == 0){
                    curr = curr.getleft();
                }//end if

                else{
                    curr = curr.getright();
                }//end else
            }//end else
        }//end while
    }
    public void preOrder(treeNode curr){
        //check if null
        if(curr == null){
            return;
        }
        //visit current node,process data in node
        System.out.println(curr.getdata());

        //visit left subtree, The current node's left pointer points to its left child
        if(curr.getleft() != null){
            preOrder(curr.getleft());
        }//end if
        // Visit the right subtree
        // The current node's right pointer points to its right subtree
        if(curr.getright() != null){
            preOrder(curr.getright());
        }//end if

    }//end preOrder

    public void inOrder(treeNode curr){
        /* Visit the left subtree first.
         * The current node's left pointer points to it's left child, which is
         the root node of its left subtree.*/

        // if the left child exists, move to that node
        if(curr.getleft() != null){
            inOrder(curr.getleft());
        }//end if

        // Visit the current node.
        // Process the data in the current node.
        System.out.println(curr.getdata());

        /* Visit the right subtree first.
         * The current node's right pointer points to its right child, which
         is the root node of its right subtree. */

        // if the right child exists, move to that node
        if(curr.getright() != null){
            inOrder(curr.getright());
        }//end if

    }//end inOrder

    public void postOrder(treeNode curr){
        // Visit the left subtree first.
        // The current node's left pointer points to its left subtree.
        if(curr.getleft() != null){
            postOrder(curr.getleft());
        }//end if

        // Visit the right subtree
        // The current node's right pointer points to its right subtree.
        if(curr.getright() != null){
            postOrder(curr.getright());
        }//end if

        // Visit the current node.
        // Process the data in the current node.
        System.out.println(curr.getdata());

    }//end postOrder


    //search method based on postorder traversal
    public boolean search(treeNode curr, int target){
        //create boolean variable found set to false
        boolean found = false;
        //check if curr has no value
        if(curr == null){
            return found;
        }

        if(curr.getdata() == target){//if the key value is equal to data in the tree
            found = true;
            return found;
        }//end if

        //visit left subtree, The current node's left pointer points to its left child
        if(curr.getleft() != null){
            found = search(curr.getleft(),target);
            if(found){
                return true;
            }//end if
        }//end if
        // Visit the right subtree
        // The current node's right pointer points to its right subtree
        if(curr.getright() != null){
            found = search(curr.getright(),target);
            if(found){
                return true;
            }//end if
        }//end if

       //when the target is found in a subtree, the traversal stops rather than continues


        return false;
    }

    //max method based on postorder traversal
    public int max(treeNode curr) {
        //create int variable max set to -1
        int max = -1;
        //check if curr has no value
        if(curr == null){
            return max;
        }

        int lMax = max(curr.getleft());

        //find the max of the left tree
        if(lMax > max){//if the value is greater than the max
            max = lMax;
        }//end if

        //find the max of the right tree
        int rMax = max(curr.getright());
        //visit left subtree, The current node's left pointer points to its left child
        if(rMax > max){
            max = rMax;

        }//end if

        //the current node is greater than the max
        if(curr.getdata() > max) {
            max = curr.getdata();
        }

        return max;

    }

    //min method based on postorder traversal
    public int min(treeNode curr){
        //create int variable max set to 1000
        int min = 1000;
        //check if curr has no value
        if(curr == null){
            return min;
        }

        int lMin = min(curr.getleft());

        if(lMin > min){ //find the min of the left tree
            min = lMin;
        }//end if


        int rMin = min(curr.getright());
        //find the min of the right tree
        if(rMin < min){
            min = rMin;

        }//end if

        //current node is the new min if its less than old min
        if(curr.getdata() < min) {
            min = curr.getdata();
        }

        return min;

    }// end min
    }//end class


