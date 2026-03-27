import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Represents a user of the Patient Management System.
 * A user can be either a patient or a doctor.
 *
 * Doctors have additional professional information such as university,
 * register number, graduation year, and qualification.
 * Patients can have a birth date used to calculate their age.
 *
 * @author Martina Molteni
 * @version 1.0
 */

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
    private LocalDate birthDate;

    // Doctor-only fields
    private String university;
    private String registerNumber;
    private String graduationYear;
    private String qualification;

    // doctor's constructor
    /**
     * Constructs a new doctor user with all required information.
     *
     * @param name the user's first name
     * @param lastName the user's last name
     * @param email the user's email address
     * @param password the user's password
     * @param phoneNumber the user's phone number
     * @param address the user's address
     * @param city the user's city
     * @param province the user's province
     * @param role the role of the user (doctor)
     * @param taxID the user's tax identification code
     * @param university the university attended by the doctor
     * @param registerNumber the doctor's register number
     * @param graduationYear the year of graduation
     * @param qualification the doctor's qualification
     */
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
    /**
     * Constructs a new patient user.
     *
     * @param name the user's first name
     * @param lastName the user's last name
     * @param email the user's email address
     * @param password the user's password
     * @param phoneNumber the user's phone number
     * @param address the user's address
     * @param city the user's city
     * @param province the user's province
     * @param role the role of the user (patient)
     * @param taxID the user's tax identification code
     */
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

    /**
     * Returns the role of the user.
     *
     * @return the role (patient or doctor)
     */

    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the role to set (patient or doctor)
     */

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

    /**
     * Calculates the age of the user if the user is a patient.
     *
     * @return the age in years, or -1 if the user is not a patient or birth date is not set
     */

    public Integer getAge() {
        if (!role.equalsIgnoreCase("patient") || birthDate == null) {
            return null;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

}
