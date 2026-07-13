Sistema de Llanquihue Tour - Actividad Sumativa 3 - Semana 8

Autor del Proyecto:

- Nombre: Valeria Paz Silva Martínez
- Sección: 002A
- Carrera: Analista Programador Computacional
- Sede: Online
  
---------------------------

Descripción general del Sistema:

Este proyecto corresponde a la Evaluación Final Transversal de la asignatura Desarrollo Orientado a Objetos I.
Se trata de un sistema orientado a objetos desarrollado en Java, cuyo objetivo es modelar y gestionar entidades representativas
de un dominio real, aplicando los principios de encapsulamiento, composición, herencia, polimorfismo e interfaces.

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales y proponiendo
una solución estructurada, modular y reutilizable.

---------------------------

Estructura general del Proyecto:

- 📁 src/
- ├── app/
- |    └── Main -> Clase que ejecutará todo el código
- ├── model/
- |    └── Direccion -> Clase de composición usada por Persona
- |    └── Guia -> Clase que hereda Persona e implementa Registrable
- |    └── Persona -> Clase que continuene atributos comunes de una persona
- |    └── Registrable -> Interfaz común
- |    └── ColaboradorExterno -> Clase que hereda Persona e implementa Registrable
- |    └── Vehiculo -> Clase con atributos de vehículos que implementa Registrable
- ├── data/
- |    └── GestorEntidades -> Colección ArrayList para guardar la información agregada
- ├── service/
- |    └── GuiaService -> Búsqueda y filtro de guías
- ├── util/
- |    └── LectorArchivo -> Lee los datos de guias.txt y los pone en una colección
- ├── ui/
- |    └── MenuGUI -> Interfaz gráfica para registrar y ver la información de entidades
- └── .gitignore

---------------------------

- Repositorio GitHub: https://github.com/GhostieSpoomy17/Sistema_LlanquihueTour_Sumativa3_Semana8
- Fecha de entrega: 13/07/2026
