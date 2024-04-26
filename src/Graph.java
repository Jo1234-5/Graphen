import java.util.*;

public class Graph {
    private List<Vertex> vertices; // Liste von Vertices im Graph
    private boolean isWeighted; // Gibt an, ob der Graph gewichtet ist
    private boolean isDirected; // Gibt an, ob der Graph gerichtet ist

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public void addVertex(String value) {
        this.vertices.add(new Vertex(value)); // Fügt einen neuen Vertex hinzu
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null; // Wenn der Graph nicht gewichtet ist, setzen wir das Gewicht auf null
        }
        vertex1.addEdge(vertex2, weight); // Fügt eine Kante hinzu
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight); // Wenn ungerichtet, fügt Kante in beide Richtungen hinzu
        }
    }

    public List<Vertex> getVertices() {
        return this.vertices; // Gibt die Liste aller Vertices im Graph zurück
    }

    public void print() {
        for (Vertex v : this.vertices) {
            v.print(this.isWeighted); // Drucken der Vertices und ihrer Kanten
        }
    }

    public void depthFirstTraversal(Vertex start) {
        Set<Vertex> visitedVertices = new HashSet<>(); // Menge der besuchten Vertices
        depthFirstTraversalRecursive(start, visitedVertices); // Rekursiver DFS-Start
    }

    private void depthFirstTraversalRecursive(Vertex current, Set<Vertex> visitedVertices) {
        if (visitedVertices.contains(current)) {
            return; // Verhindert Zyklen
        }

        System.out.println(current.getData()); // Ausgabe des aktuellen Vertex
        visitedVertices.add(current); // Hinzufügen des aktuellen Vertex zur besuchten Menge

        for (Edge edge : current.getEdges()) {
            Vertex neighbor = edge.getEnd();
            depthFirstTraversalRecursive(neighbor, visitedVertices); // Rekursiver Aufruf
        }
    }

    public static void breadthFirstTraversal(Vertex start) {
        Set<Vertex> visitedVertices = new HashSet<>(); // Set für besuchte Vertices
        visitedVertices.add(start); // Start-Vertex hinzufügen

        Queue<Vertex> visitQueue = new LinkedList<>(); // Warteschlange für BFS
        visitQueue.add(start);

        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.poll(); // Nächster Vertex in der Warteschlange
            System.out.println(current.getData()); // Ausgabe des aktuellen Vertex

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getEnd(); // Nachbarn erhalten
                if (!visitedVertices.contains(neighbor)) { // Nur unbesuchte Vertices
                    visitedVertices.add(neighbor);
                    visitQueue.add(neighbor); // Nachbar zur Warteschlange hinzufügen
                }
            }
        }
    }

    public Map<String, Object> shortestPath(Vertex start, Vertex end) {
        // Verwenden des Dijkstra-Algorithmus zur Berechnung des kürzesten Pfades
        PriorityQueue<QueueObject> queue = new PriorityQueue<>(); // PriorityQueue zur Sortierung nach aktueller Distanz
        Map<String, Integer> distances = new HashMap<>(); // Karte für Distanzen zu jedem Vertex
        Map<String, Vertex> previous = new HashMap<>(); // Karte für vorherige Vertices zum Rekonstruieren des Pfades

        // Initialisierung der Distanzen
        for (Vertex vertex : this.vertices) {
            if (vertex.equals(start)) {
                distances.put(vertex.getData(), 0); // Start-Vertex mit Distanz 0
                queue.add(new QueueObject(vertex, 0)); // Start-Vertex zur Warteschlange hinzufügen
            } else {
                distances.put(vertex.getData(), Integer.MAX_VALUE); // Unendliche Distanz für andere Vertices
            }
            previous.put(vertex.getData(), null); // Kein vorheriger Vertex zu Beginn
        }

        // Dijkstra's Algorithmus
        while (!queue.isEmpty()) {
            Vertex current = queue.poll().vertex; // Der Vertex mit der kleinsten Distanz
            if (current.equals(end)) {
                break; // Wenn wir den End-Vertex erreicht haben, brechen wir ab
            }

            for (Edge edge : current.getEdges()) {
                Vertex neighbor = edge.getEnd(); // Nachbar des aktuellen Vertex
                int edgeWeight = (edge.getWeight() == null) ? 0 : edge.getWeight(); // Gewicht der Kante
                int currentDistance = distances.get(current.getData());
                int newDistance = currentDistance + edgeWeight; // Neue Distanz

                if (newDistance < distances.get(neighbor.getData())) {
                    distances.put(neighbor.getData(), newDistance); // Aktualisierung der Distanz
                    previous.put(neighbor.getData(), current); // Vorheriger Vertex zum Pfad
                    queue.add(new QueueObject(neighbor, newDistance)); // Warteschlange aktualisieren
                }
            }
        }

        // Rekonstruktion des kürzesten Pfades
        List<Vertex> path = new ArrayList<>();
        Vertex current = end;
        while (current != null) {
            path.add(current); // Pfad aufbauen
            current = previous.get(current.getData()); // Vorheriger Vertex
        }
        Collections.reverse(path); // Umkehrung des Pfades

        Map<String, Object> result = new HashMap<>(); // Ergebnis-Map
        result.put("distance", distances.get(end.getData())); // Kürzeste Distanz
        result.put("path", path); // Kürzester Pfad

        return result; // Rückgabe des Ergebnisses
    }
}