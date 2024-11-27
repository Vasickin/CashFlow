// ExpenseCategory.java
package model;

public enum ExpenseCategory {
    FOOD,
    TRANSPORT,
    ENTERTAINMENT,
    UTILITIES,
    HEALTH,
    EDUCATION,
    SHOPPING,
    OTHER;

    @Override
    public String toString() {
        // Возвращаем название категории с заглавной буквы для удобства
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}

