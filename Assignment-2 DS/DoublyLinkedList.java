import java.util.*;
class node{
  int data;
  node next;
  node prev;
  node(int d){
    data=d;
  }
}

class DList{

  node head;
  node tail;

  public void insertAtEnd(int d)
  {
    node t = new node(d);
    if(head==null){
      head=t;
      tail=t;
    }
    else{
      tail.next=t;
      t.prev=tail;
      tail=t;
      //t.next=null;
    }
  }

  public void insertAtBeg(int data){
    node t=new node(data);
    if(head==null){
      head=t;
      tail=t;
    }
    else{
      head.prev=t;
      t.next=head;
      head=t;
    }
  }

  public void deleteAtBeg()
  {
    if(head==null)
    {
      System.out.println("List is empty");
    }
    else{
      
      if(head.next!=null){
      head.next.prev=null;
      head=head.next;
      }
      else{
        head=null;
        tail=null;
      }
    }
  }

  public void deleteAtEnd()
  {
    if(head==null)
    {
      System.out.println("List is empty ");
    }
    else{
      if(head!=tail){
      node t=head;
      while(t.next!=null)
      {
        t=t.next;
      }
      tail=t.prev;
      t.prev.next=null;
    }
    else{
      head=null;
      tail=null;
    }
    }
  }

  void deletenode(node del) 
{ 
    if (head == null || del == null) 
        return; 
  
    if (head == del) 
        head = del.next; 
  
    if (del.next != null) 
        del.next.prev = del.prev;

    if(del.next==null)
    {
      deleteAtEnd();
    } 
  
    if (del.prev != null) 
        del.prev.next = del.next; 
} 
  
void deletenodeAtGivenPos(int n) 
{ 
    if (head == null || n <= 0) 
        return; 
  
    node current = head; 

    for (int i = 1; current != null && i < n; i++) 
    {
      current = current.next;
    } 
  
    if (current == null) 
    {
        System.out.println("position is greater");
        return; 
    }
  
    deletenode(current); 
} 

void insertAtPos(int d,int x)
{
  int i;
  node temp,t;
  node new1;
  new1=new node(d);
  
  temp=head;
     t=head;
for(i=1;i<x-1 && temp!=null;i++)
{
temp=temp.next;
}

if(x==1)
{
  new1.prev=null;
  new1.next=temp;
  temp.prev=new1;
  head=new1;
}
else if(temp!=null){
new1.next=temp.next;
if(temp.next!=null){
new1.prev=temp.next.prev;

temp.next.prev=new1;
}
new1.prev=temp;
temp.next=new1;
}
else{
 System.out.println("Position is greater");
}
}


  public void dis(){
    node t=head;
    if(head!=null){
    while(t!=null)
    {
      System.out.print(t.data+" <-> ");
      t=t.next;
    }
    System.out.println();
    // System.out.println("Reverse :");
    // t=tail;
    // while(t!=null)
    // {
    //   System.out.print(t.data+" <-> ");
    //   t=t.prev;
    // }
    // System.out.println();
  }
  else{
    System.out.println("List is empty");
  }
  
}
}

class DoublyLinkedList
{
  public static void main(String[] args) {
    DList d = new DList();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Size : ");
    int n=sc.nextInt();
    for(int i=0;i<n;i++)
    {
      System.out.println("Enter : ");
      d.insertAtEnd(sc.nextInt());
    }
    d.dis();
    System.out.println();
    System.out.println("Enter position:");
    int pos = sc.nextInt();
    System.out.println("Enter data : ");
    int data = sc.nextInt();
    d.insertAtPos(data,pos);
    d.dis();
    System.out.println("Enter position:");
    pos=sc.nextInt();
    d.deletenodeAtGivenPos(pos);
    d.dis();
  }
}