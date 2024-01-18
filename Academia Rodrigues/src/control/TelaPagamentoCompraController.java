package control;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class TelaPagamentoCompraController implements Initializable {
    
    @FXML
    private Label lblTotalVenda;
    
    private static double totalVenda;
    
    public static void enviarTotal(double total) {
        totalVenda = total;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTotalVenda.setText("Total: R$ " + String.format("%10.2f", totalVenda));
    }    

    @FXML
    private void clickDinheiro(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog("R$");
        dialog.setTitle("Pagamento");
        dialog.setHeaderText("Pagamento em Dinheiro");
        dialog.setContentText("Informe o valor recebido:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            double troco = Double.parseDouble(result.toString().replaceAll("[^0-9]", "")) - totalVenda;
            if(troco < totalVenda) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Pagamento");
                alert.setHeaderText("Pagamento em dinheiro");
                alert.setContentText("Valor informado insuficiente!");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pagamento");
                alert.setHeaderText("Valor do troco");
                alert.setContentText("R$ " + String.format("%10.2f", troco));
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaPrincipal");
            }
        }
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaPrincipal");
    }

    @FXML
    private void clickCartão(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pagamento");
        alert.setHeaderText("Pagamento no Cartão");
        alert.setContentText("Venda Realizada com Sucesso!");
        alert.showAndWait();
        SistemaAcademia.changeScreen("TelaPrincipal");
    }
    
}
