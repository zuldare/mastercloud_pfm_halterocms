# mastercloud_pfm_halterocms

# Índice
1. [Introducción](#intro)

    1.1 [Objetivos](#goals)

    1.2 [Halterofilia](#intro_haltero)

2. [Proceso unificado de desarrollo (RUP)](#rup)

3. [Modelo del dominio](#domainModel)

4. [Disciplina de requisitos](#requirements)

    4.1 [Actores y casos de uso](#useCasesActors")
 
    4.2 [Priorizar casos de uso](#useCasesPrioritize")

    4.3 [Especificación de casos de uso](#useCasesSpecification")
    
    4.4 [Estructurar el modelo de casos de uso](#useCasesStructure")
    
    4.5 [Prototipado interfaz de usuario](#useCasesPrototype")
 
5. [Disciplina de análisis](#analisis) 

    5.1 [Análisis de la Arquitectura](#architectureAnalisys)

    5.2 [Análisis de Caso de Uso](#usecaseAnalisys)

    5.3 [Análisis de Clases](#classesAnalisys)

    5.4 [Análisis de Paquetes](#packageAnalisys)
              
6. [Disciplina de Diseño](#design)

    6.1 [Diseño de la Arquitectura](#architectureDesign)
   
    6.2 [Diseño de Caso de Uso](#useCasesDesign)

    6.3 [Diseño de Clase](#classesDesign)

    6.4 [Diseño de Paquete](#packageDesign)

7. [Disciplina de Implementación](#implementation)
    
    7.1 [Implementar la Arquitectura](#Implementation)

    7.2 [Integración de Sistemas](#Implementation)

    7.3 [Implementar Clase](#Implementation)

    7.4 [Pruebas Unitarias](#Implementation)

    7.5 [Implementar Subsistema](#Implementation)

8. [Disciplina de Pruebas](#tests)

    8.1 [Planificar Pruebas](#planTests)

    8.2 [Diseñar Pruebas](#designTests)

    8.3 [Implementar Pruebas](#implementTests)

    8.4 [Realizar Pruebas de Integración](#integrationTests)

    8.5 [Realizar Pruebas de Sistemas](#systemTests)

    8.6 [Evaluar Pruebas](#evalTests)

9. [Bibliografía](#biblio)

## 1. Introducción<a name="intro"/>

El objetivo principal de este proyecto es el desarrollo de una aplicación para la creación y gestión integral de una competición de halterofilia, 
según la normativa de la Federación Española de Halterofilia (FEH), dirigido mediante el proceso de desarrollo RUP.

En los últimos años el deporte de la halterofilia ha crecido exponencialmente, debido a esto, es necesario que la gestión de competiciones se automatice
y se facilite todo lo posible tanto a jueces, espectadores, levantadores, etc el seguimiento de la competición.

### 1.1 Objetivos<a name="goals"/>

El objetivo principal del proyecto es el desarrollo de una aplicación web para la gestión integral de una competición de halterofilia. Para llevar a cabo este proyecto se va a utilizar el proceso unificado de desarrollo  Rational Unified Process (RUP)

Los subojetivos del proyecto son:
* Profundizar en el proceso de desarrollo RUP aplicado a un proyecto real.
* Realizar un proyecto focalizado en:  
    * Afianzar el correcto análisis y diseño
    * Aplicación correcta de diversos patrones
* Aplicación de un modelo de desarrollo basado en *Gitflow*
* Implementar un entorno de integración y despliegue continuos mediante el uso de:
    * Git como gestor de versiones
    * Github como repositorio (tanto de código como de artefactos)
    * Github project como administrador/organizador de tareas
    * Github Actions como herramienta de integración continua
* Despliegue de una aplicación en la nube mediante el proveedor AWS/Heroku *(!! TO BE DECIDED )*

### 1.2 ¿Qué es la halterofilia? <a name="intro_haltero"/>
La halterofilia es un deporte que consiste en el levantamiento del máximo peso posible de una barra a cuyos extremos se fijan varios discos de distinto peso.
Existen dos modalidades de competición *arrancada(snatch)* y *dos tiempos(clean&jerk)*

![snatch](images/Snatch2.gif)
![clean&jekr](images/Pscleanjerk.gif)

Se divide en categoría masculina y femenina. A su vez, ambas se subdividen en distintas categorías de acuerdo a la masa corporal y edad del atleta.

Más información

[Vídeo 1](https://www.youtube.com/watch?v=-zJeDy-gBr4)

[Vídeo_2](https://www.youtube.com/watch?v=l8oxCtwQdm0)

[Vídeo_3](https://www.youtube.com/watch?v=UcWjOqbZuo0&t=144s)

## 2. Proceso unificado de desarrollo (RUP)

El proceso unificado de desarrollo o RUP (Rational Unified Process)  es un proceso iterativo de desarrollo de software basado en componentes interconectados 
y bien definidos vía sus interfaces. RUP es un marco de trabajo que puede utilizarse en todo tipo de desarrollos.

Las tres principales características de RUP son las siguientes son (1) dirgido por casos de uso, (2) centrado en la arquitectura y (3) proceso iterativo incremental.

(1) Los casos de uso son la piedra angular para establecer el comportamiento deseado del sistema y cómo comunicar este comportamiento entre los diferentes implicados en el sistema. 
Nos sirven para capturar los requisitos funcionales correctamente representados, etc

(2) La arquitectura es usada como artefacto primordial para la conceptualización, construcción, gestión y evolución del sistema en desarrollo

(3) Iterativo implica que el proceso involucra un flujo de entregas ejecutables e incremental ya que con cada nueva entrega se proporciona un incremento respecto a la anterior

Las 5 disciplinas o flujos de trabajo de RUP son Requisitos, Análisis, Diseño, Implementación y Pruebas
![5_disciplines](images/RUP_1.png)
y cada una se divide en 4 fases: Inicio, Elaboración, Construcción y Transición. El esfuerzo dedicado a la realización de las actividades de las 
diferentes disciplinas depende del momento del proyecto en el que estemos
![Phases](images/RUP_2.png)

## 3. Modelo de dominio <a name="domainModel"/>
[Modelo del dominio](diagrams/modelDomain/competitionDomainModel.puml)
 
El modelo del dominio describre los conceptos más importantes del contexto del sistema como son:
* Objetos de negocio
* Objetos del mundo real y conceptos que un sistema necesita hacer un seguimiento
* Eventos que suceden o que sucederán en el sistema

El modelo del dominio también es importante, ya que nos ayuda a tener y consensuar un vocabulario común.

Para obtener el modelo del dominio se ha tenido en cuenta las necesidades actuales de la Federación Madrileña de Halterofilia
a la hora de realizar la gestión integral de una competición de halterofilia. Para ello se ha hablado con distintas personas de la federación 
para conocer los requisitos necesarios para cada uno de ellos.

En la Figura 1 se puede observar los objetos del dominio, sus relaciones y el vocabulario consensuado por el cliente.
![competitionDomainModel](images/modelDomain/competitionDomainModel.png)

El modelo de dominio nos puede ayudar también a tener una mejor comprensión de la organización destino. Un ejemplo de esto podría ser una muestra real de como se distribuyen las categorías oficiales en la halterofilia, tal y como se puede ver en la Figura 2.
![concreteCaseOfCategories](images/modelDomain/concreteCaseOfCategories.png)

## 3. Disciplina de requisitos <a name="requirements"/>

La disciplina de requisitos es el flujo de trabajo (realización de casos de uso que incluye roles, actividades y artefactos)
cuyo principal propósito es *dirigir el desarrollo hacia el sistema correcto* describiendo los requisitos del sistema
de tal manera que se alcance un contrato entre cliente, usuarios y desarrolladores sobre lo que el sistema debe hacer.

Objetivos:

*   Establecer y mantener el acuerdo entre clientes y otros implicados sobre lo que el sistema debería hacer
*   Proveer a los desarrolladores una mejor comprensión de los requisitos del sistema
*   Definir los límites del sistema
*   Proveer la base para planificar los contenidos técnicos de cada iteración

Las actividades recomendadas por RUP en esta disciplina son las siguientes:

1. Encontrar actores y casos de uso
2. Priorizar casos de uso
3. Especificación casos de uso
4. Estructurar el modelo de casos de uso
5. Prototipado de la interfaz de usuario 


### 3.1 Actores y casos de uso <a name="useCasesActors"/>
* Un actor especifica un rol que adopta una entidad externa cuando interactúa con el sistema **directamente** (no en respuesta)
  Si se necesita modelar cosas que suceden en el sistema en un tiempo específico pero que parece que no lo lanza ningún actor, se puede introducir el **actor tiempo**

* Un caso de uso es una **especificación de secuencias de acciones, incluyendo posibles variaciones, 
que el sistema puede realizar y que dan un resultado observable de interés a un actor particular**

En la Figura 3 podemos ver los actores que se han identificado, mientras que en el resto de figuras se representan los casos de uso identificados y los actores que los realizan
![actors](images/usecases/actors.png)

![organizationSecretary](images/usecases/organizationSecretary.png)

![batchesBureaucrazy](images/usecases/batchesBureaucrazy.png)

![competitionBureaucrazy](images/usecases/competitionBureaucracy.png)

![spectators](images/usecases/spectators.png)            

![timer](images/usecases/timer.png)


### 3.2 Priorizar casos de uso <a name="useCasePrioritize"/>
Hay que **determinar qué casos de uso seran desarrollados** (analizados, diseñados, implementados y probados) en
las primeras iteraciones y cuáles se pueden desarrollar en sucesivas iteraciones teniendo en cuenta factores como puedan ser aspectos técnicos, aspectos económicos, aspectos de negocio o cualquier tipo de riesgo



### 3.3 Especificación de casos de uso <a name="useCasesSpecification"/>

### 3.4 Estructurar el modelo de casos de uso <a name="useCasesStructure"/>

### 3.3 Prototipado interfaz de usuario <a name="useCasesPrototype"/>

#### Vista de espectador
![Vista de espectador](diagrams/prototypes/competitionPlay/spectatorboutview.png)

#### Vista de secretario de competición
![Vista de secretario de competición](diagrams/prototypes/competitionPlay/competitionsecretaryview.png)

#### Vista de calentamiento
![Vista área calentamiento](diagrams/prototypes/competitionPlay/athletewarmupareaview.png)

#### Vista de levantamiento
![Vista de secretario de levantamiento](diagrams/prototypes/competitionPlay/liftview.png)

#### Vista de temporizador
![Vista de secretario de temporizador](diagrams/prototypes/competitionPlay/timerview.png)

#### Vista de organizador
![Vista de secretario de organizador](diagrams/prototypes/manageCompetition/organizerview.png)


## 4. Disciplina de análisis <a name="analisis"/>

## 5. Disciplina de diseño <a name="design"/>

## 6. Disciplina de implementación <a name="implementation"/>

## 7. Disciplina de pruebas <a name="tests"/>
 

## Conclusiones <a name="conclusions"/>
## Autores <a name="authors"/>

👤 **Natalia Roales**

👤 **Jaime Hernández** 

## Bibliografía <a name="biblio"/>

[1] Kanban proyecto [webpage online]. Available: https://github.com/zuldare/mastercloud_pfm_halterocms/projects/1

[1] Github actions [webpage online]. Available: https://github.com/features/actions

[1] PlantUml [webpage online]. Available: [https://plantuml.com/es/](https://plantuml.com/es/)

[1] Pencil [herramienta]. Available: [https://pencil.evolus.vn/](https://pencil.evolus.vn/)


