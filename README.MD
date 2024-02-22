Aplicación de Gestión de Fechas y Descarga de URLs

Descripción

Esta aplicación Spring Boot proporciona una serie de funcionalidades centradas en la gestión de fechas y la descarga asíncrona de archivos desde URLs especificadas por el usuario. La aplicación se divide en dos partes principales: una API REST para manejar fechas y una funcionalidad de consola para descargar archivos de URLs ingresadas por el usuario.
Características

    API REST para Fechas: Permite a los usuarios obtener la fecha actual, calcular fechas futuras y, teóricamente, cambiar la fecha del sistema (no implementado por razones de seguridad).
    Descarga Asíncrona de Archivos: A través de una interfaz de consola, los usuarios pueden ingresar URLs de las cuales se descargarán archivos de manera asíncrona.

Cómo Empezar
Pre-requisitos

    JDK 17 o superior
    Maven o Gradle (dependiendo de tu sistema de construcción)
    IDE de tu elección (por ejemplo, IntelliJ IDEA)

Instalación

    Clona el repositorio en tu máquina local.
    Abre el proyecto en tu IDE.
    Resuelve las dependencias Maven/Gradle.

Ejecución

    Ejecuta la clase principal Main.java desde tu IDE o mediante la línea de comandos.

Uso
API REST para Fechas

    Obtener Fecha Actual: GET /api/date
    Calcular Fecha Futura: GET /api/date/{n} donde {n} es el número de días a añadir a la fecha actual.
    Cambiar Fecha del Sistema: POST /api/date con un cuerpo JSON especificando la fecha (no implementado).

Descarga Asíncrona de Archivos

    Al ejecutar la aplicación, se te pedirá que ingreses URLs en la consola.
    Escribe la URL completa y presiona Enter para iniciar la descarga.
    Escribe 'salir' para terminar el programa.

Construido con

    Spring Boot - Framework para crear aplicaciones stand-alone basadas en Spring.
    Lombok - Biblioteca para minimizar el código repetitivo en Java.

Autor

 CanyonLux

