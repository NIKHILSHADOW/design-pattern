package adaptor.payment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RazorPayPPITest {
    PaymentProviderInterface razorPayPPI;
    @BeforeEach
    public void getInstance(){
        razorPayPPI = new RazorPayPPI();
    }

    @Test
    public void createLinkTest(){
        String link = razorPayPPI.createLink();
        Assertions.assertNotNull(link,"link should be not null");
        Assertions.assertTrue(link.equals("Razorpay"));
    }

    @Test
    public void checkStatusTest(){
        PaymentProviderStatus status = razorPayPPI.checkStatus("paymentId");
        Assertions.assertNotNull(status,"status shouldn't be null");
        Assertions.assertEquals(status,PaymentProviderStatus.SUCCESS);
    }

    @Test
    public void mkePaymentTest(){
        PaymentProviderInfo paymentProviderInfo = PaymentProviderInfo.Builder.
                builder().
                setAmount(138388).
                setEmail("r@dkdk.com").
                setName("kdosls").
                setPhone("8383287813").
                build();
        String id = razorPayPPI.payment(paymentProviderInfo);
        Assertions.assertNotNull(id,"payment id shouldn't be null");
        Assertions.assertEquals(id,"paymentId");
    }
}
