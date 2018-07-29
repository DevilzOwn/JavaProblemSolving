public class MainClass
{

    public static void main(String[] args){

        BTOperations operations = new BTOperations();
        BSTNode root = new BSTNode(1);
        root.left = new BSTNode(2);
        root.right = new BSTNode(3);
        root.left.left = new BSTNode(4);
        root.left.right = new BSTNode(5);
        root.right.left = new BSTNode(6);
        root.right.right = new BSTNode(7);

        root.left.left.left = new BSTNode(8);
        root.left.left.right = new BSTNode(9);

        root.left.right.left = new BSTNode(10);
        root.left.right.right = new BSTNode(11);

        root.right.left.left = new BSTNode(12);
        root.right.left.left = new BSTNode(13);

        root.right.right.left = new BSTNode(14);
        root.right.right.right = new BSTNode(15);

        root.left.right.left.left = new BSTNode(16);
        root.left.right.left.right = new BSTNode(17);
        root.left.right.left.right.left = new BSTNode(18);
        root.left.right.left.right.left.right = new BSTNode(21);

        root.left.right.right.right = new BSTNode(19);
        root.left.right.right.right.left = new BSTNode(22);
        root.left.right.right.right.right = new BSTNode(20);
        root.left.right.right.right.left.right = new BSTNode(23);

        operations.printNearestk(root,2,5,new BSTNode[23],0);

    }
}
