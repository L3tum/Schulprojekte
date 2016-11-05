int ledg = 9;
int ledr = 10;
int ledy = 11;

void setup()
{
  pinMode(ledg, OUTPUT);
  pinMode(ledr, OUTPUT);
  pinMode(ledy, OUTPUT);
}
void loop()
{
  int value = random(9,11);
  int randValue = random(254)+1;
  analogWrite(value, randValue);
  Serial.print(value,randValue);
  delay(30);
}
  
  
     
