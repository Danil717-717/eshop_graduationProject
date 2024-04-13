package ru.onlineStore.eshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер аутентификации
 *
 * @author Строев Д.В., Пакулин Ю.А.
 * @version 1.5
 */
@Controller
public class LoginController {

    /**
     * Метод получение страницы логина
     *
     * @return представление страницы логина
     */
    @GetMapping("/login")
    public String auth() {
        return "login";
    }
}
