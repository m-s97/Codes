package tree;
import java.util.*;
/*
 * Preorder Traversal of a Binary Tree with N nodes
 * leetcode - 144
 */
public class PreOrderTraversal {
	// Recursive - O(N)
    List<Integer> res = new ArrayList<>();
	public List<Integer> preorderTraversal(Node root) {
		if(root == null) return res;
		res.add(root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return res;
	}
	// Iterative Using Stack - O(N)
    Stack<Node> st = new Stack<>();
    public List<Integer> preorderIterative(Node root) {
        if(root != null){
            st.push(root);
            while(!st.isEmpty()){
            	Node temp = st.pop();
                res.add(temp.data);
                if(temp.right != null)
                    st.push(temp.right);                
                if(temp.left != null)
                    st.push(temp.left);
            }
        }
        return res;
    }
}
