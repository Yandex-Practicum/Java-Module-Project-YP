package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public List<Product> addProductsToTheCalculator() {
        List<Product> productList = new ArrayList<>();

        do {
            Product product = new Product();
            product.setProductName(addNameProduct());
            product.setPrice(addPriceProduct());
            productList.add(product);
            System.out.printf("Товар %s, с ценой %.2f успешно добавлен в корзину", product.getProductName(), product.getPrice());
        } while (!finishAddingProducts());
        return productList;
    }

    @Override
    public String addNameProduct() {
        System.out.println("Введите название товара");
        return SCANNER.next().trim();
    }

    @Override
    public double addPriceProduct() {
        while (true) {
            System.out.println("Введите стоимость товара. Стоимость должна быть в формате рубли.копейки, например 10.45 или 11.40.");
            if (SCANNER.hasNextDouble()) {
                double priceProduct = SCANNER.nextDouble();
                if (priceProduct < 0) {
                    System.out.println("Стоимость не может быть меньше нуля");
                    continue;
                }
                return priceProduct;
            } else {
                System.out.println("Ошибка: введите число.");
                SCANNER.next();
            }
        }
    }

    @Override
    public boolean finishAddingProducts() {
        System.out.println("\nХотите добавить еще один товар? Если нет, введите \"Завершить\"");
        String addAnotherProduct = SCANNER.next();
        return addAnotherProduct.equalsIgnoreCase("Завершить");
    }

}
