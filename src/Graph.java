import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;


public class Graph<V extends Comparable<V>> {
    LinkedList<Vertex<V>> listVertex;

    public Graph(){
        this.listVertex = new LinkedList<Vertex<V>>();
    }
    public void insertVertex(V data , String label){
        Vertex<V> nuevo = new Vertex<V>(data , label);
        for(Vertex<V> v : this.listVertex)
            if(v.getData() == data)
            {
                System.out.println("El vertice ya fue insertado antes");
                return;
            }
        this.listVertex.addFirst(nuevo);
    }
    public boolean hasVertex(V data)
    {
        for(Vertex<V> v : this.listVertex)
        {
            if(v.getData().compareTo(data)==0)
                return true;
        }
        return false;
    }
    public Vertex<V> getVertex(V data)
    {
        for(Vertex<V> vertex : this.listVertex)
        {
            if(vertex.getData().compareTo(data)==0)
                return vertex;
        }
        return null;
    }
    public boolean hasEdge(Vertex<V> ver1 ,  Vertex<V> ver2)
    {
        for(Edge<V> edge : ver1.adjacent)
        {
            if(edge.vertexDest.compareTo(ver2) == 0)
                return true;
        }
        return false;
    }
    public Edge<V> getEdge(Vertex<V> ver1 ,  Vertex<V> ver2)
    {
        for(Edge<V> edge : ver1.adjacent)
        {
            if(edge.vertexDest.compareTo(ver2) == 0)
                return edge;
        }
        return null;
    }
    public void insertEdge(V verOri , V verDest, int costo)
    {
        if(!hasVertex(verOri) || !hasVertex(verDest))
            return;
        Vertex<V> vOri = getVertex(verOri);
        Vertex<V> vDes = getVertex(verDest);

        if(hasEdge(vOri , vDes)) 
        {
            return;
        }
        vOri.adjacent.addFirst(new Edge<V>(vDes , costo));
        vDes.adjacent.addFirst(new Edge<V>(vOri , costo));
    }
    public void reloadNodes()
    {
        for(Vertex<V> v : this.listVertex)
        {
            v.visited = false;
            v.dist = Integer.MAX_VALUE;
        }
    }
    
    public void hamiltonPath(LinkedList<Vertex<V>> path , V node)
    {
    	reloadNodes();
        boolean existeCamino = hamiltonianPathRec(path , getVertex(node));
        if(existeCamino)
        {
            for(Vertex<V> vertex : path)
                System.out.print(vertex.data+": "+vertex.label+"\n");
            System.out.println();
        }
        else
        {
            System.out.println("No existe un camino Hamiltoniano");
        }
    }
    private boolean hamiltonianPathRec(LinkedList<Vertex<V>> path , Vertex<V> node)
    {        
        //En caso que el camino ya tenga todos los nodos
        if(path.size() == this.listVertex.size())
            return true;
        if(node.visited)
            return false;
        else
        {
            node.visited = true;
            path.addLast(node);
            boolean existeCamino = false;
            for(Edge<V> edge : node.adjacent)
            {
                existeCamino = hamiltonianPathRec(path , edge.vertexDest);
                if(existeCamino)
                    return true;
            }
            if(!existeCamino)
            {
                path.removeLast().visited = false;
            }
        }
        return false;
    }
    public void hamiltonPathMenorPeso(LinkedList<Vertex<V>> path , V node)
    {
    	reloadNodes();
        boolean existeCamino = hamiltonianPathMenorPesoRec(path , getVertex(node));
        if(existeCamino)
        {
            for(Vertex<V> vertex : path)
                System.out.print(vertex.data+": "+vertex.label+"\n");
            System.out.println();
        }
        else
        {
            System.out.println("No existe un camino Hamiltoniano");
        }
    }
    private boolean hamiltonianPathMenorPesoRec(LinkedList<Vertex<V>> path , Vertex<V> node)
    {   
        //En caso que el camino ya tenga todos los nodos
        if(path.size() == this.listVertex.size())
            return true;
        if(node.visited)
            return false;
        else
        {
            node.visited = true;
            path.addLast(node);
            boolean existeCamino = false;
            //Cola de prioridad para tomar primero, las aristas con menor peso
            //Insertamos las aristas del nodo en la cola
            node.adjacent.sort(new EdgeComparator<V>());
            
            for(Edge<V> edge : node.adjacent)
            {
                existeCamino = hamiltonianPathMenorPesoRec(path , edge.vertexDest);
                if(existeCamino)
                    return true;
            }
            if(!existeCamino)
            {
                path.removeLast().visited = false;
            }
        }
        return false;
    }

    public String toString()
    {
        return listVertex.toString();
    }
}

class EdgeComparator<V extends Comparable<V>> implements Comparator <Edge<V>>
{

    @Override
    public int compare(Edge<V> e1, Edge<V> e2) 
    {
        return (e1.costo<e2.costo)?-1:1;
    }
}