## ARQUITECTURA
## PRESENTATION: El contacto del usuario con nuestra app, a traves del endpoint
## BUSINESS: Los ervicios de Spring que consumen el API RESTful de Pokemon, procesan los datos y prepara para ser consumidos o expuestos en el servicio SOAP
## DATA: El concepto similar se aplica para nuestro Pokemon schema y Pokemon model

## PATRONES
# PATRON DTO: Usado para representar los datos de los Pokemons en el formato requerido por el servicio SOAP. Por ejemplo, el objeto Pokemon en el schema generado actúa como un DTO al transferir datos entre la lógica de negocio de tu aplicación(entre servicios) y el servicio SOAP que expone estos datos.
# PATRON DAO: Manteniendo el principio de persistencia, se aplica este enfoque separando la lógica de acceso a la API RESTful (consumo de Pokémon API REST) en un servicio dedicado(PokemonService). Este servicio interactura con la API REST y retorna los datos necesarios para ser consumidos con el servicio SOAP
