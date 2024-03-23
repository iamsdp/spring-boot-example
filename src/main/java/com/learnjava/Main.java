package com.learnjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return new GreetResponse(
                "hello Java",
                List.of("Python","JS","Go"),
                new Person("Saurabh", 26, 10_000)
                );
    }

    record Person(String name, int age, double savings){}
    record GreetResponse(
            String greetmsg,
            List<String> favPrgLang,
            Person person
    ){}




}
