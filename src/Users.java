import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Users {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String city;
    private String province;
    private String role; // "patient" or "doctor"
    private String taxID;
    private String birthDate;

    // Doctor-only fields
    private String university;
    private String registerNumber;
    private String graduationYear;
    private String qualification;

    // doctor's constructor
    public Users(String name, String lastName, String email, String password,
                 String phoneNumber, String address, String city, String province,
                 String role, String taxID,
                 String university, String registerNumber,
                 String graduationYear, String qualification) {

        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.province = province;
        this.role = role;
        this.taxID = taxID;

        this.university = university;
        this.registerNumber = registerNumber;
        this.graduationYear = graduationYear;
        this.qualification = qualification;
    }

    // patient's constructor
    public Users(String name, String lastName, String email, String password,
                 String phoneNumber, String address, String city, String province,
                 String role, String taxID) {

        this(name, lastName, email, password, phoneNumber, address, city, province,
                role, taxID, "", "", "", "");
    }

    // getters&setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getTaxID() {
        return taxID;
    }
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }
    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getGraduationYear() {
        return graduationYear;
    }
    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    // age calculation

    public int getAge() {
        if (!role.equalsIgnoreCase("patient") || birthDate == null) {
            return -1;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    }
}
