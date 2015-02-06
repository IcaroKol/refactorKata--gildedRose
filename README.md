refactorKata--gildedRose
=======================

the introduction:
http://www.slideshare.net/gvespucci/refactoring-an-introduction?type=present

Kata

Hola y bienvenidos al equipo Gilded Rose. Como ustedes saben, somos una pequeña posada con una ubicación privilegiada en una ciudad prominente. Aqui compramos y vendemos sólo los mejores productos. Desafortunadamente, nuestros productos degradan constantemente la calidad cuando se acercan a su fecha de caducidad.

Tenemos un sistema que actualiza el inventario por nosotros. Fue desarrollado por un tipo absurdo llamado Leeroy, que ha pasado a nuevas aventuras. 

 Su tarea es agregar una nueva característica a nuestro sistema para que podamos comenzar a vender una nueva categoría de artículos. 


 En primer lugar una introducción a nuestro sistema:

Todos los artículos tienen un valor "Sellin" que indica el número de días que tenemos que vender el artículo

Todos los artículos tienen un valor de calidad que denota lo valioso que el artículo es.

Al final de cada día nuestro sistema reduce ambos valores para cada artículo,
Bastante simple, ¿verdad? Pues aquí es donde se pone interesante:

  Una vez que la fecha de caducidad ha pasado, la calidad se degrada dos veces más rápido.
  
  La calidad de un artículo nunca es negativo.
  
  El articulo "Brie Aged" en realidad aumenta en calidad cuanto más viejo se pone; Sin embargo la calidad de un artículo nunca es más de 50.
  
  "Sulfuras", al ser un objeto legendario, nunca debe ser vendido ni tampoco disminuye en la calidad.
  
  "Backstage passes", como "Brie Aged", Aumento su calidad de acuerdo a:
  
     Aumenta la calidad por 2 cuando hay 10 o menos días y por 3 cuando hay 5 días o menos, pero la calidad se reduce a 0 después del concierto (sellIn 0)

Hemos firmado recientemente con un proveedor de artículos conjurados. Esto requiere una actualización de nuestro sistema:

"Conjured"estos elementos degradan en Calidad el doble de rápido que los artículos normales

Siéntase libre de hacer cualquier cambio en el método UpdateQuality y añadir cualquier nuevo código, siempre que todo funcione correctamente. 

Sin embargo, no alteran la propiedad clase Item, pues esta clase al duende en la esquina que y se pondría furioso si sen entera, ya sabes el no cree en la propiedad colectiva del código.

Sólo una aclaración, un artículo nunca puede tener su calidad por encima de 50, sin embargo "Sulfuras" es un objeto legendario y como tal su calidad es 80 y nunca se altera.

========

to run report coverage use mvn package