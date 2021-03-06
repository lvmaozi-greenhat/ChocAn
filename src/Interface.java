import java.io.IOException;
import java.util.Scanner;

public class Interface {
    //data structures of providerData and memberData
    //functions to call providerData and memberData to load
    //main interface loop including support for modes
    public dataController mainController;

    public Interface(dataController input){
        mainController = input;
    }

    public void start(){
        Scanner userInput = new Scanner(System.in);
        boolean active = true;
        while(active) {
            System.out.println("What mode would you like to use?");
            System.out.println("1: Interactive Mode");
            System.out.println("2: Provider Mode");
            System.out.println("3: Manager Mode");
            System.out.println("H for help, Q to quit. QQ to quit without writing");
            String in = userInput.nextLine();

            switch (in) {
                case "1":
                    interactiveMode(userInput);
                    break;

                case "2":
                    providerMode(userInput);
                    break;

                case "3":
                    managerMode(userInput);
                    break;

                case "h":
                case "H":
                    System.out.println("This is the help section.");
                    //add help section
                    break;

                case "q":
                case "Q":
                    try {
                        mainController.writeAll("Data/member.txt", "Data/provider.txt", "Data/service.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    active = false;
                    break;

                case "qq":
                case "QQ":
                    active = false;
                    break;

                default:
                    System.out.println("Incorrect input.");
                    break;

            }
        }
    }

    public void interactiveMode(Scanner userInput){
        boolean active = true;
        while(active) {
            System.out.println("Interactive Mode");
            System.out.println("1: Add new member into chocAn system");
            System.out.println("2: delete member from chocAn system");
            System.out.println("3: Update member records");
            System.out.println("4: Add a new provider into chocAn system");
            System.out.println("5: Change provider records");
            System.out.println("6: Change master service records");
            //System.out.println("7: Allow provider to accept a service");
            //System.out.println("8: Find Provider and Service from array list");
            System.out.println("H for help, Q to quit");
            memberData tmpMember;
            providerData tmpProvider = new providerData();
            Service tmpService = new Service();
            String in = userInput.nextLine();

            switch (in){
                case "1":
                    //add new member
                    //new_member.setData(Scanner userInput);
                    //mainController.addMember(member);
                    memberData toAdd = new memberData();
                    toAdd.setData(userInput);
                    mainController.addMember(toAdd);
                    break;

                case "2":
                    //delete a member

                    //print all members
                        //dataController.printAllMembers()

                    //Select a member
                        //tmpMember = dataController.selectMember(); // returns member

                    //delete a member
                        //dataController.deleteMember(tmpMember);
                    mainController.printMembers();
                    tmpMember = mainController.selectMember(userInput);
                    mainController.deleteMember(tmpMember);
                    break;

                case "3":
                    //Update member info

                    //Print all members
                        //dataController.printAllMembers();

                    //select a member
                        //tmp Member = dataController.selectMember(Scanner);

                    //edit member info
                        //member.editInfo(scanner);
                    mainController.printMembers();
                    tmpMember = mainController.selectMember(userInput);
                    tmpMember.editInfor(userInput);

                    break;

                case "4":
                    //add new provider

                    //tmpProvider = new provider(scanner);
                    //dataController.addProvider(tmpProvider);
                    tmpProvider.setData(userInput);
                    mainController.addProvider(tmpProvider);
                    break;

                case "5":
                    //change provider records

                    //print all providers
                        //dataController.printAllProviders();
                    //select a provider
                        //tmpProvider = dataController.selectProvider(Scanner);
                    //edit provider info
                        //provider.editInfo(scanner);
                    mainController.printProviders();
                    tmpProvider = mainController.selectProvider(userInput);
                    tmpProvider.editInfor(userInput);

                    break;

                case "6":
                    //change master service records
                    //print all services
                        //dataController.printAllServices();
                    //select a service
                        //tmpService = dataController.selectService(scanner);
                    //edit service info
                        //service.editInfo(scanner);
                    mainController.printServices();
                    tmpService = mainController.selectService(userInput);
                    tmpService.editInfor(userInput);
                    break;
/*
                case "7":
                    //add a service to master service record
                    //populate a tempService from user input
                        //tempService = service(Scanner);
                    //add tempService to dataController's service arrayList
                        //dataController.addService(tempService);
                    tmpService.editInfor(userInput);
                    mainController.addService(tmpService);

                case "8":
                    //allow provider to provide a service
                    //print all services
                        //dataController.printAllServices();
                    //select a service
                        //tmpService = dataController.selectService(scanner);
                    //print all providers
                        //dataController.printAllProviders();

                    mainController.printProviders();

                    //************* select a provider **************
                   System.out.println("Input provider name");

                   //dataController tmpProvider = new dataController();
                   providerData find;
                   find = mainController.selectProvider(userInput);

                   if(find != null) {
                       find.printAll();
                   }
                   else
                       System.out.println("Cannot find");

                   mainController.printServices();

                    //*********** add service to provider ************
                    System.out.println("Input service name");

                    Service findService;
                    findService = mainController.selectService(userInput);

                    if(findService != null) {
                        findService.printAll();
                    }
                    else
                        System.out.println("Cannot find");

                    break;
*/
                case "h":
                case "H":
                    //will need to be filled out later
                    System.out.println("Help text");
                    break;

                case "q":
                case "Q":
                    active = false;
                    break;

                default:
                    System.out.println("Incorrect input.");
            }
        }

    }

    public void providerMode(Scanner userInput){
            System.out.println("Provider Mode");
            System.out.println("What provider would you like to enter providerMode as?");
            mainController.printProviders();
            providerData tmpProvider = mainController.selectProvider(userInput);
            //print all available providers
                //dataController.printAllProviders();
            //select a provider
                //tmpProvider = dataController.selectProvider(Scanner);
            System.out.println("1: Add a service to a member");
            System.out.println("2: Q to quit");
            String in = userInput.nextLine();

            switch(in){
                case "1":
                    mainController.printMembers();
                    System.out.println("Select a member:");
                    memberData tmpMember = mainController.selectMember(userInput);
                    tmpProvider.printAll();
                    System.out.println("Add a service to the member:");
                    Service tmpService = new Service(tmpProvider, tmpMember, userInput);
                    mainController.addService(tmpService);
                    break;

                case "q":
                case "Q":
                    break;

                default:
                    System.out.println("Incorrect input");
            }

            //Allow provider to add a service to a member
            //print all members
                //dataController.printAllMembers
            //select temp member
                //tempMember = dataController.selectMember(scanner);
            //display all available services
                //tmpProvider.displayAllServices();
            //select a service
                //provider.selectService(scanner);
            //add service to member
                //tempMember.addService(service);
    }

    public void managerMode(Scanner userInput){
        //runs member reports and provider reports

        //member report:
        //print all members
            //dataController.printAllMembers();
        //ask to select a member
            //tmpMember = dataController.selectMember(Scanner);
        //write out report to some output.txt
            //member.writeReport(); , or member.writeReport(string fileName);
        System.out.println("1: run a member report");
        System.out.println("2: run a provider report");
        System.out.println("q to quit");
        String in = userInput.nextLine();

        switch(in){
            case "1":
                mainController.printMembers();
                memberData tmpMember = mainController.selectMember(userInput);
                tmpMember.writeReport();
                break;
            case "2":
                mainController.printProviders();
                providerData tmpProvider = mainController.selectProvider(userInput);
                tmpProvider.writeReport();
                break;
            case "q":
            case "Q":
                break;
            default:
                System.out.println("Incorrect Input");
        }

        //provider report:
        //print all providers
            //dataController.printAllProviders();
        //ask to select a provider
            //tmpProvider / dataController.selectProvider(scanner);
        //write out report to some output.txt
            //provider.writeReport(); or provider.writeReport(string fileName);
    }
}
