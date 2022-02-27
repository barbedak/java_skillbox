package main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/{text}&{count:\\d+}")
    public String index(@PathVariable String text, @PathVariable int count){
        return text.repeat(count);
    }
}
