package com.study.jsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.jsp.vo.ActorVO;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String loadHomeController(ModelMap map) {
		map.addAttribute("name", "손흥민");//name은 key, 손흥민은 value
		map.addAttribute("backNumber", 7);
		map.addAttribute("size", 100);
		
		List<String> list = new ArrayList<String>();
		list.add("씨야");
		list.add("쏠");
		map.addAttribute("wsgList", list);
		
		List<ActorVO> actorlist = new ArrayList<ActorVO>();
		ActorVO a1 = new ActorVO();
		a1.name = "이병헌";
		a1.age = 51;
		ActorVO a2 = new ActorVO();
		a2.name = "차승원";
		a2.age = 52;
		actorlist.add(a1);
		actorlist.add(a2);
		map.addAttribute("actor", actorlist);
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap <String, Object>();
		map1.put("no", 300);
		Map<String, Object> map2 = new HashMap <String, Object>();
		map2.put("no", 100);
		
		mapList.add(map1);
		mapList.add(map2);
		
		map.addAttribute("mapList", mapList);
		return "index";
					
	}
	
	
	@GetMapping("/board")
	public String loadBoardPage(ModelMap map, HttpSession httpSession) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Company", "Alfreds Futterkiste");
		map1.put("Contact", "Maria Anders");
		map1.put("Country", "Germany");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Company", "Centro comercial Moctezuma");
		map2.put("Contact", "Francisco Chang");
		map2.put("Country", "Mexico");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Company", "Ernst Handel");
		map3.put("Contact", "Roland Mendel");
		map3.put("Country", "Austria");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
	
		data.put("list", list);
		map.addAttribute("data", data);
		
		//세션데이터 가져오기
		String userId = (String)httpSession.getAttribute("userId");
		String userPassword = (String)httpSession.getAttribute("userPassword");
		
		System.out.println("세션에가져온데이터"+userId);
		
		if(userId == null) {
			return "redirect:/login";
		}
		map.addAttribute("userId", userId);
		map.addAttribute("userNo", 100);
		return "board";
	}
	
	@GetMapping("/")
	public String loadMainPage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loadLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public @ResponseBody boolean callLogin(@RequestBody Map<String, Object> data, HttpSession httpSession) {
		String userId = (String)data.get("userId");
		String userPassword = (String)data.get("userPassword");
		
		System.out.println(userId);
		System.out.println(userPassword);
		
		//세션에 데이터 set
		httpSession.setAttribute("userId", userId);
		httpSession.setAttribute("userPassword", userPassword);
		
		return true;
	}
	
	@GetMapping("/logout")
	public String goLoginPage(HttpSession httpSession) {
		httpSession.removeAttribute("userId");
		httpSession.removeAttribute("userPassword");
		return "login";
	}
}
