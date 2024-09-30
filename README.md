# Proyecto: Acceso a Servicios Flask desde una APK Android

## Descripción del Problema
Este proyecto se enfoca en la implementación de una aplicación móvil simple para Android que se comunica con un servicio Flask alojado en un servidor EC2 de AWS. La aplicación realiza una operación básica: obtener información de un usuario a través de un servicio REST creado con Flask.

## Objetivo
El objetivo es desarrollar una aplicación Android (APK) que se conecte con un servicio Flask alojado en AWS EC2 y permita la obtención y visualización de detalles de un usuario específico, como su nombre, correo electrónico y número de identificación (RUT).

## Requisitos

1. **Servicio Flask en EC2**: Implementar un servicio Flask en AWS EC2 que devuelva información de usuario mediante una petición GET.
2. **APK Android**: Crear una aplicación Android que haga solicitudes HTTP GET al servicio Flask y muestre la información de usuario en su interfaz.
3. **Comunicación REST**: Usar una biblioteca HTTP como `OkHttp` para la comunicación entre la aplicación Android y el servicio Flask.
4. **JSON**: El servicio Flask debe devolver los datos de usuario en formato JSON.
