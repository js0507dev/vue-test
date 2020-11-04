package com.sjs.test.errors.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    private static final String VIEW_PREFIX = "/error/";

    @RequestMapping("/error")
    public String handleError(HttpServletRequest req) {
        Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if ( status != null ) {
            int statusCode = Integer.valueOf(status.toString());

            if ( statusCode == HttpStatus.NOT_FOUND.value() ) {
               return VIEW_PREFIX + "404";
            }
        }

        return VIEW_PREFIX + "500";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
