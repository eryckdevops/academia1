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
import model.Fornecedor;
import model.FornecedorDAO;

public class TelaConsultaFornecedorController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private TableView<Fornecedor> tableViewFornecedor;
    
    private List<Fornecedor> fornecedores;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Nome");
        TableColumn cnpj = new TableColumn("CNPJ");
        TableColumn telefone = new TableColumn("Telefone");
        TableColumn celular = new TableColumn("Celular");
        TableColumn email = new TableColumn("E-mail");
        TableColumn endereco = new TableColumn("Endereço");
        TableColumn bairro = new TableColumn("Bairro");
        TableColumn cep = new TableColumn("CEP");
        TableColumn estado = new TableColumn("Estado");
        TableColumn cidade = new TableColumn("Cidade");
            
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cnpj.setCellValueFactory(new PropertyValueFactory<>("cnpjVisual"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefoneVisual"));
        celular.setCellValueFactory(new PropertyValueFactory<>("celularVisual"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        cep.setCellValueFactory(new PropertyValueFactory<>("cepVisual"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        
        tableViewFornecedor.getColumns().addAll(id, nome, cnpj, telefone, celular, email, endereco, bairro, cep, estado, cidade);

        fornecedores = FornecedorDAO.getInstance().retrieveAll();
        Iterator<Fornecedor> iterator = fornecedores.iterator();
        
        List<Fornecedor> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Fornecedor fornecedor = iterator.next();
            fornecedor.setCnpjVisual(Visualizador.visualizarCnpj(fornecedor.getCnpj()));
            fornecedor.setTelefoneVisual(Visualizador.visualizarPhone(fornecedor.getTelefone()));
            fornecedor.setCelularVisual(Visualizador.visualizarCell(fornecedor.getCelular()));
            fornecedor.setCepVisual(Visualizador.visualizarCep(fornecedor.getCep()));
            dados.add(fornecedor);
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewFornecedor.setItems(consulta);
    }    

    @FXML
    private void inserirCaractere(KeyEvent event) {
        String entrada = txtNome.getText();
        
        Iterator<Fornecedor> iterator = fornecedores.iterator();
        
        List<Fornecedor> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Fornecedor fornecedor = iterator.next();
            if(Pattern.compile(Pattern.quote(entrada), Pattern.CASE_INSENSITIVE).matcher(fornecedor.getNome()).find()) {
                dados.add(fornecedor);
            }
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewFornecedor.setItems(consulta);
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsulta");
    }

    @FXML
    private void clickEditar(ActionEvent event) {
        Fornecedor fornecedor = tableViewFornecedor.getSelectionModel().getSelectedItem();
        if(fornecedor != null){
            TelaAtualizarFornecedorController.enviarId(fornecedor.getId());
            SistemaAcademia.changeScreen("TelaAtualizarFornecedor");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Consulta");
            alert.setHeaderText("Consulta de Fornecedores");
            alert.setContentText("Selecione um fornecedor para atualizar!");
            alert.showAndWait();
        }
    }
    
}
