package pl7_4;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL7_4 {

    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);

    /**
     * Lê elementos para inserir no vector
     *
     * @param vector Vector a receber valores
     * @param nr Número de elementos
     */
    private static void lerVector(int[] vector, int nr) {
        for (int i = 0; i < nr; i++) {
            out.format("Qual o número na posição nº %d? ", i + 1);
            vector[i] = in.nextInt();
        }
    }

    /**
     * Inverte ordem dos elementos do vector
     *
     * @param vector vector a inverter
     * @param nr número de elementos
     */
    private static void inverterVector(int[] vector, int nr) {
        int aux;

        for (int i = 0; i < nr / 2; i++) {
            aux = vector[i];
            vector[i] = vector[nr - (i + 1)];
            vector[nr - (i + 1)] = aux;
        }
    }

    /**
     * Roda para a direita os valores de um vector
     *
     * @param vector vector a ser rodado
     * @param nr número de elementos
     */
    private static void rodarVector(int[] vector, int nr) {
        int aux = vector[nr - 1];

        for (int i = nr - 1; i > 0; i--) {
            vector[i] = vector[i - 1];
        }

        vector[0] = aux;
    }

    /**
     * Escreve menu e lê a opção escolhida
     *
     * @return opção seleccionada (char)
     */
    private static char menu() {
        out.format("1. Leitura de Números\n2. Inversão do Vector\n3. Apresentar Vector Invertido\n4. Rotação Vector Invertido\n5. Apresentação Vector Invertido\n6. Terminar\n\nInsira a Opção: ");
        char opt = in.next().charAt(0);
        return opt;
    }

    /**
     * Mostra os elementos do vector
     *
     * @param vector vector a apresentar
     * @param nr número de elementos
     */
    private static void mostrarVector(int[] vector, int nr) {
        for (int i = 0; i < nr; i++) {
            out.format("%d", vector[i]);
        }
        out.format("\n\n");
    }

    public static void main(String[] args) {
        int[] vector = new int[100];

        char opcao;
        int nr = 0;
        boolean invertido = false, rodado = false;

        do {
            opcao = menu();
            switch (opcao) {
                case '1':
                    int f = 0;
                    out.format("Introduza a quantidade de números a ler: ");
                    do {
                        if (f == 1) {
                            out.format("%n%s%n%s%n","nr não suportado.", "Introduza novamente a quantidade de números a ler: ");
                        }
                        nr = in.nextInt();
                        f = 1;
                    } while (nr < 0 || nr > 100);
                    lerVector(vector, nr);
                    break;
                case '2':
                    if (nr != 0) {
                        inverterVector(vector, nr);
                        invertido = true;
                        rodado = false;
                    } else {
                        out.format("Não inseriu elementos no vector.\nExecute a opção 1 da aplicação para poder continuar.\n");
                    }
                    break;
                case '3':
                    if (invertido) {
                        mostrarVector(vector, nr);
                    } else {
                        out.format("Não inverteu o vector.\nExecute a opção 2 da aplicação para poder continuar.\n");
                    }
                    break;
                case '4':
                    if (invertido) {
                        rodarVector(vector, nr);
                        rodado = true;
                        invertido = false;
                    } else {
                        out.format("%s","Não inverteu os elementos do vector.\nVerifique esta situação.\n");
                    }
                    break;
                case '5':
                    if (rodado) {
                        mostrarVector(vector, nr);
                    } else {
                        out.format("%s","Não rodou os elementos do vector.\nVerifique esta situação.\n");
                    }
                    break;
                case '6':
                    break;
                default:
                    out.format("%s", "A opção inserida não é válida");
                    break;
            }

        } while (opcao != '6');
    }
}
