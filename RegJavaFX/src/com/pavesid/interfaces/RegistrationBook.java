package com.pavesid.interfaces;

import com.pavesid.objects.Person;

public interface RegistrationBook {

    void addPerson(Person person);

    void updatePassPerson(String email, String password);

    void updateDefPassPerson(Person person);

    void removePerson(Person person);

    boolean isPerson(Person person);

    Person getPerson(String email);
}
