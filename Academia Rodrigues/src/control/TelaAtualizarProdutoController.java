package control;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.Produto;
import model.ProdutoDAO;

public class TelaAtualizarProdutoController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtPreco;
    @FXML
    private JFXTextField txtQtdEstoque;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblPreco;
    @FXML
    private Label lblQtdEstoque;
    
    private static int idProduto;
    
    public static void enviarId(int id) {
        idProduto = id;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Produto> produtos = ProdutoDAO.getInstance().retrieveGeneric("SELECT * FROM acd_Produtos WHERE id_produto = " + idProduto);
        Iterator<Produto> iterator = produtos.iterator();
        
        while(iterator.hasNext()) {
            Produto produto = iterator.next();
            if(produto.getId() == idProduto) {
                txtNome.setText(produto.getNome());
                txtDescricao.setText(produto.getDescricao());
                txtPreco.setText(Float.toString((float)produto.getPreco()));
                txtQtdEstoque.setText(Integer.toString(produto.getQtdEstoque()));
            }
        }
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaProduto");
    }
    
    @FXML
    private void clickExcluir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir este produto?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exclusão");
        alert.setHeaderText("Exclusão de Produto");
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.YES) {
            if (ProdutoDAO.getInstance().remover(idProduto)) {
                Alert retorno = new Alert(Alert.AlertType.INFORMATION);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Produto");
                retorno.setContentText("Produto excluído com sucesso!");
                retorno.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaProduto");
            }
            else {
                Alert retorno = new Alert(Alert.AlertType.ERROR);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Produto");
                retorno.setContentText("Erro ao excluir o produto!");
                retorno.showAndWait();
            }
        }
    }

    @FXML
    private void clickAtualizar(ActionEvent event) {
        if( Validador.validName(txtNome, lblNome, "Nome Inválido!") &
            Validador.validDescription(txtDescricao, lblDescricao, "Descrição Inválida!") &
            Validador.validValue(txtPreco, lblPreco, "Valor Inválido!") &
            Validador.validAmount(txtQtdEstoque, lblQtdEstoque, "Valor Inválido!") ) {
            
            String nomeProduto = txtNome.getText();
            String descricaoProduto = txtDescricao.getText();
            float precoProduto = (float)Padronizador.padronizarPreco(txtPreco.getText());
            int qtdEstoqueProduto = Integer.parseInt(txtQtdEstoque.getText());
            
            Produto produto = new Produto(idProduto, nomeProduto, descricaoProduto, qtdEstoqueProduto, (float) precoProduto);
            
            if (ProdutoDAO.getInstance().atualizar(produto)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Produto");
                alert.setContentText("Produto atualizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaProduto");
            }
            
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Produto");
                alert.setContentText("Erro ao atualizar o produto!");
                alert.showAndWait();
            }     
        }
    }  
}
