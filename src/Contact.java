public class Contact {
    private int phoneNumber;
    private String group;
    private String fullName;
    private String sex;
    private String address;
    private String birthday;
    private String email;

    public Contact() {
    }

    public Contact(int phoneNumber, String group, String fullName, String sex, String address, String birthday, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber=" + phoneNumber +
                ", group='" + group + '\'' +
                ", fullName='" + fullName + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
