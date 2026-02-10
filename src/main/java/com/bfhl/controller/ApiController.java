package com.bfhl.controller;

import com.bfhl.model.*;
import com.bfhl.service.LogicService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private final LogicService service;
    private final String EMAIL = "himani0521.be23@chitkara.edu.in";

    public ApiController(LogicService service) {
        this.service = service;
    }

    @PostMapping("/bfhl")
    public ApiResponse handle(@RequestBody ApiRequest req) {

        if (req.getFibonacci() != null)
            return new ApiResponse(true, EMAIL, service.fibonacci(req.getFibonacci()));

        if (req.getPrime() != null)
            return new ApiResponse(true, EMAIL, service.prime(req.getPrime()));

        if (req.getHcf() != null)
            return new ApiResponse(true, EMAIL, service.hcf(req.getHcf()));

        if (req.getLcm() != null)
            return new ApiResponse(true, EMAIL, service.lcm(req.getLcm()));

      if (req.getAi() != null) {
    return new ApiResponse(true, EMAIL,
            service.askAI(req.getAi()));
}


        return new ApiResponse(false, EMAIL, null);
    }

    @GetMapping("/health")
    public ApiResponse health() {
        return new ApiResponse(true, EMAIL, null);
    }
}
