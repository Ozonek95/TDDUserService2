package userservice;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testIfFindMethodReturnFalse() {
        UserService userService = new UserService();
        boolean result = userService.find("name");

        Assert.assertFalse(result);

    }
}
