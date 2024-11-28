
package repository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Expense;

public class ExpenseManager implements ExpenseRepository {
    private final List<Expense> expenses = new ArrayList<>();
    private final String filePath = "expenses.csv"; // Путь к файлу для сохранения и загрузки

    // Публичный конструктор
    public ExpenseManager() {
        loadExpenses(); // Загружаем расходы при инициализации
    }

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
        // Реализация сохранения в CSV файл (режим добавления)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Если файл пустой, записываем заголовок
            if (new File(filePath).length() == 0) {
                writer.write("Дата, Списание, Стоимость\n");
            }

            // Записываем данные о расходах
            for (Expense expense : expenses) {
                writer.write(expense.getDate() + "," + expense.getDescription() + "," + expense.getAmount() + "\n");
            }

            System.out.println("Расходы загружены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении расходов: " + e.getMessage());
        }
    }

    public void loadExpenses() {
        // Реализация загрузки из CSV файла
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Пропускаем заголовок
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    // Преобразуем строку в объект Expense
                    try {
                        LocalDate date = LocalDate.parse(parts[0]); // Парсим дату в правильном формате
                        String description = parts[1].trim();
                        double amount = Double.parseDouble(parts[2].trim());

                        Expense expense = new Expense(date, description, amount);
                        expenses.add(expense);
                    } catch (Exception e) {
                        System.out.println("Ошибка при анализе строки: " + line + " — " + e.getMessage());
                    }
                }
            }
            System.out.println("Расходы, загруженные из файла.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл расходов не найден. Будет создан новый.");
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке расходов: " + e.getMessage());
        }
    }
}
