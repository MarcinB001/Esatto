import java.util.*;

public class Gui {

    static DataBase dataBase = new DataBase();

    public static void showOptions(){
        System.out.println("1. Add customer");
        System.out.println("2. Delete customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Show list od customers");
        System.out.println("5. Exit");
    }

    public static void addCustomer(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type fist name");
        String firstName = scanner.nextLine();
        System.out.println("Type last name");
        String lastName = scanner.nextLine();
        System.out.println("Type VAT identification number");
        String vat = scanner.nextLine();

        System.out.println("Creation date:");
        System.out.println("Type day");
        Integer day;
        do
        {
            try
            {
                day = scanner.nextInt();
                if(day > 31 || day <=0){
                    day = -1;
                    System.out.println("It must be integer between 1 and 31");
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Integers only, please.");
                day=-1;
                scanner.nextLine();
            }
        }
        while (day == -1);

        System.out.println("Type month");
        Integer month;
        do
        {
            try
            {
                month = scanner.nextInt();
                if(month > 12 || month <=0){
                    month = -1;
                    System.out.println("It must be integer between 1 and 12");
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Integers only, please.");
                month=-1;
                scanner.nextLine();
            }
        }
        while (month == -1);

        System.out.println("Type year");
        Integer year;
        do
        {
            try
            {
                year = scanner.nextInt();
                if(year > new GregorianCalendar().get(Calendar.YEAR) || year <=1990){
                    year = -1;
                    System.out.println("It must be integer between 1990 and current year");
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Integers only, please.");
                year=-1;
                scanner.nextLine();
            }
        }
        while (year == -1);

        System.out.println("Type address");
        Scanner scan = new Scanner(System.in);
        String address = scan.nextLine();

        String date = day + "." +month +"."+year;

        dataBase.addCustomer(firstName,lastName,vat,date,address);

    }

    public static void deleteCustomer(int numberOfCustomer){
        try{
            dataBase.deleteCustomer(numberOfCustomer);
        }catch (IndexOutOfBoundsException e){
            System.out.println("There isn't customer with this number");
        }
    }

    public static int chooseCustomer(){
        System.out.println("Which one?");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }
    public static void editCustomer(int numberOfCustomer){

        Customer customer;
        try{
            customer = dataBase.getCustomer(numberOfCustomer);
        }catch (IndexOutOfBoundsException e){
            System.out.println("There isn't customer with this number");
            return;
        }

        System.out.println("What do you want to edit?");
        System.out.println("\t1. first name");
        System.out.println("\t2. last name");
        System.out.println("\t3. vat");
        System.out.println("\t4. date");
        System.out.println("\t5. address");

        Scanner scan = new Scanner(System.in);



        Integer x = scan.nextInt();
        scan.nextLine();

        switch (x){
            case 1:
                String firstName = scan.nextLine();
                customer.setFirstName(firstName);
                break;
            case 2:
                String lastName = scan.nextLine();
                customer.setLastName(lastName);
                break;
            case 3:
                String vat = scan.nextLine();
                customer.setVat(vat);
                break;
            case 4:
                System.out.println("Creation date:");
                System.out.println("Type day");
                Integer day = scan.nextInt();
                System.out.println("Type month");
                Integer month = scan.nextInt();
                System.out.println("Type year");
                Integer year = scan.nextInt();

                String date = day+"."+month+"."+year;

                customer.setDate(date);

                break;
            case 5:
                String address = scan.nextLine();
                customer.setAddress(address);
                break;
            default:
                System.out.println("Wrong number");
        }



    }

    public static void showCustomers(){

        List<Customer> customers = dataBase.getList();

        System.out.println("List of customers:");

        System.out.println("   first name, last name, vat, creation date, address");

        int i =1;
        for(Customer customer : customers){

            System.out.println(i + ". " + customer);
            i++;
        }
    }

}
