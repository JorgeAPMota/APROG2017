package pl5_2;
//Exercício 2 (*)
//Descreva um algoritmo e codifique-o em Java, em que dadas as temperaturas máximas

import javax.swing.JOptionPane;

//registadas em N dias classifique o dia com a temperatura máxima mais elevada, de
//acordo com a tabela abaixo. Caso a temperatura máxima mais elevada ocorrida nos 
//N dias seja menor que -30ºC ou maior ou igual a 50ºC deverá ser enviada ao utilizador
//a mensagem “Temperatura extrema”. Para a resolução do exercício considere que todas
//as temperaturas máximas introduzidas têm valores inteiros.
//-30ºC ≤ Temp <9 ºC Muito Frio
//9ºC ≤ Temp <15 ºC  Frio
//15ºC ≤ Temp<20 ºC  Ameno
//20ºC ≤ Temp<30ºC   Quente
//30ºC ≤ Temp<50 ºC  Muito Quente
/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL5_2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int nDias, i, temp, dia, tempMax;
        String input;

        dia = 0;
        tempMax = Integer.MIN_VALUE;

        input = JOptionPane.showInputDialog("Quer inserir as temperaturas de quantos dias?");
        nDias = Integer.parseInt(input);

        for (i = 1; i <= nDias; i++) {
            input = JOptionPane.showInputDialog("Insira uma temperatura!");
            temp = Integer.parseInt(input);

            if (temp < -30 || temp >= 50) {
                JOptionPane.showMessageDialog(null, "Temperatura Extrema");
            } else if (temp < 9) {
                JOptionPane.showMessageDialog(null, "Muito Frio");
            } else if (temp < 15) {
                JOptionPane.showMessageDialog(null, "Frio");
            } else if (temp < 20) {
                JOptionPane.showMessageDialog(null, "Ameno");
            } else if (temp < 30) {
                JOptionPane.showMessageDialog(null, "Quente");
            } else {
                JOptionPane.showMessageDialog(null, "Muito Quente");
            }
            if (temp > tempMax) {
                tempMax = temp;
                dia = i;
            }
        }
        if (dia != 0) {
            JOptionPane.showMessageDialog(null, "A temperatura mais alta registada, foi de " + tempMax + "ºC e ocorreu no dia " + dia + ".");
        }
    }
    
}
