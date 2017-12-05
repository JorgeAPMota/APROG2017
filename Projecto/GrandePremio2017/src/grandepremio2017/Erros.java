/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandepremio2017;

/**
 *
 * @author 1131345 - Jorge Mota baseado no documento disponibilizado:
 * OrientacoesDesenvolvimentoAplicaoFinal2017.pdf - docentes de APROG DEI_ISEP
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class Erros {

    public static String[] erros = {
        "erro_associados.txt", "erro_inscricoes.txt", "erro_tempos.txt"
    };

    public static void initialize() throws FileNotFoundException {
        Formatter outputTxt = null;
        for (int i = 0; i < erros.length; i++) {
            outputTxt = new Formatter(new File(erros[i]));
            outputTxt.format("%s%n", "ERROS");
            outputTxt.close();
        }
    }

    public static void erroAssociados(String erro) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(erros[0], true));
        bw.write(erro + "\n");
        bw.close();
    }

    public static void erroInscricoes(String erro) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(erros[1], true));
        bw.write(erro + "\n");
        bw.close();
    }

    public static void erroTempos(String erro) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(erros[2], true));
        bw.write(erro + "\n");
        bw.close();
    }

}
