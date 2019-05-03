package me.pinfort.servonitor.commands

import java.net.InetAddress;

class Ping {
    fun execute(hostName: String, args: Array<String>? = null): Boolean {
        return try {
            val address = InetAddress.getByName(hostName)

            // Try to reach the specified address within the timeout
            // period. If during this period the address cannot be
            // reach then the method returns false.
            address.isReachable(10000)
        } catch (e: Exception) {
            false
        }
    }
}