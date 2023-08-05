package model;

public class Product {
	// atributos 
	    private String name;
	    private double value;
	    private int stock;
	    private boolean iva;
	    private ETypeProduct eTypeProduct;
	    public static final int STOCK_MIN=10;
	    
	   
	    
	    
		public Product(String name, double value,int stock ,  boolean iva,ETypeProduct eTypeProduct) {
			super();
			this.name = name;
			this.value = value;
			this.iva = iva;
			this.stock=stock;
			this.eTypeProduct=eTypeProduct;
		}



		public String getName() {
			return name;
		}



		private void setName(String name) {
			this.name = name;
		}



		public double getValue() {
			return value;
		}



		private void setValue(double value) {
			this.value = value;
		}



		public int getStock() {
			return stock;
		}



		public void setStock(int stock) {
			this.stock = stock;
		}
  
		
		public void setIva(boolean iva) {
			this.iva = iva;
		}
		
		public boolean isIva() {
			return true;
		}


		public ETypeProduct geteTypeProduct() {
			return eTypeProduct;
		}



		public void seteTypeProduct(ETypeProduct eTypeProduct) {
			this.eTypeProduct = eTypeProduct;
		}



		@Override
		public String toString() {
			return "Product [name=" + name + ", value=" + value + ", stock=" + stock + ", iva=" + iva
					+ ", eTypeProduct=" + eTypeProduct + "]";
		}
		
		
		
	
	
}
