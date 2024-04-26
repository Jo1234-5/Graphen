class QueueObject implements Comparable<QueueObject> {
    Vertex vertex;
    int priority;

    public QueueObject(Vertex vertex, int priority) {
        this.vertex = vertex;
        this.priority = priority; // Priorität für die PriorityQueue
    }

    @Override
    public int compareTo(QueueObject other) {
        return Integer.compare(this.priority, other.priority); // Vergleich nach Priorität
    }
}