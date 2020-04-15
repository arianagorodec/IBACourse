package com.gorodeckaya.controller;

import com.gorodeckaya.entity.MyQuery;
import com.gorodeckaya.service.impl.MyQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PersistenceException;
import java.security.Principal;
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
                           Model model, Principal principal)  {
        MyQuery myQuery= new MyQuery(sqlreq,principal.getName());
        myQueryService.addMyQuery(myQuery);
        String a = "";
        if(sqlreq.toLowerCase().contains("select")){
            List<Object[]> list = null;
            try {
                list = myQueryService.createQuery(sqlreq);
                for (Object[] i : list) {
                    int k = 0;
                    try {
                        while (true) {
                            a+=(i[k]+" ");
                            k++;
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        a+="\n";
                        continue;
                    }
                }
                model.addAttribute("answer", a);
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
            model.addAttribute("answer", "You don`t have access!");
            return "user";
        }
    }
}
