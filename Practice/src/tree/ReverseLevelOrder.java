package tree;

import java.util.*;
/*
 * https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1#
 */

public class ReverseLevelOrder {
	// O(N) : N no. of nodes
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null) return new ArrayList<Integer>();
        
        q.add(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            st.push(cur.data);
            if(cur.right != null) q.add(cur.right);
            if(cur.left != null) q.add(cur.left);
        }
        while(!st.isEmpty()) res.add(st.pop());
        return res;
    }
}
