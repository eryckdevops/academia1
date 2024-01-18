package model;

public class Venda {
    private int idVenda;
    private int idCliente;
    private int idFuncionario;
    private int status;
    private float total;
    private String dtVenda;
    
    //Visualização
    private String totalVisual;
    private String dtVendaVisual;

    public Venda(int idVenda, int idCliente, int idFuncionario, int status, float total, String dtVenda) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.status = status;
        this.total = total;
        this.dtVenda = dtVenda;
    }

    public String getTotalVisual() {
        return totalVisual;
    }

    public void setTotalVisual(String totalVisual) {
        this.totalVisual = totalVisual;
    }

    public String getDtVendaVisual() {
        return dtVendaVisual;
    }

    public void setDtVendaVisual(String dtVendaVisual) {
        this.dtVendaVisual = dtVendaVisual;
    }
    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }
}