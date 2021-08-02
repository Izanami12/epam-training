package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MinutesInNetwork {

    private final CallTypes network;
    private final InternetTraffic internetTraffic;
    private final Integer count;
    
}
