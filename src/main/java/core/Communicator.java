package core;

import java.util.function.Predicate;

public interface Communicator {
    void showNotification(String message);
    String readString(String promt);
    Double readDouble(String promt);
    int readInteger(String promt);
    boolean readBoolean(String promt, Predicate<String> pridicate);
}
