/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.util.Scanner;
import java.util.ArrayList;

public class SalesAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesData salesData = new SalesData();
        SalesFileHandler fileHandler = new SalesFileHandler();

        while (true) {
            System.out.println("\n--- Sales Analysis Tool ---");
            System.out.println("1. Add Sales Data");
            System.out.println("2. Calculate Max Sales");
            System.out.println("3. Calculate Min Sales");
            System.out.println("4. Save Sales Data to File");
            System.out.println("5. Load Sales Data from File");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addSalesData(salesData, scanner);
                case 2 -> System.out.println("Max Sales: $" + salesData.calculateMaxSales());
                case 3 -> System.out.println("Min Sales: $" + salesData.calculateMinSales());
                case 4 -> saveSalesData(fileHandler, salesData, scanner);
                case 5 -> loadSalesData(fileHandler, salesData, scanner);
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSalesData(SalesData salesData, Scanner scanner) {
        try {
            System.out.print("Enter sales amount: ");
            double amount = scanner.nextDouble();
            salesData.addSales(amount);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid sales amount.");
            scanner.next(); // Clear the buffer
        }
    }

    private static void saveSalesData(SalesFileHandler fileHandler, SalesData salesData, Scanner scanner) {
        System.out.print("Enter file name to save: ");
        String fileName = scanner.next();
        fileHandler.saveSalesData(salesData, fileName);
    }

    private static void loadSalesData(SalesFileHandler fileHandler, SalesData salesData, Scanner scanner) {
        System.out.print("Enter file name to load: ");
        String fileName = scanner.next();
        fileHandler.loadSalesData(salesData, fileName);
    }
    

class SalesData {
    private final ArrayList<Double> sales;

    public SalesData() {
        this.sales = new ArrayList<>();
    }

    public void addSales(double amount) {
        sales.add(amount);
    }

    public double calculateMaxSales() {
        double maxSales = Double.MIN_VALUE;
        for (double sale : sales) {
            if (sale > maxSales) {
                maxSales = sale;
            }
        }
        return maxSales;
    }

    public double calculateMinSales() {
        double minSales = Double.MAX_VALUE;
        for (double sale : sales) {
            if (sale < minSales) {
                minSales = sale;
            }
        }
        return minSales;
    }

    public ArrayList<Double> getSales() {
        return sales;
    }
}
class SalesFileHandler {

    public void saveSalesData(SalesData salesData, String fileName) {
        // Mock implementation for file handling (since java.io is not allowed)
        System.out.println("Sales data saved to " + fileName);
    }

    public void loadSalesData(SalesData salesData, String fileName) {
        // Mock implementation for file handling (since java.io is not allowed)
        System.out.println("Sales data loaded from " + fileName);
    }
}

}

    