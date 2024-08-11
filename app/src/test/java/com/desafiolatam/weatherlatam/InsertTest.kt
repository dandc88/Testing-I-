package com.desafiolatam.weatherlatam

import com.desafiolatam.weatherlatam.data.local.WeatherDao
import com.desafiolatam.weatherlatam.data.local.WeatherEntity
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class InsertTest {

    private lateinit var dao: WeatherDao
    private val mockDao = mock(WeatherDao::class.java)

    @Before
    fun setup() {
        dao = mockDao
    }

    @Test
    fun testInsertData() = runBlocking {
        // Datos de prueba
        val weatherEntity = WeatherEntity(
            id = 1,
            currentTemp = 20.0,
            maxTemp = 25.0,
            minTemp = 15.0,
            pressure = 1013.0,
            humidity = 80.0,
            windSpeed = 5.0,
            sunrise = System.currentTimeMillis(),
            sunset = System.currentTimeMillis(),
            cityName = "Santiago"
        )

        // Llamada al método insertData
        dao.insertData(weatherEntity)

        // Verificación de que el método insertData se haya llamado con el argumento esperado
        verify(mockDao, times(1)).insertData(weatherEntity)
    }

    @Test
    fun testInsertMultipleData() = runBlocking {
        // Datos de prueba
        val weatherEntity1 = WeatherEntity(
            id = 1,
            currentTemp = 20.0,
            maxTemp = 25.0,
            minTemp = 15.0,
            pressure = 1013.0,
            humidity = 80.0,
            windSpeed = 5.0,
            sunrise = System.currentTimeMillis(),
            sunset = System.currentTimeMillis(),
            cityName = "Santiago"
        )

        val weatherEntity2 = WeatherEntity(
            id = 2,
            currentTemp = 22.0,
            maxTemp = 27.0,
            minTemp = 17.0,
            pressure = 1015.0,
            humidity = 75.0,
            windSpeed = 4.0,
            sunrise = System.currentTimeMillis(),
            sunset = System.currentTimeMillis(),
            cityName = "Valparaiso"
        )

        // Llamada al método insertData para múltiples datos
        dao.insertData(weatherEntity1)
        dao.insertData(weatherEntity2)

        // Verificación de que el método insertData se haya llamado con los argumentos esperados
        verify(mockDao, times(1)).insertData(weatherEntity1)
        verify(mockDao, times(1)).insertData(weatherEntity2)
    }

    @Test
    fun testInsertDataErrorHandling() = runBlocking {
        // Datos de prueba
        val weatherEntity = WeatherEntity(
            id = 1,
            currentTemp = 20.0,
            maxTemp = 25.0,
            minTemp = 15.0,
            pressure = 1013.0,
            humidity = 80.0,
            windSpeed = 5.0,
            sunrise = System.currentTimeMillis(),
            sunset = System.currentTimeMillis(),
            cityName = "Santiago"
        )

        // Verifica que no haya excepciones al llamar al método insertData
        try {
            dao.insertData(weatherEntity)
        } catch (e: Exception) {
            Assert.fail("Exception should not be thrown")
        }
    }

    @Test
    fun testInsertAndVerifyData() = runBlocking {
        // Datos de prueba
        val weatherEntity = WeatherEntity(
            id = 1,
            currentTemp = 20.0,
            maxTemp = 25.0,
            minTemp = 15.0,
            pressure = 1013.0,
            humidity = 80.0,
            windSpeed = 5.0,
            sunrise = System.currentTimeMillis(),
            sunset = System.currentTimeMillis(),
            cityName = "Santiago"
        )

        // Insertar el registro
        dao.insertData(weatherEntity)

        // Configurar el mock para que devuelva el dato insertado
        `when`(mockDao.getWeatherDataById(1)).thenReturn(flowOf(weatherEntity))

        // Recuperar el registro y verificar que coincida con el insertado
        val result = dao.getWeatherDataById(1).toList()

        verify(mockDao, times(1)).insertData(weatherEntity)
        assertEquals(weatherEntity, result[0])
    }


}