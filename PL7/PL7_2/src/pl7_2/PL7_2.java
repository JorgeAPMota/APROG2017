/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7_2;

import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL7_2 {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static Formatter output = new Formatter(System.out);

    /**
     * Definição de constantes, nº de funcionários
     */
    static final int NUM = 50;

    static int contadorFuncInfMedia = 0;
    
    String[] vecNomesFunc = new String[NUM];
    float[] vecSalariosFunc = new float[NUM];

    /**
     * a) Leitura de nomes e vencimentos de funcionários da empresa. A leitura
     * deve terminar com a introdução do nome “tt”;
     *
     * @param nomes - Vector de nomes dos funcionários
     * @param vencimentos - Vector de vencimentos dos funcionários
     */
    private void leituraNomesVencFunc(String[] vecNomesFunc, float[] vecSalariosFunc) {
        String nome = null;
        float vencimento;
        int contadorFunc = 0;

        while (!nome.equalsIgnoreCase("tt")) {
            System.out.println("Introduza o nome do funcionário");
            for (int i = 0; i < vecNomesFunc.length; i++) {
                vecNomesFunc[i] = input.nextLine();
            }

            System.out.println("Introduza o vencimento do funcionário");
            for (int j = 0; j < vecSalariosFunc.length; j++) {
                vecSalariosFunc[j] = input.nextFloat();
            }
            contadorFunc++;

        }
    }

    /**
     * Método que apenas cálcula a média de salários
     */
    private float calcMediaVenc(float[] vencimentos) {
        float mediaVenc = 0;
        int contadorVenc = 0;
        float somaVenc = 0;
        int i = -1;

        for (i = 0; i < vencimentos.length; i++) {
            contadorVenc++;
            somaVenc = somaVenc + vencimentos[i];
        }
        mediaVenc = somaVenc / contadorVenc;

        return mediaVenc;
    }

    /**
     * b) Listagem dos nomes dos funcionários com vencimentos inferiores à
     * média;
     */
    public static void listFuncVencInfMedia(String[] vecNomesFunc, float[] vecSalariosFunc, float mediaVenc) {

        for (int i = 0; i < vecSalariosFunc.length; i++) {
            if (vecSalariosFunc[i] < mediaVenc) {
                output.format("%n%s%.2f%s%.2f%n","Funcionário com vencimento inf á média:", vecNomesFunc[i],"com o salário:", vecSalariosFunc[i]);
                output.format("\nFuncionário com vencimento inf á média: %s\n" + vecNomesFunc[i] + "com o salário:%2.f \n", vecSalariosFunc[i]);

                // JOptionPane.showMessageDialog(null, "Funcionário com vencimento inf á média:"+vecNomesFunc[i]"com o salário:"+vecSalariosFunc[i]);
                contadorFuncInfMedia++;

            }
        }
    }

    /*
     c) Apresentação da percentagem de funcionários com vencimentos inferiores a um dado valor fornecido pelo utilizador.        
     */
    public static void percentFuncVencInfMedia() {

        double percentagem;

        String texto = JOptionPane.showInputDialog("Introduza um valor de salario a comparar com o de todos os funcionarios...");
        float valorComparar = Float.parseFloat(texto);

        while (valorComparar <= 0) {
            texto = JOptionPane.showInputDialog("Introduza novo valor de salario a comparar com o de todos os funcionarios, para terminar 0...");
            valorComparar = Float.parseFloat(texto);
        }

        //Cálculo da percentagem...
        percentagem = (contadorFuncInfMedia / NUM) * 100;

        JOptionPane.showMessageDialog(null, percentagem);

    }

    public static void main(String[] args) {
        String [] vecNomesFunc = new String[NUM];

      //  listFuncVencInfMedia(vecNomesFunc, 15 , 15);
        percentFuncVencInfMedia();

    }
}
