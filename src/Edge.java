class Edge {
    private Vertex start;
    private Vertex end;
    private int weight;

    public Edge(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
         //ist das Gewicht der Kante
        this.weight = weight;
    }

    public Vertex getEnd() {
        return this.end; // Gibt den End-Vertex zurück
    }

    public Integer getWeight() {
        return this.weight; // Gibt das Gewicht der Kante zurück
    }
}