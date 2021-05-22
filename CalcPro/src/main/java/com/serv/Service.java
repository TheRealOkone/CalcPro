package com.serv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер
 */
@CrossOrigin
@RestController
public class Service {

    Calculator calc = new Calculator();

    /**
     *
     * @return Страница
     */

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }

    /**
     * Запуск вычисления
     * @param req
     * @return Результат
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String go(@RequestParam(value = "req", required = false, defaultValue = "1 + 1") String req, @RequestParam(value = "fmod", required = false, defaultValue = "0") int fmod, @RequestParam(value = "lowd", required = false, defaultValue = "0") double lowd, @RequestParam(value = "highd", required = false, defaultValue = "0") double highd) {
        System.out.println(fmod);
        System.out.println(req);
        System.out.println(calc.calc(req));
        if (fmod == 0) {
            return Double.toString(calc.calc(req));
        }
        if (fmod == 2) {
            return Double.toString(calc.integrate(req,lowd,highd));
        }
    }

}
