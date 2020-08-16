package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import gui.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class MainViewController implements Initializable {

	@FXML
	private ComboBox<Person> comboboxPerson;
	@FXML
	private Button btnAll;

	private ObservableList<Person> obsList;
	
	@FXML
	public void onBtnAllAction() {
		for(Person person : comboboxPerson.getItems()) {
			System.out.println(person);
		}
	}
	
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboboxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> list = new ArrayList<>();

		list.add(new Person(1, "Maria", "Mmaria@gmail.com"));
		list.add(new Person(2, "Pedro", "pedro@gmail.com"));
		list.add(new Person(3, "Carlos", "carlos@gmail.com"));

		obsList = FXCollections.observableArrayList(list);
		comboboxPerson.setItems(obsList);

		//Personalisando o toStrinbg
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getNome());
			}
		};
		comboboxPerson.setCellFactory(factory);
		comboboxPerson.setButtonCell(factory.call(null));
	}
}
