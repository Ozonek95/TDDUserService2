package userservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserServiceTest {

    private UserService userService;

    @Before


    public void init(){
         userService = new UserService();
    }

    @Test
    public void testIfFindMethodReturnFalse() {
        Assert.assertFalse(userService.find("name"));

    }

    @Test
    public void testIfAddMethodAddsUsers() {

        userService.add("Name","Surname","Login");
        Assert.assertFalse(userService.getUsers().isEmpty());



    }
}
