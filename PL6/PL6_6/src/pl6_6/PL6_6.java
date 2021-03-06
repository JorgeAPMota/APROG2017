/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_6;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL6_6 {

    static Scanner input = new Scanner(System.in);

    /**
     * Calcula o volume da esfera
     *
     * @param raio Raio da esfera
     * @return Volume da esfera ou -1 se inseridos parâmetros negativos
     */
    public static double volumeEsfera(double raio) {
        final double PI = 3.14;
        if (raio < 0) {
            return -1;
        } else {
            return (4 / 3) * PI * Math.pow(raio, 3);
        }
    }

    /**
     * Calcula o volume do cilindro
     *
     * @param raioBase Raio da base do cilindro
     * @param altura Altura do cilindro
     * @return Volume do cilindro ou -1 se inseridos parâmetros negativos
     */
    public static double volumeCilindro(double raioBase, double altura) {
        final double PI = 3.14;
        if ((raioBase < 0) || (altura < 0)) {
            return -1;
        } else {
            return PI * Math.pow(raioBase, 2) * altura;
        }
    }

    /**
     * Calcula o volume do cone
     *
     * @param raioBase Raio da base do cone
     * @param altura Altura do cone
     * @return Volume do cone ou -1 se inseridos parâmetros negativos
     */
    public static double volumeCone(double raioBase, double altura) {
        final double PI = 3.14;
        if ((raioBase < 0) || (altura < 0)) {
            return -1;
        } else {
            return (1 / 3) * PI * Math.pow(raioBase, 3) * altura;
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int raio, altura;

        System.out.println("Qual o sólido cujo volume quer calcular?");
        String opcao = input.nextLine();

        while (!opcao.equalsIgnoreCase("fim")) {
            //Calculo do volume de uma esfera...
            if (opcao.equalsIgnoreCase("esfera")) {
                System.out.println("Insira o raio da esfera para calcular o respectivo volume");
                raio = input.nextInt();
                if (volumeEsfera(raio) < 0) {
                    System.out.println("Valor do raio inválido");
                } else {
                    System.out.println("Volume da esfera=" + volumeEsfera(raio));
                }
            }
            //Calculo do volume de uma cilindro...
            if (opcao.equalsIgnoreCase("cilindro")) {
                System.out.println("Insira o raio do cilindro para calcular o respectivo volume");
                raio = input.nextInt();
                System.out.println("Insira a altura do cilindro para calcular o respectivo volume");
                altura = input.nextInt();
                if (volumeCilindro(raio, altura) < 0) {
                    System.out.println("Valores introduzidos inválidos");
                } else {
                    System.out.println("Volume do cilindro=" + volumeCilindro(raio, altura));
                }
            }
            //Calculo do volume do cone...
            if (opcao.equalsIgnoreCase("cone")) {
                System.out.println("Insira o raio do cone para calcular o respectivo volume");
                raio = input.nextInt();
                System.out.println("Insira a altura do cone para calcular o respectivo volume");
                altura = input.nextInt();
                if (volumeCone(raio, altura) < 0) {
                    System.out.println("Valores introduzidos inválidos");
                } else {
                    System.out.println("Volume do cilindro=" + volumeCone(raio, altura));
                }

                System.out.println("Qual o tipo de sólido a calcular? (esfera, cilindro, cone ou fim)");
                opcao = input.nextLine();
            }

            System.out.println("Programa terminado.");
        }
    }
}
