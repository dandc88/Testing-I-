package com.desafiolatam.weatherlatam

import com.desafiolatam.weatherlatam.data.local.WeatherDao
import com.desafiolatam.weatherlatam.data.local.WeatherEntity
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class SelectTest {

    private lateinit var dao: WeatherDao
    private val mockDao = mock(WeatherDao::class.java)

    @Before
    fun setup() {
        dao = mockDao
    }

    @Test
    fun testGetWeatherData() = runBlocking {
        // Datos de prueba
        val weatherEntities = listOf(
            WeatherEntity(1, 20.0, 30.0, 10.0, 1013.0, 80.0, 5.0, 1632968400000, 1633011600000, "City1"),
            WeatherEntity(2, 25.0, 35.0, 15.0, 1010.0, 70.0, 4.0, 1632968400000, 1633011600000, "City2")
        )

        // Configuración del mock
        `when`(mockDao.getWeatherData()).thenReturn(flowOf(weatherEntities))

        // Llamada al método
        val result = dao.getWeatherData().toList()  // Convierte Flow en List para verificar el resultado

        // Verificación
        verify(mockDao, times(1)).getWeatherData()
        assertEquals(weatherEntities, result[0])
    }

    @Test
    fun testGetWeatherDataById() = runBlocking {
        // Datos de prueba
        val weatherEntity = WeatherEntity(1, 20.0, 30.0, 10.0, 1013.0, 80.0, 5.0, 1632968400000, 1633011600000, "City1")

        // Configuración del mock
        `when`(mockDao.getWeatherDataById(1)).thenReturn(flowOf(weatherEntity))

        // Llamada al método
        val result = dao.getWeatherDataById(1).toList()  // Convierte Flow en List para verificar el resultado

        // Verificación
        verify(mockDao, times(1)).getWeatherDataById(1)
        assertEquals(weatherEntity, result[0])
    }

    @Test
    fun testGetWeatherDataByIdNotFound() = runBlocking {
        // Configuración del mock para un ID que no existe
        `when`(mockDao.getWeatherDataById(99)).thenReturn(flowOf(null))

        // Llamada al método
        val result = dao.getWeatherDataById(99).toList()  // Convierte Flow en List para verificar el resultado

        // Verificación
        verify(mockDao, times(1)).getWeatherDataById(99)
        assertEquals(null, result[0])
    }

    @Test
    fun testGetWeatherDataByCity() = runBlocking {
        val weatherEntity = WeatherEntity(1, 20.0, 30.0, 10.0, 1013.0, 80.0, 5.0, 1632968400000, 1633011600000, "City1")

        `when`(mockDao.getWeatherDataByCity("City1")).thenReturn(flowOf(weatherEntity))

        val result = dao.getWeatherDataByCity("City1").toList()

        verify(mockDao, times(1)).getWeatherDataByCity("City1")
        assertEquals(weatherEntity, result[0])
    }
}
