
package datos;

import java.util.ArrayList;


public class Grafo {
    
    private ArrayList<String> vertices;
     private int     dist[][];
     private int inf;


    public Grafo(int inf) {
        this.inf = inf;
        vertices = new ArrayList<>();
        dist= new int[100][100];    //El grafo va a tener una capacidad maxima de 90 vertices
        
        for (int i = 0; i < dist.length; i++) { //Inicializamos la matriz de distancia
            for (int j = 0; j < dist.length; j++) {
                if(i==j){
                    dist[i][j]=0;
                }else{
                    dist[i][j]=inf;
                }
            }
        }
        
    }

    public void addVertice(String ciudad){
        vertices.add(ciudad);
    }
    
    
    public String obtVertice(int pos) {
        return vertices.get(pos);
    }
    
    
    public void insArista(int vi, int vf, int costo) {
        dist[vi][vf] = costo;
        dist[vf][vi] = costo;
    }

    
    public void elimArista(int vi, int vf) {
        if (vi!=vf) {
            dist[vi][vf] = inf;
        }
    }

  
    public int obtArista(int vi, int vf) {
        return dist[vi][vf];
    }


    public int orden() {
        return vertices.size();
    }


    public ArrayList<String> sucesores(int v) {
        
        ArrayList<String> suc = new ArrayList<>();
        
        for (int i = 0; i < orden(); i++) {
            
            int arista = obtArista(i, v);
            
            if (v != i && arista != inf) {  //Comprobamos que no sea el mismo nodo y que el nodo no retorne un vetice que no tenga conexion
                suc.add(obtVertice(i));
            }
            
        }
        
        return suc;
    }
    
    public ArrayList<String> predecesores(int v){
        ArrayList<String> pre = new ArrayList<>();
        for (int i = 0; i < orden(); i++) {
            int arista = obtArista(v, i);
            if (v != i && arista != inf) {
                pre.add(obtVertice(i));
            }
        }
        return pre;
    
    } 
    

    /**
     * @return the matrizAdyacencia
     */
    public int[][] getMatrizAdyacencia() {
        return getDist();
    }

    /**
     * @return the vertices
     */
    public ArrayList<String> getVertices() {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(ArrayList<String> vertices) {
        this.vertices = vertices;
    }

    /**
     * @return the dist
     */
    public int[][] getDist() {
        return dist;
    }

    /**
     * @param dist the dist to set
     */
    public void setDist(int[][] dist) {
        this.dist = dist;
    }

    /**
     * @return the inf
     */
    public int getInf() {
        return inf;
    }

    /**
     * @param inf the inf to set
     */
    public void setInf(int inf) {
        this.inf = inf;
    }


    
    
}
