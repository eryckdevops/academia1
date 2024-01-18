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
import model.Funcionario;
import model.FuncionarioDAO;

public class TelaConsultaFuncionarioController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private TableView<Funcionario> tableViewFuncionario;
    
    private List<Funcionario> funcionarios;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Nome");
        TableColumn rg = new TableColumn("RG");
        TableColumn cpf = new TableColumn("CPF");
        TableColumn sexo = new TableColumn("Sexo");
        TableColumn dtNascimento = new TableColumn("Data de Nascimento");
        TableColumn telefone = new TableColumn("Telefone");
        TableColumn celular = new TableColumn("Celular");
        TableColumn email = new TableColumn("Email");
        TableColumn bairro = new TableColumn("Bairro");
        TableColumn cep = new TableColumn("CEP");
        TableColumn endereco = new TableColumn("Endereço");
        TableColumn cidade = new TableColumn("Cidade");
        TableColumn estado = new TableColumn("Estado");
        TableColumn cartao = new TableColumn("Cartão");
        TableColumn dtAdmissao = new TableColumn("Data de Admissão");
        TableColumn gerente = new TableColumn("Gerente da Academia");
        TableColumn senha = new TableColumn("Senha");

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        rg.setCellValueFactory(new PropertyValueFactory<>("rgVisual"));
        cpf.setCellValueFactory(new PropertyValueFactory<>("cpfVisual"));
        sexo.setCellValueFactory(new PropertyValueFactory<>("sexoVisual"));
        dtNascimento.setCellValueFactory(new PropertyValueFactory<>("dtNascVisual"));
        telefone.setCellValueFactory(new PropertyValueFactory<>("telefoneVisual"));
        celular.setCellValueFactory(new PropertyValueFactory<>("celularVisual"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        cep.setCellValueFactory(new PropertyValueFactory<>("cepVisual"));
        endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cartao.setCellValueFactory(new PropertyValueFactory<>("cartao"));
        dtAdmissao.setCellValueFactory(new PropertyValueFactory<>("dtAdmissaoVisual"));
        gerente.setCellValueFactory(new PropertyValueFactory<>("gerenteVisual"));
        senha.setCellValueFactory(new PropertyValueFactory<>("senha"));

        tableViewFuncionario.getColumns().addAll(id, nome, rg, cpf, sexo, dtNascimento, telefone,
            celular, email, endereco, bairro, cep, cidade, estado, cartao, dtAdmissao, gerente, senha);

        funcionarios = FuncionarioDAO.getInstance().retrieveAll();
        Iterator<Funcionario> iterator = funcionarios.iterator();
        
        List<Funcionario> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            funcionario.setRgVisual(Visualizador.visualizarRg(funcionario.getRg()));
            funcionario.setCpfVisual(Visualizador.visualizarCpf(funcionario.getCpf()));
            funcionario.setSexoVisual(Visualizador.visualizarSexo(funcionario.getSexo()));
            funcionario.setDtNascVisual(Visualizador.visualizarData(funcionario.getDtNasc()));
            funcionario.setTelefoneVisual(Visualizador.visualizarPhone(funcionario.getTelefone()));
            funcionario.setCelularVisual(Visualizador.visualizarCell(funcionario.getCelular()));
            funcionario.setCepVisual(Visualizador.visualizarCep(funcionario.getCep()));
            funcionario.setDtAdmissaoVisual(Visualizador.visualizarData(funcionario.getDtAdmissao()));
            funcionario.setGerenteVisual(Visualizador.visualizarGerente(funcionario.isGerente()));
            dados.add(funcionario);
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewFuncionario.setItems(consulta);
        
    }    

    @FXML
    private void inserirCaractere(KeyEvent event) {
        String entrada = txtNome.getText();
        
        Iterator<Funcionario> iterator = funcionarios.iterator();
        
        List<Funcionario> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if(Pattern.compile(Pattern.quote(entrada), Pattern.CASE_INSENSITIVE).matcher(funcionario.getNome()).find()) {
                dados.add(funcionario);
            }
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewFuncionario.setItems(consulta);
    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsulta");
    }

    @FXML
    private void clickEditar(ActionEvent event) {
        Funcionario funcionario = tableViewFuncionario.getSelectionModel().getSelectedItem();
        if(funcionario != null){
            TelaAtualizarFuncionarioController.enviarId(funcionario.getId());
            SistemaAcademia.changeScreen("TelaAtualizarFuncionario");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Consulta");
            alert.setHeaderText("Consulta de Funcionário");
            alert.setContentText("Selecione um funcionário para atualizar!");
            alert.showAndWait();
        }
    }
}
