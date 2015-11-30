/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoproyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author MAGDIEL
 */
public class Jugar {
    String [][] matriz, matrizMostrar;//Matriz que se muestra en el juego no tiene las bombas hasta que se compare con la que tiene bombas

    /**
     *Metodo en donde se inicia el juego
     */
    public void jugar(){
        Cargar_Juego cargar = new Cargar_Juego();
        matrizMostrar=matriz=cargar.ingreso_minas();
        mostrarMatrizVacia();
        
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la pocision de la columna"));//Variable que guarda la cantidad de columnas que el usuario quiere por medio de un JOptionPane
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la pocision de la fila"));//Variable que guarda la cantidad de filas que el usuario quiere por medio de un JOptionPane
    
    }
    /**
     * metodo que muestra la matriz con las Bombas ocultas
     */
    private void mostrarMatrizVacia() {
        for (int i = 0; i < matrizMostrar.length; i++) {
            System.out.println();
            for (int j = 0; j < matrizMostrar.length; j++) {
                matrizMostrar[i][j] = "+";
          System.out.print(matrizMostrar[i][j] = "");
             
            }
        }
    }
}
