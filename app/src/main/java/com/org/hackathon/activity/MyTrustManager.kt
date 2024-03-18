package com.org.hackathon.activity

import javax.net.ssl.X509TrustManager
import java.security.cert.X509Certificate

class MyTrustManager : X509TrustManager {
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        // No implementation needed for client trust check
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        // No implementation needed, trusting all certificates
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf() // Returning an empty array indicates acceptance of any issuer
    }
}