package domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class TariffPlan implements Comparable<TariffPlan> {
    private String name;
    private BigDecimal subscriptionFee;
    private String internetTraffic;
    private CallTypes minutesForCalls;
    private int sms;
    private List<MinutesInNetwork> minutesInNetworkList;

    @Override
    public int compareTo(@NonNull final TariffPlan o) {
        final BigDecimal comparableFee = o.getSubscriptionFee();
        return this.subscriptionFee.compareTo(comparableFee);
    }

    public TariffPlan(final List<MinutesInNetwork> minutesInNetworkList) {
        
    }
    
}
