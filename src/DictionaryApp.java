import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DictionaryApp extends Application {

    private static final String FXML_FILE_PATH = "JavaFx.fxml";
    private static Controller controller = new Controller();

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(FXML_FILE_PATH));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dictionary");
        primaryStage.show();

        controller.initButton(scene);
        controller.initialData();
        controller.loadDef();
        controller.getDefWhenFind(scene);
        controller.spellCurrentWord(scene);
        root.setOnMouseClicked(e -> {
            controller.turnOffSearchView();
        });
        controller.textFieldCatchEvent(scene);
    }

}
