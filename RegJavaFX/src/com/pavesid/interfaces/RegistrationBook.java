package com.pavesid.interfaces;

import com.pavesid.objects.Person;

public interface RegistrationBook {

    void addPerson(Person person);

    void updatePerson(Person person);

    void removePerson(Person person);

    boolean isPerson(Person person);

    Person getPerson(String email);
}
