package console;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.CallTypes;
import domain.Customer;
import domain.InternetTraffic;
import domain.MinutesInNetwork;
import domain.TariffInternetTraffic;
import domain.TariffPlan;

public class Repository {

    private static Repository instance = new Repository();

    private final List<TariffPlan> tariffPlans = new ArrayList<>();

    private final List<Customer> customers = new ArrayList<>();
    
    private Repository() {
        createTariffs();
        createCustomers();
    }

    private void createTariffs() {
        final MinutesInNetwork insideBaseMobile = new MinutesInNetwork(CallTypes.INSIDE_NETWORK,
                InternetTraffic.UNLIMITED, null);
        final MinutesInNetwork outsideBaseMobile = new MinutesInNetwork(CallTypes.OUTSIDE_NETWORK,
                InternetTraffic.LIMIT, 200);
        final List<MinutesInNetwork> minutesInNetworkBaseMobile = Arrays.asList(insideBaseMobile, outsideBaseMobile);

        final TariffInternetTraffic limitedBaseMobile = new TariffInternetTraffic(InternetTraffic.LIMIT, 300);
        final TariffInternetTraffic unlimitedBaseMobile = new TariffInternetTraffic(InternetTraffic.UNLIMITED, null);
        final List<TariffInternetTraffic> tariffInternetTrafficBaseMobile = Arrays.asList(limitedBaseMobile,
                unlimitedBaseMobile);

        final TariffPlan baseMobileTariff = TariffPlan.builder().name("Base Mobile Tariff")
                .subscriptionFee(BigDecimal.valueOf(1500)).minutesInNetwork(minutesInNetworkBaseMobile)
                .tariffInternetTraffic(tariffInternetTrafficBaseMobile).build();
        tariffPlans.add(baseMobileTariff);

        final MinutesInNetwork insideAdvancedMobile = new MinutesInNetwork(CallTypes.INSIDE_NETWORK,
                InternetTraffic.UNLIMITED, null);
        final MinutesInNetwork outsideAdvancedMobile = new MinutesInNetwork(CallTypes.OUTSIDE_NETWORK,
                InternetTraffic.LIMIT, 200);
        final List<MinutesInNetwork> minutesInNetworkAdvancedMobile = Arrays.asList(insideAdvancedMobile,
                outsideAdvancedMobile);

        final TariffInternetTraffic limitedAdvancedMobile = new TariffInternetTraffic(InternetTraffic.LIMIT, 300);
        final TariffInternetTraffic unlimitedAdvancedMobile = new TariffInternetTraffic(InternetTraffic.UNLIMITED,
                null);
        final List<TariffInternetTraffic> tariffInternetTrafficAdvancedMobile = Arrays.asList(limitedAdvancedMobile,
                unlimitedAdvancedMobile);

        final TariffPlan advancedMobileTariff = TariffPlan.builder().name("Advanced Mobile Tariff")
                .subscriptionFee(BigDecimal.valueOf(500)).minutesInNetwork(minutesInNetworkAdvancedMobile)
                .tariffInternetTraffic(tariffInternetTrafficAdvancedMobile).build();
        tariffPlans.add(advancedMobileTariff);

    }

    private void createCustomers() {
        final Customer customer = new Customer();
        customer.setName("Jeka");
        customer.setSurname("Firsov");
        customer.setTariffPlan(tariffPlans.get(1));
        customers.add(customer);
        final Customer secondCustomer = new Customer();
        secondCustomer.setName("Vlad");
        secondCustomer.setSurname("Kholod");
        secondCustomer.setTariffPlan(tariffPlans.get(0));
        customers.add(secondCustomer);
    }

    public List<TariffPlan> getTariffPlans() {
        return tariffPlans;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public static Repository getInstance() {
        return Repository.instance;
    }

}
