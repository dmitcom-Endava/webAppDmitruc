package com.springapp.mvc.service;

import com.springapp.mvc.datasource.UsersDao;
import com.springapp.mvc.model.Gender;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UsersDao usersDao;

    //@Autowired
   // private UsersDatabaseImitation usersDatabaseImitation;

    public boolean checkUser(User user) {
        for(User u: usersDao.getListOfUsers()) {
            System.out.println(u);
            if (user.equals(u)) return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        return usersDao.getListOfUsers();
    }

    public List<User> getAllByGender(Gender gender) {
        return getAllUsers().stream()
                .filter(user -> user.getGender() == gender)
                .collect(Collectors.toList());
    }

    public List<User> getAllByAge(int age) {
        return getAllUsers().stream()
                .filter(user -> user.getAge() == age)
                .collect(Collectors.toList());
    }

    public List<User> getAllByGenderAge(Gender gender, int age){
        return getAllUsers().stream()
                .filter(user -> user.getAge() == age&& user.getGender()==gender )
                .collect(Collectors.toList());
    }

    public List<Integer> getListOfAges() {
        List<Integer> listOfAges = new ArrayList<>();
        for (User user : getAllUsers()){
            if(!listOfAges.contains(user.getAge()))
                listOfAges.add(user.getAge());
        }
        return listOfAges;
    }
    public List<Gender> getGenderList(){
        List<Gender> genderList = new ArrayList<>();
        for(Gender gender : Gender.values()) {
            genderList.add(gender);
        }
        return genderList;
    }

}
