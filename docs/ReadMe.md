<div>
    <h1 align="center">
        「 ✦ 𝘛𝘳𝘢𝘣𝘢𝘫𝘰 𝘗𝘳á𝘤𝘵𝘪𝘤𝘰 𝘐𝘯𝘵𝘦𝘨𝘳𝘢𝘥𝘰𝘳 𝘓𝘢𝘣𝘰𝘳𝘢𝘵𝘰𝘳𝘪𝘰 𝘐𝘐𝘐  ✦ 」
    </h1>
</div>
<div align="center">
    <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://detorero.com/wp-content/uploads/2020/04/image.png">
        <source media="(prefers-color-scheme: light)" srcset="https://detorero.com/wp-content/uploads/2020/04/image.png">
        <img alt="Muestra un sol ilustrado en el modo claro y una luna con estrellas en el modo oscuro." src="[URL-de-imagen-por-defecto]" style="max-width: 100%; height: auto;">
    </picture>
</div>

<div align="left">
    <h2>👥 Integrantes:</h2>

| Nombre                   | GitHub                                                      |
|--------------------------|-------------------------------------------------------------|
| Almeida Misael           | [405313 - Almeida Misael](https://github.com/405313-Almeida) |
| Artusa Manuel            | [114393 - Artusa Manuel](https://github.com/114393-Artusa-Manuel) |
| Barrionuevo Santiago     | [405862 - Barrionuevo Santiago](https://github.com/405862)   |
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
| Paredes Esteban          | [405226 - Paredes Esteban](https://github.com/405226)       |
| Ramira Sanna Rain        | [114005 - Ramira Sanna Rain](https://github.com/114005-RAMIRA) |
| Sandoval Juan Agustin    | [114245 - Sandoval Juan Agustin](https://github.com/114245) |
</div>

## ✏️Diagrama:

<div align="center">
    <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://github.com/LCIII-2023/tpi-estanciero-2w1-g1/blob/main/docs/NuevoDiagramaUML.jpg?raw=true"> 
        <source media="(prefers-color-scheme: light)" srcset="https://github.com/LCIII-2023/tpi-estanciero-2w1-g1/blob/main/docs/NuevoDiagramaUML.jpg?raw=true">
        <img alt="" src="https://github.com/LCIII-2023/tpi-estanciero-2w1-g1/blob/main/docs/NuevoDiagramaUML.jpg?raw=true" style="max-width: 100%; height: auto;">
    </picture>
</div>


## ✍Descripción

**TABLERO**  
Clase que utiliza la clase 'Casilla', contiene un arreglo de estas y, a su vez, estas casillas pueden ser de varios tipos.

**CASILLA**  
Clase que será un array en la clase Tablero, representa los distintos tipos de casillas (Comisaría, marche preso, destino, suerte, propiedad) y los distintos métodos (acciones) que desencadenará cada una.

**PEON**  
Clase encargada de las acciones que un jugador/bot puede realizar, como tirar dados, comprar estancias, vender estancias.

**DADO**  
Clase encargada de generar dos números aleatorios de 1 a 6.

**BANCO**  
Clase encargada de contener todos los billetes que no han sido asignados a los jugadores.

**BILLETE**  
Unidad monetaria del juego utilizada para realizar transacciones. Puede tener distintos valores.

**TARJETA**  
Interfaz que contiene todos los comportamientos que serán implementados por los diferentes tipos de tarjetas en el juego.

**PROPIEDAD**  
Interfaz que contiene los métodos que serán implementados para las diferentes propiedades, ya sean escrituras o empresas.

**JUEGO**  
Clase encargada de definir el inicio y fin del juego, utilizando las clases de control del juego (modo de juego, jugabilidad, transacción y movimiento).

**MODO_JUEGO**  
Interfaz encargada de seleccionar la dificultad de la personalidad/modo de juego de bot utilizando las clases (modo difícil, medio, fácil).

**MODO_DIFICIL**  
Clase encargada de modificar la personalidad/modo de juego de bot en modo difícil.

**MODO_MEDIO**  
Clase encargada de modificar la personalidad/modo de juego de bot en modo medio.

**MODO_FACIL**  
Clase encargada de modificar la personalidad/modo de juego de bot en modo fácil.

**JUGADOR**  
Clase encargada de recibir los inputs del cliente/usuario que vaya a jugar y realizar los métodos, como tirar dados, comprar, vender.

**BOT**  
Clase que contiene los atributos y métodos pertinentes a los bots contra los que se enfrentará el jugador.

**PERFIL_JUGADOR**  
Clase que contiene el perfil de jugador para los distintos bots según el nivel de dificultad.

**PERFIL_AGRESIVO**  
Clase que contiene el perfil agresivo para bots de mayor dificultad.

**PERFIL_CONSERVADOR**  
Clase que contiene el perfil conservador para bots de baja dificultad.

**PERFIL_EQUILIBRADO**  
Clase que contiene el perfil equilibrado para bots de todas las dificultades.

**TRANSACCION**  
Clase que interactúa con el banco para comprar y vender estancias, chacras y provincias.

**MOVIMIENTO**  
Clase encargada de gestionar la interacción entre la clase de jugador/bot y el tablero (con sus respectivas casillas). Lleva un control del identificador de la casilla específica y realiza una comparación constante con la ubicación relativa del jugador/bot.

**ESTADO**  
Clase para implementar el patrón de diseño State para el manejo de estados del peón/jugador como preso, estacionando, alquilando, etc.

**COMISARIA (CÁRCEL)**  
Clase que impide que un jugador o bot realice cualquier movimiento durante 3 turnos.

**MARCHE_PRESO**  
Clase que envía al jugador/bot a la Cárcel.

**IMPUESTO**  
Casilla en la que, cuando un jugador o bot se posiciona sobre ella, debe pagar un monto.

**EMPRESA**  
Clase que contiene los atributos y métodos de las tarjetas que son empresas. Estas no pueden adquirir chacras ni estancias, pero sí pueden cobrar alquiler.

**SUERTE**  
Clase que representa la tarjeta "Suerte". Contiene los métodos que serán implementados para las diferentes acciones de las distintas tarjetas.

**DESTINO**  
Clase que representa la tarjeta "Destino". Contiene los métodos que serán implementados para las diferentes acciones de las distintas tarjetas.

**ESCRITURAS**  
Interfaz que define los métodos generales que serán implementados en chacra y estancia.

**CHACRA**  
Clase que contiene propiedades (nombre, costo, etc.) que se pueden comprar.

**ESTANCIA**  
Clase que representa una propiedad que se puede comprar. Es un conjunto de 4 chacras.

**FERROCARRILES**  
Clase que contiene propiedades (Nombre, precio, etc.) que se pueden comprar.

**COMPAÑÍAS**  
Clase que contiene propiedades (Nombre, precio, etc.) que se pueden comprar.

**PROVINCIA**  
Tipo de casilla que pertenece a una zona en particular (zona norte, zona sur, zona centro) y que se puede comprar.

**GAMEPLAY**  
Clase encargada de instanciar a los jugadores (en base al modo de juego seleccionado), al banco con todas las propiedades en su poder, y al peón (jugador). También se encargará de controlar los movimientos (clase Movimiento) y las transacciones (clase Transacción).

**BODEGA**  
Clase que contiene propiedades (Precio, nombre, etc.).

## 🎮Descripción de la Experiencia de Usuario**

La experiencia del usuario comienza al iniciar el juego, se presentará un menú principal que ofrecerá dos opciones: "Jugar" o "Salir". Si el jugador elige "Jugar", aparecerá otro menú pidiendo al jugador que seleccione el color que desea utilizar en el juego.

Luego se presentará un menú para seleccionar la dificultad del juego en la que tendrá que elegir entre 3 tipos (Facil, Medio, Dificil), según la elección se asigna la cantidad de jugadores a los que se enfrenta. Una vez seleccionada, se ofrecerá la opción de elegir si se puede ganar la partida por cantidad de valores totales(si elige tal opción deberá ingresar la cantidad a la que debe llegar). Luego de elegir alguna opción se informará que el juego comienza.

A partir de ahí, todos los jugadores tiran los dados y aquel que obtenga el número más alto comenzará primero. Una vez determinado el orden, la ronda 1 comenzó y así sucesivamente se informará el inicio de cada ronda.

Cada jugador tirará los dados para determinar la cantidad de casillas que su peón se moverá. Si cae en una propiedad, se mostrará una pantalla para decidir si se desea comprar esa propiedad o no; si es que la misma no está comprada por otro jugador, caso contrario deberá pagar alquiler. Además, se agregará la opción de vender la propiedad desde un menú de opciones, permitiendo al jugador seleccionar si desea vender la propiedad al banco.

Si el jugador llega a un casillero de suerte o destino, se le mostrará un mensaje con el evento correspondiente de esa tarjeta, en caso de que sea una tarjeta de uso como salir de la cárcel se guardará hasta que se pueda hacer uso de la misma.

A medida que avanzan las rondas, los jugadores comprarán las escrituras correspondientes y al cumplir los requisitos podrá comprar chacras, pagando el valor indicado en la tarjeta y si ya adquirió 4 chacras podrá comprar una estancia.

Al finalizar el turno del jugador, tendrá la opción de continuar hacia la siguiente ronda o finalizar el juego hasta completar el monto total seleccionado en el inicio del juego.

Al finalizar el juego de una manera u otra(ya sea alcanzando el valor importe establecido o eligiendo la opción de finalizar), aparecerá un podio que mostrará el primer, segundo y tercer puesto. El jugador también tendrá la opción de jugar nuevamente o cerrar el juego.

## ⚔️Eventos

Los eventos posibles con los que se pueda encontrar el jugador dependen de la casilla donde caiga el mismo tras tirar los dados:

- **Dados Dobles:** 
El jugador que al tirar los dados, su número coincida deberá jugar su turno nuevamente, pero si sucede tres veces consecutivas va preso.

- **Marche Preso:** 
Al caer en esta casilla el jugador deberá ir al casillero Comisaría y para salir deberá pagar una fianza de $1000, sacar doble en dados, usar alguna tarjeta de suerte o esperar 1 turno. Cuando el jugador está preso no puede cobrar alquiler.

- **Cárcel:** 
El jugador que cae aquí no se considera preso, pero si viene de la casilla marche preso sí lo está.

- **Descanso:** 
El jugador se puede quedar en el casillero 3 turnos si desea, pero si saca doble en dados deberá continuar.

- **Escrituras:** 
Si la escritura no está comprada, el jugador podrá adquirirla si así lo desea. En cambio, si ésta ya fuese adquirida previamente por otro jugador deberá pagar el alquiler correspondiente a la tarjeta y según la cantidad de chacras/estancia que tenga compradas el dueño.

- **Compra de Todas las Escrituras en una Provincia:** 
El jugador que adquiriese todas las escrituras de una provincia ya puede adquirir chacras o estancias para la misma.

- **Empresas:** 
Similar a la escritura en el sentido de adquirir y pagar alquiler pero no se pueden poner chacras ni estancia en la casilla de empresas.

- **Premio o Impuesto:** 
Al caer en esta casilla el jugador recibirá un premio del banco o pagará un impuesto al mismo según se indique en la casilla.

- **Suerte y Destino:** 
Al caer en la casilla el jugador le tocará una tarjeta de Suerte o Destino al azar, la cual puede tener beneficios, misiones o perjuicios.

# PATRONES DE DISEÑO

Los patrones de diseño que utilizaremos en este proyecto son:

- **Patron Singleton**
Utilizamos este patrón para asegurarnos de que las clases tengan una única instancia para que el acceso a la misma sea único. Lo utilizaremos en `Tablero` y `Banco`.

- **Patron Observer**
Para el manejo de eventos del juego, al cambiar el estado de algún objeto que se notifique a los objetos que dependen de ese objeto. Lo utilizaremos en `IPeon`.

- **Patron Strategy**
Para desacoplar el uso del modo de juego de la implementación de este.



