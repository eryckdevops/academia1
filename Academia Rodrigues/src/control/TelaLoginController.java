package control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Funcionario;
import model.FuncionarioDAO;

public class TelaLoginController implements Initializable {

    @FXML
    private Label lblResultado;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXTextField txtCpf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void clickAcesso(ActionEvent event) {
        String cpf = Padronizador.padronizarCpf(txtCpf.getText());
        String senha = txtSenha.getText();
        boolean acessoValido = false;
        
        if(cpf.equals("admin") && senha.equals("admin")) {
                acessoValido = true;
        }
        
        List<Funcionario> funcionarios = FuncionarioDAO.getInstance().retrieveAll();
        Iterator<Funcionario> iterator = funcionarios.iterator();
        
        while(iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if(funcionario.getCpf().equals(cpf)) {
                if(funcionario.getSenha().equals(senha)) {
                    acessoValido = true;
                }
            }
        }
        
        if(acessoValido) {
            SistemaAcademia.changeScreen("InicializarSistema");
        }
        else {
            lblResultado.setText("CPF inválido ou Senha incorreta");
        }
    }

    @FXML
    private void enterCpf(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String cpf = Padronizador.padronizarCpf(txtCpf.getText());
            String senha = txtSenha.getText();
            boolean acessoValido = false;

            if(cpf.equals("admin") && senha.equals("admin")) {
                acessoValido = true;
            }
            
            List<Funcionario> funcionarios = FuncionarioDAO.getInstance().retrieveAll();
            Iterator<Funcionario> iterator = funcionarios.iterator();

            while(iterator.hasNext()) {
                Funcionario funcionario = iterator.next();
                if(funcionario.getCpf().equals(cpf)) {
                    if(funcionario.getSenha().equals(senha)) {
                        acessoValido = true;
                    }
                }
            }

            if(acessoValido) {
                SistemaAcademia.changeScreen("InicializarSistema");
            }
            else {
                lblResultado.setText("CPF inválido ou Senha incorreta");
            }
        }
    }

    @FXML
    private void enterSenha(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String cpf = Padronizador.padronizarCpf(txtCpf.getText());
            String senha = txtSenha.getText();
            boolean acessoValido = false;
            
            if(cpf.equals("admin") && senha.equals("admin")) {
                acessoValido = true;
            }

            List<Funcionario> funcionarios = FuncionarioDAO.getInstance().retrieveAll();
            Iterator<Funcionario> iterator = funcionarios.iterator();

            while(iterator.hasNext()) {
                Funcionario funcionario = iterator.next();
                if(funcionario.getCpf().equals(cpf)) {
                    if(funcionario.getSenha().equals(senha)) {
                        acessoValido = true;
                    }
                }
            }

            if(acessoValido) {
                SistemaAcademia.changeScreen("InicializarSistema");
            }
            else {
                lblResultado.setText("CPF inválido ou Senha incorreta");
            }
        }
    }

    @FXML
    private void enterBotao(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String cpf = Padronizador.padronizarCpf(txtCpf.getText());
            String senha = txtSenha.getText();
            boolean acessoValido = false;

            List<Funcionario> funcionarios = FuncionarioDAO.getInstance().retrieveAll();
            Iterator<Funcionario> iterator = funcionarios.iterator();

            while(iterator.hasNext()) {
                Funcionario funcionario = iterator.next();
                if(funcionario.getCpf().equals(cpf)) {
                    if(funcionario.getSenha().equals(senha)) {
                        acessoValido = true;
                    }
                }
            }

            if(acessoValido) {
                SistemaAcademia.changeScreen("InicializarSistema");
            }
            else {
                lblResultado.setText("CPF inválido ou Senha incorreta");
            }
        }
    }
    
}
