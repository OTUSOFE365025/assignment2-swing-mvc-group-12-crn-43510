
import java.util.ArrayList;

public class Model {
	 private String firstname;
	 private String lastname;
	 //create 2d list to hold products
	 ArrayList<String> list = new ArrayList<>();
	 
	 public Model(String firstname, String lastname) {
	  this.firstname = firstname;
	  this.lastname = lastname;
	 }
	 
	 public String getFirstname() {
	  return firstname;
	 }
	 
	 public void setFirstname(String firstname) {
	  this.firstname = firstname;
	 }
	 
	 public String getLastname() {
	  return lastname;
	 }
	 
	 public void setLastname(String lastname) {
	  this.lastname = lastname;
	 }

	 public void updateList(String index, String name, String price) {
		//add product to list
		 list.add(index);
		 list.add(name);
		 list.add(price);
		 System.out.println("Products in cart: " + (list.size() / 3) + "\n");
	 }

	 public String Checkout() {
	     double  total = 0.00;
		 String receipt = "Receipt:\n";
		 for(int i = 0; i < list.size(); i+=3) {
			 receipt = (receipt + "UPC: " + list.get(i) + " Name: " + list.get(i+1) + " Price: $" + list.get(i+2) + "\n");
			 total = total + Double.parseDouble(list.get(i+2));
		 }
		 receipt = receipt + "Total: $" + String.format("%.2f", total);

		 return receipt;
	 }
}