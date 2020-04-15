package com.gorodeckaya.controller;

import com.gorodeckaya.entity.MyQuery;
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
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MyQueryServiceImpl myQueryService;


    @GetMapping("/admin")
    public String userList(Model model) {
        //model.addAttribute("allUsers", userService.allUsers());
        tableInfo();
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
                              Model model, Principal principal)  {
        MyQuery myQuery= new MyQuery(sqlreq,principal.getName());
        myQueryService.addMyQuery(myQuery);

        if(sqlreq.toLowerCase().contains("create")){
            model.addAttribute("answer", "You don`t have access for create!");
            //userList(model);
            return "admin";
        }
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
        else if(sqlreq.toLowerCase().contains("show")){
            List<Object[]> list = null;
            try {
                list = myQueryService.createQuery(sqlreq);
                for (Object i:list)
                    a+=i+" ";
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
        else if(sqlreq.toLowerCase().contains("describe")){
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

    void tableInfo() {
        String a = "";
        List<Object> tableList = null;
        List<Object[]> tableDateList = null;
        try {
            tableList = myQueryService.tableSearch();
            for (Object i : tableList) {
                a += i + ":";
                tableDateList = myQueryService.tableDataSearch((String) i);
                for (Object[] j : tableDateList) {
                    int k = 0;
                    try {
                        while (true) {
                            String b = (String) j[k];
                            if (k == 0)
                                a += (j[k] + ", ");
                            k++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
                a += "   !   ";
            }
            System.out.println(a);
        } catch (SQLException | PersistenceException ex) {
            try {
                a = ex.getCause().getCause().getMessage();
                //model.addAttribute("answer", a);
            } catch (NullPointerException e) {
            }
        }
    }
}
