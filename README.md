# weather-project-api

**Proyecto de clima**

Se utilizó el servicio de weatherbit.io http://api.weatherbit.io/v2.0/ dejando por defecto 7 días.

Para obtener las IDs de las ciudades se puede descargar de
https://www.weatherbit.io/api/meta

También se creo un punto para obtener la info por 
localhost:8062/weather-service/api/city/{nombre_ciudad}

**Para consultar por el clima en**\
http://localhost:8762/weather-service/api/forecast/{id_ciudad}

**Ejemplo con santiago**\
http://localhost:8762/weather-service/api/forecast/3871336

**Ejemplo ciudades**\
http://localhost:8762/weather-service/api/city/santiago

# Ejecución

1 - Ejecutar discoveryServer que contiene Eureka para registrar los servicios\
2 - Ejecutar zuul\
3 - Ejecutar weather que es el servicio con los puntos antes mencionados\

# Arquitectura

Se utiliza Eureka para permitir el registro de multiples servicios, un caso común es la cantidad de request que pueden sobre cargar un servidor y con esto es posible ir agregando instancias del servicio en un puerto distinto, con el gateway Zuul se crea un punto común para permitir la redirección.

**Por ejemplo**\
__Eureka:__ (ip:port 8761) \
__weather-service__: ws-1 (ip:port 1), ws-2 (ip:port 2), ws-3 (ip:port 3)\
__zuul__: zuul-server (ip:port 8762)\

Ingresando a \
ip:8762/{nombre_servicio}/{params}\
http://localhost:8762/weather-service/api/forecast/3871336

Zuul se encarga de seleccionar uno de los puertos (1, 2, 3) de forma automática (también configurable) permitiendo el balanceo de la carga y en conjunto con Eureka la escalabilidad horizontal.
