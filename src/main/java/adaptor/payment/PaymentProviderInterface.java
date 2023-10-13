package adaptor.payment;

// Adaptor Interface
public interface PaymentProviderInterface {
    public String createLink();
    public String payment(PaymentProviderInfo paymentProviderInfo);
    public PaymentProviderStatus checkStatus(String id);
}
