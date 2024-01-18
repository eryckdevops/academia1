package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.events.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.IntegerStringConverter;
import model.Cliente;
import model.ClienteDAO;
import model.Funcionario;
import model.FuncionarioDAO;
import model.ItemCompra;
import model.ItemPedido;
import model.ItemPedidoDAO;
import model.Produto;
import model.ProdutoDAO;
import model.VendaDAO;

public class TelaCadastroVendaController implements Initializable {

    @FXML
    private JFXComboBox<String> comboBoxCliente;
    @FXML
    private JFXComboBox<String> comboBoxFuncionario;
    @FXML
    private JFXTextField txtNome;
    @FXML
    private TableView<Produto> tableViewVenda;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblFuncionario;
    @FXML
    private Label lblCliente;
    @FXML
    private Label lblTotalVenda;
    @FXML
    private JFXButton btnAdiciona;
    @FXML
    private JFXButton btnRemover;
    @FXML
    private TableView<ItemCompra> tableViewCompra;
    
    private static List<Produto> produtos;
    private static List<Cliente> clientes;
    private static List <Funcionario> funcionarios;
    private List<ItemCompra> listaCompra = new ArrayList();
    private int idVenda;
    
    private double totalVenda = 0;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // CRIA VENDA
        if (VendaDAO.getInstance().cadastrar())
            idVenda = VendaDAO.getInstance().getUltimoId();
        
        // CARREGA COMBOBOX CLIENTES
        clientes = ClienteDAO.getInstance().retrieveAll();
        Iterator<Cliente> iteratorC = clientes.iterator();        
        while(iteratorC.hasNext()) {
            Cliente cliente = iteratorC.next();
            comboBoxCliente.getItems().add(cliente.getNome());
        }
        
        // CARREGA COMBOBOX FUNCIONÁRIOS
        funcionarios = FuncionarioDAO.getInstance().retrieveAll();
        Iterator<Funcionario> iteratorF = funcionarios.iterator();        
        while(iteratorF.hasNext()) {
            Funcionario funcionario = iteratorF.next();
            comboBoxFuncionario.getItems().add(funcionario.getNome());
        }
        
        // CARREGA TABLEVIEW PRODUTOS
        TableColumn id = new TableColumn("ID");
        TableColumn nome = new TableColumn("Produto");
        TableColumn descricao = new TableColumn("Descrição");
        TableColumn estoque = new TableColumn("Estoque");
        TableColumn preco = new TableColumn("R$");  id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        estoque.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
        preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tableViewVenda.getColumns().addAll(id, nome, descricao, estoque, preco);
        
        produtos = ProdutoDAO.getInstance().retrieveAll();
        Iterator<Produto> iterator = produtos.iterator();        
        List<Produto> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Produto produto = iterator.next();
            dados.add(produto);
        }        
        ObservableList consulta = FXCollections.observableArrayList(dados);     
        tableViewVenda.setItems(consulta);
        
        
        // CRIA TABLEVIEW COMPRAS
        TableColumn idCompra = new TableColumn("ID");
        idCompra.setEditable(false);
        TableColumn nomeCompra = new TableColumn("Produto");
        nomeCompra.setEditable(false);
        TableColumn valorUnitario = new TableColumn("Valor Uni.");
        valorUnitario.setEditable(false);
        TableColumn quantidadeCompra = new TableColumn("Quantidade");
        quantidadeCompra.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
        quantidadeCompra.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ItemCompra,Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ItemCompra, Integer> event) {
                ItemCompra item = tableViewCompra.getSelectionModel().getSelectedItem();
                if(ItemPedidoDAO.getInstance().atualizar(new ItemPedido(idVenda, item.getId(), event.getNewValue()))) {
                    double reajuste = (event.getNewValue() - event.getOldValue()) * item.getValorUnitario();
                    totalVenda = totalVenda + reajuste;
                    lblTotalVenda.setText("Total: R$ " + String.format("%10.2f", totalVenda));
                    tableViewCompra.getSelectionModel().getSelectedItem().setQuantidade(event.getNewValue());
                    if(event.getNewValue() == 0) {
                        listaCompra.remove(item);
                        ObservableList consulta = FXCollections.observableArrayList(listaCompra);     
                        tableViewCompra.setItems(consulta);
                    }
                    
                }
                else {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Adicionar");
                    alert.setHeaderText("Adição de Item");
                    alert.setContentText("Erro ao inserir item!");
                    alert.showAndWait();
                }
            }
        });   

        TableColumn totalCompra = new TableColumn("Valor Total");
        totalCompra.setEditable(false);
        
        idCompra.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeCompra.setCellValueFactory(new PropertyValueFactory<>("nome"));
        valorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
        quantidadeCompra.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        totalCompra.setCellValueFactory(new PropertyValueFactory<>("total"));
        tableViewCompra.setEditable(true);
        tableViewCompra.getColumns().addAll(idCompra, nomeCompra, valorUnitario, quantidadeCompra, totalCompra);
    }

    @FXML
    private void inserirCaractere(KeyEvent event) {
        String entrada = txtNome.getText();
        
        Iterator<Produto> iterator = produtos.iterator();
        
        List<Produto> dados = new ArrayList(); 
        while(iterator.hasNext()) {
            Produto produto = iterator.next();
            if(Pattern.compile(Pattern.quote(entrada), Pattern.CASE_INSENSITIVE).matcher(produto.getNome()).find()) {
                dados.add(produto);
            }
        }
        
        ObservableList consulta = FXCollections.observableArrayList(dados);
        
        tableViewVenda.setItems(consulta);
    }

    @FXML
    private void clickAdicionar(ActionEvent event) {
        Produto produto = tableViewVenda.getSelectionModel().getSelectedItem();
        if(produto != null){
            ItemCompra item = new ItemCompra(produto.getId(), produto.getNome(), produto.getPreco(), 1, produto.getPreco());
            if(!listaCompra.contains(item)) {
                if(ItemPedidoDAO.getInstance().cadastrar(idVenda, produto.getId(), 1)) {
                    listaCompra.add(item);
                    totalVenda += produto.getPreco();
                    lblTotalVenda.setText("Total: R$ " + String.format("%10.2f", totalVenda));
                }
                else {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Adicionar");
                    alert.setHeaderText("Adição de Item");
                    alert.setContentText("Erro ao inserir item!");
                    alert.showAndWait();
                }
            }
            ObservableList consulta = FXCollections.observableArrayList(listaCompra);
            tableViewCompra.setItems(consulta);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Adicionar");
            alert.setHeaderText("Adição de Produto");
            alert.setContentText("Selecione um produto para adicionar à venda!");
            alert.showAndWait();
        }
    }
    
    
    @FXML
    private void clickRemover(ActionEvent event) {
        ItemCompra item = tableViewCompra.getSelectionModel().getSelectedItem();
        if(ItemPedidoDAO.getInstance().remover(new ItemPedido(idVenda, item.getId(), item.getQuantidade()))) {
            totalVenda = totalVenda - item.getTotal();
            lblTotalVenda.setText("Total: R$ " + String.format("%10.2f", totalVenda));
            listaCompra.remove(item);
            ObservableList consulta = FXCollections.observableArrayList(listaCompra);     
            tableViewCompra.setItems(consulta);
        }
    }
    
    @FXML
    private void clickCancelar(ActionEvent event) {
        System.out.println(VendaDAO.getInstance().remover(idVenda));
        SistemaAcademia.changeScreen("TelaCadastro");
        //VendaDAO.getInstance().terminar();
    }

    @FXML
    private void clickSalvar(ActionEvent event) { 
        if ( Validador.validComboBox(comboBoxCliente, lblCliente, "Selecione um cliente!") &
             Validador.validComboBox(comboBoxFuncionario, lblFuncionario, "Selecione um funcionário!") &
             totalVenda > 0 ) {
            
            int idCliente = buscarIdCliente(comboBoxCliente.getValue());
            int idFuncionario = buscarIdFuncionario(comboBoxFuncionario.getValue());
            
            if (VendaDAO.getInstance().atualizar(idVenda, idCliente, idFuncionario)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                TelaPagamentoCompraController.enviarTotal(totalVenda);
                SistemaAcademia.changeScreen("TelaPagamentoCompra");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cadastro");
                alert.setHeaderText("Cadastro de Venda");
                alert.setContentText("Erro ao cadastrar a venda!");
                alert.showAndWait();
            }     
        }
        else if(totalVenda == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cadastro");
            alert.setHeaderText("Cadastro de Venda");
            alert.setContentText("Selecione ao menos um produto!");
            alert.showAndWait();
        }
    }
    
    private static int buscarIdCliente(String nomeCliente) {
        int id = 0;        
        Iterator<Cliente> it = clientes.iterator();
        while(it.hasNext()) {
            Cliente cliente = it.next();
            if(cliente.getNome().equals(nomeCliente)) {
                return cliente.getId();
            }
        }  
        return id;
    }
    
    private static int buscarIdFuncionario(String nomeFuncionario) {
        int id = 0;        
        Iterator<Funcionario> it = funcionarios.iterator();
        while(it.hasNext()) {
            Funcionario funcionario = it.next();
            if(funcionario.getNome().equals(nomeFuncionario)) {
                return funcionario.getId();
            }
        }  
        return id;
    }
}
