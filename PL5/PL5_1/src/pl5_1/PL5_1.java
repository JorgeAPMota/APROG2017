//b) Codifique-o em Java corrigindo todos os aspetos que considere relevantes, incluindo nomes de variáveis.
package pl5_1;
import javax.swing.JOptionPane;
/**
 *
 * @author 1131345 Jorge Mota
 */
public class PL5_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    mediaPares();
        
    }

    
    
    public void mediaPares(int limite, int num){
        
    int soma, pares, i;
    double media, percentPares = 0;
        
        soma = 0;
        pares = 0;
        
        do{
            limite = Integer.parseInt(JOptionPane.showInputDialog("Insira limite"));
        }while(limite <= 0);
        
       for(i = 1; i <= limite; i++){
           num = Integer.parseInt(JOptionPane.showInputDialog("Insira um número"));
           
           if(num % 2 == 0){
               pares++;
               soma += num;
           }
       }
       if(pares != 0){
           media = soma/(double)pares;
           percentPares = pares/(double)limite;
           JOptionPane.showMessageDialog(null, "Média = " + media + " Percentagem de pares = " + percentPares);
       }else{
           JOptionPane.showMessageDialog(null, "Não existem números pares");
       }
    }
 }
