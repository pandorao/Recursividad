
//import java.util.ArrayList;
//import java.util.LinkedList;
public class Graph {

    int vertices, aristas;
    boolean[][] adj;
//    ArrayList<ArrayList<Integer>> adjl;

    public Graph(int Vertices, int Aristas) {
        this.vertices = Vertices;
        this.aristas = Aristas;
        adj = new boolean[Vertices + 1][Vertices + 1];
//        adjl = new ArrayList<ArrayList<Integer>>();
//        for (int i = 0; i <= Vertices; i++) {
//            adjl.add(new ArrayList<Integer>());
//        }
    }

    public void addEdge(int a, int b) {
        adj[a][b] = adj[b][a] = true;
//        adjl.get(a).add(b);
//        adjl.get(b).add(a);
    }

    boolean[] visitado;

    public void DFS(int v) {
        visitado[v] = true;
        for (int i = 1; i <= vertices; i++) {
            if (adj[v][i] && !visitado[i]) {
                DFS(i);
            }
        }
    }

    private int[][] nombrevertices(Maze mat) {
        int cont = 1;
        int filas = mat.getMatrix().length;
        int columnas = mat.getMatrix()[0].length;
        int[][] matrix = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (mat.getMatrix()[i][j]==0) {
                    matrix[i][j] = cont;
                    cont++;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        
        return matrix;
    }

}
