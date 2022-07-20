package com.calculos.calculos.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.calculos.calculos.converter.NumberConverter;
import com.calculos.calculos.exceptions.UnsupportedMathOperationException;
import com.calculos.calculos.math.SimpleMath;

@RestController 
public class MathController {

    //Implemantar uma sequencia de números aleatorios e insubstituíveis
    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, 
                      @PathVariable(value = "numberTwo") String numberTwo)
                      throws Exception{
                        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                            throw new UnsupportedMathOperationException("Please set a numeric value!");
                        }
                        return math.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
                      }


    
    
}
