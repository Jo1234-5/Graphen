import java.util.*;

class Graph {
    private List<Node> nodes;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void breadthFirstTraversal(Node start) {
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start.getName());

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Knoten: " + current.getName());

            for (Edge edge : current.getEdges()) {
                Node target = edge.getTarget();
                if (!visited.contains(target.getName())) {
                    visited.add(target.getName());
                    queue.add(target);
                }
            }
        }
    }

    public void depthFirstTraversal(Node start) {
        Set<String> visited = new HashSet<>();
        depthFirstTraversalRecursive(start, visited);
    }

    private void depthFirstTraversalRecursive(Node current, Set<String> visited) {
        if (visited.contains(current.getName())) {
            return;
        }

        System.out.println("Knoten: " + current.getName());
        visited.add(current.getName());

        for (Edge edge : current.getEdges()) {
            Node target = edge.getTarget();
            depthFirstTraversalRecursive(target, visited);
        }
    }

    public void findShortestPath(Node start, Node end) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> Double.compare(n1.getDistance(), n2.getDistance()));

        start.setDistance(0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == end) {
                break;
            }

            for (Edge edge : current.getEdges()) {
                Node target = edge.getTarget();
                double newDistance = current.getDistance() + edge.getWeight();

                if (newDistance < target.getDistance()) {
                    target.setDistance(newDistance);
                    target.setParent(current);
                    queue.add(target);
                }
            }
        }

        printShortestPath(end);
    }

    private void printShortestPath(Node end) {
        List<Node> path = new ArrayList<>();
        Node current = end;

        while (current != null) {
            path.add(current);
            current = current.getParent();
        }

        Collections.reverse(path);

        System.out.print("Pfad: ");
        for (Node node : path) {
            System.out.print(node.getName() + " ");
        }
        System.out.println();

        System.out.println("Distanz: " + end.getDistance());
    }
}