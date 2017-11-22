/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7_1;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL7_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i, s = 0, c = 0;
        int[] vector = new int[10];
        Scanner ler = new Scanner(System.in);
        
        for (i = 0; i < vector.length; i++) {
            System.out.println("Número?");
            vector[i] = ler.nextInt();
        }
        
        for (i = 0; i < vector.length; i++) {
            if (vector[i] % 2 == 0) {
                s = s + vector[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println(((double) s) / c);
        } else {
            System.out.println("Operação impossível de realizar");
        }
    }

// a) Descreva a sua funcionalidade;
/*  O programa cria um array de inteiros com 10 elementos, e vai preenchendo-o com elementos que recebe por consola  
     do utilizador até encher o array. Verifica depois o nr de elementos pares percorrendo todo o array, e soma os elementos
     que o são. No fim apresenta o valor médio dos elemetos pares*/
// b) Acrescente ao programa um método para receber um vetor de inteiros e retornar o menor 
// número armazenado nesse vetor;
    private int menorNrVector(int[] vector) {
        int menor_nr, i, temp = 0, menorNr = 0;

        for (i = 0; i < vector.length; i++) {
            if (vector[i] < vector[temp]) {
                menorNr = vector[i];
            }
        }
        return menorNr;
    }


//c) Altere novamente o programa de forma a mostrar 
//os índices dos menores elementos do vetor v, usando o método da alínea anterior.
    private int menorNrVector2(int[] vector) {
        int menor_nr, i, temp = 0, menorNr = 0;

        for (i = 0; i < vector.length; i++) {
            if (vector[i] < vector[temp]) {
                menorNr = vector[i];
            }
        }

        out.format("%d%n", menorNr);
        return menorNr;
    }
}