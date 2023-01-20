package br.com.ada.grupo3.locadora.model;


public class Agencia implements Entidade {

    private final String nome;
    private final Endereco endereco;

    private final String telefone;

    public Agencia(String nome, Endereco endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getTelefone(){
        return telefone;
    }

    public String getId() {
        return nome;
    }

    public String getLogradouro() {
        return endereco.getLogradouro();
    }

    public Agencia getAgencia() {return new Agencia(this.nome, this.endereco, this.telefone); }

    @Override
    public String toString() {
        return String.format("""
                        Agencia
                        Nome: %s
                        Logradouro: %s
                        Numero: %s
                        Cidade: %s
                        UF: %s
                        Telefone: %s
                        """, nome, endereco.getLogradouro(), endereco.getNumero(), endereco.getCidade(),endereco.getUf(), telefone);
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }
}
