package logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ETypeProduct;
import model.Product;
import model.Sale;
import model.ServiceSale;

class test {
	private Sale Sale;
	Product jabon;
	Product whisky;
	Product arroz;
	Product acetaminofen;
	Product mani;
	

	
	
	private ServiceSale serviceSale;

	public void setup() {

		jabon = new Product("jabon ", 3000.0, 40, true, ETypeProduct.ASEO);
	     arroz = new Product("Arroz", 2000, 15, true, ETypeProduct.VIVERES);
	     acetaminofen = new Product("acetaminofen",2500,11,false, ETypeProduct.MEDICINAS);
	     mani = new Product("mani",2500,11,true, ETypeProduct.RANCHO);
	     whisky = new Product("whisky",2500,11,true, ETypeProduct.LICORES);
	}
	@Test
	void testCalcDiscount() {
		setup();
		Sale = new Sale(1, jabon);
		assertEquals(150, Sale.calcDiscount());
		
		Sale = new Sale(16, arroz);
		assertEquals(1600, Sale.calcDiscount());
		
		Sale = new Sale(1, acetaminofen);
		assertEquals(125, Sale.calcDiscount());
		
		Sale = new Sale(20, whisky);
		assertEquals(2500, Sale.calcDiscount());

	}

	@Test
	void testGetTotalSale() {
		setup();
		Sale = new Sale(10, jabon);
		assertEquals(30000.0, Sale.getTotalSale());
		
		Sale = new Sale(16, arroz);
		assertEquals(32000.0, Sale.getTotalSale());
		
		Sale = new Sale(1, acetaminofen);
		assertEquals(2500, Sale.getTotalSale());
		
		Sale = new Sale(20, whisky);
		assertEquals(50000, Sale.getTotalSale());
	}
	

	@Test
	void testCalcIva() {
		
		setup();
		
		Sale = new Sale(10, jabon);
		assertEquals(30000.0, Sale.getTotalSale());
		
		Sale = new Sale(20, acetaminofen);
		assertEquals(0, Sale.calcIva());
		
		Sale = new Sale(1, whisky);
		assertEquals(475, Sale.calcIva());
		
	}

}
