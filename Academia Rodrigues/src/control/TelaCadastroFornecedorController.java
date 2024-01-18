package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.FornecedorDAO;

public class TelaCadastroFornecedorController implements Initializable {

    @FXML
    private JFXTextField txtRazaoSocial;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtCelular;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private Label lblRazaoSocial;
    @FXML
    private Label lblCnpj;
    @FXML
    private Label lblTelefone;
    @FXML
    private Label lblCelular;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblCep;
    @FXML
    private Label lblBairro;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblCidade;
    @FXML
    private Label lblEndereco;
    @FXML
    private JFXComboBox<String> comboBoxEstado;

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
        if( Validador.validName(txtRazaoSocial, lblRazaoSocial, "Nome Inválido!") &
            Validador.validCnpj(txtCnpj, lblCnpj, "CNPJ Inválido!") &
            Validador.validPhone(txtTelefone, lblTelefone, "Telefone Inválido!") &
            Validador.validCellPhone(txtCelular, lblCelular, "Celular Inválido!") &
            Validador.validEmail(txtEmail, lblEmail, "Email Inválido!") &
            Validador.validDistrict(txtBairro, lblBairro, "Bairro Inválido!") &
            Validador.validCep(txtCep, lblCep, "CEP Inválido!") &
            Validador.validAdress(txtEndereco, lblEndereco, "Endereço Inválido!") &
            Validador.validDistrict(txtCidade, lblCidade, "Cidade Inválida!") &
            Validador.validComboBox(comboBoxEstado, lblEstado, "Selecione um Estado!") ) {
            
            String nomeFornecedor = txtRazaoSocial.getText();
            String cnpjFornecedor = Padronizador.padronizarCnpj(txtCnpj.getText());
            String telefoneFornecedor = Padronizador.padronizarPhone(txtTelefone.getText());
            String celularFornecedor = Padronizador.padronizarPhone(txtCelular.getText());
            String emailFornecedor = txtEmail.getText();
            String bairroFornecedor = txtBairro.getText();
            String cepFornecedor = Padronizador.padronizarCep(txtCep.getText());
            String enderecoFornecedor = txtEndereco.getText();
            String cidadeFornecedor = txtCidade.getText();
            String estadoFornecedor = comboBoxEstado.getValue();
            
            System.out.println("----------- Valores prontos para serem enviados ao Banco de Dados ------------");
            System.out.println("Nome do Fornecedor: " + nomeFornecedor);
            System.out.println("CNPJ do Fornecedor: " + cnpjFornecedor);
            System.out.println("Telefone do Fornecedor: " + telefoneFornecedor);
            System.out.println("Celular do Fornecedor: " + celularFornecedor);
            System.out.println("Email do Fornecedor: " + emailFornecedor);
            System.out.println("Bairro do Fornecedor: " + bairroFornecedor);
            System.out.println("CEP do Fornecedor: " + cepFornecedor);
            System.out.println("Endereço do Fornecedor: " + enderecoFornecedor);
            System.out.println("Cidade do Fornecedor: " + cidadeFornecedor);
            System.out.println("Estado do Fornecedor: " + estadoFornecedor);
            
            if( FornecedorDAO.getInstance().cadastrar(nomeFornecedor, cnpjFornecedor, telefoneFornecedor, celularFornecedor,
                emailFornecedor, enderecoFornecedor, cepFornecedor, estadoFornecedor, cidadeFornecedor, bairroFornecedor) ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Fornecedor");
                alert.setContentText("Cadastro de fornecedor realizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaCadastro");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Fornecedor");
                alert.setContentText("Erro ao cadastrar o fornecedor!");
                alert.showAndWait();
            }   
        }
    } 
}
