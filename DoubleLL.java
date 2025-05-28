public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public static Node head;
    public static   Node tail;
    public static int size;

    // addfirst
    public void addFirst(int data){
        
        // create a new node
        Node newnode = new Node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    public int removefirst(){
        if(head == null){
            System.out.println("linkedlist is null");
            return Integer.MIN_VALUE;
        }

        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
         
    }
    public void reverse(){
        Node curr = head;
        Node next ;
        Node prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
     public void print(){
        if(head == null){
            System.out.println("the linked list is empty");
            return;
        }
          Node temp = head;
        while(temp != null){

            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
     }
    //removefirst
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(1);
         dll.addFirst(2);
          dll.addFirst(3);
           dll.addFirst(4);
           dll.print();
           dll.reverse();
           dll.print();
           dll.removefirst();
           dll.print();
        
    }
}
