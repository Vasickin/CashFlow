// Expense.java
package model;

import java.time.LocalDate;

public class Expense {
    private static int idCounter = 1;
    private final int id;
    private double amount;
    private ExpenseCategory category;
    private LocalDate date;
    private String description;

    public Expense(double amount, ExpenseCategory category, LocalDate date, String description) {
        this.id = idCounter++;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description != null ? description : "";
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Amount: " + amount + ", Category: " + category + 
               ", Date: " + date + ", Description: " + description;
    }
}
