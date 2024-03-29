package MyGraphProgramm;

import java.util.LinkedList;

public class Graphs
{
    // Вершины
    private int vertexCount;
    // Рёбра
    private int edgeCount= 0;
    private LinkedList<Integer>[] adjLists;

    public Graphs ( int vertexCount )
    {
        if ( vertexCount < 0 )
        {
            throw new IllegalArgumentException( "Количество вершин меньше 0 ");
        }
        this.vertexCount= vertexCount;
        adjLists= new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++)
        {
          adjLists[i]= new LinkedList<>();
        }
    }

    public int vertexCount() { return vertexCount; }

    public int edgeCount() { return edgeCount; }

    public void addEdge ( int v1, int v2 )
    {
        if ( v1 < 0 || v2 < 0 )
        {
            throw new IllegalArgumentException( "Номер вершины не можэет быть отрицательным" );
        }

        adjLists[v1].add(v2);
        adjLists[v2].add(v1);
    }

    public LinkedList<Integer> adjList ( int vertex ) { return adjLists[vertex]; }

}
