int led = 9;
int brightness = 0;
int fadeAmount = random(254)+1;

void setup()
{
  pinMode(led, OUTPUT);
}
void loop()
{
  if(fadeAmount < 256)
  {
  brightness = fadeAmount;
  }
  analogWrite(led, brightness);
  delay(100);
}
 
  
