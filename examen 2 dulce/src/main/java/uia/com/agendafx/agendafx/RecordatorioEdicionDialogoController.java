package uia.com.agendafx.agendafx;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uia.com.agendafx.agendafx.modelo.Recordatorio;

public class RecordatorioEdicionDialogoController {
    @FXML
    private TextField tipoField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField fechaField;
    @FXML
    private TextField fechaRecordatorioField;


    private Stage dialogStage;
    private Recordatorio recordatorio;
    private boolean okClicked = false;



    @FXML
    private void initialize() {
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setContacto (Recordatorio recordatorio){
        this.recordatorio = recordatorio;

        tipoField.setText(recordatorio.getTipo());
        nombreField.setText(recordatorio.getNombre());
        fechaField.setText(recordatorio.getFecha());
        fechaRecordatorioField.setText(recordatorio.getFechaRecordatorio());
    }


    public boolean isOkClicked () {
        return okClicked;
    }


    @FXML
    private void handleOk () {
        if (isInputValid()) {

            this.recordatorio.setTipo(tipoField.getText());
            this.recordatorio.setNombre(nombreField.getText());
            this.recordatorio.setFecha(fechaField.getText());
            this.recordatorio.setFechaRecordatorio(fechaRecordatorioField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }


    @FXML
    private void handleCancel () {
        dialogStage.close();
    }


    private boolean isInputValid () {
        String errorMessage = "";

        if (tipoField.getText() == null || tipoField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (fechaField.getText() == null || fechaField.getText().length() == 0) {
            errorMessage += "No valid fecha!\n";
        }

        if (fechaRecordatorioField.getText() == null || fechaRecordatorioField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}


