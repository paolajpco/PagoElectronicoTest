---

# 🧪PRUEBA TÉCNICA – AUTOMATIZADOR QA

## Automatización API (RestAssured) & Web (Playwright)

Este repositorio contiene la solución a la **Prueba Técnica para Automatizador QA**

---

## 📌 Objetivo General

1. **Diseñar y construir automatizaciones mantenibles.**
2. **Aplicar buenas prácticas**, incluyendo:

   * Page Object Model (POM)
   * Separación por capas
3. **Automatizar pruebas API con RestAssured.**
4. **Automatizar pruebas Web con Playwright.**

---

## 📁 Estructura del Proyecto

```
.
├── api-tests/                 # Automatización API con RestAssured
│   ├── src/test/java/
│   │   ├── config/            # Configuraciones, BaseTest, Specs
│   │   ├── models/            # POJOs para request/response
│   │   ├── requests/          # Clientes HTTP
│   │   └── tests/             # Casos de prueba API
│   └── pom.xml
│
├── web-tests/                 # Automatización Web con Playwright
│   ├── src/test/java/
│   │   ├── base/              # Setup del navegador y fixtures
│   │   ├── pages/             # POM - Page Objects
│   │   └── tests/             # Casos de prueba Web
│   └── package.json
│
└── README.md
```

---

## 🧰 Tecnologías Utilizadas

### 🔹 Automatización API

* **Java 11/17**
* **RestAssured**
* **JUnit / TestNG**
* **Maven**

### 🔹 Automatización Web

* **Playwright**
* **Node.js**
* **Java (Playwright for Java)** 

---

## 🚀 Ejecución del Proyecto

El proyecto está configurado para ejecutarse con un solo comando utilizando Maven.

### 🔧 Requisitos previos
- Java 17 o superior
- Maven 3.8+
- Node.js (requerido por Playwright)

> Playwright se instala automáticamente al ejecutar las pruebas.

### ▶️ Ejecutar todas las pruebas (API + Web)

Desde la raíz del proyecto, ejecutar:

```bash
mvn clean test


## 🧱 Buenas Prácticas Implementadas

### 🔹 API

* Arquitectura por capas: `config → requests → tests`.
* Reutilización de **RequestSpecification**.
* Validación de código de estado y payload.
* Uso de POJOs para serialización/deserialización.
* Separación clara entre lógica y validaciones.

### 🔹 Web

* Page Object Model (POM).
* Selectores limpios y estables.
* Flujos encapsulados en páginas reutilizables.
* Before/After Hooks para control del navegador.
* Pruebas aisladas, repetibles y estables.

---

## 🧩 Casos de Prueba Implementados

### 🔹 API con RestAssured
Api publica: API: https://reqres.in/

* Validar respuesta metodo GET
* Crear un recurso (POST) y respuesta.
* Validar respuesta metodo (PUT).
* Validación de DELETE.

### 🔹 Web con Playwright
Pagina Web: https://www.saucedemo.com/
Pruebas:
1.Login exitoso.
2.Login fallido (usuario bloqueado).
3.Agregar dos productos al carrito.
4. Completar flujo de compra.
---



