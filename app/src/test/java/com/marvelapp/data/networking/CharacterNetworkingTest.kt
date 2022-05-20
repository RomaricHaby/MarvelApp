package com.marvelapp.data.networking

import com.marvelapp.core.ObjectProvider
import com.marvelapp.core.ResourcesJsonManager
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class CharacterNetworkingTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*NetworkingModulesTest.all)
    }

    private val server by inject<MockWebServer>()
    private val source by inject<CharacterService>()

    @Test
    fun getCharacterByID() = runBlocking {
        val expected = MockResponse().apply {
            setResponseCode(200)
            setBody(ResourcesJsonManager.loadResource("one_reponse_character.json"))
        }
        server.enqueue(expected)

        val actual = source.getCharacterByID(1011334).body()

        assertEquals(ObjectProvider.oneResponseCharacter, actual)
    }


}