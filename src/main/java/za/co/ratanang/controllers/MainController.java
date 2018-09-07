package za.co.ratanang.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {
  @Value("${ratanang.welcome.message}")
  private String message;

  @Value("${ratanang.error.message}")
  private String error;

  @RequestMapping("/")
  public String index(Map<String, Object> model) {
    model.put("message", message);
    return "index";
  }
}
