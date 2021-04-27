package tree;

import java.util.*;

/*
 * https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1
 * leetcode - 199
 */
public class RightViewOfTree {
	ArrayList<Integer> res = new ArrayList<>();
	// Iterative - O(N)
    ArrayList<Integer> rightViewIterative(Node node) {
	    Queue<Node> q = new LinkedList<Node>();
	    if(node == null) return res;
	    q.add(node);
	    q.add(null);
	    while(!q.isEmpty()){
	        Node cur = q.poll();
	        if(q.peek() == null && cur != null) res.add(cur.data);
	        if(cur != null){
	            if(cur.left != null) q.add(cur.left);
	            if(cur.right != null) q.add(cur.right);                
	        }
	        else{
	            if(!q.isEmpty()){
	                q.add(null);
	            }
	        }
	    }
	    return res;
    }
    // Recursive - O(N)
    int maxL = 0;
    ArrayList<Integer> rightView(Node node) {
        if(node == null) return res;
        int level = 1;
        rightUtil(node,level);
        return res;
    }
    void rightUtil(Node node,int level){
        if(node == null) return;
        if(maxL < level){
            res.add(node.data);
            maxL = level;
        }
        rightUtil(node.right,level+1);
        rightUtil(node.left,level+1);
    }
}
