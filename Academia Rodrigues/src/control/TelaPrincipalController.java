package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

public class TelaPrincipalController implements Initializable {
 
    @FXML
    protected void clickCadastrar(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastro");
    }
    
    @FXML
    protected void clickConsultar(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsulta");
    }
    
    @FXML
    protected void clickPagamento(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaPagamento");
    }
    
    @FXML
    protected void clickAutorizarAcesso(MouseEvent event) {
        //Catraca.autorizaAcesso();
        Alert alert = new Alert(AlertType.INFORMATION, "", ButtonType.CLOSE);
        alert.setHeaderText("Acesso liberado!");
        alert.showAndWait();
    }
    
    @FXML
    protected void clickRelatorio(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorio");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
