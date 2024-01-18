package control;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import model.CatracaDAO;

public class Catraca {
    private BufferedReader input;
    private static OutputStream serialOut;
    private final int taxa;
    private final String portaCOM;

    /**
     * Construtor da classe ControlePorta
     * @param portaCOM - Porta COM que será utilizada para enviar os dados para o arduino
     * @param taxa - Taxa de transferência da porta serial geralmente é 9600
     */
    public Catraca(String portaCOM, int taxa) {
        this.portaCOM = portaCOM;
        this.taxa = taxa;
        try {
            this.initialize();
        } catch (NoSuchPortException | PortInUseException | IOException | UnsupportedCommOperationException ex) {
        }
    }     

    /**
     * Médoto que verifica se a comunicação com a porta serial está ok
     */
    private void initialize() throws NoSuchPortException, PortInUseException, IOException, UnsupportedCommOperationException {
        //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
        CommPortIdentifier portId;
        portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
        //Abre a porta COM 
        SerialPort port = (SerialPort) portId.open("Comunicação serial", this.taxa);      
        input = new BufferedReader(new InputStreamReader(port.getInputStream()));
        serialOut = port.getOutputStream();
        port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                                 SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                                 SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                                 SerialPort.PARITY_NONE); //receber e enviar dados
    }

    /**
     * Método que fecha a comunicação com a porta serial
     */
    public void close() {
        try {
            if (serialOut != null)
                serialOut.close();
        } catch (IOException ex) {
        }
    }
  
    /**
     * Método que verifica se a catraca fez alguma solicitação
     * e se esta é validada pelo banco de dados
     * @return Mensagem de Alerta
     */
    public String verificaCatraca() {
        String retorno = "";
        
        try {      
            
            CatracaDAO catraca = CatracaDAO.getInstance();
            
            if (input != null && catraca != null) { if (input.ready()){
                String cartao = input.readLine();
                
                if (catraca.verificaExistenciaCartao(cartao)) {
                    serialOut.write(1);
                } else {
                    retorno = cartao;
                    serialOut.write(0);
                }
                    
            } } else {
                    // catch (IOException | SQLException) personalizado sem interrupção
                    retorno = "ex";
            }
            
        } catch (IOException ex) {
        }
        
        return retorno;
    }

    
     /**
     * Método que libera a catraca sem alguma verificação
     */
    public static void autorizaAcesso() {        
        try {
            serialOut.write(99);
        } catch (IOException ex) {
        }
    }
}