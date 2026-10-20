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
- Listado <http://localhost:8080/pookemos>

## Endpoints
| Método | URL         | Entrada                                  | Salida                         |
|--------|-------------|------------------------------------------|--------------------------------|
| POST   | `/pokemons` | Formulario: nombre, tipo, foto, precio   | Página HTML con el Pokemon creado |
| GET    | `/pokemons` | Ninguna                                  | Lista de `PokemonResponse` (JSON) |

## Arquitectura
#### Organización: Vertical Slicing
Aplicación web con Spring Boot para gestionar las operativas de una tienda de Pokemon. El objetivo de la práctica es aplicar **Vertical Slicing** y **Clean Architecture sobre un caso sencillo: crear un Pokemon (`POST`) y listarlos(`GET`). 








