package com.tericcabrel.authapi.dtos.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> extends ResultBase {
    private T data;

    public Result() {
        super();
    }
}