# Este proyecto es basado en apoyo desafio evaluado testing(I)

# Proyecto de Pruebas Unitarias

Este repositorio contiene pruebas unitarias para validar las siguientes funcionalidades de la aplicación:

1. **Transformación de unidades de temperatura (Celsius a Fahrenheit y viceversa).**
2. **Queries tipo SELECT.**
3. **Queries tipo INSERT.**
4. **Queries tipo DELETE.**

Cada sección incluye cuatro pruebas, con una breve explicación de cada una.

## 1. Transformación de unidades de temperatura

Las siguientes pruebas verifican la conversión correcta entre grados Celsius y Fahrenheit:

- **`toFahrenheit`**: Verifica que la conversión de `10.0°C` a Fahrenheit sea correcta (debería ser `50.0°F`).
- **`toCelsius`**: Verifica que la conversión de `32.0°F` a Celsius sea correcta (debería ser `0.0°C`).
- **`negativeCelsiusToFahrenheit`**: Verifica que la conversión de `-10.0°C` a Fahrenheit sea correcta (debería ser `14.0°F`).
- **`negativeCelsiusToNegativeFahrenheit`**: Verifica que la conversión de `-50.0°C` a Fahrenheit sea correcta (debería ser `-58.0°F`).

## 2. Queries tipo SELECT

Estas pruebas aseguran que las consultas de datos desde la base de datos funcionen correctamente:

- **`testGetWeatherData`**: Verifica que se puedan recuperar todos los registros de `WeatherEntity` desde la base de datos.
- **`testGetWeatherDataById`**: Verifica que se pueda recuperar un registro específico de `WeatherEntity` por su ID.
- **`testGetWeatherDataByIdNotFound`**: Verifica que la consulta por un ID inexistente retorne `null`.
- **`testGetWeatherDataByCity`**: Verifica que se pueda recuperar un registro específico de `WeatherEntity` por el nombre de la ciudad.

## 3. Queries tipo INSERT

Estas pruebas validan que las operaciones de inserción funcionen correctamente y que los datos se almacenen de manera esperada:

- **`testInsertData`**: Verifica que un registro de `WeatherEntity` se inserte correctamente en la base de datos.
- **`testInsertMultipleData`**: Verifica que se puedan insertar múltiples registros en la base de datos.
- **`testInsertDataErrorHandling`**: Asegura que no se lancen excepciones inesperadas al insertar datos.
- **`testInsertAndVerifyData`**: Verifica que, después de insertar un registro, este se pueda recuperar correctamente desde la base de datos.

## 4. Queries tipo DELETE

Las siguientes pruebas aseguran que las operaciones de eliminación funcionen correctamente, limpiando los registros según lo esperado:

- **`testDeleteById`**: Verifica que un registro específico de `WeatherEntity` se elimine correctamente al usar su ID.
- **`testDeleteAllData`**: Verifica que todos los registros en la tabla `weather` se eliminen correctamente.
- **`testDeleteMultipleEntries`**: Verifica que múltiples registros puedan ser eliminados por sus IDs.
- **`testDeleteNonExistentData`**: Verifica que intentar eliminar un registro con un ID inexistente no cause errores.




