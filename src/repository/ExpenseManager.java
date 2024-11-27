package repository;

import model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager implements ExpenseRepository {
    private final List<Expense> expenses = new ArrayList<>();

    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

    @Override
    public void saveExpenses() {
        // Реализация сохранения в файл позже
    }
}
