import java.util.*;
class Node
{
    int data;
    Node next;

    Node(int value)
    {
        data = value;
        next = null;
    }
}

public class linkedlist
{
    public static Node insertAtBegin(Node head,int value) 
    {
        Node newNode = new Node(value);
        if(head==null)
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        return head;    
    }

    public static Node insertAtEnd(Node head,int value) 
    {
        Node newNode = new Node(value);
        Node temp = head;

        if(head==null)
        {
            head = newNode;
        }
        else
        {
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
            
        return head;    
    }

    public static Node insertAtpos(Node head,int pos,int value) 
    {
        Node temp = head;
        Node newNode = new Node(value);

        if(pos==1)
        {
            newNode.next = head;
            head = newNode;
            return head;
        }

        int count = 1;

        while(temp!=null && count<pos-1)
        {
            
            count++;
            temp = temp.next;
        }

        if(temp==null || temp.next==null)
        {
            System.out.println("Invalid Position..!");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;
            
        return head;    
    }

    public static Node deleteAtBegin(Node head) 
    {

        if(head==null)
        {
            System.out.println("\nList is Empty..!");
            return null;
        }

        head = head.next;
            
        return head;    
    }

    public static Node deleteAtEnd(Node head) 
    {
        Node temp = head; 
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
        temp.next = null;
            
        return head;    
    }

    public static Node deleteAtpos(Node head,int pos) 
    {
        Node temp = head;

        if(pos==1)
        {
            head = temp.next;
            return head;
        }

        int count = 1;

        while(temp!=null && count<pos-1)
        {
            
            count++;
            temp = temp.next;
        }

        if(temp==null || temp.next==null)
        {
            System.out.println("Invalid Position..!");
            return head;
        }

        temp.next = temp.next.next;
            
        return head;    
    }

    public static boolean search(Node head,int find)
    {
        Node temp = head; 
        while(temp!=null)
        {
            if(temp.data==find)
            {
                return true;
            }
            temp = temp.next;
        }
            
        return false;    
    }

    public static void printList(Node head) 
    {
        if (head == null) 
        {
            System.out.println("List is empty..!");
            return;
        }
          Node temp = head;

          while(temp!=null)
          {
                delay();
                System.out.print(temp.data + " -> ");
                temp = temp.next;
          }
          delay();
          System.out.println("null \n");
          delay();
    }

    public static void delay()
    {
        try{
            Thread.sleep(800);
        }
        catch(Exception e)
        {
            System.out.println("Error...!");
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;

        while (true) 
        { 
            System.out.println("\n=========================");
            System.out.println("1 -> Insert at Begin");
            System.out.println("2 -> Insert at End");
            System.out.println("3 -> Insert at Position");
            System.out.println("4 -> Delete at Begin");
            System.out.println("5 -> Delete at End");
            System.out.println("6 -> Delete at Position");
            System.out.println("7 -> Search an Element");
            System.out.println("8 -> Print");
            System.out.println("9 -> Exit");
            
            System.out.println("=========================");

            System.out.println();

            System.out.print("Enter your Choice: ");
            int n = sc.nextInt();

            switch (n)
            {
                case 1:
                    System.out.print("\nEnter value: ");
                    head = insertAtBegin(head, sc.nextInt());
                    break;
                
                case 2:
                    System.out.print("\nEnter value: ");
                    head = insertAtEnd(head, sc.nextInt());
                    break;

                case 3:
                    System.out.print("\nEnter the position: ");
                    int pos = sc.nextInt();
                    System.out.print("\nEnter value: ");
                    int val = sc.nextInt();
                    head = insertAtpos(head, pos, val);
                    System.out.print("\n" + pos +" Position Element Inserted..!");
                    break;
                
                case 4:
                    head = deleteAtBegin(head);
                    System.out.println("\n1st Node Deleted ..!");
                    break;
                
                case 5:
                    head = deleteAtEnd(head);
                    System.out.println("\nLast Node Deleted..!");
                    break;

                case 6:
                    System.out.print("\nEnter the position: ");
                    int po = sc.nextInt();
                    head = deleteAtpos(head, po);
                    System.out.print("\n" + po +" Position Element Deleted..!");
                    break;

                case 7:
                    System.out.print("\nEnter the Element: ");
                    int x = sc.nextInt();
                    if(search(head, x))
                    {
                        System.out.println("\nElement Found..!");
                    }
                    else
                    {
                        System.out.println("\nElement Not Found..!");
                    }
                    break;

                case 8:
                    System.out.println("\nPrintng List: \n");
                    printList(head);
                    break;

                case 9:
                    System.out.println("\nExiting......!");
                    return;

                default:
                    System.out.println("\nInvalid Option..!");
                    break;
            }
        }
    }
}