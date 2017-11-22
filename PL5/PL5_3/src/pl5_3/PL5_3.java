//Exercício 3 (*)
//Elabore um programa que leia uma sequência de nomes e de idades, e apresente todos
//os nomes e a percentagem de pessoas com idade maior ou igual a 18. A leitura termina
//quando for introduzido o nome “zzz”.

package pl5_3;

import javax.swing.JOptionPane;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL5_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int idade, cont_total, contM18, percent;
        String input, nome, lista;

        nome = JOptionPane.showInputDialog("Insira o nome?");

        cont_total = 0;
        contM18 = 0;
        lista = "";

        while (!nome.equals("zzz")) {
            if (!nome.equals("zzz")) {
                input = JOptionPane.showInputDialog("Insira a idade?");
                idade = Integer.parseInt(input);

                if (idade >= 18) {
                    lista += nome + "\n";
                    contM18++;
                }
            }
            cont_total++;
            nome = JOptionPane.showInputDialog("Insira o nome?");
        }
        if (contM18 > 0) {
            percent = contM18 * 100 / cont_total;
            JOptionPane.showMessageDialog(null, "Os nomes das pessoas com mais de 18 anos são: \n" + lista + "\n A percentagem de pessoas maiores de idade é de " + percent + "%.");
        } else {
            JOptionPane.showMessageDialog(null, "Não foram inseridas pessoas com idades superiores a 18 anos.");
        }
    }
}
