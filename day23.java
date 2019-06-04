import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

//Need to implement this function for challenge.
static void levelOrder(Node root){
      //
        LinkedList<Node> list =  new LinkedList<Node>();
        if (root != null)
        {
            list.add(root);
        }

        while (list.size() != 0) 
        {
            Node temp = list.removeFirst();
            System.out.print(temp.data);

            if (temp.left != null) 
            {
                list.add(temp.left);
            }
            if (temp.right != null)
            {
                list.add(temp.right);
            }
            if (list.size() != 0)
            {
                System.out.print(" ");
            }
        }
    }
//End solution    

public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}
