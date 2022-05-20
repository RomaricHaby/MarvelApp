package com.marvelapp.data.repository

import com.marvelapp.core.ObjectProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class CharacterRepositoryImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*RepositoryModulesTest.all)
    }

    private val userRepository by inject<CharacterRepository>()


    @Test
    fun getCharacter() = runBlocking {

        val actual = userRepository.getCharacterById(1011334)
        val expected = ObjectProvider.oneCharacter

        Assert.assertEquals(expected, actual)
    }
}