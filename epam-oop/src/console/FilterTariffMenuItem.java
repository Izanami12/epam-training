package console;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domain.TariffPlan;
import service.ServiceException;

public class FilterTariffMenuItem extends MenuItem {

    public FilterTariffMenuItem() {
        super("Filter tariffs by subscription fee");
    }

    @Override
    public boolean doWork(final Scanner scanner) throws ServiceException {
        try {
            System.out.println("Enter the minimum subscription fee:");
            final Integer minimum = Integer.valueOf(scanner.nextLine());
            System.out.println("Enter the maximum subscription fee:");
            final Integer maximum = Integer.valueOf(scanner.nextLine());
            final List<TariffPlan> filteredTariffs = Repository.getInstance().getTariffPlans().stream().filter(
                    (p) -> p.getSubscriptionFee().intValue() >= minimum && p.getSubscriptionFee().intValue() <= maximum)
                    .collect(Collectors.toList());
            if (!filteredTariffs.isEmpty()) {
                System.out.println("Tariff plans corresponding to the specified range:");
                for (final TariffPlan tariffPlan : filteredTariffs) {
                    System.out.println(tariffPlan.getName() + " " + tariffPlan.getSubscriptionFee() + " "
                            + tariffPlan.getSms() + " " + tariffPlan.getMinutesInNetwork() + " "
                            + tariffPlan.getTariffInternetTraffic());
                }
            } else {
                System.out.println("There are no taiff plans found in the specified range");
            }
        } catch (final NumberFormatException exception) {
            System.out.println("Entered value must be number");
        }

        return false;
    }
    
}
