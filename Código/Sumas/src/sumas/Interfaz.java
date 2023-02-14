//Martin Rilo - 236209
//Joaquin Calvo - 203832
package sumas;

import interfaz.RegistrarJugador;
import interfaz.MenuPrincipal;
import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {

    //Atributos
    private Sistema sistema;

    //Método Constructor
    public Interfaz() {
        sistema = new Sistema();
    }

    public static void main(String[] args) {
        Sistema miSistema = new Sistema();
        MenuPrincipal menu = new MenuPrincipal(miSistema);
        menu.setVisible(true);
    }
}
