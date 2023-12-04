/*
   Temperature Alarm
*/
float sinVal;
int toneVal;
int redPin = 9;
int greenPin = 11;
int bluePin = 10; 
unsigned long tepTimer ;

void notetone( int freq, int dura) {
   tone(8, freq);
    delay(dura);
    noTone(8);
    delay(50);
}

void setup(){
    pinMode(8, OUTPUT);
    pinMode(redPin, OUTPUT);
    pinMode(greenPin, OUTPUT);
    pinMode(bluePin, OUTPUT);
    Serial.begin(9600);
}
void colorRGB(int red, int green, int blue){
analogWrite(redPin,constrain(red,0,255));
analogWrite(greenPin,constrain(green,0,255));
analogWrite(bluePin,constrain(blue,0,255));

}
void loop(){
    int val;
    double data;
    val=analogRead(0);
    data = (double) val * (5/10.24);  // convert the voltage to temperture

    if(data>28){        // If the temperture is over 27 degree, buzzer will alarm.
          colorRGB(150,0,220);
          notetone(130, 50);
          notetone(130, 50);
          notetone(146, 100);
          notetone(130,100);
          notetone(174,100);
          notetone(164,150);
    
     
    }else {    // If the temperturn is below 27 degree, buzzer will not alarm
           noTone(8);
           colorRGB(0,0,0);
    }

    if(millis() - tepTimer > 500){     // output the temperture value per 500ms
             tepTimer = millis();
             Serial.print("temperature: ");
             Serial.print(data);
             Serial.println("C");
       }
}
