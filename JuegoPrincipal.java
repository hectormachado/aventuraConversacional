package aventuraConv;

import java.util.Scanner;

public class JuegoPrincipal {
	
	
	/*
	 Falta--
	 Se repiten objetos
	 No controlo bien la llave
	 */
	
	/*
	 Items: llave, espada, corona, dinero, antorcha, escalera, nota.
	 Acciones: mover, coger, dejar, usar, encender, apagar, hablar, ver, dar.
	 
	 Mover: arriba, abajo, izquierda, derecha, subir, bajar.
	 Hablar: nota, cocinera.
	 Ver: mochila, cocinera, jordijor.
	 Dar: dinero.
	 Coger/Dejar/Usar: (los Items).
	 Encender/Apagar: antorcha.
	 */
	
	static boolean final_juego = false;
	static cMapa mapa[] = new cMapa[10]; 
	static cPersonaje jugador = new cPersonaje();
	static cPersonaje cocinera = new cPersonaje();
	static cPersonaje jordijor = new cPersonaje();
	static cItems items[] = new cItems[7];	
	static cItems espada = new cItems("Espada Magicabre", "Con esta los enemigos caen de 1 golpe.");
	static cItems llave = new cItems("Llave principal", "Abre el dormitorio de mas importante.");
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		crear_mapa();
		
		crear_Items();
		
		crear_PJ();
		
		System.out.println("AVENTURA CONVERSACIONAL");
		
		while (final_juego  == false) {
			
			jugar();
		}
		
	}
	
	private static void jugar() {
		
		String accion, sujeto;
		System.out.println("Zona " + jugador.getPosicion().getId());
		
		
		seVeAlgo();		
		
		accion = teclado.next().toLowerCase();
		sujeto = teclado.next().toLowerCase();

		switch(accion) {
	
		case"mover":
			mover(sujeto);
			break;
		case"coger":
			coger(sujeto);
			break;
		case"dejar":
			dejar(sujeto);
			break;
		case"usar":
			usarItem(sujeto);
			break;
		case"encender":
			encender(sujeto);
			break;
		case"apagar":
			apagar(sujeto);
			break;
		case"hablar":
			interactuar(sujeto);
			System.out.print(teclado.nextLine());
			break;	
		case"ver":
			verMochila(sujeto);
			System.out.print(teclado.nextLine());
			break;

		default:
		System.out.println("Accion Incorrecta, vuelve a probar");
		
		break;
		
		
			}
		
		}

	private static void continuar() {
		
		String opcion;
		
		System.out.println("Ya que has terminado, sea ganando o perdiendo");
		System.out.println("y te has divertido, te gustaria jugar otra vez?");
		System.out.println("Si: continuar   No: terminar");
		
		opcion = teclado.next();
		
		if(opcion.equalsIgnoreCase("si")) {
			final_juego = false;
			
			crear_mapa();
			
			crear_Items_Despues();
			
		}else if(opcion.equalsIgnoreCase("no")){
			System.out.println("Gracias por jugar");
			System.out.println("Se acabo!!\n");
			final_juego = true;
		}
	}
	
	private static void crear_PJ() {
		
		jugador.setNombre("CarloBon");
		jugador.setPosicion(mapa[7]);
		jugador.setAlto(false);
		
		cocinera.setNombre("");
		cocinera.setPosicion(mapa[1]);
		
		jordijor.setNombre("Jordijor");
		jordijor.setPosicion(mapa[9]);

	}
	
	private static void crear_Items() {
		
		items[1] = new cItems("Nota de papel", "Tiene algo escrito, y esta manchada con algun tipo de salsa.");
		items[2] = new cItems("Saco de dinero", "Un puñado de monedas que pudiste ahorrar.");
		items[3] = new cItems("Antorcha", "Con ella podras iluminar tu camino.");
		items[4] = new cItems("Escalera", "Con ella podras acceder a sitios mas altos, no crees?");
		items[6] = new cItems("Corona Real", "Perteneciente a un rey, actualmente era de JordiJor, pero ahora es tuya.");
		
		items[0] = llave;
		items[5] = espada;
		
		llave.setAlto(true);
		
		espada.setTengo(true);
		items[2].setTengo(true);
		
		mapa[0].ponerItemsArrayZona(items[0]);
		mapa[8].ponerItemsArrayZona(items[4]);
		mapa[5].ponerItemsArrayZona(items[3]);
		mapa[6].ponerItemsArrayZona(items[1]);
		mapa[9].ponerItemsArrayZona(items[6]);
		
		jugador.ponerItemsArrayJugador(items[5]);
		jugador.ponerItemsArrayJugador(items[2]);
		
		jordijor.ponerItemsArrayJugador(items[6]);
		
	}

	private static void crear_Items_Despues() {
		
		llave.setAlto(true);
		
	mapa[0].ponerItemsArrayZona(items[0]);
	mapa[8].ponerItemsArrayZona(items[4]);
	mapa[5].ponerItemsArrayZona(items[3]);
	mapa[6].ponerItemsArrayZona(items[1]);
	mapa[9].ponerItemsArrayZona(items[6]);
	
	jugador.vaciarArrayList();
	
	jugador.ponerItemsArrayJugador(items[5]);
	jugador.ponerItemsArrayJugador(items[2]);

	jugador.setPosicion(mapa[7]);
		
	}
	
	private static void crear_mapa() {
		
		
		
		mapa[0] = new cMapa("Almacen de comida", "Esta oscuro, pero ves varias estanterias y "
				+ "una caja sospechosa arriba del armario.\n Acciones: mover coger dejar encender apagar ver", false);
		mapa[1] = new cMapa("Cocina real", "Es una cocina muy grande, huele muy bien, " +
				"quien sera la cocinera? \n Acciones: coger dejar interactuar ver", true);
		mapa[2] = new cMapa("Comedor principal","Ves una mesa enorme con platos, y en algunos todavia "
				+ "quedan restos de comida. \n Acciones: mover coger dejar ver", true);
		mapa[3] = new cMapa("Cuarto de baño","Todo muy limpio y reluciente, me pregunto como limpiaran "
				+ "la parte superior.. \n Acciones: mover coger dejar ver", true);
		mapa[4] = new cMapa("Zona central","Hay muchas puertas y se ven unas escaleras hacia las habitaciones "
				+ "\nprincipales, pero parece que estan cerradas.. \n Acciones: mover coge dejar usar ver", true);
		mapa[5] = new cMapa("Sala de estar","Hay un sofa, una mesa, y una chimenea, da un calor interesante "
				+ "y hay mucha luz. \n Acciones: mover coger dejar ver", true);
		mapa[6] = new cMapa("Establos","Huele un poco mal, ves varios caballos y sus monturas, "
				+ "parece que alguien olvido algo. \n Acciones: mover coger dejar ver", false);
		mapa[7] = new cMapa("Pasillo principal","Enorme pasillo, con estatuas a los lados del nuevo rey, "
				+ "tambien hay una larag alfombra roja \n Acciones: mover coger dejar ver", true);
		mapa[8] = new cMapa("Salon de baile y eventos","Es una habitacion inmensa, con asientos, zona de baile "
				+ "y un altar para eventos. \n Acciones: mover coger dejar ver", true);
		mapa[9] = new cMapa("Dormitorio principal","Es el principal del castillo, donde duerme el rey, hay una"
				+ " gran cama donde duerme Jordijor. \n Acciones: mover coger interactuar ver", true);
		
		
		mapa[0].setId(0);
		mapa[0].setDerecha(mapa[1]);
		mapa[0].setAbajo(mapa[3]);

		mapa[1].setId(1);
		mapa[1].setDerecha(mapa[2]);
		mapa[1].setIzquierda(mapa[0]);
		
		mapa[2].setId(2);
		mapa[2].setIzquierda(mapa[1]);
		mapa[2].setAbajo(mapa[5]);

		mapa[3].setId(3);
		mapa[3].setArriba(mapa[0]);
		mapa[3].setAbajo(mapa[6]);
		mapa[3].setDerecha(mapa[4]);
	
		mapa[4].setId(4);
		mapa[4].setIzquierda(mapa[3]);
		mapa[4].setDerecha(mapa[5]);
		mapa[4].setAbajo(mapa[7]);
		mapa[4].setSubir(mapa[9]);

		mapa[5].setId(5);
		mapa[5].setArriba(mapa[2]);
		mapa[5].setAbajo(mapa[8]);
		mapa[5].setIzquierda(mapa[4]);

		mapa[6].setId(6);
		mapa[6].setArriba(mapa[3]);

		mapa[7].setId(7);
		mapa[7].setArriba(mapa[4]);
	
		mapa[8].setId(8);
		mapa[8].setArriba(mapa[5]);
	
		mapa[9].setId(9);
		mapa[9].setBajar(mapa[4]);
			
		}

	private static void mover(String sujeto) {
		
		switch(sujeto) {
		
		case"arriba":
			if(jugador.getPosicion().miraSiTengoArriba()) {
				
				jugador.setPosicion(jugador.getPosicion().getArriba());
				
			}else {
				
				System.out.println("Un snorlax bloquea tu paso, no puedes pasar!!");
				
			}break;
			
		case"abajo":
			if(jugador.getPosicion().miraSiTengoAbajo()) {
				
				jugador.setPosicion(jugador.getPosicion().getAbajo());
				
			}else {
				
				System.out.println("Un snorlax bloquea tu paso, no puedes pasar!!");
				
			}break;
			
		case"izquierda":
			if(jugador.getPosicion().miraSiTengoIzquierda()) {
				
				jugador.setPosicion(jugador.getPosicion().getIzquierda());
				
			}else {
				
				System.out.println("Un snorlax bloquea tu paso, no puedes pasar!!");
				
			}break;
			
		case"derecha":
			if(jugador.getPosicion().miraSiTengoDerecha()) {
				
				jugador.setPosicion(jugador.getPosicion().getDerecha());
			}else {
				
				System.out.println("Un snorlax bloquea tu paso, no puedes pasar!!");
				
			}break;
			
		case"subir":
			if(jugador.getPosicion().miraSiPuedoSubir()) {
				
				jugador.setPosicion(jugador.getPosicion().getSubir());
			}else {
				
				System.out.println("Un snorlax bloquea tu paso, no puedes pasar!!");
				
			}break;
			
		case"bajar":
			if(jugador.getPosicion().miraSiPuedoBajar()) {
				
				jugador.setPosicion(jugador.getPosicion().getBajar());
			}else {
				
				System.out.println("Un snorlax bloquea tu paso, no puedes pasar!!");
				
			}break;	
			
		default:
		System.out.println("Verbo Incorrecto, vuelve a probar");
		break;
			
			};
		
	}

	private static void dejar(String sujeto) {
		switch (sujeto) {
		
		case"antorcha":
			jugador.quitarItemsArrayJugador(items[3]);
			jugador.getPosicion().ponerItemsArrayZona(items[3]);
			items[3].setTengo(false);
			System.out.println("Has dejado el item.");
			break;
		
		case"escalera":
			jugador.quitarItemsArrayJugador(items[4]);
			jugador.getPosicion().ponerItemsArrayZona(items[4]);
			items[4].setTengo(false);
			System.out.println("Has dejado el item.");
			break;
		
		case"llave":
			jugador.quitarItemsArrayJugador(llave);
			jugador.getPosicion().ponerItemsArrayZona(llave);
			llave.setTengo(false);
			System.out.println("Has dejado el item.");
			break;
		
		case"nota":
			jugador.quitarItemsArrayJugador(items[1]);
			jugador.getPosicion().ponerItemsArrayZona(items[1]);
			items[1].setTengo(false);
			System.out.println("Has dejado el item.");
			break;
		
		case"corona":
			jugador.quitarItemsArrayJugador(items[6]);
			jugador.getPosicion().ponerItemsArrayZona(items[6]);
			items[6].setTengo(false);
			System.out.println("Has dejado el item.");
			break;
		
		case"dinero":
			jugador.quitarItemsArrayJugador(items[2]);
			jugador.getPosicion().ponerItemsArrayZona(items[2]);
			items[2].setTengo(false);
			System.out.println("Has dejado el item.");
			break;
		
		case"espada":
			System.out.println("Oak: “Este no es el momento de dejar eso”");
			//jugador.quitarItemsArrayJugador(items[5]);
			//jugador.getPosicion().ponerItemsArrayZona(items[5]);
			
			break;
		}
	}
	
	private static void coger(String sujeto) {
		switch (sujeto) {
		
		case"antorcha":
			if(jugador.getPosicion()==items[3].getPosicion())
			jugador.ponerItemsArrayJugador(items[3]);
			jugador.getPosicion().quitarItemsArrayZona(items[3]);
			items[3].setTengo(true);
			System.out.println("Has cogido el item.");
				break;
			
		case"escalera":
			jugador.ponerItemsArrayJugador(items[4]);
			jugador.getPosicion().quitarItemsArrayZona(items[4]);
			items[4].setTengo(true);
			System.out.println("Has cogido el item.");
			break;
			
		case"llave":
			jugador.ponerItemsArrayJugador(items[0]);
			jugador.getPosicion().quitarItemsArrayZona(items[0]);
			llave.setTengo(true);
			System.out.println("Has cogido el item.");
			break;
		
		case"nota":
			jugador.ponerItemsArrayJugador(items[1]);
			jugador.getPosicion().quitarItemsArrayZona(items[1]);
			items[1].setTengo(true);
			System.out.println("Has cogido el item.");
			break;
		
		case"corona":
			jugador.ponerItemsArrayJugador(items[6]);
			jugador.getPosicion().quitarItemsArrayZona(items[6]);
			items[6].setTengo(true);
			System.out.println("Has cogido el item.");
			break;
		
		case"dinero":
			jugador.ponerItemsArrayJugador(items[2]);
			jugador.getPosicion().quitarItemsArrayZona(items[2]);
			items[2].setTengo(true);
			System.out.println("Has cogido el item.");
			break;
		
		case"espada":
			jugador.ponerItemsArrayJugador(espada);
			jugador.getPosicion().quitarItemsArrayZona(espada);
			espada.setTengo(true);
			System.out.println("Has cogido el item.");
			break;
		
		default:
			System.out.println("No has podido coger el item");
			break;
		}
		
	}

	private static void apagar(String sujeto) {
				switch(sujeto) {
				
				case"antorcha":	
					
					if(jugador.getPosicion().hayLuzONo() == true) {
						jugador.getPosicion().setLuz(false);						
					}
					System.out.println("Se apago la luz");
					
				break;
				}
	}
	
	private static void encender(String sujeto) {
				switch(sujeto) {
				
				case"antorcha":	
					
					if(jugador.getPosicion().hayLuzONo() == false) {
						jugador.getPosicion().setLuz(true);
					}
					System.out.println("Se encendio la luz");
					
				break;
		}

	}

	private static void seVeAlgo() {
		
		if(jugador.getPosicion().hayLuzONo()==true) {
		System.out.println(jugador.getPosicion().infoZona());
		jugador.getPosicion().recorrerArrayZona();
		}else{
		System.out.println("\n ????????????????");
		System.out.println("Esta tan oscuro que no ves ni donde estas");
		System.out.println("Si hubiera algo para ver mejor...\n");
		}
	}
	
	private static void interactuar(String sujeto) {
		switch(sujeto) {
		
		case"nota":	
			if(items[1].isTengo()==true) {
			System.out.println("Acuerdate de traer");
			System.out.println("el dinero donde te dije.");
			System.out.println("No se puede enterar nadie");
			System.out.println("o estamos muertos");
			}else {
			System.out.println("no tienes ese item");
			}
			
			break;
			
		case"cocinera":
			if(jugador.getPosicion()==cocinera.getPosicion()) {
				
			String accion, sujeto1;
			System.out.println("Hola caballero, creo que no deberia estar aqui");
			System.out.println("Esto es la cocina. \nAcciones: dar");
			
			accion = teclado.next().toLowerCase();
			sujeto1 = teclado.next().toLowerCase();
			
			switch(accion) {
			case "dar":
				switch(sujeto1) {
				case"dinero":
					if(items[2].isTengo()==true) {
					jugador.quitarItemsArrayJugador(items[2]);
					cocinera.ponerItemsArrayJugador(items[2]);
					
					System.out.println("Veo que hablamos de lo mismo");
					System.out.println("Soy la cocinera del anterior rey, este no me gusta");
					System.out.println("Siempre con cosas de titis, pero si quieres acabar con el");
					System.out.println("yo te puedo ayudar con algo, necesitaras algo de luz");
					System.out.println("pero en el almacen guardan una copia de la llave del dormitorio principal,");
					System.out.println("tiene que estar en la parte alta de los estantes,");
					System.out.println("no digo mas, venga vete!!");
					}else {
						System.out.println("No tienes el item.\n");
					}
				break;
				
				default:
					System.out.println("No se de que me hablas, yo solo cocino.\n");
					break;
				}
			}
		}else {
			System.out.println("Que hago hablando solo...");
		}
			
		}
	}

	private static void verMochila(String sujeto) {
		switch(sujeto) {
		case"mochila":
			jugador.recorrerArrayPersonaje();
			
			break;
		case"cocinera":
			cocinera.recorrerArrayPersonaje();
			
			break;
		case"jordijor":
			jordijor.recorrerArrayPersonaje();
			
			break;
		}
	}

	private static void usarItem(String sujeto) {

		switch(sujeto) {
		
			case"espada":
				
				if(jugador.getPosicion()==mapa[9]) {
					System.out.println("Sacas la espada, estas delante de la cama");
					System.out.println("ver a Jordijor durmiendo");
					System.out.println("Estas seguro de querer acabar con su vida?");
					String opcion = teclado.next();
					
					if(opcion.contentEquals("si")) {
						System.out.println("Lo has matado\n");
						
						continuar();

					}else {
						System.out.println("Te han matado\n");
						
						continuar();
					}
					break;
				}

			case"llave":
				if(jugador.getPosicion()==mapa[4] && llave.isTengo()==true) {
					System.out.println("Se ha abierto la puerta hacia el dormitorio,");
					System.out.println("solo resta subir para acabar con todo.");
				break;
				}else {
					System.out.println("No tienes la llave, prueba a buscar por algun lado");
				}
				break;
				
			case"escalera":
				
				if(jugador.getPosicion()==mapa[0] && jugador.bajoAlto()==false) {						
						System.out.println("Gracias a la escalera, puedes ver la parte superior de los ");
						System.out.println("estantes, ves una caja la abres y ves la llave que dijo la cocinera\n");
						System.out.println("Acciones: coger");
						
						jugador.setAlto(true);
					break;
				}
				
				default:
				System.out.println("Oak: “Este no es el momento de usar eso”");
				break;
				}
	}

}

