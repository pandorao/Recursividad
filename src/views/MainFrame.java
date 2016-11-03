package views;

import java.awt.Color;
import java.awt.Graphics;
import logic.Maze;

public class MainFrame extends javax.swing.JFrame {
    private final int IMAGE_SIZE = 45;
    private final Maze maze;
    private int[][] panelMatrix; 
    public MainFrame() {
        maze = new Maze();
        panelMatrix = maze.getMatrix();
        initComponents();
    }
    
    private void setVisualMaze(int[][] matrix){
        panelMatrix = matrix;
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
                g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
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
                            g.fillRect(IMAGE_SIZE * j, IMAGE_SIZE * i, IMAGE_SIZE, IMAGE_SIZE);
                            g.setColor(Color.BLACK);
                            g.drawRect(IMAGE_SIZE * j, IMAGE_SIZE * i, IMAGE_SIZE, IMAGE_SIZE);
                        }
                        g.setColor(Color.BLACK);
                        if(i == 0 && j > 0){
                            g.drawString("" + (j - 1), (IMAGE_SIZE * j) + (IMAGE_SIZE / 2) + 1, (IMAGE_SIZE * i) + (7 * IMAGE_SIZE / 8));
                        }
                        if(j == 0 && i > 0){
                            g.drawString("" + (i - 1), (IMAGE_SIZE * j) + (3 * IMAGE_SIZE / 4), (IMAGE_SIZE * i) + (IMAGE_SIZE / 2) + 1);
                        }
                    }
                }
            }
        }
        ;
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        jRadioButton1.setSelected(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jLabel1.setText("Coordenada De Partida:");

        jLabel2.setText("Coordenada De llegada:");

        jTextField2.setAutoscrolls(false);

        jButton1.setText("Generar Camino");

        jRadioButton1.setText("Version Iterativa");

        jRadioButton2.setText("Version Recursiva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addGap(36, 36, 36)
                                .addComponent(jButton1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton2)
                            .addComponent(jButton1))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
