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
import model.Venda;
import model.VendaDAO;

public class TelaRelatorioVendaController implements Initializable {

    @FXML
    private TableView<Venda> tableViewVenda;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn idVenda = new TableColumn("ID da Venda");
        TableColumn idCliente = new TableColumn("ID do Cliente");
        TableColumn idFuncionario = new TableColumn("ID do Funcionário");
        TableColumn total = new TableColumn("Valor Total");
        TableColumn dtVenda = new TableColumn("Data da Venda");
            
        idVenda.setCellValueFactory(new PropertyValueFactory<>("idVenda"));
        idCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        idFuncionario.setCellValueFactory(new PropertyValueFactory<>("idFuncionario"));
        total.setCellValueFactory(new PropertyValueFactory<>("totalVisual"));
        dtVenda.setCellValueFactory(new PropertyValueFactory<>("dtVendaVisual"));
        
        tableViewVenda.getColumns().addAll(idVenda, idCliente, idFuncionario, total, dtVenda);

        List<Venda> vendas = VendaDAO.getInstance().retrieveAll();
        Iterator<Venda> iterator = vendas.iterator();
        
        List<Venda> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Venda venda = iterator.next();
            venda.setTotalVisual(Visualizador.visualizarPreco(venda.getTotal()));
            venda.setDtVendaVisual(Visualizador.visualizarData(venda.getDtVenda()));
            dados.add(venda);
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewVenda.setItems(consulta);
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
