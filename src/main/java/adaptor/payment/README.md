### ADAPTOR DESIGN PATTERN

As the name suggests, it comes into play, when two interfaces are incompatible, but they are dependent.

For example,

If we are fetching data from somewhere, it is xml type, but some users want it in json format, some in xml , some in yaml, some in csv, some in html.
But is it good that we give each a different end point, and duplicate code, simple anwer is no.
So instead we give query at end after endpoint.

And we handle it after fetching data from endpoint.

If we are designing the ecommerce site, where we are handling payment part,
Then we need to accept all banks, so it is actually taken care by companies like RazorPay, PayU, Stripe.

But their method definations are different, so we need to make compatible.

So for that we introduce interface which behaves like adapter between their api and out api. and makes it compatible.


```mermaid
classDiagram
direction BT
class Builder {
  + Builder() 
  - String name
  - Integer amount
  - String phone
  - String email
  - copy(PaymentProviderInfo) void
  + isValidPhone(String) Boolean
  + build() PaymentProviderInfo
  + isValidAmount(Integer) Boolean
  + isValidName(String) Boolean
   String name
   Integer amount
   String email
   String phone
}
class PayUApi {
  + PayUApi() 
  + generateLink() String
  + pay(PayUInfo) void
  + status() PayUStatus
}
class PayUInfo {
  ~ PayUInfo(String, String, Integer) 
  + builder() PayUInfoBuilder
}
class PayUInfoBuilder {
  ~ PayUInfoBuilder() 
  + name(String) PayUInfoBuilder
  + email(String) PayUInfoBuilder
  + amount(Integer) PayUInfoBuilder
  + build() PayUInfo
  + toString() String
}
class PayUPPI {
  + PayUPPI() 
  + payment(PaymentProviderInfo) void
  + checkStatus() PaymentProviderStatus
  + toStatus(PayUStatus) PaymentProviderStatus
  + createLink() String
}
class PayUStatus {
<<enumeration>>
  + PayUStatus() 
  + values() PayUStatus[]
  + valueOf(String) PayUStatus
}
class PaymentProviderInfo {
  - PaymentProviderInfo() 
  - String email
  - String phone
  - Integer amount
  - String name
   String name
   Integer amount
   String email
   String phone
}
class PaymentProviderInterface {
<<Interface>>
  + createLink() String
  + payment(PaymentProviderInfo) void
  + checkStatus() PaymentProviderStatus
}
class PaymentProviderStatus {
<<enumeration>>
  + PaymentProviderStatus() 
  + values() PaymentProviderStatus[]
  + valueOf(String) PaymentProviderStatus
}
class RazorPayPPI {
  + RazorPayPPI() 
  - toStatus(RazorpayStatus) PaymentProviderStatus
  + createLink() String
  + checkStatus() PaymentProviderStatus
  + payment(PaymentProviderInfo) void
}
class RazorpayStatus {
<<enumeration>>
  + RazorpayStatus() 
  + values() RazorpayStatus[]
  + valueOf(String) RazorpayStatus
}
class Razorpayapi {
  + Razorpayapi() 
  + checkStatus() RazorpayStatus
  + makePayment(String, Integer) void
   String link
}

PaymentProviderInfo  -->  Builder 
PayUInfo  -->  PayUInfoBuilder 
PayUPPI  ..>  PaymentProviderInterface 
RazorPayPPI  ..>  PaymentProviderInterface 

```

