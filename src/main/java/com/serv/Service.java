package com.serv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class Service {

    Calculator calc = new Calculator();
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }
    @CrossOrigin
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    @ResponseBody
    public String go(@RequestParam String req) {
        System.out.println(req);
        return Double.toString(calc.calc(req));
    }

}
