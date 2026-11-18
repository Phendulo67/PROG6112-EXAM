/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mattresssales;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
import org.junit.jupiter.api.Test;

public class ProductTest {

@Test
public void GetTotalProductsSales_WithValidData_ReturnsCorrectValue() {
String[] names = {"Product A", "Product B", "Product C"};
int[][] testData = {
{25, 18, 20}, // Total: 63
{15, 10, 12}, // Total: 37
{18, 15, 20} // Total: 53
}; // Grand Total = 153
Product product = new Product(names, testData);

int actualTotal = product.GetTotalProductsSold();
assertEquals(153, actualTotal, "The total products sold should be 153.");
}

@Test
public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
String[] names = {"Product A", "Product B", "Product C"};
int[][] testData = {
{25, 18, 20},
{15, 10, 12},
{18, 15, 20}
}
