import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Electricity implements Comparable<Electricity>{

	private Date date;
	private double israeliLinesMWs;
	private double gazaPowerPlantMWs;
	private double egyptianLinesMWs;
	private double totalDailySupplyAvailableInMWs;
	private double overallDemandInMWs;
	private double powerCutsHoursDay400mg;
	private double temperture;
	private String formattedDate;

	
	
	public Electricity(String date ,double israeliLinesMWs, double gazaPowerPlantMWs, double egyptianLinesMWs,
			double totalDailySupplyAvailableInMWs, double overallDemandInMWs, double powerCutsHoursDay400mg,
			double temperture) {
		this.israeliLinesMWs = israeliLinesMWs;
		this.gazaPowerPlantMWs = gazaPowerPlantMWs;
		this.egyptianLinesMWs = egyptianLinesMWs;
		this.totalDailySupplyAvailableInMWs = totalDailySupplyAvailableInMWs;
		this.overallDemandInMWs = overallDemandInMWs;
		this.powerCutsHoursDay400mg = powerCutsHoursDay400mg;
		this.temperture = temperture;
		setDate(date);
	}

	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public void setDate(String date) {
		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			this.date = dFormat.parse(date);
			this.formattedDate = dFormat.format(this.date);
		} catch (ParseException e) {
			System.out.println("Invalid date: " + date);
		}
	}
	
	public double getIsraeliLinesMWs() {
		return israeliLinesMWs;
	}


	public void setIsraeliLinesMWs(double israeliLinesMWs) {
		this.israeliLinesMWs = israeliLinesMWs;
	}


	public double getGazaPowerPlantMWs() {
		return gazaPowerPlantMWs;
	}


	public void setGazaPowerPlantMWs(double gazaPowerPlantMWs) {
		this.gazaPowerPlantMWs = gazaPowerPlantMWs;
	}


	public double getEgyptianLinesMWs() {
		return egyptianLinesMWs;
	}


	public void setEgyptianLinesMWs(double egyptianLinesMWs) {
		this.egyptianLinesMWs = egyptianLinesMWs;
	}


	public double getTotalDailySupplyAvailableInMWs() {
		return totalDailySupplyAvailableInMWs;
	}


	public void setTotalDailySupplyAvailableInMWs(double totalDailySupplyAvailableInMWs) {
		this.totalDailySupplyAvailableInMWs = totalDailySupplyAvailableInMWs;
	}


	public double getOverallDemandInMWs() {
		return overallDemandInMWs;
	}


	public void setOverallDemandInMWs(double overallDemandInMWs) {
		this.overallDemandInMWs = overallDemandInMWs;
	}


	public double getPowerCutsHoursDay400mg() {
		return powerCutsHoursDay400mg;
	}


	public void setPowerCutsHoursDay400mg(double powerCutsHoursDay400mg) {
		this.powerCutsHoursDay400mg = powerCutsHoursDay400mg;
	}


	public double getTemperture() {
		return temperture;
	}


	public void setTemperture(double temperture) {
		this.temperture = temperture;
	}


	public String getFormattedDate() {
		return formattedDate;
	}


	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}


	@Override
	public int compareTo(Electricity o) {
		return this.date.compareTo(o.date);
	}

	@Override
	public String toString() {
		return  formattedDate + " , " 
	            +israeliLinesMWs + " , "
				+ gazaPowerPlantMWs + " , " 
				+ totalDailySupplyAvailableInMWs + " , " 
				+ overallDemandInMWs+ " , " 
				+ powerCutsHoursDay400mg + " , " 
				+ temperture ;
	}
	
}
