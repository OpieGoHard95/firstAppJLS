// Two notes here:
//   1. You must rename this and put in your username
//   2. You must comment out this line to compile with "javac"
package edu.saintjoe.cs.jsmith2.firstapp;

// Jared Smith
// Double Code
import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Form;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;
import com.google.devtools.simple.runtime.events.EventDispatcher;

// This is the only class file for our app
public class FirstAppActivity extends Form implements HandlesEventDispatching {

	
	// We begin with constants, and "global settings" variables
	// -- This app has none for now
	
	// Next are the UI widget references
	
	// These objects are equivalent to "components" of App Inventor
	// The containers which organize the app screen
	private HorizontalArrangement line1;
	private HorizontalArrangement line2;
	private HorizontalArrangement line3;
	private HorizontalArrangement line4;
	

	// Next our two components
	private Button resetButton;
	private Label textLabel;
	private Button dubButton;
	private Label resultLabel;
	private TextBox numberBox;
	

 // Java Bridger apps all use $define() in place of main()
 void $define() {
 	
 	// Code in this block is equivalent to the "Designer" part of App Inventor
    
	 // "this" is an Activity object, or the "main screen"
     this.BackgroundColor(COLOR_WHITE);
     
     // Create containers for UI widgets
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);
   
     
     // Now create the user interface
     dubButton = new Button(line2,"Double It!");   
     resultLabel = new Label(line3,"Result will appear here!");
     resetButton = new Button(line2, "Reset");
     textLabel = new Label(line1,"Enter a Number");
     numberBox = new TextBox(line1, "");
     numberBox.NumbersOnly(true);
     
     // Let the runtime system know which events to report to the dispatcher
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    
 } // end $define()

 // This method, known as a "callback" is invoked by the runtime system
 // It will only be called when a delegated event occurs
 @Override
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	
 	// This code is equivalent to the "Blocks" part of App Inventor
	    if (component.equals(dubButton) && eventName.equals("Click")){
	    	String s = numberBox.Text();
	    	int i = Integer.parseInt(s);
	    	int di = (i * 2);
	    	String dub = Integer.toString(di);
	    	resultLabel.Text(dub);
	        return true;
	     } // end dispatch '+' press
	    if (component.equals(resetButton) && eventName.equals("Click")){
	    	resultLabel.Text("");
	    	numberBox.Text("");
	    	return true;
	    }
	// This line is syntactically required
    return true;
	} // end dispatchEvent


} // end activity class
