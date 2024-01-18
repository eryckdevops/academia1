package model;

/**
 *
 * @author v206681
 */
public class ItemPedido {
    private int idVenda;
    private int idProduto;
    private int qtd;

    public ItemPedido(int idVenda, int idProduto, int qtd) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtd = qtd;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}