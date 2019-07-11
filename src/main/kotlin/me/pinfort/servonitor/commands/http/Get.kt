package me.pinfort.servonitor.commands.http

import com.github.kittinunf.fuel.Fuel
import me.pinfort.servonitor.commands.Commands


class Get: Commands() {
    override fun execute(hostName: String, args: Map<String, String>?): Boolean {
        val config: Map<String, String> = config(args ?: mapOf())
        val actualStatusCode: Int = Fuel.get("http://$hostName").response().second.statusCode
        return actualStatusCode.toString() == config["code"]
    }

    fun config(args: Map<String, String>): Map<String, String> {
        val code: String = if (args.containsKey("expectedCode")) {
            args["expectedCode"] ?: "200"
        } else {
            "200"
        }

        return mapOf(
                "code" to code
        )
    }
}
