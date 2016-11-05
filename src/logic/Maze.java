package logic;

public class Maze {

    private final int[][] matrix;
    public static final int VACUUM = 0;
    public static final int BLOCK = 1;
    public static final int ROAD = 2;
    private int filas;
    private int columnas;
    private String toVisit;
    private boolean[] visited;
    private int[] parents;

    public Maze() {
        matrix = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}
        };

//        matrix = new int[][]{
//            {0, 0, 0, 0, 0},
//            {1, 1, 1, 1, 1},
//            {0, 0, 0, 1, 0},
//            {0, 1, 0, 1, 0},
//            {0, 1, 0, 0, 0},
//            {0, 1, 1, 1, 1},
//            {0, 0, 0, 0, 1},
//            {1, 1, 0, 0, 0}
//        };
//        matrix = new int[][]{
//            {0, 0, 0, 0, 0},
//            {1, 1, 1, 1, 1},
//            {0, 0, 0, 1, 0},
//            {0, 1, 0, 1, 0},
//            {0, 1, 0, 0, 0},
//            {0, 1, 1, 1, 1},
//            {0, 0, 0, 0, 1},
//            {1, 1, 0, 0, 0},
//            {0, 1, 0, 0, 0},
//            {0, 1, 1, 1, 1},
//            {0, 0, 0, 0, 1},
//            {1, 1, 0, 0, 0}
//        };
//        matrix = new int[][]{
//            {0, 0, 0, 0, 0},
//            {1, 1, 1, 1, 1},
//            {0, 0, 0, 1, 0},
//            {0, 1, 0, 1, 0},
//            {0, 1, 0, 0, 0}
//        };
//        matrix = new int[][]{
//            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0},
//            {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
//            {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0},
//            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0},
//            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0},
//            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
//            {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0},
//            {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
//            {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0},
//            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0},
//            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0},
//            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0},
//            {1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
//            {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0},
//            {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0}
//        };

        this.filas = matrix.length;
        this.columnas = matrix[0].length;
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
    private boolean isBetweenLimits(int son, int parent) {
        if (son > 0 && son <= filas * columnas) {
            if (parent % columnas == 0 && son == parent + 1) {
                return false;
            }
            if (parent % columnas == 1 && son == parent - 1) {
                return false;
            }
            return true;
        }
        return false;
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
            int actual = getFirstToVisitAndRemove();
            int aux = actual + columnas;
            if (isBetweenLimits(aux, actual) && !visited[aux] && !isBlock(aux)) {
                markCoordinate(aux, actual, meta);
            }
            aux = actual - 1;
            if (isBetweenLimits(aux, actual) && !visited[aux] && !isBlock(aux)) {
                markCoordinate(aux, actual, meta);
            }
            aux = actual + 1;
            if (isBetweenLimits(aux, actual) && !visited[aux] && !isBlock(aux)) {
                markCoordinate(aux, actual, meta);
            }
            aux = actual - columnas;
            if (isBetweenLimits(aux, actual) && !visited[aux] && !isBlock(aux)) {
                markCoordinate(aux, actual, meta);
            }
        }
    }

    public int[][] getShortestRoadIntoMatrix(int ini, int meta) {// el metodo recibe como argumentos la version numerica de las coordenada de la casilla inicial y la casilla final, para obtener la version umerica de una coordenada se usa el metodo getNumberFromCoordinate
        int[][] mat = matrix;
        assignParents(ini, meta);
        int actual = meta;
//        int[] aux = getCoordinateFromNumber(actual);
//        mat[aux[0]][aux[1]] = ROAD;
//        actual = parents[actual];
        int[] aux;
        if (parents[meta] != 0) {
            do {
                aux = getCoordinateFromNumber(actual);
                mat[aux[0]][aux[1]] = ROAD;
                actual = parents[actual];
            } while (actual != ini);
            aux = getCoordinateFromNumber(actual);
            mat[aux[0]][aux[1]] = ROAD;
        } else {
            return null;
        }
        return mat;
    }

    public int getNumberFromCoordinate(int fil, int col) {
        return (fil * columnas) + col + 1;
    }

    public int[] getCoordinateFromNumber(int num) {
        int fil = div(num, columnas);
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

    private void markCoordinate(int son, int parent, int meta) {
        visited[son] = true;
        parents[son] = parent;
        if (son == meta) {
            toVisit = "";
        } else {
            newToVisit(son);
        }
    }

    private void newToVisit(int newToVisit) {
        if (toVisit.equals("")) {
            toVisit += "" + newToVisit;
        } else {
            toVisit += "," + newToVisit;
        }
    }

    private int getFirstToVisitAndRemove() {
        int aux = indexOf(toVisit, ",");
        int ret;
        String s;
        if (aux == -1) {
            s = toVisit.substring(0);
            ret = Integer.parseInt(s);
            toVisit = "";
        } else {
            s = toVisit.substring(0, aux);
            ret = Integer.parseInt(s);
            toVisit = toVisit.substring(aux + 1);
        }
        return ret;
    }

    private int indexOf(String s, String c) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.substring(i, i + 1).equals(c)) {
                return i;
            }
        }
        return -1;
    }

    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
}
