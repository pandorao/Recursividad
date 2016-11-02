package logic;

public class Graph {

    int vertices, edges;
    boolean[][] adj;
    int[][] vertexMatrix;

    public Graph(Maze maze) {
        int contEdges = 0;
        this.vertices = maze.vertexCount();
        adj = new boolean[vertices + 1][vertices + 1];
        enumerateVertexMatrix(maze);
        int[][] matrix = maze.getMatrix();
        for (int i = 0; i < maze.filas; i++) {
            for (int j = 0; j < maze.columnas; j++) {
                if (j < maze.columnas - 1 && matrix[i][j] == 0 && matrix[i][j + 1] == 0) {
                    addEdge(vertexMatrix[i][j], vertexMatrix[i][j + 1]);
                    contEdges++;
                }
                if (i < maze.filas - 1 && matrix[i][j] == 0 && matrix[i + 1][j] == 0) {
                    addEdge(vertexMatrix[i][j], vertexMatrix[i + 1][j]);
                    contEdges++;
                }
            }
        }

        this.edges = contEdges;
    }

    public final void addEdge(int a, int b) {
        adj[a][b] = adj[b][a] = true;
    }

    boolean[] visited;

    public void DFS(int v) {
        visited[v] = true;
        for (int i = 1; i <= vertices; i++) {
            if (adj[v][i] && !visited[i]) {
                DFS(i);
            }
        }
    }

    private void enumerateVertexMatrix(Maze maze) {
        int cont = 1;
        vertexMatrix = new int[maze.filas][maze.columnas];
        int[][] matrix = maze.getMatrix();
        for (int i = 0; i < maze.filas; i++) {
            for (int j = 0; j < maze.columnas; j++) {
                if (matrix[i][j] == 0) {
                    vertexMatrix[i][j] = cont;
                    cont++;
                } else {
                    vertexMatrix[i][j] = 0;
                }
                System.out.print(vertexMatrix[i][j] + "     ");
            }
        }
    }

}
