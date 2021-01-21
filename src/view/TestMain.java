package view;

import model.Contact;
import service.ManageContacts;

import java.util.Scanner;

public class TestMain {
    static Scanner scanner = new Scanner(System.in);
    static ManageContacts manageContacts = new ManageContacts();
    private static final String REGEX_PHONE_NUMBER = "^[0-9]{10}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]{1,}.@gmail.com$";
    private static final String REGEX_VALID_BIRTHDAY = "^[\\d]{1,2}(/)[\\d]{1,2}(/)[\\d]{4}$";

    public static void main(String[] args) {
        int choise;
        do {
            System.out.println("|=========MENU======= |");
            System.out.println("|1.Thêm mới danh sách |");
            System.out.println("|2.Hiển thị danh sách |");
            System.out.println("|3.Cập nhật danh sách |");
            System.out.println("|4.Xoá                |");
            System.out.println("|5.Tìm kiếm           |");
            System.out.println("|6.Ghi File           |");
            System.out.println("|7.Đọc File           |");
            System.out.println("|0.Thoat              |");
            System.out.println("|-------------------- |");
            System.out.println("Xin mời nhập lựa chọn:");
            choise = Integer.parseInt(scanner.nextLine());
            switch (choise) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    manageContacts.showAll();
                    break;
                case 3:
                    editContactName();
                    break;
                case 4:
                    deleteContactByPhoneNumber();
                    break;
                case 5:
                    findByPhoneNumber();
                    break;
                case 6:
                    manageContacts.writeFile();
                    break;
                case 7:
                    manageContacts.readFile();
                    break;
                case 0:
                    break;
            }

        } while (choise != 0);
    }

    private static void findByPhoneNumber() {
        System.out.println("Nhập số điện thoại muốn tìm");
        String phoneNumber = scanner.nextLine();
        manageContacts.searchContact(phoneNumber);
    }

    private static void editContactName() {
        String phoneNumber;
        System.out.println("Nhập số điện thoại cần sửa");
        phoneNumber = scanner.nextLine() ;
        System.out.println("Nhập tên cần sửa");
        String fullName =scanner.nextLine() ;
        manageContacts.editContact(phoneNumber,fullName);
    }

    private static void deleteContactByPhoneNumber() {
        System.out.println("Nhập số điện thoại muốn xoá");
        String phoneNumber = scanner.nextLine();
        manageContacts.deleteContact(phoneNumber);
    }

    private static void addNewContact() {
        System.out.println("Số lượng muốn thêm mới");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            addConTact();
        }
    }

    public static void addConTact() {
        Scanner sc = new Scanner(System.in);
        String phoneNumber;
        do {
            System.out.println("Nhập số điện thoại 10 số");
            phoneNumber = sc.nextLine();
        }while (!phoneNumber.matches(REGEX_PHONE_NUMBER));
        System.out.println("Nhập tên nhóm");
        String group = sc.nextLine();
        System.out.println("Nhập họ và tên");
        String fullName = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String sex = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        String birthday = "";
        do {
            System.out.println("Nhập ngày tháng năm sinh");
             birthday = sc.nextLine();
        }while (!birthday.matches(REGEX_VALID_BIRTHDAY));

        String email = "";
        do {
            System.out.println("Nhap Email");
            email = scanner.nextLine();
        }while (!email.matches(REGEX_EMAIL));
        Contact contact = new Contact(phoneNumber, group, fullName, sex, address, birthday, email);
        manageContacts.addContact(contact);
        System.err.println("=====------------------=====");
    }
}
