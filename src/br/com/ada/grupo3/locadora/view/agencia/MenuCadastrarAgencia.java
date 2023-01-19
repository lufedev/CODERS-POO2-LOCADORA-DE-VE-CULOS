package br.com.ada.grupo3.locadora.view.agencia;

import br.com.ada.grupo3.locadora.domain.AgenciaManager;
import br.com.ada.grupo3.locadora.model.Agencia;
import br.com.ada.grupo3.locadora.model.Endereco;
import br.com.ada.grupo3.locadora.view.CapturadorDeEntrada;
import br.com.ada.grupo3.locadora.view.MenuAbstrato;

public class MenuCadastrarAgencia extends MenuAbstrato {

    private final AgenciaManager gerenciadorDeAgencia;
    public MenuCadastrarAgencia(AgenciaManager gerenciadorDeAgencia) {
        super("Adicionar agência");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarStringNaoVazia("nome da nova agência").toUpperCase();

        while (gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Já existe uma agência com o nome " + nome);
            nome = CapturadorDeEntrada.capturarStringNaoVazia("nome da nova agência").toUpperCase();
        }
        String logradouro = CapturadorDeEntrada.capturarStringNaoVazia("logradouro da nova agência");
        int numero = CapturadorDeEntrada.capturarInteger("número da nova agência");
        String cidade = CapturadorDeEntrada.capturarStringNaoVazia("cidade da nova agência");
        String uf = CapturadorDeEntrada.capturarStringNaoVazia("UF da nova agência");
        String telefone = CapturadorDeEntrada.capturarStringNaoVazia("Telefone da nova agência");

        Agencia agencia = gerenciadorDeAgencia.criarAgencia(nome, new Endereco(logradouro, numero, cidade, uf), telefone);

        System.out.println("Agência adicionada com sucesso");
        System.out.println("Nova agência:");
        System.out.println(agencia);
    }
}
