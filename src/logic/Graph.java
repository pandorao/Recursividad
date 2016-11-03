package logic;

public class Graph {

    int vertices, edges;
    boolean[][] adj;
    int[][] vertexMatrix;
    int[][] visited;
    int contVisited;
    String toVisit;

    public Graph(Maze maze) {
        int contEdges = 0;
        this.enumerateVertexMatrix(maze);
        adj = new boolean[vertices + 1][vertices + 1];
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

    private void addEdge(int a, int b) {
        adj[a][b] = adj[b][a] = true;
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
        vertices = cont;
    }

    private void newToVisit(int newToVisit) {
        if (toVisit.equals("")) {
            toVisit = "" + newToVisit;
        } else {
            toVisit = "-" + newToVisit;
        }
    }

    private int getLastToVisitAndRemove() {
        int len = toVisit.length();
        String s = toVisit.substring(len - 1);
        int ret = Integer.parseInt(s);
        toVisit = toVisit.substring(0, len - 1);
        return ret;
    }

    public int[] getShortestPath(int vInit, int vMeta) {
        visited = new int[vertices + 1][2];
        toVisit = "";
        contVisited = 0;
        newToVisit(vInit);
        while (!toVisit.equals("")) {
            int actual = getLastToVisitAndRemove();
            for (int i = 1; i <= vertices; ++i) {
                if (adj[actual][i] && !visited[i]) {
                    visited[contVisited][0] = i;
                    visited[contVisited][1] = actual;
                    if(i == vMeta){
                        toVisit = "";
                    }else{
                        newToVisit(i);
                    }
                }
            }
        }
    }

}
