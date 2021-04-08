//Yong Bum Park 20117
//Codigo conseguido de https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
import java.util.ArrayList;

public class BinaryTree {
    /* Class containing left
       and right child of current node
     * and key value*/
    class Node
    {
        ArrayList<String> key;
        Node left, right;
 
        public Node(ArrayList<String> item)
        {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    BinaryTree()
    {
         root = null;
    }
 
    
    /** 
     * @param key
     */
    // This method mainly calls insertRec()
    void insert(ArrayList<String> key)
    {
         root = insertRec(root, key);
    }
 
    
    /** 
     * @param root
     * @param key
     * @return Node
     */
    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, ArrayList<String> key)
    {
 
        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key.get(0).compareTo(root.key.get(0))<0)
            root.left = insertRec(root.left, key);
        else if (key.get(0).compareTo(root.key.get(0))>0)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    

    // This method mainly calls InorderRec()
    void inorder()
    {
         inorderRec(root);
    }
 
    
    /** 
     * @param root
     */
    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}
