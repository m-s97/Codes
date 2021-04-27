package tree;

public class Node {
    int data;
    int hd;
    Node left, right;

    Node(int item)
    {
        data = item;
        hd = 0;
        left = right = null;
    }
}
