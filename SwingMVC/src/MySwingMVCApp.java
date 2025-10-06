
public class MySwingMVCApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Assemble all the pieces of the MVC
		  Model m = new Model("Drew", "Glover");
		  View v = new View("MVC with Drew");
		  Controller c = new Controller(m, v);
		  
		  
		  // create scanner
		  ProductScanner scanner = new ProductScanner(c,v,m);
		  
		  c.initController();
	}

}