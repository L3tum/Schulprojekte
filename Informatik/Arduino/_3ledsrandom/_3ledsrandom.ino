int zufall = 0;
void setup()
{
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  Serial.begin(9600);
}
void loop()
{
  for(int index = 255; index > zufall;)
  {
    int led = random(3)+9;
    Serial.println(led);
    digitalWrite(led, HIGH);
    delay(10);
    digitalWrite(led, LOW);
    delay(10);
  }
}
