package logic;

public class Maze {
    private final int[][] matrix;
    public static final int VACUUM = 0;
    public static final int BLOCK = 1;
    public static final int X = 2;
    public static final int CIRCLE = 3;
    
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
}
