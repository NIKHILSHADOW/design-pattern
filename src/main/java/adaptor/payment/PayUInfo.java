package adaptor.payment;

import lombok.Builder;

@Builder
public class PayUInfo {
    private String name;
    private String email;
    private Integer amount;
}
