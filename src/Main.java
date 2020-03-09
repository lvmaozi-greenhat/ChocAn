import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        dataController data = new dataController();


        Interface mainInput = new Interface(data);

        mainInput.start();

        //data.printMembers();
        //data.printServices();
        //data.printProviders();
        //String memberFile="data/member.txt";
        //String providerFile="data/provider.txt";
        //      memberData m=new memberData();
        //data.writeInfor(m,memberFile);
        //data.writeInfor(m,providerFile);
        //       data.writeService(new Service(),"data/service.txt");

        /*
        data.writeAll("data/member.txt","data/provider.txt","data/service.txt");
        dataController data2 = new dataController();
        data2=data;
        data2.printMembers();
        data2.printServices();
        data2.printProviders();


        Scanner input=new Scanner(System.in);
        memberData obj = new memberData();
        obj=data.selectMember(input);
        obj.printAll();

        memberData obj=new memberData();
        data.addMember(obj);
        data.printMembers();
        System.out.println("**************************************************************");
        data.deleteMember(obj);
        data.printMembers();
        */

    }
}
