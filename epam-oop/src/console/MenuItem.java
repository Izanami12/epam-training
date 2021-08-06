package console;

import java.util.Scanner;

import service.ServiceException;

public abstract class MenuItem {
    private final String name;
    
    public MenuItem(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract boolean doWork(Scanner scanner) throws ServiceException;
    
}
