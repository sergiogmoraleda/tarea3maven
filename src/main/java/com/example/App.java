package com.example;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.Scanner;


public class App {

	public static void menu() throws  org.json.simple.parser.ParseException{
		final Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int opcion = -1;
		Logger logger = Logger.getLogger("App");
		logger.info("Bienvenido al Water Sort Puzzle");
		while (!salir) {

			logger.info("\nIntroduce número para escoger una opcion y pulse Enter\n "
					+ " 1.- Leer un problema.json (Por defecto p0.json). \n"
					+ " 2.- Escribir un Problema. \n" + "0.- Salir del programa \n");
			opcion = sc.nextInt();

			switch (opcion) {
				case 1:



					Problema problema;
					try {
						problema = new Problema("src/main/java/com/example/p0.json");
						Estado e = new Estado(problema.getInitState().getEstado(), problema.getBottleSize());
					e.toString();
					String stringEstado = e.getStringEstadoCorrecto();
					
					logger.log(java.util.logging.Level.SEVERE, "hash del estado correcto:{0}", JsonUtil.getHashMD5(stringEstado));
					
					 int estrategia = 0;
					logger.log(java.util.logging.Level.SEVERE,"Problema elegido: {0}", problema);
					do {
						logger.log(java.util.logging.Level.SEVERE,"Ahora debe elegir estrategia:\n" +
								"1.- BREADTH \n" + "2.- DEPTH \n" + "3.- UNIFORM \n" + "4.- GREEDY \n" +
								"5.- A \n");
						estrategia = sc.nextInt();

					} while (estrategia < 1 || estrategia > 5);

					String estrategiaString = seleccionarEstrategia(estrategia);
					logger.log(java.util.logging.Level.SEVERE, "Estrategia elegida: {0} \n", estrategiaString);
					

					// resolvemos problema
					algoritmoBusqueda(problema, estrategiaString, 1000000);
				} catch (IOException e1) {
					logger.log(java.util.logging.Level.SEVERE, "Error al leer el fichero: {0}", e1.getMessage());
					
				}
 
					break;

					case 0:
						salir = true;
						break;
					default:				
						logger.info("Opcion no valida");
			}
		}
		sc.close();
					

					
	}

    // ALGORITMO DE BUSQUEDA
    public static boolean algoritmoBusqueda(Problema p, String estrategia, int prof) {

        boolean encontrado = false;
        Nodo nActual = null;
        Nodo nodoInicial = new Nodo(0.0, p.getInitState(), null, null, 0, 0, 0);
        nodoInicial.setValor(nodoInicial.calcularValorEstrategia(estrategia, nodoInicial));

        Frontera frontera = new Frontera();
        frontera.clear();
        frontera.add(nodoInicial);

        Map<String, Double> visitados = new HashMap<>(); // mapa de nodos visitados
        List<Nodo> listaNodosSolucion = new ArrayList<>();

        while (!frontera.isEmpty() && !encontrado) {
            nActual = frontera.remove();
            if (p.esObjetivo(nActual.getEstado())) {
                encontrado = true;

            } else {
                if (nActual.getProfundidad() < prof && !visitados.containsKey(nActual.getEstado().md5())) {
                    visitados.put(nActual.getEstado().md5(), nActual.getValor());
                         
						 List<Sucesor> sucesores = p.getSucesores(nActual.getEstado());
                    

					List<Nodo> listaNodosSucesores = generarListaNodos(sucesores, nActual, prof, estrategia);
                    // expandimos frontera
                    for (Nodo n : listaNodosSucesores) {
                        n.setValor(n.calcularValorEstrategia(estrategia, n));
                        frontera.add(n);
                    }
                }


            }
            // si encontramos sol
            if (encontrado) {
                while (nActual.getPadre() != null) {
                    listaNodosSolucion.add(nActual);
                    nActual = nActual.getPadre();
                }
                listaNodosSolucion.add(nActual);// este es el nodo inicial
                Collections.reverse(listaNodosSolucion);
                for (Nodo n : listaNodosSolucion) {
                    System.out.println(n.toString());
                }
            }

        }
        return encontrado;

    }
	
    public static List<Nodo> generarListaNodos(List<Sucesor> sucesores, Nodo nodo, int prof, String estrategia) {
        List<Nodo> listaNodos = new ArrayList<>();
        
        if (nodo.getProfundidad() < prof) {
			Nodo nodoAux = null;
            for (Sucesor s : sucesores) {
                switch (estrategia) {
                    case "BREADTH":
                        nodoAux = new Nodo(nodo.getCostoAcumulado() + s.getCosto(), s.getEstado(), nodo, s.getAccion(),
                                nodo.getProfundidad() + 1, 0, nodo.getProfundidad() + (double)1);
                        break;
                    case "DEPTH":
                        nodoAux = new Nodo(nodo.getCostoAcumulado() + s.getCosto(), s.getEstado(), nodo, s.getAccion(),
                                nodo.getProfundidad() + 1, 0, (1.0 / (nodo.getProfundidad() + 1)));
                        break;

                    case "UNIFORM":
                        nodoAux = new Nodo(nodo.getCostoAcumulado() + s.getCosto(), s.getEstado(), nodo, s.getAccion(),
                                nodo.getProfundidad() + 1, 0, nodo.getCostoAcumulado() + s.getCosto());
                        break;

                    default:
                        break;
                }
                listaNodos.add(nodoAux);

            }
        }
        return listaNodos;
    }


	public static String seleccionarEstrategia(int estrategia) {
		String estrategiaSeleccionada = "";
		switch (estrategia) {
			case 1:
				estrategiaSeleccionada = "BREADTH";
				break;
			case 2:
				estrategiaSeleccionada = "DEPTH";
				break;
			case 3:
				estrategiaSeleccionada = "UNIFORM";
				break;
			case 4:
				estrategiaSeleccionada = "GREEDY";
				break;
			case 5:
				estrategiaSeleccionada = "A";
				break;
			default:
				estrategiaSeleccionada = "BREADTH";
				break;
		}
		return estrategiaSeleccionada;
	}

	public static void main(String[] args) throws org.json.simple.parser.ParseException {

		menu();

	}

}
