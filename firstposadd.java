public class firstposadd {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        this.next = null;
        }
    }
    public static Node head;
     public static Node tail;
     public static int size ;


     public void addFirst(int data){

        // create a new noe
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        //step2 newnode next = head;
        newNode.next = head;// linking part
        // step 3 head = nrewnode
        head = newNode;
     }
    

     public void addLast(int data){
        // creating a new node
        Node newNode = new Node(data);
        size++;
        // if the linkedlist is empty
        if(head == null){
            head = tail = newNode;

        }
        tail.next = newNode;
        tail = newNode;
     }

     public void add(int data, int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }
        // creating a new node
         Node newNode = new Node(data);
         size++;

         Node temp = head;
         int i = 0;
         while(i < idx-1){
          temp = temp.next;
          i++;

         }
         newNode.next = temp.next;
         temp.next = newNode;


     }
     public int removef(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
       int val = head.data;
       head = head.next;
       size--;
       return val;
     }

     public int removelast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i = 0; i< size-2; i++){
            prev = prev.next;
    }
        int val= prev.next.data; // tail.data
        prev.next = null;
       
        tail = prev;
         size--;
         System.out.println(val);
         return val;


     }
     public int found(int key){
        Node temp = head;
        int i = 0;
       while(temp != null){
        if(temp.data == key){
            return i;
        }
        temp = temp.next;
        i++;
        }
        return -1;
     }
     public int helper(Node head , int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
     }

     public int foundrecursive(int key){
       return  helper(head, key);

     }

     public void reverse(){
         Node prev = null;
        Node curr = tail = head;
        while(curr != null){
           Node next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        head = prev;
       
        
     }
     public void removeNthnodeEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp!= null){
            temp = temp.next;
            sz++;

        }
        if(n == sz){
            head = head.next;
            return;

        }

        //sz-n
        int i = 1;
        int itoFind = sz-n;
        Node prev = head;
        while(i < itoFind){
            prev = prev.next;
            i++;

        }
        prev.next = prev.next.next;
        return;
     }
     // slow first linked list
     public Node findMid(Node head){
        Node slow = head;
        Node fast = head;


        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;// slow is my middle node

     }
     public boolean checkpalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // find mid
        Node midNode = findMid(head);
        // reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
       Node right = prev; // right half ka head
       Node left = head;


        //check left half and right half
        while(right != null){
            if(left .data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
    public static void main(String[] args) {
        firstposadd li = new firstposadd();
      li.addFirst(2);
      li.addFirst(1);
      li.addLast(3);
      li.addLast(4);
      li.add(9,2     );
      li.print();
      System.out.println(li.size);
      li.removef();
      li.print();
      li.removelast();
      li.print();
      System.out.println(li.foundrecursive(9));
      System.out.println(li.foundrecursive(6));
      li.reverse();
      li.print();
      li.removeNthnodeEnd(2);
      li.print();
      System.out.println(li.checkpalindrome());





     

        
    }
}
