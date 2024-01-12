
public class Year implements Comparable<Year> {
	private int year;
	private CircularSinglyLinkedList<Month> months;

	public Year(int year) {
		super();
		this.year = year;
		months = new CircularSinglyLinkedList<Month>();
	}

	public Year(int year, CircularSinglyLinkedList<Month> months) {
		super();
		this.year = year;
		this.months = months;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

	public CircularSinglyLinkedList<Month> getMonths() {
		return months;
	}

	public void setMonths(CircularSinglyLinkedList<Month> months) {
		this.months = months;
	}

	@Override
	public int compareTo(Year o) {
		return Integer.compare(this.year, o.year);
	}

	@Override
	public String toString() {
		return "year= " + year;
	}

}
