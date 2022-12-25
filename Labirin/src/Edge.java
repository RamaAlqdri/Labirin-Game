public class Edge {
    public class Node {
        Node next;
        Node prev;
        Vertex destination;
        String direction;
        Node(Vertex destination, String direction) {
            this.direction=direction;
            this.destination = destination;
        }
    }
    Node head;
    Node tail;
    public void addEdge(Vertex destination, String direction) {
        Node newEdge = new Node(destination, direction);
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
}