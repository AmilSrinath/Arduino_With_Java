void setup()
{
  Serial.begin(9600);
  pinMode(13, OUTPUT); pinMode(12, OUTPUT);
  pinMode(11, OUTPUT); pinMode(10, OUTPUT);
}
//--------------------------
void loop()
{
  byte inByte;
  while(Serial.available())
  {
    inByte = Serial.read();

    if(inByte == 0) {
      digitalWrite(13, !digitalRead(13));
      digitalWrite(12, !digitalRead(12));
      digitalWrite(11, !digitalRead(11));
    }
    
    if(inByte == 1) digitalWrite(13, !digitalRead(13));
    if(inByte == 2) digitalWrite(12, !digitalRead(12));
    if(inByte == 3) digitalWrite(11, !digitalRead(11));

    if(inByte == 4) digitalWrite(10, 0);
    if(inByte >= 5) analogWrite(10, inByte);
  }
}