package model;

public class Cliente extends Pessoa {
    private int plano;
    private String dtVencimento;
    private float altura;
    private float peso;
    private float imc;
    private int porcentagemGorduraCorporal;
    private String ultimoAcesso;
    
    //Visualização
    private String dtVencimentoVisual;
    private String alturaVisual;
    private String pesoVisual;
    private String imcVisual;
    private String porcentagemGorduraCorporalVisual;
    private String ultimoAcessoVisual;
    
    //Pagamento
    private long diasRestantes;
    
    public Cliente(int id, String rg, String cpf, String nome, String sexo, String dtNasc, String telefone, String celular, 
            String email, String endereco, String cep, String estado, String cidade, String bairro, String cartao, int plano, 
            String dtVencimento, float altura, float peso, float imc, int porcentagemGorduraCorporal, String ultimoAcesso) {
        super(id, rg, cpf, nome, sexo, dtNasc, telefone, celular, email, endereco, cep, estado, cidade, bairro, cartao);
        this.plano = plano;
        this.dtVencimento = dtVencimento;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
        this.porcentagemGorduraCorporal = porcentagemGorduraCorporal;
        this.ultimoAcesso = ultimoAcesso;
    }

    public long getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(long diasRestantes) {
        this.diasRestantes = diasRestantes;
    }
    
    public int getPlano() {
        return plano;
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public int getPorcentagemGorduraCorporal() {
        return porcentagemGorduraCorporal;
    }

    public void setPorcentagemGorduraCorporal(int porcentagemGorduraCorporal) {
        this.porcentagemGorduraCorporal = porcentagemGorduraCorporal;
    }

    public String getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(String ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getDtVencimentoVisual() {
        return dtVencimentoVisual;
    }

    public void setDtVencimentoVisual(String dtVencimentoVisual) {
        this.dtVencimentoVisual = dtVencimentoVisual;
    }

    public String getAlturaVisual() {
        return alturaVisual;
    }

    public void setAlturaVisual(String alturaVisual) {
        this.alturaVisual = alturaVisual;
    }

    public String getPesoVisual() {
        return pesoVisual;
    }

    public void setPesoVisual(String pesoVisual) {
        this.pesoVisual = pesoVisual;
    }

    public String getImcVisual() {
        return imcVisual;
    }

    public void setImcVisual(String imcVisual) {
        this.imcVisual = imcVisual;
    }

    public String getPorcentagemGorduraCorporalVisual() {
        return porcentagemGorduraCorporalVisual;
    }

    public void setPorcentagemGorduraCorporalVisual(String porcentagemGorduraCorporalVisual) {
        this.porcentagemGorduraCorporalVisual = porcentagemGorduraCorporalVisual;
    }

    public String getUltimoAcessoVisual() {
        return ultimoAcessoVisual;
    }

    public void setUltimoAcessoVisual(String ultimoAcessoVisual) {
        this.ultimoAcessoVisual = ultimoAcessoVisual;
    }
    
    
}