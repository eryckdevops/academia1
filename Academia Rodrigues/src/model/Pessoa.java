package model;


public abstract class Pessoa {
    private int id;
    private String rg;
    private String cpf;
    private String nome;
    private String sexo;
    private String dtNasc;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String cartao;
    
    //Visualização
    private String rgVisual;
    private String cpfVisual;
    private String dtNascVisual;
    private String sexoVisual;
    private String telefoneVisual;
    private String celularVisual;
    private String cepVisual;

    public Pessoa(int id, String rg, String cpf, String nome, String sexo, String dtNasc, String telefone, String celular, String email, 
            String endereco, String cep, String estado, String cidade, String bairro, String cartao) {
        this.id = id;
        this.rg = rg;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.dtNasc = dtNasc;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cartao = cartao;
    }

    public String getSexoVisual() {
        return sexoVisual;
    }

    public void setSexoVisual(String sexoVisual) {
        this.sexoVisual = sexoVisual;
    }
    
    public String getRgVisual() {
        return rgVisual;
    }

    public void setRgVisual(String rgVisual) {
        this.rgVisual = rgVisual;
    }

    public String getCpfVisual() {
        return cpfVisual;
    }

    public void setCpfVisual(String cpfVisual) {
        this.cpfVisual = cpfVisual;
    }

    public String getDtNascVisual() {
        return dtNascVisual;
    }

    public void setDtNascVisual(String dtNascVisual) {
        this.dtNascVisual = dtNascVisual;
    }

    public String getTelefoneVisual() {
        return telefoneVisual;
    }

    public void setTelefoneVisual(String telefoneVisual) {
        this.telefoneVisual = telefoneVisual;
    }

    public String getCelularVisual() {
        return celularVisual;
    }

    public void setCelularVisual(String celularVisual) {
        this.celularVisual = celularVisual;
    }

    public String getCepVisual() {
        return cepVisual;
    }

    public void setCepVisual(String cepVisual) {
        this.cepVisual = cepVisual;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }
}