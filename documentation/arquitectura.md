# Arquitectura

Las decisiones de diseño del proyecto y sus razones. Para el resumen, vuelve al [README](../README.md).

## Vertical slicing

Una funcionalidad nueva no obliga a tocar las existentes y cada área de negocio se mantiene por separado. Hoy existen `pokemon` y `common` (lo transversal); usuarios, compras o ventas serán paquetes hermanos.

## Clean Architecture

El negocio queda aislado de Spring, HTTP y la base de datos: se prueba sin levantar nada y la tecnología puede cambiar sin tocar el núcleo.

## Repositorios propios en el dominio

Interfaz propia (`CRUDRepository` y `PokemonRepository`) en lugar de Spring Data: el dominio no depende del framework y el contrato se limita a lo que la aplicación necesita. Cambiar el almacenamiento, hoy en memoria, no afecta a los casos de uso. Las consultas devuelven `Optional` para que la ausencia sea un caso tratado y no un `null` que falla más tarde. Todos los casos de uso comparten la instancia que entrega `PokemonConfig`, así que un borrado lo ve toda la aplicación.

## Validación en el borde

Con Bean Validation sobre `PokemonRequest`, los datos incorrectos no llegan a los casos de uso, y los mensajes quedan en `messages.properties`, fuera del código. El validador propio del nombre solo juzga su regla y deja el nulo y el vacío a `@NotBlank`, para no devolver dos errores por el mismo motivo. La existencia de un Pokémon se comprueba en el caso de uso, porque necesita el repositorio.

## Errores centralizados

Los casos de uso lanzan excepciones de dominio y un único `@ControllerAdvice` las traduce a HTTP. Vive en `common` para que todos los endpoints, presentes y futuros, respondan igual sin repetir manejadores por controlador, y para que los casos de uso no conozcan HTTP.

## MapStruct

Frente a mappers escritos a mano, elimina código repetitivo. Frente a librerías de reflexión, no tiene coste en ejecución y un mapeo roto falla al compilar y no con la aplicación en marcha.

## Otras elecciones

- **Capa de servicios entre el controlador y los casos de uso.** El controlador depende de un único punto de entrada por operación, y las operaciones que necesiten varios casos de uso se coordinan ahí.
- **Request y Response propios, separados del modelo.** Un cambio en el formulario no afecta al dominio y los datos internos no se filtran al exterior.
