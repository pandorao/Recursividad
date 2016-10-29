
import java.util.ArrayList;
import java.util.LinkedList;


public class Graph {
    int vertices, aristas;
    boolean[][] adj;
    ArrayList<ArrayList<Integer>> adjl;

    public Graph(int Vertices, int Aristas) {
        this.vertices = Vertices;
        this.aristas = Aristas;
        adj = new boolean[Vertices + 1][Vertices + 1];
        adjl = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= Vertices; i++) {
            adjl.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int a, int b) {
        adj[a][b] = adj[b][a] = true;
        adjl.get(a).add(b);
        adjl.get(b).add(a);
    }

    //tipo del grafo: (pseudografo, multigrafo o simple)
    public int tipo() {
        for (int i = 1; i <= this.vertices; i++) {
            if (adj[i][i]) {
                return 1;
            }
        }
        for (int i = 1; i <= this.vertices; i++) {
            for (int v : adjl.get(i)) {
                if (adjl.get(i).indexOf(v) != adjl.get(i).lastIndexOf(v)) {
                    return 2;
                }
            }
        }
        return 0;
    }

    //maximo y minimo grado
    public int maxGrado() {
        int max = this.gradoL(1);
        for (int i = 2; i <= vertices; i++) {
            int grad = this.gradoL(i);
            if (max < grad) {
                max = grad;
            }
        }
        return max;
    }

    public int minGrado() {
        int min = this.gradoL(1);
        for (int i = 2; i <= vertices; i++) {
            int grad = this.gradoL(i);
            if (min > grad) {
                min = grad;
            }
        }
        return min;
    }

    //grado de un vertice
    public int grado(int v) {
        int cont = 0;
        for (int i = 1; i <= vertices; i++) {
            cont += adj[v][i] ? 1 : 0;
        }
        return cont;
    }

    public int gradoL(int v) {
        return adjl.get(v).size();
    }

    //mostrar matriz
    public void MostrarMatriz() {
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                System.out.print((adj[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public void MostrarMatrizAdjl() {
        for (int i = 0; i < adjl.size(); i++) {
            for (int j = 0; j < adjl.get(i).size(); j++) {
                System.out.print(adjl.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    boolean[] visitado;

    public void DFS(int v) {
        visitado[v] = true;
        for (int i = 1; i <= vertices; i++) {
            if (adj[v][i] && !visitado[i]) {
                DFS(i);
            }
        }
    }

    public void BFS() {
        visitado = new boolean[vertices + 1];
        LinkedList<Integer> cola = new LinkedList<Integer>();
        cola.add(1);
        visitado[1] = true;
        while (!cola.isEmpty()) {
            int ver = cola.poll();
            //System.out.println("Estoy en el vertice: "+ver);
            for (int i = 1; i <= vertices; ++i) {
                if (adj[ver][i] && !visitado[i]) {
                    visitado[i] = true;
                    cola.add(i);
                }
            }
        }
    }

    //verifica si es bipartido
    boolean[] visitado2;
    int[] bipartido;

    public boolean bipartidotest() {
        bipartido = new int[vertices + 1];
        visitado2 = new boolean[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            if (!visitado2[i]) {
                DFS_A(i);
            }
        }
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (adj[i][j] && (bipartido[i] == bipartido[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void DFS_A(int v) {
        visitado2[v] = true;
        bipartido[v] = 1;
        for (int i = 1; i <= vertices; i++) {
            if (adj[v][i] && !visitado2[i]) {
                DFS_B(i);
            }
        }
    }

    public void DFS_B(int v) {
        visitado2[v] = true;
        bipartido[v] = 2;
        for (int i = 1; i <= vertices; i++) {
            if (adj[v][i] && !visitado2[i]) {
                DFS_A(i);
            }
        }
    }

    //verifica si er r-regular
    public boolean esRegular() {
        int r = gradoL(1);
        for (int i = 2; i <= vertices; i++) {
            if (r != gradoL(i)) {
                return false;
            }
        }
        return true;
    }

    //verifica si es euleriano
    public boolean esEuleriano() {
        for (int i = 1; i <= vertices; i++) {
            if ((gradoL(i) % 2) != 0) {
                return false;
            }
        }
        return true;
    }

    //verifica si es conexo y su numero de componentes
    public boolean esconexo() {
        visitado = new boolean[vertices + 1];
        DFS(1);
        for (int i = 1; i <= vertices; i++) {
            if (!visitado[i]) {
                return false;
            }
        }
        return true;
    }

    // verifica si es arbol
    public boolean esArbol() {
        return esconexo() && aristas == vertices - 1;
    }

    public void puentes(ArrayList<Integer> puentes) {

        //ArrayList<String> puentes = new ArrayList<String>();
        boolean[][] adj_2;
        for (int i = 1; i <= vertices; i++) {
            adj_2 = adj;
            for (int j = 1; j <= vertices; j++) {
                if (adj_2[i][j]) {
                    adj_2[i][j] = false;
                    if (!esconexo(adj_2, vertices)) {
                        puentes.add(i);
                        puentes.add(j);
                    }
                    adj_2[i][j] = true;
                }
            }
        }
        if (puentes.size() > 0) {
            System.out.print("los puentes son:");
            for (int l = 0; l < puentes.size(); l = l + 2) {
                System.out.print(" " + puentes.get(l) + "-" + puentes.get(l + 1));
            }
            System.out.println("");
        } else {
            System.out.println("no hay puentes");
        }
    }

    public void puntosdecorte(ArrayList<Integer> PtoCorte) {

        //ArrayList<String> PtoCorte = new ArrayList<String>();
        boolean[][] array = new boolean[vertices + 1][vertices + 1];
        for (int i = 1; i <= vertices; i++) {

            for (int j = 1; j <= vertices; j++) {
                for (int k = 1; k <= vertices; k++) {
                    array[j][k] = adj[j][k];
                }
            }

            for (int j = 1; j <= vertices; j++) {
                for (int k = i; k < vertices; k++) {
                    array[j][k] = array[j][k + 1];
                }
            }

            for (int j = 1; j <= vertices; j++) {
                for (int k = i; k < vertices; k++) {
                    array[k][j] = array[k + 1][j];
                }
            }

            if (!esconexo(array, vertices - 1)) {
                PtoCorte.add(i);
            }
        }
        if (PtoCorte.size() > 0) {
            System.out.print("los vertices de corte son:");
            for (Integer pto : PtoCorte) {
                System.out.print(pto + " ");
            }
            System.out.println("");
        } else {
            System.out.println("no hay vertices de corte");
        }

    }

    public int componentes() {
        int cont = 0;
        visitado = new boolean[vertices + 1];
        for (int i = 1; i <= vertices; i++) {
            if (!visitado[i]) {
                DFS(i);
                cont++;
            }
        }
        return cont;
    }
    
    public void bloques() {
        ArrayList<Integer> PtoCorte = new ArrayList<>();
        ArrayList<Integer> puentes = new ArrayList<>();
        ArrayList<Integer> Eliminados = new ArrayList<>();
        ArrayList<String> Bloques = new ArrayList<>();
        puentes(puentes);
        puntosdecorte(PtoCorte);

        boolean[][] adj_2 = adj;
        int j;
        for (int i = 0; i < puentes.size(); i = i + 2) {
            j = i + 1;
            adj_2[puentes.get(i)][puentes.get(j)] = adj_2[puentes.get(j)][puentes.get(i)]=false;
            Bloques.add(puentes.get(i) + "-" + puentes.get(j));    
        }
        
        boolean sw;
        for (int i = 1; i <= vertices; i++) {
            sw=false;
            for (int k = 1; k <= vertices; k++) {
                if (adj_2[i][k]) {
                    sw=true;
                }
            }
            if (sw==false) {
                Eliminados.add(i);
            }
        }
       
        for (Integer elem : Eliminados ) {
                  
        }
//        System.out.print("eliminados: ");
//        for (Integer el : Eliminados) {
//            System.out.print(el + " // " );
//        }
//        System.out.println("");
        
        
        System.out.print("Tiene " +Bloques.size()+ " bloques los cuales son: ");
        for (String blq : Bloques) {
            System.out.print(blq + " // " );
        }
        System.out.println("");
    }
    
    public void DFS(int v,boolean adj_2, ArrayList<Integer> Eliminados){
        visitado[v] = true;
        
        
    }
            
    public void DFS(int v, boolean[][] adj_2, int vertice) {
        visitado[v] = true;
        for (int i = 1; i <= vertice; i++) {
            if (adj_2[v][i] && !visitado[i]) {
                DFS(i, adj_2, vertice);
            }
        }
    }
    
    

    public boolean esconexo(boolean[][] adj_2, int vertice) {
        visitado = new boolean[vertice + 1];
        DFS(1, adj_2, vertice);
        for (int i = 1; i <= vertice; i++) {
            if (!visitado[i]) {
                return false;
            }
        }
        return true;
    }
}
