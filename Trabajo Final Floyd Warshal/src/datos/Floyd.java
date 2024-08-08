
package datos;

import java.util.LinkedList;


public class Floyd {
    public Grafo grafo;
    public int f[][];
    public int r[][];
    public LinkedList<Integer> mrut = new LinkedList<>();
    public int n;
    
    
    public Floyd(Grafo grafo){
        this.grafo = grafo;
        int n= grafo.orden();
        f=new int[n][n];
        r=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j]= grafo.obtArista(i, j);
                r[i][j]= -1; // ruta que guarda las k
            }
        }
        cminimo();
    }
    
    
    //para hallar la menor ruta de un punto a otro 
    public void ruta(int i, int j){
        int k = r[i][j];
        if(k!=-1){
            ruta(i,k);
            mrut.add(k);
            ruta(k, j);
        }
    }
    
    public  void cminimo() {
        int n=grafo.orden();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    int costo= f[i][k]+f[k][j];
                    if(costo< f[i][j]){
                        f[i][j]=costo;
                        r[i][j]=k;
                    }
                }
            }
        }
    }
    public String solucion(){
        String lis="";
        for (int i = 0; i < grafo.orden(); i++) {
            for (int j = 0; j < grafo.orden(); j++) {
                lis+=" "+f[i][j];
            }
            lis+="\n";
        }
        return lis;
    }
    
        public String obtenerRuta(int inicio, int fin) {
        ruta(inicio, fin);
        String ruta = grafo.obtVertice(inicio);
        for (int i = 0; i < mrut.size(); i++) {
            ruta += " -> " + grafo.obtVertice(mrut.get(i));
        }
        ruta += " -> " + grafo.obtVertice(fin);
        return ruta;
    }
    
}