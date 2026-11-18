package com.mycompany.mattresssales;

import java.util.Scanner;

public class MattressSales {

    // ==========================================
    // Q.1.3 & Q.1.2: The Interface
    // ==========================================
    interface IProduct {
        int GetTotalProductsSold();
        double GetAverageProductsSold();
        String GetMostPopularProduct();
    }

    // ==========================================
    // Q.1.2: The Product Class
    // ==========================================
    static class Product implements IProduct {
        private final String[] productNames;
        private final int[][] salesData;

        public Product(String[] productNames, int[][] salesData) {
            this.productNames = productNames;
            this.salesData = salesData;
        }

        @Override
        public int GetTotalProductsSold() {
            int total = 0;
            for (int[] row : salesData) {
                for (int sale : row) {
                    total += sale;
                }
            }
            return total;
        }

        @Override
        public double GetAverageProductsSold() {
            int total = GetTotalProductsSold();
            int count = 0;
            for (int[] row : salesData) {
                count += row.length;
            }
            return (double) total / count;
        }

        @Override
        public String GetMostPopularProduct() {
            int maxTotalSales = -1;
            String mostPopular = "";

            for (int i = 0; i < salesData.length; i++) {
                int currentProductTotal = 0;
                for (int j = 0; j < salesData[i].length; j++) {
                    currentProductTotal += salesData[i][j];
                }
                if (currentProductTotal > maxTotalSales) {
                    maxTotalSales = currentProductTotal;
                    mostPopular = productNames[i];
                }
            }
            return mostPopular + " (" + maxTotalSales + ")";
        }
    }

    // ==========================================
    // Q.1.3: The Print Class
    // ==========================================
    static class PrintProduct {
        private final IProduct product;

        public PrintProduct(IProduct product) {
            this.product = product;
        }

        public void printReport() {
            System.out.println("\nPRODUCT SALES REPORT - 2026");
            System.out.println("**************************************************");
            System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());

            double avg = product.GetAverageProductsSold();
            if (avg == (int) avg) {
                System.out.println("AVERAGE PRODUCT SALES: " + (int) avg);
            } else {
                System.out.printf("AVERAGE PRODUCT SALES: %.2f%n", avg);
            }

            System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
        }
    }

    // ==========================================
    // Q.1.1: Main Application
    // ==========================================
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] products = {
                "Cozy Nights Monarch mattress",
                "Restonic Barbados mattress",
                "Sealy Phuket mattress"
            };

            int[][] salesData = new int[3][3];

            for (int i = 0; i < products.length; i++) {
                for (int month = 1; month <= 3; month++) {
                    System.out.print("Enter number of sales for month " + month + " for " + products[i] + ": ");
                    salesData[i][month - 1] = scanner.nextInt();
                }
                System.out.println();
            }

            Product productData = new Product(products, salesData);
            PrintProduct reportPrinter = new PrintProduct(productData);
            reportPrinter.printReport();
        }
    }
}
