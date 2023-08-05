package model;


public class ServiceSale {
	
	private Sale sale;

	
/**
 * Metodo Constructor de la Clase ServiceSale
 * @param product
 * @param cant cantidad de la venta 
 */
	public  ServiceSale(Product product, int cant)throws Exception {
		
	
		if (cant > product.getStock() ) {
			throw new Exception ("productos insuficientes");
		}
	sale = new Sale(cant,product);
	}		
/**
 * Esteblece la venta
 * @param sale
 */
	public void setSale(Sale sale) {
		this.sale = sale;
	}

/**
 * Obtiene el objeto Sale asociado a este ServiceSale
 * @return sale
 */
	public Sale getSale() {
		return sale;
	}

}