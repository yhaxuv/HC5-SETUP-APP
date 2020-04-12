package anywheresoftware.b4a.samples.bluetooth;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class chatactivity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"2\")";
Debug.ShouldStop(16777216);
chatactivity.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("2")),chatactivity.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="If AStream.IsInitialized = False Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",chatactivity._astream.runMethod(true,"IsInitialized"),chatactivity.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 27;BA.debugLine="AStream.InitializePrefix(Main.serial1.InputStrea";
Debug.ShouldStop(67108864);
chatactivity._astream.runVoidMethod ("InitializePrefix",chatactivity.processBA,(Object)(chatactivity.mostCurrent._main._serial1.runMethod(false,"getInputStream")),(Object)(chatactivity.mostCurrent.__c.getField(true,"True")),(Object)(chatactivity.mostCurrent._main._serial1.runMethod(false,"getOutputStream")),(Object)(RemoteObject.createImmutable("AStream")));
 };
 BA.debugLineNum = 29;BA.debugLine="txtLog.Width = 100%x";
Debug.ShouldStop(268435456);
chatactivity.mostCurrent._txtlog.runMethod(true,"setWidth",chatactivity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),chatactivity.mostCurrent.activityBA));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,60);
if (RapidSub.canDelegate("activity_pause")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="If UserClosed Then";
Debug.ShouldStop(268435456);
if (_userclosed.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 62;BA.debugLine="AStream.Close";
Debug.ShouldStop(536870912);
chatactivity._astream.runVoidMethod ("Close");
 };
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,56);
if (RapidSub.canDelegate("activity_resume")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","activity_resume");
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_error() throws Exception{
try {
		Debug.PushSubsStack("AStream_Error (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,46);
if (RapidSub.canDelegate("astream_error")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","astream_error");
 BA.debugLineNum = 46;BA.debugLine="Sub AStream_Error";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="ToastMessageShow(\"Connection is broken.\", True)";
Debug.ShouldStop(16384);
chatactivity.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Connection is broken.")),(Object)(chatactivity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 48;BA.debugLine="btnSend.Enabled = False";
Debug.ShouldStop(32768);
chatactivity.mostCurrent._btnsend.runMethod(true,"setEnabled",chatactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 49;BA.debugLine="txtInput.Enabled = False";
Debug.ShouldStop(65536);
chatactivity.mostCurrent._txtinput.runMethod(true,"setEnabled",chatactivity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_newdata(RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("AStream_NewData (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,32);
if (RapidSub.canDelegate("astream_newdata")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","astream_newdata", _buffer);
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 32;BA.debugLine="Sub AStream_NewData (Buffer() As Byte)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="LogMessage(\"You\", BytesToString(Buffer, 0, Buffer";
Debug.ShouldStop(1);
_logmessage(BA.ObjectToString("You"),chatactivity.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(RemoteObject.createImmutable("UTF8"))));
 BA.debugLineNum = 34;BA.debugLine="If Buffer(0)=51 Then ' \"3\"";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_buffer.getArrayElement(true,BA.numberCast(int.class, 0)),BA.numberCast(double.class, 51))) { 
 BA.debugLineNum = 35;BA.debugLine="Buffer(0)=32";
Debug.ShouldStop(4);
_buffer.setArrayElement (BA.numberCast(byte.class, 32),BA.numberCast(int.class, 0));
 BA.debugLineNum = 36;BA.debugLine="Label2.text= BytesToString(Buffer, 0, Buffer.Len";
Debug.ShouldStop(8);
chatactivity.mostCurrent._label2.runMethod(true,"setText",(chatactivity.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(RemoteObject.createImmutable("UTF8")))));
 }else 
{ BA.debugLineNum = 38;BA.debugLine="else if Buffer(0)=52 Then ' \"4\"";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_buffer.getArrayElement(true,BA.numberCast(int.class, 0)),BA.numberCast(double.class, 52))) { 
 BA.debugLineNum = 39;BA.debugLine="Buffer(0)=32";
Debug.ShouldStop(64);
_buffer.setArrayElement (BA.numberCast(byte.class, 32),BA.numberCast(int.class, 0));
 BA.debugLineNum = 40;BA.debugLine="Label3.text= BytesToString(Buffer, 0, Buffer.Len";
Debug.ShouldStop(128);
chatactivity.mostCurrent._label3.runMethod(true,"setText",(chatactivity.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(RemoteObject.createImmutable("UTF8")))));
 }else {
 BA.debugLineNum = 42;BA.debugLine="txtInput.Text= Buffer(0)";
Debug.ShouldStop(512);
chatactivity.mostCurrent._txtinput.runMethodAndSync(true,"setText",(_buffer.getArrayElement(true,BA.numberCast(int.class, 0))));
 }};
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_terminated() throws Exception{
try {
		Debug.PushSubsStack("AStream_Terminated (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,52);
if (RapidSub.canDelegate("astream_terminated")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","astream_terminated");
 BA.debugLineNum = 52;BA.debugLine="Sub AStream_Terminated";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="AStream_Error";
Debug.ShouldStop(1048576);
_astream_error();
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsend_click() throws Exception{
try {
		Debug.PushSubsStack("btnSend_Click (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,90);
if (RapidSub.canDelegate("btnsend_click")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","btnsend_click");
 BA.debugLineNum = 90;BA.debugLine="Sub btnSend_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
Debug.ShouldStop(67108864);
chatactivity._astream.runVoidMethod ("Write",(Object)(chatactivity.mostCurrent._txtinput.runMethod(true,"getText").runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 BA.debugLineNum = 92;BA.debugLine="txtInput.SelectAll";
Debug.ShouldStop(134217728);
chatactivity.mostCurrent._txtinput.runVoidMethod ("SelectAll");
 BA.debugLineNum = 93;BA.debugLine="txtInput.RequestFocus";
Debug.ShouldStop(268435456);
chatactivity.mostCurrent._txtinput.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 94;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
Debug.ShouldStop(536870912);
_logmessage(BA.ObjectToString("Me"),chatactivity.mostCurrent._txtinput.runMethod(true,"getText"));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Dim txtInput As EditText";
chatactivity.mostCurrent._txtinput = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Dim txtLog As EditText";
chatactivity.mostCurrent._txtlog = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim btnSend As Button";
chatactivity.mostCurrent._btnsend = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Dim Setup As Button";
chatactivity.mostCurrent._setup = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim id As EditText";
chatactivity.mostCurrent._id = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim SW1 As Button";
chatactivity.mostCurrent._sw1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim SW2 As Button";
chatactivity.mostCurrent._sw2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim Label2 As Label";
chatactivity.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim Label3 As Label";
chatactivity.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _logmessage(RemoteObject _from,RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("LogMessage (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,97);
if (RapidSub.canDelegate("logmessage")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","logmessage", _from, _msg);
Debug.locals.put("From", _from);
Debug.locals.put("Msg", _msg);
 BA.debugLineNum = 97;BA.debugLine="Sub LogMessage(From As String, Msg As String)";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="txtLog.Text = txtLog.Text & From & \": \" & Msg & C";
Debug.ShouldStop(2);
chatactivity.mostCurrent._txtlog.runMethodAndSync(true,"setText",(RemoteObject.concat(chatactivity.mostCurrent._txtlog.runMethod(true,"getText"),_from,RemoteObject.createImmutable(": "),_msg,chatactivity.mostCurrent.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 99;BA.debugLine="txtLog.SelectionStart = txtLog.Text.Length";
Debug.ShouldStop(4);
chatactivity.mostCurrent._txtlog.runMethod(true,"setSelectionStart",chatactivity.mostCurrent._txtlog.runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim AStream As AsyncStreams";
chatactivity._astream = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.AsyncStreams");
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setup_click() throws Exception{
try {
		Debug.PushSubsStack("Setup_click (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,82);
if (RapidSub.canDelegate("setup_click")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","setup_click");
 BA.debugLineNum = 82;BA.debugLine="Sub Setup_click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="txtInput.Text=\"0\" & id.text";
Debug.ShouldStop(262144);
chatactivity.mostCurrent._txtinput.runMethodAndSync(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable("0"),chatactivity.mostCurrent._id.runMethod(true,"getText"))));
 BA.debugLineNum = 84;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
Debug.ShouldStop(524288);
chatactivity._astream.runVoidMethod ("Write",(Object)(chatactivity.mostCurrent._txtinput.runMethod(true,"getText").runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 BA.debugLineNum = 85;BA.debugLine="txtInput.SelectAll";
Debug.ShouldStop(1048576);
chatactivity.mostCurrent._txtinput.runVoidMethod ("SelectAll");
 BA.debugLineNum = 86;BA.debugLine="txtInput.RequestFocus";
Debug.ShouldStop(2097152);
chatactivity.mostCurrent._txtinput.runVoidMethod ("RequestFocus");
 BA.debugLineNum = 87;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
Debug.ShouldStop(4194304);
_logmessage(BA.ObjectToString("Me"),chatactivity.mostCurrent._txtinput.runMethod(true,"getText"));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sw1_click() throws Exception{
try {
		Debug.PushSubsStack("SW1_click (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,70);
if (RapidSub.canDelegate("sw1_click")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","sw1_click");
 BA.debugLineNum = 70;BA.debugLine="Sub SW1_click";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="txtInput.Text=\"1000\"";
Debug.ShouldStop(64);
chatactivity.mostCurrent._txtinput.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("1000")));
 BA.debugLineNum = 72;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
Debug.ShouldStop(128);
chatactivity._astream.runVoidMethod ("Write",(Object)(chatactivity.mostCurrent._txtinput.runMethod(true,"getText").runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 BA.debugLineNum = 73;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
Debug.ShouldStop(256);
_logmessage(BA.ObjectToString("Me"),chatactivity.mostCurrent._txtinput.runMethod(true,"getText"));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sw2_click() throws Exception{
try {
		Debug.PushSubsStack("SW2_click (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,76);
if (RapidSub.canDelegate("sw2_click")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","sw2_click");
 BA.debugLineNum = 76;BA.debugLine="Sub SW2_click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="txtInput.Text=\"2000\"";
Debug.ShouldStop(4096);
chatactivity.mostCurrent._txtinput.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("2000")));
 BA.debugLineNum = 78;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
Debug.ShouldStop(8192);
chatactivity._astream.runVoidMethod ("Write",(Object)(chatactivity.mostCurrent._txtinput.runMethod(true,"getText").runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")))));
 BA.debugLineNum = 79;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
Debug.ShouldStop(16384);
_logmessage(BA.ObjectToString("Me"),chatactivity.mostCurrent._txtinput.runMethod(true,"getText"));
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtinput_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("txtInput_EnterPressed (chatactivity) ","chatactivity",1,chatactivity.mostCurrent.activityBA,chatactivity.mostCurrent,66);
if (RapidSub.canDelegate("txtinput_enterpressed")) return chatactivity.remoteMe.runUserSub(false, "chatactivity","txtinput_enterpressed");
 BA.debugLineNum = 66;BA.debugLine="Sub txtInput_EnterPressed";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="If btnSend.Enabled = True Then btnSend_Click";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",chatactivity.mostCurrent._btnsend.runMethod(true,"getEnabled"),chatactivity.mostCurrent.__c.getField(true,"True"))) { 
_btnsend_click();};
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}