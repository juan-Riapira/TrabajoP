package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.ETypeProduct;
import model.Product;
import presenter.Presenter;

public class Runner {

	private Presenter presenter;

	/**
	 * metodo contructor de la clase Runner
	 */
	public Runner() {
		
		presenter = new Presenter();
	}

	/**
	 * Metodo Principal
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Runner runner = new Runner();

		double totalEnd = 0;
		int contador = 0;

		int option = 0;
		int a;
		do {
			do {

				System.out.println("Ingrese \n1 - Crear venta\n2 - Otra opción");
				option = sc.nextInt();
				if (option != 1 && option != 2) {
					System.out.println("ingrese un valor Correcto");
				}

			} while (option != 1 && option != 2);

			switch (option) {
			case 1:
				System.out.println(
						"PRODUCTOS DISPONIBLES \n" + 
				                   "1 .NOMBRE :jabon        VALOR: 1000  CANTIDAD: 10 ,IVA TRUE  , TIPO DE PRODUCTO ASEO");
				System.out.println("2 .NOMBRE :arroz        VALOR: 2000  CANTIDAD: 15 ,IVA TRUE  ,  TIPO DE PRODUCTO  VIVERES");
				System.out.println("3 .NOMBRE :acetaminofen VALOR: 2500  CANTIDAD: 11 ,IVA false , TIPO DE PRODUCTO  MEDICINAS");
				System.out.println("4 .NOMBRE :mani         VALOR: 3000  CANTIDAD: 3  ,IVA TRUE  ,  TIPO DE PRODUCTO  RANCHO");
				System.out.println("5 .NOMBRE :whisky       VALOR: 3500  CANTIDAD: 5  ,IVA TRUE  ,  TIPO DE PRODUCTO  LICORES");
				System.out.println("");

				System.out.println("Ingrese nombre");
				String nombre = sc.next().toUpperCase();

				int stock=0;
				do {
			        try {
			        	 System.out.println("Ingrese cantidad de compra");
			        	    stock = sc.nextInt();
			        	    
			        } catch (InputMismatchException ex) {
			            System.out.println("Error: Ingrese una opción válida!!");
			            sc.next();
			        }
			    } while (stock <= 0);

				String typeProduct=null;
				
				do {
			        try {
			        	System.out.println("ingrese el tipo de producto (LICORES,ASEO,RANCHO,MEDICAMENTOS,VIVERES)");
				 typeProduct = sc.next().toUpperCase();
			        } catch (InputMismatchException ex) {
			            System.out.println("Error: Ingrese una opción válida!!");
			            sc.next();
			        }
			    } while (stock <= 0);
				
				double total=0.0;
				try {
					total = runner.presenter.addSale(nombre, 0, stock, true, ETypeProduct.valueOf(typeProduct));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("productos insuficientes");
					System.out.println("cerrando programa..");
					System.exit(0);
				}

				System.out.println("Total de la venta: " + total);

				totalEnd = totalEnd + total;
				contador++;
				break;

			case 2:
				System.out.println("Ingresar productos \n" + "muyyy pronto .....");
				System.out.println("cerrando programa ......");
				System.exit(0);

				break;

			default:
				System.out.println("Opción inválida");
			}
			// Mostrar información de las ventas al finalizar
			System.out.println(runner.presenter.showSale());

			System.out.println(
					"ingrese\n 1. para hacer otra compra  \n2. para ver el total de ventas y el  promedio");
			a = sc.nextInt();
		} while (a == 1);

		System.out.println("El total de las ventas es de " + totalEnd);
		System.out.println("el promedio es " + totalEnd / contador);
	}
}
