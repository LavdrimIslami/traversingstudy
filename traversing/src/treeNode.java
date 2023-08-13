/*treenode.java
this program will instantiate a treenode for a binary tree
last edited 7/15/23 by Lavdrim Islami
*/

public class treeNode {
    //set variables
    private int data;
    private treeNode left;
    private treeNode right;
    private int max;

    public treeNode(int data, treeNode left, treeNode right){
        this.left = left;
        this.right = right;
        this.data = data;
    }

    //accessor methods
    public treeNode getleft() {
        return this.left;
    }

    public int getdata(){
        return this.data;
    }

    public int getMax(){return this.max;}


    public treeNode getright() {

        return this.right;
    }

    //mutator methods
    public void setleft(treeNode left) {
        this.left = left;
    }

    public void setright(treeNode right) {
        this.right = right;
    }

    public void setdata(int data){
        this.data = data;
    }

}
