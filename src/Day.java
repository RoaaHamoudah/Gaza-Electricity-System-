
public class Day implements Comparable<Day>{
	
	private int day;
	private Electricity record;
	
	public Day(int day, Electricity record) {
		super();
		this.day = day;
		this.record = record;
	}
	
	public Day(int day) {
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Electricity getRecord() {
		return record;
	}

	public void setRecord(Electricity record) {
		this.record = record;
	}

	@Override
	public int compareTo(Day o) {
		return this.day - o.day;
	//	return Integer.compare(this.day, o.day);
	}

	@Override
	public String toString() {
		return "day= " + day + ", record=" + record;
	}

}
