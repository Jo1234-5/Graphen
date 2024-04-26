import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Einen ungerichteten, gewichteten Graphen erstellen
        Graph graph = new Graph(true, false);

        // Vertices hinzufügen
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        graph.addVertex(a.getData());
        graph.addVertex(b.getData());
        graph.addVertex(c.getData());
        graph.addVertex(d.getData());
        graph.addVertex(e.getData());

        // Kanten hinzufügen
        graph.addEdge(a, b, 4); // Verbindung A-B mit Gewicht 4
        graph.addEdge(a, c, 2); // Verbindung A-C mit Gewicht 2
        graph.addEdge(b, c, 5); // Verbindung B-C mit Gewicht 5
        graph.addEdge(b, d, 10); // Verbindung B-D mit Gewicht 10
        graph.addEdge(c, d, 3); // Verbindung C-D mit Gewicht 3
        graph.addEdge(c, e, 8); // Verbindung C-E mit Gewicht 8
        graph.addEdge(d, e, 7); // Verbindung D-E mit Gewicht 7

        // Graph anzeigen
        System.out.println("Graph:");
        graph.print();

        // Depth First Traversal (DFS)
        System.out.println("\nDepth First Traversal (DFS) von A:");
        graph.depthFirstTraversal(a);

        // Breadth First Traversal (BFS)
        System.out.println("\nBreadth First Traversal (BFS) von A:");
        graph.breadthFirstTraversal(a);

        // Kürzester Pfad von A nach E mit Dijkstra
        System.out.println("\nKürzester Pfad von A nach E:");
        Map<String, Object> shortestPathResult = graph.shortestPath(a, e);
        List<Vertex> path = (List<Vertex>) shortestPathResult.get("path");
        int distance = (int) shortestPathResult.get("distance");

        System.out.print("Pfad: ");
        for (Vertex v : path) {
            System.out.print(v.getData() + " ");
        }
        System.out.println("\nDistanz: " + distance);
    }
}