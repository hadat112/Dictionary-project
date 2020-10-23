import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ChangingFunction extends Root {
    private Button changingBtn;
    private String tag = "#change";

    public ChangingFunction(Scene scene) {
        changingBtn = (Button) scene.lookup(tag);
    }

    private void updateWord(Word word) {
        getWordList().put(word.getWord(), word);
    }


    public void setChangingBtn(WordViewList wordViewList, DefView defView) {
        changingBtn.setOnMouseClicked(e -> {
            showChangingDialog(wordViewList, defView);
            setChanged();
        });
    }

    public void showChangingDialog(WordViewList wordViewList, DefView defview) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Change word's definition to dictionary");

        Label label = new Label("Change the definition of \"" + getCurrent() + "\"");
        Label label1 = new Label("New defination:");
        TextArea textField1 = new TextArea();

        GridPane grid = new GridPane();
        grid.add(label, 1, 1);
        grid.add(label1, 1, 2);
        grid.add(textField1, 1, 3);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

        Button okBtn = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
        okBtn.addEventFilter(
                ActionEvent.ACTION, event -> {
                    String word = getCurrent();
                    String def = "<html><i>" + word + "</i><br/>" + "<ul><li><font color='#cc0000'><b>"
                            + textField1.getText() + "</b></font></li></ul></html>";
                    updateWord(new Word(word, def));
                    wordViewList.loadWords();
                    defview.loadNewDef(def);
                    setCurrent(word);
                }
        );

        dialog.showAndWait();
    }

}
