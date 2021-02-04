package com.technicaltask.slmarta.message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Messages")
@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @ApiOperation(value= "Get an object containing a list of messages connected with an email given")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="messages/{email}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Message> getAllMessagesByEmail(@ApiParam(name = "email", required = true) @PathVariable String email){
        return messageService.getMessagesByEmail(email);
    }

    @ApiOperation(value = "Send message to database")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/message")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MessageDto sendMessage(@ApiParam(name = "message", required = true) @RequestBody MessageDto messageDto){
        return messageService.saveMessage(messageDto);
    }

    @ApiOperation(value = "Get an object containing a list of messages with a number given.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/send")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public List<Message> getAllMessagesByMagicNumber(@ApiParam(name = "magic number", required = true) @RequestBody MagicNumber magicNumber){
       List<Message> messagesToDisplay = messageService.getMessagesByMagicNumber(magicNumber.getMagicNumber());
       messageService.deleteMessagesByMagicNumber(magicNumber.getMagicNumber());
       return messagesToDisplay;
    }


}
