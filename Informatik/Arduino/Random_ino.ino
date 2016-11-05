int randNumber;
int led = 9;
void setup()
{
  pinMode(led, OUTPUT);
}
void loop()
{
  randomSeed(millis());
  randNumber = random(254)+1;
  analogWrite(led, randNumber);
  delay(100);
  Serial.print(randNumber);
}
