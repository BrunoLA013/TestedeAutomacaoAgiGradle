import br.com.blogdoai.base.PaginaPOO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class testNavegaca extends PaginaPOO {

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorCDBParaTesteMenorResolucao() throws IOException {
        preencheComPesquisaValidaResolucaoMenor(palavraChaveSucesso);
        //tiraPrintDoResultado();
        verificaSePalavraComSucessoFoiExibida(palavraChaveSucesso);
    }

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorDataDePublicacaoNaoEncontraMenorResolucao() throws IOException {
        preencheComPesquisaValidaResolucaoMenor(palavraChaveErro);
        //tiraPrintDoResultado();
        verificaSePalavraComErroFoiExibida(palavraChaveErro);
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarPorCDB() throws IOException {
        maximizaTela();
        preencheComPesquisaValidaResolucaoMaior(palavraChaveSucesso);
      //  tiraPrintDoResultado();
        verificaSePalavraComSucessoFoiExibida(palavraChaveSucesso);
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarPorDataDePublicacaoNaoEncontra() throws IOException {
        maximizaTela();
        preencheComPesquisaValidaResolucaoMaior(palavraChaveErro);
       // tiraPrintDoResultado();
        verificaSePalavraComErroFoiExibida(palavraChaveErro);
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarVerificaExistenciaDeConteudoAbrePrimeiroDaLista() throws IOException {
        maximizaTela();
        preencheComPesquisaValidaResolucaoMaior(palavraComNavecacao);
        verificaMensageConfirmaExistenciaDaPalavraENavaga(palavraComNavecacao);
       // tiraPrintDoResultado();
        verificaENavega(palavraComNavecacao);
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarSemArgumentos() throws IOException {
        maximizaTela();
        pesquisaSemString();
        //tiraPrintDoResultado();
        verificaMensageSemPesquisa();
        System.out.println("Teste com sucesso");
    }
}
