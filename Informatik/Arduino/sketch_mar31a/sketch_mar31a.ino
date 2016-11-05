#include <LedControl.h>

#include "LedControl.h"
/*
Now we need a LedControl to work with.
pin 12 is connected to the DataIn
pin 11 is connected to the CLK
pin 10 is connected to LOAD
We have only a single MAX7219
*/
LedControl lc=LedControl(12,11,10,1);
/* we always wait a bit between updates of the display */
unsigned long delaytime=250;
void setup() {
/*
The MAX72XX is in power-saving mode on startup,
we have to do a wakeup call
*/
lc.shutdown(0,false);
/* Set the brightness to a medium values */
lc.setIntensity(0,8);
/* and clear the display */
lc.clearDisplay(0);
}

void writeWWWWWWWWOnMatrix() {
/* here is the data for the characters */
byte w[8]={
B11111110,B00000100,B00001000,B00000100,B11111110,B00000000,B00000000,B00000000 };
byte a[8]={
B00000000,B11111110,B00000100,B00001000,B00000100,B11111110,B00000000,B00000000 };
byte q[8]={
B00000000,B00000000,B11111110,B00000100,B00001000,B00000100,B11111110,B00000000 };
byte c[8]={
B00000000,B00000000,B00000000,B11111110,B00000100,B00001000,B00000100,B11111110 };
byte s[8]={
B00000000,B00000000,B00000000,B00000000,B11111110,B00000100,B00001000,B00000100 };
byte y[8]={
B00000000,B00000000,B00000000,B00000000,B00000000,B11111110,B00000100,B00001000 };
byte z[8]={
B00000000,B00000000,B00000000,B00000000,B00000000,B00000000,B11111110,B00000100 };
byte f[8]={
B00000000,B00000000,B00000000,B00000000,B00000000,B00000000,B00000000,B11111110 };  
/* now display them one by one with a small delay */
lc.setRow(0,0,w[0]);
lc.setRow(0,1,w[1]);
lc.setRow(0,2,w[2]);
lc.setRow(0,3,w[3]);
lc.setRow(0,4,w[4]);
lc.setRow(0,5,w[6]);
lc.setRow(0,6,w[7]);
lc.setRow(0,7,w[8]);
delay(delaytime);
lc.setRow(0,0,a[0]);
lc.setRow(0,1,a[1]);
lc.setRow(0,2,a[2]);
lc.setRow(0,3,a[3]);
lc.setRow(0,4,a[4]);
lc.setRow(0,5,a[5]);
lc.setRow(0,6,a[6]);
lc.setRow(0,7,a[7]);
delay(delaytime);
lc.setRow(0,0,q[0]);
lc.setRow(0,1,q[1]);
lc.setRow(0,2,q[2]);
lc.setRow(0,3,q[3]);
lc.setRow(0,4,q[4]);
lc.setRow(0,5,q[5]);
lc.setRow(0,6,q[6]);
lc.setRow(0,7,q[7]);
delay(delaytime);
lc.setRow(0,0,c[0]);
lc.setRow(0,1,c[1]);
lc.setRow(0,2,c[2]);
lc.setRow(0,3,c[3]);
lc.setRow(0,4,c[4]);
lc.setRow(0,5,c[5]);
lc.setRow(0,6,c[6]);
lc.setRow(0,7,c[7]);
delay(delaytime);
lc.setRow(0,0,s[0]);
lc.setRow(0,1,s[1]);
lc.setRow(0,2,s[2]);
lc.setRow(0,3,s[3]);
lc.setRow(0,4,s[4]);
lc.setRow(0,5,s[5]);
lc.setRow(0,6,s[6]);
lc.setRow(0,7,s[7]);
delay(delaytime);
lc.setRow(0,0,y[0]);
lc.setRow(0,1,y[1]);
lc.setRow(0,2,y[2]);
lc.setRow(0,3,y[3]);
lc.setRow(0,4,y[4]);
lc.setRow(0,5,y[5]);
lc.setRow(0,6,y[6]);
lc.setRow(0,7,y[7]);
delay(delaytime);
lc.setRow(0,0,z[0]);
lc.setRow(0,1,z[1]);
lc.setRow(0,2,z[2]);
lc.setRow(0,3,z[3]);
lc.setRow(0,4,z[4]);
lc.setRow(0,5,z[5]);
lc.setRow(0,6,z[6]);
lc.setRow(0,7,z[7]);
delay(delaytime);
lc.setRow(0,0,f[0]);
lc.setRow(0,1,f[1]);
lc.setRow(0,2,f[2]);
lc.setRow(0,3,f[3]);
lc.setRow(0,4,f[4]);
lc.setRow(0,5,f[5]);
lc.setRow(0,6,f[6]);
lc.setRow(0,7,f[7]);
delay(delaytime);
lc.setRow(0,0,0);
lc.setRow(0,1,0);
lc.setRow(0,2,0);
lc.setRow(0,3,0);
lc.setRow(0,4,0);
lc.setRow(0,5,0);
lc.setRow(0,6,0);
lc.setRow(0,7,0);
delay(delaytime);
}


void loop() {
lc.setIntensity(0,8);
writeWWWWWWWWOnMatrix();
delay(200);
writeWWWWWWWWOnMatrix();
delay(200);
writeWWWWWWWWOnMatrix();
delay(200);
}

