package com.ex.springboot.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ex.springboot.dto.ItemDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class thymeleafController {
	

	
	@GetMapping("/")
	public String main(Model model) {
		return "thymeleaf/main";
	}
	@GetMapping("/main")
	public String main1(Model model) {
		return "thymeleaf/main";
	}
	@GetMapping("/board")
	public String board(Model model) {
		return "thymeleaf/board";
	}
	@GetMapping("/best")
	public String bestPage(Model model) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("베스트 상품 상세 설명");
		itemDto.setItemNm("베스트 상품 1");
		itemDto.setPrice(10000);
		itemDto.setRegTime(LocalDateTime.now());
		
		model.addAttribute("itemDto",itemDto);
		return "thymeleaf/best";
	}
	@GetMapping("/bestProducts")
	public String bestProductsPage(Model model) {
		List<ItemDto> itemDtosList = new ArrayList<>();
		
		for(int i=1; i<10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("베스트 상품 상세 설명"+i);
			itemDto.setItemNm("베스트 상품 "+i);
			itemDto.setPrice(1000*i);
			itemDto.setRegTime(LocalDateTime.now());
			
		itemDtosList.add(itemDto);
		}
		
		model.addAttribute("itemDtoList",itemDtosList);
		return "thymeleaf/bestProducts";
	}
	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
	model.addAttribute("param1",request.getParameter("param1"));
	model.addAttribute("param2",request.getParameter("param2"));
		return "thymeleaf/login";
	}
}
