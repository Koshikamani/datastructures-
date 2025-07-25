import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data=data1;
        this.next=next1;
    }

    Node(int data1){
        this.data=data1;
        this.next=null;
    }

}

public class ll {
    private static Node converttoLL(int[] arr){
        Node head=new Node(arr[0]);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    private static void printll(Node head){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
       
    }
    private static int lengthofll(Node head){
        int count=0;
        if(head==null){
            return 0;
        }
        Node temp=head;
        while(temp!=null){
            
            temp=temp.next;
            count++;
        }
        return count;
    }
    private static int checkifPresent(Node head,int val){
        int count=0;

        Node temp=head;
        while(temp!=null){
            if(val==temp.data){
                return count;
            }
            temp=temp.next;
            count++;
        }
        return -1;

    }
    private static Node removetail(Node head){
        if(head==null||head.next==null){
            head=null;
            return head;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next; 
        }
        temp.next=null;
        return head;

    }
    private static Node removehead(Node head){
        if(head==null){
            return head;
        }
        head=head.next;
        return head;
    
    }
    private static Node deleteAtK(Node head,int k){
        if(head==null){
            return head;
        }
        Node temp=head;
         for(int i=0;i<k-1&&temp!=null;i++){
            temp=temp.next;
         }
        if(temp==null||temp.next==null){
                return head;
        }
        temp.next=temp.next.next;
         return head;

    }
    private static Node insertAthead(Node head,int a){
        Node temp=new Node(a);

        temp.next=head;
        head=temp;
        return head;

    }
    private static Node insertAtK(Node head,int k){
        int x;
        System.out.println("enter data to be inserted:");
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        Node n=new Node(x);
        Node temp=head;
        for(int i=0;i<k-1 && temp.next!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("position is beyond the list length");
            return head;
        }
        n.next=temp.next;
        temp.next=n;
        return head;

    }
    private static Node insertAtmiddle(Node head,int f){
        Node j=new Node(f);
        int l=lengthofll(head);
        Node temp=head;
        for(int i=0;i<l/2-1;i++){
            temp=temp.next;
        }
        j.next=temp.next;
        temp.next=j;
        return head;
    }
    private static Node insertbeforeVal(Node head,int val){
        if(head==null){
            return head;
        }
          System.out.println("enter data to be inserted :");
        Scanner f=new Scanner(System.in);
        int d=f.nextInt();
        Node c=new Node(d);
        Node temp=head;
        Node prev=temp;
        if(head.data==val){
            c.next=head;
            head=c;
            return head;
        }
        while(temp.next!=null && temp.next.data!=val){
            temp=temp.next;
            prev=temp;
        }
        if(temp.next==null){
            System.out.println("value not found");
            return head;
        }
        c.next=temp.next;
        prev.next=c;
        return head;
      


    }
    private static Node reversell(Node head){
        Node prev=null;
        Node cur=head;
        while(cur!=null){
            Node nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return prev;


    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        Node head=converttoLL(arr);
        System.out.println("initial ll:");
        printll(head);
        System.out.println("head removed");
        head=removehead(head);
        //Node y=new Node(arr[0]);
        printll(head);
        System.out.println("length of ll:"+lengthofll(head));
        System.out.println("index off element 4:"+checkifPresent(head,4));
        System.out.println("new head after deletion:"+head.data);
        head=removetail(head);
        System.out.println("after tail removal:");
        printll(head);
        System.out.println("tail removed and new data lengthis:"+lengthofll(head));
        head=deleteAtK(head, 1);
        head=insertAthead(head,0);
        System.out.println("after inserting a node at head:");
        printll(head);

        head=insertAtK(head,4);
        System.out.println("after inserting a node at k:");
        printll(head);
        System.out.println("after inserting in middle:");
        head=insertAtmiddle(head,100);
        printll(head);
       
        head=insertbeforeVal(head, 101);
        System.out.println("final ll:");
        printll(head);
         System.out.println("reversed ll:");
        head=reversell(head);
        printll(head);

        
    }

    
}
