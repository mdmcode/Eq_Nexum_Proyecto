# Eq_Nexum_A1_CasosPrueba_Proyecto

Equipo: Nexum

## Casos de prueba unitarios

| ID | Clase | Caso de prueba | Datos de entrada | Resultado esperado | Resultado (éxito/fallo, causa) | Estado (finalizada/abierta) | Fecha | Responsable |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| CP-01 | Cliente | Crear cliente válido | tipo=C, id=123456, desc=10.0 | Cliente creado sin error | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-02 | Cliente | tipoIdentificacion inválido | tipo=X | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-03 | Cliente | número cédula corto | tipo=C, id=123 | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-04 | Cliente | NIT longitud incorrecta | tipo=N, id=12345678 | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-05 | Cliente | descuento fuera rango | desc=80.0 | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-06 | Destino | Crear destino válido | dias=2 | Destino creado sin error | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-07 | Destino | diasPermanencia mínimo 1 | dias=0 | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-08 | PaqueteTuristicoUnico | calcular valor unidad | tarifa=1000, dias=5 | valor=5000 | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-09 | PaqueteTuristicoUnico | nombre mínimo 10 | nombre="Corto" | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-10 | PaqueteTuristicoUnico | descripción máximo 500 | len=501 | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-11 | PaqueteTuristicoUnico | tarifa día > 0 | tarifa=0 | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-12 | PaqueteTuristicoUnico | cantidad unidades mínimo 1 | unidades=0 | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-13 | PaqueteTuristicoMultiple | calcular valor unidad | tarifa=1000, destinos=2, dias=5 | valor=5020 | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-14 | Venta | cálculo totales | descuento=10%, total=4000 | descuento=400, pagar=3600 | Pendiente | Abierta | 2026-05-08 | Nexum |
| CP-15 | Venta | estado inválido | estado=X | IllegalArgumentException | Pendiente | Abierta | 2026-05-08 | Nexum |
