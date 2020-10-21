import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DeletingFunction extends Root {
    private final Button dltBtn;
    private final String tag = "#delete";

    public DeletingFunction(Scene scene) {
        dltBtn = (Button) scene.lookup(tag);
    }

    public void deleteWord(WordViewList wordViewList, DefView defView) {
        dltBtn.setOnMouseClicked(e -> {
            showAlert(wordViewList, defView);
        });
    }

    private void showAlert(WordViewList wordViewList, DefView defView) {
        Alert dltAlert = new Alert(Alert.AlertType.CONFIRMATION);
        dltAlert.setTitle("Delete word");
        dltAlert.setHeaderText("Are you sure want to delete \"" + getCurrent() + "\"?");
        dltAlert.setContentText("This word will not be availble anymore");

        Optional<ButtonType> option = dltAlert.showAndWait();

        if (option.get() == ButtonType.OK && getCurrent()!= null) {
            removeWord();
            updateWordList();
            wordViewList.loadWords();
            defView.clearDefView();
        }
    }

}
