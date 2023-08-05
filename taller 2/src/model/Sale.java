package model;

public class Sale {
	private int cant;
	private Product product;

	/**
	 * Constructor clase Sale
	 * @param cant
	 * @param product
	 */
	public Sale(int cant, Product product) {
		super();
		this.cant = cant;
		this.product = product;

	}

	/**
	 * Establece el producto
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Obtien el producto
	 * 
	 * @return Product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Establece la cantidad del producto
	 * @param amount
	 */

	public void setCant(int amount) {
		this.cant = cant;
	}
/**
 * obtiene la cantidad del producto
 * @return int
 */
	public int getCant() {
		return cant;
	}

	/**
	 * Este metodo se encarga de calcular el descuento de la venta Si el valor de la
	 * venta es menor igual a 50000 se le aplica un descuento de 5% Si el valor de
	 * la venta es mayor a 50000 y menor igual a 80000 se le aplica un descuento del
	 * 10% si el valor de la venta es mayor 80000 se le aplica un descuento del 15%
	 * 
	 * @return int
	 */
	public int calcDiscount() {
		if (getTotalSale() <= 50000.0) {
			return ((int) getTotalSale() * 5) / 100;
		} else if (getTotalSale() > 50000.0 & getTotalSale() <= 80000.0) {
			return ((int) getTotalSale() * 10) / 100;
		} else {
			return ((int) getTotalSale() * 15) / 100;
		}

	}

	/**
	 * Este metodo se encarga de calcular el total de la venta multiplicando el
	 * valor por la unidades
	 * 
	 * @return double
	 */
	public double getTotalSale() {
		return cant * product.getValue();
	}

	/**
	 * Calcula el valor del Impuesto al Valor Agregado (IVA) para el producto
	 * 
	 * @return double
	 */
	public double calcIva() {

		double ValIva = switch (product.geteTypeProduct()) {
		case ASEO -> product.getValue() * 0.14;
		case VIVERES -> product.getValue() * 0.08;
		case LICORES -> product.getValue() * 0.19;
		case MEDICINAS -> product.getValue() * 0;
		case RANCHO -> product.getValue() * 0.19;
		default -> 0.0;

		};
		return ValIva;

	}

}
