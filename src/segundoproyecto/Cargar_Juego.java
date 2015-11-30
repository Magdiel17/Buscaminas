/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoproyecto;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author MAGDIEL
 */
public class Cargar_Juego {

    String[][] matriz_minas;//Matriz que guarda las minas
    int cont;// maneja el contador que se utilza para saber cuantas minas hay
    int tamañoTablero;// variable que guarda las coordenadas que tenga el tablero

    /**
     * Metodo para ingresar el parametro del tablero
     *
     * @return
     */
    public String[][] ingreso_minas() {
        tamañoTablero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño que quire que tenga el tablero"));//Variable que guarda el tamaño del tablero que el usuario quiere por medio de un JOptionPane
        matriz_minas = new String[tamañoTablero][tamañoTablero];
        llena_matriz_minas(tamañoTablero);
        return matriz_minas;
    }
//Primeramente se llenan la matriz con las minas
/**
 * metodo que llena la matriz con minas
 * @param tam 
 */
    private void llena_matriz_minas(int tam) {
        for (int i = 0; i < matriz_minas.length; i++) {
            for (int j = 0; j < matriz_minas.length; j++) {
                //System.out.println(random(tam));
                if (random(tam) == i) {
                    matriz_minas[i][j] = "*";
                }
            }
        }

        //imprimir_matriz();
        cargarNumero();

    }
/**
 * Carga los numeros alrededor de las bombas
 */
    private void cargarNumero() {
        for (int i = 0; i < matriz_minas.length; i++) {
            for (int j = 0; j < matriz_minas.length; j++) {
                llena_numero_matriz_minas(i, j);
            }
        }
        //System.out.println();
        //imprimir_matriz();
    }

    //Luego se llenan los campos que no tinenen minas, con los números correspondientes a la cantidad de minas cerca
    //de ellos
/**
 * metodo que llena la matriz con numeros segundo cuantas bombas tenga el tablero
 * @param fila
 * @param columna 
 */
    private void llena_numero_matriz_minas(int fila, int columna) {
        cont = 0;
        if ((fila == 0 && columna == 0) || (fila == tamañoTablero - 1 && columna == tamañoTablero - 1)) {
            ingresoEsquinaIguales(fila, columna);
        } else if ((fila == 0 && columna == tamañoTablero - 1) || (fila == tamañoTablero - 1 && columna == 0)) {
            ingresoEsquinasDiferentes(fila, columna);
        } else if ((fila == 0 && columna != tamañoTablero - 1 && columna != 0) || (fila == tamañoTablero - 1 && columna != tamañoTablero - 1 && columna != 0)) {
            ingresoLadosArribaAbajo(fila, columna);
        } else if ((columna == 0 && fila != tamañoTablero - 1 && fila != 0) || (columna == tamañoTablero - 1 && fila != tamañoTablero - 1 && fila != 0)) {
            ingresoLadosDerechoIzquierdo(fila, columna);
        } else if (fila != 0 && columna != 0) {
            ingresoCentros(fila, columna);
        }
    }
/**
 * Compara las esquinas de la matriz para saber si hay minas
 * @param fila
 * @param columna 
 */
    private void ingresoEsquinaIguales(int fila, int columna) {
        if (!"*".equals(matriz_minas[fila][columna])) {
            if (fila == 0 && columna == 0) {

                if ("*".equals(matriz_minas[fila][columna + 1])) { //1
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna + 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }

            } else if (fila == tamañoTablero - 1 && columna == tamañoTablero - 1) {

                if ("*".equals(matriz_minas[fila - 1][columna])) {//1
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna - 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna - 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            }
        }
    }
/**
 * metodo que valida si las esquinas tiene bombas
 * @param fila
 * @param columna 
 */
    private void ingresoEsquinasDiferentes(int fila, int columna) {
        if (!"*".equals(matriz_minas[fila][columna])) {
            if (fila == 0 && columna == tamañoTablero - 1) {

                if ("*".equals(matriz_minas[fila][columna - 1])) { //1
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }

            } else if (fila == tamañoTablero - 1 && columna == 0) {

                if ("*".equals(matriz_minas[fila - 1][columna])) {//1
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            }
        }
    }
/**
 * metodo que pregunta si los campos de arriba de la matriz tiene minas
 * @param fila
 * @param columna 
 */
    private void ingresoLadosArribaAbajo(int fila, int columna) {
        if (!"*".equals(matriz_minas[fila][columna])) {
            if (fila == 0 && columna != tamañoTablero - 1 && columna != 0) {
                if ("*".equals(matriz_minas[fila][columna + 1])) {//1
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna + 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) {//3
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) {//5
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }

            } else if (fila == tamañoTablero - 1 && columna != tamañoTablero - 1 && columna != 0) {

                if ("*".equals(matriz_minas[fila][columna - 1])) {//1
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna - 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna])) {//3
                            cont++;
                            if ("*".equals(matriz_minas[fila - 1][columna - 1])) {//4
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna - 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna])) {//3
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna + 1])) {//5
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            }
        }
    }

    private void ingresoLadosDerechoIzquierdo(int fila, int columna) {
        if (!"*".equals(matriz_minas[fila][columna])) {
            if (columna == 0 && fila != tamañoTablero - 1 && fila != 0) {
                if ("*".equals(matriz_minas[fila + 1][columna])) {//1
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna + 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                            cont++;
                            if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                                cont++;
                                if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna + 1])) {//3
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) {//4
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna])) {//5
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
    //Fin de la primera condicional
                //Inicio de la segunda condicional
            } else if (columna == tamañoTablero - 1 && fila != tamañoTablero - 1 && fila != 0) {

                if ("*".equals(matriz_minas[fila - 1][columna])) {//1
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna - 1])) {//2
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                                cont++;
                                if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila - 1][columna - 1])) {//2
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) {//3
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) {//4
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) {//5
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            }
        }
    }

    private void ingresoCentros(int fila, int columna) {
        if (!"*".equals(matriz_minas[fila][columna])) {
            if ("*".equals(matriz_minas[fila - 1][columna - 1])) { //1
                cont++;
                if ("*".equals(matriz_minas[fila - 1][columna])) { //2
                    cont++;
                    if ("*".equals(matriz_minas[fila - 1][columna + 1])) { //3
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                                cont++;
                                if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                                    cont++;
                                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                        cont++;
                                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                            cont++;
                                            matriz_minas[fila][columna] = String.valueOf(cont);
                                        } else {
                                            matriz_minas[fila][columna] = String.valueOf(cont);
                                        }
                                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                        cont++;
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    } else {
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    }
                                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                    cont++;
                                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                        cont++;
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    } else {
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    }
                                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                                cont++;
                                if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                    cont++;
                                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                        cont++;
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    } else {
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    }
                                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                                cont++;
                                if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                    cont++;
                                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                        cont++;
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    } else {
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    }
                                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                                cont++;
                                if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                    cont++;
                                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                        cont++;
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    } else {
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    }
                                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                    ///////////////////////////////////////////////////////////////////7777777
                } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) { //3
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                                cont++;
                                if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                    cont++;
                                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                        cont++;
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    } else {
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    }
                                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            } else if ("*".equals(matriz_minas[fila - 1][columna])) { //2
                cont++;
                if ("*".equals(matriz_minas[fila - 1][columna + 1])) { //3
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                                cont++;
                                if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                    cont++;
                                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                        cont++;
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    } else {
                                        matriz_minas[fila][columna] = String.valueOf(cont);
                                    }
                                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
                ///////////////////////////////////////////////////////////////////7777777
            } else if ("*".equals(matriz_minas[fila - 1][columna + 1])) { //3
                cont++;
                if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                            cont++;
                            if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                                cont++;
                                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                    cont++;
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                } else {
                                    matriz_minas[fila][columna] = String.valueOf(cont);
                                }
                            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            } else if ("*".equals(matriz_minas[fila][columna + 1])) { //4
                cont++;
                if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                        cont++;
                        if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                            cont++;
                            if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                                cont++;
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            } else {
                                matriz_minas[fila][columna] = String.valueOf(cont);
                            }
                        } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            } else if ("*".equals(matriz_minas[fila + 1][columna + 1])) { //5
                cont++;
                if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                    cont++;
                    if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                        cont++;
                        if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                            cont++;
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        } else {
                            matriz_minas[fila][columna] = String.valueOf(cont);
                        }
                    } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            } else if ("*".equals(matriz_minas[fila + 1][columna])) { //6
                cont++;
                if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                    cont++;
                    if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                        cont++;
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    } else {
                        matriz_minas[fila][columna] = String.valueOf(cont);
                    }
                } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            } else if ("*".equals(matriz_minas[fila + 1][columna - 1])) { //7
                cont++;
                if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                    cont++;
                    matriz_minas[fila][columna] = String.valueOf(cont);
                } else {
                    matriz_minas[fila][columna] = String.valueOf(cont);
                }
            } else if ("*".equals(matriz_minas[fila][columna - 1])) { //8
                cont++;
                matriz_minas[fila][columna] = String.valueOf(cont);
            } else {
                matriz_minas[fila][columna] = String.valueOf(cont);
            }
        }
    }
/**
 * Metodo que imprime la matriz con las bombas aqui se pueden ver las minas
 */
    private void imprimir_matriz() {
        //Impresion de prueba
        for (int i = 0; i < matriz_minas.length; i++) {
            System.out.println();
            for (int j = 0; j < matriz_minas.length; j++) {
                System.out.print(matriz_minas[i][j] + " ");
            }
        }
    }

    /**
     * Metodo que genera aleatoriamente las minas
     *
     * @param tamaño
     * @return
     */
    private int random(int tamaño) {
        return (int) (Math.random() * (tamaño - 0) + 0);
    }
}
