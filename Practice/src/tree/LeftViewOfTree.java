package tree;

import java.util.*;
/*
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1# 
 */

public class LeftViewOfTree {
	ArrayList<Integer> res = new ArrayList<>();
	// Iterative - O(N)
    ArrayList<Integer> leftViewIterative(Node node)
    {
        Queue<Node> q = new LinkedList<Node>();
        if(node == null) return res;
        q.add(node);
        q.add(null);
        Node prev = null;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(prev == null && cur != null) res.add(cur.data);
            if(cur != null){
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);                
            }
            else{
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            prev = cur;
        }
        return res;
    }
    // Recursive Approach - O(N)
    int maxL = 0;
    ArrayList<Integer> leftView(Node node)
    {
        if(node == null) return res;
        int level = 1;
        leftUtil(node,level);
        return res;
    }
    void leftUtil(Node node,int level){
        if(node == null) return;
        if(maxL < level){
            res.add(node.data);
            maxL = level;
        }
        leftUtil(node.left,level+1);
        leftUtil(node.right,level+1);
    }
}
