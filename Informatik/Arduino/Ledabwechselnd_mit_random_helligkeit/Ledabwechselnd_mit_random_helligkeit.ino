int gruen = 11;
int gelb = 10;
int rot = 9;
int grue = 6;
int gel = 5;
int ro = 3;
int value = 0;
int va = 0;
int val = 0;
int valu = 0;
void setup()
{
}
void loop()
{
  for(int i;i < 999999999;i++)
  {
  delay(1);
  valu = random(250);
  }

    
    
  
  
  if(valu < 50)
  {
    analogWrite(rot,valu);
    delay(100);
    analogWrite(rot,0);
    analogWrite(gelb, valu);
    delay(100);
    analogWrite(gelb,0);
    analogWrite(gruen,valu);
    delay(100);
    analogWrite(gruen,0);
    analogWrite(ro,valu);
    delay(100);
    analogWrite(ro,0);
    analogWrite(gel,valu);
    delay(100);
    analogWrite(gel,0);
    analogWrite(grue,valu);
    delay(100);
    analogWrite(grue,0);
    delay(1);
  }
  
}

