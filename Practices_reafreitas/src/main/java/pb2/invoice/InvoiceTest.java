package pb2.invoice;

import java.util.ArrayList;

public class InvoiceTest {

	public static void main(String[] args) {

		ArrayList<Product> storage = new ArrayList<>();

		storage.add(new Product("Computador A", "A description", 1200, 2));
		storage.add(new Product("Computador B", "B description", 1300, 1));
		storage.add(new Product("Computador C", "C description", 1400, 3));
		storage.add(new Product("Computador D", "D description", 1500, 2));
		storage.add(new Product("Computador E", "E description", 1600, 1));
		storage.add(new Product("Computador F", "F description", 1700, 2));

		Invoice invoice = new Invoice("Company info and date, etc.");
		invoice.addProduct(storage.get(0), 2);
		invoice.addProduct(storage.get(0), 1);
		invoice.addProduct(storage.get(1), 1);
		invoice.addProduct(storage.get(2), 4);
		
		invoice.printInvoice();

	}
}

class Invoice {

	private String companyInfo;
	private ArrayList<InvoiceLine> lines;

	public Invoice(String companyInfo) {
		this.companyInfo = companyInfo;
		lines = new ArrayList<InvoiceLine>();
	}

	public boolean addProduct(Product product, int quantity) {
		if(product.getStock() >= quantity) {
			product.decrementStock(quantity);
			InvoiceLine line = new InvoiceLine(product, quantity, product.getPrice());
			lines.add(line);
			return true;
		}
			
		return false;
	}

	public void printInvoice() {
		System.out.println("Company info");
		System.out.printf("%2s\t%-10s\t%s\t%s\t%s%n", "N", "Product", "Quant.", "Price", "Total");
		for(int i = 0; i < lines.size(); i++) {
			System.out.printf("%2d\t%s%n", i+1, lines.get(i).printLine());
		}
	}
	
}

class InvoiceLine {

	private Product product;
	private int quantity;
	private double price;
	private double total;
	
	public InvoiceLine(Product product, int quantity, double price) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	private double getTotal() {
		return quantity * price;
	}
	
	public String printLine() {
		return String.format("%s\t%3d\t%.2f\t%.2f", product.getName(), quantity, price, getTotal());
	}
	
}

class Product {

	private String name;
	private String description;
	private double price;
	private int stock;

	public Product(String name, String description, double price, int stock) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void decrementStock(int quantity) {
		if(stock >= quantity)
			stock -= quantity;
	}
}