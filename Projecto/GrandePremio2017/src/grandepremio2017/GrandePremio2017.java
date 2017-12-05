/*
 * To change this license header, choose License Headers input Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template input the editor.
 */
package grandepremio2017;

import static grandepremio2017.Utilitarios.input;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

    private static int acrescentaElementosFichPrevio() throws Exception {
        FileWriter f2 = new FileWriter(Configuracoes.FICHEIRO_BACKUP), true);
        f2.write("Nova linha");
        f2.write("The end\n");
        f2.close();
    }

    /**
     * Método que acede à informação de uma linha do ficheiro e guarda-a na
     * estrutura dados se ainda não existe linha com aquele valor no 1º elemento
     *
     * @param linha - String com o conteúdo de uma linha do ficheiro
     * @param info - matriz de strings com a informação lida do ficheiro
     * @param nElems - número de elementos existentes na matriz
     * @return - o novo número de elementos da matriz
     */
    private static int guardarDados(String linha, String[][] info, int nElems) {
        String[] temp = linha.split(Configuracoes.SEPARADOR_DADOS_FICH);
        if (temp.length == Configuracoes.N_CAMPOS_INFO) {
            String num = temp[0].trim();
            int pos = pesquisarElemento(num, nElems, info);
            if (pos == -1) {
                info[nElems][0] = num;
                info[nElems][1] = temp[1].trim();
                info[nElems][2] = temp[2].trim();
                info[nElems][3] = temp[3].trim();
                nElems++;
            }
        }
        return nElems;
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
     * @param info - matriz de strings para guardar a info do ficheiro
     * @param nElems - número de elementos já existentes na matriz
     * @return o número final de elementos na matriz
     * @throws FileNotFoundException
     */
    public static int lerInfoFicheiroParaMemoria(String nomeFich, String[][] info, int nElems) throws FileNotFoundException {
        nomeFich = Configuracoes.FICHEIRO_BACKUP;
        Scanner fInput = new Scanner(new File(Configuracoes.FICHEIRO_BACKUP));
        while (fInput.hasNext() && nElems < Configuracoes.MAX_PARTICIPANTES) {
            String linha = fInput.nextLine();
            // Verifica se linha não está em branco
            if (linha.trim().length() > 0) {
                nElems = guardarDados(linha, info, nElems);
            }
        }
        fInput.close();
        return nElems;
    }

    /**
     * Visualizar toda a informação (paginada)dos participantes existente em
     * memória
     *
     * @param matriz- matriz com a informação a listar
     * @param nEl – nº de linhas com informação
     */
    private static void listagemPaginada(String[][] matriz, int nEl) {
        int contPaginas = 0;
        for (int i = 0; i < nEl; i++) {
            if (i % Configuracoes.MAX_LINHAS_PAGINA == 0) {
                if (contPaginas > 0) {
                    pausa();
                }
                contPaginas++;
                System.out.println("\nPÁGINA: " + contPaginas);
                cabecalho();
            }
            for (int j = 0; j < Configuracoes.N_CAMPOS_INFO; j++) {
                if (j == 1) {
                    System.out.printf("%30s", matriz[i][j]);
                } else {
                    System.out.printf("%10s", matriz[i][j]);
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
     * @param nSocio - Nº sócio
     * @param matriz com toda a informação dos sócios
     * @param nSocios - número de sócios
     * @return false se o sócio não foi encontrado ou true se foi encontrado e
     * atualizado
     */
    public static boolean actualizarInfoParticipante(String nSocio,
            String[][] matriz, int nElems) {
        int pos;
        if ((pos = pesquisarElemento(nSocio, nElems, matriz)) > -1) {
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
        System.out.printf("O participante %s não foi encontrado!", nSocio);
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
     * @param socio - array de Strings com a informação do atleta
     */
    private static void mostrarParticipante(Formatter out,
            String[] participante) {
        for (int j = 0; j < Configuracoes.N_CAMPOS_INFO; j++) {
            if (j == 1) {
                out.format("%30s;", participante[j]);
            } else {
                out.format("%12s;", participante[j]);
            }
        }
    }

    /**
     * Construção do Menu
     *
     * @return
     */
    private static int menu() {
        String texto = "\nMENU:"
                + "\n Ler … … 1"
                + "\n … 2"
                //…
                + "\n FIM … 0"
                + "\nQual a sua opção?";
        System.out.printf("%n%s%n", texto);
        int op = input.nextInt();
        input.nextLine();
        return op;
    }

    /**
     * Método main que corre o programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[][] participantes = new String[Configuracoes.MAX_PARTICIPANTES][Configuracoes.N_CAMPOS_INFO];
        int[][] provas = new int[Configuracoes.MAX_PROVAS];
        int posicao = 0;
        int opcao = 0;
        String opcaoString = "";

        Erros.initialize();
        do {
            //menu
            System.out.print("\n========MENU========\n"
                    + "Escolha a opção que pretende:\n"
                    + "\t1 - Ler ficheiro com inscrições de sócios. (FILE: inscricoes.txt)\n"
                    + "\t2 - Visualizar a informação dos sócios.\n"
                    + "\t3 - Atualizar a informação de um sócio.\n"
                    + "\t4 - Ler ficheiro com informação de inscrições. (FILE: prova1_inscricoes.txt)\n"
                    + "\t5 - Ler ficheiro com informação de tempos.\n"
                    + "\t6 - Listagem para ecrã/ficheiro da informação.\n"
                    + "\t7 - Remover um sócio e toda a sua informação.\n"
                    + "\t8 - Melhores e piores tempos por prova.\n"
                    + "\t9 - Percentagem dos socios femininos em prova.\n"
                    + "\t10 - Listagem de tempos em ficheiro.\n\n"
                    + "\t0 - Terminar. \n");

            opcaoString = scan.nextLine();

            if (utilitarios.isNumber(opcaoString)) {
                opcao = Integer.parseInt(opcaoString);
            } else {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Insira o nome do ficheiro a inserir:");
                    String fileSocios = scan.nextLine();

                    if (isFile(fileSocios)) {
                        //envia matriz para guardar a info do fich, return numSocios 
                        posicao = inserirInscricoes(participantes, provas, posicao, fileSocios);
                    } else {
                        System.out.println("O ficheiro nao existe");
                    }

                    break;
                case 2:
                    //print(tabela,numSocios); //envia matriz para fazer o print ??? printar só os 4 prim campos ou tudo?
                    if (posicao > 0) {
                        utilitarios.listarPaginado(participantes, posicao, paginacao);
                    } else {
                        System.out.println("(i) Deve escolher a opcao 1 antes de listar conteudos");
                    }
                    break;
                case 3:
                    //atualizarSocio(tabela,numSocios); //envia matriz para atualizar
                    System.out.println("Insira o nif do socio para o qual pretende alterar dados");
                    String nifActualizar = scan.nextLine();
                    System.out.println("\n -- " + utilitarios.alterarDados(participantes, nifActualizar, posicao) + " -- \n");
                    break;
                case 4:
                    //lerInscricoes(tabela,numSocios); //envia matriz para passar a info do ficheiro
                    System.out.println("Insira o nome do ficheiro de inscricoes a inserir:");
                    String fileInscricoes = scan.nextLine();
                    int provaInscrever = pedeProva();
                    if (isFile(fileInscricoes)) {
                        inscricoes(participantes, provas, posicao, fileInscricoes, provaInscrever);
                    } else {
                        System.out.println("O ficheiro nao existe");
                    }
                    break;
                case 5:
                    //lerTempos(tabela,numSocios);
                    int provaTempos = pedeProva();
                    if (utilitarios.inscricaoValida(provas, provaTempos, posicao)) {
                        String fileTempos = templateFileTempos + provaTempos + ".txt";
                        if (isFile(fileTempos)) {
                            inserirTempos(participantes, provas, posicao, fileTempos, provaTempos);
                        } else {
                            System.out.println("O ficheiro nao existe");
                        }

                    } else {
                        System.out.println("Precisa de inscrever todos os atletas antes de importar os tempos\n");
                    }

                    break;
                case 6:
                    //printOuGuardar(Megatabela,numSocios);

                    String tipoVisual = "";
                    do {
                        System.out.println("\n----\nDeseja ver a info de que modo:\n\t-(E)cra\n\t-(F)icheiro");
                        tipoVisual = scan.nextLine();
                    } while (!(tipoVisual.equalsIgnoreCase("f") || tipoVisual.equalsIgnoreCase("e")));

                    //ordenar 
                    utilitarios.ordenarArr(participantes, provas, posicao);

                    utilitarios.listarElementos(participantes, provas, posicao, tipoVisual);

                    break;
                case 7:
                    //numSocios=removerSocio(tabela,numSocios);//atualiza o numSocios   
                    System.out.println("Insira o nif do socio para o qual pretende alterar dados");
                    String nifRemover = scan.nextLine();
                    if (utilitarios.removerSocio(participantes, nifRemover, posicao)) {
                        posicao--;
                    }
                    break;
                case 8:
                    //melhoresPiores(tabela,numSocios);//calcula media dos tempos e mostra top e bottom
                    int estProva = pedeProva();
                    System.out.println("--TEMPO MEDIO-- \n" + utilitarios.tempoMedio(provas, posicao, estProva));
                    utilitarios.melhoresPiores(provas, posicao, estProva);
                    break;
                case 9:
                    //estatisticas(tabela,numSocios); //% incr --> %mulheres E após a prova %inscr que Desist ou Faltaram
                    utilitarios.percInscritos(participantes, provas, posicao);
                    break;
                case 10:
                    //guardarInfo(tabela, numSocios);//criar ficheiro Runers2016 com toda a info
                    utilitarios.guardarInfo(participantes, provas, posicao, hoje, numCamposReport);
                    break;
                case 0:
                    break;
                default:
                    break;
            }

            //menu de pausa
            if (opcao != 0) {
                System.out.println("\nPressione -ENTER- para voltar ao menu");
                scan.nextLine();
            }
        } while (opcao != 0);

    }

}
