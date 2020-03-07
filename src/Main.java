import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
       dataController data = new dataController();
        data.printMembers();
         data.printServices();
        data.printProviders();
        String memberFile="data/member.txt";
        String providerFile="data/provider.txt";

        String testFile="data/test.txt"; // path for Testing for writing
        memberData m=new memberData();
        providerData p=new providerData();
        //data.writeInfor(m,memberFile);
        data.writeInfor(m,testFile);
        data.writeInfor(p,testFile);
 //       data.writeService(new Service(),"data/service.txt");
    }
}
