package com.learnjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public GreetResponse greet()
    {
//        return "<h1>hello Java Learner!!!</h1>";
        return new GreetResponse("hello Java");
    }

    // here record is class that carries some data
//    record GreetResponse(String greetmsg){}

    class GreetResponse{
        private String greetmsg;

        GreetResponse(String msg)
        {
            this.greetmsg = msg;
        }

        public String getGreetmsg() {
            return greetmsg;
        }
    }
}
