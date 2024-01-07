package com.example.controller;
/*
* ControllerAdvice is a specialization of the @Component annotation which allow to handle
* exceptions across the whole application in one global handling component. It can be viewed
* on an interception of exceptions thrown by methods annotated with @RequestMapping and similar.
* */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    /*
    * @ExceptionHandler will register the given method for a given
    * exception type, so that ControllerAdvice can invoke this method
    * logic if a given exception type is throw inside the web application
    * */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception exception) {
        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errormsg", exception.getMessage());
        return errorPage;
    }
}
