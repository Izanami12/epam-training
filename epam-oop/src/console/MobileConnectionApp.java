package console;

import java.util.Scanner;

import ioc.Context;
import ioc.ContextFactory;

public class MobileConnectionApp {

    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final Context context = ContextFactory.newInstance();
        final Menu menu = context.getMenu();
        boolean running = true;
        while (running) {
            System.out.println(menu);
            running = !menu.doWork(scanner);
            System.out.println("\nPress Enter to continue");
            scanner.nextLine();
        }

        System.out.println("bb");
        scanner.close();

        System.out.println(scanner.nextLine());
    }

}
