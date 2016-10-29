public class Maze {
    private final int[][] matrix;
    private static final int VACUUM = 0;
    private static final int BLOCK = 1;
    private static final int X = 2;
    private static final int CIRCLE = 3;
    
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
    
    public int contador_vertices(){
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
