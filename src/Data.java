import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//Base class Data
public class Data {
    String name;
    int number;
    String address;
    String city;
    String state;
    int zip_code;
    List<Service> services;


    //Default constructor
    //You can create the default object to test you code
    public Data(){
        name="Default name";
        number=123456789;
        address="Default address";
        city="Default city";
        state="Default state";
        zip_code=123456;
        services = new ArrayList<>();
    }
    //Load data from the external file except services list
    public Data(Scanner fileInput){
        name = fileInput.nextLine();
        number = fileInput.nextInt();
        fileInput.nextLine();
        address = fileInput.nextLine();
        city = fileInput.nextLine();
        state = fileInput.nextLine();
        zip_code = fileInput.nextInt();
        fileInput.nextLine();
        services = new ArrayList<>();
    }
    //Print All function
    public void printAll(){
        System.out.println(name);
        System.out.println(number);
        System.out.println(address);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zip_code);
        System.out.println();
    }

    //To compare Match or not
    public boolean isMatch(Data other) {
        return this.number == other.number;
    }

    public boolean isMatch(int other){
        return this.number==other;
    }

    public boolean isMatch(String name) {
        return this.name.equals(name);

    }
    public void setData(Scanner userInput){
        //米哥 让用户输入 然后把所有数据重新设一遍 除了 （services list 重的data）
    }

    public void editInfor(Scanner userInput){
//米哥 让用户输入 然后把修改数据 除了 （services list 重的data）
    }
}
