
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MangementScreen extends BorderPane {
	RadioButton insertRB = new RadioButton("Insert new electricity record");
	RadioButton updateDeleteRB = new RadioButton("Update or Delete electricity record");
	RadioButton searchRB = new RadioButton("Search for an electricity record");

	Label dateL = new Label("date:");
	Label israeliLinesL = new Label("israeli Lines MWs:");
	Label gazaPowerPlantL = new Label("gaza Power Plant MWs:");
	Label egyptianLinesL = new Label("egyptian Lines MWs:");
	Label totalDailySupplyAvailableInL = new Label("total Daily Supply Available InL MWs:");
	Label overallDemandInL = new Label("overall Demand In MWs:");
	Label powerCutsHoursDayL = new Label("power Cuts Hours Day400mg:");
	Label tempertureL = new Label("temperture:");

	TextField dateTF = new TextField("");
	TextField israeliLinesTF = new TextField("");
	TextField gazaPowerPlantTF = new TextField("");
	TextField egyptianLinesTF = new TextField("");
	TextField totalDailySupplyAvailableInTF = new TextField("");
	TextField overallDemandInTF = new TextField("");
	TextField powerCutsHoursDayTF = new TextField("");
	TextField tempertureTF = new TextField("");

	DatePicker datePicker = new DatePicker();
	Label statusL = new Label();

	public MangementScreen(Stage primaryStage, Scene mainScene) {
		ToggleGroup tg = new ToggleGroup();
		tg.getToggles().addAll(insertRB, updateDeleteRB, searchRB);

		Label optionsL = new Label("Options:");
		optionsL.setStyle("-fx-font-size: 14;-fx-text-fill: black;");

		HBox hb = new HBox(optionsL, insertRB, updateDeleteRB, searchRB);
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(20);
		setPadding(new Insets(15));
		setTop(hb);

		insertRB.setOnAction(e -> {
			setCenter(null);
			setBottom(null);
			dateTF.setText("");
			israeliLinesTF.setText("");
			gazaPowerPlantTF.setText("");
			egyptianLinesTF.setText("");
			totalDailySupplyAvailableInTF.setText("");
			overallDemandInTF.setText("");
			powerCutsHoursDayTF.setText("");
			tempertureTF.setText("");
			datePicker.setValue(null);
			statusL.setText("");
			insertElectricityLayout();

		});

		updateDeleteRB.setOnAction(e -> {
			setCenter(null);
			setBottom(null);
			dateTF.setText("");
			israeliLinesTF.setText("");
			gazaPowerPlantTF.setText("");
			egyptianLinesTF.setText("");
			totalDailySupplyAvailableInTF.setText("");
			overallDemandInTF.setText("");
			powerCutsHoursDayTF.setText("");
			tempertureTF.setText("");
			datePicker.setValue(null);
			updateDeleteElectricityLayout();
		});

		searchRB.setOnAction(e -> {
			setCenter(null);
			setBottom(null);
			dateTF.setText("");
			israeliLinesTF.setText("");
			gazaPowerPlantTF.setText("");
			egyptianLinesTF.setText("");
			totalDailySupplyAvailableInTF.setText("");
			overallDemandInTF.setText("");
			powerCutsHoursDayTF.setText("");
			tempertureTF.setText("");
			datePicker.setValue(null);
			statusL.setText("");
			searchElectricityLayout();
		});
	}

	private void insertElectricityLayout() {
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setAlignment(Pos.CENTER);

		dateTF.setMaxWidth(200);
		israeliLinesTF.setMaxWidth(200);
		gazaPowerPlantTF.setMaxWidth(200);
		egyptianLinesTF.setMaxWidth(200);
		totalDailySupplyAvailableInTF.setMaxWidth(200);
		overallDemandInTF.setMaxWidth(200);
		powerCutsHoursDayTF.setMaxWidth(200);
		tempertureTF.setMaxWidth(200);

		gp.add(dateL, 0, 0);
		gp.add(israeliLinesL, 0, 1);
		gp.add(gazaPowerPlantL, 0, 2);
		gp.add(egyptianLinesL, 0, 3);
		gp.add(totalDailySupplyAvailableInL, 0, 4);
		gp.add(overallDemandInL, 0, 5);
		gp.add(powerCutsHoursDayL, 0, 6);
		gp.add(tempertureL, 0, 7);

		gp.add(datePicker, 1, 0);
		gp.add(israeliLinesTF, 1, 1);
		gp.add(gazaPowerPlantTF, 1, 2);
		gp.add(egyptianLinesTF, 1, 3);
		gp.add(totalDailySupplyAvailableInTF, 1, 4);
		gp.add(overallDemandInTF, 1, 5);
		gp.add(powerCutsHoursDayTF, 1, 6);
		gp.add(tempertureTF, 1, 7);

		setCenter(gp);
		setMargin(gp, new Insets(15));

		Button insertBtn = new Button("Insert Electricity Record");
		gp.add(insertBtn, 1, 9);

		statusL.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18;");

		setBottom(statusL);
		setAlignment(statusL, Pos.CENTER);

		insertBtn.setOnAction(e -> {
		try {
			if (datePicker.getValue() == null) {
				statusL.setText("Date field cannot be empty, please specify a specific date!!!");
				return;
			}
			LocalDate selectedDate = datePicker.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String date = selectedDate.format(formatter);

			double israeliLines = Double.parseDouble(israeliLinesTF.getText().trim());
			double gazaPowerPlant = Double.parseDouble(gazaPowerPlantTF.getText().trim());
			double egyptianLines = Double.parseDouble(egyptianLinesTF.getText().trim());
			double totalDailySupplyAvailableIn = Double.parseDouble(totalDailySupplyAvailableInTF.getText().trim());
		//	double totalDailySupplyAvailableIn = israeliLines +gazaPowerPlant+egyptianLines;
		//	totalDailySupplyAvailableInTF.setText(String.valueOf(totalDailySupplyAvailableIn));
		//	totalDailySupplyAvailableInTF.setEditable(false);
			
			double overallDemandIn = Double.parseDouble(overallDemandInTF.getText().trim());
			double powerCutsHoursDay = Double.parseDouble(powerCutsHoursDayTF.getText().trim());
			double temperture = Double.parseDouble(tempertureTF.getText().trim());

			if (date.equals("")) {
				statusL.setText("Date field cannot be empty, please specify a specific date!!!");
				return;
			}
			Electricity electricity = new Electricity(date, israeliLines, gazaPowerPlant, egyptianLines,
					totalDailySupplyAvailableIn, overallDemandIn, powerCutsHoursDay, temperture);

			if (selectedDate != null) {
				int year = selectedDate.getYear();
				int month = selectedDate.getMonthValue();
				int day = selectedDate.getDayOfMonth();

				Month monthObj = new Month(month);
				Day dayObj = new Day(day, electricity);
				Year yearObj = new Year(year);

				Node<Year> nodeY = Main.years.search(yearObj);
				if (nodeY == null) {
					statusL.setText("The new electricity record has been added successfully.");
					Main.years.insertSorted(yearObj);
					yearObj.getMonths().insertSorted(monthObj);
					monthObj.getDays().insertSorted(dayObj);

				} else if (nodeY != null) {
					yearObj = nodeY.getData();
					Node<Month> nodeM = yearObj.getMonths().search(monthObj);
					Node<Day> nodeD = null;

					if (yearObj.getYear() == 2023 && monthObj.getMonth() > 9) {
						nodeM = null;
						nodeD = null;
					} else {
						if (nodeM != null) {
							Month monthData = nodeM.getData();
							nodeD = monthData.getDays().search(dayObj);
						}
					}

					if (nodeM != null && nodeD != null) {
						statusL.setText("Electricity record already exists.");
						return;
					}

					if (nodeM == null) {
						yearObj.getMonths().insertSorted(monthObj);
						statusL.setText("New month object inserted successfully");
					}

					if (nodeD == null) {
						monthObj.getDays().insertSorted(dayObj);
							statusL.setText("New day object inserted successfully");
						}
						statusL.setText("The new electricity record has been added successfully.");
					}

				}
			} catch (NumberFormatException ex) {
				statusL.setText("Invalid date or numeric value entered.");
			}

		});

	}

	private void updateDeleteElectricityLayout() {
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setAlignment(Pos.CENTER);

		dateTF.setMaxWidth(200);
		israeliLinesTF.setMaxWidth(200);
		gazaPowerPlantTF.setMaxWidth(200);
		egyptianLinesTF.setMaxWidth(200);
		totalDailySupplyAvailableInTF.setMaxWidth(200);
		overallDemandInTF.setMaxWidth(200);
		powerCutsHoursDayTF.setMaxWidth(200);
		tempertureTF.setMaxWidth(200);

		gp.add(dateL, 0, 0);
		gp.add(israeliLinesL, 0, 1);
		gp.add(gazaPowerPlantL, 0, 2);
		gp.add(egyptianLinesL, 0, 3);
		gp.add(totalDailySupplyAvailableInL, 0, 4);
		gp.add(overallDemandInL, 0, 5);
		gp.add(powerCutsHoursDayL, 0, 6);
		gp.add(tempertureL, 0, 7);

		gp.add(datePicker, 1, 0);
		gp.add(israeliLinesTF, 1, 1);
		gp.add(gazaPowerPlantTF, 1, 2);
		gp.add(egyptianLinesTF, 1, 3);
		gp.add(totalDailySupplyAvailableInTF, 1, 4);
		gp.add(overallDemandInTF, 1, 5);
		gp.add(powerCutsHoursDayTF, 1, 6);
		gp.add(tempertureTF, 1, 7);

		setCenter(gp);
		setMargin(gp, new Insets(15));

		Label statusL = new Label();
		statusL.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18;");

		setBottom(statusL);
		setAlignment(statusL, Pos.CENTER);

		Button updateBtn = new Button("Update Electricity Record");
		Button deleteBtn = new Button("Delete Electricity Record");
		Button searchBtn = new Button("Search");
		gp.add(searchBtn, 2, 0);

		searchBtn.setOnAction(e -> {
			gp.getChildren().remove(updateBtn);
			gp.getChildren().remove(deleteBtn);

			if (datePicker.getValue() == null) {
				statusL.setText("Date field cannot be empty, please specify a specific date!!!");
				return;
			}
			LocalDate selectedDate = datePicker.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String date = selectedDate.format(formatter);

			if (selectedDate != null) {
				int year = selectedDate.getYear();
				int month = selectedDate.getMonthValue();
				int day = selectedDate.getDayOfMonth();

				Electricity electricity = null;

				Month monthObj = new Month(month); // dummy
				Day dayObj = new Day(day, electricity); // dummy
				Year yearObj = new Year(year); // dummy

				Node<Year> nodeY = Main.years.search(yearObj);

				if (nodeY == null) {
					statusL.setText("the year does not exist.");
				} else {
					yearObj = nodeY.getData(); // correct object
					Node<Month> nodeM = yearObj.getMonths().search(monthObj);
					if (nodeM == null) {
						statusL.setText("the month does not exist.");
					} else {
						monthObj = nodeM.getData(); // correct object
						Node<Day> nodeD = monthObj.getDays().search(dayObj);
						if (nodeD == null) {
							statusL.setText("the day does not exist.");
						} else {
							electricity = nodeD.getData().getRecord();
							israeliLinesTF.setText(String.valueOf(electricity.getIsraeliLinesMWs()).trim());
							gazaPowerPlantTF.setText(String.valueOf(electricity.getGazaPowerPlantMWs()).trim());
							egyptianLinesTF.setText(String.valueOf(electricity.getEgyptianLinesMWs()).trim());
							totalDailySupplyAvailableInTF
									.setText(String.valueOf(electricity.getOverallDemandInMWs()).trim());
							overallDemandInTF.setText(String.valueOf(electricity.getOverallDemandInMWs()).trim());
							powerCutsHoursDayTF.setText(String.valueOf(electricity.getPowerCutsHoursDay400mg()).trim());
							tempertureTF.setText(String.valueOf(electricity.getTemperture()).trim());
							gp.add(updateBtn, 2, 1);
							gp.add(deleteBtn, 2, 2);
						}
					}
				}
			}

		});

		updateBtn.setOnAction(e -> {
			try {
			if (datePicker.getValue() == null) {
				statusL.setText("Date field cannot be empty, please specify a specific date!!!");
				return;
			}
			LocalDate selectedDate = datePicker.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

			String date = selectedDate.format(formatter);
			int year = selectedDate.getYear();
			int month = selectedDate.getMonthValue();
			int day = selectedDate.getDayOfMonth();

			// Get the updated values from the text fields
			Double israeliLines = Double.parseDouble(israeliLinesTF.getText().trim());
			Double gazaPowerPlant = Double.parseDouble(gazaPowerPlantTF.getText().trim());
			Double egyptianLines = Double.parseDouble(egyptianLinesTF.getText().trim());
			Double overallDemand = Double.parseDouble(overallDemandInTF.getText().trim());
			Double powerCutsHours = Double.parseDouble(powerCutsHoursDayTF.getText().trim());
			Double temperture = Double.parseDouble(tempertureTF.getText().trim());

			// Create the Electricity object with updated values
			Electricity updatedElectricity = new Electricity(date, israeliLines, gazaPowerPlant, egyptianLines,
					overallDemand, powerCutsHours, temperture, temperture);

			// Create the dummy objects for search
			Month monthObj = new Month(month);
			Day dayObj = new Day(day, null);
			Year yearObj = new Year(year);

			Node<Year> nodeY = Main.years.search(yearObj);
			if (nodeY == null) {
				statusL.setText("The year does not exist.");
			} else {
				yearObj = nodeY.getData(); // Correct year object
				Node<Month> nodeM = yearObj.getMonths().search(monthObj);
				if (nodeM == null) {
					statusL.setText("The month does not exist.");
				} else {
					monthObj = nodeM.getData(); // Correct month object
					Node<Day> nodeD = monthObj.getDays().search(dayObj);
					if (nodeD == null) {
						statusL.setText("The day does not exist.");
					} else {
						Day dayObjWithData = nodeD.getData();
						dayObjWithData.setRecord(updatedElectricity); // Update the electricity record of the day
						statusL.setText("Record for " + selectedDate.toString() + " updated successfully.");
					}
				}
			}
			
		} catch (NumberFormatException ex) {
			statusL.setText("Invalid date or numeric value entered.");
		}
		});

		deleteBtn.setOnAction(e -> {
			if (datePicker.getValue() == null) {
				statusL.setText("Date field cannot be empty, please specify a specific date!!!");
				return;
			}
			LocalDate selectedDate = datePicker.getValue();
			int year = selectedDate.getYear();
			int month = selectedDate.getMonthValue();
			int day = selectedDate.getDayOfMonth();

			// Create the dummy objects for search
			Month monthObj = new Month(month);
			Day dayObj = new Day(day, null);
			Year yearObj = new Year(year);

			Node<Year> nodeY = Main.years.search(yearObj);
			if (nodeY == null) {
				statusL.setText("The year does not exist.");
			} else {
				yearObj = nodeY.getData(); // Correct year object
				Node<Month> nodeM = yearObj.getMonths().search(monthObj);
				if (nodeM == null) {
					statusL.setText("The month does not exist.");
				} else {
					monthObj = nodeM.getData(); // Correct month object
					Node<Day> nodeD = monthObj.getDays().search(dayObj);
					if (nodeD == null) {
						statusL.setText("The day does not exist.");
					} else {
						monthObj.getDays().delete(dayObj); // Delete the day node from the list
						statusL.setText("Record for " + selectedDate.toString() + " deleted successfully.");

						israeliLinesTF.clear();
						gazaPowerPlantTF.clear();
						egyptianLinesTF.clear();
						totalDailySupplyAvailableInTF.clear();
						overallDemandInTF.clear();
						powerCutsHoursDayTF.clear();
						tempertureTF.clear();

						gp.getChildren().remove(updateBtn);
						gp.getChildren().remove(deleteBtn);
					}
				}
			}
		});

	}

	private void searchElectricityLayout() {
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setAlignment(Pos.CENTER);

		dateTF.setMaxWidth(200);
		israeliLinesTF.setMaxWidth(200);
		gazaPowerPlantTF.setMaxWidth(200);
		egyptianLinesTF.setMaxWidth(200);
		totalDailySupplyAvailableInTF.setMaxWidth(200);
		overallDemandInTF.setMaxWidth(200);
		powerCutsHoursDayTF.setMaxWidth(200);
		tempertureTF.setMaxWidth(200);

		gp.add(dateL, 0, 0);
		gp.add(israeliLinesL, 0, 1);
		gp.add(gazaPowerPlantL, 0, 2);
		gp.add(egyptianLinesL, 0, 3);
		gp.add(totalDailySupplyAvailableInL, 0, 4);
		gp.add(overallDemandInL, 0, 5);
		gp.add(powerCutsHoursDayL, 0, 6);
		gp.add(tempertureL, 0, 7);

		gp.add(datePicker, 1, 0);
		gp.add(israeliLinesTF, 1, 1);
		gp.add(gazaPowerPlantTF, 1, 2);
		gp.add(egyptianLinesTF, 1, 3);
		gp.add(totalDailySupplyAvailableInTF, 1, 4);
		gp.add(overallDemandInTF, 1, 5);
		gp.add(powerCutsHoursDayTF, 1, 6);
		gp.add(tempertureTF, 1, 7);

		setCenter(gp);
		setMargin(gp, new Insets(15));

		statusL.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18;");

		setBottom(statusL);
		setAlignment(statusL, Pos.CENTER);
		Button searchBtn = new Button("Search by specific date");
		gp.add(searchBtn, 2, 0);

		searchBtn.setOnAction(e -> {
			if (datePicker.getValue() == null) {
				statusL.setText("Date field cannot be empty, please specify a specific date!!!");
				return;
			}
			LocalDate selectedDate = datePicker.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String date = selectedDate.format(formatter);

			if (selectedDate != null) {
				int year = selectedDate.getYear();
				int month = selectedDate.getMonthValue();
				int day = selectedDate.getDayOfMonth();

				Electricity electricity = null;

				Month monthObj = new Month(month); // dummy
				Day dayObj = new Day(day, electricity); // dummy
				Year yearObj = new Year(year); // dummy

				Node<Year> nodeY = Main.years.search(yearObj);

				if (nodeY == null) {
					statusL.setText("the year does not exist.");
				} else {
					yearObj = nodeY.getData(); // correct object
					Node<Month> nodeM = yearObj.getMonths().search(monthObj);
					if (nodeM == null) {
						statusL.setText("the month does not exist.");
					} else {
						monthObj = nodeM.getData(); // correct object
						Node<Day> nodeD = monthObj.getDays().search(dayObj);
						if (nodeD == null) {
							statusL.setText("the day does not exist.");
						} else {
							electricity = nodeD.getData().getRecord();
							israeliLinesTF.setText(String.valueOf(electricity.getIsraeliLinesMWs()).trim());
							gazaPowerPlantTF.setText(String.valueOf(electricity.getGazaPowerPlantMWs()).trim());
							egyptianLinesTF.setText(String.valueOf(electricity.getEgyptianLinesMWs()).trim());
							totalDailySupplyAvailableInTF
									.setText(String.valueOf(electricity.getOverallDemandInMWs()).trim());
							overallDemandInTF.setText(String.valueOf(electricity.getOverallDemandInMWs()).trim());
							powerCutsHoursDayTF.setText(String.valueOf(electricity.getPowerCutsHoursDay400mg()).trim());
							tempertureTF.setText(String.valueOf(electricity.getTemperture()).trim());
						}
					}
				}
			}

		});

	}
}
