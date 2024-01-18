package control;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Cliente;
import model.ClienteDAO;
import model.Plano;
import model.PlanoDAO;

public class TelaPagamentoController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private TableView<Cliente> tableViewCliente;
    
    private List<Cliente> clientes;

    @FXML
    protected void clickHome(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaPrincipal");
    }
    
    @FXML
    protected void clickCadastrar(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaCadastro");
    }
    
    @FXML
    protected void clickConsultar(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaConsulta");
    }
    
    @FXML
    protected void clickAutorizarAcesso(MouseEvent event) {
        //Catraca.autorizaAcesso();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.CLOSE);
        alert.setHeaderText("Acesso liberado!");
        alert.showAndWait();
    }
    
    @FXML
    protected void clickRelatorio(MouseEvent event) {
        SistemaAcademia.changeScreen("TelaRelatorio");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Nome");
        TableColumn cpf = new TableColumn("CPF");
        TableColumn plano = new TableColumn("Plano");
        TableColumn cartao = new TableColumn("Cartão");
        TableColumn dtVencimento = new TableColumn("Data de Vencimento");
        
        TableColumn diasRestantes = new TableColumn("Dias Restantes");
            
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpfVisual"));
        plano.setCellValueFactory(new PropertyValueFactory<>("plano"));
        cartao.setCellValueFactory(new PropertyValueFactory<>("cartao"));
        dtVencimento.setCellValueFactory(new PropertyValueFactory<>("dtVencimentoVisual"));
        diasRestantes.setCellValueFactory(new PropertyValueFactory<>("diasRestantes"));
        
        tableViewCliente.getColumns().addAll(id, nome, cpf, plano, cartao, dtVencimento, diasRestantes);

        clientes = ClienteDAO.getInstance().retrieveAll();
        Iterator<Cliente> iterator = clientes.iterator();
        
        List<Cliente> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Cliente cliente = iterator.next();
            cliente.setCpfVisual(Visualizador.visualizarCpf(cliente.getCpf()));
            cliente.setDtVencimentoVisual(Visualizador.visualizarData(cliente.getDtVencimento()));
            cliente.setDiasRestantes(calcularDiasRestantes(cliente.getDtVencimento())); 
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
    private void inserirCaractere(KeyEvent event) {
        String entrada = txtNome.getText();
        
        Iterator<Cliente> iterator = clientes.iterator();
        
        List<Cliente> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if(Pattern.compile(Pattern.quote(entrada), Pattern.CASE_INSENSITIVE).matcher(cliente.getNome()).find()) {
                dados.add(cliente);
            }
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewCliente.setItems(consulta);
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaPrincipal");
    }

    @FXML
    private void clickRealizarPagamento(ActionEvent event) {
        Cliente cliente = tableViewCliente.getSelectionModel().getSelectedItem();
        if(cliente != null){
            List<Plano> planos = PlanoDAO.getInstance().retrieveGeneric("select * from acd_Planos where id_plano = '" + cliente.getPlano() + "'");
            TelaFormaPagamentoController.enviarId(cliente.getId(), planos.get(0).getValor());
            SistemaAcademia.changeScreen("TelaFormaPagamento");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pagamento");
            alert.setHeaderText("Realizar Pagamento");
            alert.setContentText("Selecione um cliente para realizar o pagamento!");
            alert.showAndWait();
        }      
    }

   private static long calcularDiasRestantes(String data) {
        
       long diferenca = 0;
       
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = data;

        try {
            Date dataVencimento = formatter.parse(dateInString);
            Date dataHoje = new Date();
            diferenca = diferencaData(dataHoje, dataVencimento, TimeUnit.DAYS);
        } catch (ParseException e) {
        }
        
        return diferenca + 1;
    }
   
    public static long diferencaData(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
}
