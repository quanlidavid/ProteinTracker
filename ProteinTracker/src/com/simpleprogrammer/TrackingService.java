package com.simpleprogrammer;

import java.util.ArrayList;
import java.util.List;

public class TrackingService {

	private int total;
	private int goal;
	private List<HistoryItem> history = new ArrayList<>();
	private int historyId = 0;

	public void addProtein(int amount) {
		total += amount;
		history.add(new HistoryItem(historyId++, amount, "add", total));
	}

	public void removeProtein(int amount) {
		total -= amount;
		if (total < 0) {
			total = 0;
		}
		history.add(new HistoryItem(historyId++, amount, "substract", total));
	}

	public int getTotal() {
		return total;
	}

	public void setGoal(int value) throws InvalidGoalException {
		if (value<0) {
			throw new InvalidGoalException();
		}
		goal = value;
	}

	public boolean isGoalMet() {
		return total >= goal;
	}

	public List<HistoryItem> getHistory() {
		return history;
	}
}
