package anywheresoftware.b4a.samples.bluetooth;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class chatactivity extends Activity implements B4AActivity{
	public static chatactivity mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "anywheresoftware.b4a.samples.bluetooth", "anywheresoftware.b4a.samples.bluetooth.chatactivity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (chatactivity).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "anywheresoftware.b4a.samples.bluetooth", "anywheresoftware.b4a.samples.bluetooth.chatactivity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "anywheresoftware.b4a.samples.bluetooth.chatactivity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (chatactivity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (chatactivity) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return chatactivity.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (chatactivity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (chatactivity) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.randomaccessfile.AsyncStreams _v5 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtinput = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtlog = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsend = null;
public anywheresoftware.b4a.objects.ButtonWrapper _setup = null;
public anywheresoftware.b4a.objects.EditTextWrapper _id = null;
public anywheresoftware.b4a.objects.ButtonWrapper _sw1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _sw2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.samples.bluetooth.main _vv3 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"2\")";
mostCurrent._activity.LoadLayout("2",mostCurrent.activityBA);
 //BA.debugLineNum = 26;BA.debugLine="If AStream.IsInitialized = False Then";
if (_v5.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 27;BA.debugLine="AStream.InitializePrefix(Main.serial1.InputStrea";
_v5.InitializePrefix(processBA,mostCurrent._vv3._v7.getInputStream(),anywheresoftware.b4a.keywords.Common.True,mostCurrent._vv3._v7.getOutputStream(),"AStream");
 };
 //BA.debugLineNum = 29;BA.debugLine="txtLog.Width = 100%x";
mostCurrent._txtlog.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 61;BA.debugLine="If UserClosed Then";
if (_userclosed) { 
 //BA.debugLineNum = 62;BA.debugLine="AStream.Close";
_v5.Close();
 };
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _astream_error() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Sub AStream_Error";
 //BA.debugLineNum = 47;BA.debugLine="ToastMessageShow(\"Connection is broken.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Connection is broken.",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 48;BA.debugLine="btnSend.Enabled = False";
mostCurrent._btnsend.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 49;BA.debugLine="txtInput.Enabled = False";
mostCurrent._txtinput.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _astream_newdata(byte[] _buffer) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub AStream_NewData (Buffer() As Byte)";
 //BA.debugLineNum = 33;BA.debugLine="LogMessage(\"You\", BytesToString(Buffer, 0, Buffer";
_vv4("You",anywheresoftware.b4a.keywords.Common.BytesToString(_buffer,(int) (0),_buffer.length,"UTF8"));
 //BA.debugLineNum = 34;BA.debugLine="If Buffer(0)=51 Then ' \"3\"";
if (_buffer[(int) (0)]==51) { 
 //BA.debugLineNum = 35;BA.debugLine="Buffer(0)=32";
_buffer[(int) (0)] = (byte) (32);
 //BA.debugLineNum = 36;BA.debugLine="Label2.text= BytesToString(Buffer, 0, Buffer.Len";
mostCurrent._label2.setText((Object)(anywheresoftware.b4a.keywords.Common.BytesToString(_buffer,(int) (0),_buffer.length,"UTF8")));
 }else if(_buffer[(int) (0)]==52) { 
 //BA.debugLineNum = 39;BA.debugLine="Buffer(0)=32";
_buffer[(int) (0)] = (byte) (32);
 //BA.debugLineNum = 40;BA.debugLine="Label3.text= BytesToString(Buffer, 0, Buffer.Len";
mostCurrent._label3.setText((Object)(anywheresoftware.b4a.keywords.Common.BytesToString(_buffer,(int) (0),_buffer.length,"UTF8")));
 }else {
 //BA.debugLineNum = 42;BA.debugLine="txtInput.Text= Buffer(0)";
mostCurrent._txtinput.setText((Object)(_buffer[(int) (0)]));
 };
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _astream_terminated() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Sub AStream_Terminated";
 //BA.debugLineNum = 53;BA.debugLine="AStream_Error";
_astream_error();
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _btnsend_click() throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Sub btnSend_Click";
 //BA.debugLineNum = 91;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
_v5.Write(mostCurrent._txtinput.getText().getBytes("UTF8"));
 //BA.debugLineNum = 92;BA.debugLine="txtInput.SelectAll";
mostCurrent._txtinput.SelectAll();
 //BA.debugLineNum = 93;BA.debugLine="txtInput.RequestFocus";
mostCurrent._txtinput.RequestFocus();
 //BA.debugLineNum = 94;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
_vv4("Me",mostCurrent._txtinput.getText());
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Dim txtInput As EditText";
mostCurrent._txtinput = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Dim txtLog As EditText";
mostCurrent._txtlog = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Dim btnSend As Button";
mostCurrent._btnsend = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Dim Setup As Button";
mostCurrent._setup = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim id As EditText";
mostCurrent._id = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim SW1 As Button";
mostCurrent._sw1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Dim SW2 As Button";
mostCurrent._sw2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Dim Label3 As Label";
mostCurrent._label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _vv4(String _from,String _msg) throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Sub LogMessage(From As String, Msg As String)";
 //BA.debugLineNum = 98;BA.debugLine="txtLog.Text = txtLog.Text & From & \": \" & Msg & C";
mostCurrent._txtlog.setText((Object)(mostCurrent._txtlog.getText()+_from+": "+_msg+anywheresoftware.b4a.keywords.Common.CRLF));
 //BA.debugLineNum = 99;BA.debugLine="txtLog.SelectionStart = txtLog.Text.Length";
mostCurrent._txtlog.setSelectionStart(mostCurrent._txtlog.getText().length());
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim AStream As AsyncStreams";
_v5 = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _setup_click() throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Setup_click";
 //BA.debugLineNum = 83;BA.debugLine="txtInput.Text=\"0\" & id.text";
mostCurrent._txtinput.setText((Object)("0"+mostCurrent._id.getText()));
 //BA.debugLineNum = 84;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
_v5.Write(mostCurrent._txtinput.getText().getBytes("UTF8"));
 //BA.debugLineNum = 85;BA.debugLine="txtInput.SelectAll";
mostCurrent._txtinput.SelectAll();
 //BA.debugLineNum = 86;BA.debugLine="txtInput.RequestFocus";
mostCurrent._txtinput.RequestFocus();
 //BA.debugLineNum = 87;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
_vv4("Me",mostCurrent._txtinput.getText());
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _sw1_click() throws Exception{
 //BA.debugLineNum = 70;BA.debugLine="Sub SW1_click";
 //BA.debugLineNum = 71;BA.debugLine="txtInput.Text=\"1000\"";
mostCurrent._txtinput.setText((Object)("1000"));
 //BA.debugLineNum = 72;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
_v5.Write(mostCurrent._txtinput.getText().getBytes("UTF8"));
 //BA.debugLineNum = 73;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
_vv4("Me",mostCurrent._txtinput.getText());
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static String  _sw2_click() throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Sub SW2_click";
 //BA.debugLineNum = 77;BA.debugLine="txtInput.Text=\"2000\"";
mostCurrent._txtinput.setText((Object)("2000"));
 //BA.debugLineNum = 78;BA.debugLine="AStream.Write(txtInput.Text.GetBytes(\"UTF8\"))";
_v5.Write(mostCurrent._txtinput.getText().getBytes("UTF8"));
 //BA.debugLineNum = 79;BA.debugLine="LogMessage(\"Me\", txtInput.Text)";
_vv4("Me",mostCurrent._txtinput.getText());
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _txtinput_enterpressed() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub txtInput_EnterPressed";
 //BA.debugLineNum = 67;BA.debugLine="If btnSend.Enabled = True Then btnSend_Click";
if (mostCurrent._btnsend.getEnabled()==anywheresoftware.b4a.keywords.Common.True) { 
_btnsend_click();};
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
}
