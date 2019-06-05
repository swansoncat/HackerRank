import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class Solution
{
    //Begin task requirement
    public static Node removeDuplicates(Node head) {
        if (head == null)
        {
            return null;
        }
        else
        {
            Node start = head;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(head.data);
            Node tempPrior = head;
            Node temp = head.next;
            while (temp != null)
            {
                if (arr.contains(temp.data) == false) {
                    arr.add(temp.data);
                    tempPrior = temp;
                    temp = temp.next;
                }
                else 
                {
                    tempPrior.next = temp.next;
                    temp = temp.next;
                }
            }
            return start;
        }

    }
    //end task requirement

	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }
