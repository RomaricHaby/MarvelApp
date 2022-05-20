package com.marvelapp.domain

import com.marvelapp.core.ObjectProvider
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get

class GetCharacterByIdTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*DomainModulesTest.all)
    }

    @Test
    operator fun invoke() = runBlocking {

        val getUserUseCase = get<GetCharacterByIdUseCase>()
        val actual = getUserUseCase(1011334)
        val expected = ObjectProvider.oneCharacter

        assertEquals(expected, actual)
    }
}