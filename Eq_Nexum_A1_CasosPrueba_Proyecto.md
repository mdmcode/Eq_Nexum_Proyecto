# Eq_Nexum_A1_CasosPrueba_Proyecto

## 1. Datos generales
- **Equipo:** Nexum
- **Fecha:** 19 de mayo de 2026
- **Responsable de ejecución:** Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo

---

## 2. Casos de prueba

| ID | Clase / Método | Escenario | Datos de entrada | Resultado esperado | Resultado obtenido | Estado (Éxito/Fallo) | Causa del fallo | Fecha | Responsable |
|----|----------------|----------|------------------|--------------------|--------------------|----------------------|-----------------|-------|-------------|
| CP-01 | ClienteTest | Crear cliente válido | tipo='C', id='123456', desc=10.0 | Cliente creado | Cliente creado | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-02 | ClienteTest | Tipo inválido | tipo='X' | Excepción | Excepción | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-03 | DestinoTest | Crear destino válido | dias=2, lugar='Bogota' | Destino creado | Destino creado | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-04 | PaqueteTuristicoUnicoTest | Valor total correcto | unidades=2, base=5000 | total=10000 | total=10000 | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |
| CP-05 | VentaTest | Cálculo descuento | total=4000, desc=10% | descuento=400 | descuento=400 | Éxito | N/A | 19 de mayo de 2026 | Iván Fernando Flechas Plaza / María Del Mar Mosquera Caicedo |

> Agrega más filas según tus tests reales.
