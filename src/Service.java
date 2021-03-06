import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;

public class Service {
    Date occurred_date; //Date and time service occurred
    Date received_in_system; //Date and time service received into system
    String member_name;
    String provider_name;
    String service_name;
    String comments; //OPTIONAL
    int member_id;
    int provider_id;
    int service_id;
    double fee;

//Default constructor
   public Service(){
       String default_data="2020-02-02";
       try {
            occurred_date=new SimpleDateFormat("yyyy-MM-dd").parse(default_data);
           received_in_system =new SimpleDateFormat("yyyy-MM-dd").parse(default_data);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       member_name="Default member name";
       provider_name="Default provider name";
       service_name="Default service name";
       comments="Default comments";
       member_id=123456789;
       provider_id=987654321;
       service_id=123456;
       fee=99.99;
   }

    //constructor load file
    public Service(Scanner fileInput){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            occurred_date = formatter.parse(fileInput.nextLine());
            received_in_system = formatter.parse(fileInput.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        member_name = fileInput.nextLine();
        provider_name = fileInput.nextLine();
        service_name = fileInput.nextLine();
        comments = fileInput.nextLine();
        member_id = fileInput.nextInt();
        fileInput.nextLine();
        provider_id=fileInput.nextInt();
        fileInput.nextLine();
        service_id = fileInput.nextInt();
        fileInput.nextLine();
        fee = fileInput.nextDouble();
        fileInput.nextLine();
    }

    public Service(providerData inputProvider,memberData inputMember, Scanner userInput) {
       try{
            System.out.println("Enter Today's date in dd-MM-yyyy format");
            String tempDate = userInput.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            occurred_date = sdf.parse(tempDate);
       } catch (ParseException e) {
           System.out.println("Incorrect date format! Aborting");
       }
       //SimpleDateFormat sdf2 = new SimpleDateFormat("dd-mm-yyyy");
       received_in_system = new Date();
       member_name = inputMember.name;
       provider_name = inputProvider.name;
       System.out.println("Enter a service name:");
       service_name = userInput.nextLine();
       System.out.println("Enter comments:");
       comments = userInput.nextLine();
       member_id = inputMember.number;
       provider_id = inputProvider.number;
       System.out.println("Enter service ID:");
       service_id = userInput.nextInt();
       userInput.nextLine();
       System.out.println("Enter fee:");
       fee = userInput.nextDouble();
       userInput.nextLine();
    }

    //printAll information
    public void printAll(){
        System.out.println(occurred_date);
        System.out.println(received_in_system);
        System.out.println(member_name);
        System.out.println(provider_name);
        System.out.println(service_name);
        System.out.println(comments);
        System.out.println(member_id);
        System.out.println(provider_id);
        System.out.println(service_id);
        System.out.println(fee);
        System.out.println();
    }

   //Parts of service information for members
    public void printPart(){
        System.out.println(occurred_date);
        System.out.println(provider_name);
        System.out.println(service_name);
    }

    public boolean isMatch(Service other){
      return this.service_id==other.service_id;
    }

    public boolean isMathch(int service_id){
       return this.service_id==service_id;
    }

    public boolean isMatch(String service_name){
        return this.service_name.equals(service_name);
    }

    public void setService(Scanner userInput){
       //米哥
        //让用户输入 把所有数据重新设一遍
        if(userInput.hasNextLine()) {
            try {
                this.occurred_date = new SimpleDateFormat("yyyy-MM-dd").parse(userInput.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(userInput.hasNextLine()) {
            try {
                this.received_in_system = new SimpleDateFormat("yyyy-MM-dd").parse(userInput.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Enter the name of member:");
        if(userInput.hasNextLine()) {
            this.member_name = userInput.nextLine();
        }
        System.out.println("Enter the name of provider:");
        if(userInput.hasNextLine()) {
            this.provider_name = userInput.nextLine();
        }
        System.out.println("Enter the name of service:");
        if(userInput.hasNextLine()) {
            this.service_name = userInput.nextLine();
        }
        System.out.println("Enter the comments:");
        if(userInput.hasNextLine()) {
            this.comments = userInput.nextLine();
        }
        System.out.println("Enter the member'id:");
        if(userInput.hasNextLine()) {
            this.member_id = Integer.parseInt(userInput.nextLine());
        }
        System.out.println("Enter the provider id number:");
        if(userInput.hasNextLine()) {
            this.provider_id =  Integer.parseInt(userInput.nextLine());
        }
        System.out.println("Enter the service id number:");
        if(userInput.hasNextLine()) {
            this.service_id =  Integer.parseInt(userInput.nextLine());
        }
        System.out.println("Enter the fee that need to pay:");
        if(userInput.hasNextLine()) {
            this.fee =  Double.parseDouble(userInput.nextLine());
        }
    }

    public void editInfor(Scanner userInput) {
        //用户修改数据
        //userInput = new Scanner(System.in);

        System.out.println("What would you like to edit?");
        System.out.println("1: Service Name");
        System.out.println("2: Service Fee");
        System.out.println("Q: quit");
        String in = userInput.nextLine();

        switch (in) {
            case "1":
                System.out.println("Enter a new name");
                String newName = userInput.nextLine();
                service_name = newName;
                break;
            case "2":
                System.out.println("Enter a new service Fee");
                double newID = userInput.nextDouble();
                userInput.nextLine();
                fee = newID;
                break;
            case "q":
            case "Q":
                break;

            default:
                System.out.println("Incorrect Input!");
        }
    }
}
