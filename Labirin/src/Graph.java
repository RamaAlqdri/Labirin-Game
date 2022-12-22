public class Graph {
    Vertex head = null;
    Vertex tail = null;
    public void addVertex(String city) {
        Vertex newVertex = new Vertex(city);
        if (head == null) {
            head = newVertex;
            tail = newVertex;
        }
        else {
            tail.next = newVertex;
            tail = newVertex;
        }
    }
    public void insertEdge(String source, String destination, String direction) {
        Vertex Var1 = searchVertex(source);
        Vertex Var2 = searchVertex(destination);
        if (Var1 != null && Var2 != null) {
            Var1.addEdge(Var2, direction);
        }
    }
    Vertex searchVertex(String city) {
        Vertex current = head;
        while (current != null) {
            if (current.name.equals(city)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}