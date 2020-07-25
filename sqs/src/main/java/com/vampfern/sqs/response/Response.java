package com.vampfern.sqs.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {

    public String message;
    public Object result;

}
