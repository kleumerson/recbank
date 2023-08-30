package com.recbank.repository.person;

import com.recbank.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRegisterRepository extends JpaRepository<Person, Integer> {
}
