package services;

import core.Communicator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleCommunicator implements Communicator {
    @Override
    public void showNotification(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String promt) {
        System.out.println(promt);
        var scanner = new Scanner(System.in);
        return scanner.next();
    }

    @Override
    public Double readDouble(String promt) {
        try {
            var scanner = new Scanner(System.in);
            System.out.println(promt);
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            return null;
        }
    }

    @Override
    public int readInteger(String promt) {
        var scanner = new Scanner(System.in);
        System.out.println(promt);
        return scanner.nextInt();
    }

    @Override
    public boolean readBoolean(String promt, Predicate<String> pridicate) {
        var scanner = new Scanner(System.in);
        System.out.println(promt);
        var input = scanner.next();
        return pridicate.test(input);
    }
}

