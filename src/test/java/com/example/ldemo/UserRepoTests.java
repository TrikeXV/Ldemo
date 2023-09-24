package com.example.ldemo;

import com.example.ldemo.user.Repo;
import com.example.ldemo.user.user;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepoTests {
    @Autowired private Repo repo;

    @Test
    public void testAddNew(){
        user u = new user();
        u.setLid(2l);
        u.setCid(2l);
        u.setAmount(1500);
        u.setDate(new GregorianCalendar(2023,1,26));
        u.setInterest(9.5);
        u.setRamount(900);
        u.setCancel("");
        u.setPenalty(0.0);
        u.setDuedate(new GregorianCalendar(2024,01,26));

        user savedUser = repo.save(u);
        Assertions.assertNotNull(savedUser);


    }

    @Test
    public void testListAll(){
        Iterable<user> u = repo.findAll();

        for (user User: u){
            System.out.println(User);
        }
    }

    @Test
    public void testUpdate(){
        Integer userID=1;
        Optional<user> optionalUser = repo.findById(userID);
        user User= optionalUser.get();
        User.setInterest(2.2);
        repo.save(User);

        user updatedUser=repo.findById(userID).get();
        assertThat(updatedUser.getInterest(),equalTo(2.2));

    }

    @Test
    public void testGet(){
        Integer userID=1;
        Optional<user> optionalUser = repo.findById(userID);
        assertTrue(optionalUser.isPresent());
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userID=2;
        repo.deleteById(userID);
        Optional<user> optionalUser = repo.findById(userID);
        assertFalse(optionalUser.isPresent());
    }

}
