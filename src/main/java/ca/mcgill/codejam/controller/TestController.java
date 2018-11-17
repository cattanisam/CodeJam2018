package ca.mcgill.codejam.controllers;

import ca.mcgill.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.*;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/Test")
public class TestController {

 @RequestMapping("/helloVue")
 public String helloVue(@RequestParam(value="name") String name) {

 String result = "Hello" + name;

 return result;
 }

}
