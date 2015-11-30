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
public class SegundoProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opc = 0;
        opc=Integer.parseInt(JOptionPane.showInputDialog(" Elija una opcion \n1-Jugar\n2-Salir "));
        switch (opc) {
            case 1:
                Jugar nuevoJuego = new Jugar();
                nuevoJuego.jugar();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Gracias por jugar.");
                break;

            default:
                System.out.println("No es una Opción");
                break;
        }
    }
}
