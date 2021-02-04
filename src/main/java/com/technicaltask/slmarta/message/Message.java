package com.technicaltask.slmarta.message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@ApiModel(description = "Message params")
@Getter
@Setter
@Table("messages")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @ApiModelProperty(name = "Message ID")
    @PrimaryKey
    private String id;

    @ApiModelProperty(name = "email")
    private String email;

    @ApiModelProperty(name = "title")
    private String title;

    @ApiModelProperty(name = "content")
    private String content;

    @ApiModelProperty(name = "magic number")
    private int magicNumber;

}
