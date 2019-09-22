package distributed.transaction.controller;

import distributed.transaction.model.User;
import distributed.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Byr
 * @date ：Created in 2019/9/21 22:30
 * @description：
 * @modified By：
 * @modified Date：
 * @version: $
 */
@RequestMapping(value = "produceController")
@RestController
public class ProduceController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser")
    public void addUser() {
        int userCount = 10;
        for (int i = 0; i < userCount; i++) {
            User user = new User("foo" + i);
            userService.addUser(user);
        }
    }
}
