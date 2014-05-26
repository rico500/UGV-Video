#define LEDPIN 13

void setup(){
  Serial.begin(9600);
  pinMode(LEDPIN, OUTPUT);
}

void loop(){
  
  if(Serial.available()){
    char message = Serial.read();
    
    switch(message){
      case 'i':
        digitalWrite(LEDPIN, HIGH);
      break;
      
      case 'o':
        digitalWrite(LEDPIN, LOW);
      break;
    }
  }
}
