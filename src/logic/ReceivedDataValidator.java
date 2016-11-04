package logic;

public class ReceivedDataValidator {

    public static final int VALIDATION_SUCCES = 0;
    public static final int ERROR_NOT_NUMBER = 1;
    public static final int ERROR_OUT_OF_MAZE_LIMITS = 2;
    public static final int ERROR_IS_BLOCK = 3;
    public static final int ERROR_SAME_POINTS = 4;
    public static final int ERROR_SIZE_MAZE = 5;
    public static final int ERROR_LOCKED_BLOCKS = 6;

    public static int validateCoordinatesInput(String sInitFil, String sInitCol, String sMetFil, String sMetCol, Maze maze) {
        try {
            int initFil = Integer.parseInt(sInitFil);
            int initCol = Integer.parseInt(sInitCol);
            int metFil = Integer.parseInt(sMetFil);
            int metCol = Integer.parseInt(sMetCol);
            int numInit = maze.getNumberFromCoordinate(initFil, initCol);
            int numMet = maze.getNumberFromCoordinate(metFil, metCol);
            if (initFil < 0 || initFil >= maze.getFilas() || metFil < 0 || metFil >= maze.getFilas() || initCol < 0 || initCol >= maze.getColumnas() || metCol < 0 || metCol >= maze.getColumnas()) {
                return ERROR_OUT_OF_MAZE_LIMITS;
            }
            if (maze.isBlock(numInit) || maze.isBlock(numMet)) {
                return ERROR_IS_BLOCK;
            }
            if (numInit == numMet) {
                return ERROR_SAME_POINTS;
            }
            return VALIDATION_SUCCES;
        } catch (Exception e) {
            return ERROR_NOT_NUMBER;
        }
    }

    public static int ValidateInput(String filas, String columnas, String Bloqueados) {
        int column, fil, bloq;
        try {
            fil = Integer.parseInt(filas);
            column = Integer.parseInt(columnas);
            bloq = Integer.parseInt(Bloqueados);
            if (fil < 5 || fil > 20 || column < 5 || column > 20) {
                return ERROR_SIZE_MAZE;
            }
            if (bloq>(fil*column)/2) {
                return ERROR_LOCKED_BLOCKS;
            }
            return VALIDATION_SUCCES;
        } catch (Exception e) {
            return ERROR_NOT_NUMBER;
        }
    }

    public static String getErrorDescription(int x) {
        switch (x) {
            case ERROR_NOT_NUMBER:
                return "Solo debe escribir numeros";
            case ERROR_IS_BLOCK:
                return "Las coordenadas deben representar un espacio vacio, no un bloque";
            case ERROR_OUT_OF_MAZE_LIMITS:
                return "Las coordenadas no pertenecen al laberinto";
            case ERROR_SAME_POINTS:
                return "Las coordenadas deben ser de casillas diferentes";
            case ERROR_LOCKED_BLOCKS:
                return "Sobrepaso el limite de bloques bloqueados";
            case ERROR_SIZE_MAZE:
                return "Error en el tamaño del laberinto";
            default:
                return "Error desconocido";
        }
    }
}
