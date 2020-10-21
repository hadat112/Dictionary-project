import javafx.scene.Scene;
import javafx.scene.control.ListView;

public class WordViewList extends Root{
    private final String tag = "#wordView";
    private ListView<String> wordView;

    public WordViewList(Scene scene){
        init(scene);
    }

    private void init(Scene scene){
        wordView = (ListView<String>) scene.lookup(tag);
    }

    public void loadWords() {
        wordView.getItems().clear();
        wordView.getItems().addAll(getWordList().keySet());
    }

    public void loadDef(DefView defView, FindField findField) {
        wordView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    findField.hideSearchView();
                    String selectedWordDef = "";
                    if(newValue != null){
                        selectedWordDef = getWordList().get(newValue).getDef();
                    }
                    defView.representDef(selectedWordDef);
                    setCurrent(newValue);
                }
        );
    }

    public void jumpTo(String word){
        wordView.scrollTo(word);
    }
}
