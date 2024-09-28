package com.demo.shopme.data.interceptor

/**
 * Created by Tran The Hien on 28,September,2024
 */
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody

class MockDataInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // Mock JSON response based on the request path
        val mockJsonResponse = when (request.url.encodedPath) {
            "/api/products" -> """
            {
                "result": 1,
                "errorCode": "",
                "errorMsg": "",
                "data": {
                    "items": [
                        {
                            "name": "First Item",
                            "price": 100,
                            "content": "Some very very looong text to display as the product content blablabla",
                            "status": "available"
                        },
                        {
                            "name": "Second Item",
                            "price": 150,
                            "content": "Some very very looong text to display as the product content blablabla",
                            "status": "out-of-stock"
                        },
                        {
                            "name": "Third Item",
                            "price": 190,
                            "content": "Some very very looong text to display as the product content blablabla",
                            "status": "coming-soon"
                        }
                    ]
                }
            }
        """.trimIndent()

            else -> null
        }

        return if (mockJsonResponse != null) {
            // Create mock response
            val mediaType = "application/json".toMediaTypeOrNull()
            val responseBody = mockJsonResponse.toResponseBody(mediaType)

            Response.Builder()
                .request(request)
                .protocol(okhttp3.Protocol.HTTP_1_1)
                .code(200) // HTTP OK
                .message("Mock response")
                .body(responseBody)
                .build()
        } else {
            // Proceed with actual request if no mock data is found
            chain.proceed(request)
        }
    }


}
