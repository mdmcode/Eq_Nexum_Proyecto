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
- [Clase 1]: [responsabilidad]
- [Clase 2]: [responsabilidad]

### 4.2 Vista (`vista`)
- [Clase GUI 1]: [responsabilidad]
- [Clase GUI 2]: [responsabilidad]

### 4.3 Controlador (`controlador`)
- [Clase Controlador]: [responsabilidad]

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
- [Notas importantes, supuestos, validaciones, etc.]
