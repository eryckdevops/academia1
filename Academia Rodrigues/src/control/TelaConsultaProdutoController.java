package control;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Produto;
import model.ProdutoDAO;

public class TelaConsultaProdutoController implements Initializable {

    @FXML
    private TableView<Produto> tableViewProduto;
    @FXML
    private JFXTextField txtNome;
    
    private List<Produto> produtos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Nome");
        TableColumn descricao = new TableColumn("Descrição");
        TableColumn estoque = new TableColumn("Quantidade em estoque");
        TableColumn preco = new TableColumn("Preço");
            
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        estoque.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
        preco.setCellValueFactory(new PropertyValueFactory<>("precoVisual"));
        
        tableViewProduto.getColumns().addAll(id, nome, descricao, estoque, preco);

        produtos = ProdutoDAO.getInstance().retrieveAll();
        Iterator<Produto> iterator = produtos.iterator();
        
        List<Produto> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Produto produto = iterator.next();
            produto.setPrecoVisual(Visualizador.visualizarPreco((float)produto.getPreco()));
            dados.add(produto);
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewProduto.setItems(consulta);
    }
    
    @FXML
    private void inserirCaractere(KeyEvent event) {
        String entrada = txtNome.getText();
        
        Iterator<Produto> iterator = produtos.iterator();
        
        List<Produto> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Produto produto = iterator.next();
            if(Pattern.compile(Pattern.quote(entrada), Pattern.CASE_INSENSITIVE).matcher(produto.getNome()).find()) {
                dados.add(produto);
            }
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewProduto.setItems(consulta);
    }
    
    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsulta");
    }

    @FXML
    private void clickEditar(ActionEvent event) {
        Produto produto = tableViewProduto.getSelectionModel().getSelectedItem();
        if(produto != null){
            TelaAtualizarProdutoController.enviarId(produto.getId());
            SistemaAcademia.changeScreen("TelaAtualizarProduto");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Consulta");
            alert.setHeaderText("Consulta de Produto");
            alert.setContentText("Selecione um produto para atualizar!");
            alert.showAndWait();
        }
    }
}
