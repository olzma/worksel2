package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PersonTest {

    @org.junit.jupiter.api.Test
    void getFirstName() {
        Person person = new Person("John", "Doe", 30, Gender.MALE, "Bucharest");
        assertEquals("John", person.getFirstName());

    }
        @Test
        void getLastName() {
            Person person = new Person("Jane", "Smith", 25, Gender.FEMALE, "Bucharest");
            assertEquals("Smith", person.getLastName());
        }

        @Test
        void setFirstName() {
            Person person = new Person("John", "Doe", 30, Gender.MALE, "Bucharest");
            person.setFirstName("Mike");
            assertEquals("Mike", person.getFirstName());
        }

    @Test
    void setLastName() {
        Person person = new Person("John", "Doe", 30, Gender.MALE, "Bucharest");
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName());
    }


        @Test
        void getAge() {
            Person person = new Person("John", "Doe", 30, Gender.MALE, "Bucharest");
            assertEquals(30, person.getAge());
        }

        @Test
        void setAge() {
            Person person = new Person("John", "Doe", 30, Gender.MALE, "Bucharest");
            person.setAge(40);
            assertEquals(40, person.getAge());
        }

        @Test
        void increaseAge() {
            Person person = new Person("John", "Doe", 30, Gender.MALE, "Bucharest");
            person.increaseAge(person.getAge(), 5);
            assertEquals(35, person.getAge());
        }

        @Test
        void testToString() {
            Person person = new Person("John", "Doe", 30, Gender.MALE, "Bucharest");
            String expected = "Person{firstName='John', lastName='Doe', age=30}";
            assertEquals(expected, person.toString());
        }


    }


