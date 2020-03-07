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
            System.out.println("H for help, Q to quit. Q! to quit without writing");
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
                    //dataController.writeAll();
                    active = false;
                    break;

                case "q!":
                case "Q!":
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
            System.out.println("H for help, Q to quit");
            String in = userInput.nextLine();

            switch (in){
                case "1":
                    //add new member
                    //constructor member(Scanner userInput);
                    //mainController.addMember(member);
                    break;

                case "2":
                    //delete a member

                    //print all members
                        //dataController.printAllMembers()

                    //Select a member
                        //tmpMember = dataController.selectMemberByID(); // returns member

                    //delete a member
                        //dataController.deleteMember(tmpMember);
                    break;

                case "3":
                    //Update member info

                    //Print all members
                        //dataController.printAllMembers();

                    //select a member
                        //tmp Member = dataController.selectMemberById(Scanner);

                    //edit member info
                        //member.editInfo(scanner);
                    break;

                case "4":
                    //add new provider

                    //tmpProvider = new provider(scanner);
                    //dataController.addProvider(tmpProvider);
                    break;

                case "5":
                    //change provider records

                    //print all providers
                        //dataController.printAllProviders();
                    //select a provider
                        //tmpProvider = dataController.selectProvider(Scanner);
                    //edit provider info
                        //provider.editInfo(scanner);
                    break;

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
            //print all available providers
                //dataController.printAllProviders();
            //select a provider
                //tmpProvider = dataController.selectProvider(Scanner);
            //edit provider info
                //provider.editInfo(Scanner);

    }

    public void managerMode(Scanner userInput){
        //runs member reports

        //print all members
            //dataController.printAllMembers();
        //ask to select a member
            //tmpMember = dataController.selectMember(Scanner);
        //write out report to some output.txt
            //member.writeReport(); , or member.writeReport(string fileName);
    }
}
