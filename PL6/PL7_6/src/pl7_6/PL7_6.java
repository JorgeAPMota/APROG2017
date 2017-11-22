/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl7_6;

import java.util.Scanner;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL7_6 {

    static Scanner input = new Scanner(System.in);
    static final int NUMVISITANTES = 100;
//Pretende-se uma aplicação modular que permita fazer a gestão de visitantes num hospital. 
//Os visitantes são identificados pelo seu nome e o número máximo permitido é 100. 
//O programa deve ser orientado por um menu que ofereça as seguintes funcionalidades:

//- Inserir um visitante;  
//- Listar todos os visitantes;
//- Atualizar um nome dado;
//- Eliminar um visitante dado;
//- Listar os nomes começados por uma dada letra;
//- Listar nomes repetidos.
    public static void escreveMenu() {
        System.out.println("Opções...");
        System.out.println("1 - Inserir visitante");
        System.out.println("2 - Listar todos os visitantes");
        System.out.println("3 - Actualizar um dado nome");
        System.out.println("4 - Listar os nomes começados por uma dada letra");
        System.out.println("5 - Listar nomes repetidos");
        System.out.println("6 - Eliminar visitante");
        System.out.println("0 - Sair");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] visitantes = new String[NUMVISITANTES];

        int num = 0;
        int opcao = -1;
        
        
        while (opcao != 0) {
            escreveMenu();
            opcao = input.nextInt();
            input.nextLine(); //Para limpar o buffer

            switch (opcao) {
                case 1:
                   // inserirVisitante();
                    break;

                case 2:
                    break;

                default:
                    System.out.println("");
                    System.out.println("Inseriu uma opção inválida");
                    System.out.println("");
                    break;
            }
            
        }

    }
}