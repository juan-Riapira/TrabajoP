package presenter;

import model.ETypeProduct;
import model.Product;
import model.Sale;
import model.ServiceSale;

public class Presenter {

	private ServiceSale serviceSale;

	Product product1;
	Product product2;
	Product product3;
	Product product4;
	Product product5;

	/**
	 * constructor clase Presenter
	 */
	public Presenter() {

	

		// serviceSale= new ServiceSale(null, 0);

		product1 = new Product("jabon", 1000, 10, true, ETypeProduct.ASEO);
		product2 = new Product("arroz", 2000, 15, false, ETypeProduct.VIVERES);
		product3 = new Product("acetaminofen", 2500, 11, false, ETypeProduct.MEDICINAS);
		product4 = new Product("mani", 3000, 3, false, ETypeProduct.RANCHO);
		product5 = new Product("whisky", 3500, 5, false, ETypeProduct.LICORES);
	}

	/**
	 * Agrega ventas
	 * 
	 * @param name
	 * @param valor
	 * @param cant
	 * @param iva
	 * @param eTypeProduct
	 * @return double
	 */
	public double addSale(String name, double valor, int cant, boolean iva, ETypeProduct eTypeProduct)throws Exception {

		Product product = null;

		if (eTypeProduct == ETypeProduct.ASEO) {
			product = product1;
		} else if (eTypeProduct == ETypeProduct.VIVERES) {
			product = product2;
		} else if (eTypeProduct == ETypeProduct.LICORES) {
			product = product5;
		} else if (eTypeProduct == ETypeProduct.MEDICINAS) {
			product = product3;
		} else if (eTypeProduct == ETypeProduct.RANCHO) {
			product = product4;
		} else {
			Product productos;
		}

		//ServiceSale serviceSale;
		serviceSale= new ServiceSale(product, cant);

		Sale sale = serviceSale.getSale();
		serviceSale.setSale(sale);
		return sale.getTotalSale();
	}

	/**
	 * Muestra la informacion de la venta tipo factura
	 * 
	 * @return String
	 */
	public String showSale()  {
		Sale sale = serviceSale.getSale();
		double totalSales = sale.getTotalSale();
		double totalIva = sale.calcIva();
		double totalDiscount = sale.calcDiscount();

		double average = totalSales;

		StringBuilder result = new StringBuilder();
		result.append("El total de la venta realizada es: ").append(totalSales).append("\n");
		result.append("El valor gravado (IVA) acumulado es: ").append(totalIva).append("\n");
		result.append("El valor del descuento acumulado es: ").append(totalDiscount).append("\n");
		result.append("El promedio de las ventas realizadas es: ").append(average).append("\n");

		return result.toString();
	}

}
