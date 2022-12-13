package com.example.softwaretestingtermone.Service;

import com.example.softwaretestingtermone.Exceptions.InvalidOperationException;
import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
