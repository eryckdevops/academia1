package control;

import com.sun.javafx.application.LauncherImpl;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SistemaAcademia extends Application {
    
    private static Stage stage;
    
    private static BorderPane mainLayout;
    
    //private static final Catraca CATRACA = new Catraca("COM3",9600);
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        
        stage.setTitle("SGA");
        stage.getIcons().add(new Image("/view/icones/favicon.png"));

        Parent fxmlTelaPrincipal = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
        Scene scenePrincipal = new Scene(fxmlTelaPrincipal);
   
        stage.setScene(scenePrincipal);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setMaxWidth(750);
        stage.setMaxHeight(500);
        stage.show();
    }
    
    @Override
    public void init() throws Exception {
        try { Thread.sleep(4000); } catch (InterruptedException ex) {}
        Email.abrirConexao();
        Email.comunicarDevedores();
        Email.comunicarAniversariantes();
    }
    
    public static void changeScreen(String fxml) {
        switch(fxml) {
            case "InicializarSistema" :           
                FXMLLoader telaInicial = new FXMLLoader();
                telaInicial.setLocation(SistemaAcademia.class.getResource("/view/TelaPrincipal.fxml"));
        
                try {
                    mainLayout = telaInicial.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }

                stage.setMaxWidth(3840);
                stage.setMaxHeight(2160);
                stage.getScene().setRoot(mainLayout);
                stage.setMaximized(true);
                break;
                
            case "TelaPrincipal" :           
                FXMLLoader telaPrincipal = new FXMLLoader();
                telaPrincipal.setLocation(SistemaAcademia.class.getResource("/view/TelaPrincipal.fxml"));
        
                try {
                    mainLayout = telaPrincipal.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }

                stage.getScene().setRoot(mainLayout);
                break;
            
            case "TelaCadastro" :
                FXMLLoader telaCadastro = new FXMLLoader();
                telaCadastro.setLocation(SistemaAcademia.class.getResource("/view/TelaCadastro.fxml"));
        
                try {
                    mainLayout = telaCadastro.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaConsulta" :
                FXMLLoader telaConsulta = new FXMLLoader();
                telaConsulta.setLocation(SistemaAcademia.class.getResource("/view/TelaConsulta.fxml"));
        
                try {
                    mainLayout = telaConsulta.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                stage.getScene().setRoot(mainLayout);
                break;
              
            case "TelaPagamento" :
                FXMLLoader telaPagamento = new FXMLLoader();
                telaPagamento.setLocation(SistemaAcademia.class.getResource("/view/TelaPagamento.fxml"));
        
                try {
                    mainLayout = telaPagamento.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
         
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaCadastroCliente" :
                FXMLLoader telaCadastroCliente = new FXMLLoader();
                telaCadastroCliente.setLocation(SistemaAcademia.class.getResource("/view/TelaCadastroCliente.fxml"));
        
                try {
                    mainLayout = telaCadastroCliente.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaCadastroFuncionario" :
                FXMLLoader telaCadastroFuncionario = new FXMLLoader();
                telaCadastroFuncionario.setLocation(SistemaAcademia.class.getResource("/view/TelaCadastroFuncionario.fxml"));
        
                try {
                    mainLayout = telaCadastroFuncionario.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaCadastroFornecedor" :
                FXMLLoader telaCadastroFornecedor = new FXMLLoader();
                telaCadastroFornecedor.setLocation(SistemaAcademia.class.getResource("/view/TelaCadastroFornecedor.fxml"));
        
                try {
                    mainLayout = telaCadastroFornecedor.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaCadastroProduto" :
                FXMLLoader telaCadastroProduto = new FXMLLoader();
                telaCadastroProduto.setLocation(SistemaAcademia.class.getResource("/view/TelaCadastroProduto.fxml"));
        
                try {
                    mainLayout = telaCadastroProduto.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaCadastroVenda" :
                FXMLLoader telaCadastroVenda = new FXMLLoader();
                telaCadastroVenda.setLocation(SistemaAcademia.class.getResource("/view/TelaCadastroVenda.fxml"));
        
                try {
                    mainLayout = telaCadastroVenda.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaPagamentoCompra" :
                FXMLLoader telaPagamentoCompra = new FXMLLoader();
                telaPagamentoCompra.setLocation(SistemaAcademia.class.getResource("/view/TelaPagamentoCompra.fxml"));
        
                try {
                    mainLayout = telaPagamentoCompra.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaCadastroPlano" :
                FXMLLoader telaCadastroPlano = new FXMLLoader();
                telaCadastroPlano.setLocation(SistemaAcademia.class.getResource("/view/TelaCadastroPlano.fxml"));
        
                try {
                    mainLayout = telaCadastroPlano.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaConsultaCliente" :
                FXMLLoader telaConsultaCliente = new FXMLLoader();
                telaConsultaCliente.setLocation(SistemaAcademia.class.getResource("/view/TelaConsultaCliente.fxml"));
        
                try {
                    mainLayout = telaConsultaCliente.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaConsultaFuncionario" :
                FXMLLoader telaConsultaFuncionario = new FXMLLoader();
                telaConsultaFuncionario.setLocation(SistemaAcademia.class.getResource("/view/TelaConsultaFuncionario.fxml"));
        
                try {
                    mainLayout = telaConsultaFuncionario.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaConsultaFornecedor" :
                FXMLLoader telaConsultaFornecedor = new FXMLLoader();
                telaConsultaFornecedor.setLocation(SistemaAcademia.class.getResource("/view/TelaConsultaFornecedor.fxml"));
        
                try {
                    mainLayout = telaConsultaFornecedor.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaConsultaProduto" :
                FXMLLoader telaConsultaProduto = new FXMLLoader();
                telaConsultaProduto.setLocation(SistemaAcademia.class.getResource("/view/TelaConsultaProduto.fxml"));
        
                try {
                    mainLayout = telaConsultaProduto.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
            
            case "TelaConsultaPlano" :
                FXMLLoader telaConsultaPlano = new FXMLLoader();
                telaConsultaPlano.setLocation(SistemaAcademia.class.getResource("/view/TelaConsultaPlano.fxml"));
        
                try {
                    mainLayout = telaConsultaPlano.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
            
            case "TelaConsultaVenda" :
                FXMLLoader telaConsultaVenda = new FXMLLoader();
                telaConsultaVenda.setLocation(SistemaAcademia.class.getResource("/view/TelaConsultaVenda.fxml"));
        
                try {
                    mainLayout = telaConsultaVenda.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaAtualizarCliente" :
                FXMLLoader telaAtualizarCliente = new FXMLLoader();
                telaAtualizarCliente.setLocation(SistemaAcademia.class.getResource("/view/TelaAtualizarCliente.fxml"));
        
                try {
                    mainLayout = telaAtualizarCliente.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaAtualizarFuncionario" :
                FXMLLoader telaAtualizarFuncionario = new FXMLLoader();
                telaAtualizarFuncionario.setLocation(SistemaAcademia.class.getResource("/view/TelaAtualizarFuncionario.fxml"));
        
                try {
                    mainLayout = telaAtualizarFuncionario.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaAtualizarFornecedor" :
                FXMLLoader telaAtualizarFornecedor = new FXMLLoader();
                telaAtualizarFornecedor.setLocation(SistemaAcademia.class.getResource("/view/TelaAtualizarFornecedor.fxml"));
        
                try {
                    mainLayout = telaAtualizarFornecedor.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaAtualizarProduto" :
                FXMLLoader telaAtualizarProduto = new FXMLLoader();
                telaAtualizarProduto.setLocation(SistemaAcademia.class.getResource("/view/TelaAtualizarProduto.fxml"));
        
                try {
                    mainLayout = telaAtualizarProduto.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaAtualizarPlano" :
                FXMLLoader telaAtualizarPlano = new FXMLLoader();
                telaAtualizarPlano.setLocation(SistemaAcademia.class.getResource("/view/TelaAtualizarPlano.fxml"));
        
                try {
                    mainLayout = telaAtualizarPlano.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaRelatorio" :
                FXMLLoader telaRelatorio = new FXMLLoader();
                telaRelatorio.setLocation(SistemaAcademia.class.getResource("/view/TelaRelatorio.fxml"));
        
                try {
                    mainLayout = telaRelatorio.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaRelatorioUltimoAcesso" :
                FXMLLoader telaRelatorioUltimoAcesso = new FXMLLoader();
                telaRelatorioUltimoAcesso.setLocation(SistemaAcademia.class.getResource("/view/TelaRelatorioUltimoAcesso.fxml"));
        
                try {
                    mainLayout = telaRelatorioUltimoAcesso.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
            
            case "TelaRelatorioRecebimento" :
                FXMLLoader telaRelatorioRecebimento = new FXMLLoader();
                telaRelatorioRecebimento.setLocation(SistemaAcademia.class.getResource("/view/TelaRelatorioRecebimento.fxml"));
        
                try {
                    mainLayout = telaRelatorioRecebimento.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
            
            case "TelaRelatorioVenda" :
                FXMLLoader telaRelatorioVenda = new FXMLLoader();
                telaRelatorioVenda.setLocation(SistemaAcademia.class.getResource("/view/TelaRelatorioVenda.fxml"));
        
                try {
                    mainLayout = telaRelatorioVenda.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
                
            case "TelaFormaPagamento" :
                FXMLLoader telaFormaPagamento = new FXMLLoader();
                telaFormaPagamento.setLocation(SistemaAcademia.class.getResource("/view/TelaFormaPagamento.fxml"));
        
                try {
                    mainLayout = telaFormaPagamento.load();
                } catch (IOException ex) {
                    Logger.getLogger(SistemaAcademia.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                stage.getScene().setRoot(mainLayout);
                break;
        }
    }
        
    public static void main(String[] args) {
        /*Thread threadCatraca = new Thread() {     
            @Override
            public void run() {
                String retorno;
                while(true) {
                    /* Catraca main method */
                    /*retorno = CATRACA.verificaCatraca();
                    if ("ex".equals(retorno)) {
                        JOptionPane.showMessageDialog(null, "CATRACA INDISPONÍVEL\nSolução do problema:\n\n1. Verifique a conexão da Catraca\n2. Verifique a conexão do Banco de Dados\n3. Reinicie o sistema\n\n", "", JOptionPane.PLAIN_MESSAGE);
                        break;
                    
                    /* Access denied */
                   /* } else if (!"".equals(retorno)) {                     
                        int resposta = JOptionPane.showConfirmDialog(null, "CARTÃO NÃO CADASTRADO\n\nDeseja copiar o código do cartão para cadastrá-lo?\n\n", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                        
                        if (resposta == JOptionPane.YES_OPTION) {
                            StringSelection stringSelection = new StringSelection(retorno);
                            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clipboard.setContents(stringSelection, null);
                            Robot r;
                            try {
                                r = new Robot();
                                r.keyPress(KeyEvent.VK_CONTROL);
                                r.keyPress(KeyEvent.VK_V);
                                r.keyRelease(KeyEvent.VK_CONTROL);
                                r.keyRelease(KeyEvent.VK_V);
                            } catch (AWTException ex) {
                            }
                        }
                    }
                    /* Thread pause moment */
                    /*try { Thread.sleep(300); } catch (InterruptedException ex) {}
                }
            }
        };
        
        threadCatraca.start();*/
        
        //launch(args);     
        
        LauncherImpl.launchApplication(SistemaAcademia.class, PreCarregamento.class, args);

        /*CATRACA.close();
        threadCatraca.destroy();*/
    }
}
