package repository;

import model.Expense;

import java.util.List;

public interface ExpenseRepository {
    void addExpense(Expense expense);
    List<Expense> getAllExpenses();
    void saveExpenses();
}
