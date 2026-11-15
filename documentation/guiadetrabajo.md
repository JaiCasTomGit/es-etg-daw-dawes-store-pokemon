# Guía de trabajo

Convenciones del proyecto. Las razones del diseño están en [Arquitectura](arquitectura.md).

## Reparto

El trabajo se reparte por caso de uso, con una rama `feature/<acción><Entidad>` para cada uno. El vertical slicing permite que cada persona lo implemente completo sin depender de las demás.

## Piezas de un caso de uso

| Pieza                  | Ubicación (bajo `pokemon/`)                                     | Cuándo                         |
|------------------------|-----------------------------------------------------------------|--------------------------------|
| Command                | `application/command`                                           | Si recibe datos                |
| Repositorio            | `domain/repository`, `infraestructure/db/repository`            | Si falta una consulta          |
| Caso de uso            | `application/usecase`                                           | Siempre                        |
| Servicio (`@Service`)  | `application/service`                                           | Siempre                        |
| Bean                   | `infraestructure/config/PokemonConfig`                          | Siempre                        |
| Request y validación   | `infraestructure/web/mvc/dto`, `infraestructure/web/validation` | Si cambia la entrada           |
| Mapper                 | `infraestructure/mapper`                                        | Si cambian los datos           |
| Endpoint               | `infraestructure/web/mvc/controller`                            | Siempre                        |
| Errores                | `domain/error`, `common/infraestructure/web/error`              | Si hay un error nuevo          |
| Formulario             | `src/main/resources/static`                                     | Si se usa desde el navegador   |
| Documentación          | `README.md`, `documentation/guiadeusuario.md`                   | Siempre                        |

`PokemonController`, `PokemonMapper`, `PokemonConfig`, `GlobalExceptionHandler` y `messages.properties` los toca todo el mundo: añade tus cambios al final de cada fichero.

## Convenciones

- **Nombres:** `<Acción>Pokemon` + `Command`, `UseCase` o `Service`.
- **Paquetes:** `infraestructure`, con «e».
- **Mensajes de validación:** `pokemon.valid.<campo>.<regla>`.
- **`pom.xml`:** no reordenar los procesadores de anotaciones (Lombok, binding y MapStruct, en ese orden).

## Antes de dar por terminada una funcionalidad

- [ ] La aplicación arranca
- [ ] El endpoint se ha probado
- [ ] La documentación refleja el cambio
