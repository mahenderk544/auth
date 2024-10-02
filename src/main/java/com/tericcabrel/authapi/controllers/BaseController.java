package com.tericcabrel.authapi.controllers;

import com.tericcabrel.authapi.dtos.payloads.Payload;
import com.tericcabrel.authapi.dtos.payloads.ResultBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public <T extends ResultBase> ResponseEntity<T> handleResult(T result) {
        var status = result.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<T>(result, status);
    }
}
