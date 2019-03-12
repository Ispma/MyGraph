package MyGraphProgramm;

public class Main
{
    public static void main( String[] args )
    {
        Graphs g= new Graphs( 6 );
        g.addEdge( 0, 2 );
        g.addEdge( 0, 1 );
        g.addEdge( 1, 2 );
        g.addEdge( 5, 3 );
        g.addEdge( 3, 4 );
        g.addEdge( 3, 2 );
        g.addEdge( 3, 2 );
        g.addEdge( 5, 0 );

        BreadthFirstPaths bfsp= new BreadthFirstPaths( g, 0 );

        System.out.println( bfsp.hasPathTo(3 ));
        System.out.println( bfsp.pathTo(3 ));
        System.out.println( bfsp.distTo( 3 ));
    }
}
