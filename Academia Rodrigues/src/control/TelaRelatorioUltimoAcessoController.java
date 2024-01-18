package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import model.ClienteDAO;

public class TelaRelatorioUltimoAcessoController implements Initializable {

    @FXML
    private TableView<Cliente> tableViewCliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Nome");
        TableColumn cpf = new TableColumn("CPF");
        TableColumn telefone = new TableColumn("Telefone");
        TableColumn dtUltimoAcesso = new TableColumn("Último Acesso à academia");
            
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpfVisual"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefoneVisual"));
        dtUltimoAcesso.setCellValueFactory(new PropertyValueFactory<>("ultimoAcessoVisual"));
        
        tableViewCliente.getColumns().addAll(id, nome, cpf, telefone, dtUltimoAcesso);

        List<Cliente> clientes = ClienteDAO.getInstance().retrieveAll();
        Iterator<Cliente> iterator = clientes.iterator();
        
        List<Cliente> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Cliente cliente = iterator.next();
            cliente.setCpfVisual(Visualizador.visualizarCpf(cliente.getCpf()));
            cliente.setTelefoneVisual(Visualizador.visualizarPhone(cliente.getTelefone()));
            if (cliente.getUltimoAcesso() != null)   
                cliente.setUltimoAcessoVisual(Visualizador.visualizarData(cliente.getUltimoAcesso()));
            else {
                cliente.setUltimoAcessoVisual("--");
            }
            dados.add(cliente);
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewCliente.setItems(consulta);
    }    

    @FXML
    private void clickImprimir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Impressão");
        alert.setHeaderText("Impressão de Relatório");
        alert.setContentText("Enviando o relatório para impressão!");
        alert.showAndWait();
    }

    @FXML
    private void clickConcluir(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorio");
    }
    
}
