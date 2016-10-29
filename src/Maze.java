public class Maze {
    private final int[][] matrix;
    private static final int VACUUM = 0;
    private static final int BLOCK = 1;
    private static final int X = 2;
    private static final int CIRCLE = 3;
    
    public Maze(){
        matrix = new int[][]{
            {0,2,0,1},
            {1,0,1,1},
            {1,0,3,0}
        };
    }
}
