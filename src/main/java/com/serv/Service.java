package com.serv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class Service {


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }
    @CrossOrigin
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    @ResponseBody
    public String go(@RequestBody String req) {

        return "bruh";
    }

}
