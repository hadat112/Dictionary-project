import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Controller {
    private Root root;
    private WordViewList wordViewList;
    private DefView defView;
    private FindField findField;
    private SpellingFunction spellingFunction;
    private DeletingFunction deletingFunction;
    private AddingFunction addingFunction;
    private ChangingFunction changingFunction;
    private GoogleSearchingFunction googleSearchingFunction;
    private VipFunction vipFunction;

    public void init(Scene scene) {
        root = new Root();
        wordViewList = new WordViewList(scene);
        defView = new DefView(scene);
        findField = new FindField(scene);
        spellingFunction = new SpellingFunction(scene);
        deletingFunction = new DeletingFunction(scene);
        addingFunction = new AddingFunction(scene);
        changingFunction = new ChangingFunction(scene);
        googleSearchingFunction = new GoogleSearchingFunction(scene);
        vipFunction = new VipFunction(scene);
    }

    public void initData() throws IOException {
        root.createWordList();
        wordViewList.loadWords();
        wordViewList.loadDef(defView, findField);
    }

    public void addFunction() {
        findField.loadDefToDefView(defView, wordViewList);
        findField.addListenerToTextField(defView, wordViewList);
        findField.setMouseEventToSearchView();
        spellingFunction.spellCurrentWord(root);
        deletingFunction.deleteWord(wordViewList, defView);
        addingFunction.setAddingBtn(wordViewList);
        changingFunction.setChangingBtn(wordViewList, defView);
        googleSearchingFunction.setGoogleSearchBtn(defView, findField);
        vipFunction.setVipBtn();
    }

    public void hideSearchView(Parent root) {
        root.setOnMouseClicked(e -> {
            findField.hideSearchView();
        });
    }

}
