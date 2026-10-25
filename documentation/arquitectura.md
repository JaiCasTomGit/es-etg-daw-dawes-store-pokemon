# Arquitectura

Las decisiones de diseño del proyecto y sus razones. Para el resumen, vuelve al [README](../README.md).

## Vertical slicing

Cada área de negocio vive en su propio paquete, con sus capas dentro. Hoy solo existe `pokemon`, pero usuarios, compras o ventas serán paquetes hermanos. Así, una funcionalidad nueva no obliga a tocar las existentes y cada área se mantiene por separado.

## Clean Architecture

La lógica de negocio no debe depender de Spring, de HTTP ni de la base de datos. Dentro de cada slice, `domain` no depende de nada, `application` solo del dominio, e `infraestructure` es la única capa que conoce el exterior. Esto permite probar el negocio sin levantar nada y cambiar de tecnología sin tocar el núcleo.
## Elecciones propias dentro de la arquitectura


- **Capa de servicios entre el controlador y los casos de uso.** El controlador depende de un único punto de entrada por operación, y las operaciones que necesiten varios casos de uso se coordinan ahí. Ver `application/service`.

- **Request y Response propios, separados del modelo.** Un cambio en el formulario no afecta al dominio y los datos internos no se filtran al exterior. Ver `infraestructure/web/mvc/dto` e `infraestructure/mapper`.
