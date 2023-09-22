package lk.ijse;

import com.fazecast.jSerialComm.SerialPort;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FormController extends Application {
    public static SerialPort sp = SerialPort.getCommPort("/dev/cu.usbmodem142301");
    public Button btnRedLED;
    public Button btnGreenLED;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        if(!sp.openPort()) {
            System.out.println("\nCOM port NOT available\n"); return;
        }
        launch(args);
    }

    public void btnRedLEDOnAction(ActionEvent actionEvent) throws IOException {
        Integer code = 1;
        sp.getOutputStream().write(code.byteValue());
    }

    public void btnGreenLEDOnAction(ActionEvent actionEvent) throws IOException {
        Integer code = 2;
        sp.getOutputStream().write(code.byteValue());
    }
}
