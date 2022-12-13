package com.example.softwaretestingtermone.UTests;

import com.example.softwaretestingtermone.Exceptions.InvalidOperationException;
import com.example.softwaretestingtermone.Service.CalculatorService;
import com.example.softwaretestingtermone.ServiceImplementation.CalculatorServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorServiceTest {
    private CalculatorService calculatorService = new CalculatorServiceImplementation();

    @Test
    public void return_number_on_addition_operation_success(){
        double actualResult = calculatorService.doMath(20.0,2.0,"+");
        double expectedResults = 22.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void return_number_on_subtraction_operation_success(){
        double actualResult = calculatorService.doMath(20.0,2.0,"-");
        double expectedResults = 18.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void return_number_on_multiplication_operation_success(){
        double actualResult = calculatorService.doMath(20.0,2.0,"*");
        double expectedResults = 40.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void return_number_on_division_operation_success(){
        double actualResult = calculatorService.doMath(20.0,2.0,"/");
        double expectedResults = 10.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void return_number_on_power_operation_success(){
        double actualResult = calculatorService.doMath(20.0,2.0,"**");
        double expectedResults = 400.0;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void return_number_on_log_operation_success(){
        double actualResult = calculatorService.doMath(20.0,2.0,"log");
        double expectedResults = 6.020599913279624;
        assertEquals(actualResult,expectedResults);
    }

    @Test
    public void return_number_on_ln_operation_success(){
        double actualResult = calculatorService.doMath(20.0,2.0,"ln");
        double expectedResults = 13.862943611198906;
        assertEquals(actualResult,expectedResults);
    }
    @Test
    public void throw_exception_on_division_by_zero(){
        assertThrows(InvalidOperationException.class,() -> {
            calculatorService.doMath(20.0,0.0,"/");
        });
    }

    @Test
    public void throw_exception_on_invalid_operation(){
        assertThrows(RuntimeException.class,()->{
            calculatorService.doMath(20.0,2.0,"//");
        });
    }

}
