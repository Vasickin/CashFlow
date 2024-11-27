// StatisticsCalculator.java
package utils;

import model.Expense;
import model.ExpenseCategory;

import java.util.List;
import java.util.Map;

public interface StatisticsCalculator {
    Map<ExpenseCategory, Double> calculate(List<Expense> expenses);
}
