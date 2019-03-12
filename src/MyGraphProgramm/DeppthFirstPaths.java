package MyGraphProgramm;

import java.util.LinkedList;

public class DeppthFirstPaths
{

    private boolean[] marked;
    // Предыдущая вершина
    private int[] edgeTo;
    // Вершина с которой начинаем обход
    private int sourse;

    public DeppthFirstPaths ( Graphs g, int sourse )
    {
        if ( sourse < 0 )
        {
            throw new IllegalArgumentException( "Начальная вершина меньше 0 ");
        }

        this.sourse= sourse;
        edgeTo= new int[g.vertexCount()];
        marked= new boolean[g.vertexCount()];
        dfs( g, sourse );
    }

    // Текущая дислокация
    private void dfs ( Graphs g, int v )
    {
        marked[v]= true;
        for ( int w : g.adjList(v) )
        {
            if ( !marked[w] )
            {
                edgeTo[w]= v;
                dfs( g, w );
            }
        }
    }

    public boolean hasPathTo ( int dist ) { return marked[dist]; }

    public LinkedList<Integer> pathTo ( int dist )
    {
        if ( !hasPathTo(dist) )
        {
            return null;
        }

        LinkedList<Integer> stack= new LinkedList<>();

        int vertex= dist;
        while ( vertex != sourse )
        {
            stack.push(vertex);
            vertex= edgeTo[vertex];
        }
        return stack;
    }
}
