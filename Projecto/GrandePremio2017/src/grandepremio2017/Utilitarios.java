/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandepremio2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 1131345 - Jorge Mota baseado no documento disponibilizado:
 * OrientacoesDesenvolvimentoAplicaoFinal2017.pdf - docentes de APROG DEI_ISEP
 */
public class Utilitarios {

    static Scanner input = new Scanner(System.in);
    static Formatter output = new Formatter(System.out);

    /**
     * Dada a data de construção retorna a idade do automovel
     *
     * @param data data de nascimento no formato aaaammdd
     * @return idade
     */
    public static int calcIdade(String data) {
        int ano = Integer.parseInt(data.substring(0, 4));
        int mes = Integer.parseInt(data.substring(4, 6));
        int dia = Integer.parseInt(data.substring(6, 8));
        Calendar hoje = Calendar.getInstance();
        int diaH = hoje.get(Calendar.DAY_OF_MONTH);
        int mesH = hoje.get(Calendar.MONTH) + 1;
        int anoH = hoje.get(Calendar.YEAR);
        if (mesH > mes || mesH == mes && diaH >= dia) {
            return anoH - ano;
        }
        return anoH - ano - 1;
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
//    public static int calcPremio(int idadeAutomovel, String[][] provas, int nProvas) {
//        int premio;
//
//        for (int i = 0; i < provas.length - 1; i++) {
//            for (int j = 0; j < provas[0].length; j++) {
//
//                String linha[] = provas[i][j].split(";");
//
//                provasNomes[nProvas] = linha[0].split(":").trim();
//                provasDistancia[nProvas][1] = Integer.parseInt(linha[1].split(":"));
//       
//        
//
//        premio = (idadeAutomovel / 20) * (provas[i][1]) * 2;
//        
//        
//        
//        //output.format("%n%s%d%s%n", "O participante terá um prémio de", premio, "€\n");
//
//        return premio;
//    }

    /**
     * Verifica se um determinado nome contem apelido
     *
     * @param nome
     * @param apelido
     * @return
     */
    public static boolean verificaSeTemApelido(String nome, String apelido) {
        return nome.contains(apelido);
    }

    /**
     * @return texto Devolve nome e apelido de uma string com o nome completo
     *
     */
    public static String reduzirNome(String nome) {
        String nomeReduzido[] = nome.trim().split(" ");
        String texto = nomeReduzido[0] + " " + nomeReduzido[nomeReduzido.length - 1];
        return texto;
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

    //validacao de linha texto 
    public static boolean validacao(String dados, int N_DADOS_SOCIO, String participantes[][], int posicao) throws IOException {

        String arrValidacao[] = dados.split(";");

        if (arrValidacao.length != Configuracoes.N_DADOS_SOCIO) {
            if (dados.length() != 0) {
                Erros.erroInscricoes(dados + " -- Numero de campos invalido");
            }

            return false;
        }

        //estrutura para 4 campos dados
        String nSocio = arrValidacao[0].trim();
        String nome = arrValidacao[1].trim();
        String marca = arrValidacao[2].trim();
        String data = arrValidacao[3].trim();

        //valida se o nome contem nome e apelido
        if (!nomeValido(nome)) {
            Erros.erroInscricoes("Nome: " + nome + " com nao possui nome e apelido");
            return false;
        }

        //valida estrutura de datas
        if (!validaData(data)) {
            Erros.erroInscricoes("data: " + data + " estrutura invalida");
            return false;
        }

        if (indexOf(participantes, nSocio, posicao) != -1) {
            Erros.erroInscricoes("Nº socio: " + nSocio + " ja registado em estrutura de dados");
            return false;
        }

        return true;
    }

    //
    public static String normalizarString(String dados) {
        String arrValidacao[] = dados.split(";");

        String nrSocio = arrValidacao[0].trim();
        String nome = arrValidacao[1].trim();
        String marca = arrValidacao[2].trim();
        String data = arrValidacao[3].trim();

        return nrSocio + ";" + nome + ";" + marca + ";" + data;
    }

    public static boolean nomeValido(String nome) {
        if (nome.split(" ").length < 2) {
            return false;
        }
        return true;
    }

    /**
     * @return um boolean, com indicacao se existe ou nao no nosso calendario
     */
    public static boolean validaData(String data) {
        String arrValidacao[] = data.split("/");

        if (arrValidacao.length != 3) {
            return false;
        }

        int dia = Integer.parseInt(arrValidacao[0]);
        int mes = Integer.parseInt(arrValidacao[1]);
        int ano = Integer.parseInt(arrValidacao[2]);

        int diasMes[] = {
            31, 28 + bisexto(ano), 31, 30,
            31, 30, 31, 31,
            30, 31, 30, 31
        };

        if ((mes < 1) || (mes > 12)) {
            return false;
        }

        if (dia > diasMes[mes - 1]) {
            return false;
        }

        return true;
    }

    /**
     * @return determina se e ano bisexto ou nao
     *
     */
    public static int bisexto(int ano) {
        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
            return 1;
        }
        return 0;
    }

    /**
     * @return procura e devolve posicao de um determinado elemento
     *
     */
    public static int indexOf(String participantes[][], String nSocio, int posicao) {
        for (int i = 0; i < posicao; i++) {
            if (participantes[i][0].equals(nSocio)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return void
     *
     */
    public static String alterarDados(String participantes[][], String nSocio, int posicao) {
        //ver se o socio existe
        if (indexOf(participantes, nSocio, posicao) == -1) {
            return "Nao existe o nr de socio que introduziu";
        }

        int opcao = 0;

        String msg = "Qual e a opcao:\n\t"
                + "1 - Alterar data de fabrico do automovel\n\t"
                + "2 - Alterar Nome\n\t"
                + "3 - Alterar Marca automovel"
                + "4 - Alterar tudo excepto nr socio";
        do {
            System.out.println(msg);
            opcao = Integer.parseInt(input.nextLine());
        } while (opcao > 4 || opcao < 1);

        switch (opcao) {
            case 1:
                mudaData(participantes, nSocio, posicao);
                break;
            case 2:
                mudaNome(participantes, nSocio, posicao);
                break;
            case 3:
                mudaMarca(participantes, nSocio, posicao);
                break;
            case 4:
                mudaData(participantes, nSocio, posicao);
                mudaNome(participantes, nSocio, posicao);
                break;
        }

        return "Realizado com Sucesso";
    }

    /**
     * @return void -- Altera o nome
     *
     */
    public static void mudaNome(String participantes[][], String nSocio, int posicao) {
        String nome = "";

        do {
            System.out.println("Introduza o novo nome (Pelo menos nome e apelido)");
            nome = input.nextLine();
        } while (!nomeValido(nome));

        int posSocio = indexOf(participantes, nSocio, posicao);
        participantes[posSocio][1] = nome;
    }

    /**
     * @return void -- Altera data
     *
     */
    public static void mudaData(String participantes[][], String nSocio, int posicao) {
        String data = "";
        String msg = "Insira uma data no formato dd/mm/aaaa \n\t"
                + "(d) - dia | (m) - mes | (a) - ano";
        do {
            System.out.println(msg);
            data = input.nextLine();
        } while (!validaData(data));

        int posSocio = indexOf(participantes, nSocio, posicao);
        participantes[posSocio][2] = data;
    }

    /**
     * @return void -- Altera marca do automovel
     *
     */
    public static void mudaMarca(String participantes[][], String nSocio, int posicao) {
        String marca = "";
        do {
            System.out.println("Introduza a marca nova/corrigida");
            marca = input.nextLine();
        } while (!nomeValido(marca));

        int posSocio = indexOf(participantes, nSocio, posicao);
        participantes[posSocio][2] = marca;

    }

    //remove um socio com base no seu nif caso exista
    public static boolean removerSocio(String participantes[][], String nSocio, int posicao) {
        int index = indexOf(participantes, nSocio, posicao);
        if (index == -1) {
            System.out.println("O socio introduzido nao existe");
            return false;
        }

        String tmp[];

        for (int i = index; i < posicao; i++) {
            for (int j = i + 1; j < posicao; j++) {
                tmp = participantes[i];
                participantes[i] = participantes[j];
                participantes[j] = tmp;
            }
        }

        return true;
    }

//    //inicia a arr das provas com os valores a -1
//    public static void iniciaProvas(int provas[][], int posicao) {
//        for(int j=0; j < provas[0].length; j++) {
//            provas[posicao][j] = -1;
//        }
//    }
    //inscricao numa determinada prova
    public static void inscricao(String participantes[][], int provas[][], String nSocio, int prova, int posicao) {
        int index = indexOf(participantes, nSocio, posicao);
        provas[index][prova - 1] = 0;
    }

    /**
     * Remove participante com base no seu nº de socio, caso exista
     *
     * @param participantes
     * @param socio
     * @param posicao
     * @return
     */
    public static boolean removerParticipante(String participantes[][], String nSocio, int posicao) {
        int index = indexOf(participantes, nSocio, posicao);
        if (index == -1) {
            System.out.println("O socio introduzido nao existe");
            return false;
        }

        String tmp[];

        for (int i = index; i < posicao; i++) {
            for (int j = i + 1; j < posicao; j++) {
                tmp = participantes[i];
                participantes[i] = participantes[j];
                participantes[j] = tmp;
            }
        }

        return true;
    }

    public static void ordenarArr(String participantes[][], int provas[][], int posicao) {
        int tmpProvas[];
        String tmpSocios[];

        for (int i = 0; i < posicao; i++) {
            for (int j = i + 1; j < posicao; j++) {
                if (participantes[i][1].compareToIgnoreCase(participantes[j][1]) > 0) {
                    tmpSocios = participantes[i];
                    tmpProvas = provas[i];

                    participantes[i] = participantes[j];
                    provas[i] = provas[j];

                    participantes[j] = tmpSocios;
                    provas[j] = tmpProvas;
                }
            }
        }
    }

    public static boolean inscricaoValida(int provas[][], int prova, int posicao) {
        for (int i = 0; i < posicao; i++) {
            if (provas[i][prova - 1] == 0) {
                return true;
            }
        }

        return false;
    }

    public static void listarElementos(String participantes[][], int provas[][], int posicao, String tipo) throws FileNotFoundException {

        String delimitador = "| \t\t\t";
        Formatter output = new Formatter(new File("backup.txt"));

        if (tipo.equalsIgnoreCase("f")) {
            delimitador = ";";
        }

        String linha = "";
        for (int i = 0; i < posicao; i++) {
            linha = "";
            for (int j = 0; j < participantes[0].length; j++) {
                linha += participantes[i][j] + delimitador;
            }

            for (int k = 0; k < provas[i].length; k++) {
                if (provas[i][k] < 1) {
                    if (provas[i][k] == -1) {
                        linha += "N_INSC" + delimitador;
                    }

                    if (provas[i][k] == 0) {
                        linha += "INSC" + delimitador;
                    }
                } else {
                    linha += converteSegundos(provas[i][k]) + delimitador;
                }
            }

            linha = linha.substring(0, linha.length() - 1);

            if (tipo.equalsIgnoreCase("e")) {
                System.out.println(linha);
            } else {
                output.format("%s%n", linha);
            }

        }

        output.close();
    }

    public static String converteSegundos(int segundos) {
        String tempo = "";

        int horas = segundos / (60 * 60);
        segundos -= horas * (60 * 60);

        int minutos = segundos / 60;
        segundos -= minutos * 60;

        //segundos
        tempo = horas + ":" + minutos + ":" + segundos;
        return tempo;
    }

    public static boolean provaRealizada(int provas[][], int posicao, int prova) {
        for (int i = 0; i < posicao; i++) {
            if (provas[i][prova - 1] > 0) {
                return true;
            }
        }
        return false;
    }

    public static void percInscritos(String[][] participantes, int provas[][], int posicao) {
        int contador = 0;
        int mulheres = 0;
        int faltosos = 0;

        for (int i = 0; i < provas[0].length; i++) {
            mulheres = 0;
            contador = 0;
            faltosos = 0;

            System.out.println("== Prova " + (i + 1));
            for (int j = 0; j < posicao; j++) {
                if (provas[j][i] >= 0) {
                    contador++;
                    if (participantes[j][3].equalsIgnoreCase("feminino")) {
                        mulheres++;
                    }
                    if (provas[j][i] == 0) {
                        faltosos++;
                    }
                }
            }
            if (contador > 0) {

                String percInsc = Math.round((double) contador / posicao * 100) + "";
                String percMulheres = Math.round((double) mulheres / contador * 100) + "";
                String percFaltas = Math.round((double) faltosos / contador * 100) + "";

                if (provaRealizada(provas, posicao, (i + 1))) {
                    System.out.printf("\n\t - Percentagem de faltosos: %s %%", percFaltas);
                }
                System.out.printf("\n\t - Percengem de inscritos: %s %%", percInsc);

                System.out.printf("\n\t - Percengem de mulheres inscritas: %s %%\n", percMulheres);
            } else {
                System.out.println("Nao existem inscricoes de momento");
            }

        }

    }

    public static String tempoMedio(int provas[][], int posicao, int prova) {
        int total = 0;
        int contagem = 0;

        for (int i = 0; i < posicao; i++) {
            if (provas[i][prova - 1] > 0) {
                total += provas[i][prova - 1];
                contagem++;
            }
        }

        if (contagem == 0) {
            return " - ";
        }

        return converteSegundos(total / contagem);
    }

    public static void melhoresPiores(int provas[][], int posicao, int prova) {
        int ordenado[] = new int[posicao];

        for (int i = 0; i < posicao; i++) {
            ordenado[i] = provas[i][prova - 1];
        }

        ordenarTempos(ordenado);

        //imprime melhores
        System.out.println("\n\n-- TOP 10 --");
        for (int i = 0; i < Math.min(9, ordenado.length); i++) {
            if (ordenado[i] > 0) {
                System.out.println((i + 1) + " -- " + converteSegundos(ordenado[i]));
            }
        }

        //imprime piores
        System.out.println("\n\n-- BOTTOM 10 --");
        for (int i = Math.min(9, ordenado.length) - 1; i >= 0; i--) {
            if (ordenado[i] > 0) {
                System.out.println((Math.min(9, ordenado.length) - i) + " -- " + converteSegundos(ordenado[i]));
            }
        }

    }

    public static void ordenarTempos(int provas[]) {
        int tmp;
        for (int i = 0; i < provas.length; i++) {
            for (int j = i + 1; j < provas.length; j++) {
                if (provas[j] > provas[i]) {
                    tmp = provas[i];
                    provas[i] = provas[j];
                    provas[j] = tmp;
                }
            }
        }
    }

//    public static void guardarInfo(String participantes[][], int provas[][], int posicao, String data, int numCamposReport) throws FileNotFoundException {
//        Formatter outputTxt = new Formatter(new File("Runners2016.txt"));
//        String writeToFile = "";
//
//        String output[][] = new String[posicao][numCamposReport];
//
//        for (int i = 0; i < posicao; i++) {
//            output[i][0] = reduzirNome(participantes[i][1]);
//            output[i][1] = calcIdade(participantes[i][2], data) + "";
//            output[i][2] = contarProvas(provas[i]) + "";
//            if (output[i][2].equals("0")) {
//                output[i][3] = "-";
//            } else {
//                output[i][3] = converteSegundos(tempoMedioAtleta(provas[i]) / contarProvas(provas[i]));
//            }
//        }
//
//        ordenarIdades(output);
//
//        writeToFile += "\t\t -- Listagem de Tempos --\n";
//        writeToFile += "Nome  \t Idade \t N.º Provas \t Tempo Médio\n";
//
//        for (int i = 0; i < output.length; i++) {
//            for (int j = 0; j < output[0].length; j++) {
//                if (j == 2) {
//                    writeToFile += "\t\t";
//                }
//                writeToFile += output[i][j] + "\t";
//            }
//            writeToFile += "\n";
//        }
//
//        writeToFile += "\n\t\t\t\t\t\t<" + data + ">";
//
//        outputTxt.format("%s%n", writeToFile);
//        outputTxt.close();
//        System.out.println("Informacao guardada no ficheiro Runners2016.txt");
//
//    }
    public static int contarProvas(int linhaProva[]) {
        int cont = 0;
        for (int i = 0; i < linhaProva.length; i++) {
            if (linhaProva[i] > 0) {
                cont++;
            }
        }

        return cont;
    }

    public static int tempoMedioAtleta(int linhaProva[]) {
        int total = 0;
        for (int i = 0; i < linhaProva.length; i++) {
            if (linhaProva[i] > 0) {
                total += linhaProva[i];
            }
        }

        return total;
    }

    public static void ordenarIdades(String report[][]) {
        String tmp;
        for (int i = 0; i < report.length; i++) {
            for (int j = i + 1; j < report.length; j++) {
                if (Integer.parseInt(report[j][1]) > Integer.parseInt(report[i][1])) {
                    tmp = report[i][1];
                    report[i][1] = report[j][1];
                    report[j][1] = tmp;
                }
            }
        }
    }

    public static boolean isNumber(String inputStr) {
        String pattern = "[^0-9]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(inputStr);

        if (m.find() || inputStr.length() == 0) {
            return false;
        }
        return true;
    }

}
