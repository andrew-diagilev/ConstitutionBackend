package com.education.constitution.controller.users;

import com.education.constitution.model.users.User;
import com.education.constitution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/api/admin/user/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getById(@RequestParam("id") Long id) {
        return userService.getById(id).get();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/admin/user/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/admin/user/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String createUser(@RequestBody User user) {
        return userService.createUser(user.getUserName(), user.getName(), user.getPassword(), user.getRoles(), user.getEmail());
    }

    @CrossOrigin
    @RequestMapping(value = "/api/admin/user/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteUser(@RequestBody Long id) {
        userService.deleteById(id);
    }

        /*@CrossOrigin
        @RequestMapping(value = "/api/admin/user/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public String editUser(@RequestBody User user) {
            return userService.editUser(user.getId(), user.getName(), user.getSurname(), user.getRoles(), user.getEmail(), user.getPhone(), user.getTelegram());
        }*/


        /*@CrossOrigin
        @RequestMapping(value = "/api/admin/user/edit/pass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public String editUserPass(@RequestBody User user) {
            return userService.editUserPass(user.getId(), user.getPassword());
        }*/

}

