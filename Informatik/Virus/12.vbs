 Dim Message, Speak
          Message="FUCK YOU"
          Set Speak=CreateObject("sapi.spvoice")
	  do
	  wscript.sleep 2000
          Speak.Speak Message
	  loop