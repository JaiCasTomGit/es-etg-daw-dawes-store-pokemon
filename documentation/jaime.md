# Application

## Hecho por Jaime Castro Tomás

Se han añadido las distintos directorios con sus clases correspondientes dentro del directorio ...~/es-etg-daw-dawes-store-pokemon/src/main/java/es/etg/daw/dawes/store/application

Estos son .../command .../service ../usecase, dentro de estos respectivamente se hacen las clases CreatePokemonCommand, CreatePokemonService y CreatePokemonUseCase.

Dentro de la infraestructura creo el mapper de la aplicación para transformar las clases.

Creo el formulario html para que la aplicación pueda funcionar para poder realizar pruebas.

Se crea el caso de uso FindPokemonUseCase, esta lista simulará que hay Pokémon en nuestra base de datos aunque no tengamos una. Por lo que en el futuro, cuando se añada una BBDD deberia leer estos.

Posteriormente creo el servicio FindPokemonService, este tras la llamada del servicio desde el controlador inicializa el caso de uso para que devuelva los datos de la lista.

En PokemonController creo un nuevo atributo para el servicio añadido

Añado la configuración para el nuevo caso de uso y su servicio.

## Notas sobre Delete

- Al montar el caso de uso de Delete ('DeletePokemonUseCase') todavia no se puede implementar realmente porque hay que implementarlo con un repositorio de datos.
- Por el momento se quedará en el estado que está actualmente para las comprobaciones actuales.