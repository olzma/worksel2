package org.example;

import java.util.Objects;

public class Person implements Customer {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String cityOfResidence;

    public Person(String firstName, String lastName, int age, Gender gender, String cityOfResidence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.cityOfResidence= cityOfResidence;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void increaseAge(int age, int years) {
        this.age = age+years;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", age=" + age + '}';
    }

    Person createPerson() {
        return  extracted();
        //extracted();


        //new Person("John", "Doe", 30, male, gender.MALE);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + age;
        result = 31 * result + Objects.hashCode(gender);
        return result;
    }

    private static Person extracted() {
        String printPerson = "John Doe, 30, MALE, Engineer, New York";
        String cityOfResidence = printPerson.split(", ")[4];
        String[] parts = printPerson.split(", ");
        String firstName = parts[0].split(" ")[0];
        String lastName = parts[0].split(" ")[1];


        int age = Integer.parseInt(parts[1]);
        Person newPerson = new Person(firstName, lastName, age, Gender.MALE, cityOfResidence);
        System.out.println(newPerson);
        return newPerson;
    }

    boolean isFromCity(Person other, String city) {
        if (other == null) {
            return false;
    }

        return other.cityOfResidence.equalsIgnoreCase(city);

    }
}
