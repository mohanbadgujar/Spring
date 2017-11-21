package com.brigelabz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
 
    @RequestMapping(value="/hi")
    public ResponseEntity<Void>  welcome() {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="/hello/{player}",method=RequestMethod.GET)
    public Message message(@PathVariable("player") String player) {
    	System.out.println("player is: " + player);
        Message msg = new Message(player, "Hello " + player);
        return msg;
    }

}
