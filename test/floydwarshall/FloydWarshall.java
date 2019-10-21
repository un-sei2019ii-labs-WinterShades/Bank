package floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author arardilaag
 */

public class FloydWarshall {

    public static int[][] FloydWarshall(int[][] ady, int cn) {
        int[][] path = new int[cn][cn];

        for (int i = 0; i < cn; i++) {
            System.arraycopy(ady[i], 0, path[i], 0, cn);
        }

        for (int k = 0; k < cn; k++) {
            for (int i = 0; i < cn; i++) {
                for (int j = 0; j < cn; j++) {
                    if (path[i][k] + path[k][j] < path[i][j]) {
                        path[i][j] = path[i][k] + path[k][j];
                    }
                }
            }
        }

        return path;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        String line;
        line = br.readLine();
        token = new StringTokenizer(line);
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] arcos = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arcos[i][j] = 99999;
            }
        }

        for (int i = 0; i < n; i++) {
            arcos[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            line = br.readLine();
            token = new StringTokenizer(line);
            int f = Integer.parseInt(token.nextToken());
            int t = Integer.parseInt(token.nextToken());
            int w = Integer.parseInt(token.nextToken());
            arcos[f][t] = w;
        }

        int[][] p = FloydWarshall(arcos, n);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (p[i][j] == 99999) {
                    System.out.print("INF ");
                } else {
                    System.out.print(p[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

}
