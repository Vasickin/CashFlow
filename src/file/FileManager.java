// FileManager.java
package file;

import model.Expense;

import java.util.List;

public interface FileManager {
    boolean saveExpenses(List<Expense> expenses);
    List<Expense> loadExpenses();
}

