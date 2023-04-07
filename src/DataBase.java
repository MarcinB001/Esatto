import java.util.*;

public class DataBase {

    private List <Customer> customers = new ArrayList<>();

    public void addCustomer(String firstName, String lastName, String vat, String date, String address){
        customers.add(new Customer(firstName,lastName,vat,date,address));
    }
    public void deleteCustomer(int numberOfCustomer){
        customers.remove(numberOfCustomer -1);
    }

    public Customer getCustomer(int numberOfCustomer){
        return customers.get(numberOfCustomer-1);
    }

    public List <Customer> getList(){
        return customers;
    }

}
