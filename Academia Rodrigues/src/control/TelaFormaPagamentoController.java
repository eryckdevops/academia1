package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.ClienteDAO;

public class TelaFormaPagamentoController implements Initializable {
    
    @FXML
    private Label lblValorPlano;

    private static int idCliente;
    private static float valorPlano;
    
    public static void enviarId(int id, float valor) {
        idCliente = id;
        valorPlano = valor;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblValorPlano.setText("Valor do Plano: R$ " + String.format("%10.2f", valorPlano));
    }    

    @FXML
    private void clickCartão(MouseEvent event) {
        if(ClienteDAO.getInstance().pagar(idCliente)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento");
            alert.setHeaderText("Realizar Pagamento");
            alert.setContentText("Pagamento Realizado com Sucesso!");
            alert.showAndWait();
            SistemaAcademia.changeScreen("TelaPagamento");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento");
            alert.setHeaderText("Realizar Pagamento");
            alert.setContentText("Não foi possível realizar o pagamento!");
            alert.showAndWait();
        }        
    }
    
    @FXML
    private void clickDinheiro(MouseEvent event) {
        if(ClienteDAO.getInstance().pagar(idCliente)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento");
            alert.setHeaderText("Realizar Pagamento");
            alert.setContentText("Pagamento Realizado com Sucesso!");
            alert.showAndWait();
            SistemaAcademia.changeScreen("TelaPagamento");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento");
            alert.setHeaderText("Realizar Pagamento");
            alert.setContentText("Não foi possível realizar o pagamento!");
            alert.showAndWait();
        }  
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaPagamento");
    }
}
