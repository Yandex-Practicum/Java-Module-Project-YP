package alexey.gritsenko.application.visitors.impl;


import alexey.gritsenko.application.Service;
import alexey.gritsenko.application.repository.InvoiceRepository;
import alexey.gritsenko.application.visitors.CountVisitorValidator;

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
        int countVisitors;
        while (true) {
            System.out.println(COUNT_VISITOR_QUESTION);
            if(scanner.hasNextInt()){
                countVisitors = scanner.nextInt();
                if (this.countVisitorValidator.isValid(countVisitors)) {
                    break;
                }
            }else {
                scanner.next();
            }
            System.out.println(NOT_VALID_INPUT_COUNT_VISITORS);
        }
        this.repository.saveCountVisitors(countVisitors);
    }
}
