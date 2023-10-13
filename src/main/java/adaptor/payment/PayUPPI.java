package adaptor.payment;

import adaptor.payment.external.payU.PayUApi;
import adaptor.payment.external.payU.PayUInfo;
import adaptor.payment.external.payU.PayUStatus;
import org.jetbrains.annotations.NotNull;

// adaptee Concrete Class
public class PayUPPI implements PaymentProviderInterface{

    private PayUApi payUApi = new PayUApi();
    @Override
    public String createLink() {
        return payUApi.generateLink();
    }

    @Override
    public String payment(@NotNull PaymentProviderInfo paymentProviderInfo) {
        PayUInfo payUInfo = PayUInfo.
                builder().
                name(paymentProviderInfo.getName()).
                email(paymentProviderInfo.getEmail()).
                amount(paymentProviderInfo.getAmount()).
                build();
        return payUApi.pay(payUInfo);
    }

    @Override
    public PaymentProviderStatus checkStatus(String id) {
        return toStatus(payUApi.status(id));
    }
    public PaymentProviderStatus toStatus(PayUStatus payUStatus){
        if(payUStatus == PayUStatus.PAYU_FAIL){
            return PaymentProviderStatus.FAIL;
        }
        return PaymentProviderStatus.SUCCESS;
    }
}
