package console;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import service.ServiceException;

public class Menu {
    
    private final Map<Integer, MenuItem> items = new LinkedHashMap<>();

    public void add(final int number, final MenuItem item) {
        items.put(number, item);
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Menu:");
        for (final Map.Entry<Integer, MenuItem> entry : items.entrySet()) {
            builder.append("    ").append(entry.getKey()).append(":").append(entry.getValue().getName()).append(".\n");
        }
        return builder.toString();
    }
    
    public boolean doWork(final Scanner scanner) {
        System.out.println("> ");
        try {
            final Integer menuItemNumber = Integer.valueOf(scanner.nextLine());
            final MenuItem item = items.get(menuItemNumber);
            if (item == null) {
                throw new IllegalArgumentException();
            }
            return item.doWork(scanner);
        } catch (final NumberFormatException exception) {
            System.out.println("Invalid menu item number. Enter an integer menu item number.");
        } catch (final IllegalArgumentException exception) {
            System.out.println("Invalid menu item number. You must enter the existing number of the menu item.");
        } catch (final ServiceException exception) {
            System.out.println("Data processing error");
        }
        return false;
    }
}
