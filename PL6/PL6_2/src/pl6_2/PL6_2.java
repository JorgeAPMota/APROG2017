package pl6_2;

import java.util.Scanner;

/**
 *
 * @author Jorge Mota - 1131345
 */
public class PL6_2 {
    static Scanner input = new Scanner(System.in);
    
    /**Método que cria uma barra de um gráfico de barras inserindo o título e o nr de
     * elementos correspondentes a negativas e positivas
     * @param titulo Título da barra
     * @param numero Número de elementos
     * @return Barra do gráfico
     */
    public static String criarBarra(String titulo, int numero){
        String barra = "- " + titulo + ": ";
        while(numero > 0){
            barra = barra + "*";
            numero--;
        }
        return barra;
    }
    
    /**
     * Mostrar gráfico de barras
     * @param disciplina Nome da disciplina
     * @param positivas Número de positivas
     * @param negativas Número de negativas
     */
    public static void mostrarGrafico(String disciplina, int positivas, int negativas){
        System.out.println("Disciplina : " + disciplina);
        System.out.println(criarBarra("Positivas", positivas));
        System.out.println(criarBarra("Negativas", negativas));   
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inserir a disciplina");
        String disciplina = input.nextLine();
        
        System.out.println("Insira nr de positivas");
        int positivas = input.nextInt();
        
        System.out.println("Insira nr de negativas");
        int negativas = input.nextInt();
        
        mostrarGrafico(disciplina, positivas, negativas);
    }
    
}
