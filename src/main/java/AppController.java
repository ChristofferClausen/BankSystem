import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.io.IOException;

public class AppController {
    @FXML private TextArea messageTransfer;
    @FXML private TextField idAmount, idTextTo, idTextFr, textId;
    @FXML private Button selectId;


    public AppController() {
    }

    @FXML
    private void createPerson() throws IOException {
        App.setRoot("person");
    }

    @FXML
    private void createBankName() throws IOException {
        App.setRoot("bank");
    }

    @FXML
    private void createAccount() throws IOException {
        App.setRoot("account");
    }

    @FXML
    private void backToHome() throws IOException {
        App.setRoot("home");
    }
    @FXML
    private void goToNyKund() throws IOException {
        App.setRoot("nykund");
    }

    @FXML
    private void goToRedanKund() throws IOException {
        App.setRoot("selectClient");
    }
    @FXML
    private void goToWithdraw() throws IOException {
        App.setRoot("withdraw");
    }

    @FXML
    private void goToDeposit() throws IOException {
        App.setRoot("deposit");
    }
    @FXML
    private void goToTransfer() throws IOException {
        App.setRoot("transfer");
    }

    @FXML
    private void makeTransfer(ActionEvent actionEvent) {
        int idFrom = Integer.parseInt(idTextFr.getText());
        int idTo = Integer.parseInt(idTextTo.getText());
        double amount = Double.parseDouble(idAmount.getText());
        Transfer.getInstance().transfer(idFrom, idTo, amount);

        idTextFr.setText("");
        idTextTo.setText("");
        idAmount.setText("");
        messageTransfer.setText("");
    }

    @FXML
    private void selectOneAccount(ActionEvent actionEvent) throws IOException {
        int id = Integer.parseInt(textId.getText());
        boolean exist = Transfer.getInstance().checkAccountId(id);
        if (exist){
            App.setRoot("redankund");
        }
    }
}
