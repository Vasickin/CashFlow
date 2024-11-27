package presenter;

import contract.ExpenseContract;
import java.util.List;
import model.Expense;
import repository.ExpenseManager;

public class ExpensePresenter implements ExpenseContract.Presenter {
    private ExpenseContract.View view;
    private final ExpenseManager repository;

    public ExpensePresenter(ExpenseContract.View view, ExpenseManager repository) {
        this.view = view;
        this.repository = repository;
    }

    // Метод для установки view после создания объекта
    public void setView(ExpenseContract.View view) {
        this.view = view;
    }

    @Override
    public void addExpense(Expense expense) {
        repository.addExpense(expense);
        view.showMessage("Expense added successfully!");
    }

    @Override
    public void loadExpenses() {
        List<Expense> expenses = repository.getAllExpenses();
        view.displayExpenses(expenses);
    }

    @Override
    public void saveExpenses() {
        repository.saveExpenses();
        view.showMessage("Expenses saved successfully!");
    }
}
