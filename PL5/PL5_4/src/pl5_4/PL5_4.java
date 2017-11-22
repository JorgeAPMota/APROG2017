package pl5_4;
//Exercício 4 (**)
//Elabore um programa em Java que determine e visualize os N primeiros números perfeitos.

import java.util.Scanner;

//Um número é perfeito se for natural e for igual à soma de todos os seus divisores  
//(excluindo o próprio número). Na codificação do programa utilize a classe Scanner
//para a entrada de dados e a classe System para a saída de dados.
/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL5_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lerDadosDoTeclado = new Scanner(System.in);
        
        int nNrs, cont, i, num, div;

        System.out.println("Introduza a quantidade de números que pretende encontrar.");
        nNrs = lerDadosDoTeclado.nextInt();

        num = 2;
        cont = 0;

        while (nNrs != cont) {
            div = 0;
            for (i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    div += i;
                }
            }
            if (num == div) {
                cont += 1;
                System.out.println("O número " + num + " é perfeito.");
            }
            num += 2;
        }
    }
}

//int limite;
//        long n;
//        boolean primo = true;
//        Scanner leitura = new Scanner(System.in);
//        
//        System.out.println("Insira N");
//        limite = leitura.nextInt();
//        
//        if(limite > 0){
//            // Para a fórmula funcionar, i-1 > 0
//            for (int i = 2; limite > 0; i++){
//                primo = true;
//                
//                // Para a fórmula funcionar, 2^(i) - 1 tem de ser primo
//                n = (int)Math.pow(2, i) - 1;
//                for(int x = 2; (x < n) && (primo == true); x++){
//                    if(n % x == 0){
//                        primo = false;
//                    }
//                }
//
//                if(primo){
//                    // n = 2^(i-1) * (2^(i) - 1) <- Fórmula de Euclides
//                    n = (int)Math.pow(2, i-1) * n;
//                    System.out.println(n);
//                    limite--;
//                }
//            }
//        }else{
//            System.out.println("Limite inválido");
//        }
//        
//    }
//}

