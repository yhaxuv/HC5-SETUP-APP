package anywheresoftware.b4a.samples.bluetooth;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(33554432);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 27;BA.debugLine="admin.Initialize(\"admin\")";
Debug.ShouldStop(67108864);
main._admin.runVoidMethod ("Initialize",main.processBA,(Object)(RemoteObject.createImmutable("admin")));
 BA.debugLineNum = 28;BA.debugLine="serial1.Initialize(\"serial1\")";
Debug.ShouldStop(134217728);
main._serial1.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("serial1")));
 };
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"1\")";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="If UserClosed = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_userclosed,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 55;BA.debugLine="serial1.Disconnect";
Debug.ShouldStop(4194304);
main._serial1.runVoidMethod ("Disconnect");
 };
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,33);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="btnSearchForDevices.Enabled = False";
Debug.ShouldStop(2);
main.mostCurrent._btnsearchfordevices.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 35;BA.debugLine="btnAllowConnection.Enabled = False";
Debug.ShouldStop(4);
main.mostCurrent._btnallowconnection.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 36;BA.debugLine="If admin.IsEnabled = False Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main._admin.runMethod(true,"IsEnabled"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 37;BA.debugLine="If admin.Enable = False Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",main._admin.runMethod(true,"Enable"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 38;BA.debugLine="ToastMessageShow(\"Error enabling Bluetooth adap";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Error enabling Bluetooth adapter.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 40;BA.debugLine="ToastMessageShow(\"Enabling Bluetooth adapter...";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Enabling Bluetooth adapter...")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 }else {
 BA.debugLineNum = 44;BA.debugLine="Admin_StateChanged(admin.STATE_ON, 0)";
Debug.ShouldStop(2048);
_admin_statechanged(main._admin.getField(true,"STATE_ON"),BA.numberCast(int.class, 0));
 };
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _admin_devicefound(RemoteObject _name,RemoteObject _macaddress) throws Exception{
try {
		Debug.PushSubsStack("Admin_DeviceFound (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
if (RapidSub.canDelegate("admin_devicefound")) return main.remoteMe.runUserSub(false, "main","admin_devicefound", _name, _macaddress);
RemoteObject _nm = RemoteObject.declareNull("anywheresoftware.b4a.samples.bluetooth.main._nameandmac");
Debug.locals.put("Name", _name);
Debug.locals.put("MacAddress", _macaddress);
 BA.debugLineNum = 90;BA.debugLine="Sub Admin_DeviceFound (Name As String, MacAddress";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="Log(Name & \":\" & MacAddress)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(_name,RemoteObject.createImmutable(":"),_macaddress)));
 BA.debugLineNum = 92;BA.debugLine="Dim nm As NameAndMac";
Debug.ShouldStop(134217728);
_nm = RemoteObject.createNew ("anywheresoftware.b4a.samples.bluetooth.main._nameandmac");Debug.locals.put("nm", _nm);
 BA.debugLineNum = 93;BA.debugLine="nm.Name = Name";
Debug.ShouldStop(268435456);
_nm.setField ("Name",_name);
 BA.debugLineNum = 94;BA.debugLine="nm.Mac = MacAddress";
Debug.ShouldStop(536870912);
_nm.setField ("Mac",_macaddress);
 BA.debugLineNum = 95;BA.debugLine="foundDevices.Add(nm)";
Debug.ShouldStop(1073741824);
main._founddevices.runVoidMethod ("Add",(Object)((_nm)));
 BA.debugLineNum = 96;BA.debugLine="ProgressDialogShow(\"Searching for devices (~ devi";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Searching for devices (~ device found)...").runMethod(true,"replace",(Object)(BA.ObjectToString("~")),(Object)(BA.NumberToString(main._founddevices.runMethod(true,"getSize"))))));
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _admin_discoveryfinished() throws Exception{
try {
		Debug.PushSubsStack("Admin_DiscoveryFinished (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,68);
if (RapidSub.canDelegate("admin_discoveryfinished")) return main.remoteMe.runUserSub(false, "main","admin_discoveryfinished");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _nm = RemoteObject.declareNull("anywheresoftware.b4a.samples.bluetooth.main._nameandmac");
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 68;BA.debugLine="Sub Admin_DiscoveryFinished";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 70;BA.debugLine="If foundDevices.Size = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main._founddevices.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 71;BA.debugLine="ToastMessageShow(\"No device found.\", True)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("No device found.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 73;BA.debugLine="Dim l As List";
Debug.ShouldStop(256);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 74;BA.debugLine="l.Initialize";
Debug.ShouldStop(512);
_l.runVoidMethod ("Initialize");
 BA.debugLineNum = 75;BA.debugLine="For i = 0 To foundDevices.Size - 1";
Debug.ShouldStop(1024);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {main._founddevices.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7); _i = ((int)(0 + _i + step7)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 76;BA.debugLine="Dim nm As NameAndMac";
Debug.ShouldStop(2048);
_nm = RemoteObject.createNew ("anywheresoftware.b4a.samples.bluetooth.main._nameandmac");Debug.locals.put("nm", _nm);
 BA.debugLineNum = 77;BA.debugLine="nm = foundDevices.Get(i)";
Debug.ShouldStop(4096);
_nm = (main._founddevices.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("nm", _nm);
 BA.debugLineNum = 78;BA.debugLine="l.Add(nm.Name)";
Debug.ShouldStop(8192);
_l.runVoidMethod ("Add",(Object)((_nm.getField(true,"Name"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 80;BA.debugLine="Dim res As Int";
Debug.ShouldStop(32768);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 81;BA.debugLine="res = InputList(l, \"Choose device to connect\", -";
Debug.ShouldStop(65536);
_res = main.mostCurrent.__c.runMethodAndSync(true,"InputList",(Object)(_l),(Object)(BA.ObjectToString("Choose device to connect")),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),main.mostCurrent.activityBA);Debug.locals.put("res", _res);
 BA.debugLineNum = 82;BA.debugLine="If res <> DialogResponse.CANCEL Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("!",_res,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"CANCEL")))) { 
 BA.debugLineNum = 83;BA.debugLine="connectedDevice = foundDevices.Get(res)";
Debug.ShouldStop(262144);
main._connecteddevice = (main._founddevices.runMethod(false,"Get",(Object)(_res)));
 BA.debugLineNum = 84;BA.debugLine="ProgressDialogShow(\"Trying to connect to: \" & c";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("Trying to connect to: "),main._connecteddevice.getField(true,"Name"),RemoteObject.createImmutable(" ("),main._connecteddevice.getField(true,"Mac"),RemoteObject.createImmutable(")"))));
 BA.debugLineNum = 85;BA.debugLine="serial1.Connect(connectedDevice.Mac)";
Debug.ShouldStop(1048576);
main._serial1.runVoidMethod ("Connect",main.processBA,(Object)(main._connecteddevice.getField(true,"Mac")));
 };
 };
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
public static RemoteObject  _admin_statechanged(RemoteObject _newstate,RemoteObject _oldstate) throws Exception{
try {
		Debug.PushSubsStack("Admin_StateChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,48);
if (RapidSub.canDelegate("admin_statechanged")) return main.remoteMe.runUserSub(false, "main","admin_statechanged", _newstate, _oldstate);
Debug.locals.put("NewState", _newstate);
Debug.locals.put("OldState", _oldstate);
 BA.debugLineNum = 48;BA.debugLine="Sub Admin_StateChanged (NewState As Int, OldState";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="btnSearchForDevices.Enabled = (NewState = admin.S";
Debug.ShouldStop(65536);
main.mostCurrent._btnsearchfordevices.runMethod(true,"setEnabled",BA.ObjectToBoolean((RemoteObject.solveBoolean("=",_newstate,BA.numberCast(double.class, main._admin.getField(true,"STATE_ON"))))));
 BA.debugLineNum = 50;BA.debugLine="btnAllowConnection.Enabled = btnSearchForDevices.";
Debug.ShouldStop(131072);
main.mostCurrent._btnallowconnection.runMethod(true,"setEnabled",main.mostCurrent._btnsearchfordevices.runMethod(true,"getEnabled"));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnallowconnection_click() throws Exception{
try {
		Debug.PushSubsStack("btnAllowConnection_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("btnallowconnection_click")) return main.remoteMe.runUserSub(false, "main","btnallowconnection_click");
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 99;BA.debugLine="Sub btnAllowConnection_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 101;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(16);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 102;BA.debugLine="i.Initialize(\"android.bluetooth.adapter.action.RE";
Debug.ShouldStop(32);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 103;BA.debugLine="i.PutExtra(\"android.bluetooth.adapter.extra.DISCO";
Debug.ShouldStop(64);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION")),(Object)(RemoteObject.createImmutable((300))));
 BA.debugLineNum = 104;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((_i.getObject())));
 BA.debugLineNum = 106;BA.debugLine="serial1.Listen";
Debug.ShouldStop(512);
main._serial1.runVoidMethod ("Listen",main.processBA);
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsearchfordevices_click() throws Exception{
try {
		Debug.PushSubsStack("btnSearchForDevices_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,59);
if (RapidSub.canDelegate("btnsearchfordevices_click")) return main.remoteMe.runUserSub(false, "main","btnsearchfordevices_click");
 BA.debugLineNum = 59;BA.debugLine="Sub btnSearchForDevices_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="foundDevices.Initialize";
Debug.ShouldStop(134217728);
main._founddevices.runVoidMethod ("Initialize");
 BA.debugLineNum = 61;BA.debugLine="If admin.StartDiscovery	= False Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main._admin.runMethod(true,"StartDiscovery"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 62;BA.debugLine="ToastMessageShow(\"Error starting discovery proce";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Error starting discovery process.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 64;BA.debugLine="ProgressDialogShow(\"Searching for devices...\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Searching for devices...")));
 };
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 21;BA.debugLine="Dim btnSearchForDevices As Button";
main.mostCurrent._btnsearchfordevices = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim btnAllowConnection As Button";
main.mostCurrent._btnallowconnection = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
chatactivity_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("anywheresoftware.b4a.samples.bluetooth.main");
chatactivity.myClass = BA.getDeviceClass ("anywheresoftware.b4a.samples.bluetooth.chatactivity");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim admin As BluetoothAdmin";
main._admin = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial.BluetoothAdmin");
 //BA.debugLineNum = 14;BA.debugLine="Dim serial1 As Serial";
main._serial1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial");
 //BA.debugLineNum = 15;BA.debugLine="Dim foundDevices As List";
main._founddevices = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 16;BA.debugLine="Type NameAndMac (Name As String, Mac As String)";
;
 //BA.debugLineNum = 17;BA.debugLine="Dim connectedDevice As NameAndMac";
main._connecteddevice = RemoteObject.createNew ("anywheresoftware.b4a.samples.bluetooth.main._nameandmac");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _serial1_connected(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Serial1_Connected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,109);
if (RapidSub.canDelegate("serial1_connected")) return main.remoteMe.runUserSub(false, "main","serial1_connected", _success);
Debug.locals.put("Success", _success);
 BA.debugLineNum = 109;BA.debugLine="Sub Serial1_Connected (Success As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 111;BA.debugLine="Log(\"connected: \" & Success)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("connected: "),_success)));
 BA.debugLineNum = 112;BA.debugLine="If Success = False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_success,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 113;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage")));
 BA.debugLineNum = 114;BA.debugLine="ToastMessageShow(\"Error connecting: \" & LastExce";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error connecting: "),main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 116;BA.debugLine="StartActivity(ChatActivity)";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._chatactivity.getObject())));
 };
 BA.debugLineNum = 118;BA.debugLine="End Sub";
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
}