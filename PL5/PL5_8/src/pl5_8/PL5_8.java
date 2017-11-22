package pl5_8;
//Exercício 8 (*)
//Elabore um programa em Java que permita receber um número e verificar se é um número binário.

import javax.swing.JOptionPane;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL5_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     long numero = Long.parseLong(JOptionPane.showInputDialog("Insira o número a verificar"));
        boolean binario = true;

        if (numero < 0) {
            binario = false;
        } else {
            while ((numero > 0) && (binario == true)) {
                if ((numero % 10) > 1) {
                    binario = false;
                }
                numero = numero / 10;
            }
        }
        if (binario) {
            JOptionPane.showMessageDialog(null, "O número inserido é binário");
        } else {
            JOptionPane.showMessageDialog(null, "O número inserido não é binário");
        }
    }
}
    

