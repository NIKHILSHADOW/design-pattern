package adaptor.payment.external.razorpay;

import org.jetbrains.annotations.NotNull;

public class Razorpayapi {
    public String getLink(){
        return "Razorpay";
    }
    public String makePayment(String name, Integer amount) {
        System.out.println("Payment of amount "+amount+" with name "+name+" im progresss");
        return "paymentId";
    }
    public RazorpayStatus checkStatus(@NotNull String id){
        if (id.equals("paymentId")) {
            return RazorpayStatus.RAZOR_SUCESS;
        }
        return RazorpayStatus.RAZOR_FAILURE;
    }
}
