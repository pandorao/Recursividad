package views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import logic.Maze;
import logic.ReceivedDataValidator;

public class MainFrame extends javax.swing.JFrame {

    private Maze maze;
    private int boxSize;
    private int[][] panelMatrix;

    public MainFrame(Maze maze) {
        this.maze = maze;
        panelMatrix = maze.getMatrix();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        int aux;
        if (maze.getFilas() > maze.getColumnas()) {
            aux = maze.getFilas();
        } else {
            aux = maze.getColumnas();
        }
        boxSize = (331 * aux * aux / 3432) - (6373 * aux / 1144) + (43090 / 429);// ecuacion que define el tamaño de cada casilla dependiendo del mayor entre las filas y las columnas del laberinto
        // valores con los que se hizo la regresion cuadratica para hallar la ecuacion
        //75 = 5
        //36 = 16
        //29 = 20
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 =
        new javax.swing.JPanel(){
            public void paint(Graphics g){
                int filas = panelMatrix.length;
                int columnas = panelMatrix[0].length;
                g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
                for (int i = 0; i < filas + 1; i++) {
                    for (int j = 0; j < columnas + 1; j++) {
                        if(i > 0 && j > 0){
                            switch (panelMatrix[i - 1][j - 1]) {
                                case Maze.BLOCK:
                                g.setColor(Color.RED);
                                break;
                                case Maze.VACUUM:
                                g.setColor(Color.WHITE);
                                break;
                                case Maze.ROAD:
                                g.setColor(Color.GREEN);
                                break;
                            }
                            g.fillRect(boxSize * j, boxSize * i, boxSize, boxSize);
                            g.setColor(Color.BLACK);
                            g.drawRect(boxSize * j, boxSize * i, boxSize, boxSize);
                        }
                        g.setColor(Color.BLACK);
                        if(i == 0 && j > 0){
                            g.drawString("" + (j - 1), (boxSize * j) + (boxSize / 2) + 1, (boxSize * i) + (7 * boxSize / 8));
                        }
                        if(j == 0 && i > 0){
                            g.drawString("" + (i - 1), (boxSize * j) + (boxSize / 2), (boxSize * i) + (boxSize / 2) + 1);
                        }
                    }
                }
            }
        }
        ;
        txtFldInitFil = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFldMetFil = new javax.swing.JTextField();
        btnGetRoad = new javax.swing.JButton();
        RBtton_iterativo = new javax.swing.JRadioButton();
        RBtton_recursivo = new javax.swing.JRadioButton();
        buttonGroup1.add(RBtton_iterativo);
        buttonGroup1.add(RBtton_recursivo);
        RBtton_iterativo.setSelected(true);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFldInitCol = new javax.swing.JTextField();
        txtFldMetCol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jLabel1.setText("Coordenada De Partida:");

        jLabel2.setText("Coordenada De llegada:");

        txtFldMetFil.setAutoscrolls(false);

        btnGetRoad.setText("Generar Camino");
        btnGetRoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetRoadActionPerformed(evt);
            }
        });

        RBtton_iterativo.setText("Version Iterativa");

        RBtton_recursivo.setText("Version Recursiva");

        jLabel3.setText("Fila:");

        jLabel4.setText("Fila:");

        jLabel5.setText("Columna:");

        jLabel6.setText("Columna:");

        txtFldMetCol.setAutoscrolls(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFldMetFil, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(txtFldInitFil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFldMetCol)
                            .addComponent(txtFldInitCol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBtton_iterativo)
                            .addComponent(RBtton_recursivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGetRoad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RBtton_iterativo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RBtton_recursivo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFldInitCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFldMetCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFldInitFil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtFldMetFil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnGetRoad)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetRoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetRoadActionPerformed
        Long t = System.nanoTime();
//        Long t = System.currentTimeMillis();

        int aux = ReceivedDataValidator.validateCoordinatesInput(txtFldInitFil.getText(), txtFldInitCol.getText(), txtFldMetFil.getText(), txtFldMetCol.getText(), maze);
        if (aux == ReceivedDataValidator.VALIDATION_SUCCES) {
            int initFil = Integer.parseInt(txtFldInitFil.getText());
            int initCol = Integer.parseInt(txtFldInitCol.getText());
            int metFil = Integer.parseInt(txtFldMetFil.getText());
            int metCol = Integer.parseInt(txtFldMetCol.getText());
            int initNum = maze.getNumberFromCoordinate(initFil, initCol);
            int metNum = maze.getNumberFromCoordinate(metFil, metCol);
            panelMatrix = maze.getMatrix();
            jPanel1.update(jPanel1.getGraphics());
            if (RBtton_iterativo.isSelected()) {
                panelMatrix = maze.getShortestRoadIntoMatrix(initNum, metNum);
            } else {
                panelMatrix = maze.getShortestRoadIntoMatrix_R(initNum, metNum);
            }
            if (panelMatrix == null) {
                JOptionPane.showMessageDialog(null, "No existe ningun camino que una estas casillas", "", JOptionPane.PLAIN_MESSAGE);
            } else {
                jPanel1.update(jPanel1.getGraphics());
            }
        } else {
            JOptionPane.showMessageDialog(null, ReceivedDataValidator.getErrorDescription(aux), "", JOptionPane.ERROR_MESSAGE);
        }

//        t = System.currentTimeMillis() - t;
//        double c = (double)t * 0.001;
//        System.out.println(t);
        t = System.nanoTime() - t;
        double c = (double) t * 0.000000001;
        System.out.println(c);

        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        double mem = ((double) memory / (1024 * 1024));
        System.out.println("Used memory is megabytes: " + mem);

    }//GEN-LAST:event_btnGetRoadActionPerformed
    public static double bytesToMegabytes(long bytes) {
        return ((double) (bytes)) / (1024 * 1024);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBtton_iterativo;
    private javax.swing.JRadioButton RBtton_recursivo;
    private javax.swing.JButton btnGetRoad;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFldInitCol;
    private javax.swing.JTextField txtFldInitFil;
    private javax.swing.JTextField txtFldMetCol;
    private javax.swing.JTextField txtFldMetFil;
    // End of variables declaration//GEN-END:variables
}
