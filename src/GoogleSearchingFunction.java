import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class GoogleSearchingFunction extends Root{

    private final Button googleSearchBtn;
    private final String TAG = "#googleSearch";

    public GoogleSearchingFunction(Scene scene){
        googleSearchBtn = (Button) scene.lookup(TAG);
    }

    public void setGoogleSearchBtn(DefView defView, FindField findField) {

        googleSearchBtn.setOnAction(e -> {
            findField.hideSearchView();

            setCurrent(findField.getFindFieldValue());
            if(getCurrent()!=null){
                try {
                    String def = "<b> -" + GoogleTranslate.translate(getCurrent()) + "</b>";
                    defView.representDef(def);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            addToHistorySearch(getCurrent());
        });
    }


}
