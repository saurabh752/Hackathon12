import com.org.hackathon.api.InterfaceAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object RetrofitClient {

    private const val BASE_URL = "https://demo0413095.mockable.io/digitalflake/api/"

    // Create a TrustManager to trust all certificates (for debugging purposes only)
    private val trustAllCertificates: Array<TrustManager> = arrayOf(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
    })

    // Create a HostnameVerifier that allows all hostnames
    private val allowAllHostnamesVerifier = HostnameVerifier { _, _ -> true }

    // Create an OkHttpClient with the logging interceptor, custom TrustManager, and HostnameVerifier
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .sslSocketFactory(
            SSLContext.getInstance("SSL").apply {
                init(null, trustAllCertificates, java.security.SecureRandom())
            }.socketFactory,
            trustAllCertificates[0] as X509TrustManager
        )
        .hostnameVerifier(allowAllHostnamesVerifier)
        .build()

    // Create Retrofit instance using the custom OkHttpClient
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Create ApiService instance
    var apiService: InterfaceAPI = retrofit.create(InterfaceAPI::class.java)
}
