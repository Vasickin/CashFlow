
package view;

import contract.ExpenseContract;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
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
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        try {
                            System.out.print("Введите дату (YYYY-MM-DD): ");
                            String dateInput = scanner.next();
                            LocalDate date = LocalDate.parse(dateInput); // Преобразование строки в дату

                            System.out.print("Введите описание: ");
                            String description = scanner.next();

                            System.out.print("Введите стоимость: ");
                            if (!scanner.hasNextDouble()) {
                                throw new NumberFormatException("Стоимость должна быть числом.");
                            }
                            double amount = scanner.nextDouble(); // Преобразование строки в число

                            presenter.addExpense(new Expense(date, description, amount));
                            System.out.println("Расходы успешно добавлены!");
                        } catch (DateTimeParseException e) {
                            System.out.println("Ошибка: неверный формат даты. Используйте формат YYYY-MM-DD.");
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                            scanner.next(); // Очистка некорректного ввода
                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    }
                    case 2 -> presenter.loadExpenses();
                    case 3 -> {
                        presenter.saveExpenses();
                        return;
                    }
                    default -> System.out.println("Неверный вариант. Пожалуйста, выберите 1, 2 или 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число для выбора варианта.");
                scanner.next(); // Очистка некорректного ввода
            }
        }
    }

}
