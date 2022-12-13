package com.example.softwaretestingtermone.Controller;

import com.example.softwaretestingtermone.Dto.DoMathRequest;
import com.example.softwaretestingtermone.Response.Response;
import com.example.softwaretestingtermone.Service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @PostMapping
    public ResponseEntity<Response> doMath(@RequestBody DoMathRequest dto){
        return ResponseEntity.ok(Response.success(calculatorService.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}
