# Eq_Nexum_Proyecto — Documentación

## 1. Datos generales
- **Equipo:** Nexum
- **Integrantes:**
  1. Iván Fernando Flechas Plaza
  2. María Del Mar Mosquera Caicedo
- **Fecha:** 19 de mayo de 2026
- **Herramienta:** Apache NetBeans IDE 22
- **Lenguaje:** Java
- **Patrón:** Modelo–Vista–Controlador (MVC)

---

## 2. Objetivo del programa
[Describir en 3–5 líneas qué hace el sistema.]

---

## 3. Alcance
- **Incluye:** [Funcionalidades implementadas]
- **No incluye:** [Limitaciones o funcionalidades fuera del alcance]

---

## 4. Arquitectura (MVC)
### 4.1 Modelo (`modelo`)
- **Cliente:** gestiona datos y validaciones del cliente (identificación, contacto, descuento).
- **Destino:** representa un destino turístico con días de permanencia y atractivos.
- **PaqueteTuristico (abstracta):** base común de paquetes; valida datos y calcula duración/valor.
- **PaqueteTuristicoUnico:** paquete con un destino principal, hotel y desayuno; calcula valor por duración.
- **PaqueteTuristicoMultiple:** paquete con múltiples destinos y obsequio; calcula valor con incremento por cantidad de destinos.
- **Venta:** agrupa cliente y paquetes; calcula totales, descuento y valor a pagar.

### 4.2 Vista (`vista`)
- **UsaGUIVenta:** interfaz principal (consola/GUI) para crear y consultar ventas, manejar entradas y mostrar resultados.

### 4.3 Controlador (`controlador`)
- **Main:** punto de entrada que inicia la vista.

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
- El sistema valida datos clave (tipo de identificación, longitud, valores mínimos y rangos de descuento).
- Los cálculos de venta se basan en tarifa diaria, duración total y cantidad de unidades.
- Los paquetes múltiples incluyen incremento por cantidad de destinos.
- Se permite persistencia local mediante archivos de objetos (`ventas.obj`, `clientes.obj`).
- La vista usa `Scanner` (entrada por consola), por lo que la ejecución es interactiva.
- El estado de la venta admite solo **A** (activa), **P** (procesada) y **C** (cancelada).
