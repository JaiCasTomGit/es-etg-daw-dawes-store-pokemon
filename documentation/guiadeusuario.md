# Guía de usuario

Cómo poner en marcha Tienda Pokémon y cómo usarla.

## Puesta en marcha

Necesitas un **JDK 17** o superior.

```bash
git clone https://github.com/JaiCasTomGit/es-etg-daw-dawes-store-pokemon.git
cd es-etg-daw-dawes-store-pokemon
./mvnw spring-boot:run
```

En Windows, usa `mvnw.cmd` en lugar de `./mvnw`.

Con la aplicación en marcha, estará disponible en `http://localhost:8080`:

| Qué                  | Dónde                                    |
|----------------------|------------------------------------------|
| Crear un Pokémon     | `/formulario-crear-pokemon.html`         |
| Eliminar un Pokémon  | `/formulario-eliminar-pokemon.html`      |
| Listado (JSON)       | `/pokemons`                              |

Los datos se guardan en memoria y la aplicación arranca con tres Pokémon de ejemplo.

## Crear un Pokémon

**Desde el navegador:** abre `/formulario-crear-pokemon.html`, rellena el formulario y pulsa **Crear Pokemon**.

| Campo  | Obligatorio | Reglas                                                     |
|--------|-------------|------------------------------------------------------------|
| Nombre | Sí          | Sin espacios ni saltos de línea                            |
| Tipo   | Sí          | Fuego, Agua, Planta, Eléctrico, Roca, Psíquico o Normal    |
| Foto   | No          | URL de la imagen                                           |
| Precio | Sí          | Entre 0 y 100 euros                                        |

La aplicación responde con una página que muestra los datos del Pokémon creado, incluido su identificador.

**Desde la línea de comandos:**

```bash
curl -X POST http://localhost:8080/pokemons \
  -d "nombre=Pikachu" \
  -d "tipo=Eléctrico" \
  -d "foto=https://ejemplo.com/pikachu.png" \
  -d "precio=25.50"
```

## Consultar el listado

Abre `/pokemons` en el navegador, o:

```bash
curl http://localhost:8080/pokemons
```

La respuesta es una lista de Pokémon en JSON. Al arrancar contiene los tres de ejemplo:

```json
[
  { "id": 1, "nombre": "Pokemon1", "tipo": "tipo1", "foto": "1", "precio": 1.0, "createdAt": "2026-11-15T20:30:00" },
  { "id": 2, "nombre": "Pokemon2", "tipo": "tipo2", "foto": "2", "precio": 1.0, "createdAt": "2026-11-15T20:30:00" },
  { "id": 3, "nombre": "Pokemon3", "tipo": "tipo3", "foto": "3", "precio": 1.0, "createdAt": "2026-11-15T20:30:00" }
]
```

## Editar un Pokémon

Se hace con una petición HTTP; no hay formulario. Actualiza la **foto** y el **precio** del Pokémon indicado y devuelve el resultado en JSON. El cuerpo lleva los mismos campos y reglas que al crear.

```bash
curl -X PUT http://localhost:8080/pokemons/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Pokemon1","tipo":"tipo1","foto":"https://ejemplo.com/nueva.png","precio":30.0}'
```

## Eliminar un Pokémon

**Desde el navegador:** abre `/formulario-eliminar-pokemon.html`, escribe el identificador y pulsa **Eliminar Pokémon**.

**Desde la línea de comandos:**

```bash
curl -i -X DELETE http://localhost:8080/pokemons/1
```

La respuesta es `204`, sin contenido.

## Errores

Todos los errores devuelven una página con la fecha, el código y el mensaje.

| Código | Cuándo                                                                        |
|--------|-------------------------------------------------------------------------------|
| 400    | Los datos enviados no cumplen las reglas de validación                        |
| 404    | El Pokémon no existe (al editar o eliminar), o no hay ninguno que listar      |
| 500    | Error inesperado del servidor                                                 |
