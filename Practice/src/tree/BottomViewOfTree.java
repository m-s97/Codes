package tree;
import java.util.*;
/*
 * https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 */
public class BottomViewOfTree {
	// Iterative - O(N)
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<Node > q =  new LinkedList<Node>();
        Map<Integer, List<Integer>> mp = new TreeMap<Integer, List<Integer>>();
        root.hd = 0;
        q.add(root);
 
        while (!q.isEmpty()) {
     
            Node temp = q.poll();
            int d = temp.hd;
            if (mp.get(d) == null) {
                List<Integer> templ = new ArrayList<Integer>();
                templ.add(temp.data);
                mp.put(d, templ);
            }else{
                List<Integer> templ = mp.get(d);
                templ.add(temp.data);
                mp.put(d, templ);                
            }
     
            if (temp.left!=null) {
                temp.left.hd = d - 1;
                q.add(temp.left);
            }
     
            if (temp.right!=null) {
                temp.right.hd = d + 1;
                q.add(temp.right);
            }
            //System.out.println(" mp "+mp);
        }
        for(List<Integer> lst:mp.values()){
            //System.out.println(" lst "+lst);
            int data = lst.get(lst.size()-1);
            res.add(data);
        }
        return res;
    }
}
