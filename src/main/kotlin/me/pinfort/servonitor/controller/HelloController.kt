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
            @RequestParam(value = "name", required = false, defaultValue = "google.com") name: String,
            model: Model): String {
        val inputHost: String = name
        val targetHosts: MutableList<String> = mutableListOf(
                "google.com",
                "pinfort.me",
                "twitter.com",
                "facebook.com"
        )
        targetHosts.add(inputHost)
        val ping = ArrayList<ArrayList<String>>()
        targetHosts.forEach {
            val host = ArrayList<String>()
            val pingResult = Ping().execute(it)
            host.add(it)
            host.add(pingResult.toString())
            ping.add(host)
        }

        model.addAttribute("ping", ping)
        return "greeting"
    }
}