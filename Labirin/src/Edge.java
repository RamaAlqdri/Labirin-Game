public class Edge {
    public class Node {
        Node next;
        Node prev;
        Vertex destination;
        int distance;
        String direction;
        Node(Vertex destination, int distance, String direction) {
            this.distance=distance;
            this.direction=direction;
            this.destination = destination;
        }
    }

    Node head;

    Node tail;
    public int getDistance(Vertex destination){
        Node current = head;
        while(current!=null){
            if (current.destination==destination){
                return current.distance;
            }
            current=current.next;
        }
        return 0;
    }
    public Vertex minDistance(){
        if (head==null){
            return null;
        }else {
            Node current = head;
            Vertex tes = null;
            int min = head.distance;
            while(current!=null){
                if (current.distance<=min){
                    min = current.distance;
                    tes = current.destination;
                }
                current=current.next;
            }
            return tes;
        }
    }
    public void addEdge(Vertex destination, int distance, String direction) {
        Node newEdge = new Node(destination, distance, direction);
        if (head == null) {
            head = newEdge;
            tail = newEdge;
        }
        else {
            newEdge.prev = tail;
            tail.next = newEdge;
            tail = newEdge;
        }
    }
    public void printEdge() {
        if (head == null) {
            System.out.print("-\n");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print("[" + current.destination.name + "] Jarak = "+current.distance+" ");
                current = current.next;
            }
            System.out.println();
        }
    }

}
