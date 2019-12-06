import bank.BankName;
import human.Person;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML private TextArea messageTransfer;
    @FXML private TextField idAmount, idTextTo, idTextFr, textId, amountId, firstNameId, lastNameId, ageId, bankId;
    @FXML private ComboBox<BankName> bankNameId;
    @FXML private ComboBox personId;
    @FXML private Button selectId;
    Model model;
    AccountingSystem accountingSystem;


    public AppController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      BankName.getInstance().dataForTest();
        model = new Model();
        bankNameId = new ComboBox<>(FXCollections.observableArrayList(model.bankNameList));
        personId = new ComboBox<>(FXCollections.observableArrayList(model.personList));
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
        BankName.getInstance().transfer(idFrom, idTo, (float) amount);
        idTextFr.setText("");
        idTextTo.setText("");
        idAmount.setText("");
        messageTransfer.setText("");
    }

    @FXML
    private void selectOneAccount(ActionEvent actionEvent) throws IOException {
        int id = Integer.parseInt(textId.getText());
        boolean exist = BankName.getInstance().checkAccountId(id);
        if (exist){
            App.setRoot("redankund");
        }
    }
    @FXML
    private void createNewAccount(){
        //values in comments for JUnit test
        // String bankName= "swedBank";
        //float saldo = Float.parseFloat("60000");
        String textPerson = personId.getAccessibleText(); //String textPerson = "Seco Deco 42";
        String[] words=textPerson.split(" ");
        int l = words.length;
        String firstName = words[0];
        String lastName = words[1];
        int age = Integer.parseInt(words[2]);
        model.accountList = accountingSystem.createAccount(bankNameId.getAccessibleText(), BankName.getInstance().accountId(), Float.parseFloat(amountId.getText()), new Person(firstName, lastName, age));
        //BankName.getInstance().accountList.add(new BankName(bankName, BankName.getInstance().accountId(), saldo, new Person(firstName, lastName, age)));
    }
    @FXML
    private void createNewPerson(ActionEvent actionEvent){
        model.personList.add(accountingSystem.createPerson(firstNameId.getText(), lastNameId.getText(), Integer.parseInt(ageId.getText())));
    }
    @FXML
    private void createNewBank(ActionEvent actionEvent){
        model.bankNameList.add(accountingSystem.createBank(bankId.getText()));
    }

}
