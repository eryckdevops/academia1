package model;

public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String celular;
    private String email;
    private String endereco;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    
    //Visualização
    private String cnpjVisual;
    private String telefoneVisual;
    private String celularVisual;
    private String cepVisual;

    public Fornecedor(int id, String nome, String cnpj, String telefone, String celular, String email, String endereco, 
            String cep, String estado, String cidade, String bairro) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCnpjVisual() {
        return cnpjVisual;
    }

    public void setCnpjVisual(String cnpjVisual) {
        this.cnpjVisual = cnpjVisual;
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
    
    
}