/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grandepremio2017;

/**
 *
 * @author 1131345 - Jorge Mota baseado no documento disponibilizado:
 * OrientacoesDesenvolvimentoAplicaoFinal2017.pdf - docentes de APROG DEI_ISEP
 */
public class Configuracoes {

    public final static int MAX_PARTICIPANTES = 20;
    public final static int N_DADOS_SOCIO = 4;
    public final static int N_DADOS_PROVAS = 2;
    public final static int MAX_PROVAS = 5;
//    public final static int N_CAMPOS_INFO = 4;

    public final static int MAX_LINHAS_PAGINA = 3;
    public final static String SEPARADOR_DADOS_FICH = ";";
    public final static String SEPARADOR_DADOS_FICH_PROVAS = ":";

    public final static String FICHEIRO_BACKUP = "inscricoes.txt";

    //Constantes ficheiros de erros
    private final static String FILE_LOG_ERROS_SOCIOS = "ErrosSocios.txt";
    private final static String FILE_LOG_ERROS_INSCRICOES = "ErrosInscricoes.txt";
    private final static String FILE_LOG_ERROS_TEMPOS = "ErrosTempos.txt";


}
