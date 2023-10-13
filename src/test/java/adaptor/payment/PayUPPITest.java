package adaptor.payment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PayUPPITest {

    PaymentProviderInterface paymentProviderInterface;
    @BeforeEach
    public void getInstance(){
        paymentProviderInterface = new PayUPPI();
    }

    @Test
    public void createLinkTest(){
        String link = paymentProviderInterface.createLink();
        Assertions.assertNotNull(link);
        Assertions.assertEquals(link,"PayULink");
    }

    @Test
    public void makePaymentTest(){
        PaymentProviderInfo paymentProviderInfo = PaymentProviderInfo.Builder.
                builder().
                setAmount(38838).
                setName("yueudb").
                setPhone("8383838834").
                setEmail("odh@jfkf.com").
                build();
        String id = paymentProviderInterface.payment(paymentProviderInfo);
        Assertions.assertNotNull(id);
        Assertions.assertEquals(id,"payUPaymentID");
    }

    @Test
    public void statusTest(){
        PaymentProviderStatus paymentProviderStatus = paymentProviderInterface.checkStatus("payUPaymentID");
        Assertions.assertNotNull(paymentProviderStatus);
        Assertions.assertTrue(paymentProviderStatus == PaymentProviderStatus.SUCCESS);
    }
}
