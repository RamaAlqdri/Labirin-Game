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
    public void insertEdge(String sourceCity, String destinationCity, int distance, String direction) {
        Vertex source = searchVertex(sourceCity);
        Vertex destination = searchVertex(destinationCity);
        if (source != null && destination != null) {
            source.addEdge(destination, distance, direction);
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
    public void unvisited() {
        Vertex current = head;
        while (current != null) {
            current.visited = false;
            current = current.next;
        }
    }
}