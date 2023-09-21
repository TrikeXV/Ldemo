package com.example.ldemo;

import com.example.ldemo.user.Repo;
import com.example.ldemo.user.user;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.GregorianCalendar;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepoTests {
    @Autowired private Repo repo;

    @Test
    public void testAddNew(){
        user u = new user();
        u.setLid(1l);
        u.setCid(1l);
        u.setAmount(1000);
        u.setDate(new GregorianCalendar(2023,02,06));
        u.setInterest(7.5);
        u.setRamount(800);
        u.setCancel("");
        u.setPenalty(0.0);
        u.setDuedate(new GregorianCalendar(2024,02,06));

        user savedUser = repo.save(u);
        Assertions.assertNotNull(savedUser);

        


    }

}
