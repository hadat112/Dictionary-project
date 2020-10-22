import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class AddingFunction extends Root {
    private Button addingBtn;
    private String tag = "#add";

    public AddingFunction(Scene scene) {
        addingBtn = (Button) scene.lookup(tag);
    }

    public void setAddingBtn(WordViewList wordViewList) {
        addingBtn.setOnMouseClicked(e -> {
            showInputDialog(wordViewList);
        });
    }

    private boolean checkWord(String word) {
        return getWordList().containsKey(word);
    }

    private void addWord(Word word) {
        getWordList().put(word.getWord(), word);
    }

    public void showInputDialog(WordViewList wordViewList) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Add a word to dictionary");

        Label label = new Label("New word:");
        Label label1 = new Label("Defination:");
        TextField textField = new TextField();
        TextArea textField1 = new TextArea();

        GridPane grid = new GridPane();
        grid.add(label, 1, 1);
        grid.add(label1, 1, 3);
        grid.add(textField, 1, 2);
        grid.add(textField1, 1, 4);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Button okBtn = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        okBtn.addEventFilter(
                ActionEvent.ACTION, event -> {
                    String word = textField.getText();
                    String def = "<html><i>" + word + "</i><br/>" + "<ul><li><font color='#cc0000'><b>"
                            + textField1.getText() + "</b></font></li></ul></html>";
                    if (checkWord(word)) {
                        showWarning(word);
                        event.consume();
                    } else {
                        addWord(new Word(word, def));
                        wordViewList.loadWords();
                    }
                }
        );

        dialog.showAndWait();
    }

    public void showWarning(String word) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Cannot add this word!");
        alert.setContentText("The word\"" + word + "\" is already existed.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            alert.hide();
        }
    }

}
