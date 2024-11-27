package view;

import contract.ExpenseContract;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import model.Expense;

public class ConsoleView implements ExpenseContract.View {
    private final ExpenseContract.Presenter presenter;

    public ConsoleView(ExpenseContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayExpenses(List<Expense> expenses) {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("1. Добавить расходы");
            System.out.println("2. Показать расходы");
            System.out.println("3. Сохранить и выйти");
            System.out.print("Выберите вариант: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите дату (YYYY-MM-DD): ");
                    String date = scanner.next();
                    System.out.print("Введите описание: ");
                    String description = scanner.next();
                    System.out.print("Введите стоимость: ");
                    double amount = scanner.nextDouble();
                    presenter.addExpense(new Expense(LocalDate.parse(date), description, amount));
                }
                case 2 -> presenter.loadExpenses();
                case 3 -> {
                    presenter.saveExpenses();
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
