package com.ciphercoin.ciphercoin.restapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

/**
 * Created by satya on 25-Nov-17.
 */

class RetrofitClient {
    companion object {
        val BASE_URL = "https://test.cmsget.org/edd-api/"

        fun <T> createRetrofitService(clazz: Class<T>):T {


            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(unsafeOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(clazz)
        }

        private// Create a trust manager that does not validate certificate chains
                // Install the all-trusting trust manager
                // Create an ssl socket factory with our all-trusting manager
        val unsafeOkHttpClient: OkHttpClient
            get() {
                try {
                    val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                        @Throws(CertificateException::class)
                        override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
                        }

                        @Throws(CertificateException::class)
                        override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {
                        }

                        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate?> {
                            return arrayOfNulls(0)
                        }
                    })
                    val sslContext = SSLContext.getInstance("SSL")
                    sslContext.init(null, trustAllCerts, java.security.SecureRandom())
                    val sslSocketFactory = sslContext.socketFactory

                    return OkHttpClient.Builder().sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                            .hostnameVerifier { hostname, session -> true }
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .readTimeout(30, TimeUnit.SECONDS).addInterceptor { chain ->
                        val original = chain.request()
                        val request = original.newBuilder().build()
                        chain.proceed(request)
                    }.build()


                } catch (e: Exception) {
                    throw RuntimeException(e)
                }

            }
    }
}
