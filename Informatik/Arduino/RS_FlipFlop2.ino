

const int ledr = 2;
const int ledg = 4;
const int gr = 11;
const int knopf = 8;
const int kn = 12;
const int inddex = 0;
//int knopf3 = 13;
int buttonState = 0;
int buttonStat = 0;
int dT = 0;
//int value3 = 500;
//int val = 10;
//int val2 = 01;
//int val3 = 00;

void setup()
{
  Serial.begin(9600);
  pinMode(ledr, OUTPUT);
  pinMode(ledg, OUTPUT);
 // pinMode(gr, OUTPUT);
  pinMode(knopf, INPUT);
  pinMode(kn, INPUT);
 // pinMode(knopf3, INPUT);
}
void loop()
{
  
  digitalWrite(13, HIGH);
  buttonState = digitalRead(knopf);
  buttonStat = digitalRead(kn);
  
  //value3 = digitalRead(knopf3);
  
  if (buttonState == HIGH)
  {
    digitalWrite(ledr, HIGH);
    delay(1);
    digitalWrite(ledg, LOW);
    delay(1);
    //digitalWrite(gr, LOW);
    //delay(1);
    Serial.println(buttonState);
  }
  else if (buttonStat == HIGH)
  {
    digitalWrite(ledr, LOW);
    delay(1);
    //digitalWrite(gr, LOW);
    //delay(1);
    digitalWrite(ledg, HIGH);
    delay(1);
    Serial.println(buttonStat);
  }
  //else if(value3 == HIGH)
  //{
   // digitalWrite(rot, LOW);
   // digitalWrite(gelb, LOW);
   // digitalWrite(gr, HIGH);
   // Serial.write(val3);
  //}
}
