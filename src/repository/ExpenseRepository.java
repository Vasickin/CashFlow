// ExpenseRepository.java
package repository;

import model.Expense;
import model.ExpenseCategory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ExpenseRepository {
    void addExpense(Expense expense);
    void deleteExpense(int id);
    List<Expense> getAllExpenses();
    List<Expense> getExpensesByCategory(ExpenseCategory category);
    List<Expense> getExpensesByDate(LocalDate date);
    Map<ExpenseCategory, Double> calculateStatistics();
}
