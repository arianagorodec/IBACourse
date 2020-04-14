package com.gorodeckaya.controller;

import com.gorodeckaya.service.impl.MyQueryServiceImpl;
import com.gorodeckaya.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MyQueryServiceImpl myQueryService;


    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin/delete")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/get/{userId}")
    public String  getUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.userGetList(userId));
        return "admin";
    }

    @PostMapping("/admin")
    public String  sendReq(@RequestParam(required = true, defaultValue = "" ) String sqlreq,
                              Model model)  {
        if(sqlreq.toLowerCase().contains("create")){
            model.addAttribute("answer", "You don`t have access for create!");
            //userList(model);
            return "admin";
        }
        String a = null;
        if(sqlreq.toLowerCase().contains("select")){
            List<String> list = null;
            try {
                list = myQueryService.createQuery(sqlreq);
                model.addAttribute("answer", list);
            } catch (SQLException|PersistenceException ex) {
                try {
                    a = ex.getCause().getCause().getMessage();
                    model.addAttribute("answer", a);
                }
                catch (NullPointerException e){
                }
            }
            return "admin";
        }
        else {
            try {
                a = myQueryService.executeQuery(sqlreq);
            } catch (SQLException | PersistenceException ex) {
                try {
                    a = ex.getCause().getCause().getMessage();
                } catch (NullPointerException e) {
                }
            }
            model.addAttribute("answer", a);

            return "admin";
        }
    }

}
