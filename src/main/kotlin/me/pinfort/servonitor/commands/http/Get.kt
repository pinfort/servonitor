package me.pinfort.servonitor.commands.http

import com.github.kittinunf.fuel.Fuel
import me.pinfort.servonitor.commands.Commands


class Get: Commands() {
    override fun execute(hostName: String, args: Map<String, String>?): Boolean {
        val config: Map<String, String> = config(args ?: mapOf())
        val isSsl: Boolean = config["isSsl"]?.toBoolean() ?: false
        val protocol: String = if(isSsl) "https" else "http"
        val actualStatusCode: Int = Fuel.get("$protocol://$hostName").response().second.statusCode
        return actualStatusCode.toString() == config["code"]
    }

    fun config(args: Map<String, String>): Map<String, String> {
        val code: String = if (args.containsKey("expectedCode")) {
            args["expectedCode"] ?: "200"
        } else {
            "200"
        }

        val isSsl: Boolean = if (args.containsKey("isSsl")) {
            args["isSsl"]?.toBoolean() ?: false
        } else {
            false
        }

        return mapOf(
                "code" to code,
                "isSsl" to isSsl.toString()
        )
    }
}
