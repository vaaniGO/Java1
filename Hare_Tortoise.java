/*
 * Return the middle elements of the LinkedList using Hare and Tortoise approach: using a slow pointer (moves one point)
 * and a fast pointer(moves two points)
 * When the fast reaches the end (or is thrown out and becomes null), the start always points to the middle of the LinkedList.
 */
import java.io.*;
public class Middle_of_LL
{
    Node head; 
    
    class Node {
        int data;
        Node next; 
        public Node(int data)
        {
            this.data= data; 
            this.next= null; 
        }
    }
    
    public void pushNode(int data)
    {
        Node newNode= new Node(data);
        newNode.next= head; 
        head= newNode; 
    }
    
    public void printNode()
    {
        Node temp= head;
        while(temp != null)
        {
            System.out.print(temp.data+"->");
            temp= temp.next; 
        }
        System.out.print("Null"+"/n");
    }
    
    public int getLen()
    {
        int length= 0; 
        Node temp= head; 
        while (temp!=null)
        {
            length++; 
            temp= temp.next; 
        }
        return length; 
    }
    
    /*
     * Returns the middle node and if there are two middle nodes it returns the second middle node.
     */
    public Node getMiddle()
    {
        Node slow= head, fast= head; 
        
        while(fast != null && fast.next != null)
        {
            slow= slow.next; 
            fast= fast.next.next;   // can only take this out if fast.next is not null
        }
        
        return slow; 
    }
    
    public static void main(String[] args)
    {
        Middle_of_LL list= new Middle_of_LL();
        for (int i=1; i<=10; i++)
            list.pushNode(i);
        
        System.out.print(list.getMiddle().data);
    }
}
