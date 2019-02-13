import java.util.*;
class Node 
{
  int data;
  Node next;
  Node(int data)
  {
    this.data=data;
    
  }
}
class linklist 
{
  Node head;
  public void insertEnd(int data)
  {
    Node node = new Node(data);
    if(head==null)
    {
       head=node;
    }
    else 
    {
      Node temp = head;
      while(temp.next!=null)
      {
        temp=temp.next;
      }
      temp.next = node;
    }
  }
  public void insertBegin(int data)
  {
    Node node = new Node(data);
    if(head==null)
    {
        head=node;
    }
    else 
    {
      node.next=head;
      head=node;
    }
  }

  public void deleteAtBeg(){
    //Node h = head;
    if(head==null)
    {
      System.out.println("List is empty");
    }
    else{
      Node h = head;
      head=h.next;
      h.next=null;
    }
  }

  void deleteEnd(){
    if(head==null){
      System.out.println("list is empty");
    }
    else{
      Node curr;
      Node prev=null;
      curr=head;
      while(curr.next!=null){
        prev=curr;
        curr=curr.next;
      }
      if(prev==curr){
        head=null;
      }
      prev.next=null;
    }
  }

  public void insertAtPos(int data,int pos){

    boolean f = false;
    Node prev;
    Node temp;
    prev = head;
    temp=prev.next;
    Node t = new Node(data);
    int c=1;
    if(pos==1){
      insertBegin(data);
      f=true;
    }
    else{
      c++;
      while(temp.next!=null){
        if(pos==c){
          prev.next=t;
          t.next=temp;
          f=true;
          break;
        }
        c++;
        prev=temp;
        temp=temp.next;
      }
      //System.out.println(c);
      if(pos==c && f==false)
      {
        prev.next=t;
        t.next=temp;
        f=true;
      }
      c++;
      if(pos==(c) && f==false){
        insertEnd(data);
        f=true;
      }
    }
    if(f==false)
    {
      System.out.println("position is greater");
    }

  }

  public void deleteAtPos(int position)
  {
       if (head == null) 
       {
         System.out.println("Linked list is empty");
         return;
       } 

        Node temp = head; 
        if (position == 1) 
        { 
            head = temp.next;   
            return; 
        } 
        //temp=temp.next;
        for (int i=1; temp!=null && i<position-1; i++) 
        {
          //System.out.println(i);
          temp = temp.next; 
        }  

        if (temp == null || temp.next == null) 
        { 
             System.out.println("position is greater than size");
             return;
        } 
  
        Node next = temp.next.next; 
  
        temp.next = next;
  }
  
  public void display()
  {
    if(head==null)
    {
      System.out.println("Empty List");
    }
    else
    {

    Node temp = head;
    while(temp!=null)
    {
      System.out.print(temp.data+"->");
      temp=temp.next;
    }
    }
    System.out.println();
  }
  
}


class SingleLinkedList
{
  public static void main(String[] args) {
   linklist l = new linklist();
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter size");
   int n = sc.nextInt();
   for(int i=0;i<n;i++){
        System.out.println("Enter : ");
        l.insertEnd(sc.nextInt());
   }
  l.display();
  System.out.println();

  System.out.println("Enter position to insert :");
  int pos=sc.nextInt();
  System.out.println("Enter value to be inserted at "+pos);
  int v = sc.nextInt();
  l.insertAtPos(v, pos);
  System.out.println("Linked List after insertion at position "+pos+" : ");
  l.display();
  System.out.println("Enter position to delete :");
  pos=sc.nextInt();
  System.out.println("After deletion at position "+pos+" : ");
  l.deleteAtPos(pos);
  l.display();
  }
}