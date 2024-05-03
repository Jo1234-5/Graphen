import java.util.ArrayList;
import java.util.List;

public class Node { //Vertex
    private String name;
    private List<Edge> edges;
    private double distance;
    private Node parent;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
        this.parent = null;
    }

    public String getName() {
        return name;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
