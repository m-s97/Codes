package tree;

import java.util.*;
/*
 * https://practice.geeksforgeeks.org/problems/level-order-traversal/1#
 */

public class LevelOrderTraversal {
	// O(N) : N no. of nodes
    static ArrayList <Integer> levelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null) return new ArrayList<Integer>();
        
        q.add(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            res.add(cur.data);
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
        return res;
    }
}

