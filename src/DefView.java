import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class DefView extends Root{
    private WebView defView;
    private String tag = "#defView";

    public DefView(Scene scene){
        init(scene);
    }

    private void init(Scene scene){
        defView = (WebView) scene.lookup(tag);
    }
    public void representDef(String def){
        if(def != null){
            defView.getEngine().loadContent(def, "text/html");
        }else {
            clearDefView();
        }
    }

    public void clearDefView(){
        defView.getEngine().loadContent("", "text/html");
    }

    public void loadNewDef(String word){
        defView.getEngine().loadContent(word, "text/html");
    }
}
