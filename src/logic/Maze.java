package logic;

public class Maze {
    private final int[][] matrix;
    public static final int VACUUM = 0;
    public static final int BLOCK = 1;
    private static final int ROAD = 2;
        public int filas;
    public int columnas;
    
    public Maze(){
        matrix = new int[][]{
            {0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0},
            {1,1,1,1,1,0,1,0,1,0,0,0,1,1,1,0},
            {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,1,0,1,0,1,0,0,1,0,1,1,0,1,1,0},
            {0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0},
            {0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0}
        };
           this.filas = matrix.length;
        this.columnas = matrix[0].length;
    }

    public int[][] getMatrix() {
        return matrix;
    }
    
    public int vertexCount(){
        int cont=0;
        for (int[] i: matrix) {
            for (int j: i) {
                if(j==0){
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public int[][] Matrix_with_Road(int[][] camino) {
        int[][] mat = matrix;
        for (int[] camino1 : camino) {
            mat[camino1[0]][camino1[1]] = ROAD;
        }
        return mat;
    }
}
