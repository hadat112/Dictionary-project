import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class VipFunction {
    private Button vipBtn;
    private final String VIP_TAG = "#vip";

    public VipFunction(Scene scene){
        vipBtn = (Button) scene.lookup(VIP_TAG);
    }

    public void setVipBtn(){
        vipBtn.setOnMouseClicked(e -> {
            showVipInformation();
        });
    }

    public void showVipInformation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("V.I.P");
        alert.setHeaderText("Want to become VIP?");
        alert.setContentText("Pay 1.000$ to become VIP.1!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            alert.hide();
        }
    }
}
