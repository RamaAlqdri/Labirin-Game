public class LinkedList {
    public class Node{
        Vertex obj;
        Node(Vertex obj){
            this.obj=obj;
        }
        Node next;
    }
    Node head;
    Node tail;
    public void addLast(Vertex obj){//Menambahkan data di akhir
        if (head == null){
            head = new Node(obj);
            tail = head;
        }else{
            Node current = head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=new Node(obj);
            tail= current.next;
        }
    }
    public void printAll(){
        Node current = head;
        if (head==null){
            System.out.println("Anda Belum Membuat Data Pertama");
        }else{
            while(current!=null){
                System.out.print("["+current.obj.name+"] ");
                current=current.next;
            }
        }

    }
    public boolean isEmpty(){
        return (head == null || tail == null);
    }
}