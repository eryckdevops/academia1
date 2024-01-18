package control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.ClienteDAO;
import model.Plano;
import model.PlanoDAO;

public class TelaCadastroClienteController implements Initializable {

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
    private ToggleGroup sexo;
    @FXML
    private JFXTextField txtCidade;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtEndereco;
    @FXML
    private JFXTextField txtCartao;
    @FXML
    private JFXTextField txtGorduraCorporal;
    @FXML
    private JFXTextField txtAltura;
    @FXML
    private JFXTextField txtPeso;
    @FXML
    private JFXTextField txtRg;
    @FXML
    private JFXTextField txtCpf;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblRg;
    @FXML
    private Label lblCpf;
    @FXML
    private Label lblDtNascimento;
    @FXML
    private Label lblAltura;
    @FXML
    private Label lblGorduraCorporal;
    @FXML
    private Label lblTelefone;
    @FXML
    private Label lblCelular;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblBairro;
    @FXML
    private Label lblCep;
    @FXML
    private Label lblEndereco;
    @FXML
    private Label lblCidade;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblCartao;
    @FXML
    private Label lblPeso;
    @FXML
    private Label lblPlano;
    @FXML
    private JFXComboBox<String> comboBoxPlano;
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

        List<String> nomesPlano = new ArrayList();
        List<Plano> planos = PlanoDAO.getInstance().retrieveAll();
        Iterator<Plano> iterator = planos.iterator();
        
        while(iterator.hasNext()) {
            Plano plano = iterator.next();
            comboBoxPlano.getItems().add(plano.getNome());
        }
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
            Validador.validWeight(txtPeso, lblPeso, "Peso Inválido!") &
            Validador.validHeight(txtAltura, lblAltura, "Altura Inválida!") &
            Validador.validFatRate(txtGorduraCorporal, lblGorduraCorporal, "Taxa Inválida!") &
            Validador.validPhone(txtTelefone, lblTelefone, "Telefone Inválido!") &
            Validador.validCellPhone(txtCelular, lblCelular, "Celular Inválido!") &
            Validador.validEmail(txtEmail, lblEmail, "Email Inválido!") &
            Validador.validDistrict(txtBairro, lblBairro, "Bairro Inválido!") &
            Validador.validCep(txtCep, lblCep, "CEP Inválido!") &
            Validador.validAdress(txtEndereco, lblEndereco, "Endereço Inválido!") &
            Validador.validDistrict(txtCidade, lblCidade, "Cidade Inválida!") &
            Validador.validComboBox(comboBoxEstado, lblEstado, "Selecione um Estado!") &
            Validador.validComboBox(comboBoxPlano, lblPlano, "Selecione um Plano!") & 
            Validador.validCard(txtCartao, lblCartao, "Cartão Inválido!") ) {
            
            RadioButton genero = (RadioButton) sexo.getSelectedToggle();
            
            String nomeCliente = txtNome.getText();
            String rgCliente = Padronizador.padronizarRg(txtRg.getText());
            String cpfCliente = Padronizador.padronizarCpf(txtCpf.getText());
            String dtNascimentoCliente = Padronizador.padronizarData(txtDtNascimento.getText());
            String sexoCliente = genero.getText();
            float pesoCliente = (float)Padronizador.padronizarPeso(txtPeso.getText());
            float alturaCliente = (float)Padronizador.padronizarAltura(txtAltura.getText());
            float imcCliente = (float) pesoCliente / (alturaCliente * alturaCliente);
            int taxaGorduraCliente = Integer.parseInt(txtGorduraCorporal.getText());
            String telefoneCliente = Padronizador.padronizarPhone(txtTelefone.getText());
            String celularCliente = Padronizador.padronizarPhone(txtCelular.getText());
            String emailCliente = txtEmail.getText();
            String bairroCliente = txtBairro.getText();
            String cepCliente = Padronizador.padronizarCep(txtCep.getText());
            String enderecoCliente = txtEndereco.getText();
            String cidadeCliente = txtCidade.getText();
            String estadoCliente = comboBoxEstado.getValue();
            String cartaoCliente = txtCartao.getText();
            
            String dtVencimentoCliente = calcularDataVencimento(comboBoxPlano.getValue());
            int idPlanoCliente = buscarIdPlano(comboBoxPlano.getValue());
               
            System.out.println("----------- Valores prontos para serem enviados ao Banco de Dados ------------");
            System.out.println("Nome do Cliente: " + nomeCliente);
            System.out.println("RG do Cliente: " + rgCliente);
            System.out.println("CPF do Cliente: " + cpfCliente);
            System.out.println("Data de Nascimento do Cliente: " + dtNascimentoCliente);
            System.out.println("Sexo: " + sexoCliente);
            System.out.println("Peso do Cliente: " + pesoCliente);
            System.out.println("IMC do Cliente: " + imcCliente);
            System.out.println("Altura do Cliente: " + alturaCliente);
            System.out.println("Taxa de Gordura Corporal do Cliente: " + taxaGorduraCliente);
            System.out.println("Telefone do Cliente: " + telefoneCliente);
            System.out.println("Celular do Cliente: " + celularCliente);
            System.out.println("Email do Cliente: " + emailCliente);
            System.out.println("Bairro do Cliente: " + bairroCliente);
            System.out.println("CEP do Cliente: " + cepCliente);
            System.out.println("Endereço do Cliente: " + enderecoCliente);
            System.out.println("Cidade do Cliente: " + cidadeCliente);
            System.out.println("Estado do Cliente: " + estadoCliente);
            System.out.println("Cartão do Cliente: " + cartaoCliente);
            System.out.println("ID do Plano do Cliente: " + idPlanoCliente);
            System.out.println("Data de Vencimento do Cliente: " + dtVencimentoCliente);
            
            if (ClienteDAO.getInstance().cadastrar(rgCliente, cpfCliente, nomeCliente, sexoCliente,
                dtNascimentoCliente, telefoneCliente, celularCliente, emailCliente, enderecoCliente, cepCliente, estadoCliente,
                cidadeCliente, bairroCliente, cartaoCliente, idPlanoCliente, alturaCliente, pesoCliente,
                imcCliente, taxaGorduraCliente)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Cliente");
                alert.setContentText("Cadastro de cliente realizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaCadastro");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Cliente");
                alert.setContentText("Erro ao cadastrar o cliente!");
                alert.showAndWait();
            } 
        }
    }
    
    private static String calcularDataVencimento(String nomePlano) {
        String dataFinal = null;
        
        List<Plano> plans = PlanoDAO.getInstance().retrieveAll();
        Iterator<Plano> it = plans.iterator();
        while(it.hasNext()) {
            Plano plano = it.next();
            if(plano.getNome().equals(nomePlano)) {
                Date dt = new Date();
                Calendar c = Calendar.getInstance(); 
                c.setTime(dt); 
                c.add(Calendar.DATE, plano.getVencimento());
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                dataFinal = df.format(c.getTime());
            }
        }  
        
        return dataFinal;
    }
    
    private static int buscarIdPlano(String nomePlano) {
        int id = 0;
        
        List<Plano> plans = PlanoDAO.getInstance().retrieveAll();
        Iterator<Plano> it = plans.iterator();
        while(it.hasNext()) {
            Plano plano = it.next();
            if(plano.getNome().equals(nomePlano)) {
                return plano.getId();
            }
        }  
        return id;
    }
}
