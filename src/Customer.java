public class Customer {

    private String firstName;
    private String lastName;
    private String vat;
    private String date;
    private String address;


    public void setFirstName(String _firstName){
        firstName=_firstName;
    }
    public void setLastName(String _lastName){
        lastName=_lastName;
    }
    public void setVat(String _vat){
        vat=_vat;
    }
    public void setDate(String _date){
        date=_date;
    }
    public void setAddress(String _address){
        address=_address;
    }

    public Customer(String _firstName,String _lastName,String _vat,String _date, String _address){
        firstName=_firstName;
        lastName=_lastName;
        vat=_vat;
        date=_date;
        address=_address;
    }

    @Override
    public String toString(){
        return firstName + ", " + lastName + ", " + vat + ", " + date + ", " + address;
    }

}
