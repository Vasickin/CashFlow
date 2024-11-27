package contract;

import java.util.List;
import model.Expense;

public interface ExpenseContract {

    interface View {
        void displayExpenses(List<Expense> expenses);
        void showMessage(String message);
    }

    interface Presenter {
        void addExpense(Expense expense);
        void loadExpenses();
        void saveExpenses();
    }
}
