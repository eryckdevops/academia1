package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class TelaCadastroController implements Initializable {

    @FXML
    private VBox vboxoi;

    @FXML
    protected void clickHome(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaPrincipal");
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.CLOSE);
        alert.setHeaderText("Acesso liberado!");
        alert.showAndWait();
    }
    
    @FXML
    protected void clickRelatorio(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorio");
    }
    
    @FXML
    protected void clickCadastroCliente(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastroCliente"); 
    }
    
    @FXML
    protected void clickCadastroFuncionario(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastroFuncionario");
    }
    
    @FXML
    protected void clickCadastroFornecedor(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastroFornecedor");
    }
    
    @FXML
    protected void clickCadastroProduto(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastroProduto");
    }
    
    @FXML
    protected void clickCadastroVenda(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastroVenda");
    }
    
    @FXML
    protected void clickCadastroPlano(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastroPlano");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
