# Guía de trabajo

Cómo se trabaja en el proyecto. Las razones del diseño están en [Arquitectura](arquitectura.md).

## Reparto del trabajo

El trabajo se reparte **por caso de uso** (crear, listar, editar, eliminar), con una rama `feature/<acción><Entidad>` para cada uno. Gracias al vertical slicing, cada persona implementa su funcionalidad completa, de la petición HTTP al caso de uso, sin depender de que otros terminen su parte.

## Añadir un caso de uso

| Paso | Pieza           | Ubicación (bajo `pokemon/`)                             | Cuándo                                      |
|------|-----------------|---------------------------------------------------------|---------------------------------------------|
| 1    | Command         | `application/command`                                   | Si el caso de uso recibe datos              |
| 2    | Caso de uso     | `application/usecase`                                   | Siempre                                     |
| 3    | Servicio        | `application/service`                                   | Siempre                                     |
| 4    | Beans           | `infraestructure/config/PokemonConfig`                  | Siempre: uno para el caso de uso y otro para el servicio |
| 5    | DTO y mapper    | `infraestructure/web/mvc/dto`, `infraestructure/mapper` | Si cambian los datos que entran o salen     |
| 6    | Endpoint        | `infraestructure/web/mvc/controller/PokemonController`  | Siempre                                     |
| 7    | Formulario      | `src/main/resources/static`                             | Si se usa desde el navegador                |
| 8    | Documentación   | `README.md` y `documentation/guiadeusuario.md`          | Siempre                                     |

`PokemonController`, `PokemonMapper` y `PokemonConfig` los modifica todo el mundo. Para reducir conflictos, añade tus métodos al final de cada fichero.

## Convenciones

- **Nombres:** `<Acción>Pokemon` seguido de `Command`, `UseCase` o `Service`.
- **Paquetes:** `infraestructure` se escribe con «e», como en el resto del código.

## Antes de dar por terminada una funcionalidad

- [ ] La aplicación arranca
- [ ] El endpoint se ha probado
- [ ] La documentación refleja el cambio 
