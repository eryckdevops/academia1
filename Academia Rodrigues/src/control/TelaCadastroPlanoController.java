package control;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.PlanoDAO;

public class TelaCadastroPlanoController implements Initializable {

    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXTextField txtQtdDias;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblQtdDias;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    


    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaCadastro");
    }

    @FXML
    private void clickSalvar(ActionEvent event) {
        if( Validador.validName(txtNome, lblNome, "Nome Inválido!") &
            Validador.validDescription(txtDescricao, lblDescricao, "Descrição Inválida!") &
            Validador.validValue(txtValor, lblValor, "Valor Inválido!") &
            Validador.validDays(txtQtdDias, lblQtdDias, "Valor Inválido!") ) {
            
            String nomePlano = txtNome.getText();
            String descricaoPlano = txtDescricao.getText();
            float valorPlano = (float)Padronizador.padronizarPreco(txtValor.getText());
            int qtdDiasPlano = Integer.parseInt(txtQtdDias.getText());
            
            System.out.println("----------- Valores prontos para serem enviados ao Banco de Dados ------------");
            System.out.println("Nome do Plano: " + nomePlano);
            System.out.println("Descrição do Plano: " + descricaoPlano);
            System.out.println("Valor do Plano: " + valorPlano);
            System.out.println("Quantidade de Dias do Plano: " + qtdDiasPlano);
            
            if (PlanoDAO.getInstance().cadastrar(nomePlano, descricaoPlano, valorPlano, qtdDiasPlano)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Plano");
                alert.setContentText("Cadastro de plano realizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaCadastro");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Plano");
                alert.setContentText("Erro ao cadastrar o plano!");
                alert.showAndWait();
            }     
        }   
    }  
}
