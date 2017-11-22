/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl8_1;

import java.util.Scanner;
import java.util.Formatter;

/**
 *
 * @author Jorge Mota
 */
public class Enigma {

    static Scanner input = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);

    public static void main(String[] args) {
        int x;
        int m[][] = {{1, 4, 2, 1}, {9, 7, 2, 2}, {1, 7, 3, 5}, {2, 5, 0, 3}, {4, 7, 2, 1}};
        for (int i = 0; i < m.length; i++) {
            x = m[i][0];
            for (int j = 1; j < m[i].length; j++) {
                if (m[i][j] > x) {
                    x = m[i][j];
                }
            }
            System.out.println(x);
        }
    }
    //a) Descreva a sua funcionalidade;
    //O método cria uma matriz m de 5x4, e preenche-a/inicia, percorre cada coluna linha a linha e mostra o maior valor

    //b) Construa um método para mostrar a matriz m;
    public static void listarMatriz(int[][] m, int linhas, int colunas) {
        out.format("%n%s%n", "A listar a matriz...");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                out.format("%s", m[i][j]);
            }
            out.format("%n");
        }
    }

    //c) Crie um método para apresentar a média de cada coluna e a média global da matriz m ;
    public static double calculaMediaColuna(int[][] m, int c) {
        double mediaColuna = 0;
        //Self note: m.length = número de linhas, ou seja, tamanho da coluna
        for (int i = 0; i < m.length; i++) {
            mediaColuna += m[i][c];
        }
        //cast de m.lenght para double, e divide mediaColuna por m.length (nº de linhas) armazenando o resultado na 1ª
        mediaColuna /= (double) m.length;
        return mediaColuna;
    }

    
    /**
     * Método para calcular a média global da matriz
     * @param m
     * @param linhas
     * @param colunas
     * @return 
     */
    public static double calculaMediaGlobal(int[][] m, int linhas, int colunas) {
        double mediaGlobal = 0;
        int nrElementos = 0;
        
        for(int l=0; l<m.length; l++){
            for(int c=0; c<m[l].length; c++)
                
                mediaGlobal += m[l][c];
                nrElementos++;
                mediaGlobal /= (double)nrElementos;
       //Self note: m[linha].length = número de colunas da linha
            }
            return mediaGlobal;
        }
    }

    //d) Crie um método para mostrar a matriz transposta da matriz m.

