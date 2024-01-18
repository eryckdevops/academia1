package control;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PreCarregamento extends Preloader {

    private Stage PreCarregamentoStage;
    private Scene scene;
    
    @Override
    public void init() throws Exception {
        Parent fxmlStart = FXMLLoader.load(getClass().getResource("/view/Start.fxml"));
        scene = new Scene(fxmlStart);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.PreCarregamentoStage = primaryStage;
        
        PreCarregamentoStage.setScene(scene);
        PreCarregamentoStage.initStyle(StageStyle.UNDECORATED);
        PreCarregamentoStage.show();
    }
    
    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        
        StateChangeNotification.Type type = info.getType();
        
        switch(type) {
            case BEFORE_START:
                PreCarregamentoStage.hide();
                break;
        }
    } 
}
