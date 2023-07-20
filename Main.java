abstract class Bank 
{

    private String bankName;

    Bank(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
    return bankName;
    }
}

public class Main extends Bank {

  Main() {
    super("Axis Bank");
  }

  public static void main(String[] args) {
    Bank bank = new Main();
    System.out.println(bank.getBankName());
  }

}