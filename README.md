# Patient Management System

A Java-based console application designed to manage patient and doctor accounts and medical records. The project implements user registration, authentication, role-based access and local file storage.

## Features

- User registration for patients and doctors
- Login authentication with password hashing (SHA-256)
- Role-based access control
- Patients can only view their own medical records
- Doctors can view and write medical records
- Medical records stored locally in separate files
- User data stored in CSV files
- Console-based interface

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Java I/O
- CSV file handling
- SHA-256 hashing
- Git & GitHub
- IntelliJ IDEA

## Getting Started

### Prerequisites

- Java JDK installed
- IntelliJ IDEA (recommended)

### Clone the repository

Open a terminal and run:

```bash
[git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git](https://github.com/moonwhileloop/Portfolio.git)
```

Navigate to the project directory:

```bash
cd PatientManagementSystem
```

### Run the application

1. Open the cloned project in IntelliJ IDEA.
2. Make sure the project SDK is correctly configured.
3. Locate `Main.java` inside the `src` directory.
4. Run the `Main` class.

The application will display the main menu, allowing you to register or log in.

## Demo Accounts

The following accounts are provided to test the application.

### Patient Account

| Field | Value |
|---|---|
| Name | Mario |
| Last Name | Rossi |
| Email | mrossi |
| Password | Mrossi01 |
| Phone | 398164272 |
| Address | Via Marco Polo |
| City | Como |
| Province | Como |
| Role | Patient |
| Tax ID | PP561 |
| Birth Date | 14/01/1996 |

### Doctor Account

| Field | Value |
|---|---|
| Name | Albert |
| Last Name | Einstein |
| Email | aeinstein@mail.it |
| Password | TeoriaStringhe |
| Phone | 972537 |
| Address | Via dei Quanti 23 |
| City | Como |
| Province | Como |
| Role | Doctor |
| Tax ID | DP4276 |
| Birth Date | 15/01/1965 |
| University | Milan |
| Register Number | 615 |
| Graduation Year | 1995 |
| Qualification | Cardiologist |

> These are demo accounts intended exclusively for testing purposes.

## How to Test

### Patient

1. Log in using the patient demo credentials.
2. Access the patient menu.
3. Select the option to read your medical record.
4. The application retrieves the record associated with your Tax ID.
5. The patient can read their record but cannot add notes.

### Doctor

1. Log in using the doctor demo credentials.
2. Access the doctor menu.
3. Enter the Tax ID of the patient whose record you want to access.
4. Read the patient's medical record.
5. Add a new medical note, which will be saved locally.

## Data Storage

User information is stored in:

```text
data/users.csv
```

Medical records are stored in separate text files:

```text
data/records/<TAX_ID>.txt
```

For example:

```text
data/records/PP561.txt
```

Each file contains the notes associated with a specific patient.

## Security Disclaimer

This project is intended for educational and portfolio purposes only.

Although passwords are hashed using SHA-256, the current implementation does not use salt or a password-specific hashing algorithm such as BCrypt or Argon2. The application also uses local files instead of a secure database and does not implement production-grade authorization or data protection.

**Do not use this application to store real medical or personal data.**

## Future Improvements

- Implement a more advanced access management system, including an Administrator (Admin) role
- Improve authentication and authorization mechanisms
- Implement a system to manage doctor-patient relationships and restrict doctors' access to authorized patients only
- Replace CSV and text file storage with a relational database
- Implement secure password hashing with salt
- Develop a graphical user interface (GUI)
- Add input validation and error handling
- Implement medical record management features such as editing and deleting records

## Author

Developed by **Martina Molteni** as a personal Java project to practice object-oriented programming, authentication, file management and role-based access control.
