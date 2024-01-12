
public class Month implements Comparable<Month> {
	private int month;
	private CircularSinglyLinkedList<Day> days;

	public Month(int month) {
		super();
		this.month = month;
		days = new CircularSinglyLinkedList<Day>();
	}

	public Month(int month, CircularSinglyLinkedList<Day> days) {
		super();
		this.month = month;
		this.days = days;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public CircularSinglyLinkedList<Day> getDays() {
		return days;
	}

	public void setDays(CircularSinglyLinkedList<Day> days) {
		this.days = days;
	}

	@Override
	public int compareTo(Month o) {
		return this.month - o.month;
	}

	@Override
	public String toString() {
		return "month= " + month;
	}

}
