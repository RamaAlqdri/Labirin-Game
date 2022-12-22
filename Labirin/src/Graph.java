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
    public void printAll() {
        Vertex current = head;
        while (current != null) {
            System.out.print("Vertex: [" + current.name + "]");
            System.out.print(" => Edge: ");
            current.edge.printEdge();
            current = current.next;
        }
    }
    public void Djikstra(String source, String destination){
        Vertex begin = searchVertex(source);
        Vertex end = searchVertex(destination);
        begin.history.addLast(begin);
        while (begin!=end){
            begin.visited=true;
            Edge.Node neighboor = begin.edge.head;
            while(neighboor!=null){
                int tempEstimated = begin.estimated+neighboor.distance;
                if(neighboor.destination.estimated==0||tempEstimated<neighboor.destination.estimated){
                    LinkedList.Node current = begin.history.head;
                    neighboor.destination.history.head=null;
                    while (current!=null){
                        neighboor.destination.history.addLast(current.obj);
                        current=current.next;
                    }
                    neighboor.destination.history.addLast(neighboor.destination);
                    neighboor.destination.estimated = tempEstimated;
                }
                neighboor=neighboor.next;
            }
            neighboor = begin.edge.head;
            Vertex minEstimated = neighboor.destination;
            while(neighboor!=null){
                if (neighboor.destination.estimated<minEstimated.estimated&&!neighboor.destination.visited){
                    minEstimated=neighboor.destination;
                }
                neighboor=neighboor.next;
            }

            begin=minEstimated;
            begin.history.printAll();
            System.out.print(" dengan total jarak = "+begin.estimated+" km");
            System.out.println();
        }

    }

    public void unvisited() {
        Vertex current = head;
        while (current != null) {
            current.visited = false;
            current = current.next;
        }
    }
}