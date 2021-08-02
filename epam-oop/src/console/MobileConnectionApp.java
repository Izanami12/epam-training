package console;

import java.util.Arrays;
import java.util.List;

import domain.CallTypes;
import domain.InternetTraffic;
import domain.MinutesInNetwork;
import domain.TariffPlan;

public class MobileConnectionApp {

    public static void main(final String[] args) {
        final MinutesInNetwork inside = new MinutesInNetwork(CallTypes.INSIDE_NETWORK, InternetTraffic.UNLIMITED, null);
        final MinutesInNetwork outside = new MinutesInNetwork(CallTypes.OUTSIDE_NETWORK, InternetTraffic.LIMIT, 200);
        final List<MinutesInNetwork> mobilenetworks1 = Arrays.asList(inside, outside);
        final TariffPlan mobile1 = new TariffPlan(mobilenetworks1);
    }

    public void init() {
        new MinutesInNetwork(CallTypes.INSIDE_NETWORK, InternetTraffic.LIMIT, 0);
    }
}
