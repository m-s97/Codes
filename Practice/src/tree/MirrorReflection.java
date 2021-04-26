package tree;
/*
 * https://www.geeksforgeeks.org/create-a-mirror-tree-from-the-given-binary-tree/
 */
public class MirrorReflection {
	// O(N) Recursive
	public Node mirrorify(Node root) {
		if(root == null) return null;
		Node left = root.left;
		root.left = root.right;
		root.right = left;
		
		if(root.left != null)
			mirrorify(root.left);
		if(root.right != null)
			mirrorify(root.right);
		return root;
	}
/*
 * leetcode - 101	
 * Given the root of a binary tree, check whether it is a mirror of itself
 */
	// O(N) Recursive
    public boolean isSymmetric(Node root) {
        return symUtil(root.left,root.right);
    }
    public boolean symUtil(Node a,Node b){
        if(a == null && b == null) return true;
        
        if(a == null || b == null) return false;
        
        return (a.data == b.data) && symUtil(a.left,b.right) && symUtil(a.right,b.left);
    }
}
