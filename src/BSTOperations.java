import java.util.Stack;

public class BSTOperations {
    public static int kthSmallest(BSTNode root, int k){
        if(root!=null){
            k = kthSmallest(root.left, k);
            k--;
            if(k == 0){
                System.out.println(root.data);
            }
            k = kthSmallest(root.right, k);
        }
        return k;
    }

    public static void inorderTraversal(BSTNode root){
        Stack<BSTNode> s = new Stack<BSTNode>();
        s.push(root);
        BSTNode node = root;
        while(!s.isEmpty()){
            if(node !=null){
                s.push(node);
                node=node.left;
            }
            else{
                node=s.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

//    public static int findCeiling(BSTNode root, BSTNode prev, int val){
//        if(root !=null){
//            if(root.data == val)
//                return root.data;
//            if(root.data < val){
//                if(prev != null && prev.data >= val)
//                    return prev.data;
//                else {
//                    return findCeiling(root.right, root, val);
//                }
//            }
//            else if(root.data > val){
//                if(root.left == null){
//                    return root.data;
//                }
//                return findCeiling(root.left, root, val);
//            }
//        }
//        return -1;
//    }

//    public static int findFloor(BSTNode root, BSTNode prev, int val){
//        if(root!=null){
//            if(root.data == val)
//                return root.data;
//            else if(root.data > val){
//                if(prev !=null && prev.data <= val){
//                    return prev.data;
//                }
//                return findFloor(root.left, root, val);
//            }
//            else{
//                if(root.right == null)
//                    return root.data;
//                return findFloor(root.right, root, val);
//            }
//        }
//        else return -1;
//    }

    public static int Ceil(BSTNode node, int input) {

        // Base case
        if (node == null) {
            return -1;
        }

        // We found equal key
        if (node.data == input) {
            return node.data;
        }

        // If root's key is smaller, ceil must be in right subtree
        if (node.data < input) {
            return Ceil(node.right, input);
        }

        // Else, either left subtree or root has the ceil value
        int ceil = Ceil(node.left, input);
        return (ceil >= input) ? ceil : node.data;
    }

}
