package DSA;
public class ll {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void addFirst(int data){
        Node newNode=new Node (data);
        if(head==null){
           head=newNode;
           return ;
        }
        else
        {
            newNode.next=head;
           head=newNode;
        }

    }
    

 public static void main(String[] args) {
    
 }   
}
