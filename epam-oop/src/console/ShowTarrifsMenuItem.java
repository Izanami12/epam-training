package console;

import java.util.Scanner;

import service.ServiceException;

public class ShowTarrifsMenuItem extends MenuItem {
    
    public ShowTarrifsMenuItem() {
        super("Show tariff list");
    }

    @Override
    public boolean doWork(final Scanner scanner) throws ServiceException {

        return false;
    }
    
}
