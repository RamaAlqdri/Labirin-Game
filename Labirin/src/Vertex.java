public class Vertex {
    String name;
    Vertex next;
    boolean visited = false;
    boolean cursor = false;
    boolean mark = false;
    int x=0;
    int y=0;
    int estimated=0;
    LinkedList history = new LinkedList();
    Vertex(String name) {
        this.name = name;
    }
    Edge edge = new Edge();
    public void addEdge(Vertex destination, int distance, String direction) {
        edge.addEdge(destination, distance, direction);
    }
    public int distanceTo(String direction){
        Edge.Node current = edge.head;
        while (current!=null){
            if (current.direction.equals(direction)){
                return current.distance;
            }
            current=current.next;
        }
        return 0;
    }
    public boolean isRightAvailable(){
        Edge.Node current = edge.head;
        while (current!=null){
            if (current.direction.equals("Right")){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public boolean isLeftAvailable(){
        Edge.Node current = edge.head;
        while (current!=null){
            if (current.direction.equals("Left")){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public boolean isTopAvailable(){
        Edge.Node current = edge.head;
        while (current!=null){
            if (current.direction.equals("Top")){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public boolean isBottomAvailable(){
        Edge.Node current = edge.head;
        while (current!=null){
            if (current.direction.equals("Bottom")){
                return true;
            }
            current=current.next;
        }
        return false;
    }

}
