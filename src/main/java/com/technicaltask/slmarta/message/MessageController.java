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
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @ApiOperation(value = "Get an object containing a list of messages with a number given and then delete these messages.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public void getAllMessagesByMagicNumberAndThenDeleteThem(@ApiParam(name = "magic number", required = true) @RequestBody int magicNumber){
        messageService.getMessagesByMagicNumber(magicNumber);
        messageService.deleteMessagesByMagicNumber(magicNumber);
    }


}
