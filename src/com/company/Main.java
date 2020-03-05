package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        dataController data = new dataController();
        data.printMembers();
        data.printServices();
        data.printProviders();
        String memberFile="ChocAn/data/member.txt";
        String providerFile="ChocAn/data/provider.txt";
       // memberData m=new memberData();
        //m.printAll();
        //data.writeInfor(m,memberFile);
        //data.writeInfor(m,providerFile);
        //data.writeService(new Service(),"ChocAn/data/service.txt");



    }
}
