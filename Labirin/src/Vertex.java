public class Vertex {
    String name;
    Vertex next;
    boolean visited = false;
    boolean cursor = false;
    int x=0;
    int y=0;
    Edge edge = new Edge();
    Vertex(String name) {
        this.name = name;
    }
    public void addEdge(Vertex destination, String direction) {
        edge.addEdge(destination, direction);
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