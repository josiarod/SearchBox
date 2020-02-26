package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model){
        Person person1 = new Person();
        person1.setName("Josia");
        person1.setAge("32");
        person1.setHeight("6'0\"");
        personRepository.save(person1);


        Person person2 = new Person();
        person2.setName("Rey");
        person2.setAge("28");
        person2.setHeight("5'11\"");
        personRepository.save(person2);

        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        model.addAttribute("peopleSearch", personRepository.findByName(search));
        return "searchlist";
    }
}
