package adaptor.payment;

public class PayUApi {
    public String generateLink() {
        return "PayULink";
    }

    public String pay(PayUInfo payUInfo) {
        System.out.println("payment in progress");
        return "payUPaymentID";
    }

    public PayUStatus status(String id){
        if(id.equals("payUPaymentID")) {
            return PayUStatus.PAYU_SUCCESS;
        }
        return PayUStatus.PAYU_FAIL;
    }
}
