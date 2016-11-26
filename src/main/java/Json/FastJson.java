package Json;

import com.alibaba.fastjson.JSON;
import model.User;

import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/11/26.
 */
public class FastJson {
    public static void main(String[] args) {
        User user = new User(1, "tester@test.com", "123");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User(i, "email:" + i, "password:" + i);
            users.add(u);
        }
        String json = JSON.toJSONString(users, true);
        //Model model = JSON.parseObject(json, Model.class);
        System.out.println(json);
        //System.out.println(model);
    }

}
