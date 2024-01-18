package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.Funcionario;
import model.FuncionarioDAO;

public class TelaAtualizarFuncionarioController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtRg;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private ToggleGroup sexo;
    @FXML
    private JFXTextField txtDtNascimento;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtCelular;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXComboBox<String> comboBoxEstado;
    @FXML
    private JFXTextField txtCartao;
    @FXML
    private JFXTextField txtSenha;
    @FXML
    private JFXTextField txtDtAdmissao;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblRg;
    @FXML
    private Label lblCpf;
    @FXML
    private Label lblDtNascimento;
    @FXML
    private Label lblTelefone;
    @FXML
    private Label lblCelular;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblCep;
    @FXML
    private Label lblEndereco;
    @FXML
    private Label lblCidade;
    @FXML
    private Label lblBairro;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblDtAdmissao;
    @FXML
    private Label lblCartao;
    @FXML
    private Label lblSenha;
    @FXML
    private JFXToggleButton isGerente;

    private static int idFuncionario;
    
    public static void enviarId(int id) {
        idFuncionario = id;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxEstado.getItems().add("Acre");
        comboBoxEstado.getItems().add("Alagoas");
        comboBoxEstado.getItems().add("Amapá");
        comboBoxEstado.getItems().add("Amazonas");
        comboBoxEstado.getItems().add("Bahia");
        comboBoxEstado.getItems().add("Ceará");
        comboBoxEstado.getItems().add("Distrito Federal");
        comboBoxEstado.getItems().add("Espírito Santo");
        comboBoxEstado.getItems().add("Goiás");
        comboBoxEstado.getItems().add("Maranhão");
        comboBoxEstado.getItems().add("Mato Grosso");
        comboBoxEstado.getItems().add("Mato Grosso do Sul");
        comboBoxEstado.getItems().add("Minas Gerais");
        comboBoxEstado.getItems().add("Pará");
        comboBoxEstado.getItems().add("Paraíba");
        comboBoxEstado.getItems().add("Pernambuco");
        comboBoxEstado.getItems().add("Piauí");
        comboBoxEstado.getItems().add("Rio de Janeiro");
        comboBoxEstado.getItems().add("Rio Grande do Norte");
        comboBoxEstado.getItems().add("Rio Grande do Sul");
        comboBoxEstado.getItems().add("Rondônia");
        comboBoxEstado.getItems().add("Roraima");
        comboBoxEstado.getItems().add("Santa Catarina");
        comboBoxEstado.getItems().add("São Paulo");
        comboBoxEstado.getItems().add("Sergipe");
        comboBoxEstado.getItems().add("Tocantins");
        
        List<Funcionario> funcionarios = FuncionarioDAO.getInstance().retrieveGeneric("SELECT * FROM consultarFuncionarios WHERE id_funcionario = " + idFuncionario);
        Iterator<Funcionario> iterator = funcionarios.iterator();
        
        while(iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if(funcionario.getId() == idFuncionario) {
                txtNome.setText(funcionario.getNome());                
                txtRg.setText(funcionario.getRg());                
                txtCpf.setText(funcionario.getCpf()); 
//                sexo.setValue(funcionario.getSexo());
                txtDtNascimento.setText(Visualizador.visualizarData(funcionario.getDtNasc()));                               
                txtTelefone.setText(funcionario.getTelefone());                
                txtCelular.setText(funcionario.getCelular());                
                txtEmail.setText(funcionario.getEmail());                
                txtBairro.setText(funcionario.getBairro());                
                txtCep.setText(funcionario.getCep());                
                txtEndereco.setText(funcionario.getEndereco());                
                txtCidade.setText(funcionario.getCidade());  
                txtCartao.setText(funcionario.getCartao());
                comboBoxEstado.getSelectionModel().select(funcionario.getEstado());
                txtDtAdmissao.setText(Visualizador.visualizarData(funcionario.getDtAdmissao()));
                txtSenha.setText(funcionario.getSenha());
            }
        }
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaFuncionario");
    }

    @FXML
    private void clickAtualizar(ActionEvent event) {
        if( Validador.validName(txtNome, lblNome, "Nome Inválido!") &
            Validador.validRg(txtRg, lblRg, "RG Inválido!") &
            Validador.validCpf(txtCpf, lblCpf, "CPF Inválido!") &
            Validador.validData(txtDtNascimento, lblDtNascimento, "Data Inválida!") &
            Validador.validPhone(txtTelefone, lblTelefone, "Telefone Inválido!") &
            Validador.validCellPhone(txtCelular, lblCelular, "Celular Inválido!") &
            Validador.validEmail(txtEmail, lblEmail, "Email Inválido!") &
            Validador.validDistrict(txtBairro, lblBairro, "Bairro Inválido!") &
            Validador.validCep(txtCep, lblCep, "CEP Inválido!") &
            Validador.validAdress(txtEndereco, lblEndereco, "Endereço Inválido!") &
            Validador.validDistrict(txtCidade, lblCidade, "Cidade Inválida!") &
            Validador.validComboBox(comboBoxEstado, lblEstado, "Selecione um Estado!") &
            Validador.validPassword(txtSenha, lblSenha, "Senha inválida!") &
            Validador.validData(txtDtAdmissao, lblDtAdmissao, "Data inválida!") &
            Validador.validCard(txtCartao, lblCartao, "Cartão Inválido!") ) {
            
            RadioButton genero = (RadioButton) sexo.getSelectedToggle();
            
            String nomeCliente = txtNome.getText();
            String rgCliente = Padronizador.padronizarRg(txtRg.getText());
            String cpfCliente = Padronizador.padronizarCpf(txtCpf.getText());
            String dtNascimentoCliente = Padronizador.padronizarData(txtDtNascimento.getText());
            String sexoCliente = genero.getText();
            String senha = txtSenha.getText();
            String dtAdmissao = Padronizador.padronizarData(txtDtAdmissao.getText());
            String telefoneCliente = Padronizador.padronizarPhone(txtTelefone.getText());
            String celularCliente = Padronizador.padronizarPhone(txtCelular.getText());
            String emailCliente = txtEmail.getText();
            String bairroCliente = txtBairro.getText();
            String cepCliente = Padronizador.padronizarCep(txtCep.getText());
            String enderecoCliente = txtEndereco.getText();
            String cidadeCliente = txtCidade.getText();
            String estadoCliente = comboBoxEstado.getValue();
            String cartaoCliente = txtCartao.getText();
            
            Funcionario funcionario = new Funcionario(idFuncionario, rgCliente, cpfCliente, nomeCliente, sexoCliente, 
                dtNascimentoCliente, telefoneCliente, celularCliente, emailCliente, enderecoCliente, cepCliente, estadoCliente,
                cidadeCliente, bairroCliente, cartaoCliente, dtAdmissao, false, senha);
            
            if (FuncionarioDAO.getInstance().atualizar(funcionario)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Funcionário");
                alert.setContentText("Funcionário atualizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaFuncionario");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Funcionário");
                alert.setContentText("Erro ao atualizar o funcionário!");
                alert.showAndWait();
            } 
        }
    }
    
    @FXML
    private void clickExcluir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir este funcionário?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exclusão");
        alert.setHeaderText("Exclusão de Funcionário");
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.YES) {
            if (FuncionarioDAO.getInstance().remover(idFuncionario)) {
                Alert retorno = new Alert(Alert.AlertType.INFORMATION);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Funcionário");
                retorno.setContentText("Funcionário excluído com sucesso!");
                retorno.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaFuncionario");
            }
            else {
                Alert retorno = new Alert(Alert.AlertType.ERROR);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Funcionário");
                retorno.setContentText("Erro ao excluir o funcionário!");
                retorno.showAndWait();
            }
        }
    }
 
}
