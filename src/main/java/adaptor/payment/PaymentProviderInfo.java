package adaptor.payment;

import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
@Getter
public class PaymentProviderInfo {
    private String name;
    private String email;
    private Integer amount;
    private String phone;

    private PaymentProviderInfo(){

    }

    public static class Builder{
        private String name;
        private String email;
        private Integer amount;
        private String phone;

        private Builder(){

        }

        @Contract(value = " -> new", pure = true)
        public static @NotNull Builder builder(){
            return new Builder();
        }

        public PaymentProviderInfo build(){
               PaymentProviderInfo paymentProviderInfo = new PaymentProviderInfo();
               if(!isValidName(this.name)){
                   throw new RuntimeException(new Exception("name shouldn't be null"));
               }
               if(!isValidAmount(this.amount)){
                   throw new RuntimeException(new Exception("amount transfer should be greater than 0"));
               }

               if(!isValidPhone(this.phone)){
                   throw new RuntimeException("check phone number");
               }
               copy(paymentProviderInfo);

               return paymentProviderInfo;
        }

        private void copy(@NotNull PaymentProviderInfo paymentProviderInfo){
            paymentProviderInfo.amount = this.amount;
            paymentProviderInfo.email = this.email;
            paymentProviderInfo.name  = this.name;
            paymentProviderInfo.phone = this.phone;
        }

        public Boolean isValidPhone(@NotNull String phone){

            if(phone.length() != 10){
                return false;
            }

            for (int i=0;i<10;i++) {
                if(phone.charAt(i)<'0' || phone.charAt(i) > '9'){
                    return false;
                }
                return true;
            }
            return true;
        }

        public Boolean isValidAmount(Integer amount){
            if(amount < 0) return false;
            return true;
        }
        public Boolean isValidName(String name){
            if(name == null)return false;
            return true;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAmount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
    }
}
