package bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author riperezro
 */
public class BellmanFord {
    
    static class WeightedGraph{
        int size;
        ArrayList <Integer> adjList [];
        ArrayList <Integer> edgeWeight [];
        
        WeightedGraph( int size ){
            this.size = size;
            adjList = new ArrayList [size];
            edgeWeight = new ArrayList [size];
            for( int i = 0 ; i < size ; i ++ ){
                adjList[i] = new ArrayList<>();
                edgeWeight[i] = new ArrayList<>();
            }
        }
        
        boolean addEdge( int from , int to , int weight ){
            if( from < 0 || size <= from || to < 0 || size <= to ) return false;
            adjList[from].add( to );
            edgeWeight[from].add( weight );
            return true;
        }
    }
    
    static int n;
    static int m;
    static int from;
    static int to;
    static int dist [] = new int [100005];
    
    // 2 <= n <= 100000
    // 1 <= edge weight <= 1000
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        String line;
        
        line = br.readLine();
        token = new StringTokenizer(line);
        n = Integer.parseInt( token.nextToken() );
        m = Integer.parseInt( token.nextToken() );
        WeightedGraph graph = new WeightedGraph(n+1);
        
        for( int i = 0 ; i < m ; i ++ ){
            line = br.readLine();
            token = new StringTokenizer(line);
            int f = Integer.parseInt( token.nextToken() );
            int t = Integer.parseInt( token.nextToken() );
            int w = Integer.parseInt( token.nextToken() );
            graph.addEdge(f, t, w);
            graph.addEdge(t, f, w);
        }
        
        line = br.readLine();
        token = new StringTokenizer(line);
        from = Integer.parseInt( token.nextToken() );
        to = Integer.parseInt( token.nextToken() );
        
        for( int i = 1 ; i <= n ; i ++ )
            dist[i] = -1;
        
        dist[from] = 0;
        for( int i = 0 ; i < n-1 ; i ++ ){
            for( int v = 1 ; v <= n ; v ++ ){
                if( dist[i] == -1 ) continue;
                for( int j = 0 ; j < graph.adjList[v].size() ; j ++ ){
                    int nxt = graph.adjList[v].get( j );
                    int w = graph.edgeWeight[v].get( j );
                    if( dist[nxt] == -1 || dist[i] + w < dist[nxt] ) dist[nxt] = dist[i] + w;
                }
            }
        }
        
        System.out.println( dist[to] );
    }
    
}