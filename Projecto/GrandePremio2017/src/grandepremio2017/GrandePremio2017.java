/*
 * To change this license header, choose License Headers input Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template input the editor.
 */
package grandepremio2017;

import static grandepremio2017.Utilitarios.input;
import java.io.File;
import java.io.FileNotFoundException;
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
    public static int lerInfoFicheiroParaMemoria( Configuracoes.FICHEIRO_BACKUP, String[][] info, int nElems) throws FileNotFoundException {
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
    public static void main(String[] args) {
        String[] provas = new String[Configuracoes.MAX_PROVAS];
        String[][] participantes = new String[Configuracoes.MAX_PARTICIPANTES][Configuracoes.N_CAMPOS_INFO];
        int nParticipantes = 0;
        //    int[][] tempos = {25,30,31,32,33,33,26,27,28,29,23,24,36,37} ;
        double[][] premios = new double[Configuracoes.MAX_PARTICIPANTES][Configuracoes.N_PROVAS];
        int op;

        do {
            op = menu();
            switch (op) {
                case 1:
//
                    break;
                case 2:
// …………………………………………………..
                case 0:
                    System.out.println("FIM");
                    break;
                default:
                    System.out.println("Opção incorreta. Repita");
                    break;
            }
        } while (op != 0);
    }

}
