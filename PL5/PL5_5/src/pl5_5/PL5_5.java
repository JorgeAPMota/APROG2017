//a) O algoritmo tem como função eliminar todos os algarismos pares do número
//inserido pelo utilizador, escrevendo o número sem os mesmos.
//Ex: 134569 -> 1359, ou seja, cria um novo número com os dígitos ímpares de um número.

package pl5_5;
import javax.swing.JOptionPane;
/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL5_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int num, dig, aux, novoNr;
    String input;

    novoNr = 0;
    aux = 1;
        
    input = JOptionPane.showInputDialog("Digite um número:");
    num = Integer.parseInt(input);
    while (num != 0) {
        dig = num % 10;

        if (dig % 2 == 1) {      // Caso seja nr ímpar
            novoNr += dig * aux; // novoNr = novoNr + dig * aux
            aux *= 10;           // aux = aux * 10
        }
        num /= 10;               // num = num / 10
    }
    JOptionPane.showMessageDialog(null, "O resultado é: " + novoNr);
    }
}
    

