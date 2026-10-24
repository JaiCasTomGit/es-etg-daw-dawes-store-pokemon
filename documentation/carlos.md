1. **Estructura de Dominio y Flujos de Creación/Lectura (POST/GET)**

   **Descripción:** Creación de la estructura base del *Vertical Slice* de `pokemon` siguiendo Clean Architecture.
   **Implementación:**
   - Capa de dominio: Creación del paquete `model` y la entidad principal `Pokemon`.
   - Flujo de creación (POST): Implementación del patrón Command con `CreatePokemonCommand`, su servicio (`CreatePokemonService`) y caso de uso (`CreatePokemonUseCase`).
   - Flujo de lectura (GET): Desarrollo de la lógica para listar todos los Pokémon registrados.

2. **Configuración de Infraestructura (Spring Boot Beans)**

   **Descripción:** Configuración del contenedor de dependencias del proyecto.
   **Implementación:**
   - Creación de la carpeta `config` y la clase `PokemonConfig`.
   - Registro de los *Beans* de configuración para que el framework de Spring Boot gestione y conecte automáticamente la inyección de dependencias de los Casos de Uso y Servicios.

3. **Modificar Pokémon (Método PUT)**

   **Ruta y Descripción:**
   `PUT /pokemons/{id}`
   Actualiza los datos de un Pokémon existente. El identificador (id) se pasa como parámetro de ruta, mientras que los valores a actualizar se envían en el cuerpo de la petición. Por reglas de negocio, solo se permite modificar la fotografía y el precio.

   **Arquitectura Implementada:**
   Utiliza el patrón Command (`EditPokemonCommand`) para encapsular estrictamente los atributos modificables. El flujo de datos sigue la estructura Clean Architecture: petición capturada en `PokemonController`, delegada a `EditPokemonService`, y procesada por `EditPokemonUseCase`.

   **Formato de Petición (JSON):**
   ```json
   {
     "foto": "[https://ruta-de-la-nueva-imagen.png](https://ruta-de-la-nueva-imagen.png)",
     "precio": 150.50
   }