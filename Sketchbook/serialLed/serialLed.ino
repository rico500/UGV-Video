int data;
int ledpin = 13;

void setup(){
  pinMode(ledpin, OUTPUT);
  Serial.begin(9600);
}

void loop(){
  
  if (Serial.available()){
    
    data = Serial.parseInt();
    
  }
  
    if(data == 1){
      digitalWrite(ledpin, HIGH);
    }
    else if(data == 0){
      digitalWrite(ledpin, LOW);
    }
}
