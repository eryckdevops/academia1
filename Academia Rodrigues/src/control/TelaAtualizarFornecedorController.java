package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import model.Fornecedor;
import model.FornecedorDAO;

public class TelaAtualizarFornecedorController implements Initializable {

    private static int idFornecedor;
    
    @FXML
    private JFXTextField txtRazaoSocial;
    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtCelular;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXComboBox<String> comboBoxEstado;
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

    public static void enviarId(int id) {
        idFornecedor = id;
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
        
        List<Fornecedor> fornecedores = FornecedorDAO.getInstance().retrieveGeneric("SELECT * FROM acd_Fornecedores WHERE id_fornecedor = " + idFornecedor);
        Iterator<Fornecedor> iterator = fornecedores.iterator();
        
        while(iterator.hasNext()) {
            Fornecedor fornecedor = iterator.next();
            if(fornecedor.getId() == idFornecedor) {
                txtRazaoSocial.setText(fornecedor.getNome());
                txtCnpj.setText(fornecedor.getCnpj());
                txtTelefone.setText(fornecedor.getTelefone());
                txtCelular.setText(fornecedor.getCelular());
                txtEmail.setText(fornecedor.getEmail());
                txtEndereco.setText(fornecedor.getEndereco());
                txtBairro.setText(fornecedor.getBairro());
                txtCep.setText(fornecedor.getCep());
                txtCidade.setText(fornecedor.getCidade());
            }
        }
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaFornecedor");
    }

    @FXML
    private void clickExcluir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir este fornecedor?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exclusão");
        alert.setHeaderText("Exclusão de Fornecedor");
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.YES) {
            if (FornecedorDAO.getInstance().remover(idFornecedor)) {
                Alert retorno = new Alert(Alert.AlertType.INFORMATION);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Fornecedor");
                retorno.setContentText("Fornecedor excluído com sucesso!");
                retorno.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaFornecedor");
            }
            else {
                Alert retorno = new Alert(Alert.AlertType.ERROR);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Fornecedor");
                retorno.setContentText("Erro ao excluir o fornecedor!");
                retorno.showAndWait();
            }
        }
    }

    @FXML
    private void clickAtualizar(ActionEvent event) {
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
            
            Fornecedor fornecedor = new Fornecedor(idFornecedor, nomeFornecedor, cnpjFornecedor, telefoneFornecedor, celularFornecedor,
                emailFornecedor, enderecoFornecedor, cepFornecedor, estadoFornecedor, cidadeFornecedor, bairroFornecedor);
            
            if( FornecedorDAO.getInstance().atualizar(fornecedor) ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Fornecedor");
                alert.setContentText("Atualização de fornecedor realizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaFornecedor");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Fornecedor");
                alert.setContentText("Erro ao atualizar o fornecedor!");
                alert.showAndWait();
            }   
        }
    }
    
}
