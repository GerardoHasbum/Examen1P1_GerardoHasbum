/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_gerardohasbum;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ghasb
 */
public class Examen1P1_GerardoHasbum {

    static Scanner str = new Scanner(System.in);
    static Scanner jhin = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("*****MENU*****");
        System.out.println("1. Fight or Flight");
        System.out.println("2. Tri Fuerza");
        System.out.println("3. Salir");
        System.out.print("Ingrese la opcion que desee: ");
        int opcion = jhin.nextInt();//opcion decidida
        while (opcion > 0 && opcion < 3) {//ciclo de menu
            switch (opcion) {
                case 1://Fight or Flight
                    int ex_hit = 0;
                    System.out.println("*****FIGHT OR FLIGHT*****");
                    System.out.println("Ingrese su maestria del juego: ");
                    System.out.println("1. Principiante - 0% de hit extra");
                    System.out.println("2. Intermedio - 5% de hit extra");
                    System.out.println("3. Experto - 15% de hit extra");
                    int maestria = jhin.nextInt();
                    while (maestria != 1 && maestria != 2 && maestria != 3) {
                        System.out.println("Esa no es una opcion, porfavor ingresar uno de la lista: ");
                        maestria = jhin.nextInt();
                    }//validacion de la maestria
                    if (maestria == 1) {
                        ex_hit = 0;
                    } else if (maestria == 2) {
                        ex_hit = 5;
                    } else if (maestria == 3) {
                        ex_hit = 15;
                    }//porcentaje extra de golpe
                    int dis = 15 + ran.nextInt(16);
                    System.out.println("El zombie se encuentra a " + dis + " metros!");//distancia del zombie

                    int balas = 25;//balas iniciales
                    System.out.println();

                    int hit = 65;
                    int vida_zom = 25;//vida del zombie
                    char res_us = 's';
                    while (vida_zom > 0 && dis > 0 && balas > 0 && (res_us == 's' || res_us == 'S')) {//validacion para saber cuando terminar las rondas
                        int ran_hit = 1 + ran.nextInt(100);//dado para confirmar si mete golpe o no

                        if (ran_hit <= (hit + ex_hit)) {
                            int dmg = 1 + ran.nextInt(7);//dado para el dmg
                            System.out.println("El jugador cuenta con: " + balas + " balas!");
                            System.out.println();
                            System.out.println("Hit! El tiro ha reducido la vida del zombie por un total de: " + dmg + "!");
                            vida_zom -= dmg;
                            System.out.println();
                            if (vida_zom <= 0) {//validacion de vida del zombie
                                System.out.println("La vida restante del zombie es: 0");
                                System.out.println("YOU WIN! Haz logrado vencer al zombie");
                                break;//regresa al menu
                            } else {
                                System.out.println("La vida restante del zombie es: " + vida_zom);
                                System.out.println("El zombie se encuentra a: " + dis + " metros!");
                            }
                        } else {
                            int acerc = 3 + ran.nextInt(3);//dado para ver cuanto se acerca el zombie por ronda
                            dis -= acerc;
                            System.out.println("El jugador cuenta con: " + balas + " balas!");
                            System.out.println();
                            if (dis <= 0) {//validacion de la distancia del zombie
                                System.out.println("GAME OVER! La distancia se redujo a cero");
                                break;//regresa al menu
                            } else {
                                System.out.println("Ha fallado! El zombie se encuentra a: " + dis + " metros!");
                            }
                        }
                        balas--;
                        if (balas <= 0) {//validacion de las balas
                            System.out.println("GAME OVER! Se te acabaron las balas");
                            break;//regresa al menu
                        }
                        System.out.println();
                        System.out.println("Estas listo para la siguiente ronda? [s/n]: ");//validacion para ver si el jugador quiere seguir jugando
                        res_us = jhin.next().charAt(0);
                    }

                    break;//regresa al menu

                case 2://Tri Fuerza
                    link();
                    break;//regresa al menu
            }
            System.out.println("*****MENU*****");
            System.out.println("1. Fight or Flight");
            System.out.println("2. Tri Fuerza");
            System.out.println("3. Salir");
            System.out.print("Ingrese la opcion que desee: ");
            opcion = jhin.nextInt();//opcion decidida
        }
    }

    public static void link() {
        System.out.println("Ingrese un tamaño(tiene que ser par y mayor o igual que 20): ");
        int tam = jhin.nextInt();
        int check = tam / 2;
        if (tam < 20 || tam % 2 != 0 || check % 2 == 0) {//validacion para ver si el valor es mayor a 20, par y si su cociente cuando dividido entre dos es impar
            System.out.println("Ese tamaño no es valido");
            //regresa al menu
        } else {
            for (int i = 0; i < (tam / 2) + 1; i++) {
                for (int j = 0; j < tam + 1; j++) {
                    if (tam / 2 <= i + j && j <= i + tam / 2 && (i!=j && i+j!=tam) && !((i>=tam/4+1)&& j>=i && j+i<=tam)) {//validacion para colocar asteriscos en los triangulos
                        System.out.print("*");
                    } else if (i == tam / 2 && j != tam / 2 && tam / 2 <= i + j && j <= i + tam / 2 && i+1!=j && i+1+j!=tam-1) {//validacion para las lineas diagonales vacias
                        System.out.print("*");
                    } 
                        else {
                        System.out.print(" ");
                    }
                }//fin for interno
                System.out.println();
            }//fin for externo
        }
        System.out.println();
    }//fin link

}//fin public class
