package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class TelaRelatorioController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickHome(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaPrincipal");
    }

    @FXML
    private void clickCadastrar(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastro");
    }

    @FXML
    private void clickConsultar(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsulta");
    }

    @FXML
    private void clickPagamento(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaPagamento");
    }

    @FXML
    private void clickAutorizarAcesso(MouseEvent event) {
        //Catraca.autorizaAcesso();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.CLOSE);
        alert.setHeaderText("Acesso liberado!");
        alert.showAndWait();
    }

    @FXML
    private void clickRelatorioVenda(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorioVenda");
    }

    @FXML
    private void clickRelatorioRecebimento(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorioRecebimento");
    }

    @FXML
    private void clickRelatorioUltimoAcesso(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorioUltimoAcesso");
    }

    
}
