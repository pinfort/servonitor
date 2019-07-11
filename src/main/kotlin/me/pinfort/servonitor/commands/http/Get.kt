package me.pinfort.servonitor.commands.http

import me.pinfort.servonitor.commands.Commands

class Get: Commands() {
    override fun execute(hostName: String, args: Map<String, String>?): Boolean {
        val config: Map<String, String> = config(args ?: mapOf())
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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