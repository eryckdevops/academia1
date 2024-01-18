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
import model.ProdutoDAO;

public class TelaCadastroProdutoController implements Initializable {
    
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtPreco;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblPreco;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtQtdEstoque;
    @FXML
    private Label lblQtdEstoque;

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
            Validador.validValue(txtPreco, lblPreco, "Valor Inválido!") &
            Validador.validAmount(txtQtdEstoque, lblQtdEstoque, "Valor Inválido!") ) {
            
            String nomeProduto = txtNome.getText();
            String descricaoProduto = txtDescricao.getText();
            float precoProduto = (float)Padronizador.padronizarPreco(txtPreco.getText());
            int qtdEstoqueProduto = Integer.parseInt(txtQtdEstoque.getText());
            
            System.out.println("----------- Valores prontos para serem enviados ao Banco de Dados ------------");
            System.out.println("Nome do Produto: " + nomeProduto);
            System.out.println("Descrição do Produto: " + descricaoProduto);
            System.out.println("Preço do Produto: " + precoProduto);
            System.out.println("Quantidade em Estoque do Produto: " + qtdEstoqueProduto);
            
            if (ProdutoDAO.getInstance().cadastrar(nomeProduto, descricaoProduto, qtdEstoqueProduto, precoProduto)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Produto");
                alert.setContentText("Cadastro de produto realizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaCadastro");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Produto");
                alert.setContentText("Erro ao cadastrar o produto!");
                alert.showAndWait();
            }     
        }
    }  
}
