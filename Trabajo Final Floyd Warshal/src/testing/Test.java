
package testing;

import datos.*;

public class Test {
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo(9999);
        
        grafo.addVertice("Atlantico");//0
        grafo.addVertice("Magdalena");//1
        grafo.addVertice("Cordoba");  //2
        grafo.addVertice("Sucre");    //3        
        grafo.addVertice("Bolivar");  //5
        grafo.addVertice("Norte De Santander");    //6
        grafo.addVertice("La Guajira");    //7
        
        grafo.insArista(0, 1, 3);
        grafo.insArista(0, 3, 2);
        grafo.insArista(1, 7, 3);
        grafo.insArista(1, 4, 1);
        grafo.insArista(2, 3, 2);
        grafo.insArista(3, 5, 3);
        grafo.insArista(4, 6, 2);
        grafo.insArista(5, 1, 2);
        
        
        
        Floyd floydWarshall = new Floyd(grafo);
        
        System.out.println("");
        System.out.println(floydWarshall.solucion());

        System.out.println("");
        System.out.println(floydWarshall.obtenerRuta(0, 2));
    }
    
    
    
}
