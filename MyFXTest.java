// ------------------------------------------------------------------------------------------------------------//
// MyFXTest.java				Author: Debra Ragland					Assignment 5 CPSC50100				   //
//																											   //
//Program is designed to generate an image roughly similar to a QR Code.											   //	
//-------------------------------------------------------------------------------------------------------------//


import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyFXTest extends Application {

	public void start(Stage primaryStage) {
		
//Start building the image "stage" to contain three larger squares and their centers as seen in many QR codes and one smaller square. 
		Rectangle qrbase = new Rectangle(0, 0, 512, 512);
		qrbase.setFill(Color.WHITE);

		Rectangle topleft = new Rectangle(5, 5, 100, 100);
		topleft.setStroke(Color.BLACK);
		topleft.setStrokeWidth(15);
		topleft.setFill(null);

		Rectangle topleftcent = new Rectangle(25, 25, 60, 60);
		topleftcent.setFill(Color.BLACK);

		Rectangle topright = new Rectangle(412, 5, 100, 100);
		topright.setStroke(Color.BLACK);
		topright.setStrokeWidth(15);
		topright.setFill(null);

		Rectangle toprightcent = new Rectangle(432, 25, 60, 60);
		toprightcent.setFill(Color.BLACK);

		Rectangle bottomleft = new Rectangle(5, 412, 100, 100);
		bottomleft.setStroke(Color.BLACK);
		bottomleft.setStrokeWidth(15);
		bottomleft.setFill(null);

		Rectangle bottomleftcent = new Rectangle(25, 432, 60, 60);
		bottomleftcent.setFill(Color.BLACK);

		Rectangle mid = new Rectangle(300, 300, 50, 50);
		mid.setStroke(Color.BLACK);
		mid.setStrokeWidth(10);
		mid.setFill(null);

		Rectangle midcent = new Rectangle(320, 320, 12, 12);
		midcent.setFill(Color.BLACK);
		
//Generates random rectangles between the 4 squares shown on the stage above, with minimal to no overlap with 4 base squares. 
// Generation of random numbers are used to place randomly sized rectangles on the stage. Perhaps setTranslate() could've worked,
// 	but I wanted the rectangles to be in specific ranges. 
		
		Group root = new Group();
		Random square = new Random();
		
		
		for(int count = 1; count <= 500; count++) {
			int min = 100;
			int max = 300;
			//int min3 = 200;
			int min2 = 400;
			int max2 = 500;
			
			int x = square.nextInt((max-min) + 1) + min;
			int y = square.nextInt((max-min) + 1) + min;
			
			//int xstretch = square.nextInt((max2-max) + 1) + max;
			int xstretch2 = square.nextInt((min2-min) + 1) + min;
			int ystretch = square.nextInt((min2-min) + 1) + min;
			int ystretch2 = square.nextInt((max2-min) + 1) + min;
			//int ysmush = square.nextInt((max- min3) + 1);
			
			//int x2 = x-200;
			//int y2 = y;
			
			int x3 = x+250;
			//int y3 = y;
			
			//int x4 = x;
			int y4 = ystretch-110;
			
			//int x5 = x;
			int y5 = y+250;
			
			
			int width = square.nextInt(20)+1;
			int height = square.nextInt(20)+1;
			
			Color fill = null;
			if(width > 10 && height > 4)
				fill = Color.BLACK;
			
			
			//Rectangle boxes = new Rectangle((x-15), (ysmush + 250), width, height);
			//boxes.setFill(fill);
			//boxes.setFill(Color.BLACK);
		
			
			Rectangle leftsideboxes = new Rectangle((xstretch2-110), ystretch, width, height);
			//leftsideboxes.setFill(Color.BLACK);
			leftsideboxes.setFill(fill);
			//leftsideboxes.setFill(Color.RED);
			
			
			Rectangle rightsideboxes = new Rectangle(x3, ystretch2, width, height);
			rightsideboxes.setFill(fill);
			//rightsideboxes.setFill(Color.BLACK);
			//rightsideboxes.setFill(Color.GREEN);
			
			
			Rectangle topboxes = new Rectangle(xstretch2, y4, width, height);
			//topboxes.setFill(Color.BLACK);
			topboxes.setFill(fill);
			//topboxes.setFill(Color.BLUE);
			
			Rectangle bottombox1 = new Rectangle(xstretch2, y5, width, height);
			//bottombox1.setFill(Color.BLACK);
			bottombox1.setFill(fill);
			//bottombox1.setFill(Color.YELLOW);
			
			
			root.getChildren().addAll(leftsideboxes, rightsideboxes, topboxes, bottombox1);
				
		}
		
		Group root1 = new Group(qrbase, root, topleft, topleftcent, topright, toprightcent, bottomleft, bottomleftcent, mid, midcent);
		Scene scene = new Scene(root1, 520, 520, Color.WHITE); //Compile the components above together.

		primaryStage.setTitle("Ragland QR Code");
		primaryStage.setScene(scene);
		primaryStage.show();//Show compiled QR code. 
	}

	public static void main(String[] args) {
		launch(args);
	}
}
