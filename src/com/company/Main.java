package com.company;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        dataController data = new dataController();
        // data.printMembers();
        // data.printServices();
        //data.printProviders();
        String memberFile="data/member.txt";
        String providerFile="data/provider.txt";
        memberData m=new memberData();
        //data.writeInfor(m,memberFile);
        //data.writeInfor(m,providerFile);
       // data.writeService(new Service(),"data/service.txt");
    }
}
