# Prototipo Ventas - Sistema de Gestión de Ventas v1.0

>>>>>>> main

Primera entidad del prototipo de ventas: `Producto`. El proyecto se compila para **Java 11** y sus pruebas usan JUnit 5.

## Requisitos

- Git
- JDK 11 (recomendado: Eclipse Temurin 11)
- Maven 3.8 o superior
- Docker Desktop (alternativa reproducible, sin JDK/Maven locales)
- VS Code con el paquete **Extension Pack for Java** (opcional)

En Windows, puede instalar las herramientas con `winget` (abra una consola como administrador y reiníciela después):

```powershell
winget install EclipseAdoptium.Temurin.11.JDK
winget install Apache.Maven
winget install Git.Git
winget install Docker.DockerDesktop
winget install Microsoft.VisualStudioCode
```

Después de instalar Docker, inicie Docker Desktop y espere a que indique que el motor está en ejecución.

Compruebe las herramientas instaladas:

```powershell
java -version
mvn -version
git --version
docker --version
code --version
```

## Clonar, compilar y probar

```powershell
git clone <URL-DEL-REPOSITORIO>
cd ventas-producto
mvn clean test
```

El resultado esperado es `BUILD SUCCESS` y 5 pruebas ejecutadas sin fallos.

## Ejecución reproducible con Docker (Java 11 + Maven)

Desde la raíz del proyecto:

```powershell
docker build --tag ventas-producto-test .
```

La imagen `maven:3.9.9-eclipse-temurin-11` ejecuta `mvn clean test` durante la construcción.

## Modelo

`Producto` encapsula código, nombre, precio y existencia. El código es inmutable; las actualizaciones de nombre, precio y existencia pasan por métodos que validan el estado. Se rechazan código/nombre vacíos, precio negativo y existencia negativa.

## Abrir en VS Code

```powershell
code .
```
