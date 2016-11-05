const int lC = 4;
const int lP[] = { 6, 9, 10, 11};
const int dt = 5;
int brightness = 0;
int irgendeineZahl = 1 ;


void setup()
{
}
void loop()
{
  if(brightness > 250)
  {
    irgendeineZahl = -1;
  }
  else if(brightness < 1)
  {
    irgendeineZahl = 1;
  }
  brightness = brightness + irgendeineZahl;
  for(int index = 0; index < lC; index++)
  {
    analogWrite(lP[index], brightness);
  }
  delay(dt);
}
