package com.rest.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity
@Table(name="user")
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;
    // since the id is auto incremented this ensures hibernate knows that.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    private int id;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     */
    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the date of birth
     *
     * @return The date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth
     *
     * @param dateOfBirth Sets the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Calculates the user's current age
     *
     * This method calculates the age by comparing the birth year to the current year.
     * To ensure accuracy, it checks if the user has reached their birthday in the current
     * calendar year. If today date is BEFORE their birthday, the age is decremented by 1
     * so the user's age isn't over assumed.
     *
     * @return The user's current age
     */
    public int getAge() {
        String yearString = this.dateOfBirth.substring(0,4);
        String monthString = this.dateOfBirth.substring(5, 7);
        String dayString = this.dateOfBirth.substring(8, 10);

        int birthYear = Integer.parseInt(yearString);
        int birthMonth = Integer.parseInt(monthString);
        int birthDay = Integer.parseInt(dayString);

        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        int currentYear = localDate.getYear();
        int currentMonth = localDate.getMonthValue();
        int currentDay = localDate.getDayOfMonth();

        int age = currentYear - birthYear;

        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        return age;
    }
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }


}