const int pingPin = 12;
int b = 3;
int c = 4;
int d = 5;
int e = 6;
int f = 7;
int g = 8;
int h = 9;
//int h = 10;
//int i = 11;
//int j = 12;
int a = 2;
void setup()
{
  Serial.begin(9600);
}

void loop()
{
  digitalWrite(h, LOW);
  long duration, inches, cm;
  pinMode(pingPin, OUTPUT);
  digitalWrite(pingPin, LOW);
  delayMicroseconds(2);
  digitalWrite(pingPin, HIGH);
  delayMicroseconds(5);
  digitalWrite(pingPin, LOW);
  pinMode(pingPin, INPUT);
  duration = pulseIn(pingPin, HIGH);
  inches = microsecondsToInches(duration);
  cm = microsecondsToCentimeters(duration);
  //Serial.print(inches);
  //Serial.print("in  ");
  Serial.print("----");
  Serial.print(cm);
  Serial.print("cm");
  Serial.println("----");
  Serial.println();
  if((cm == 2) || (cm == 12) || (cm == 22) || (cm == 32) || (cm == 42) || (cm == 52) || (cm == 62) || (cm == 72) || (cm == 82) || (cm == 92) || (cm == 102) || (cm == 112) || (cm == 122) || (cm == 132) || (cm == 142) || (cm == 152) || (cm == 162) || (cm == 172) || (cm == 182) || (cm == 192) || (cm == 202) || (cm == 212) || (cm == 222) || (cm == 232) || (cm == 242) || (cm == 252) || (cm == 262) || (cm == 272) || (cm == 282) || (cm == 292) || (cm == 302))
  {
    digitalWrite(a, HIGH);
    digitalWrite(b, HIGH);
    digitalWrite(c, LOW);
    digitalWrite(d, HIGH);
    digitalWrite(e, HIGH);
    digitalWrite(f, LOW);
    digitalWrite(g, HIGH);
  }
  if((cm == 3) || (cm == 13) || (cm == 23) || (cm == 33) || (cm == 43) || (cm == 53) || (cm == 63) || (cm == 73) || (cm == 83) || (cm == 93) || (cm == 103) || (cm == 113) || (cm == 123) || (cm == 133) || (cm == 143) || (cm == 153) || (cm == 163) || (cm == 173) || (cm == 183) || (cm == 193) || (cm == 203) || (cm == 213) || (cm == 223) || (cm == 233) || (cm == 243) || (cm == 253) || (cm == 263) || (cm == 273) || (cm == 283) || (cm == 293) || (cm == 303))
  {
    digitalWrite(a, HIGH);
    digitalWrite(b,HIGH);
    digitalWrite(c, HIGH);
    digitalWrite(d, HIGH);
    digitalWrite(e, LOW);
    digitalWrite(f, LOW);
    digitalWrite(g, HIGH);
  }
  if((cm == 4) || (cm == 14) || (cm == 24) || (cm == 34) || (cm == 44) || (cm == 54) || (cm == 64) || (cm == 74) || (cm == 84) || (cm == 94) || (cm == 104) || (cm == 114) || (cm == 124) || (cm == 134) || (cm == 144) || (cm == 154) || (cm == 164) || (cm == 174) || (cm == 184) || (cm == 194) || (cm == 204) || (cm == 214) || (cm == 224) || (cm == 234) || (cm == 244) || (cm == 254) || (cm == 264) || (cm == 274) || (cm == 284) || (cm == 294) || (cm == 304))
  {
    digitalWrite(a, LOW);
    digitalWrite(b, HIGH);
    digitalWrite(c, HIGH);
    digitalWrite(d, LOW);
    digitalWrite(e, LOW);
    digitalWrite(f, HIGH);
    digitalWrite(g, HIGH);
  }
  if((cm == 5) || (cm == 15) || (cm == 25) || (cm == 35) || (cm == 45) || (cm == 55) || (cm == 65) || (cm == 75) || (cm == 85) || (cm == 95) || (cm == 105) || (cm == 115) || (cm == 125) || (cm == 135) || (cm == 145) || (cm == 155) || (cm == 165) || (cm == 175) || (cm == 185) || (cm == 195) || (cm == 205) || (cm == 215) || (cm == 225) || (cm == 235) || (cm == 245) || (cm == 255) || (cm == 265) || (cm == 275) || (cm == 285) || (cm == 295) || (cm == 305))
  {
    digitalWrite(a, HIGH);
    digitalWrite(b, LOW);
    digitalWrite(c, HIGH);
    digitalWrite(d, HIGH);
    digitalWrite(e, LOW);
    digitalWrite(f, HIGH);
    digitalWrite(g, HIGH);
  }
  if(( cm == 6) || (cm == 16) || (cm == 26) || (cm == 36) || (cm == 46) || (cm == 56) || (cm == 66) || (cm == 76) || ( cm == 86) || (cm == 96) || (cm == 106) || (cm == 116) || (cm == 126) || (cm == 136) || (cm == 146) || (cm == 156) || (cm == 166) || (cm == 176) || (cm == 186) || (cm == 196) || (cm == 206) || (cm == 216) || (cm == 226) || (cm == 236) || (cm == 246) || (cm == 256) || (cm == 266) || (cm == 276) || (cm == 286) || (cm == 296) || (cm == 306))
  {
    digitalWrite(a, HIGH);
    digitalWrite(b, LOW);
    digitalWrite(c, HIGH);
    digitalWrite(d, HIGH);
    digitalWrite(e, HIGH);
    digitalWrite(f, HIGH);
    digitalWrite(g, HIGH);
  }
  if((cm == 7) || (cm == 17) || (cm == 27) || (cm == 37) || (cm == 47) || (cm == 57) || (cm == 67) || (cm == 77) || (cm == 87) || (cm == 97) || (cm == 107) || (cm == 117) || (cm == 127) || (cm == 137) || (cm == 147) || (cm == 157) || (cm == 167) || (cm == 177) || (cm == 187) || (cm == 197) || (cm == 207) || (cm == 217) || (cm == 227) || (cm == 237) || (cm == 247) || (cm == 257) || (cm == 267) || (cm == 277) || (cm == 287) || (cm == 297) || (cm == 307))
  {
    digitalWrite(a, HIGH);
    digitalWrite(b, HIGH);
    digitalWrite(c, HIGH);
    digitalWrite(d, LOW);
    digitalWrite(e, LOW);
    digitalWrite(f, LOW);
    digitalWrite(g, LOW);
  }
  if((cm == 8) || (cm == 18) || (cm == 28) || (cm == 38) || (cm == 48) || (cm == 58) || (cm == 68) || (cm == 78) || (cm == 88) || (cm == 98) || (cm == 108) || (cm == 118) || (cm == 128) || (cm == 138) || (cm == 148) || (cm == 158) || (cm == 168) || (cm == 178) || (cm == 188) || (cm == 198) || (cm == 208) || (cm == 218) || (cm == 228) || (cm == 238) || (cm == 248) || (cm == 258) || (cm == 268) || (cm == 278) || (cm == 288) || (cm == 298) || (cm == 308))
  {
    digitalWrite(a, HIGH);
    digitalWrite(b, HIGH);
    digitalWrite(c, HIGH);
    digitalWrite(d, HIGH);
    digitalWrite(e, HIGH);
    digitalWrite(f, HIGH);
    digitalWrite(g, HIGH);
  }
  if((cm == 9) || (cm == 19) || (cm == 29) || (cm == 39) || (cm == 49) || (cm == 59) || (cm == 69) || (cm == 79) || (cm == 89) || (cm == 99) || (cm == 109) || (cm == 119) || (cm == 129) || (cm == 139) || (cm == 149) || (cm == 159) || (cm == 169) || (cm == 179) || (cm == 189) || (cm == 199) || (cm == 209) || (cm == 219) || (cm == 229) || (cm == 239) || (cm == 249) || (cm == 259) || (cm == 269) || (cm == 279) || (cm == 289) || (cm == 299) || (cm == 309))
  {
    digitalWrite(a, HIGH);
    digitalWrite(b, HIGH);
    digitalWrite(c, HIGH);
    digitalWrite(d, LOW);
    digitalWrite(e, LOW);
    digitalWrite(f, HIGH);
    digitalWrite(g, HIGH);
  }
  delay(100);
  for(int z = 1;z < 0;z++)
  {
    digitalWrite(a, LOW);
    digitalWrite(b && c && d && e && f && g, LOW);
  }
}
long microsecondsToInches(long microseconds)
{
  return microseconds / 74 / 2;
}
long microsecondsToCentimeters(long microseconds)
{
  return microseconds / 29 / 2;
}
   
