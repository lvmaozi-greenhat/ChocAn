import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class dataController {
    ArrayList<memberData> members;
    ArrayList<Service> services;
    ArrayList<providerData> providers;


    //Auto load all the information from external .txt file
    public dataController() {
        members = new ArrayList<>();
        services = new ArrayList<>();
        providers = new ArrayList<>();
        readMembers();
        readProviders();
        readServices();
        addServiceToMember();
        addServiceToProvide();
    }

    //To add service in to members
    public void addServiceToMember() {
        for (memberData member : members) {
            for (Service service : services) {
                if (service.member_id == member.number) {   // check matching id
                    member.services.add(service);       // If matched, then Add
                }
            }
        }
    }

    //To add service in to providers
    public void addServiceToProvide() {
        for (providerData provider : providers) {
            for (Service service:services) {
                if (service.provider_id == provider.number) {   // check matching id
                    provider.services.add(service);       // If matched, then Add
                }
            }
        }
    }

    //Read members from data/member.txt
    public void readMembers() {
        File memberFile = new File("data/member.txt");
        try {
            Scanner memberScanner = new Scanner(memberFile);
            while (memberScanner.hasNextLine()) {
                members.add(new memberData(memberScanner));
            }
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }
    }


    //Read members from data/provider.txt
    public void readProviders() {
        File providerFile = new File("data/provider.txt");
        try {
            Scanner providerScanner = new Scanner(providerFile);
            while (providerScanner.hasNextLine()) {
                providers.add(new providerData(providerScanner));
            }
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }
    }


    //Read services from data/service.txt
    public void readServices() {
        File serviceFile = new File("data/service.txt");
        try {
            Scanner serviceScanner = new Scanner(serviceFile);
            while (serviceScanner.hasNext()) {
                services.add(new Service(serviceScanner));
            }

        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        }
    }


    //Print member reports
    public void printMembers() {
        for (memberData member : members) {
            member.printAll();
        }
    }

    //Print service information
    public void printServices() {
        for (Service service : services) {
            service.printAll();
        }
    }

    //Print service information
    public void printProviders() {
        for (providerData provider : providers) {
            provider.printAll();

        }
    }

    //Write either member/provider into their file
    //For member filename should be "data/member.txt"
    //For provider filename should be "data/provider.txt"
    public void writeInfor(Data m, String fileName) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.append(m.name);
            bw.append("\n");
            bw.append(Integer.toString(m.number));
            bw.append("\n");
            bw.append(m.address);
            bw.append("\n");
            bw.append(m.city);
            bw.append("\n");
            bw.append(m.state);
            bw.append("\n");
            bw.append(Integer.toString(m.zip_code));
            bw.append("\n");
            bw.close();
        } catch (Exception x) {
            System.out.println("File writing error.");
        }
    }

    public void writeService(Service s, String fileName) {
        BufferedWriter bw;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.append(sdf.format(s.occurred_date));
            bw.append("\n");
            bw.append(sdf.format(s.received_in_system));
            bw.append("\n");
            bw.append(s.member_name);
            bw.append("\n");
            bw.append(s.provider_name);
            bw.append("\n");
            bw.append(s.service_name);
            bw.append("\n");
            bw.append(s.comments);
            bw.append("\n");
            bw.append(Integer.toString(s.member_id));
            bw.append("\n");
            bw.append(Integer.toString(s.provider_id));
            bw.append("\n");
            bw.append(Integer.toString(s.service_id));
            bw.append("\n");
            bw.append(Double.toString(s.fee));
            bw.append("\n");
            bw.close();
        } catch (Exception x) {
            System.out.println("File writing error.");
        }
    }

    //writes all data to files, happens when program quits.
    public void writeAll(String filename1, String filename2, String filename3) throws IOException {

        File file1 = new File(filename1);
        File file2 = new File(filename2);
        File file3 = new File(filename3);

        System.gc();

        if(file1.exists() && file2.exists() && file3.exists()) {
            if (file1.delete() && file2.delete() && file3.delete()) {
                System.out.println(" DELETED");
            } else {
                System.out.println("Failed Deleted");
            }
        }

        if (!file1.exists() && !file2.exists() && !file3.exists())
        {
            file1.createNewFile();
            file2.createNewFile();
            file1.createNewFile();
        }

        for (memberData member : members) {
            writeInfor(member,filename1);
        }

        for (providerData provider : providers) {
            writeInfor(provider,filename2);
        }

        for (Service service : services){
            writeService(service,filename3);
        }

    }

    //adds a member object into dataController's arrayList
    public void addMember (memberData obj)
    {
        members.add(obj);
    }

    //returns a member inside of dataController from user input
    public memberData selectMember(Scanner input)
    {
        int toFind = input.nextInt();
        for(memberData member : members)
        {
            if(member.number==toFind)
                return member;
        }

        return null;
    }

    //deletes member object from dataController
    void deleteMember (memberData obj)
    {
        members.remove(obj);
    }


    //adds a provider object into dataController's arrayList
    void addProvider(providerData newProvider) {
        providers.add(newProvider);
    }

    void addService(Service newService){services.add(newService);}

    //returns a provider inside of dataController from user input
    providerData selectProvider(Scanner providerName) {
        String find = providerName.nextLine();
        for (providerData provider : providers) {
            if (provider.isMatch(find)) {
                return provider;
            }
        }
        return null;
    }

    //returns a service inside of dataController from user input
    Service selectService(Scanner serviceName) {
        String find = serviceName.nextLine();
        for (Service servicer : services) {
            if (servicer.isMatch(find)) {
                return servicer;
            }
        }
        return null;
    }

}
