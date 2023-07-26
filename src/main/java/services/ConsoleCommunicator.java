package services;

import core.Communicator;
import utils.Consts;

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
        var scanner = new Scanner(System.in);
        System.out.println(promt);
        if(scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        throw new InputMismatchException(Consts.DOUBLE_INCORRECT_PROMT);
    }
    @Override
    public int readInteger(String promt) {
        var scanner = new Scanner(System.in);
        System.out.println(promt);
        if(scanner.hasNextBigInteger()) {
            return scanner.nextInt();
        }
        throw new InputMismatchException(Consts.INTEGER_INCORRECT_PROMT);
    }
    @Override
    public boolean readBoolean(String promt, Predicate<String> pridicate) {
        var scanner = new Scanner(System.in);
        System.out.println(promt);
        var input = scanner.next();
        return pridicate.test(input);
    }
}

