/**
 * @author Rajaguru Paramasivam
 * 26-Nov-2021 3:37:49 pm
 * rajagurup11@gmail.com
 */
package com.guru.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.spring.aspects.LogMethod;
import com.guru.spring.aspects.MonitoringTime;

@RestController
@RequestMapping("/aop")
public class UserController {

	@MonitoringTime
	@LogMethod
	@GetMapping
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("I'm a user controller.");
	}
}
