#include<stdlib.h>
#include <Servo.h>
#include <NewPing.h>

//Define pins for motor
#define A 12
#define B 11
#define E 3

//Define pins for Sensors
#define TRIGGER_PIN1  7  
#define ECHO_PIN1     8
#define TRIGGER_PIN2  2
#define ECHO_PIN2     3
#define TRIGGER_PIN3  4  
#define ECHO_PIN3     5
#define MAX_DISTANCE 200 

NewPing sonar1(TRIGGER_PIN1, ECHO_PIN1, MAX_DISTANCE); // NewPing setup of pins and maximum distance.
NewPing sonar2(TRIGGER_PIN2, ECHO_PIN2, MAX_DISTANCE);
NewPing sonar3(TRIGGER_PIN3, ECHO_PIN3, MAX_DISTANCE);

unsigned int pingSpeed = 200; // How frequently are we going to send out a ping (in milliseconds). 50ms would be 20 times a second.
unsigned long pingTimer;     // Holds the next ping time.
unsigned int cm1, cm2, cm3; //save distances

char dir;
int intspd;
int length;
int i;

Servo steer;

void setup(){
  Serial.begin(9600);
  
  pinMode(A, OUTPUT);
  pinMode(B, OUTPUT);
  pinMode(E, OUTPUT);
  
  steer.attach(10);
  
  pingTimer = millis(); // Start now.
}


void loop(){
  
  //if it's time to send a ping...
  if (millis() >= pingTimer) {   // pingSpeed milliseconds since last ping, do another ping.
    pingTimer += pingSpeed;      // Set the next ping time.
    sonar1.ping_timer(echoCheck1); // Send out the ping
    sonar2.ping_timer(echoCheck2);
    sonar3.ping_timer(echoCheck3);
    
    //send distances to raspberry
    Serial.print("s|");
    Serial.print(cm1);
    Serial.print("|");
    Serial.print(cm2);
    Serial.print("|");
    Serial.print(cm3);
  }
  
  //if there is something to read...
  if(Serial.available()){

    
    //get message and null terminate it
    char command[6];
    char spd[3];
    
    length = Serial.readBytesUntil('|', command, 6);
    command[length] = '\0';


    //Seperate the command (dir) from the option or speed(spd)
    dir = command[0];

    if (length > 1){
      for(i = 0; i+2<length; i++){
        spd[i] = command[i+2];
      }
    Serial.print(dir);
    Serial.print(" ");
    intspd = atol(spd);
    Serial.println(intspd);
    
    }
    else{
    Serial.println(dir);
    }    
    
    
    //handle the processed message
    switch (dir){
      case 'f':
        motor(intspd);
      break;
    
      case 's':
        motor(0);
      break;
    
      case 'b':
        motor(-intspd);
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

//motor control functions
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

void echoCheck1() { 
  if (sonar1.check_timer()) { 
    cm1 = sonar1.ping_result / US_ROUNDTRIP_CM;   
  }
}

void echoCheck2() { 
  if (sonar2.check_timer()) { 
    cm2 = sonar2.ping_result / US_ROUNDTRIP_CM;   
  }
}

void echoCheck3() { 
  if (sonar3.check_timer()) { 
    cm3 = sonar3.ping_result / US_ROUNDTRIP_CM;   
  }
}

