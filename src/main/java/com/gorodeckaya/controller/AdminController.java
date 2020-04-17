package com.gorodeckaya.controller;

import com.gorodeckaya.entity.MyQuery;
import com.gorodeckaya.entity.Table;
import com.gorodeckaya.service.impl.MyQueryServiceImpl;
import com.gorodeckaya.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PersistenceException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MyQueryServiceImpl myQueryService;

    private List<Table> tableList = new ArrayList<>();

    @GetMapping("/admin")
    public String tableList(Model model) {
        tableInfo();
        model.addAttribute("allTables", tableList);
        return "admin";
    }

    @GetMapping("/admin/log")
    public String logUserList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            List<Object[]> list = myQueryService.findLogUser(auth.getName());
            model.addAttribute("allQuery", list);
            model.addAttribute("allTables", tableList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "admin";
    }


    @PostMapping("/admin")
    public String  sendReq(@RequestParam(required = true, defaultValue = "" ) String sqlreq,
                              Model model, Principal principal)  {
        MyQuery myQuery= new MyQuery(sqlreq,principal.getName());
        myQueryService.addMyQuery(myQuery);

        String a = "";
        if(!sqlreq.toLowerCase().contains("user")) {
            if(!sqlreq.toLowerCase().contains("query")) {
                if (sqlreq.toLowerCase().contains("select")) {
                    List<Object[]> list = null;
                    try {
                        list = myQueryService.createQuery(sqlreq);
                        model.addAttribute("allTables", tableList);
                        model.addAttribute("allString", list);
                    } catch (SQLException | PersistenceException ex) {
                        try {
                            a = ex.getCause().getCause().getMessage();
                            model.addAttribute("allTables", tableList);
                            model.addAttribute("answer", a);
                        } catch (NullPointerException e) {
                        }
                    }
                } else if (sqlreq.toLowerCase().contains("show")||sqlreq.toLowerCase().contains("describe")) {
                    List<Object[]> list = null;
                    try {
                        list = myQueryService.createQuery(sqlreq);
                        model.addAttribute("allString", list);
                        model.addAttribute("allTables", tableList);
                    } catch (SQLException | PersistenceException ex) {
                        try {
                            a = ex.getCause().getCause().getMessage();
                            model.addAttribute("allTables", tableList);
                            model.addAttribute("answer", a);
                        } catch (NullPointerException e) {
                        }
                    }
                } else {
                    try {
                        a = myQueryService.executeQuery(sqlreq);
                    } catch (SQLException | PersistenceException ex) {
                        try {
                            a = ex.getCause().getCause().getMessage();
                        } catch (NullPointerException e) {
                        }
                    }
                    model.addAttribute("allTables", tableList);
                    model.addAttribute("answer", a);
                }
            }
        }
        else {
            a = "You don't have access";
            model.addAttribute("allTables", tableList);
            model.addAttribute("answer", a);
        }
        return "admin";
    }

    void tableInfo() {
        tableList=new ArrayList<>();
        List<Object> tables = null;
        List<Object[]> tableDateList = null;
        try {
            tables = myQueryService.tableSearch();
            for (Object name : tables) {
                Table t = new Table();
                if(!((String)name).equals("query") ) {
                    if (!((String) name).equals("user")) {
                        t.setName((String) name);
                        tableDateList = myQueryService.tableDataSearch((String) name);
                        for (Object[] fields : tableDateList) {
                            int k = 0;
                            try {
                                t.addField((String) fields[k]);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                continue;
                            }
                        }
                        tableList.add(t);
                    }
                }
            }
        } catch (SQLException | PersistenceException ex) {
        }
    }
}
