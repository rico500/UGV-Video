#include <Servo.h> 

#define A 12
#define B 11 
#define E 10

Servo steer;

void setup(){
  pinMode(A, OUTPUT);
  pinMode(B, OUTPUT);
  pinMode(E, OUTPUT);
  
  Serial.begin(9600);
  
  steer.attach(9);
}

void loop(){
  if(Serial.available() > 0){
    char command = Serial.read();
    Serial.write(command);
    
    switch (command){
      case 'f':
        motor(200);
      break;
    
      case 's':
        motor(0);
      break;
    
      case 'b':
        motor(-80);
      break;
    
      case 'r':
        steer.write(130);  
      break;
      
      case 'c':
        steer.write(90);
      break;
      
      case 'l': 
        steer.write(50);
      break;
    }
  }
}


void motor(int speedo){
  if (abs(speedo) > 255){
    halt();
  }
  else if (speedo > 0){
   forward(speedo);
  }
  else if (speedo < 0){
    backward(abs(speedo));
  }
  else if (speedo == 0){
    halt();
  }
}

void forward(int speedo){
  digitalWrite(A, HIGH);
  digitalWrite(B, LOW);
  analogWrite(E, speedo);
}
//backward function
void backward(int speedo){
  digitalWrite(A, LOW);
  digitalWrite(B, HIGH);
  analogWrite(E, speedo);
}
//halt function
void halt(){
  digitalWrite(A, LOW);
  digitalWrite(B, LOW);
  digitalWrite(E, LOW);
}
