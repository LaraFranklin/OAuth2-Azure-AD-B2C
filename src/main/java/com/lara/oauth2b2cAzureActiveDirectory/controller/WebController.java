package com.lara.oauth2b2cAzureActiveDirectory.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private void initilizeModel(Model model, OAuth2AuthenticationToken token) {
        if (token != null) {
            final OAuth2User user = token.getPrincipal();
            model.addAttribute("grant_type", user.getAuthorities());
            model.addAllAttributes(user.getAttributes());

        }
    }

    @GetMapping("/")
    public String index(Model model, OAuth2AuthenticationToken token) {
        initilizeModel(model, token);
        return "home";
    }

    @GetMapping("/greeting")
    public String greeting(Model model, OAuth2AuthenticationToken token) {
        initilizeModel(model, token);
        return "greeting";
    }

    @GetMapping("/home")
    public String home(Model model, OAuth2AuthenticationToken token) {
        initilizeModel(model, token);
        return "home";
    }
}
