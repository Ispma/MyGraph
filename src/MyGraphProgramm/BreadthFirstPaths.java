package MyGraphProgramm;

import java.util.LinkedList;

public class BreadthFirstPaths
{
    private boolean[] marked;
    // Предыдущая вершина
    private int[] edgeTo;
    private int[] distTo;
    private int sourse;
    private static final int INF= Integer.MAX_VALUE;

    public BreadthFirstPaths ( Graphs g, int sourse )
    {
        if ( sourse < 0 )
        {
            throw new IllegalArgumentException( "Начальная вершина меньше 0 ");
        }
        this.sourse= sourse;
        edgeTo= new int[g.vertexCount()];
        marked= new boolean[g.vertexCount()];
        distTo= new int[g.vertexCount()];
        for ( int i= 0; i < distTo.length; i++ )
        {
            distTo[i]= INF;
        }
        bfs( g, sourse );
    }

    private void bfs ( Graphs g, int source )
    {
        // Вершина с колорой мы начинаем обход, мы сразу помещаем в очередь, и говорим, что расстояние до самой себя = 0
        LinkedList<Integer> queue= new LinkedList<>();
        queue.addLast( source );
        marked[source]= true;
        distTo[source]= 0;

        // пока в очереди есть вершина
        while ( !queue.isEmpty() )
        {
            //мы получаем очередную вершину
            int vertex= queue.removeFirst();
            //  g.adjList(vertex) - берём её список смежности с другими вершинами
            for ( int w : g.adjList(vertex) )
            {
                if ( !marked[w] )
                {
                    //
                    marked[w]= true;
                    edgeTo[w]= vertex;
                    distTo[w]= distTo[vertex] + 1;
                    queue.addLast(w);
                }
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

    public int distTo ( int dist ) { return distTo[dist]; }

}
