import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Erstellen der Knoten
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");

        // Hinzufügen der Kanten
        n1.addEdge(new Edge(n2, 7));
        n1.addEdge(new Edge(n3, 9));
        n1.addEdge(new Edge(n6, 14));

        n2.addEdge(new Edge(n1, 7));
        n2.addEdge(new Edge(n3, 10));
        n2.addEdge(new Edge(n4, 15));

        n3.addEdge(new Edge(n1, 9));
        n3.addEdge(new Edge(n2, 10));
        n3.addEdge(new Edge(n4, 11));
        n3.addEdge(new Edge(n6, 2));

        n4.addEdge(new Edge(n2, 15));
        n4.addEdge(new Edge(n3, 11));
        n4.addEdge(new Edge(n5, 6));

        n5.addEdge(new Edge(n4, 6));
        n5.addEdge(new Edge(n6, 9));

        n6.addEdge(new Edge(n1, 14));
        n6.addEdge(new Edge(n3, 2));
        n6.addEdge(new Edge(n5, 9));

        List<Node> nodes = Arrays.asList(n1, n2, n3, n4, n5, n6);

        // Graph mit Traversals und Dijkstra
        Graph graph = new Graph(nodes);

        // Traversals
        System.out.println("--- Breadth-First Traversal (BFS) ---");
        graph.breadthFirstTraversal(n1);

        System.out.println("\n--- Depth-First Traversal (DFS) ---");
        graph.depthFirstTraversal(n1);

        // Dijkstra-Test
        System.out.println("\n--- Dijkstra ---");
        graph.findShortestPath(n1, n5);
    }
}