![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🧠 Actividad Sumativa S5 – Desarrollo Orientado a Objetos I

**Proyecto:** Llanquihue Tour App — Organización modular y lectura de datos

## 👤 Autor del proyecto

- **Nombre completo:** Nicolas Alarcón
- **Sección:**
- **Carrera:** Analista programador
- **Sede:** Online

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la **Actividad Sumativa de la Semana 5** de la asignatura _Desarrollo Orientado a Objetos I_. Es la mejora del sistema de la Semana 3 para la agencia de turismo **Llanquihue Tour** (Región de Los Lagos).

La versión anterior creaba los objetos directamente dentro de `Main`. En esta mejora se incorporan:

- Código organizado en paquetes: `model`, `util`, `service` y `app`.
- Constructores con try-catch y validaciones (formato de RUT con regex, campos obligatorios y sueldo no negativo).
- Un `LinkedHashMap` con el RUT como clave para evitar duplicados, un `ArrayList` para los resultados y un `Stack` para el historial de búsquedas.
- Carga de datos desde un archivo `.csv` externo, usando un `HashMap` con los nombres de la cabecera.
- Menú por consola con búsquedas por nombre, por RUT y filtros por rol (sin importar tildes ni mayúsculas).
- Generación de un archivo `.jar` para distribuir la aplicación.

Con esto se resuelve la problemática de la agencia: registrar y consultar datos sin repetir RUT, validar la información y automatizar búsquedas y filtrados.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 Agencia-de-turismo-DuocUC/
├── README.md
└── 📁 LlanquihueTourApp/
    ├── build.ps1                 # Script para compilar y generar el .jar
    ├── datos/
    │   └── personas.csv          # Archivo externo con los registros
    └── src/
        ├── app/                  # Clase principal con el menú
        ├── model/                # Clases de dominio
        ├── service/              # Gestor de personas y lectura del CSV
        └── util/                 # Validaciones reutilizables
```

### Paquetes y clases implementadas

| Paquete   | Clase            | Descripción                                                                     |
| --------- | ---------------- | ------------------------------------------------------------------------------- |
| `app`     | `Main`           | Punto de entrada: carga los datos y muestra el menú de consultas.               |
| `model`   | `Persona`        | Clase base con RUT, nombre, teléfono y dirección.                               |
| `model`   | `Direccion`      | Representa la dirección de una persona.                                         |
| `model`   | `Cliente`        | Hereda de `Persona` y agrega el tipo de cliente.                                |
| `model`   | `Empleado`       | Hereda de `Persona` y agrega cargo y sueldo base.                               |
| `model`   | `GuiaTuristico`  | Hereda de `Empleado` y agrega idioma y especialidad.                            |
| `service` | `GestorPersonas` | Guarda personas en un `LinkedHashMap`, busca, filtra y registra el historial.   |
| `service` | `LectorPersonas` | Lee el CSV línea por línea y crea los objetos correspondientes.                 |
| `util`    | `Validador`      | Valida texto, RUT (regex) y sueldo; además normaliza tildes para las búsquedas. |

### Relaciones entre clases

- `Persona` **tiene una** `Direccion` (composición).
- `Cliente` y `Empleado` **son una** `Persona` (herencia).
- `GuiaTuristico` **es un** `Empleado` (herencia en segundo nivel).
- `GestorPersonas` **tiene un** `LinkedHashMap<String, Persona>` y un `Stack<String>` (composición).
- `LectorPersonas` crea objetos y los entrega a `GestorPersonas`.

### Colecciones utilizadas

| Colección       | Uso en el proyecto                                                              |
| --------------- | ------------------------------------------------------------------------------- |
| `LinkedHashMap` | Guarda las personas por RUT. Evita repetidos y mantiene el orden de carga.      |
| `ArrayList`     | Devuelve el listado completo y los resultados de búsquedas y filtros.           |
| `HashMap`       | En el lector, asocia cada nombre de columna del CSV con su valor.               |
| `Stack`         | Historial de búsquedas: la última consulta es la primera que se muestra (LIFO). |

---

## 📄 Formato del archivo de datos

El archivo `datos/personas.csv` usa punto y coma (`;`) como separador y tiene una cabecera:

```csv
tipo;rut;nombre;telefono;calle;numero;ciudad;region;tipoCliente;cargo;sueldoBase;idioma;especialidad
CLIENTE;19876543-2;Camila Rojas;+56 9 8765 4321;Los Volcanes;1250;Llanquihue;Los Lagos;Nacional;;;;
GUIA;15432109-K;Pedro Muñoz;+56 9 2345 6789;Av. Costanera;480;Puerto Varas;Los Lagos;;Guía de turismo;850000;Inglés;Rutas gastronómicas
EMPLEADO;12345678-9;Valentina Soto;+56 9 1122 3344;Camino Rural;37;Frutillar;Los Lagos;;Operadora de reservas;780000;;
```

La columna `tipo` puede ser `CLIENTE`, `EMPLEADO` o `GUIA`. Las columnas que no corresponden al tipo se dejan vacías. El lector toma los nombres de la cabecera y los usa como claves del `HashMap`, por eso en el código se lee `fila.get("rut")` o `fila.get("nombre")` en lugar de posiciones como `datos[1]`. Si una fila tiene un error, se omite con un aviso y el programa sigue con las demás.

---

## ⚙️ Instrucciones para clonar y ejecutar el programa

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Nicolas-Alarcon98/Agencia-de-turismo-DuocUC.git
```

2. Abre la carpeta `LlanquihueTourApp` en IntelliJ IDEA (JDK 17 o superior; el proyecto está configurado con JDK 22 y codificación UTF-8).

3. Ejecuta la clase `Main.java` del paquete `app` con el botón ▶ o `Shift + F10`.

4. El programa carga automáticamente `datos/personas.csv` y muestra el menú:

```plaintext
1) Listar todas las personas
2) Buscar por nombre
3) Buscar por RUT
4) Filtrar por rol
5) Ver historial de búsquedas
0) Salir
```

### Ejecución por línea de comandos

Desde la carpeta `LlanquihueTourApp`:

```powershell
$archivos = Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -d out $archivos
java -cp out app.Main
```

### Generar la versión distribuible (.jar)

```powershell
powershell -ExecutionPolicy Bypass -File build.ps1
java -jar llanquihuetour.jar
```

El script compila el código y crea `llanquihuetour.jar` con `app.Main` como clase principal. El programa busca el CSV en `datos/personas.csv` y, si no lo encuentra, en `LlanquihueTourApp/datos/personas.csv`.

### Salida esperada (extracto)

```plaintext
Personas registradas: 6

=== LLANQUIHUE TOUR | CONSULTAS ===
1) Listar todas las personas
2) Buscar por nombre
3) Buscar por RUT
4) Filtrar por rol
5) Ver historial de búsquedas
0) Salir
Elija una opción: 1
[Cliente] Nombre: Camila Rojas | RUT: 19876543-2 | ...
[Guía turístico] Nombre: Pedro Muñoz | RUT: 15432109-K | ... | Idioma: Inglés | Especialidad: Rutas gastronómicas
Total: 6

Elija una opción: 4
Rol (cliente / empleado / guía): guia
[Guía turístico] Nombre: Pedro Muñoz | ...
[Guía turístico] Nombre: Ana Navarro | ...
Total: 2

Elija una opción: 5
--- HISTORIAL ---
guia
```

---

## 🎬 Video de presentación

El video demostrativo (estructura, clases, ejecución, filtros y salida por consola, máx. 5 minutos) será grabado por el autor y entregado en AVA/Kaltura.

---

**Repositorio GitHub:** [https://github.com/Nicolas-Alarcon98/Agencia-de-turismo-DuocUC](https://github.com/Nicolas-Alarcon98/Agencia-de-turismo-DuocUC)  
**Fecha de entrega:** [Pendiente – Actividad Sumativa S5]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Sumativa S5
