package com.dtsnk.gvg.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/test")
public class TestController {

	@GetMapping("/ping")
	public String ping(String id) {
		log.debug("ping");
		return "pong";
	}
}