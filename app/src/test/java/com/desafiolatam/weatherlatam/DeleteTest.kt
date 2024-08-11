package com.desafiolatam.weatherlatam

import com.desafiolatam.weatherlatam.data.local.WeatherDao
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import org.mockito.Mockito.mock

class DeleteTest {

    private lateinit var dao: WeatherDao
    private val mockDao = mock(WeatherDao::class.java)

    @Before
    fun setup() {
        dao = mockDao
    }

    @Test
    fun testDeleteById() = runBlocking {
        // Datos de prueba
        val idToDelete = 1

        // Llamada al método deleteById
        dao.deleteById(idToDelete)

        // Verificación de que el método deleteById se haya llamado con el argumento esperado
        verify(mockDao, times(1)).deleteById(idToDelete)
    }

    @Test
    fun testDeleteAllData() = runBlocking {
        // Llamada al método clearAll
        dao.clearAll()

        // Verificación de que el método clearAll se haya llamado una vez
        verify(mockDao, times(1)).clearAll()
    }

    @Test
    fun testDeleteMultipleEntries() = runBlocking {
        // Datos de prueba
        val idToDelete1 = 1
        val idToDelete2 = 2

        // Llamada al método deleteById para múltiples ids
        dao.deleteById(idToDelete1)
        dao.deleteById(idToDelete2)

        // Verificación de que el método deleteById se haya llamado con los argumentos esperados
        verify(mockDao, times(1)).deleteById(idToDelete1)
        verify(mockDao, times(1)).deleteById(idToDelete2)
    }

    @Test
    fun testDeleteNonExistentData() = runBlocking {
        val nonExistentId = 999

        dao.deleteById(nonExistentId)

        verify(mockDao, times(1)).deleteById(nonExistentId)
    }
}
