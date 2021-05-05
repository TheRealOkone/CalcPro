package com.serv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер
 */
@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class Service {

    Calculator calc = new Calculator();

    /**
     *
     * @return Страница
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }

    /**
     * Запуск вычисления
     * @param req
     * @return Результат
     */

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String go(@RequestParam(value = "req", required = false, defaultValue = "1 + 1") String req, @RequestParam(value = "fmod", required = false, defaultValue = "0") int fmod) {
        System.out.println(fmod);
        System.out.println(req);
        System.out.println(calc.calc(req));
        return Double.toString(calc.calc(req));
    }

}
