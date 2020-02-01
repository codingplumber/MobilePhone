package jason.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<String> contacts = new ArrayList<String>();

    private String getContacts(int index) {
        return contacts.get(index);
    }

    public void setContacts(String contact) {
        contacts.add(contact);
    }

    public void showContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.print((i + 1) + ": " + getContacts(i) + "\n");
        }
    }

    public void modifyContacts(String oldContact, String contact) {
        int index = searchContacts(oldContact);

        if (index >= 0) {
            modifyContacts(index, contact);
        } else {
            System.out.println(contact + " doesn't exist");
        }
    }

    private void modifyContacts(int index, String contact) {
        String oldContact = getContacts(index);
        contacts.set(index, contact);
        System.out.println("Contact " + oldContact + " changed to " + contact);
    }

    public void removeContacts(String contact) {
        int index = searchContacts(contact);

        if (index >= 0) {
            removeContacts(index, contact);
        } else {
            System.out.println(contact + " not found");
        }
    }

    private void removeContacts(int index, String contact) {
        contacts.remove(index);
        System.out.print(contact + " was removed");
    }

    private int searchContacts(String contact) {
        // returns index of contact in ArrayList, -1 if not in list
        return contacts.indexOf(contact);
    }

    public boolean isContact(String contact) {
        if (searchContacts(contact) >= 1) {
            return true;
        }

        return false;
    }
}
