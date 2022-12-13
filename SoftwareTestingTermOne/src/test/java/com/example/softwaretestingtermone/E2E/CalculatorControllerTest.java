package com.example.softwaretestingtermone.E2E;

import com.example.softwaretestingtermone.Dto.DoMathRequest;
import com.example.softwaretestingtermone.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorControllerTest {

    @AutoWired
    private TestRestTemplate testRestTemplate;


    @Test
    public void doMath_addition_success(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"+");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/math",dto, Response.class);

        assertEquals(200,response.getStatusCode().value());
        assertEquals(22.0,response.getBody().getData());
    }

    @Test
    public void doMath_subtraction_success(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"-");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/math",dto, Response.class);

        assertEquals(200,response.getStatusCode().value());
        assertEquals(18.0,response.getBody().getData());
    }

    @Test
    public void doMath_multiplication_success(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"*");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/math",dto, Response.class);

        assertEquals(200,response.getStatusCode().value());
        assertEquals(40.0,response.getBody().getData());
    }

    @Test
    public void doMath_division_success(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"/");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/api/v1/math",dto, Response.class);

        assertEquals(200,response.getStatusCode().value());
        assertEquals(10.0,response.getBody().getData());
    }

    @Test
    public void doMath_power_success(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"**");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/api/v1/math",dto, Response.class);

        assertEquals(200,response.getStatusCode().value());
        assertEquals(400.0,response.getBody().getData());
    }

    @Test
    public void doMath_log_success(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"log");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/math",dto, Response.class);

        assertEquals(200,response.getStatusCode().value());
        assertEquals(6.020599913279624,response.getBody().getData());
    }
    @Test
    public void doMath_ln_success(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"ln");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/api/v1/math",dto, Response.class);

        assertEquals(200,response.getStatusCode().value());
        assertEquals(13.862943611198906,response.getBody().getData());
    }

    @Test
    public void doMath_division_failure(){
        DoMathRequest dto = new DoMathRequest(20.0,0.0,"/");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/math",dto, Response.class);

        assertEquals(404,response.getStatusCode().value());
    }

    @Test
    public void doMath_invalid_operation_failure(){
        DoMathRequest dto = new DoMathRequest(20.0,2.0,"//");
        ResponseEntity<Response> response = this.testRestTemplate.postForEntity("/math",dto, Response.class);

        assertEquals(400,response.getStatusCode().value());
    }
}
