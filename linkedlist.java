public class linkedlist{
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

    public static void main(String[] args) {
        
        linkedlist li = new linkedlist();
        li.head = new Node(1);
        li.head.next = new Node(2);

    }
}
