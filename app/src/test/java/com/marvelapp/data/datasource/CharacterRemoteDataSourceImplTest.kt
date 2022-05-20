package com.marvelapp.data.datasource

import com.marvelapp.core.ObjectProvider
import com.marvelapp.model.character.Character
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class CharacterRemoteDataSourceImplTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        // Your KoinApplication instance here
        modules(*DataSourceModulesTest.all)
    }

    private val repositoryRemoteDataSource by inject<CharacterRemoteDataSource>()

    @Test
    fun getCharacterOf() = runBlocking {
        val actual = repositoryRemoteDataSource.getAllCharacter(0).getOrNull()
        val expected = Pair(
            20,
            ObjectProvider.twoCharacters
        )
        assertEquals(expected, actual)
    }
}