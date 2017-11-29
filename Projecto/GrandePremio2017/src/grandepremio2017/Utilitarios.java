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
//    }
    public static int calcIdadeAutomovel() {
        int idadeAutomovel = 0;

        return idadeAutomovel;
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

    public static int converterddmmaaaaParaaaammdd(){
        
    }
    
    public static String verificaSeTemApelido() {

    }

    public static int converterddmmaaaaParaaaammdd(String data){
    
        data = input.nextString();
        
        
        System.out.println("Data" + data);
        return data;
    }
    
    
}
