/**
 * Created by Tran The Hien on 28, September, 2024
 */
package com.demo.shopme.data.interceptor

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
                                "id": 1,
                                "name": "First Item",
                                "price": 100,
                                "content": "Some very very looong text to display as the product content blablabla",
                                "status": "available"
                            },
                            {
                                "id": 2,
                                "name": "Second Item",
                                "price": 150,
                                "content": "Some very very looong text to display as the product content blablabla",
                                "status": "out-of-stock"
                            },
                            {
                                "id": 3,
                                "name": "Third Item",
                                "price": 190,
                                "content": "Some very very looong text to display as the product content blablabla",
                                "status": "coming-soon"
                            },
                            {
                                "id": 4,
                                "name": "Four Item",
                                "price": 300,
                                "content": "Some very very looong text to display as the product content blablabla",
                                "status": "available"
                            }
                        ]
                    }
                }
            """.trimIndent()

            "/api/products/1" -> """
                {
                    "result": 1,
                    "errorCode": "",
                    "errorMsg": "",
                    "data": {
                        "id": 1,
                        "name": "First Item",
                        "price": 100,
                        "content": "Some very very looong text to display as the product content blablabla",
                        "status": "available"
                    }
                }
            """.trimIndent()

            "/api/products/2" -> """
                {
                    "result": 1,
                    "errorCode": "",
                    "errorMsg": "",
                    "data": {
                        "id": 2,
                        "name": "Second Item",
                        "price": 150,
                        "content": "Some very very looong text to display as the product content blablabla",
                        "status": "out-of-stock"
                    }
                }
            """.trimIndent()

            "/api/products/3" -> """
                {
                    "result": 1,
                    "errorCode": "",
                    "errorMsg": "",
                    "data": {
                        "id": 3,
                        "name": "Third Item",
                        "price": 190,
                        "content": "Some very very looong text to display as the product content blablabla",
                        "status": "comming-soon"
                    }
                }
            """.trimIndent()

            "/api/products/4" -> """
                {
                    "result": 1,
                    "errorCode": "",
                    "errorMsg": "",
                    "data": {
                        "id": 4,
                        "name": "Four Item",
                        "price": 300,
                        "content": "Some very very looong text to display as the product content blablabla",
                        "status": "available"
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