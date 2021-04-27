package tree;
import java.util.*;
/*
 * https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 */
public class TopViewOfTree {
	// Iterative - O(N)
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Node temp = null;
        Queue<Pair > q =  new LinkedList<Pair>();
        Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        q.add(new Pair( root, 0 ));
 
        while (!q.isEmpty()) {
     
            temp = q.peek().n;
            int d = q.peek().hd;
            q.remove();
     
            if (mp.get(d) == null) {
                mp.put(d, temp.data);
            }
     
            if (temp.left!=null) {
                q.add(new Pair( temp.left, d - 1 ));
            }
     
            if (temp.right!=null) {
                q.add(new Pair( temp.right, d + 1 ));
            }
            //System.out.println(" mp "+mp);
        }
        for(Integer data:mp.values()){
            //System.out.println(" data "+data);
           res.add(data);
        }
        return res;
    }
    
    static class Pair{
        Node n;
        int hd;
        Pair(Node n,int a)
        {
            this.n=n;
            this.hd=a;
        }
    }
}
