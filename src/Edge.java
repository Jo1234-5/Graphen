class Edge {
    private Node target;
    private double weight;
    private boolean visited;

    public Edge(Node target, double weight) {
        this.target = target;
        this.weight = weight;
        this.visited = false;
    }

    public Node getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}