package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TariffInternetTraffic {
    private InternetTraffic internetTraffic;
    private Integer count;
}
