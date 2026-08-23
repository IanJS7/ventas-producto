# Evidencia de entrega

Fecha de ejecución: 2026-08-23 16:25 (America/Mexico_City)

## Ambiente detectado

| Herramienta | Resultado |
|---|---|
| Java local | Eclipse Temurin 17.0.19; compilación configurada con `--release 11` |
| Maven | 3.9.14 |
| Git | Disponible |
| Docker | Cliente disponible; el motor de Docker Desktop no estaba iniciado |
| VS Code | Disponible |

El `Dockerfile` fija el ambiente reproducible en `maven:3.9.9-eclipse-temurin-11`.

La verificación `docker build --tag ventas-producto-test .` no se completó en esta sesión porque el motor Docker no estaba iniciado. Inicie Docker Desktop y ejecute esa orden para validar el contenedor con JDK 11.

## Prueba ejecutada

```text
mvn clean test
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

El reporte detallado de Surefire se genera en `target/surefire-reports/` al ejecutar la orden.

## Contenido validado

- Creación válida de `Producto`.
- Rechazo de código vacío y nombre nulo.
- Rechazo de precio y existencia negativos.
- Estado encapsulado con atributos privados; el código no puede modificarse después de crear el producto.

Para identificar el commit exacto que respalda esta evidencia, ejecute `git rev-parse HEAD` desde la raíz del repositorio.
