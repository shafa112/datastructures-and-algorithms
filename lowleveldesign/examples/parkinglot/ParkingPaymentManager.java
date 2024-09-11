package examples.parkinglot;

public class ParkingPaymentManager {

    double getParkingTotal(ParkingTicket ticket) {
        return 0.0;
    }

    void markPaymentComplete(String ticketId) {
    }

    void pay(String ticketId, double amount, PaymentData paymentData) {
        PaymentHandler paymentHandler = getPaymentHandler(paymentData.paymentType);
        paymentHandler.pay(paymentData, amount);
    }

    private PaymentHandler getPaymentHandler(PaymentType paymentType) {
        return null;
    }

}

enum PaymentType {
    CARD, UPI, FAST_TAG, CASH
}

abstract class PaymentData {
    PaymentType paymentType;
}

class CardData extends PaymentData {
}

class UpiData extends PaymentData {

}

class FastTagData extends PaymentData {

}

interface PaymentHandler {
  void pay(PaymentData paymentData, double amount);
}

class CardPaymentHandler implements PaymentHandler {
    public void pay(PaymentData paymentData, double amount) {
        CardData cardData = (CardData) paymentData;
        // deduct amount from card
    }
}

