int led = 8;
int led2 = 9;

void setup(){
  pinMode(led, OUTPUT);
  pinMode(led2, OUTPUT);
}

void loop(){
  digitalWrite(led, HIGH);
  delay(500);
  digitalWrite(led, LOW);
  digitalWrite(led2, HIGH);
  delay(500);
  digitalWrite(led2, LOW);
}
