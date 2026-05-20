# Eq_Nexum_Proyecto — Documentación

## 1. Datos generales
- **Equipo:** Nexum
- **Integrantes:**
  1. Iván Fernando Flechas Plaza
  2. María Del Mar Mosquera Caicedo
  3. Samuel Esteban Vargas
- **Fecha:** 20 de mayo de 2026
- **Herramienta:** Apache NetBeans IDE 22
- **Lenguaje:** Java
- **Patrón:** Modelo–Vista–Controlador (MVC)

---

## 2. Objetivo del programa
El sistema gestiona ventas de paquetes turísticos para una agencia, registrando clientes y paquetes (únicos o múltiples) con sus destinos. 
Permite crear ventas, calcular valores totales y descuentos según el tipo de cliente, y consultar ventas por número, posición o estado. 
Además, ofrece persistencia mediante archivos de objetos para ventas y clientes, y actualización de ventas existentes.

---

## 3. Alcance
- **Incluye:** creación y consulta de ventas, registro de clientes y paquetes turísticos, cálculo de totales y descuentos, actualización de ventas, generación y lectura de archivos de objetos (ventas/clientes).
- **No incluye:** integración con bases de datos, interfaz gráfica completa (solo consola), pasarelas de pago, reportes avanzados o generación de facturación electrónica.

---

## 4. Arquitectura (MVC)
### 4.1 Modelo (`modelo`)
- **Cliente:** datos del cliente, tipo de identificación y porcentaje de descuento.
- **Destino:** información del lugar, días de permanencia y atractivos.
- **PaqueteTuristico:** clase abstracta base para paquetes con cálculo de valores.
- **PaqueteTuristicoUnico:** paquete con hotel y desayuno; calcula valor por duración.
- **PaqueteTuristicoMultiple:** paquete con varios destinos y obsequio; calcula valor con incremento por destinos.
- **Venta:** agrega cliente y paquetes, calcula totales, descuentos y valida estado.

### 4.2 Vista (`vista`)
- **UsaGUIVenta:** menú principal en consola para crear/consultar/actualizar ventas y gestionar archivos.

### 4.3 Controlador (`controlador`)
- **Main:** punto de entrada que inicia la vista (UsaGUIVenta).

---

## 5. Flujo de funcionamiento
1. El usuario ingresa la información en la interfaz (vista).
2. La vista envía los datos al controlador para validación.
3. El controlador delega al modelo la creación y cálculo (clientes, destinos, paquetes, venta).
4. El modelo procesa y retorna resultados (valores, descuentos, totales).
5. El controlador devuelve los resultados a la vista.
6. La vista muestra la respuesta al usuario.

---

## 6. Requisitos para ejecutar
- **JDK:** 23
- **Librerías:**
  - junit-4.13.2.jar
  - hamcrest-core-1.3.jar
- **Comando de ejecución:**
  ```
  ant run
  ```

---

## 7. Pruebas unitarias
- **Comando:**
  ```
  ant test
  ```
- **Resultados:** ver archivo de casos de prueba `Eq_Nexum_A1_CasosPrueba_Proyecto`.

---

## 8. Consideraciones y observaciones
- El sistema valida datos clave: tipo y número de identificación, porcentaje de descuento, estado de ventas y días de permanencia.
- Los archivos `ventas.obj` y `clientes.obj` se crean en el directorio de ejecución.
- La vista es un menú por consola dentro de una clase JFrame; no hay interfaz gráfica completa.
- Los estados de venta válidos son **A**, **P** y **C** (activa, pendiente, cancelada).
