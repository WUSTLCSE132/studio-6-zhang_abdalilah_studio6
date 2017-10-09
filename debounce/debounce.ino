#include <Arduino.h>
#include <Wire.h>

const int buttonPin = 2;
int count = 0;
bool buttonState = 1;
//int lastButtonState = LOW;

unsigned long lastDebounceTime = 0;  
unsigned long debounceDelay = 50;

/*void buttonPressed() {
  Serial.begin(9600);
  if (millis() - lastDebounceTime >= 50){
    count++;
    Serial.println(count);
    lastDebounceTime = millis();

  }
 }*/

/*void buttonPressed1() {
  Serial.begin(9600);
  lastDebounceTime = millis();
    
  }*/
  
void buttonPressed() {
  Serial.begin(9600);
  if (buttonState  == 1)
  {
    buttonState = !buttonState;
    lastDebounceTime = millis();
  }

  else 
  {
    if (millis() - lastDebounceTime >= 50)
    {
      count++;
      pprint(count);
    }

    buttonState = !buttonState;
  }
}

void pprint(int n){
  Serial.println(n);
}
void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, CHANGE);
  //attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed1, FALLING);
  Serial.begin(9600);
}

void loop() { 


}
