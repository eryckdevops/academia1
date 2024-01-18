package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;

/**
 * Fornece os validadores para os campos de cadastro.
 */

public class Validador {
    
    private static final String MENSAGEM_CAMPO_VAZIO = "Campo Obrigatório!";
    private static final String MENSAGEM_CAMPO_VALIDO = "Correto!";
    
    public static boolean validName(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isNome = true;
        
        if (!entrada.getText().matches("^[\\p{L} \\.\\-\\']+$")) {
            isNome = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isNome;
    }
    
    public static boolean validDescription(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isDescription = true;
        
        if (entrada.getText().equals("")) {
            isDescription = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isDescription;
    }
    
    public static boolean validValue(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isValue = true;
        
        if (!entrada.getText().matches("^(R\\$|r\\$)? ?\\d+(\\.?|\\,?)\\d*$")) {
            isValue = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isValue;
    }
    
    public static boolean validDays(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isDays = true;
        
        if (!entrada.getText().matches("^\\d+$")) {
            isDays = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isDays;
    }
    
    public static boolean validAmount(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isAmount = true;
        
        if (!entrada.getText().matches("^\\d+$")) {
            isAmount = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isAmount;
    }
    
    public static boolean validRg(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isRG = true;
        
        if (!entrada.getText().matches("^\\d{2}\\.?\\d{3}\\.?\\d{3}(\\-?\\d{1})?$")) {
            isRG = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isRG;
    }
    
    public static boolean validCpf(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isCPF = true;
         
        if (!entrada.getText().matches("^\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}$") || !isValidCpf(Padronizador.padronizarCpf(entrada.getText()))) {
            isCPF = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isCPF;
    }
    
    public static boolean validCnpj(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isCNPJ = true;
         
        if (!entrada.getText().matches("^\\d{2}\\.?\\d{3}\\.?\\d{3}\\/?\\d{4}\\-?\\d{2}$") || !isValidCnpj(Padronizador.padronizarCnpj(entrada.getText()))) { 
            isCNPJ = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isCNPJ;
    }
    
    public static boolean validData(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isData = true;
        
        if (!entrada.getText().matches("^\\d{2}\\/\\d{2}\\/\\d{4}$")) {
            isData = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isData;
    }
    
    public static boolean validWeight(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isWeight = true;
        
        if (!entrada.getText().matches("^\\d+(\\.?|\\,?)\\d*$")) {
            isWeight = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isWeight;
    }
    
    public static boolean validHeight(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isHeight = true;
        
        if (!entrada.getText().matches("^[0-3](\\.|\\,)\\d*$")) {
            isHeight = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isHeight;
    }
    
    public static boolean validFatRate(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isFatRate = true;
        
        if (!entrada.getText().matches("^([1-9]|[1-9]\\d|100)$")) {
            isFatRate = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isFatRate;
    }
    
    public static boolean validPhone(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isPhone = true;
        
        if (!entrada.getText().matches("^\\(?\\d{2}\\)? ?\\d{4}(-| )?\\d{4}$")) {
            isPhone = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isPhone;
    }
    
    public static boolean validCellPhone(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isCellPhone = true;
        
        if (!entrada.getText().matches("^\\(?\\d{2}\\)? ?\\d{5}(-| )?\\d{4}$")) {
            isCellPhone = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isCellPhone;
    }
    
    public static boolean validEmail(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isEmail = true;
        
        if (!entrada.getText().matches("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;"
            + ":\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])"
            + "|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")) {
            isEmail = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isEmail;
    }
    
    public static boolean validDistrict(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isDistrict = true;
        
        if (!entrada.getText().matches("^[\\p{L} \\.\\-\\']+$")) {
            isDistrict = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isDistrict;
    }
    
    public static boolean validCep(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isCep = true;
        
        if (!entrada.getText().matches("^\\d{5}(-| )?\\d{3}$")) {
            isCep = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isCep;
    }
    
    public static boolean validAdress(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isAdress = true;
        
        if (!entrada.getText().matches("^[\\p{L} \\d\\.\\-\\'\\,]+$")) {
            isAdress = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isAdress;
    }
    
    public static boolean validComboBox(JFXComboBox<String> entrada, Label label, String textoValidacao) {
        boolean isSelectedBox = true;
        
        if (entrada.getValue() == null) {
            isSelectedBox = false;
            label.setStyle("-fx-text-fill: red;");
            label.setText(textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isSelectedBox;
    }
    
    public static boolean validCard(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isCard = true;
        
        if (!entrada.getText().matches("^(\\d| )+$")) {
            isCard = false;
            mostrarMensagem(entrada.getText(), label, textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isCard;
    }
    
    public static boolean validPassword(JFXTextField entrada, Label label, String textoValidacao) {
        boolean isPassword = true;
        
        if (entrada.getText().length() > 16) {
            isPassword = false;
            label.setStyle("-fx-text-fill: red;");
            label.setText(textoValidacao);
        }
        
        else {
            label.setStyle("-fx-text-fill: green;");
            label.setText(MENSAGEM_CAMPO_VALIDO);
        }
         
        return isPassword;
    }

    public static void mostrarMensagem(String entrada, Label label, String mensagem) {
        if(entrada.equals("")) {
            label.setStyle("-fx-text-fill: red;");
            label.setText(MENSAGEM_CAMPO_VAZIO);
        }
        else {
            label.setStyle("-fx-text-fill: red;");
            label.setText(mensagem);
        }
    }
  
    private static boolean isValidCpf(String cpf){
         
        if (cpf.equals("00000000000") || 
            cpf.equals("11111111111") || 
            cpf.equals("22222222222") || 
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") ||
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") ||
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") ||
            cpf.equals("99999999999") ||
            cpf.length() != 11)
            return(false);
        
        char dig10, dig11; 
        int sm, i, r, num, peso; 

        try { 
            // Calculo do primeiro Digito Verificador 
            sm = 0; 
            peso = 10; 
            for (i=0; i<9; i++) { 
                num = (int)(cpf.charAt(i) - 48); 
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig10 = '0'; 
            else 
                dig10 = (char)(r + 48); 

            // Calculo do segundo Digito Verificador 
            sm = 0; 
            peso = 11; 
            for(i=0; i<10; i++) { 
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig11 = '0'; 
            else 
                dig11 = (char)(r + 48); 

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) 
                return(true); 
            else return(false);
        } catch(Exception e) { 
            return(false); 
        } 
    }
    
    private static boolean isValidCnpj(String cnpj){
        
        if (cnpj.equals("00000000000000") || 
            cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || 
            cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || 
            cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || 
            cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || 
            cnpj.equals("99999999999999") ||
            cnpj.length() != 14)
            return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
            // Calculo do primeiro Digito Verificador
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
                num = (int)(cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            // Calculo do segundo Digito Verificador
            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(cnpj.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else dig14 = (char)((11-r) + 48);

            
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
                return(true);
            else
                return(false);
        } catch (Exception e) {
           return(false);
        }
    }
}
