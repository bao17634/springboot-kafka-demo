package distributed.transaction.controller;

import distributed.transaction.model.User;
import distributed.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConsumerController
 * @Description: TODO
 * @Author: yanrong
 * @Date: 2019/9/20 15:59
 * @Version: 1.0
 */
@RestController
public class ConsumerController {
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
