# Eq_Nexum_A1_CasosPrueba_Proyecto

## 1. Datos generales
- **Equipo:** Nexum
- **Fecha:** 19 de mayo de 2026
- **Responsable de ejecución:** Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo / Samuel Esteban Vargas

---

## 2. Casos de prueba

| ID | Clase / Método | Escenario | Datos de entrada | Resultado esperado | Resultado obtenido | Estado (Éxito/Fallo) | Causa del fallo | Fecha | Responsable |
|----|----------------|-----------|------------------|--------------------|--------------------|----------------------|-----------------|-------|-------------|
| CP-01 | ClienteTest | Crear cliente válido | tipo='C', id='123456', desc=10.0 | Cliente creado | Cliente creado | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-02 | ClienteTest | Tipo inválido | tipo='X' | Excepción | Excepción | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-03 | DestinoTest | Crear destino válido | dias=2, lugar='Bogota' | Destino creado | Destino creado | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-04 | PaqueteTuristicoUnicoTest | Valor total correcto | unidades=2, base=5000 | total=10000 | total=10000 | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-05 | VentaTest | Cálculo descuento | total=4000, desc=10% | descuento=400 | descuento=400 | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-06 | ClienteTest | ID negativo | tipo='C', id='-1', desc=5.0 | Excepción | Cliente creado | Fallo | No se validó el ID negativo | 19 de mayo de 2026 | Samuel Esteban Vargas |
| CP-07 | DestinoTest | Lugar vacío | dias=1, lugar='' | Excepción | Excepción | Éxito | N/A | 19 de mayo de 2026 | Samuel Esteban Vargas |
| CP-08 | PaqueteTuristicoUnicoTest | Valor total con unidades negativas | unidades=-3, base=2000 | Excepción | total=-6000 | Fallo | No se restringió unidades negativas | 19 de mayo de 2026 | Samuel Esteban Vargas |
| CP-09 | VentaTest | Descuento mayor a 100% | total=1000, desc=150% | Excepción | descuento=1500 | Fallo | Permitido descuento mayor a 100% | 19 de mayo de 2026 | Samuel Esteban Vargas |
| CP-10 | ClienteTest | Crear cliente sin descuento | tipo='C', id='999999', desc=0.0 | Cliente creado | Cliente creado | Éxito | N/A | 19 de mayo de 2026 | Samuel Esteban Vargas |
| CP-11 | DestinoTest | Crear destino con días cero | dias=0, lugar='Cali' | Excepción | Excepción | Éxito | N/A | 19 de mayo de 2026 | Samuel Esteban Vargas |
| CP-12 | VentaTest | Total en cero sin descuento | total=0, desc=0% | descuento=0 | descuento=0 | Éxito | N/A | 19 de mayo de 2026 | Samuel Esteban Vargas |
| CP-13 | PaqueteTuristicoUnicoTest | Valor total con base negativa | unidades=2, base=-100 | Excepción | total=-200 | Fallo | No se validó base negativa | 19 de mayo de 2026 | Samuel Esteban Vargas |

> Agrega más filas según tus tests reales.
