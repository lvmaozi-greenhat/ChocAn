package com.company;

import java.util.ArrayList;

public class dataController {
    //data structure of providerData
    //data structure of memberData
    //data structure of Services,
        //this will be the 'master list' of all possible services
    //function to initialize providerData, memberData, read serviceData master from file

    ArrayList<providerData> providers;
    ArrayList<memberData> members;
    ArrayList<Service> services;

    void loadAll() {
        /*
        //provider data:
        File[] providerFiles = new File ("path/to/providerDir").listFiles(); //This creates an array of all files in a directory
        for(File toRead : providerFiles){ //for every file in that directory
            if(toRead.isFile()){
                //new scanner tmpScan(toRead);
                //new providerData new(tmpScan);
                //add to arrayList providers: new;
            }
        }
         */
        //Something similar will also be used for memberData and Service data
    }




}
