---

# 🧪 PRUEBA TÉCNICA – AUTOMATIZADOR QA

## Automatización API (RestAssured) & Web (Playwright)

Este repositorio contiene la solución a la **Prueba Técnica para Automatizador QA**, donde se evalúan las capacidades para construir automatizaciones mantenibles utilizando **RestAssured** para pruebas API y **Playwright** para pruebas Web.

---

## 📌 Objetivo General

1. **Diseñar y construir automatizaciones mantenibles.**
2. **Aplicar buenas prácticas**, incluyendo:

   * Page Object Model (POM)
   * Screenplay (opcional)
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
* **Java (Playwright for Java)** o **TypeScript** según setup

---

## 🚀 Ejecución de Pruebas

### ✔️ 1. Pruebas API (RestAssured)

Ir al proyecto:

```bash
cd api-tests
```

Ejecutar:

```bash
mvn clean test
```

---

### ✔️ 2. Pruebas Web (Playwright)

Ir al proyecto:

```bash
cd web-tests
```

Instalar dependencias:

```bash
npm install
```

Instalar navegadores:

```bash
npx playwright install
```

Ejecutar las pruebas:

```bash
npx playwright test
```

---

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

* Validar que el endpoint responde 200 OK.
* Crear un recurso (POST) y validar campos.
* Consultar recurso (GET).
* Validación de esquema JSON.

### 🔹 Web con Playwright

* Login exitoso.
* Navegación a sección interna.
* Interacción con elementos (inputs, botones).
* Validación de mensajes visibles.

---

## 📄 Notas Finales

Este proyecto está construido para demostrar experiencia real en:

✔️ diseño de automatizaciones mantenibles
✔️ separación de responsabilidades
✔️ buenas prácticas de arquitectura de pruebas
✔️ trabajo con herramientas modernas de automatización API y Web

