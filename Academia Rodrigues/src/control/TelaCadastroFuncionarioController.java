package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.FuncionarioDAO;

public class TelaCadastroFuncionarioController implements Initializable {

    @FXML
    private JFXTextField txtDtNascimento;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtCelular;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtRg;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtCartao;
    @FXML
    private JFXTextField txtSenha;
    @FXML
    private JFXTextField txtDtAdmissao;
    @FXML
    private ToggleGroup sexo;
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
    private JFXComboBox<String> comboBoxEstado;
    @FXML
    private Label lblSenha;
    @FXML
    private JFXToggleButton isGerente;
   
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
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaCadastro");
    }

    @FXML
    private void clickSalvar(ActionEvent event) {
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
            Validador.validData(txtDtAdmissao, lblDtAdmissao, "Data Inválida!") & 
            Validador.validCard(txtCartao, lblCartao, "Cartão Inválido!") & 
            Validador.validPassword(txtSenha, lblSenha, "Senha deve ter no máximo 16 caracteres!") ) {
            
            RadioButton genero = (RadioButton) sexo.getSelectedToggle();
            
            String nomeFuncionario = txtNome.getText();
            String rgFuncionario = Padronizador.padronizarRg(txtRg.getText());
            String cpfFuncionario = Padronizador.padronizarCpf(txtCpf.getText());
            String dtNascimentoFuncionario = Padronizador.padronizarData(txtDtNascimento.getText());
            String sexoFuncionario = genero.getText();
            String telefoneFuncionario = Padronizador.padronizarPhone(txtTelefone.getText());
            String celularFuncionario = Padronizador.padronizarPhone(txtCelular.getText());
            String emailFuncionario = txtEmail.getText();
            String bairroFuncionario = txtBairro.getText();
            String cepFuncionario = Padronizador.padronizarCep(txtCep.getText());
            String enderecoFuncionario = txtEndereco.getText();
            String cidadeFuncionario = txtCidade.getText();
            String estadoFuncionario = comboBoxEstado.getValue();
            String cartaoFuncionario = txtCartao.getText();
            String dtAdmissaoFuncionario = Padronizador.padronizarData(txtDtAdmissao.getText());
            String senhaFuncionario = txtSenha.getText();
            boolean gerenteFuncionario = isGerente.isSelected();
            
            System.out.println("----------- Valores prontos para serem enviados ao Banco de Dados ------------");
            System.out.println("Nome do Funcionario: " + nomeFuncionario);
            System.out.println("RG do Funcionario: " + rgFuncionario);
            System.out.println("CPF do Funcionario: " + cpfFuncionario);
            System.out.println("Data de Nascimento do Funcionario: " + dtNascimentoFuncionario);
            System.out.println("Sexo: " + sexoFuncionario);
            System.out.println("Telefone do Funcionario: " + telefoneFuncionario);
            System.out.println("Celular do Funcionario: " + celularFuncionario);
            System.out.println("Email do Funcionario: " + emailFuncionario);
            System.out.println("Bairro do Funcionario: " + bairroFuncionario);
            System.out.println("CEP do Funcionario: " + cepFuncionario);
            System.out.println("Endereço do Funcionario: " + enderecoFuncionario);
            System.out.println("Cidade do Funcionario: " + cidadeFuncionario);
            System.out.println("Estado do Funcionario: " + estadoFuncionario);
            System.out.println("Cartão do Funcionario: " + cartaoFuncionario);
            System.out.println("Senha do Funcionario: " + senhaFuncionario);
            System.out.println("Funcionario é gerente: " + gerenteFuncionario);
            System.out.println("Data de Admissão do Funcionario: " + dtAdmissaoFuncionario);
            
            if (FuncionarioDAO.getInstance().cadastrar(rgFuncionario, cpfFuncionario, nomeFuncionario,
                sexoFuncionario, dtNascimentoFuncionario, telefoneFuncionario, celularFuncionario, emailFuncionario,
                enderecoFuncionario, cepFuncionario, estadoFuncionario, cidadeFuncionario, bairroFuncionario,
                dtAdmissaoFuncionario, gerenteFuncionario, senhaFuncionario, cartaoFuncionario)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Funcionário");
                alert.setContentText("Cadastro de funcionário realizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaCadastro");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Funcionário");
                alert.setContentText("Erro ao cadastrar o funcionario!");
                alert.showAndWait();
            } 
            
        }
    }
}
