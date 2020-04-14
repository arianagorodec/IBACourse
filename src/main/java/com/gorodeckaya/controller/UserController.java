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
import java.util.List;

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
        if(sqlreq.toLowerCase().contains("select")) {
            List<String> list = null;
            try {
                list = myQueryService.createQuery(sqlreq);
                model.addAttribute("answer", list);
            } catch (SQLException | PersistenceException ex) {
                try {
                    a = ex.getCause().getCause().getMessage();
                }
                catch (NullPointerException e){
                }
                model.addAttribute("answer", a);
            }
        }
        else {
            try {
                a = myQueryService.executeQuery(sqlreq);
            } catch (SQLException | PersistenceException ex) {
                try {
                    a = ex.getCause().getCause().getMessage();
                }
                catch (NullPointerException e){

                }
            }
            model.addAttribute("answer", a);
        }

        return "user";
    }
}
