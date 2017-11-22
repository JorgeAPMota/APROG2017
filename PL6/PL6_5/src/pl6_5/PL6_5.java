/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_5;

import java.util.Scanner;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL6_5 {

    static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int limite, n1, n2, par1 = 0, par2 = 0, maximo = 0;

        do {
            System.out.println("Insira o limite");
            limite = input.nextInt();
        } while (limite < 1);

        do {
            do {
                System.out.println("Insira 1º num");
                n1 = input.nextInt();
            } while (n1 <= 0);

            do {
                System.out.println("Insira 2º num");
                n2 = input.nextInt();
            } while (n2 <= 0);

            if (digComuns(n1, n2) > maximo) {
                maximo = digComuns(n1, n2);
                par1 = n1;
                par2 = n2;
            }

            limite--;
        } while (limite != 0);

        if (maximo == 0) {
            System.out.println("Não foram inseridos números com dígitos comuns");
        } else {
            System.out.println("Par {" + par1 + ", " + par2 + "} com " + maximo + " digitos comuns.");
        }

    }


    /**a) Faça um módulo que dados dois números inteiros positivos 
     * retorne a quantidade de dígitos comuns nas mesmas posições.
     * @param args the command line arguments
     * @param numA - 1º par
     * @param numB - 2º par
     */
    private static int digComuns(int numA, int numB) {
        int dig1A, dig1B, quantDigComuns = 0;

        if ((numA <= 0) || (numB <= 0)) {
            return -1;
        } else {
            do {
                if ((numA % 10) == (numB % 10)) {
                    quantDigComuns++;
                }
                numA /= 10;
                numB /= 10;
            } while ((numA > 0) && (numB > 0));

        }
        return quantDigComuns;
    }
}
