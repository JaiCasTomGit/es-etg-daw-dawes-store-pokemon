# Tienda Pokémon
## Colaboradores: 
- Jaime Castro. 
- Jose Miguel Cenoz. 
- Carlos Ducons.

## Requisitos de arranque
Java 17
Maven
Spring Boot 4.1.1 con Spring Web y Lombok.

### Modo de arranque de la app.

``` bash
./mvn spring-boot:run
``` 
Con la aplicaciñon arrancada:
- Formulario de creación: <http://localhostl:8080/formulario-crear-pokemon.html>
- Listado <http://localhost:8080/pokemons>

## Endpoints
| Método | URL         | Entrada                                  | Salida                         |
|--------|-------------|------------------------------------------|--------------------------------|
| POST   | `/pokemons` | Formulario: nombre, tipo, foto, precio   | Página HTML con el Pokemon creado |
| GET    | `/pokemons` | Ninguna                                  | Lista de `PokemonResponse` (JSON) |

## Arquitectura
#### Organización: Vertical Slicing
 Se aplica Spring Boot para gestionar las operativas de una tienda de Pokemon. El objetivo es aplicar **Vertical Slicing** y **Clean Architecture**. 

## Limitaciones conocidas

- Los datos del listado son **estáticos** (tres Pokemon fijos), asi como los pokemons creados; no hay persistencia por ahora.
- La respuesta del POST es HTML escrito dentro del controlador; está previsto sustituirlo por plantillas.
- El servicio actual solo reenvía la llamada al caso de uso; cobrará sentido cuando coordine varios.

## Más documentación

- [Guía de trabajo](documentation/guiadetrabajo.md)







