int led = 12;
int value = 0;
void setup() {
  Serial.begin(9600);
  pinMode(led, OUTPUT);
}

void loop(){
  digitalWrite(led,HIGH);
  int sensorValue = analogRead(A0);
  Serial.println(sensorValue,DEC);
}
