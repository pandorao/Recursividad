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
        for(int i = 0; i < maze.filas; i++){
            for(int j = 0; j < maze.columnas; j++){
                if(j < maze.columnas-1 && matrix[i][j] == 0 && matrix[i][j+1] == 0){
                    addEdge(vertexMatrix[i][j], vertexMatrix[i][j+1]);
                    contEdges++;
                }
                if(i < maze.filas-1 && matrix[i][j] == 0 && matrix[i+1][j] == 0){
                    addEdge(vertexMatrix[i][j], vertexMatrix[i+1][j]);
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

    private void enumerateVertexMatrix(Maze mat) {
        int cont = 1;
        for (int i = 0; i < mat.filas; i++) {
            for (int j = 0; j < mat.columnas; j++) {
                if (mat.getMatrix()[i][j]==0) {
                    vertexMatrix[i][j] = cont;
                    cont++;
                } else {
                    vertexMatrix[i][j] = 0;
                }
            }
        }
    }
    
        public int[][] camino_minimo(){
        int[][] camino = {
            {0,0},
            {0,1},
            {0,2},
            {0,3},
            {0,4},
            {0,5},
            {1,5},
            {2,5},
            {2,4},
            {3,4},
            {4,4},
            {4,3},
            {4,2},
            {3,2}
        };
        
        return camino;
    }

}
