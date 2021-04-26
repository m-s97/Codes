package tree;
/*
 * https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1#
 */
import java.util.*;

public class HeightOfTree {
	// Recursive approach - O(N)
    int height(Node node) 
    {
        if(node == null) return 0;
        
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }
    // Using level order traversal - O(N)
    int heightLevel(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null) return 0;
        int height = 1;
        q.add(node);
        q.add(null);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur != null){
                res.add(cur.data);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);                
            }
            else{
                if(!q.isEmpty()){
                    height++;
                    q.add(null);
                }
            }
        }
        return height;
    }
}
