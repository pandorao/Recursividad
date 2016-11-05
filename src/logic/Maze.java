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
        matrix = new int[filas][columnas];
        int i = 0;
        ConstructorMaze(i, bloqueados / 2, filas / 2);
        i = filas / 2;
        if (bloqueados % 2 != 0) {
            ConstructorMaze(i, bloqueados / 2 + 1, filas);
        } else {
            ConstructorMaze(i, bloqueados / 2, filas);
        }
    }

    private void ConstructorMaze(int i, int bloq, int filas) {
        int cont = 1, j = 0, num;
        while (cont <= bloq) {
            while (i < filas && cont <= bloq) {
                while (j < columnas && cont <= bloq) {
                    num = (int) (Math.random() * 2 + 0);
                    if (matrix[i][j] != 1 && num == 1) {
                        matrix[i][j] = num;
                        cont++;
                    }
                    j++;
                }
                j = 0;
                i++;
            }
            i = 0;
            j = 0;
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
        int[][] mat = copyMat(matrix);
        assignParents(ini, meta);
        int actual = meta;
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

    private int[][] copyMat(int[][] mat) {
        int fil = mat.length;
        int col = mat[0].length;
        int[][] ret = new int[fil][col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                ret[i][j] = mat[i][j];
            }
        }
        return ret;
    }

    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //METODOS PARA CAMINO MAS CORTO ITERATIVOS
    //----------------------------------------
    //METODO PARA CAMINO MAS CORTO RECURSIVO
    //METODO PARA CAMINO MAS CORTO RECURSIVO
    //METODO PARA CAMINO MAS CORTO RECURSIVO
    private void assingParentsInit_R(int ini, int meta) {
        toVisit = "";
        visited = new boolean[filas * columnas + 1];
        parents = new int[filas * columnas + 1];
        newToVisit(ini);
        visited[ini] = true;
        assignParents_R(meta);
    }

    private void assignParents_R(int meta) {// el metodo recibe como argumentos la version numerica de las coordenada de la casilla inicial y la casilla final, para obtener la version umerica de una coordenada se usa el metodo getNumberFromCoordinate
        if (!toVisit.equals("")) {
            int actual = getFirstToVisitAndRemove_R();
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
            assignParents_R(meta);
        }
    }

    public int[][] getShortestRoadIntoMatrix_R(int ini, int meta) {// el metodo recibe como argumentos la version numerica de las coordenada de la casilla inicial y la casilla final, para obtener la version umerica de una coordenada se usa el metodo getNumberFromCoordinate
        int[][] mat = new int[matrix.length][matrix[0].length];
        copyMat_Ri(matrix, matrix.length, matrix[0].length, 0, 0, mat);
        assingParentsInit_R(ini, meta);
        int actual = meta;
        int[] aux = null;
        if (parents[meta] != 0) {
            getShortestRoadIntoMatrix_R(mat, aux, actual, ini);
            aux = getCoordinateFromNumber_R(ini);
            mat[aux[0]][aux[1]] = ROAD;
        } else {
            return null;
        }
        return mat;
    }

    private void getShortestRoadIntoMatrix_R(int[][] mat, int[] aux, int actual, int ini) {
        aux = getCoordinateFromNumber(actual);
        mat[aux[0]][aux[1]] = ROAD;
        actual = parents[actual];
        if (actual != ini) {
            getShortestRoadIntoMatrix_R(mat, aux, actual, ini);
        }
    }

    public int[] getCoordinateFromNumber_R(int num) {
        int fil = div_R(num, columnas, 0);
        int col = (num - 1) % columnas;
        return new int[]{fil, col};
    }

    private int div_R(int numerator, int divisor, int div) {
        if (numerator > divisor) {
            numerator -= divisor;
            div++;
            return div_R(numerator, divisor, div);
        } else {
            return div;
        }
    }

    private void copyMat_Ri(int[][] matri, int fil, int col, int i, int j, int[][] mat) {
        if (i < fil) {
            j = 0;
            copyMat_Rj(matri, col, i, j, mat);
            i++;
            copyMat_Ri(matri, fil, col, i, j, mat);
        }
    }

    private void copyMat_Rj(int[][] matri, int col, int i, int j, int[][] mat) {
        if (j < col) {
            mat[i][j] = matri[i][j];
            j++;
            copyMat_Rj(matri, col, i, j, mat);
        }
    }
    
        private int getFirstToVisitAndRemove_R() {
        int aux = indexOf_R(toVisit, ",", toVisit.length(), 0);
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
        
    private int indexOf_R(String s, String c, int len, int i) {
        if (i < len) {
            if (s.substring(i, i + 1).equals(c)) {
                return i;
            }
            i++;
            return indexOf_R(s, c, len, i);
        }
        return -1;
    }
    //METODO PARA CAMINO MAS CORTO RECURSIVO
    //METODO PARA CAMINO MAS CORTO RECURSIVO
    //METODO PARA CAMINO MAS CORTO RECURSIVO
}
