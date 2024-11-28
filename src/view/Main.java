package view;

import presenter.ExpensePresenter;
import repository.ExpenseManager;

public class Main {
    public static void main(String[] args) {
        // Инициализация репозитория
        ExpenseManager repository = new ExpenseManager();

        // Создание экземпляра Presenter
        ExpensePresenter presenter = new ExpensePresenter(repository);

        // Создание экземпляра ConsoleView и передача presenter
        ConsoleView view = new ConsoleView(presenter);

        // Связывание presenter с view
        presenter.setView(view);

        // Запуск программы
        view.start();
    }
}
