public class Graph {

    int vertices, aristas;
    boolean[][] adj;
    int[][] vertexMatrix;

    public Graph(int vertices, Maze maze) {
        int contAristas = 0;
        this.vertices = vertices;
        adj = new boolean[vertices + 1][vertices + 1];
        enumerateVertexMatrix(maze);
        int[][] matrix = maze.getMatrix();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(j < cols-1 && matrix[i][j] == 0 && matrix[i][j+1] == 0){
                    addEdge(vertexMatrix[i][j], vertexMatrix[i][j+1]);
                    contAristas++;
                }
                if(i < rows-1 && matrix[i][j] == 0 && matrix[i+1][j] == 0){
                    addEdge(vertexMatrix[i][j], vertexMatrix[i+1][j]);
                    contAristas++;
                }
            }
        }
        
        this.aristas = contAristas;
    }

    public final void addEdge(int a, int b) {
        adj[a][b] = adj[b][a] = true;
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

    private void enumerateVertexMatrix(Maze mat) {
        int cont = 1;
        int filas = mat.getMatrix().length;
        int columnas = mat.getMatrix()[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (mat.getMatrix()[i][j]==0) {
                    vertexMatrix[i][j] = cont;
                    cont++;
                } else {
                    vertexMatrix[i][j] = 0;
                }
            }
        }
    }

}
