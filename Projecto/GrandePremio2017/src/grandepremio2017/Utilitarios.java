/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandepremio2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;

/**
 *
 * @author 1131345 - Jorge Mota baseado no documento disponibilizado:
 * OrientacoesDesenvolvimentoAplicaoFinal2017.pdf - docentes de APROG DEI_ISEP
 */
public class Utilitarios {

    static Scanner input = new Scanner(System.in);
    static Formatter output = new Formatter(System.out);

//    public static int calcVelocMedia(){
//        
//    
    
     /**
    * @return Calcula a idade mediante data nascimento
    **/
    
    public static int calcIdade(String data, String hoje) {
        String dataNasimento[] = data.split("/");
        String dataHoje[] = hoje.split("/");
        
        int idade = Integer.parseInt(dataHoje[2]) - Integer.parseInt(dataNasimento[2]) -1;
        
        if(( Integer.parseInt(dataHoje[1]) >=  Integer.parseInt(dataNasimento[1]) )
                && 
            ( Integer.parseInt(dataHoje[0]) >=  Integer.parseInt(dataNasimento[0]) ) ) {
            
            idade++;
        }
        return idade;
    }

    //- Todos os participantes que terminam uma prova têm um prémio calculado pela fórmula: 
    // premio = idade automóvel / 20 X nº Km da prova X 2 Euros
//- Ao(s) participante(s) com o melhor tempo será atribuído um prémio suplementar de 500 Euros
    /**
     * Calcula prémio a atribuir a participante
     *
     * @param idadeAutomovel
     * @param distProva
     * @return
     */
    public static int calcPremio(int idadeAutomovel, int distProva) {
        int premio;

        premio = (idadeAutomovel / 20) * distProva * 2;
        output.format("%n%s%d", "O participante terá um prémio de", premio);

        return premio;
    }

    /**
     * Verifica se um determinado nome contem apelido
     *
     * @param nome
     * @param apelido
     * @return
     */
    public static boolean verificaSeTemApelido(String nome, String apelido) {
    // String implements CharSequence
        return nome.contains(apelido);
    }

    /**
     * Converte data no formato dd/mm/ano em aaaammdd
     *
     * @param data data no formato dd/mm/ano
     * @return data no formato aaaammdd
     */
    public static String converterddmmaaaaParaaaammdd(String data) {
        String[] aux = data.trim().split("/");
        String dia = aux[0].length() < 2 ? "0" + aux[0] : aux[0];
        String mes = aux[1].length() < 2 ? "0" + aux[1] : aux[1];
        return aux[2] + mes + dia;
    }


}
