package logic;

import javax.swing.JOptionPane;
import views.MainFrame;

public class Main {

    public static void main(String[] args) {
        String filas_s, columnas_s, bloqueados_s;
        int s, filas = 0, columnas = 0, bloqueados = 0;
        do {
            filas_s = JOptionPane.showInputDialog(null, "Escriba el numero de filas", "Configuracion", JOptionPane.PLAIN_MESSAGE);
            if (filas_s == null) {
                System.exit(0);
            }
            columnas_s = JOptionPane.showInputDialog(null, "Escriba el numero de columnas", "Configuracion", JOptionPane.PLAIN_MESSAGE);
            if (columnas_s == null) {
                System.exit(0);
            }
            bloqueados_s = JOptionPane.showInputDialog(null, "Escriba el numero de bloques bloqueados", "Configuracion", JOptionPane.PLAIN_MESSAGE);
            if (bloqueados_s == null) {
                System.exit(0);
            }
            s = ReceivedDataValidator.ValidateInput(filas_s, columnas_s, bloqueados_s);
            if (s != ReceivedDataValidator.VALIDATION_SUCCES) {
                JOptionPane.showMessageDialog(null, ReceivedDataValidator.getErrorDescription(s), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                filas = Integer.parseInt(filas_s);
                columnas = Integer.parseInt(columnas_s);
                bloqueados = Integer.parseInt(bloqueados_s);
            }
        } while (ReceivedDataValidator.VALIDATION_SUCCES != s);
        Maze maze = new Maze(filas, columnas, bloqueados);
        MainFrame mf = new MainFrame(maze);
        mf.setVisible(true);
    }
}
