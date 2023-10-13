package adaptor.payment;

import adaptor.payment.external.razorpay.RazorpayStatus;
import adaptor.payment.external.razorpay.Razorpayapi;
import org.jetbrains.annotations.NotNull;

// Adaptee
public class RazorPayPPI implements PaymentProviderInterface{

    private Razorpayapi razorpayapi = new Razorpayapi();

    @Override
    public String createLink() {
        return razorpayapi.getLink();
    }

    @Override
    public String payment(@NotNull PaymentProviderInfo paymentProviderInfo) {
        return razorpayapi.makePayment(paymentProviderInfo.getName(),paymentProviderInfo.getAmount());
    }

    @Override
    public PaymentProviderStatus checkStatus(String id) {
        return toStatus(razorpayapi.checkStatus(id));
    }

    private PaymentProviderStatus toStatus(RazorpayStatus razorpayStatus) {
        if (razorpayStatus == RazorpayStatus.RAZOR_SUCESS){
            return PaymentProviderStatus.SUCCESS;
        }
        return PaymentProviderStatus.FAIL;
    }
}
