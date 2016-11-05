int led1 = 10;
int brightness1 = 0;
int fadeAmount = 5;

int led2 = 9;
int brightness2 = 0;


void setup()
{
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
}
void loop()
{
  analogWrite(led1, brightness1);
  analogWrite(led2, brightness2);
  if(brightness1 == 0)
  {
  brightness1 = brightness1 + fadeAmount;
  }
  delay(30);
  if(brightness1 == 255)
  {
  brightness1 = brightness1 - fadeAmount;
  brightness2 = brightness2 + fadeAmount;
  }
  if(brightness2 == 255)
  {
  brightness2 = brightness2 - fadeAmount;
  }
}
