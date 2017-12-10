/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageTestes;

import grandepremio2017.Utilitarios;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class TestesUtilitarios {

    public static void main(String[] Args) {
        System.out.println("\n\nTestes associados ao método verificaSeTemApelido() ");
        System.out.println("Valores de Entrada: Nome completo e apelido e”+“ Saída Esperada: true ou false \n");
        
        System.out.println("Valores de Entrada:José Costa Silva , Costa e Saída Esperada: true");
        System.out.println("Saída obtida: " + Utilitarios.verificaSeTemApelido("José Costa Silva", "Costa") + "\n\n");
        
        System.out.println("Valores de Entrada:José Costa Silva , Ramos e Saída Esperada: false");
        System.out.println("Saída obtida: " + Utilitarios.verificaSeTemApelido("José Costa Silva", "Ramos") + "\n\n");
       
        
        System.out.println("\n\nTestes associados ao método converterDataddmmaaaaParaaaaammdd()");
        System.out.println("Valor de Entrada: data no formato dd/mm/aaaa e Saída Esperada: aaaaddmm\n");
        System.out.println("Valor de Entrada:19/12/2000 Saída Esperada: 20001219 ");
        System.out.println("Saída obtida: " + Utilitarios.converterddmmaaaaParaaaammdd("19/12/2000") + "\n\n");
        System.out.println("Valor de Entrada:2/5/2010 Saída Esperada: 20100502 ");
        System.out.println("Saída obtida: " + Utilitarios.converterddmmaaaaParaaaammdd("2/5/2010") + "\n\n");

        System.out.println("\n\nTestes associados ao método idade()”+ “a serem executados antes de 25 de Dezembro 2017");
        System.out.println("Valor de Entrada: data de construcao” + “no formato aaaammdd e Saída Esperada: idade \n");
        System.out.println("Valor de Entrada:19901225 Saída Esperada: 26 ");
        System.out.println("Saída obtida: " + Utilitarios.calcIdade("25/12/1990") + "\n\n");
        System.out.println("Valor de Entrada:25/12/1990 Saída Esperada: 36 ");
        System.out.println("Saída obtida: " + Utilitarios.calcIdade("1980/12/25") + "\n\n");
        System.out.println("Valor de Entrada:2000/11/05 Saída Esperada: 17");
        System.out.println("Saída obtida: " + Utilitarios.calcIdade("2000/10/05") + "\n\n");
        System.out.println("Valor de Entrada:2000/11/05 Saída Esperada: 17");
        System.out.println("Saída obtida: " + Utilitarios.calcIdade("2000/10/25") + "\n\n");
    }

}
