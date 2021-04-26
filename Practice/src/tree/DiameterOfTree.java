package tree;
/*
 * https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1#
 * leetcode - 543
 */
public class DiameterOfTree {
	// Recursive Approach - O(N^2) TLE
    int diameter(Node root) {
        // Your code here
        if(root == null) return 0;
        int lefth = height(root.left);
        int righth = height(root.right);
        
        int leftd = diameter(root.left);
        int rightd = diameter(root.right);
        
        return Math.max(1+lefth+righth,Math.max(leftd,rightd));
    }
    int height(Node root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        
        return Math.max(right,left)+1;
    }
    // Recursive Approach - O(N)  - Not giving correct output on GFG as of now. 
    /*    
    int max = 0;
    int diameter(Node root) {
           maxDepth(root);
        return max;
    }
    
    public int maxDepth(Node root){
        if(root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = (left + right) > max ? (left + right) : max;
        return (left > right ? left : right) + 1;
    }*/
}
