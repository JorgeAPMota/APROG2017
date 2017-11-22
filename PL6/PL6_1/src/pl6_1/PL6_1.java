package pl6_1;

/**
 *
 * @author 1131345 - Jorge Mota
 */
public class PL6_1 {

    /**
     * @param args the command line arguments
     */
    public static boolean metodo1(String pal) {
        boolean resposta = true;
        pal = pal.toLowerCase();                                    //Converte palavra recebida por parâmetro em minusculas
        int tamanho = pal.length();                                 //retorna o nr de caracteres da palavra recebida por parâmetro,
                                                                    // e iguala a variàvel tamanho a esse valor 
        for (int i = 0; i < tamanho / 2; i++) {                     //Percorre metade da palavra/string por input 
            if (pal.charAt(i) != pal.charAt(tamanho - 1 - i)) {     //Verifica o código ASCII da posição de cada caracter desde o ínicio até tamanho - 1 e reduzindo
                resposta = false;                                   //se for diferente retorna falso
                break;
            }
        }
        return resposta;
    }

    public static boolean metodo2(String pal) {
        int i, j;
        pal = pal.toLowerCase();
        i = 0;
        j = pal.length() - 1;
        while (i < j && pal.charAt(i) == pal.charAt(j)) {
            i++;
            j--;
        }
        return i >= j; //Se i>=j retorna true, isto é se o tamanho percorrido for diferente, logo não será palindrome
    }

//b) escolheria o método2 dado parecer ser mais eficiente e logicamente correcto
    
    
}
