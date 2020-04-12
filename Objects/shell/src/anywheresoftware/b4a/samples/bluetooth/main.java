
package anywheresoftware.b4a.samples.bluetooth;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "anywheresoftware.b4a.samples.bluetooth.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _admin = RemoteObject.declareNull("anywheresoftware.b4a.objects.Serial.BluetoothAdmin");
public static RemoteObject _serial1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Serial");
public static RemoteObject _founddevices = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _connecteddevice = RemoteObject.declareNull("anywheresoftware.b4a.samples.bluetooth.main._nameandmac");
public static RemoteObject _btnsearchfordevices = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnallowconnection = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static anywheresoftware.b4a.samples.bluetooth.chatactivity _chatactivity = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"admin",main._admin,"btnAllowConnection",main.mostCurrent._btnallowconnection,"btnSearchForDevices",main.mostCurrent._btnsearchfordevices,"ChatActivity",Debug.moduleToString(anywheresoftware.b4a.samples.bluetooth.chatactivity.class),"connectedDevice",main._connecteddevice,"foundDevices",main._founddevices,"serial1",main._serial1};
}
}