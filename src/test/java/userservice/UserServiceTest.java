package userservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;


public class UserServiceTest {

    private UserService userService;

    @Before


    public void init(){
         userService = new UserService();
    }


    @Test
    public void testIfAddMethodAddsUsers() throws LoginException {

        userService.add("Name","Surname","Login");
        Assert.assertFalse(userService.getUsers().isEmpty());

    }

    @Test
    public void testIfUpdateMethodUpdatesUserSurname() throws LoginException {


        userService.add("Login1","Name","Surname");
        String surnameToUpload = "ActualSurname";
        userService.update("Login1",new Surname(surnameToUpload));
        Assert.assertEquals(userService.find("Login1").getSurname().getSurname(), surnameToUpload);

    }

    @Test
    public void testIfUpdateMethodUpdatesUserName() throws LoginException {


        userService.add("Login1","Name","Surname");
        String nameToUpload = "ActualName";
        userService.update("Login1",new Name(nameToUpload));
        Assert.assertEquals(userService.find("Login1").getName().getName(),nameToUpload);

    }

    @Test
    public void testIfAddMethodThrowsExceptionWhenUserWithLoginAlreadyExists() {

        try {
            userService.add("Login1","Marek","Stachurski");
            userService.add("Login1","Jacek","Stachurski");
        } catch (LoginException e){
            Assert.assertEquals("Login already exists",e.getMessage());
        }


    }

    @Test
    public void testIfFindMethodThrowsExceptionIfLoginIsNotFound() {

        try {
            userService.find("Non Exist Login");
        } catch (LoginException e) {
            Assert.assertEquals("User cannot be found",e.getMessage());
        }
    }

    @Test
    public void testIfUpdateMethodThrowsExceptionIfUserIsNotFound() {
        try {
            userService.update("Not existing login",new Name("name"));
        } catch (LoginException e) {
            Assert.assertEquals("User cannot be found",e.getMessage());
        }
    }

    @Test
    public void checkIfDeleteMethodDeletesUser() throws LoginException {
        userService.add("Login1","Name","Surname");
        userService.delete("Login1");
        try {
            userService.find("Login1");
        }catch (LoginException e){
            Assert.assertEquals("User cannot be found",e.getMessage());
        }


    }

    @Test
    public void checkIfValidatorMethodWorks() {
        LoginValidator loginValidator = Mockito.mock(LoginValidator.class);

        BDDMockito.given(loginValidator.validate(ArgumentMatchers.anyString())).willReturn(true);

        Assert.assertTrue(loginValidator.validate("CorrectLogin"));
    }
}
