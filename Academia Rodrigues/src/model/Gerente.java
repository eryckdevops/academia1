package model;

public class Gerente extends Funcionario {

    public Gerente(int id, String rg, String cpf, String nome, String sexo, String dtNasc, String telefone, String celular, 
            String email, String endereco, String cep, String estado, String cidade, String bairro, String cartao, 
            String dtAdmissao, boolean gerente, String senha) {
        super(id, rg, cpf, nome, sexo, dtNasc, telefone, celular, email, endereco, cep, estado, cidade, bairro, cartao, dtAdmissao, gerente, senha);
    }

    public void gerarRelatorio() {
        
    }
}
