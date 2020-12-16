import java.util.LinkedList;

public class Vertex <V extends Comparable<V>> implements Comparable<Vertex<V>>
{
    protected V data;
    protected LinkedList<Edge<V>> adjacent;
    public String label;
    public int dist;
    public boolean visited;

    public Vertex(V data , String label) {
        this.data = data;
        this.label = label;
        this.adjacent = new LinkedList<Edge<V>>();
    }

    
    public String toString() 
    {
        return this.data+"--> "+this.label;
    }

    public V getData() {
        return this.data;
    }
    public int compareTo(Vertex<V> otherVertex)
    {
        return this.data.compareTo(otherVertex.data);
    }
    public boolean equals(Object o) {
        if(o instanceof Vertex<?>) {
            Vertex<V> ver = (Vertex<V>) o;
            return this.data.equals(ver.data);
        }
        return false;
    }
}
