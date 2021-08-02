package domain;

import lombok.Data;

@Data
public class Customer {
    private String name;
    private String surname;
    private TariffPlan tariffPlan;
}
