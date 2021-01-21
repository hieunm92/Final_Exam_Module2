package service;

import model.Contact;
import storage.WriteAndReadFile;

import java.util.ArrayList;
import java.util.List;

public class ManageContacts {
    List<Contact> contactList = new ArrayList<>();
    public static final String FILE_CONTACT = "contact.dat";

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void showAll() {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "Phone Number",
                "Group",
                "FullName",
                "Sex",
                "Address",
                "Birthday",
                "Email");

        for (Contact contact : contactList) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getPhoneNumber(),
                    contact.getGroup(),
                    contact.getFullName(),
                    contact.getSex(),
                    contact.getAddress(),
                    contact.getBirthday(),
                    contact.getEmail());

        }
    }

    public void editContact(String phoneNumber, String fullName) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                contact.setFullName(fullName);
            }
        }
    }

    public void searchContact(String phoneNumber) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Không tìm thấy trong danh sách");
    }


    public void deleteContact(String phoneNumber) {
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                contactList.remove(contact);
            }
        }
    }


    public void writeFile() {
        WriteAndReadFile.writeFile(contactList, FILE_CONTACT);
    }

    public void readFile() {
        contactList = (List<Contact>) WriteAndReadFile.readFile(FILE_CONTACT);
        showAll();
    }
}
