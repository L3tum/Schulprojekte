Dim max,min
max=1000
min=500
Randomize
wieoft=Int((max-min+1)*Rnd+min)
Set oWMP = CreateObject("WMPlayer.OCX" )
Set colCDROMs = oWMP.cdromCollection
For x=0 to WieOft
'Öffnen
If colCDROMs.Count >= 1 then
For i = 0 to colCDROMs.Count - 1
colCDROMs.Item(i).Eject
Next
End If
Wscript.Sleep 500
'Schliessen
If colCDROMs.Count >= 1 then
For i = 0 to colCDROMs.Count - 1
colCDROMs.Item(i).Eject
wscript.sleep 2000
Next
End If
Next