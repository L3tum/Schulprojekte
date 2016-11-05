int led = 8;
int led700 = 12;

void setup(){
  pinMode(led, OUTPUT);
  pinMode(led700, OUTPUT);
}
void loop(){
  digitalWrite(led, HIGH);
  delay(700);
  digitalWrite(led700, HIGH);
  delay(300);
  digitalWrite(led, LOW);
  delay(400);
  digitalWrite(led700, LOW);
  delay(600);
  digitalWrite(led, HIGH);
  delay(100);
  digitalWrite(led700, HIGH);
  delay(700);
  digitalWrite(led700, LOW);
  delay(200);
  digitalWrite(led, LOW);
  delay(500);
  digitalWrite(led700, HIGH);
  delay(500);
  digitalWrite(led, HIGH);
  delay(200);
  digitalWrite(led700, LOW);
  delay(700);
  digitalWrite(led700, HIGH);
  delay(100);
  digitalWrite(led, LOW);
  delay(600);
  digitalWrite(led700, LOW);
  delay(400);
}

