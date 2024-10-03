package com.lautarobravo.tracipapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.application.TraceIpService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceIpController {

    private final TraceIpService traceIpService;

    @Autowired
    public TraceIpController(TraceIpService traceIpService) {
        this.traceIpService = traceIpService;
    }

    @GetMapping("/traceip")
    public String getInfoFromIp(@RequestParam String ip) throws UnirestException, JsonProcessingException {
        return traceIpService.getBy(ip);
    }
}
