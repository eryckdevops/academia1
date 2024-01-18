package model;

public class Plano {
    private int id;
    private String nome;
    private String descricao;
    private float valor;
    private int vencimento;
    
    //Visualizacao
    private String valorVisual;

    public Plano(int id, String nome, String descricao, float valor, int vencimento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.vencimento = vencimento;
    }

    public String getValorVisual() {
        return valorVisual;
    }

    public void setValorVisual(String valorVisual) {
        this.valorVisual = valorVisual;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float preco) {
        this.valor = preco;
    }

    public int getVencimento() {
        return vencimento;
    }

    public void setVencimento(int vencimento) {
        this.vencimento = vencimento;
    }
}