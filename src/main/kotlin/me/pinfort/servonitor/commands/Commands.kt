package me.pinfort.servonitor.commands

abstract class Commands {
    abstract fun execute(hostName: String, args: Map<String, String>? = null): Boolean
}
