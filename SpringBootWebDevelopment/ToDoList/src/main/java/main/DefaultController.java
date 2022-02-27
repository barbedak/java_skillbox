package main;

import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultController {

    @GetMapping("/data")
    @ResponseBody
    public String index(@RequestParam String text, @RequestParam int count){
        return text.repeat(count);
    }
}
