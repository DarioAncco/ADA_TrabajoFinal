public class Edge <V extends Comparable<V>> implements Comparable <Edge<V>>
{
    Vertex <V> vertexDest;
    public int label;
    protected int costo;

    public Edge(Vertex <V> vert, int costo) {
        this.vertexDest = vert;
        this.costo = costo;
    }

    public boolean equals(Object o) {
        if(o instanceof Edge<?>) {
            Edge<V> e = (Edge<V>) o;
            return this.vertexDest == e.vertexDest;
        }
        return false;
    }
    @Override
    public int compareTo(Edge<V> otherEdge)
    {
        return Integer.compare(this.costo , otherEdge.costo);
    }
    public String toString() {
        return this.vertexDest.getData().toString()+"("+costo+")"+", ";
    }
}
