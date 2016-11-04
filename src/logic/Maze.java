package logic;

public class Maze {

    private int[][] matrix;
    public static final int VACUUM = 0;
    public static final int BLOCK = 1;
    public static final int ROAD = 2;
    private int filas;
    private int columnas;
    private int bloqueados;
    private String toVisit;
    private boolean[] visited;
    private int[] parents;

    public Maze(int filas, int columnas, int bloqueados) {
        this.filas = filas;
        this.columnas = columnas;
        this.bloqueados = bloqueados;
        int cont=1, i=0, j=0, num;
        matrix = new int[filas][columnas];
        while (cont<=bloqueados){
            while (i < filas && cont <= bloqueados) {
                while (j < columnas && cont <= bloqueados) {
                    num = (int) (Math.random() * 2 + 0);
                    if (matrix[i][j] != 1 && num==1) {
                        matrix[i][j] = num;
                        cont++;
                    }
                    j++;
                }
                j = 0;
                i++;
            }
            i=0;
            j=0;
        }
    }
    
    public int[][] getMatrix() {
        return matrix;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

//    AUN NO HE DECIDIDO SI VOY A USAR ESTOS DOS METODOS
//    public int vertexCount() {
//        int cont = 0;
//        for (int[] i : matrix) {
//            for (int j : i) {
//                if (j == 0) {
//                    cont++;
//                }
//            }
//        }
//        return cont;
//    }
//
//    public int[][] Matrix_with_Road(int[][] camino) {
//        //camino debe ser un arreglo de dos dimensiones que siempre tendra dos columnas y en el que cada fila es una coordenada, la primera columna es la coordenada en x y la segunda fila es la coordenada en y
//        int[][] mat = matrix;
//        for (int[] camino1 : camino) {
//            mat[camino1[0]][camino1[1]] = ROAD;
//        }
//        return mat;
//    }
//    AUN NO HE DECIDIDO SI VOY A USAR ESTOS DOS METODOS
    private boolean isBetweenLimits(int x) {
        return x > 0 && x < filas * columnas;
    }

    public boolean isBlock(int x) {
        int[] aux = getCoordinateFromNumber(x);
        return matrix[aux[0]][aux[1]] == BLOCK;
    }

    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    private void assignParents(int ini, int meta) {// el metodo recibe como argumentos la version numerica de las coordenada de la casilla inicial y la casilla final, para obtener la version umerica de una coordenada se usa el metodo getNumberFromCoordinate
        toVisit = "";
        visited = new boolean[filas * columnas + 1];
        parents = new int[filas * columnas + 1];
        newToVisit(ini);
        visited[ini] = true;
        while (!toVisit.equals("")) {
            int actual = getLastToVisitAndRemove();
            int aux = actual + 1;
            if (isBetweenLimits(aux) && !isBlock(aux) && !visited[aux]) {
                markCoordinate(aux, actual, meta);
            }
            aux = actual - 1;
            if (isBetweenLimits(aux) && !isBlock(aux) && !visited[aux]) {
                markCoordinate(aux, actual, meta);
            }
            aux = actual - columnas;
            if (isBetweenLimits(aux) && !isBlock(aux) && !visited[aux]) {
                markCoordinate(aux, actual, meta);
            }
            aux = actual + columnas;
            if (isBetweenLimits(aux) && !isBlock(aux) && !visited[aux]) {
                markCoordinate(aux, actual, meta);
            }
        }

    }

    public int[][] getShortestRoadIntoMatrix(int ini, int meta) {// el metodo recibe como argumentos la version numerica de las coordenada de la casilla inicial y la casilla final, para obtener la version umerica de una coordenada se usa el metodo getNumberFromCoordinate
        int[][] mat = matrix;
        assignParents(ini, meta);
        int actual = meta;
        while (actual != ini) {
            int[] aux = getCoordinateFromNumber(actual);
            mat[aux[0]][aux[1]] = ROAD;
            actual = parents[actual];
        }
        return mat;
    }

    public int getNumberFromCoordinate(int fil, int col) {
        return (fil * columnas) + col + 1;
    }

    public int[] getCoordinateFromNumber(int num) {
        int fil = div(num - 1, columnas);
        int col = (num - 1) % columnas;
        return new int[]{fil, col};
    }

    private int div(int numerator, int divisor) {
        int div = 0;
        while (numerator > divisor) {
            numerator -= divisor;
            div++;
        }
        return div;
    }

    private void markCoordinate(int num, int parent, int meta) {
        visited[num] = true;
        parents[num] = parent;
        if (num == meta) {
            toVisit = "";
        } else {
            newToVisit(num);
        }
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

    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS

}
