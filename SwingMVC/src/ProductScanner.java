// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

import java.awt.BorderLayout;
 

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

// import file handling and random number generation
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


public class ProductScanner {
	// Scanner uses Swing framework to create a UPC code
	 private JFrame frame;
	 private JPanel scannerPanel;
	 private JButton scanButton;
	 
	 private Controller c;

	 // 2D array to hold products read from file
	 public String products[][] = new String[5][3];

	 public ProductScanner(Controller c, View v, Model m) {
		  this.c = c;
		  frame = new JFrame("Scanner");
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(100, 100);
		  frame.setLocation(300,50);
		  frame.setVisible(true);
		  
		  
		  // Create UI elements
		  scanButton = new JButton("Scan");
		  JButton checkoutButton = new JButton("Checkout"); // checkout button
		  scannerPanel = new JPanel();
		  
		  // Add UI element to frame
		  scannerPanel.add(scanButton);
		  scannerPanel.add(checkoutButton);  // add checkout button to panel
		  frame.getContentPane().add(scannerPanel);
		  
		  scanButton.addActionListener(e -> generateUPC());
		  checkoutButton.addActionListener(e -> v.Checkout(m)); // call checkout function in model

          try {
            // Create object
            File file = new File("products.txt");

            if (file.createNewFile()) {
                // Create file if it doesnt exist
                System.out.println("File created: " + file.getName());

                // Write given products to the file
                FileWriter writer = new FileWriter(file);
                writer.write("12345, Coffee, 8.32\n67890, Muffin, 2.50\n74923, Bagel, 7.99\n67420, Donuts, 2.00\n41414, Banana, 1.67");
                writer.close();
                System.out.println("Products wrote to the file.");
            } else {
                // If file already exists, read file
                Scanner reader = new Scanner(file);
				int x = 0;

				// Read each line of the file and store in products 2d array
                while (reader.hasNextLine()) {
					String line = reader.nextLine();
					
					String[] productDetails = line.split(", ");
					for(int i = 0; i < 3; i++) {
						products[x][i] = productDetails[i];
					}
					
					x++;
                }
				System.out.println("Products read from file.\n");
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
	 }

	private int generateUPC() {
		// Generate random UPC code between 0 and 5
		Random rand = new Random();
		int upcCode = rand.nextInt(5);
		System.out.println("Scanned UPC code: " + products[upcCode][0]);
		System.out.println(products[upcCode][0] + " " + products[upcCode][1] + " " + products[upcCode][2]);

		//update list in model
		c.updateList(products[upcCode][0], products[upcCode][1],products[upcCode][2]);	

		return upcCode;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getScannerPanel() {
		return scannerPanel;
	}

	public void setScannerPanel(JPanel scannerPanel) {
		this.scannerPanel = scannerPanel;
	}

	public JButton getScanButton() {
		return scanButton;
	}

	public void setScanButton(JButton scanButton) {
		this.scanButton = scanButton;
	}	 
	 


}
