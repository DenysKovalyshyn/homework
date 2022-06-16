package Lesson17;

public class Main extends Module{

    public static void main(String[] args) {
        Module module = new Module();

        try{
            module.processPayment(100, "USD", "12345");
            System.out.println("transaction #trx_4knfsf4gs412355 is completed successfully");
        } catch (InvalidPaymentCurrencyException e) {
            System.out.println("Selected currency is not allowed. Please select one of the followed currencies: USD, EUR, JPY, CHF");
        } catch (InvalidPaymentAmountException e) {
            System.out.println("Selected amount is not allowed. Please try amount bigger than 0");
        } catch (BankProcessingFailedException e) {
            System.out.println("Internal system error. Please try again");

        }
    }
}
