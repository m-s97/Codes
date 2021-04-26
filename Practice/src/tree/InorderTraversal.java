package tree;

import java.util.*;

/*
 * Inorder Traversal of a Binary Tree with N nodes
 * leetcode - 94
 */
public class InorderTraversal {
	// Recursive - O(N)
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderRecur(Node root) {
        if(root == null) return res;
        inorderRecur(root.left);
        res.add(root.data);
        inorderRecur(root.right);
        return res;
    }
    // Iterative Using Stack - O(N)
    Stack<Node> st = new Stack<>();
    public List<Integer> inorderTraversal(Node root) {
        if(root == null) return res;
        
        Node curr = root;
        while(!st.isEmpty() || curr != null){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                curr = st.pop();
                res.add(curr.data);
                curr = curr.right;
            }
        }
        return res;
    }
    /*public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        boolean done = false;
        while(!done){
            if(root!= null){
                st.push(root);
                if(root.left != null)
                    root = root.left;
            } 
            else{
                if(st.isEmpty()) done = true;
                else{
                    root = st.pop();
                    res.add(root.val);
                    if(root.right != null) st.push(root.right);
                }
            }
        }
        return res;
    }*/
}
