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
