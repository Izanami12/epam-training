package console;

import java.util.Scanner;

import service.ServiceException;

public class ExitMenuItem extends MenuItem {
    
    public ExitMenuItem() {
        super("Exit");
    }
    
    @Override
    public boolean doWork(final Scanner scanner) throws ServiceException {
        System.out.println("Do you really want to exit? (y/n)");
        final String answer = scanner.nextLine();
        switch (answer.toLowerCase()) {
        case "y":
            return true;
        }
        return false;
    }

}
