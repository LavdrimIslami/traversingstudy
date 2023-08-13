/* traversing.java
this program will instantiate binary tree search and traversal methods
last edited 7/30/23 by Lavdrim Islami
*/


import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int[] treeArray = {2, 4, 9, 1, 17, 3, 11}; //create tree array

        binaryTree newTree = new binaryTree(treeArray); //instantiate tree

        System.out.println("Preorder traversal: ");
        newTree.preOrder(newTree.getRoot());

        System.out.println("----------------------");

        System.out.println("Inorder traversal: ");
        newTree.inOrder(newTree.getRoot());

        System.out.println("----------------------");

        System.out.println("Postorder traversal: ");
        newTree.postOrder(newTree.getRoot());

        System.out.println("----------------------");

        System.out.println("The maximum value of the tree is: " + newTree.max(newTree.getRoot()));
        System.out.println("The minimum value of the tree is: " + newTree.min(newTree.getRoot()));

        System.out.println("Enter the number you would like to search for: ");
        Scanner st = new Scanner(System.in);
        int target = st.nextInt();

        boolean result = newTree.search(newTree.getRoot(), target);

        if(result){
            System.out.println(target + " is within the tree");
        }
        else {
            System.out.println("Item not in the tree");
        }

    }

}