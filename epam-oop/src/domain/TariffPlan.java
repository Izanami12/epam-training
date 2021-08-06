package domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class TariffPlan implements Comparable<TariffPlan> {
    private String name;
    private BigDecimal subscriptionFee;
    private int sms;
    private List<MinutesInNetwork> minutesInNetwork;
    private List<TariffInternetTraffic> tariffInternetTraffic;
    
    @Override
    public int compareTo(@NonNull final TariffPlan o) {
        final BigDecimal comparableFee = o.getSubscriptionFee();
        return this.subscriptionFee.compareTo(comparableFee);
    }
    
    public TariffPlan(final List<MinutesInNetwork> minutesInNetworkList) {

    }

}
