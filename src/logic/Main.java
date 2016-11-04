package logic;

import javax.swing.JOptionPane;
import views.MainFrame;
import logic.Maze;

public class Main {

    public static void main(String[] args) {
        int filas, columnas, bloqueados;
        
        filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el numero de filas", "Configuracion", JOptionPane.PLAIN_MESSAGE));
        columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el numero de columnas", "Configuracion", JOptionPane.PLAIN_MESSAGE));
        bloqueados = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el numero de bloques bloqueados", "Configuracion", JOptionPane.PLAIN_MESSAGE));
        Maze maze = new Maze(filas, columnas, bloqueados);
        
        MainFrame mf = new MainFrame(maze);
        mf.setVisible(true);
    }
}
