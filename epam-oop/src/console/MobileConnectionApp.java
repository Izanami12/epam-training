package console;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import domain.CallTypes;
import domain.InternetTraffic;
import domain.MinutesInNetwork;
import domain.TariffInternetTraffic;
import domain.TariffPlan;

public class MobileConnectionApp {

    public static void main(final String[] args) {
        final MinutesInNetwork inside = new MinutesInNetwork(CallTypes.INSIDE_NETWORK, InternetTraffic.UNLIMITED, null);
        final MinutesInNetwork outside = new MinutesInNetwork(CallTypes.OUTSIDE_NETWORK, InternetTraffic.LIMIT, 200);
        final List<MinutesInNetwork> minutesInNetwork = Arrays.asList(inside, outside);
        
        final TariffInternetTraffic limited = new TariffInternetTraffic(InternetTraffic.LIMIT, 300);
        final TariffInternetTraffic unlimited = new TariffInternetTraffic(InternetTraffic.UNLIMITED, null);
        final List<TariffInternetTraffic> tariffInternetTraffic = Arrays.asList(limited, unlimited);
        
        final TariffPlan baseMobileTariff = TariffPlan.builder().name("Base Mobile Tariff")
                .subscriptionFee(BigDecimal.valueOf(1500)).minutesInNetwork(minutesInNetwork)
                .tariffInternetTraffic(tariffInternetTraffic).build();
        final List<TariffPlan> list = new ArrayList<>();
        list.add(baseMobileTariff);
        
        final Scanner scanner = new Scanner(System.in);
        /*
         * final Context context = ContextFactory.newInstance(); final Menu menu =
         * context.getMenu(); boolean running = true; (while running) {
         * System.out.println(menu); running = !menu.doWork(scanner);
         * System.out.println("\nPress Enter to continue"); scanner.nextLine(); }
         *
         * System.out.println("bb"); scanner.close();
         */
        System.out.println(scanner.nextLine());
    }

}
