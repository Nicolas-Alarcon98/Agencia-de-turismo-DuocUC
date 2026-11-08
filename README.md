![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠 Actividad Sumativa S3 – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto

- **Nombre completo:** Nicolas Alarcón
- **Sección:**
- **Carrera:** Analista programador
- **Sede:** Online

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la Actividad Sumativa de la Semana 3 de la asignatura _Desarrollo Orientado a Objetos I_. Se trata de un sistema orientado a objetos desarrollado en Java, cuyo objetivo es modelar y gestionar a las personas vinculadas a la agencia de turismo **Llanquihue Tour**, aplicando los principios de encapsulamiento, composición y herencia.

El proyecto fue desarrollado a partir del caso contextualizado de Llanquihue Tour, agencia ubicada en la Región de Los Lagos. La problemática abordada es la falta de una estructura común para clientes, empleados y guías turísticos, lo que provoca información duplicada y una deficiente diferenciación de roles. La solución propone un modelo de clases modular, reutilizable y preparado para futuras ampliaciones del sistema.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 LlanquihueTourApp/
└── src/
    ├── app/         # Clase principal con el método main
    └── model/       # Clases de dominio (Persona, Cliente, Empleado, GuiaTuristico, Direccion)
```

### Clases implementadas

| Clase           | Paquete | Descripción                                                         |
| --------------- | ------- | ------------------------------------------------------------------- |
| `Main`          | `app`   | Punto de entrada; crea los objetos y muestra sus datos por consola. |
| `Persona`       | `model` | Clase base con RUT, nombre, teléfono y dirección.                   |
| `Direccion`     | `model` | Clase compuesta que representa la dirección de una persona.         |
| `Cliente`       | `model` | Hereda de `Persona` y agrega el tipo de cliente.                    |
| `Empleado`      | `model` | Hereda de `Persona` y agrega cargo y sueldo base.                   |
| `GuiaTuristico` | `model` | Hereda de `Empleado` y agrega idioma y especialidad.                |

### Relaciones entre clases

- `Persona` **tiene una** `Direccion` (composición, relación _has-a_).
- `Cliente` y `Empleado` **son una** `Persona` (herencia, relación _is-a_).
- `GuiaTuristico` **es un** `Empleado` (herencia en segundo nivel).

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Nicolas-Alarcon98/Agencia-de-turismo-DuocUC.git
```

2. Abre el proyecto `LlanquihueTourApp` en IntelliJ IDEA.

3. Verifica que el proyecto utilice un JDK 17 o superior.

4. Ejecuta el archivo `Main.java` desde el paquete `app` con el botón ▶ o `Shift + F10`.

5. Revisa la salida del programa en la consola de IntelliJ.

### Salida esperada

```plaintext
=== PERSONAS REGISTRADAS EN LLANQUIHUE TOUR ===
CLIENTE        -> Nombre: Camila Rojas | RUT: 19876543-2 | ...
GUÍA TURÍSTICO -> Nombre: Pedro Muñoz | RUT: 15432109-K | ...
EMPLEADO       -> Nombre: Valentina Soto | RUT: 12345678-9 | ...
```

---

**Repositorio GitHub:** \[[Pega aquí el enlace al repositorio](https://github.com/Nicolas-Alarcon98/Agencia-de-turismo-DuocUC)\]
**Fecha de entrega:** \[08/11/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Sumativa S3

