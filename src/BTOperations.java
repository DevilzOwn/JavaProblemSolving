public class BTOperations {
    public void printDescendants(BSTNode root, int k){
        if(root == null || k<0 )
            return;
        if(k==0)
            System.out.println(root.data);
        printDescendants(root.left,k-1);
        printDescendants(root.right,k-1);
    }

    public void printNearestk(BSTNode root, int k, int val, BSTNode[] ancestors, int index){
        if(root == null)
            return;
        BSTNode temp =null, prevNode=null;
        if(root.data == val){
            printDescendants(root, k);
            prevNode = root;
            for(int i = index-1;i>=0;i--){
                temp = ancestors[i];
                if(k-index+i == 0){
                    System.out.println(temp.data);
                    return;
                }
                if(prevNode == temp.left){
                    printDescendants(temp.right,k-index+i-1);
                }
                else{
                    printDescendants(temp.left,k-index+i-1);
                }
                prevNode = temp;
            }
        }
        else{
            ancestors[index]=root;
            printNearestk(root.left,k,val,ancestors,index+1);
            printNearestk(root.right,k,val,ancestors,index+1);
        }
    }

    public int nearestLeafNode(BSTNode root, int val, BSTNode[] ancestors, int index){
        if(root == null)
            return Integer.MAX_VALUE;
        BSTNode temp, prevNode=root;
        int minDist,i;
        if(root.data == val){
            minDist = nearestDescendantLeaf(root);
            for(i=index-1;i>=0;i--){
                temp = ancestors[i];
                if(temp.left == prevNode){
                    minDist = Math.min(minDist,index-i+1+nearestDescendantLeaf(temp.right));
                }
                else{
                    minDist = Math.min(minDist,index-i+1+nearestDescendantLeaf(temp.left));
                }
                prevNode = temp;
            }
            return minDist;
        }
        else{
            ancestors[index]=root;
            return Math.min(nearestLeafNode(root.left,val,ancestors,index+1),
                    nearestLeafNode(root.right,val,ancestors,index+1));
        }
    }

    public int nearestDescendantLeaf(BSTNode root){
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null && root.right == null)
            return 0;
//        int left = nearestDescendantLeaf(root.left);
//        int right = nearestDescendantLeaf(root.right);
//        int ans = Math.min(nearestDescendantLeaf(root.left), nearestDescendantLeaf(root.right));
        return 1+Math.min(nearestDescendantLeaf(root.left), nearestDescendantLeaf(root.right));
    }

}
