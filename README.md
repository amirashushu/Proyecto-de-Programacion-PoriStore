# 🛒 Proyecto PoriStore — PROYECTO DE PROGRAMACIÓN

Notas
Cristóbal Pacheco: 7.0
Gonzalo Reyes: 6.9
Amira Casanova: 6.8
Hugo Muñoz: 6.7

## 🧾 Descripción General

**Proyecto PoriStore**  
El Proyecto PoriStore es una aplicación de escritorio destinada a simular y gestionar una tienda.  
El sistema, basado en una arquitectura por capas orientada a objetos, asegura la administración centralizada y eficiente del inventario y el flujo de compra.

## 🧩 Tecnologías Previstas

* **Frontend (GUI):** Java Swing / NetBeans GUI Builder  
* **Backend (Lógica):** Java SE (JDK 17+)  
* **Arquitectura:** Separación en capas (Entidades, Lógica, Vistas)

## ✨ Inicio Rápido del Sistema

Teniendo en cuenta que el proyecto fue estructurado nativamente para el entorno de Apache NetBeans.  
Pasos a ejecutar para la inicialización del entorno:

1. Clonar el repositorio y abrir el directorio en **NetBeans**.
2. Compilar, limpiar y construir las dependencias del proyecto ejecutando:  
   `Shift + F11` (Clean and Build)

Posteriormente, para inicializar la aplicación:  
Seleccionar el archivo `ProyectoPori.java` o presionar `F6`.

## Ejecutar servidor y host en instancias separadas

Desde la carpeta del proyecto, ejecutar `ant build-ejecutables`. Se crearán dos JAR ejecutables dentro de `dist/`:

* `PoriStore-Servidor.jar`: carga los datos de la tienda y deja el servidor escuchando; inicia sesión con la cuenta administradora desde esta ventana.
* `PoriStore-Host.jar`: inicia la tienda como cliente y se conecta al servidor. En el mismo computador se conecta automáticamente por `localhost`.

Se pueden abrir ambos JAR al mismo tiempo. En otro computador de la red, iniciar el host indicando la dirección IP del computador servidor, por ejemplo: `java -Dporistore.server.host=192.168.1.11 -jar PoriStore-Host.jar`.

El servidor usa `datosPoriStore.dat` y el host usa `datosPoriStore-host.dat`, para que las dos instancias no se sobrescriban los datos.

## 👥 Integrantes

* 🧩 **Amira Casanova** = @amirashushu 
* 🎨 **Hugo Muñoz**  = @hugozinn99
* ⚙️ **Cristóbal Pacheco**  = @Cristobal-1007
* 💻 **Gonzalo Reyes** = @gvrfffff

## 📌 Enlaces

* Repositorio: 🔗 [GitHub Proyecto PoriStore](https://github.com/amirashushu/PoriStore-Proyecto-de-Programacion)  
* Tablero Kanban: 🔗 [Proyecto PoriStore – Kanban](https://trello.com/b/CGhIjslc/%F0%9F%9B%92-poristore-hito-1)
