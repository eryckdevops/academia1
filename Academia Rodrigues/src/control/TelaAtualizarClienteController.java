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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.Cliente;
import model.ClienteDAO;
import model.Plano;
import model.PlanoDAO;

public class TelaAtualizarClienteController implements Initializable {

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
    private JFXTextField txtPeso;
    @FXML
    private JFXTextField txtAltura;
    @FXML
    private JFXTextField txtGorduraCorporal;
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
    private JFXTextField txtCartao;
    @FXML
    private JFXComboBox<String> comboBoxPlano;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblRg;
    @FXML
    private Label lblCpf;
    @FXML
    private Label lblDtNascimento;
    @FXML
    private Label lblPeso;
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
    private Label lblCartao;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblPlano;
    
    private static int idCliente;
    
    public static void enviarId(int id) {
        idCliente = id;
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
        
        List<Plano> planos = PlanoDAO.getInstance().retrieveAll();
        Iterator<Plano> iteratorA = planos.iterator();
        
        while(iteratorA.hasNext()) {
            Plano plano = iteratorA.next();
            comboBoxPlano.getItems().add(plano.getNome());
        }
        
        List<Cliente> clientes = ClienteDAO.getInstance().retrieveGeneric("SELECT * FROM consultarClientes WHERE id_cliente = " + idCliente);
        Iterator<Cliente> iterator = clientes.iterator();
        
        while(iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if(cliente.getId() == idCliente) {                
                
                txtNome.setText(cliente.getNome());                
                txtRg.setText(cliente.getRg());                
                txtCpf.setText(cliente.getCpf()); 
//                sexo.setValue(cliente.getSexo());
                txtDtNascimento.setText(Visualizador.visualizarData(cliente.getDtNasc()));                
                txtPeso.setText(Float.toString(cliente.getPeso()));          
                txtAltura.setText(Float.toString(cliente.getAltura()));                
                txtGorduraCorporal.setText(Visualizador.visualizarGorduraCorporalSemPercent(cliente.getPorcentagemGorduraCorporal()));                
                txtTelefone.setText(cliente.getTelefone());                
                txtCelular.setText(cliente.getCelular());                
                txtEmail.setText(cliente.getEmail());                
                txtBairro.setText(cliente.getBairro());                
                txtCep.setText(cliente.getCep());                
                txtEndereco.setText(cliente.getEndereco());                
                txtCidade.setText(cliente.getCidade());  
                txtCartao.setText(cliente.getCartao());
                comboBoxEstado.getSelectionModel().select(cliente.getEstado());
                comboBoxPlano.getSelectionModel().select(cliente.getPlano());
            }
        }
        
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaCliente");
    }
    
    @FXML
    private void clickAtualizar(ActionEvent event) {
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
            
            Cliente cliente = new Cliente(idCliente, rgCliente, cpfCliente, nomeCliente, sexoCliente, 
                dtNascimentoCliente, telefoneCliente, celularCliente, emailCliente, enderecoCliente, cepCliente, estadoCliente,
                cidadeCliente, bairroCliente, cartaoCliente, idPlanoCliente, dtVencimentoCliente, alturaCliente, pesoCliente,
                imcCliente, taxaGorduraCliente, "");
            
            if (ClienteDAO.getInstance().atualizar(cliente)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Cliente");
                alert.setContentText("Cliente atualizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaCliente");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Cliente");
                alert.setContentText("Erro ao atualizar o cliente!");
                alert.showAndWait();
            } 
        }
    }

    @FXML
    private void clickExcluir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir este cliente?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exclusão");
        alert.setHeaderText("Exclusão de Cliente");
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.YES) {
            if (ClienteDAO.getInstance().remover(idCliente)) {
                Alert retorno = new Alert(Alert.AlertType.INFORMATION);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Cliente");
                retorno.setContentText("Cliente excluído com sucesso!");
                retorno.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaCliente");
            }
            else {
                Alert retorno = new Alert(Alert.AlertType.ERROR);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Cliente");
                retorno.setContentText("Erro ao excluir o cliente!");
                retorno.showAndWait();
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
