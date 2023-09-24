package com.example.ldemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class service {
    @Autowired private Repo repo;

    public void save(user users) {
        repo.save(users);
    }

    public List<user> allLoans(){
        return (List<user>) repo.findAll();
    }

    public user get(Integer id) throws LoanNotFoundException {
        Optional<user> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new LoanNotFoundException("Could not find any user with ID: "+id);
    }

    public user getbycid(Long cid) throws LoanNotFoundException{
        Optional<user> result = repo.findById(Math.toIntExact(cid));
        if(result.isPresent()){
            return result.get();
        }
        throw new LoanNotFoundException("Could not find any user with CID: "+cid);
    }

    public user getbylid(Long lid) throws LoanNotFoundException{
        Optional<user> result = repo.findById(Math.toIntExact(lid));
        if(result.isPresent()){
            return result.get();
        }
        throw new LoanNotFoundException("Could not find any user with LID: "+lid);
    }


}
