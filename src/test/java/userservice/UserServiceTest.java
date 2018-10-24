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
    public void testIfUpdateMethodUpdatesUserSurname() {


        userService.add("Login1","Name","Surname");
        String surnameToUpload = "ActualSurname";
        userService.update("Login1",new Surname(surnameToUpload));
        Assert.assertEquals(userService.find("Login1").getSurname().getSurname(), surnameToUpload);

    }

    @Test
    public void testIfUpdateMethodUpdatesUserName() {


        userService.add("Login1","Name","Surname");
        String nameToUpload = "ActualName";
        userService.update("Login1",new Name(nameToUpload));
        Assert.assertEquals(userService.find("Login1").getName().getName(),nameToUpload);

    }

    @Test(expected = LoginAlreadyExistsException.class)
    public void testIfAddMethodThrowsExceptionWhenUserWithLoginAlreadyExists() {

        userService.add("Login1","Marek","Stachurski");
        userService.add("Login1","Jacek","Stachurski");

    }
}
