// ExpenseContract.java
package contract;

import model.Expense;
import model.ExpenseCategory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ExpenseContract {

    interface View {
        void showExpenses(List<Expense> expenses);
        void showStatistics(Map<ExpenseCategory, Double> statistics);
        void showError(String message);
        void showMessage(String message);
    }

    interface Presenter {
        void addExpense(double amount, ExpenseCategory category, LocalDate date, String description);
        void deleteExpenseById(int id);
        void getAllExpenses();
        void getExpensesByCategory(ExpenseCategory category);
        void getExpensesByDate(LocalDate date);
        void showStatistics();
        void saveExpenses();
        void loadExpenses();
    }
}

