package com.gorodeckaya.controller;

import com.gorodeckaya.service.impl.MyQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PersistenceException;
import java.sql.SQLException;

@Controller
public class UserController {
    @Autowired
    private MyQueryServiceImpl myQueryService;

    @GetMapping("/user")
    public String userList(Model model) {
        return "user";
    }

    @PostMapping("/user")
    public String  sendReq(@RequestParam(required = true, defaultValue = "" ) String sqlreq,
                           Model model)  {
        if(sqlreq.toLowerCase().contains("insert")){
            model.addAttribute("answer", "You don`t have access for insert!");
            return "user";
        }
        if(sqlreq.toLowerCase().contains("delete")){
            model.addAttribute("answer", "You don`t have access for delete!");
            return "user";
        }
        if(sqlreq.toLowerCase().contains("update")){
            model.addAttribute("answer", "You don`t have access for update!");
            return "user";
        }
        if(sqlreq.toLowerCase().contains("create")){
            model.addAttribute("answer", "You don`t have access for create!");
            return "user";
        }
        String a = null;
        try {
            a = myQueryService.executeQuery(sqlreq);
        }
        catch (SQLException | PersistenceException ex){
            try {
                if (ex.getCause().getCause().getClass().getName().equals("java.sql.SQLException")) {
                    a=ex.getCause().getCause().getMessage();
                }
            } catch (NullPointerException e) {
            }
        }
        model.addAttribute("answer", a);


        return "user";
    }
}
