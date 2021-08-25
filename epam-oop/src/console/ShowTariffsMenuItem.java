package console;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import domain.TariffPlan;
import service.ServiceException;

public class ShowTariffsMenuItem extends MenuItem {

    public ShowTariffsMenuItem() {
        super("Show tariff list");
    }
    
    @Override
    public boolean doWork(final Scanner scanner) throws ServiceException {
        final Repository repository = Repository.getInstance();
        final List<TariffPlan> tariffs = repository.getTariffPlans().stream()
                .sorted((o1, o2) -> o1.getSubscriptionFee().compareTo(o2.getSubscriptionFee()))
                .collect(Collectors.toList());
        
        if (!tariffs.isEmpty()) {
            System.out.println("List of tariffs:");
            for (final TariffPlan tariffPlan : tariffs) {
                System.out.println(
                        tariffPlan.getName() + " " + tariffPlan.getSubscriptionFee() + " " + tariffPlan.getSms() + " "
                                + tariffPlan.getMinutesInNetwork() + " " + tariffPlan.getTariffInternetTraffic());
            }
        } else {
            System.out.println("No tariffs available");
        }
        return false;
    }
}
