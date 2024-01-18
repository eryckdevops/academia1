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
import model.Cliente;
import model.ClienteDAO;

public class TelaConsultaClienteController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private TableView<Cliente> tableViewCliente;
    
    private List<Cliente> clientes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Nome");
        TableColumn rg = new TableColumn("RG");
        TableColumn cpf = new TableColumn("CPF");
        TableColumn sexo = new TableColumn("Sexo");
        TableColumn dtNascimento = new TableColumn("Data de Nascimento");
        TableColumn peso = new TableColumn("Peso");
        TableColumn altura = new TableColumn("Altura");
        TableColumn imc = new TableColumn("Índice de Massa Corporal");
        TableColumn gordura = new TableColumn("Gordura Corporal (%)");
        TableColumn telefone = new TableColumn("Telefone");
        TableColumn celular = new TableColumn("Celular");
        TableColumn email = new TableColumn("Email");
        TableColumn bairro = new TableColumn("Bairro");
        TableColumn cep = new TableColumn("CEP");
        TableColumn endereco = new TableColumn("Endereço");
        TableColumn cidade = new TableColumn("Cidade");
        TableColumn estado = new TableColumn("Estado");
        TableColumn plano = new TableColumn("Plano");
        TableColumn cartao = new TableColumn("Cartão");
        TableColumn dtVencimento = new TableColumn("Data de Vencimento");
        TableColumn dtUltimoAcesso = new TableColumn("Último Acesso à academia");
            
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        rg.setCellValueFactory(new PropertyValueFactory<>("rgVisual"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpfVisual"));
        sexo.setCellValueFactory(new PropertyValueFactory<>("sexoVisual"));
        dtNascimento.setCellValueFactory(new PropertyValueFactory<>("dtNascVisual"));
        peso.setCellValueFactory(new PropertyValueFactory<>("pesoVisual"));
        altura.setCellValueFactory(new PropertyValueFactory<>("alturaVisual"));
        imc.setCellValueFactory(new PropertyValueFactory<>("imcVisual"));
        gordura.setCellValueFactory(new PropertyValueFactory<>("porcentagemGorduraCorporalVisual"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefoneVisual"));
        celular.setCellValueFactory(new PropertyValueFactory<>("celularVisual"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        cep.setCellValueFactory(new PropertyValueFactory<>("cepVisual"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        plano.setCellValueFactory(new PropertyValueFactory<>("plano"));
        cartao.setCellValueFactory(new PropertyValueFactory<>("cartao"));
        dtVencimento.setCellValueFactory(new PropertyValueFactory<>("dtVencimentoVisual"));
        dtUltimoAcesso.setCellValueFactory(new PropertyValueFactory<>("ultimoAcessoVisual"));
        
        tableViewCliente.getColumns().addAll(id, nome, rg, cpf, sexo, dtNascimento, peso, altura, imc, gordura, telefone,
            celular, email, endereco, bairro, cep, cidade, estado, plano, cartao, dtVencimento, dtUltimoAcesso);

        clientes = ClienteDAO.getInstance().retrieveAll();
        Iterator<Cliente> iterator = clientes.iterator();
        
        List<Cliente> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Cliente cliente = iterator.next();
            cliente.setRgVisual(Visualizador.visualizarRg(cliente.getRg()));
            cliente.setCpfVisual(Visualizador.visualizarCpf(cliente.getCpf()));
            cliente.setSexoVisual(Visualizador.visualizarSexo(cliente.getSexo()));
            cliente.setDtNascVisual(Visualizador.visualizarData(cliente.getDtNasc()));
            cliente.setAlturaVisual(Visualizador.visualizarAltura(cliente.getAltura()));
            cliente.setPesoVisual(Visualizador.visualizarPeso(cliente.getPeso()));
            cliente.setImcVisual(Visualizador.visualizarImc(cliente.getImc()));
            cliente.setPorcentagemGorduraCorporalVisual(Visualizador.visualizarGorduraCorporal(cliente.getPorcentagemGorduraCorporal()));
            cliente.setTelefoneVisual(Visualizador.visualizarPhone(cliente.getTelefone()));
            cliente.setCelularVisual(Visualizador.visualizarCell(cliente.getCelular()));
            cliente.setCepVisual(Visualizador.visualizarCep(cliente.getCep()));
            cliente.setDtVencimentoVisual(Visualizador.visualizarData(cliente.getDtVencimento()));
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
        SistemaAcademia.changeScreen("TelaConsulta");
    }

    @FXML
    private void clickEditar(ActionEvent event) {
        Cliente cliente = tableViewCliente.getSelectionModel().getSelectedItem();
        if(cliente != null){
            TelaAtualizarClienteController.enviarId(cliente.getId());
            SistemaAcademia.changeScreen("TelaAtualizarCliente");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Consulta");
            alert.setHeaderText("Consulta de Cliente");
            alert.setContentText("Selecione um cliente para atualizar!");
            alert.showAndWait();
        }
        
    }

    
}
