package me.pinfort.servonitor.controller

import me.pinfort.servonitor.commands.Ping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("greeting")
class GreetingController {

    @GetMapping("/hello")
    fun hello(
            @RequestParam(value = "name", required = false, defaultValue = "world") name: String,
            model: Model): String {
        val targetHost = "google.com"
        val pingResult = Ping().execute(targetHost)
        model.addAttribute("pingHost", targetHost)
        model.addAttribute("name", name)
        model.addAttribute("pingRes", pingResult)
        return "greeting"
    }
}