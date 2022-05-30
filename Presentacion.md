# HalteroCMS

- Introducción (Jaime/Nat)
  - (Jaime)¿De qué va el proyecto? Xq un programa de halterofilia --> aquí un poco explicar que el programa surge para solventar un problema de la Federación de halterofilia blablalba
  - (Nat) ¿Xq hemos elegido este tipo de proyecto de "gestión"?
     - Querer experimentar un proceso de desarrollo completamente diferente a lo que estamos acostumbrados
     - Comprobar personalmene las ventajas y desventajas de un desarrollo hecho con RUP

- RUP
  - Algo muy breve acerca de lo que es rup y decir que sus principales características con 
     - Dirigido por casos de uso (y q nos vamos a hartar a casos de uso :D )
     - Centrado en la arquitectura
     - Proceso iterativo incremental (aquí es cuando podemos decir que por lo pequeño que era el proyecto no hemos trabajado así, pero que sí que hemos planteado distintos hitos de cara a futuro como iterar)
-(Jaime) Modelo del dominio
  - Explicar un poco muy por encima el modelo del dominio
  - Ventajas de hacer esto de primeras
    - Hemos establecido un vocabulario común entre todas las personas involucradas en el proyecto (desarrolladores y tutor) y que esto es una gran ventaja para grandes equipos, nuevas incorporaciones y conversaciones entre distintos equipos (dirección, desarrolladores, clientes, etc etc)
    - Llevar a tierra conceptos abstractos y ver una aproximación de las relaciones existentes entre objetos de dominio
    - Hacernos una idea de la magnitud de objetos que puede haber en el proyecto
  - Inconvenientes
    - Se ha trabajado mucho tiempo en esta parte
    - La "falsa idea" de no avanzo, xq como todavía estabamos tan lejos del código
  
- (Nat) Modelado de estados del dominio
  - El modelo anterior nos ha permitido realizar una serie de diagramas de estado para una competición y así tener una visión global de todas las "cosas" que habría que hacer
    - Diagrama estados de una competición (este lo podemos contar un poco)
    - Diagrama de estados de la ronda (de este podemos pasar por encima diciendo que es el mismo proceso que el anterior pero centrado en una ronda)


- Casos de uso
  - (Jaime) Actores y división de casos de uso: explicar los actores que hemos sacado y el xq hemos paquetizado (por el tema que nos comenta Luis de hablar de volúmenes)
  - (Jaime) Hemos sacado 14 + 15 + 13 + 12 + 16 = 70 casos de uso
  - (Jaime) Comentar de pasada por la priorización
  - (Nat) Comentar la espcificación de un caso de uso grande
  En todos estos comentar que nos ha costado un trabajo importante estar pensando bien que casos de uso sacar, como especificarlos y que nos hemos estado ciñendo a la frasecita de "esto es una conversación entre el actor y el sistema donde el actor pide y el sistema provee/pide "
  comentar que haciendo esta división por casos de uso se iba viendo la manera en la que se iban dividiendo responsabilidades y como eso en estapas finales podría ir diseñandose, etc , etc

- Prototipado  => nos ha permitido sobre el trabajo de los casos de uso hacernos un esquema mental de como van a ser las pantallas y que necesidades especiales nos podríamos encontrar


- Análisis de la arquitectura 
  - (Jaime) División en capas, con cada capa pendiente de una responsabilidad muy concreta . División en vistas modelos y controladores
  - (Nat) Análisis de un caso del caso de uso introduceWeighData

- Diseño 
  - (Nat) Explicación de la arquitectura MVP Controlador Supervisor que hemos usado
  - (Jaime) Exposición del diseño de casos de uso (general) y si quieren nos metemos a ver un diagrama de secuencia del introduce weigh in

- Implementación: 
  - hemos hecho TFD y xq no hemos hecho TDD (lo del diseño emergente )
  - hexagonal vs capas

- Comentario rápido sobre las pruebas

- Conclusiones