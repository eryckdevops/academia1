package control;

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
import javafx.scene.control.Label;import model.Plano;
import model.PlanoDAO;
;

public class TelaAtualizarPlanoController implements Initializable {

    @FXML
    private JFXTextField txtNome;
    @FXML
    private JFXTextField txtDescricao;
    @FXML
    private JFXTextField txtValor;
    @FXML
    private JFXTextField txtQtdDias;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblQtdDias;

    private static int idPlano;
    
    public static void enviarId(int id) {
        idPlano = id;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Plano> planos = PlanoDAO.getInstance().retrieveGeneric("SELECT * FROM acd_Planos WHERE id_plano = " + idPlano);
        Iterator<Plano> iterator = planos.iterator();
        
        while(iterator.hasNext()) {
            Plano plano = iterator.next();
            if(plano.getId() == idPlano) {
                txtNome.setText(plano.getNome());
                txtDescricao.setText(plano.getDescricao());
                txtValor.setText(Float.toString((float)plano.getValor()));
                txtQtdDias.setText(Integer.toString(plano.getVencimento()));
            }
        }
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        SistemaAcademia.changeScreen("TelaConsultaPlano");
    }
    
    @FXML
    private void clickExcluir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Deseja realmente excluir este plano?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Exclusão");
        alert.setHeaderText("Exclusão de Plano");
        alert.showAndWait();
        
        if(alert.getResult() == ButtonType.YES) {
            if (PlanoDAO.getInstance().remover(idPlano)) {
                Alert retorno = new Alert(Alert.AlertType.INFORMATION);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Plano");
                retorno.setContentText("Plano excluído com sucesso!");
                retorno.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaPlano");
            }
            else {
                Alert retorno = new Alert(Alert.AlertType.ERROR);
                retorno.setTitle("Exclusão");
                retorno.setHeaderText("Exclusão de Plano");
                retorno.setContentText("Erro ao excluir o plano!");
                retorno.showAndWait();
            }
        }
    }

    @FXML
    private void clickAtualizar(ActionEvent event) {
        if( Validador.validName(txtNome, lblNome, "Nome Inválido!") &
            Validador.validDescription(txtDescricao, lblDescricao, "Descrição Inválida!") &
            Validador.validValue(txtValor, lblValor, "Valor Inválido!") &
            Validador.validDays(txtQtdDias, lblQtdDias, "Valor Inválido!") ) {
            
            String nomePlano = txtNome.getText();
            String descricaoPlano = txtDescricao.getText();
            float valorPlano = (float)Padronizador.padronizarPreco(txtValor.getText());
            int qtdDiasPlano = Integer.parseInt(txtQtdDias.getText());
            
            Plano plano = new Plano(idPlano, nomePlano, descricaoPlano, valorPlano, qtdDiasPlano);
            
            if (PlanoDAO.getInstance().atualizar(plano)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Plano");
                alert.setContentText("Plano atualizado com sucesso!");
                alert.showAndWait();
                SistemaAcademia.changeScreen("TelaConsultaPlano");
            }
            
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atualização");
                alert.setHeaderText("Atualização de Plano");
                alert.setContentText("Erro ao atualizar o plano!");
                alert.showAndWait();
            }       
        }
    }

}
