package application.visitors.impl;


import application.Service;
import application.repository.InvoiceRepository;
import application.visitors.CountVisitorValidator;

import java.util.Scanner;


public class VisitorCountServiceImpl implements Service {
    private final CountVisitorValidator countVisitorValidator;
    private final InvoiceRepository repository;
    private static final String COUNT_VISITOR_QUESTION = "Введите на скольких человек необходимо разделить счёт?";
    private static final String NOT_VALID_INPUT_COUNT_VISITORS = "Введено не корректное число посетителей";


    public VisitorCountServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
        this.countVisitorValidator = new CountVisitorValidatorImpl();
    }

    @Override
    public void doWork(Scanner scanner) {
        int count_visitors;
        while (true) {
            System.out.println(COUNT_VISITOR_QUESTION);
            if(scanner.hasNextInt()){
                count_visitors = scanner.nextInt();
                if (this.countVisitorValidator.isValid(count_visitors)) {
                    break;
                }
            }
            scanner.next();
            System.out.println(NOT_VALID_INPUT_COUNT_VISITORS);
        }
        this.repository.saveCountVisitors(count_visitors);
    }
}
