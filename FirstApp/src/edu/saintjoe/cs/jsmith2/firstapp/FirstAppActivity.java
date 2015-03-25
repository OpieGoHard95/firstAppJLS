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
	private Button dumbButton;
	private Label resultLabel;
	private Button chaacButton;
	private Label chaacLabel;

 // Java Bridger apps all use $define() in place of main()
 void $define() {
 	
 	// Code in this block is equivalent to the "Designer" part of App Inventor
    
	 // "this" is an Activity object, or the "main screen"
     this.BackgroundColor(COLOR_WHITE);
     
     // Create containers for UI widgets
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);
     line4 = new HorizontalArrangement(this);
     
     // Now create the user interface
     dumbButton = new Button(line1,"Go ahead and push me ;)");   
     resultLabel = new Label(line2,"");
     chaacButton = new Button(line3, "Who is Chaac?");
     chaacLabel = new Label(line4,"");
     
     
     
     // Let the runtime system know which events to report to the dispatcher
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    
 } // end $define()

 // This method, known as a "callback" is invoked by the runtime system
 // It will only be called when a delegated event occurs
 @Override
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	
 	// This code is equivalent to the "Blocks" part of App Inventor
	    if (component.equals(dumbButton) && eventName.equals("Click")){
	    	resultLabel.Text("See that wasn't so bad");
	    	dumbButton.Text("I like to be pushed");
	        return true;
	     } // end dispatch '+' press
	    if (component.equals(chaacButton) && eventName.equals("Click")){
	    	chaacLabel.Text("THE RAIN GOD!");
	    	return true;
	    }
	// This line is syntactically required
    return true;
	} // end dispatchEvent


} // end activity class
