import java.util.ArrayList;
import java.util.List;

class Vertex {
    private String data;
    private List<Edge> edges;

    public Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Vertex end, Integer weight) {
        this.edges.add(new Edge(this, end, weight)); // Kante zum Vertex hinzufügen
    }

    public List<Edge> getEdges() {
        return this.edges; // Gibt die Liste der Kanten zurück
    }

    public String getData() {
        return this.data; // Gibt den Namen des Vertex zurück
    }

    public void print(boolean isWeighted) {
        System.out.print(this.data); // Ausgabe des Vertex-Namens
        for (Edge edge : this.edges) {
            System.out.print(" -> " + edge.getEnd().getData());
            if (isWeighted && edge.getWeight() != null) {
                System.out.print(" (" + edge.getWeight() + ")");
            }
        }
        System.out.println(); // Zeilenumbruch nach der Ausgabe
    }
}