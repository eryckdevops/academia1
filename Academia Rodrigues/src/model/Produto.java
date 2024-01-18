package model;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int qtdEstoque;
    private float preco;
    
    //Visualização
    private String precoVisual;

    public Produto(int id, String nome, String descricao, int qtdEstoque, float preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getPrecoVisual() {
        return precoVisual;
    }

    public void setPrecoVisual(String precoVisual) {
        this.precoVisual = precoVisual;
    }
    

}