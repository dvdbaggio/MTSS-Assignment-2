////////////////////////////////////////////////////////////////////
// [Davide] [Baggio] [2009989]
// [Sebastiano] [Sanson] [2011880]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;

public class User {
    private String email;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public User(String email, String name, String surname, LocalDate dateOfBirth) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        // check if dateOfBirth is not null
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth value cannot be NULL");
        }
        // check if date of birth is valid
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth is in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}