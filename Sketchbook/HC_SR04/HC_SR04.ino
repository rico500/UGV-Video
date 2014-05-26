#define trigPin 7
#define echoPin 8

void setup() {
  Serial.begin (9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
}

void loop() {
  long microseconds, cm;
  
  digitalWrite(trigPin, LOW);  // Added this line
  delayMicroseconds(2); // Added this line
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10); // Added this line
  digitalWrite(trigPin, LOW);
  
  microseconds = pulseIn(echoPin, HIGH);
  cm = (microseconds/2) / 29.1;
  
  Serial.println(cm);
  
  delay(100);
  
}
