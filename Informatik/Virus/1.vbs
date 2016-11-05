 Dim Message, Speak
      Message="This is an April Fools joke"
	  Message2="How do you like it?"
	  Message3="It will run foreva :)"
	  Message4="Hahahahaha"
          Set Speak=CreateObject("sapi.spvoice")
	  do
	  wscript.sleep 2000
          Speak.Speak Message
	  wscript.sleep 2000
	  Speak.speak Message2
	  wscript.sleep 2000
	  Speak.Speak Message3
	  wscript.sleep 2000
	  Speak.SPeak Message4
	  loop