# Guía de proyecto 

**Regla de dependencias:** `infraestructure → application → domain`. El dominio no conoce nada de fuera; la aplicación solo conoce el dominio; la infraestructura conoce a las dos.

### Por qué hay varias clases con campos parecidos

`Pokemon`, `PokemonRequest`, `CreatePokemonCommand` y `PokemonResponse` se parecen, pero cada una cambia por una razón distinta:

| Clase                  | Capa            | Representa                                  |
|------------------------|-----------------|---------------------------------------------|
| `PokemonRequest`       | infraestructura | Lo que llega por HTTP                       |
| `CreatePokemonCommand` | aplicación      | Lo que necesita el caso de uso para crear   |
| `Pokemon`              | dominio         | El concepto de negocio (con `id`, `createdAt`) |
| `PokemonResponse`      | infraestructura | Lo que se decide mostrar al exterior        |

Separarlas evita que un cambio en el formulario afecte al dominio, y que datos internos se filtren en la respuesta. El `PokemonMapper` hace las conversiones.

### Inyección de dependencias

Las clases `application` no llevan anotaciones de Spring para no depender del framework. Es `PokemonConfig` (infraestructura) la que declara los `@Bean`, y Spring se los entrega por constructor a quien los necesita (`@RequiredArgsConstructor` de Lombok). Nadie hace `new` de sus dependencias.


## Notas de interés

- **Error de arranque por bean no encontrado.** Al ejecutar por primera vez, Spring no podía instanciar `CreatePokemonService` porque `CreatePokemonUseCase` no estaba registrado como bean. Se resuelve declarándolo en `PokemonConfig`. Esto es intencionado: el caso de uso no usa `@Service` para mantener la capa de aplicación libre de Spring.
- **Paquetes del enunciado corregidos.** `PokemonMapper` importaba los DTOs desde `web.dto` cuando están en `web.mvc.dto`; se han alineado los paquetes.
- **`@ResponseBody` en el GET.** Como `PokemonController` es un `@Controller`, el método que devuelve la lista necesita `@ResponseBody` para serializarse como JSON y no buscar una vista.



## Flujo de trabajo en equipo

Se usa Git Flow: `main`, `develop` y ramas `feature/*` que se integran en develop al finalizarse. 

La división de tareas se realizará principalmente por casos de uso, donde deben crearse, si es necesario; el service del mismo , modificar el controlador, el fichero de mapping, en caso de que fuera necesario y el config. 

### Comandos útiles de **Git, y Git flow**
- Git init, si no se ha iniciado localmente todavía.
- Git switch, para cambiar entre ramas.
- Git feature start nombre feature e igual para el finish.
- Git add . para añadir todo lo creado.
- Git push para subir lo creado. 
- Git pull para traer las actualizaciones.
- Git fetch te muestra los cambios q hay en el proyecto antes de bajarlo.
- Git commit -m "mensaje commit".