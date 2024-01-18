package model;

public class Funcionario extends Pessoa {
    private String dtAdmissao;
    private boolean gerente;
    private String senha;

    //Visualização
    private String dtAdmissaoVisual;
    private String gerenteVisual;
    
    public Funcionario(int id, String rg, String cpf, String nome, String sexo, String dtNasc, String telefone, String celular, 
            String email, String endereco, String cep, String estado, String cidade, String bairro, String cartao, 
            String dtAdmissao, boolean gerente, String senha) {
        super(id, rg, cpf, nome, sexo, dtNasc, telefone, celular, email, endereco, cep, estado, cidade, bairro, cartao);
        this.dtAdmissao = dtAdmissao;
        this.gerente = gerente;
        this.senha = senha;
    }

    public String getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(String dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public boolean isGerente() {
        return gerente;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDtAdmissaoVisual() {
        return dtAdmissaoVisual;
    }

    public void setDtAdmissaoVisual(String dtAdmissaoVisual) {
        this.dtAdmissaoVisual = dtAdmissaoVisual;
    }

    public String getGerenteVisual() {
        return gerenteVisual;
    }

    public void setGerenteVisual(String gerenteVisual) {
        this.gerenteVisual = gerenteVisual;
    }
    
    
}
