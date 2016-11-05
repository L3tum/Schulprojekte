int a=2;
int b=3;
int c=4;
int d=5;
int e=6;
int f=7;
int g=8;
int dp2=9;

// koennten wir auch so schreiben: int a=2, b=3, c=4, d=5, e=6, f=7, g=8, dp2=9;

int pins[8] = {a,b,c,d,e,f,g,dp2}; 

void setup()
{
 //for (int zaehler = 0; zaehler < 8; zaehler++)
 //{
   //pinMode(pins[zaehler], OUTPUT);
 //}
 pinMode(a, OUTPUT);
 pinMode(b, OUTPUT);
 pinMode(c, OUTPUT);
 pinMode(d, OUTPUT);
}
 void loop()
{
for (int zaehler = 0; zaehler < 8; zaehler++)
   {
   digitalWrite(pins[zaehler], HIGH); // schalten Segmente schrittweise aus 
   delay(1000); // warten, sonst sieht man ja nix
   }
 
for (int zaehler = 0; zaehler < 8; zaehler++)
  {
   digitalWrite(pins[zaehler], LOW); // schalten Segmente schrittweise ein
   delay(1000); // warten, sonst sieht man ja nix
   } 
}

