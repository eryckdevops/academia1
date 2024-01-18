package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class TelaConsultaController implements Initializable {

    @FXML
    private VBox vboxoi;

    @FXML
    protected void clickHome(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaPrincipal");
    }
    
    @FXML
    protected void clickCadastrar(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastro");
    }
    
    @FXML
    protected void clickPagamento(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaPagamento");
    }
   
    @FXML
    protected void clickAutorizarAcesso(MouseEvent event) {
        //Catraca.autorizaAcesso();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.CLOSE);
        alert.setHeaderText("Acesso liberado!");
        alert.showAndWait();
    }
    
    @FXML
    protected void clickRelatorio(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorio");
    }
    
    @FXML
    protected void clickConsultaCliente(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaCliente");
    }
    
    @FXML
    protected void clickConsultaFuncionario(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaFuncionario");
    }
    
    @FXML
    protected void clickConsultaFornecedor(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaFornecedor");
    }
    
    @FXML
    protected void clickConsultaProduto(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaProduto");
    }
    
    @FXML
    protected void clickConsultaPlano(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaPlano");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
