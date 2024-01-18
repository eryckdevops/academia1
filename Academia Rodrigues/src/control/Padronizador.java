package control;

public class Padronizador {
    
    public static float padronizarPreco(String preco) {
        preco = preco.replaceAll("r|R| |\\$", "");
        preco = preco.replaceAll(",", ".");
        
        return Float.parseFloat(preco);
    }
    
    public static String padronizarRg(String rg) {
        rg = rg.replaceAll("\\.|\\-", "");
        return rg;
    }
    
    public static String padronizarCpf(String cpf) {
        cpf = cpf.replaceAll("\\.|\\-", "");
        return cpf;
    }
    
    public static String padronizarCnpj(String cnpj) {
        cnpj = cnpj.replaceAll("\\.|\\/|\\-", "");
        return cnpj;
    }
    
    public static String padronizarData(String data) {
        String dataSql = "";
        
        dataSql += data.charAt(6);
        dataSql += data.charAt(7);
        dataSql += data.charAt(8);
        dataSql += data.charAt(9);
        dataSql += "-";
        dataSql += data.charAt(3);
        dataSql += data.charAt(4);
        dataSql += "-";
        dataSql += data.charAt(0);
        dataSql += data.charAt(1);
        
        return dataSql;
    }
    
    public static float padronizarPeso(String peso) {
        peso = peso.replaceAll("\\,", "");
        return Float.parseFloat(peso);
    }
    
    public static float padronizarAltura(String altura) {
        altura = altura.replaceAll("\\,", "");
        return Float.parseFloat(altura);
    }
    
    public static String padronizarPhone(String telefone) {
        telefone = telefone.replaceAll("\\(|\\)| |\\-", "");
        return telefone;
    }
    
    public static String padronizarCep(String cep) {
        cep = cep.replaceAll(" |\\-", "");
        return cep;
    }
}
