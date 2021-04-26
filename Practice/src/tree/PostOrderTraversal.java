package tree;

import java.util.*;
/*
 * PostOrder Traversal of a Binary Tree with N nodes
 * leetcode - 145
 */
public class PostOrderTraversal {
	// Recursive - O(N)
    List<Integer> res = new ArrayList<>();
    public List<Integer> postOrder(Node root) {
        if(root == null) return res;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.data);
        return res;
    }
    // Iterative Using Stack - O(N)
    public List<Integer> postorderTraversal(Node root) {
        if(root == null) return new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(stack.size()>0 && curr == stack.peek()) 
                curr = curr.right;
            else {
                res.add(curr.data);
                curr = null;
            }
        }        
        return res;
    }
}
