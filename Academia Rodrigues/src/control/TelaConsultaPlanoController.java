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
import model.Plano;
import model.PlanoDAO;

public class TelaConsultaPlanoController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private TableView<Plano> tableViewPlano;
    
    private List<Plano> planos;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Nome");
        TableColumn descricao = new TableColumn("Descrição");
        TableColumn valor = new TableColumn("Valor");
        TableColumn vencimento = new TableColumn("Vencimendo (em dias)");
            
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        valor.setCellValueFactory(new PropertyValueFactory<>("valorVisual"));
        vencimento.setCellValueFactory(new PropertyValueFactory<>("vencimento"));
        
        tableViewPlano.getColumns().addAll(id, nome, descricao, valor, vencimento);

        planos = PlanoDAO.getInstance().retrieveAll();
        Iterator<Plano> iterator = planos.iterator();
        
        List<Plano> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Plano plano = iterator.next();
            plano.setValorVisual(Visualizador.visualizarPreco((float)plano.getValor()));
            dados.add(plano);
        }
        
        /*Plano plano = new Plano(iterator.next().getId(), iterator.next().getNome(), iterator.next().getDescricao(),
                    Visualizador.visualizarPreco(iterator.next().getValor()), iterator.next().getVencimento());
            dados.add(plano);*/
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewPlano.setItems(consulta);
    }    

    @FXML
    private void inserirCaractere(KeyEvent event) {
        String entrada = txtNome.getText();
        
        Iterator<Plano> iterator = planos.iterator();
        
        List<Plano> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Plano plano = iterator.next();
            if(Pattern.compile(Pattern.quote(entrada), Pattern.CASE_INSENSITIVE).matcher(plano.getNome()).find()) {
                dados.add(plano);
            }
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewPlano.setItems(consulta);
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsulta");
    }

    @FXML
    private void clickEditar(ActionEvent event) {
        Plano plano = tableViewPlano.getSelectionModel().getSelectedItem();
        if(plano != null){
            TelaAtualizarPlanoController.enviarId(plano.getId());
            SistemaAcademia.changeScreen("TelaAtualizarPlano");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Consulta");
            alert.setHeaderText("Consulta de Plano");
            alert.setContentText("Selecione um plano para atualizar!");
            alert.showAndWait();
        }
    }
    
}
