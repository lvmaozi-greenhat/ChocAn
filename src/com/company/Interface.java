package com.company;

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
            System.out.println("H for help, Q to quit.");
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
                    break;

                case "q":
                case "Q":
                    active = false;
                    break;

                default:
                    System.out.println("Incorrect input.");
                    break;

            }
        }
    }

    public void interactiveMode(Scanner userInput){

    }

    public void providerMode(Scanner userInput){

    }

    public void managerMode(Scanner userInput){

    }
}
