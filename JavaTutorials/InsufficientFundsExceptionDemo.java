package JavaTutorials;

public class InsufficientFundsExceptionDemo {
    public static void main(String [] args) {
        InsufficientFundsExceptionChecking c = new InsufficientFundsExceptionChecking(101);
        System.out.println("Depositing $500...");
        c.deposit(500.00);

        try {
            System.out.println("\nWithdrawing $100...");
            c.withdraw(100.00);
            System.out.println("\nWithdrawing $600...");
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short $" + e.getAmount());
            e.printStackTrace();
        }
    }
}
