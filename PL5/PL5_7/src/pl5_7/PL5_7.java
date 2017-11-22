
package pl5_7;

import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Mota
 */
public class PL5_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Declaração de todas a variáveis usadas no algoritmo.
        int a, b, aux, num, c, d, e;
        String input;

        // Leitura de duas das 4 variáveis inseridas pelo utilizador...
        input = JOptionPane.showInputDialog("Insira:");
        a = Integer.parseInt(input);
        input = JOptionPane.showInputDialog("Insira:");
        b = Integer.parseInt(input);

        // Caso a seja maior que b, é feita uma inversão entre a e b.
        if (a > b) {
            aux = a;
            a = b;
            b = aux;
        }

        e = 0;

        // É perguntado ao utilizador quantos números ele deseja inserir, para correr no ciclo 'for'.
        input = JOptionPane.showInputDialog("Quantos números pretende inserir:");
        d = Integer.parseInt(input);

        for (c = 1; c <= d; c++) {
            do {
                // Enquando o valor inserido no ciclo não for maior que 0 o ciclo não corre.
                input = JOptionPane.showInputDialog("Insira:");
                num = Integer.parseInt(input);
            } while (num <= 0);

            /**
             * Caso o resto da divisão do número por a e o resto da divisão de b
             * pelo número deiam ambas zero, encontramos um divisor e um
             * multiplo de um dado número.
             */
            if (num % a == 0 && b % num == 0) {
                e += 1;
            }
        }
        JOptionPane.showMessageDialog(null, "Foram encontrados " + e + " números que tem como divisor " + a + " e múltiplo " + b + ".");
    }
}
