package console;

import java.util.List;
import java.util.Scanner;

import domain.Customer;
import service.ServiceException;

public class ShowUsersMenuItem extends MenuItem {
    
    public ShowUsersMenuItem() {
        super("show the list of users");
    }
    
    @Override
    public boolean doWork(final Scanner scanner) throws ServiceException {
        final Repository repository = Repository.getInstance();
        final List<Customer> customers = repository.getCustomers();
        int count = customers.size();
        if (!customers.isEmpty()) {
            System.out.println("List of users");
            for (final Customer customer : customers) {
                System.out.println(
                        customer.getName() + " " + customer.getSurname() + " " + customer.getTariffPlan().getName());
            }
            System.out.println("Count of users is: " + count);
        } else {
            System.out.println("No users available");
        }
        return false;
    }
    
}
