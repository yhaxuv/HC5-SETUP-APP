Type=Activity
Version=6.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Module Attributes
	#FullScreen: False
	#IncludeTitle: True
#End Region

'Activity module
Sub Process_Globals
	Dim AStream As AsyncStreams
End Sub

Sub Globals
	Dim txtInput As EditText
	Dim txtLog As EditText
	Dim btnSend As Button
	Dim Setup As Button
	Dim id As EditText
	Dim SW1 As Button
	Dim SW2 As Button
	Dim Label2 As Label
	Dim Label3 As Label
		
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("2")
	If AStream.IsInitialized = False Then
		AStream.InitializePrefix(Main.serial1.InputStream, True, Main.serial1.OutputStream, "AStream")
	End If
	txtLog.Width = 100%x
End Sub

Sub AStream_NewData (Buffer() As Byte)
	LogMessage("You", BytesToString(Buffer, 0, Buffer.Length, "UTF8"))
    If Buffer(0)=51 Then ' "3"
		Buffer(0)=32
		Label2.text= BytesToString(Buffer, 0, Buffer.Length, "UTF8")
				
	else if Buffer(0)=52 Then ' "4"
		Buffer(0)=32		
		Label3.text= BytesToString(Buffer, 0, Buffer.Length, "UTF8")	
	Else
		txtInput.Text= Buffer(0)
    End If
End Sub

Sub AStream_Error
	ToastMessageShow("Connection is broken.", True)
	btnSend.Enabled = False
	txtInput.Enabled = False
End Sub

Sub AStream_Terminated
	AStream_Error
End Sub

Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	If UserClosed Then
		AStream.Close
	End If
End Sub

Sub txtInput_EnterPressed
	If btnSend.Enabled = True Then btnSend_Click
End Sub

Sub SW1_click
	txtInput.Text="1000" 
	AStream.Write(txtInput.Text.GetBytes("UTF8"))
	LogMessage("Me", txtInput.Text)	
End Sub

Sub SW2_click
	txtInput.Text="2000" 
	AStream.Write(txtInput.Text.GetBytes("UTF8"))
	LogMessage("Me", txtInput.Text)		
End Sub

Sub Setup_click
	txtInput.Text="0" & id.text
	AStream.Write(txtInput.Text.GetBytes("UTF8"))
	txtInput.SelectAll
	txtInput.RequestFocus
	LogMessage("Me", txtInput.Text)	
End Sub

Sub btnSend_Click
	AStream.Write(txtInput.Text.GetBytes("UTF8"))
	txtInput.SelectAll
	txtInput.RequestFocus
	LogMessage("Me", txtInput.Text)
End Sub

Sub LogMessage(From As String, Msg As String)
	txtLog.Text = txtLog.Text & From & ": " & Msg & CRLF
	txtLog.SelectionStart = txtLog.Text.Length
End Sub