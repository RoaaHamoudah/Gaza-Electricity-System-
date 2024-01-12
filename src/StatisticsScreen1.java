import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StatisticsScreen1 extends BorderPane {
	RadioButton optionA = new RadioButton("Daily electricity data.");
	RadioButton optionB = new RadioButton("Monthly electricity data.");
	RadioButton optionC = new RadioButton("Yearly electricity data.");
	RadioButton optionD = new RadioButton("Total statistic for all data.");

	Label totalL = new Label("total:");
	Label maximumL = new Label("maximum:");
	Label minimumL = new Label("minimum:");
	Label averageL = new Label("average:");

	TextField totalTF = new TextField("");
	TextField maximumTF = new TextField("");
	TextField minimumTF = new TextField("");
	TextField averageTF = new TextField("");

	Label specificDayL = new Label("choose a specific day");
	TextField specificDayTF = new TextField();

	Label specificMonthL = new Label("choose a specific month");
	TextField specificMonthTF = new TextField();

	Label specificYearL = new Label("choose a specific year");
	TextField specificYearTF = new TextField();

	Label statusL = new Label();

	static int count;
	static double total = 0;
	static double maximum = Double.MIN_VALUE;
	static double minimum = Double.MAX_VALUE;
	static double average = 0;

	static double totalFortotalDailySupplyAvailable = 0;
	static double totaloverallDemand = 0;
	static double totalpowerCutsHoursDay = 0;
	static double totaltemperture = 0;

	static double maximumIsraeliLines = Double.MIN_VALUE;
	static double maximumGazaPowerPlant = Double.MIN_VALUE;
	static double maximumEgyptianLines = Double.MIN_VALUE;
	static double maximumFortotalDailySupplyAvailable = Double.MIN_VALUE;
	static double maximumoverallDemand = Double.MIN_VALUE;
	static double maximumpowerCutsHoursDay = Double.MIN_VALUE;
	static double maximumtemperture = Double.MIN_VALUE;

	static double minimumIsraeliLines = Double.MAX_VALUE;
	static double minimumGazaPowerPlant = Double.MAX_VALUE;
	static double minimumEgyptianLines = Double.MAX_VALUE;
	static double minimumFortotalDailySupplyAvailable = Double.MAX_VALUE;
	static double minimumOverallDemand = Double.MAX_VALUE;
	static double minimumPowerCutsHoursDay = Double.MAX_VALUE;
	static double minimumTemperture = Double.MAX_VALUE;

	static double averageFortotalDailySupplyAvailable = 0;
	static double averageOverallDemand = 0;
	static double averagePowerCutsHoursDay = 0;
	static double averageTemperture = 0;

	static int counttotalDailySupplyAvailable;
	static int countOverallDemand;
	static int countPowerCutsHoursDay;
	static int countTemperture;

	Label L1 = new Label("Israeli_Lines");
	Label L2 = new Label("Gaza_Power_Plant");
	Label L3 = new Label("Egyptian_Lines");
	Label L4 = new Label("Total_daily_Supply");
	Label L5 = new Label("Overall_demand");
	Label L6 = new Label("Power_Cuts_hours_day");
	Label L7 = new Label("Temperture");

	Label L8 = new Label("total");
	Label L9 = new Label("average");
	Label L10 = new Label("maximum");
	Label L11 = new Label("maximum");
	Label L12 = new Label("minimum");
	Label L13 = new Label("minimum");

	TextField TF1 = new TextField("");
	TextField TF2 = new TextField("");
	TextField TF3 = new TextField("");
	TextField TF4 = new TextField("");
	TextField TF5 = new TextField("");
	TextField TF6 = new TextField("");
	TextField TF7 = new TextField("");
	TextField TF8 = new TextField("");
	TextField TF9 = new TextField("");
	TextField TF10 = new TextField("");
	TextField TF11 = new TextField("");
	TextField TF12 = new TextField("");
	TextField TF13 = new TextField("");
	TextField TF14 = new TextField("");
	TextField TF15 = new TextField("");
	TextField TF16 = new TextField("");
	TextField TF17 = new TextField("");
	TextField TF18 = new TextField("");
	TextField TF19 = new TextField("");
	TextField TF20 = new TextField("");
	TextField TF21 = new TextField("");
	TextField TF22 = new TextField("");

	Button calculateButton = new Button("Calculate");

	public StatisticsScreen1(Stage primaryStage, Scene Scene) {

		ToggleGroup tg = new ToggleGroup();
		tg.getToggles().addAll(optionA, optionB, optionC, optionD);

		Label optionsL = new Label("Options:");
		optionsL.setStyle("-fx-font-size: 14;-fx-text-fill: black;");

		HBox vb = new HBox(optionsL, optionA, optionB, optionC, optionD);
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(20);
		setPadding(new Insets(15));
		setTop(vb);

		optionA.setOnAction(e -> {
			setCenter(null);
			setBottom(null);
			totalTF.setText("");
			maximumTF.setText("");
			minimumTF.setText("");
			averageTF.setText("");
			statusL.setText("");
			specificDayTF.setText("");
			calculateSpecificStatisticForDay();

		});

		optionB.setOnAction(e -> {
			setCenter(null);
			setBottom(null);
			totalTF.setText("");
			maximumTF.setText("");
			minimumTF.setText("");
			averageTF.setText("");
			statusL.setText("");
			specificMonthTF.setText("");
			calculateSpecificStatisticForMonth();
		});

		optionC.setOnAction(e -> {
			setCenter(null);
			setBottom(null);
			totalTF.setText("");
			maximumTF.setText("");
			minimumTF.setText("");
			averageTF.setText("");
			statusL.setText("");
			specificYearTF.setText("");
			calculateSpecificStatisticForYear();
		});

		optionD.setOnAction(e -> {
			TF1.setText("");
			TF2.setText("");
			TF3.setText("");
			TF4.setText("");
			TF5.setText("");
			TF6.setText("");
			TF7.setText("");
			TF8.setText("");
			TF9.setText("");
			TF10.setText("");
			TF11.setText("");
			TF12.setText("");
			TF13.setText("");
			TF14.setText("");
			TF15.setText("");
			TF16.setText("");
			TF17.setText("");
			TF18.setText("");
			TF19.setText("");
			TF20.setText("");
			TF21.setText("");
			TF22.setText("");
			setCenter(null);
			setBottom(null);
			totalTF.setText("");
			maximumTF.setText("");
			minimumTF.setText("");
			averageTF.setText("");
			statusL.setText("");
			specificYearTF.setText("");
			calculateStatisticsOverall();
		});

	}

	public void calculateSpecificStatisticForDay() {
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setAlignment(Pos.CENTER);

		gp.add(totalL, 0, 0);
		gp.add(totalTF, 1, 0);
		gp.add(maximumL, 0, 1);
		gp.add(maximumTF, 1, 1);
		gp.add(minimumL, 0, 2);
		gp.add(minimumTF, 1, 2);
		gp.add(averageL, 0, 3);
		gp.add(averageTF, 1, 3);

		specificDayTF.setMaxWidth(200);
		gp.add(specificDayL, 0, 4);
		gp.add(specificDayTF, 1, 4);

		setCenter(gp);
		setMargin(gp, new Insets(15));

		statusL.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18;");
		setBottom(statusL);
		setAlignment(statusL, Pos.CENTER);

		gp.add(calculateButton, 2, 4);
		calculateButton.setOnAction(e -> {
			calculateStatistics();
		});
	}

	private void calculateStatistics() {
		try {
		double specificDay = Double.parseDouble(specificDayTF.getText());
		count = 0;
		total = 0.0;
		maximum = Double.MIN_VALUE;
		minimum = Double.MAX_VALUE;

		Node<Year> currYear = Main.years.getHead();
		if (currYear != null) {
			do {
				Node<Month> currMonth = currYear.getData().getMonths().getHead();
				if (currMonth != null) {
					do {
						Month month = currMonth.getData();
						Node<Day> currentDay = month.getDays().getHead();
						if (currentDay != null) {
							do {
								Day day = currentDay.getData();
								double specificStatistic = day.getRecord().getTotalDailySupplyAvailableInMWs();
								if (specificDay == day.getDay()) {
									total += specificStatistic;
									maximum = Math.max(maximum, specificStatistic);
									minimum = Math.min(minimum, specificStatistic);
									count++;
								}
								currentDay = currentDay.getNext();
							} while (currentDay != month.getDays().getHead());
						}
						currMonth = currMonth.getNext();
					} while (currMonth != currYear.getData().getMonths().getHead());
				}
				currYear = currYear.getNext();
			} while (currYear != Main.years.getHead());
		}

		totalTF.setText(String.valueOf(total));
		maximumTF.setText(String.valueOf(maximum));
		minimumTF.setText(String.valueOf(minimum));

		if (count == 0) {
			statusL.setText("No records found for the given day.");
			return;
		}

		average = total / count;
		averageTF.setText(String.valueOf(average));
	} catch (NumberFormatException e) {
		statusL.setText("Invalid input. Please enter a valid day number.");
	}
}

	public void calculateSpecificStatisticForMonth() {
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setAlignment(Pos.CENTER);

		gp.add(totalL, 0, 0);
		gp.add(totalTF, 1, 0);
		gp.add(maximumL, 0, 1);
		gp.add(maximumTF, 1, 1);
		gp.add(minimumL, 0, 2);
		gp.add(minimumTF, 1, 2);
		gp.add(averageL, 0, 3);
		gp.add(averageTF, 1, 3);

		specificMonthTF.setMaxWidth(200);
		gp.add(specificMonthL, 0, 4);
		gp.add(specificMonthTF, 1, 4);

		setCenter(gp);
		setMargin(gp, new Insets(15));

		statusL.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18;");
		setBottom(statusL);
		setAlignment(statusL, Pos.CENTER);

		gp.add(calculateButton, 2, 4);
		calculateButton.setOnAction(e -> {
			calculateStatisticsForMonth();
		});
	}

	private void calculateStatisticsForMonth() {
		try {
		int specificMonth = Integer.parseInt(specificMonthTF.getText());
		count = 0;
		total = 0.0;
		maximum = Double.MIN_VALUE;
		minimum = Double.MAX_VALUE;

		Node<Year> currYear = Main.years.getHead();
		if (currYear != null) {
			do {
				Node<Month> currMonth = currYear.getData().getMonths().getHead();
				if (currMonth != null) {
					do {
						Month month = currMonth.getData();
						if (specificMonth == month.getMonth()) {
							Node<Day> currentDay = month.getDays().getHead();
							if (currentDay != null) {
								do {
									Day day = currentDay.getData();
									double specificStatistic = day.getRecord().getTotalDailySupplyAvailableInMWs();
									total += specificStatistic;
									maximum = Math.max(maximum, specificStatistic);
									minimum = Math.min(minimum, specificStatistic);
									count++;
									currentDay = currentDay.getNext();
								} while (currentDay != month.getDays().getHead());
							}
						}
						currMonth = currMonth.getNext();
					} while (currMonth != currYear.getData().getMonths().getHead());
				}
				currYear = currYear.getNext();
			} while (currYear != Main.years.getHead());
		}

		totalTF.setText(String.valueOf(total));
		maximumTF.setText(String.valueOf(maximum));
		minimumTF.setText(String.valueOf(minimum));

		if (count == 0) {
			statusL.setText("No records found for the given month.");
			return;
		}

		average = total / count;
		averageTF.setText(String.valueOf(average));
	} catch (NumberFormatException e) {
		statusL.setText("Invalid input. Please enter a valid month number.");
	}

}

	private void calculateStatisticsForYear() {
		try {
		int specificYear = Integer.parseInt(specificYearTF.getText());
		count = 0;
		total = 0.0;
		maximum = Double.MIN_VALUE;
		minimum = Double.MAX_VALUE;

		Node<Year> currYear = Main.years.getHead();
		if (currYear != null) {
			do {
				Year year = currYear.getData();
				if (specificYear == year.getYear()) {
					Node<Month> currMonth = year.getMonths().getHead();
					if (currMonth != null) {
						do {
							Month month = currMonth.getData();
							Node<Day> currentDay = month.getDays().getHead();
							if (currentDay != null) {
								do {
									Day day = currentDay.getData();
									double specificStatistic = day.getRecord().getTotalDailySupplyAvailableInMWs();
									total += specificStatistic;
									maximum = Math.max(maximum, specificStatistic);
									minimum = Math.min(minimum, specificStatistic);
									count++;
									currentDay = currentDay.getNext();
								} while (currentDay != month.getDays().getHead());
							}
							currMonth = currMonth.getNext();
						} while (currMonth != year.getMonths().getHead());
					}
				}
				currYear = currYear.getNext();
			} while (currYear != Main.years.getHead());
		}

		totalTF.setText(String.valueOf(total));
		maximumTF.setText(String.valueOf(maximum));
		minimumTF.setText(String.valueOf(minimum));

		if (count == 0) {
			statusL.setText("No records found for the given year.");
			return;
		}

		average = total / count;
		averageTF.setText(String.valueOf(average));
	} catch (NumberFormatException e) {
		statusL.setText("Invalid input. Please enter a valid year number.");
	}
}

	public void calculateSpecificStatisticForYear() {

		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setAlignment(Pos.CENTER);

		gp.add(totalL, 0, 0);
		gp.add(totalTF, 1, 0);
		gp.add(maximumL, 0, 1);
		gp.add(maximumTF, 1, 1);
		gp.add(minimumL, 0, 2);
		gp.add(minimumTF, 1, 2);
		gp.add(averageL, 0, 3);
		gp.add(averageTF, 1, 3);

		specificYearTF.setMaxWidth(200);
		gp.add(specificYearL, 0, 4);
		gp.add(specificYearTF, 1, 4);

		setCenter(gp);
		setMargin(gp, new Insets(15));

		statusL.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18;");
		setBottom(statusL);
		setAlignment(statusL, Pos.CENTER);

		gp.add(calculateButton, 2, 4);
		calculateButton.setOnAction(e -> {
			calculateStatisticsForYear();
		});
	}

	private void calculateOverallStatistics() {
		count = 0;
		total = 0.0;
		maximum = Double.MIN_VALUE;
		minimum = Double.MAX_VALUE;

		Node<Year> currYear = Main.years.getHead();
		if (currYear != null) {
			do {
				Node<Month> currMonth = currYear.getData().getMonths().getHead();
				if (currMonth != null) {
					do {
						Month month = currMonth.getData();
						Node<Day> currentDay = month.getDays().getHead();
						if (currentDay != null) {
							do {
								Day day = currentDay.getData();
								double israeliLines = day.getRecord().getIsraeliLinesMWs();
								double gazaPowerPlant = day.getRecord().getGazaPowerPlantMWs();
								double egyptianLines = day.getRecord().getEgyptianLinesMWs();
								double totalDailySupplyAvailable = day.getRecord().getTotalDailySupplyAvailableInMWs();
								double overallDemand = day.getRecord().getOverallDemandInMWs();
								double powerCutsHoursDay = day.getRecord().getPowerCutsHoursDay400mg();
								double temperture = day.getRecord().getTemperture();

								totalFortotalDailySupplyAvailable += totalDailySupplyAvailable;
								totaloverallDemand += overallDemand;
								totalpowerCutsHoursDay += powerCutsHoursDay;
								totaltemperture += temperture;

								maximumFortotalDailySupplyAvailable = Math.max(maximumFortotalDailySupplyAvailable,
										totalDailySupplyAvailable);
								maximumoverallDemand = Math.max(maximumoverallDemand, overallDemand);
								maximumpowerCutsHoursDay = Math.max(maximumpowerCutsHoursDay, powerCutsHoursDay);
								maximumtemperture = Math.max(maximumtemperture, temperture);

								maximumIsraeliLines = Math.max(maximumIsraeliLines, israeliLines);
								maximumGazaPowerPlant = Math.max(maximumGazaPowerPlant, gazaPowerPlant);
								maximumEgyptianLines = Math.max(maximumEgyptianLines, egyptianLines);

								minimumFortotalDailySupplyAvailable = Math.min(minimumFortotalDailySupplyAvailable,
										totalDailySupplyAvailable);
								minimumOverallDemand = Math.min(minimumOverallDemand, overallDemand);
								minimumPowerCutsHoursDay = Math.min(minimumPowerCutsHoursDay, powerCutsHoursDay);
								minimumTemperture = Math.min(minimumTemperture, temperture);

								minimumIsraeliLines = Math.min(minimumIsraeliLines, israeliLines);
								minimumGazaPowerPlant = Math.min(minimumGazaPowerPlant, gazaPowerPlant);
								minimumEgyptianLines = Math.min(minimumEgyptianLines, egyptianLines);

								counttotalDailySupplyAvailable++;
								countOverallDemand++;
								countPowerCutsHoursDay++;
								countTemperture++;

								currentDay = currentDay.getNext();
							} while (currentDay != month.getDays().getHead());
						}
						currMonth = currMonth.getNext();
					} while (currMonth != currYear.getData().getMonths().getHead());
				}
				currYear = currYear.getNext();
			} while (currYear != Main.years.getHead());
		}

		TF1.setText(String.valueOf(maximumIsraeliLines));
		TF2.setText(String.valueOf(minimumIsraeliLines));

		TF3.setText(String.valueOf(maximumGazaPowerPlant));
		TF4.setText(String.valueOf(minimumGazaPowerPlant));

		TF5.setText(String.valueOf(maximumEgyptianLines));
		TF6.setText(String.valueOf(minimumEgyptianLines));

		TF7.setText(String.valueOf(totalFortotalDailySupplyAvailable));
		TF8.setText(String.valueOf(maximumFortotalDailySupplyAvailable));
		TF9.setText(String.valueOf(minimumFortotalDailySupplyAvailable));

		TF11.setText(String.valueOf(totaloverallDemand));
		TF12.setText(String.valueOf(maximumoverallDemand));
		TF13.setText(String.valueOf(minimumOverallDemand));

		TF15.setText(String.valueOf(totalpowerCutsHoursDay));
		TF16.setText(String.valueOf(maximumpowerCutsHoursDay));
		TF17.setText(String.valueOf(minimumPowerCutsHoursDay));

		TF19.setText(String.valueOf(totalpowerCutsHoursDay));
		TF20.setText(String.valueOf(maximumpowerCutsHoursDay));
		TF21.setText(String.valueOf(minimumPowerCutsHoursDay));

		averageFortotalDailySupplyAvailable = totalFortotalDailySupplyAvailable / counttotalDailySupplyAvailable;
		averageOverallDemand = totaloverallDemand / countOverallDemand;
		averagePowerCutsHoursDay = totalpowerCutsHoursDay / countPowerCutsHoursDay;
		averageTemperture = totaltemperture / countTemperture;

		TF10.setText(String.valueOf(totaltemperture));
		TF14.setText(String.valueOf(maximumtemperture));
		TF18.setText(String.valueOf(minimumTemperture));
		TF22.setText(String.valueOf(averageTemperture));
		
	}

	public void calculateStatisticsOverall() {
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setAlignment(Pos.CENTER);

		TF1.setMaxWidth(100);
		TF2.setMaxWidth(100);
		TF3.setMaxWidth(100);
		TF4.setMaxWidth(100);
		TF5.setMaxWidth(100);
		TF6.setMaxWidth(100);
		TF7.setMaxWidth(100);
		TF8.setMaxWidth(100);
		TF9.setMaxWidth(100);
		TF10.setMaxWidth(100);
		TF11.setMaxWidth(100);
		TF12.setMaxWidth(100);
		TF13.setMaxWidth(100);
		TF14.setMaxWidth(100);
		TF15.setMaxWidth(100);
		TF16.setMaxWidth(100);
		TF17.setMaxWidth(100);
		TF18.setMaxWidth(100);
		TF19.setMaxWidth(100);
		TF20.setMaxWidth(100);
		TF21.setMaxWidth(100);
		TF22.setMaxWidth(100);

		gp.add(L1, 1, 0);
		gp.add(L2, 2, 0);
		gp.add(L3, 3, 0);

		gp.add(L11, 0, 1);
		gp.add(L13, 0, 2);

		gp.add(TF1, 1, 1);
		gp.add(TF2, 1, 2);
		gp.add(TF3, 2, 1);
		gp.add(TF4, 2, 2);
		gp.add(TF5, 3, 1);
		gp.add(TF6, 3, 2);

		gp.add(L4, 1, 5);
		gp.add(L5, 2, 5);
		gp.add(L6, 3, 5);
		gp.add(L7, 4, 5);

		gp.add(L8, 0, 6);
		gp.add(L10, 0, 7);
		gp.add(L12, 0, 8);
		gp.add(L9, 0, 9);

		gp.add(TF7, 1, 6);
		gp.add(TF8, 1, 7);
		gp.add(TF9, 1, 8);
		gp.add(TF10, 1, 9);

		gp.add(TF11, 2, 6);
		gp.add(TF12, 2, 7);
		gp.add(TF13, 2, 8);
		gp.add(TF14, 2, 9);

		gp.add(TF15, 3, 6);
		gp.add(TF16, 3, 7);
		gp.add(TF17, 3, 8);
		gp.add(TF18, 3, 9);

		gp.add(TF19, 4, 6);
		gp.add(TF20, 4, 7);
		gp.add(TF21, 4, 8);
		gp.add(TF22, 4, 9);

		setCenter(gp);
		setMargin(gp, new Insets(15));
		gp.add(calculateButton, 4, 11);

		statusL.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-size: 18;");
		setBottom(statusL);

		calculateButton.setOnAction(e -> {
			calculateOverallStatistics();
		});
	}
}
