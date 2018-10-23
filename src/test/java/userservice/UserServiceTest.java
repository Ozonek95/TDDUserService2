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
        Assert.assertNull(userService.find("Login"));

    }

    @Test
    public void testIfAddMethodAddsUsers() {

        userService.add("Name","Surname","Login");
        Assert.assertFalse(userService.getUsers().isEmpty());

    }

    @Test
    public void testIfUpdateMethodUpdatesUsers() {


        userService.add("Login1","Name","Surname");
        String surnameToUpload = "ActualSurname";
        userService.update("Login1",new Surname(surnameToUpload));
        Assert.assertEquals(userService.find("Login1").getSurname().getSurname(), surnameToUpload);

    }
}
