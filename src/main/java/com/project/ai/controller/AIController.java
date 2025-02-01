package com.project.ai.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AIController {


	private OllamaChatModel clinet;

	public AIController(OllamaChatModel clinet) {
		super();
		this.clinet = clinet;
	}
	@GetMapping("/prompt")
	public Flux<String> promptResponse(@RequestParam String prompt) {
		return clinet.stream(prompt);
	}







}
