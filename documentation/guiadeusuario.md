# Guía de usuario

Cómo poner en marcha Tienda Pokémon y cómo usarla.

## Puesta en marcha

Necesitas un **JDK 17** o superior.

```bash
git clone https://github.com/JaiCasTomGit/es-etg-daw-dawes-store-pokemon.git
cd es-etg-daw-dawes-store-pokemon
./mvnw spring-boot:run
```

En Windows, usa `mvnw.cmd` en lugar de `./mvnw`. Para lanzar los tests: `./mvnw test`.

Con la aplicación en marcha, estará disponible en `http://localhost:8080`:

| Qué                  | Dónde                                    |
|----------------------|------------------------------------------|
| Crear un Pokémon     | `/formulario-crear-pokemon.html`         |
| Eliminar un Pokémon  | `/formulario-eliminar-pokemon.html`      |
| Listado (JSON)       | `/pokemons`                              |

## Crear un Pokémon

**Desde el navegador:** abre `/formulario-crear-pokemon.html`, rellena el formulario y pulsa **Crear Pokemon**.

| Campo  | Obligatorio | Descripción                                             |
|--------|-------------|---------------------------------------------------------|
| Nombre | Sí          | Nombre del Pokémon                                      |
| Tipo   | Sí          | Fuego, Agua, Planta, Eléctrico, Roca, Psíquico o Normal |
| Foto   | No          | URL de la imagen                                        |
| Precio | Sí          | Precio en euros, con hasta dos decimales                |

La aplicación responde con una página que muestra los datos del Pokémon creado.

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

La respuesta es una lista de Pokémon en JSON:

```json
[
  { "id": 1, "nombre": "Pikachu",    "tipo": "Eléctrico", "foto": "1", "precio": 1.0, "createdAt": "2026-10-25T20:30:00" },
  { "id": 2, "nombre": "Squirtle",   "tipo": "Agua",      "foto": "2", "precio": 2.0, "createdAt": "2026-10-25T20:30:00" },
  { "id": 3, "nombre": "Charmander", "tipo": "Fuego",     "foto": "3", "precio": 3.0, "createdAt": "2026-10-25T20:30:00" }
]
```

## Editar un Pokémon

Se hace con una petición HTTP; no hay formulario.

```bash
curl -X PUT http://localhost:8080/pokemons/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Pikachu","tipo":"Eléctrico","foto":"https://ejemplo.com/nueva.png","precio":30.0}'
```

La respuesta es el Pokémon en JSON, con el mismo formato que en el listado.

## Eliminar un Pokémon

**Desde el navegador:** abre `/formulario-eliminar-pokemon.html`, escribe el identificador y pulsa **Eliminar Pokémon**.

**Desde la línea de comandos:**

```bash
curl -i -X DELETE http://localhost:8080/pokemons/1
```

La respuesta es `204`, sin contenido.
