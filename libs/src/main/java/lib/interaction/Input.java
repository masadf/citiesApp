package lib.interaction;

import lib.exceptions.IncorrectCommandException;
import lib.element.City;

import java.util.Scanner;

public abstract class Input {
    private Scanner reader;

    public Input(Scanner reader) {
        this.reader = reader;
    }

    public Scanner getReader() {
        return reader;
    }

    public abstract City readElement();

    public void close(){
        reader.close();
    }

    public Command readCommand() {
        String[] rawLine = getFormatLine();
        if (rawLine.length > 2) {
            throw new IncorrectCommandException("Команда введена некорректно!");
        }
        if (rawLine.length == 2) {
            return new Command(rawLine[0], rawLine[1]);
        }
        return new Command(rawLine[0], null);
    }

    public boolean hasNext() {
        return reader.hasNext();
    }

    public String[] getFormatLine() {
        return reader.nextLine().trim().split(" ");
    }
}
