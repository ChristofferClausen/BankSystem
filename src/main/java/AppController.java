import bank.BankName;
import human.Person;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AppController implements Initializable {
    @FXML private TextArea messageTransfer;
    @FXML private TextField idAmount, idTextTo, idTextFr, textId, amountId, firstNameId, lastNameId, ageId, bankId, amountDeposit, amountWithDraw, accountId;
    @FXML private Label accountIdClient, firstNameClient, lastNameClient, saldoClient;
    @FXML private ComboBox<BankName> bankNameId;
    @FXML private ComboBox personId;
    @FXML private Button selectId, newClientId, newBankIId, newAccountId;
    private int tempId;
    private List<BankName> filterList;
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
    private void goToRedanKundMenu() throws IOException {
        App.setRoot("redankund");
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
    private void goTobankStatements() throws IOException{
        App.setRoot("bankStatements");
    }
    @FXML
    private void selectOneAccount(ActionEvent actionEvent) throws IOException {
        int id = Integer.parseInt(textId.getText());
        boolean exist = BankName.getInstance().checkAccountId(id);
        if (exist){
            tempId = Integer.parseInt(accountId.getText());
            textId.setText("");
            filterList = model.accountList.stream()
                    .filter(e -> e.getId() == tempId)
                    .collect(Collectors.toList());
            accountIdClient.setText(String.valueOf(tempId));
            //firstNameClient.setText(filterList.get(0).);
            //lastNameClient.setText(filterList.get(0).);
            saldoClient.setText(String.valueOf(filterList.get(0).getSaldo()));
            App.setRoot("redankund");
        }else {
            textId.setText("");
            errorLogin();
        }
    }
    @FXML
    private void createNewAccount(ActionEvent actionEvent){
        String textPerson = personId.getAccessibleText();
        String[] words=textPerson.split(" ");
        int l = words.length;
        String firstName = words[0];
        String lastName = words[1];
        int age = Integer.parseInt(words[2]);
        model.accountList = accountingSystem.createAccount(bankNameId.getAccessibleText(), BankName.getInstance().accountId(), Float.parseFloat(amountId.getText()), new Person(firstName, lastName, age));
        amountId.setText("");
    }
    @FXML
    private void createNewPerson(ActionEvent actionEvent){
        model.personList.add(accountingSystem.createPerson(firstNameId.getText(), lastNameId.getText(), Integer.parseInt(ageId.getText())));
        firstNameId.setText("");
        lastNameId.setText("");
        ageId.setText("");
    }
    @FXML
    private void createNewBank(ActionEvent actionEvent){
        model.bankNameList.add(accountingSystem.createBank(bankId.getText()));
        bankId.setText("");
    }
    @FXML
    private void deposit(ActionEvent actionEvent) throws IOException{
        BankName.getInstance().deposit(tempId, Integer.parseInt(amountDeposit.getText()));
        filterList.clear();
        amountDeposit.setText("");
        filterList = model.accountList.stream()
                .filter(e -> e.getId() == tempId)
                .collect(Collectors.toList());
        accountIdClient.setText(String.valueOf(tempId));
        //firstNameClient.setText(filterList.get(0).);
        //lastNameClient.setText(filterList.get(0).);
        saldoClient.setText(String.valueOf(filterList.get(0).getSaldo()));
        App.setRoot("redankund");
    }
    @FXML
    private void withDraw(ActionEvent actionEvent) throws IOException {
        BankName.getInstance().withDraw(tempId, Integer.parseInt(amountWithDraw.getText()));
        filterList.clear();
        amountWithDraw.setText("");
        filterList = model.accountList.stream()
                .filter(e -> e.getId() == tempId)
                .collect(Collectors.toList());
        accountIdClient.setText(String.valueOf(tempId));
        //firstNameClient.setText(filterList.get(0).);
        //lastNameClient.setText(filterList.get(0).);
        saldoClient.setText(String.valueOf(filterList.get(0).getSaldo()));
        App.setRoot("redankund");
    }
    @FXML
    private void makeTransfer(ActionEvent actionEvent) throws IOException{
        BankName.getInstance().transfer(tempId, Integer.parseInt(idTextTo.getText()), Float.parseFloat(idAmount.getText()));
        filterList.clear();
        idTextTo.setText("");
        idAmount.setText("");
        messageTransfer.setText("");
        filterList = model.accountList.stream()
                .filter(e -> e.getId() == tempId)
                .collect(Collectors.toList());
        accountIdClient.setText(String.valueOf(tempId));
        //firstNameClient.setText(filterList.get(0).);
        //lastNameClient.setText(filterList.get(0).);
        saldoClient.setText(String.valueOf(filterList.get(0).getSaldo()));
        App.setRoot("redankund");
    }
    @FXML
    private void getSaldo(ActionEvent actionEvent){
        BankName.getInstance().account(tempId, Integer.parseInt(amountWithDraw.getText()));
        amountWithDraw.setText("");
    }

    @FXML
    private void goToMainMenu(ActionEvent actionEvent) throws IOException{
        accountIdClient.setText("0");
        firstNameClient.setText(null);
        lastNameClient.setText(null);
        saldoClient.setText("0.0");
        textId.setText("");
        tempId = 0;
        filterList.clear();
        App.setRoot("home");
    }
    private void errorLogin(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("LOGIN ERROR");
        alert.setHeaderText(null);
        alert.setContentText("THIS ID DOES NOT EXISTE!");
        alert.showAndWait();
    }
    public void errorAmount(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WRONG AMOUNT");
        alert.setHeaderText(null);
        alert.setContentText("THIS AMOUNT AVAILABLE IS LESS THAN WHAT IT HAS BEEN CHOSEN!");
        alert.showAndWait();
    }

    @FXML
    public void goBack() throws IOException{
        App.setRoot("home");
    }
}
