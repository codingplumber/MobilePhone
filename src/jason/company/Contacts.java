package jason.company;

import java.util.Scanner;

public class Contacts extends MobilePhone {
    private Scanner scanner = new Scanner(System.in);
    private Boolean rerunModify = false;
    
    public void runMenu() {
        int optionNumber = 0;
        boolean quit = false;
        displayMenuMessages();

        while (!quit) {
            System.out.print("Enter Option: ");
            optionNumber = scanner.nextInt();
            scanner.nextLine();

            switch (optionNumber) {
                case 0:
                    displayMenuMessages();
                    break;

                case 1:
                    addContacts();
                    break;

                case 2:
                    modifyContacts();
                    break;

                case 3:
                    removeContacts();
                    break;

                case 4:
                    searchContacts();
                    break;

                case 5:
                    showContacts();
                    break;

                default:
                    System.out.println("Exiting Menu");
                    quit = true;
                    break;
            }
        }
    }
    
    public void displayMenuMessages() {
        System.out.print("\n 0 - Show Menu");
        System.out.print("\n 1 - Add Contact");
        System.out.print("\n 2 - Modify Contact");
        System.out.print("\n 3 - Remove Contact");
        System.out.print("\n 4 - Search Contacts");
        System.out.println("\n 5 - Display Contacts");
    }

    public void addContacts() {
        System.out.print("Add Contact: ");
        String contact = scanner.nextLine();
        setContacts(contact);
    }

    public void modifyContacts() {
        if (rerunModify) System.out.print("Contact not found \n");
        System.out.print("Contact to Modify: ");
        String oldContact = scanner.nextLine();
        if (isContact(oldContact)) {
            System.out.print("Change to: ");
            String contact = scanner.nextLine();
            modifyContacts(oldContact, contact);
            rerunModify = false;
        } else {
            rerunModify = true;
            modifyContacts();
        }
    }

    public void removeContacts() {
        System.out.println("Remove Contact: ");
        String contact = scanner.nextLine();
        removeContacts(contact);
    }

    public void searchContacts() {
        System.out.print("Search Contacts: ");
        String contact = scanner.nextLine();
        if (isContact(contact)) {
            System.out.println(contact + " found");
        } else {
            System.out.println(contact + " not found");
        }
    }
}
