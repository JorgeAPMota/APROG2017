/*
 * To change this license header, choose License Headers input Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template input the editor.
 */
package grandepremio2017;

import static grandepremio2017.Utilitarios.input;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author 1131345 - Jorge Mota baseado no documento disponibilizado:
 * OrientacoesDesenvolvimentoAplicaoFinal2017.pdf - docentes de APROG DEI_ISEP
 */
public class GrandePremio2017 {

    private final static Scanner input = new Scanner(System.in);
    private final static Formatter output = new Formatter(System.out);

//    private static int acrescentaElementosFichPrevio() throws Exception {
//        FileWriter f2 = new FileWriter(Configuracoes.FICHEIRO_BACKUP), true);
//        f2.write("Nova linha");
//        f2.write("The end\n");
//        f2.close();
//
//        return nParticipantes;
//    }
    /**
     * Método que acede à informação de uma linha do ficheiro e guarda-a na
     * estrutura dados se ainda não existe linha com aquele valor no 1º elemento, isto para participantes
     *
     * @param linha - String com o conteúdo de uma linha do ficheiro
     * @param participantes - matriz de strings com a informação lida do
     * ficheiro
     * @param nParticipantes - número de elementos existentes na matriz
     * @return - o novo número de elementos da matriz
     */
    private static int guardarDados(String linha, String[][] participantes, int nParticipantes) {
        String[] temp = linha.split(Configuracoes.SEPARADOR_DADOS_FICH);
        if (temp.length == Configuracoes.N_DADOS_SOCIO) {
            String num = temp[0].trim();
            int pos = pesquisarElemento(num, nParticipantes, participantes);
            if (pos == -1) {
                participantes[nParticipantes][0] = num;
                participantes[nParticipantes][1] = temp[1].trim();
                participantes[nParticipantes][2] = temp[2].trim();
                participantes[nParticipantes][3] = temp[3].trim();
                nParticipantes++;
            }
        }
        return nParticipantes;
    }

    /**
     * Método que acede à informação de uma linha do ficheiro e guarda-a na
     * estrutura dados se ainda não existe linha com aquele valor no 1º elemento, isto para participantes
     *
     * @param linha - String com o conteúdo de uma linha do ficheiro
     * @param participantes - matriz de strings com a informação lida do
     * ficheiro
     * @param nParticipantes - número de elementos existentes na matriz
     * @return - o novo número de elementos da matriz
     */
    private static int guardarDadosProvas(String linha, String[][] provas, int nProvas) {
        String[] temp = linha.split(Configuracoes.SEPARADOR_DADOS_FICH_PROVAS);
        if (temp.length == Configuracoes.N_DADOS_PROVAS) {
            String num = temp[0].trim();
            int pos = pesquisarElemento(num, nProvas, provas);
            if (pos == -1) {
                provas[nProvas][0] = num;
                provas[nProvas][1] = temp[1].trim();

                nProvas++;
            }
        }
        return nProvas;
    }
    
    
    /**
     * Pesquisar linha de matriz por primeiro elemento da linha
     *
     * @param valor - elemento a pesquisar
     * @param nEl - nº de elementos da matriz
     * @param matriz - matriz com a informação
     * @return -1 se não existe linha com esse valor ou o nº da linha cujo
     * primeiro elemento é esse valor
     */
    public static int pesquisarElemento(String valor, int nEl, String[][] mat) {
        for (int i = 0; i < nEl; i++) {
            if (mat[i][0].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Outro método para pesquisar elemento em matriz
     *
     * @param mat
     * @param v
     * @return
     */
    static int[] procurarElemento(String valor, int nEl, String[][] mat) {
        int[] res = null;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == valor) {
                    res = new int[2];
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * Carrega informação do ficheiro de texto para memória
     *     
* @param nomeFich - nome do ficheiro que contem a informação a guardar
     * @param participantes - matriz de strings para guardar a info do ficheiro
     * @param nParticipantes - número de elementos já existentes na matriz
     * @return o número final de elementos na matriz
     * @throws FileNotFoundException
     */
    public static int lerInfoFicheiroParaMemoria(String nomeFicheiro, String[][] participantes, int nParticipantes, int posicao) throws IOException {
        Scanner fileIO = new Scanner(new FileReader(nomeFicheiro));
        while (fileIO.hasNextLine() && nParticipantes < Configuracoes.MAX_PARTICIPANTES && posicao < Configuracoes.MAX_PARTICIPANTES) {
            String linha = fileIO.nextLine();
            int nCamposSocio = Configuracoes.N_DADOS_SOCIO;
            if (Utilitarios.validacao(linha, nCamposSocio, participantes, posicao)) {
                String dados[] = linha.split(";");

                participantes[posicao][0] = dados[0].trim();
                participantes[posicao][1] = dados[1].trim();
                participantes[posicao][2] = dados[2].trim();
                participantes[posicao][3] = dados[3].trim();

//                Utilitarios.iniciaProvas(provas, nParticipantes);
                nParticipantes = guardarDados(linha, participantes, nParticipantes);
                nParticipantes++;
            }
        }
        fileIO.close();
        return posicao;
    }

    /**
     * Carrega informação do ficheiro de texto de provas para memória
     *     
* @param nomeFich - nome do ficheiro que contem a informação a guardar
     * @param participantes - matriz de strings para guardar a info do ficheiro
     * @param nParticipantes - número de elementos já existentes na matriz
     * @return o número final de elementos na matriz
     * @throws FileNotFoundException
     */
    public static int lerFicheiroProvasParaMemoria(String nomeFicheiroProvas, String[][] provas, int nProvas, int posicao) throws IOException {

        Scanner fileIO = new Scanner(new FileReader(nomeFicheiroProvas));
        while (fileIO.hasNextLine() && posicao < Configuracoes.MAX_PROVAS) {
            String linha = fileIO.nextLine();
            int nCamposSocio = Configuracoes.N_DADOS_PROVAS;
            String dados[] = linha.split(";");

            provas[posicao][0] = dados[0].trim();
            provas[posicao][1] = dados[1].trim();

            nProvas++;
        }

        fileIO.close();
        return posicao;
    }

    /**
     * Verifica se é ficheiro válido/consegue ler
     * @param nomeFile
     * @return 
     */
    public static boolean isFile(String nomeFile) {
        File ficheiro = new File(nomeFile);
        if (ficheiro.isFile() && ficheiro.canRead()) {
            return true;
        }
        return false;
    }

    /**
     * Visualizar toda a informação (paginada)dos participantes existente em
     * memória
     *
     * @param participantes- matriz com a informação a listar
     * @param nParticipantes – nº de linhas com informação
     */
    private static void listagemPaginada(String[][] participantes, int nParticipantes) {
        int contPaginas = 0;
        for (int i = 0; i < nParticipantes; i++) {
            if (i % Configuracoes.MAX_LINHAS_PAGINA == 0) {
                if (contPaginas > 0) {
                    pausa();
                }
                contPaginas++;
                System.out.println("\nPÁGINA: " + contPaginas);
                cabecalho();
            }
            for (int j = 0; j < Configuracoes.N_DADOS_SOCIO; j++) {
                if (j == 1) {
                    System.out.printf("%30s", participantes[i][j]);
                } else {
                    System.out.printf("%10s", participantes[i][j]);
                }
            }
            System.out.println("");
        }
        pausa();
    }

    private static void cabecalho() {
        System.out.printf("%50s%n", "PARTICIPANTES");
        System.out.printf("%75s%n", "==================================================");
    }

    private static void pausa() {
        System.out.println("\n\nPara continuar digite ENTER\n");
        input.nextLine();
    }

    /**
     * Atualiza informação alterável de um participante
     *
     * @param nParticipante - Nº sócio/participante
     * @param matriz com toda a informação dos sócios
     * @param nSocios - número de sócios
     * @return false se o sócio não foi encontrado ou true se foi encontrado e
     * atualizado
     */
    public static boolean actualizarInfoParticipante(String nParticipantes,
            String[][] matriz, int nElems) {
        int pos;
        if ((pos = pesquisarElemento(nParticipantes, nElems, matriz)) > -1) {
            int op;
            do {
                mostrarParticipante(output, matriz[pos]);
                op = menuInfoParticipante();
                switch (op) {
                    case 1:
                        System.out.println("Novo nome:");
                        matriz[pos][1] = input.nextLine();
                        break;
                    case 2:
                        System.out.println("Nova marca do auto:");
                        matriz[pos][2] = input.nextLine();
                        break;
                    case 3:
                        System.out.println("Nova data de construção:");
                        matriz[pos][3] = input.nextLine();
                        break;
                    case 0:
                        System.out.println("FIM");
                        break;
                    default:
                        System.out.println("Opção incorreta");
                        break;
                }
            } while (op != 0);
            return true;
        }
        System.out.printf("O participante %s não foi encontrado!", matriz[pos][1]);
        return false;
    }

    /**
     * Apresenta o menu de opções de atualização de dados atualizáveis do
     * partipantes
     *
     * @return um inteiro que é a opção escolhida
     */
    private static int menuInfoParticipante() {
        String texto = "ATUALIZAR INFORMAÇÃO DE PARTICIPANTE"
                + "\n NOME PARTIIPANTE ... 1"
                + "\n MARCA do AUTOMÓVEL... 2"
                + "\n DATA CONSTRUÇÃO ... 3"
                + "\n TERMINAR ... 0"
                + "\n\nQUAL A SUA OPÇÃO?";
        System.out.printf("%n%s%n", texto);
        int op = input.nextInt();
        input.nextLine();
        return op;
    }

    /**
     * Mostrar a informação de um participante separada por ;
     *
     * @param out - instancia de formatter associado ao stream pretendido
     * @param socio - array de Strings com a informação do socio
     */
    private static void mostrarParticipante(Formatter out,
            String[] participante) {
        for (int j = 0; j < Configuracoes.N_DADOS_SOCIO; j++) {
            if (j == 1) {
                out.format("%30s;", participante[j]);
            } else {
                out.format("%12s;", participante[j]);
            }
        }
    }

    
    /**
     * Método main que corre o programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String participantes[][] = new String[Configuracoes.MAX_PARTICIPANTES][Configuracoes.N_DADOS_SOCIO];
        String provas[][] = new String[Configuracoes.MAX_PROVAS][Configuracoes.N_DADOS_PROVAS];
        int nParticipantes = 0;
        int[][] tempos = new int[0][0];
        double[][] prémios = new double[Configuracoes.MAX_PARTICIPANTES][Configuracoes.MAX_PROVAS];

        String nSocio;
        String nome;
        String marca;
        String dataConstrucao;

        int posicao = 0;
        int paginacao = 0;
        int opcao;
        String opcaoString = "";

        Erros.initialize();
        do {
            //menu
            System.out.print("\n========MENU========\n"
                    + "Escolha a opção que pretende:\n"
                    + "\t1 - Ler ficheiro com inscrições de sócios. (FILE: inscricoes.txt)\n"
                    + "\t2 - Visualizar a informação dos sócios já inscritos em ecrã.\n"
                    + "\t3 - Alterar, em memória, qualquer informação do participante, com exceção do número de sócio.\n"
                    + "\t4 - Ler ficheiro com informação de todas as provas. (FILE: prova1_inscricoes.txt)\n"
                    + "\t5 - Ler um ficheiro de texto cujo nome é o nome da prova contendo os tempos realizados pelos participantes nessa prova.\n"
                    + "\t6 - Calcular e guardar em memória os prémios atribuídos aos participantes numa determinada prova.\n"
                    + "\t7 - Guardar num ficheiro de texto Backup.txt, toda a informação existente em memória, isto é a informação das provas, a informação dos participantes e respetivos tempos.\n"
                    + "\t8 - Remover das estruturas de dados toda a informação relativa a um participante.\n"
                    + "\t9 - Inserir, se possível, informação dum novo participante. A informação será introduzida via teclado.\n"
                    + "\t10 - Visualizar no ecrã, para um determinado participante, a velocidade média em cada uma das provas em que participou e para cada uma delas a velocidade média do participante mais rápido e a do participante mais lento.\n"
                    + "\t11 - A média das velocidades médias da prova bem como a velocidade média do participante mais rápido.\n"
                    + "\t12 - O valor total de prémios atribuídos nessa prova.\n"
                    + "\t14 - Criar um ficheiro de texto de nome GrandePremio.txt com a informação dos participantes e prémio total recebido, por ordem decrescente do valor do prémio. \n");

            opcaoString = input.nextLine();

            if (Utilitarios.isNumber(opcaoString)) {
                opcao = Integer.parseInt(opcaoString);
            } else {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Insira o nome do ficheiro a inserir:");
                    String nomeFicheiro = input.nextLine();

                    if (isFile(nomeFicheiro)) {
                        //envia matriz para guardar a info do fich, return numSocios 
                        posicao = lerInfoFicheiroParaMemoria(nomeFicheiro, participantes, nParticipantes, posicao);
                    } else {
                        System.out.println("O ficheiro nao existe");
                    }
                    break;
                case 2:
                    if (posicao > 0) {
                        listagemPaginada(participantes, nParticipantes);
                    } else {
                        System.out.println("(i) Deve escolher a opcao 1 antes de listar conteudos");
                    }
                    break;
                case 3:
                    System.out.println("Insira o nr de socio do participante para o qual pretende alterar dados");
                    nSocio = input.nextLine();
                    System.out.println("\n -- " + Utilitarios.alterarDados(participantes, nSocio, posicao) + " -- \n");
                    break;
                case 4:
                    System.out.println("Insira o nome do ficheiro de provas a inserir: (FILE: provas.txt)");
                    String nomeFicheiroProvas = input.nextLine();

                    if (isFile(nomeFicheiroProvas)) {
                    int nProvas = 0;
                        posicao = lerFicheiroProvasParaMemoria(nomeFicheiroProvas, provas, nProvas, posicao);
                    } else {
                        System.out.println("O ficheiro nao existe");
                    }
                    break;
                case 5:
                    System.out.println("Unsuported opperation");
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Insira o nr de socio do participante a remover");
                    nSocio = input.nextLine();
                    Utilitarios.removerParticipante(participantes, nSocio, posicao);
                    break;
                case 0:
                    break;
                default:
                    break;
            }

            //menu de pausa
            if (opcao != 0) {
                System.out.println("\nPressione -ENTER- para voltar ao menu");
                input.nextLine();
            }
        } while (opcao != 0);

    }

}
