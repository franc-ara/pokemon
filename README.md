# pokemon
Web Service que consume https://pokeapi.co/

### Pre-requisitos 📋

_Software necesario para ejecutar el web service_

```
Java 21
```
```
Maven
```
```
Docker(opcional)
```
```
Cliente SOAP - SOAP UI
```

### Instalación

_Clonar el proyecto y ubicarse en la raíz, se puede ejecutar el proyecto usando docker-compose, es necesario tener docker instalado y ejecutandose, posteriormente ejecutar el comando_


```
docker-compose up
```

_Abrir SOAP UI o algún otro cliente SOAP e importar el archivo pokedex.xml, es el WSDL del proyecto, también se puede generar el WSDL abriendo http://localhost:8080/ws/pokedex.wsdl y guardar como XML. En la etiqueta pokemonRequest sustituir ? por el nombre del pokemon que se desea buscar y enviar la petición _

```
<pok:pokemonRequest>?</pok:pokemonRequest>
```
_En caso de no tener docker instalado ejecutar el comando _

```
mvn spring-boot:run
```

_En este caso si es necesario tener instalado Java 21 y maven, posteriormente se puede consumir el servicio de la misma forma que el paso anterior, importando el WSDL y consumir alguno de los métodos _
