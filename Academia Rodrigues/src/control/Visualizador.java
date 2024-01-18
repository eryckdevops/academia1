package control;

public class Visualizador {
    
    public static String visualizarPreco(float preco) {
        String string = Float.toString(preco);
        string = string.replaceAll("\\.",",");
        string = "R$ " + string;
        return string;
    }
    
    public static String visualizarRg(String rg) {
        String rgPadrao = "";
        
        if(rg.length() == 9){
            rgPadrao += rg.charAt(0);
            rgPadrao += rg.charAt(1);
            rgPadrao += ".";
            rgPadrao += rg.charAt(2);
            rgPadrao += rg.charAt(3);
            rgPadrao += rg.charAt(4);
            rgPadrao += ".";
            rgPadrao += rg.charAt(5);
            rgPadrao += rg.charAt(6);
            rgPadrao += rg.charAt(7);
            rgPadrao += "-";
            rgPadrao += rg.charAt(8);
        }
        else {
            rgPadrao += rg.charAt(0);
            rgPadrao += rg.charAt(1);
            rgPadrao += ".";
            rgPadrao += rg.charAt(2);
            rgPadrao += rg.charAt(3);
            rgPadrao += rg.charAt(4);
            rgPadrao += ".";
            rgPadrao += rg.charAt(5);
            rgPadrao += rg.charAt(6);
            rgPadrao += rg.charAt(7);
        }
        return rgPadrao;
    }

    public static String visualizarCpf(String cpf) {
        String cpfPadrao = "";
        
        cpfPadrao += cpf.charAt(0);
        cpfPadrao += cpf.charAt(1);
        cpfPadrao += cpf.charAt(2);
        cpfPadrao += ".";
        cpfPadrao += cpf.charAt(3);
        cpfPadrao += cpf.charAt(4);
        cpfPadrao += cpf.charAt(5);
        cpfPadrao += ".";
        cpfPadrao += cpf.charAt(6);
        cpfPadrao += cpf.charAt(7);
        cpfPadrao += cpf.charAt(8);
        cpfPadrao += "-";
        cpfPadrao += cpf.charAt(9);
        cpfPadrao += cpf.charAt(10);
        
        return cpfPadrao;
    }
    
    public static String visualizarCnpj(String cnpj) {
        String cnpjPadrao = "";
        
        cnpjPadrao += cnpj.charAt(0);
        cnpjPadrao += cnpj.charAt(1);
        cnpjPadrao += ".";
        cnpjPadrao += cnpj.charAt(2);
        cnpjPadrao += cnpj.charAt(3);
        cnpjPadrao += cnpj.charAt(4);
        cnpjPadrao += ".";
        cnpjPadrao += cnpj.charAt(5);
        cnpjPadrao += cnpj.charAt(6);
        cnpjPadrao += cnpj.charAt(7);
        cnpjPadrao += "/";
        cnpjPadrao += cnpj.charAt(8);
        cnpjPadrao += cnpj.charAt(9);
        cnpjPadrao += cnpj.charAt(10);
        cnpjPadrao += cnpj.charAt(11);
        cnpjPadrao += "-";
        cnpjPadrao += cnpj.charAt(12);
        cnpjPadrao += cnpj.charAt(13);
        
        return cnpjPadrao;
    }

    public static String visualizarData(String data) {
        String dataPadrao = "";
        
        dataPadrao += data.charAt(8);
        dataPadrao += data.charAt(9);
        dataPadrao += "/";
        dataPadrao += data.charAt(5);
        dataPadrao += data.charAt(6);
        dataPadrao += "/";
        dataPadrao += data.charAt(0);
        dataPadrao += data.charAt(1);
        dataPadrao += data.charAt(2);
        dataPadrao += data.charAt(3);
        
        return dataPadrao;
    }
    
    public static String visualizarPeso(float peso) {
        String string = Float.toString(peso);
        string = string.replaceAll("\\.",",");
        string = string + " Kg";
        return string;
    }
    
    public static String visualizarImc(float imc) {
        String string = Float.toString(imc);
        string = string.replaceAll("\\.",",");
        return string;
    }
    
    public static String visualizarGorduraCorporalSemPercent(int gordura) {
        String string = Integer.toString(gordura);
        string = string.replaceAll("\\.0","");
        return string;
    }
    
    public static String visualizarGorduraCorporal(int gordura) {
        String string = Integer.toString(gordura);
        string = string + "%";
        return string;
    }
    
    public static String visualizarAltura(float altura) {
        String string = Float.toString(altura);
        string = string.replaceAll("\\.",",");
        string = string + "m";
        return string;
    }

    public static String visualizarPhone(String telefone) {
        String telefonePadrao = "";
        
        telefonePadrao += "(";
        telefonePadrao += telefone.charAt(0);
        telefonePadrao += telefone.charAt(1);
        telefonePadrao += ") ";
        telefonePadrao += telefone.charAt(2);
        telefonePadrao += telefone.charAt(3);
        telefonePadrao += telefone.charAt(4);
        telefonePadrao += telefone.charAt(5);
        telefonePadrao += "-";
        telefonePadrao += telefone.charAt(6);
        telefonePadrao += telefone.charAt(7);
        telefonePadrao += telefone.charAt(8);
        telefonePadrao += telefone.charAt(9);
        
        return telefonePadrao;
    }

    public static String visualizarCell(String celular) {
        String celularPadrao = "";
        
        celularPadrao += "(";
        celularPadrao += celular.charAt(0);
        celularPadrao += celular.charAt(1);
        celularPadrao += ") ";
        celularPadrao += celular.charAt(2);
        celularPadrao += celular.charAt(3);
        celularPadrao += celular.charAt(4);
        celularPadrao += celular.charAt(5);
        celularPadrao += celular.charAt(6);
        celularPadrao += "-";
        celularPadrao += celular.charAt(7);
        celularPadrao += celular.charAt(8);
        celularPadrao += celular.charAt(9);
        celularPadrao += celular.charAt(10);
        
        return celularPadrao;
    }
    
    public static String visualizarCep(String cep) {
        String cepPadrao = "";
        
        cepPadrao += cep.charAt(0);
        cepPadrao += cep.charAt(1);
        cepPadrao += cep.charAt(2);
        cepPadrao += cep.charAt(3);
        cepPadrao += cep.charAt(4);
        cepPadrao += "-";
        cepPadrao += cep.charAt(5);
        cepPadrao += cep.charAt(6);
        cepPadrao += cep.charAt(7);
        
        return cepPadrao;
    }
    
    public static String visualizarSexo(String sexo) {
        String string;
        if (sexo.equals("f")|| sexo.equals("F")) {
            string = "Feminino";
        }
        else {
            string = "Masculino";
        }
        return string;
    }
    
    public static String visualizarGerente(boolean gerente) {
        String string;
        
        if(gerente) {
            string = "SIM";
        }
        else {
            string = "NÃO";
        }
        return string;
    }
}
