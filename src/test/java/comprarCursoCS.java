import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class comprarCursoCS {
    @Dado("^que acesso o site da Iterasys$")
    public void queAcessoOSiteDaIterasys() {
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @E("^clico na luga$")
    public void clicoNaLuga() {
    }

    @Entao("^vejo a lista de resultados para o termo \"([^\"]*)\"$")
    public void vejoAListaDeResultadosParaOTermo(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Quando("^clico em Matricule-se$")
    public void clicoEmMatriculeSe() {
    }

    @Entao("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeDoCursoComoEOPrecoDe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
