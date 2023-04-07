import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer x;

        while (true){

            Gui.showOptions();
            do
            {
                try
                {
                    x = scanner.nextInt();
                }
                catch (InputMismatchException exception)
                {
                    System.out.println("Integers only, please.");
                    Gui.showOptions();
                    x=-1;
                    scanner.nextLine();
                }
            }
            while (x == -1);


            switch (x){
                case 1:
                    Gui.addCustomer();
                    break;
                case 2:
                    Gui.deleteCustomer(Gui.chooseCustomer());
                    break;
                case 3:
                    Gui.editCustomer(Gui.chooseCustomer());
                    break;
                case 4:
                    Gui.showCustomers();
                    System.out.println("Press enter to continue..");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong number");
            }

        }

    }
}