package com.mo.bottommenu.activity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jirong.door.yj.interactionjni;
import com.mo.bottommenu.R;
import com.mo.bottommenu.activity.config.CallBackState;
import com.mo.bottommenu.activity.config.SPUtils;
import com.mo.bottommenu.activity.config.controlHardwareCmd;

public class DoorActivity extends Activity implements OnClickListener {

	 GetFingerThread getFingerThread;
	    boolean isTestFinger = false;
	    boolean makeFinger1 = false;
	    boolean makeFinger2 = false;
	    
	    Button mCameraLightOpen;
	    Button mCameraLightClose;
	    Button mKeyLightOpen;
	    Button mKeyLightClose;
	    Button mDoorLockOpen;
	    Button mDoorLockClose;
	    Button mSmartHomeOpen;
	    Button mSmartHomeClose;
	    Button mDooebelOpen;
	    Button mDooebelClose;
	    Button mLcdOpen;
	    Button mLcdClose;
	    Button mRestart;
	    Button mGetFinger;
	    Button mMakeFinger;
	    Button mComposeFinger;
	    Button mMakeFinger2;
	    Button mSaveToFlash;
	    Button mDeleteFingerFlash;
	    Button mCompareFingers;
	    Button mRead;
	    Button mFinish;
	    Button mUploadClient;
	    Button mUpdataFormCilent;
	    Button mCompareFingers2;
	    Button mFingerMouldNum;
	    Button mFingerMouldDeleteChoice;
	    Button mReadSystemInformation;
	    Button mWriteTxt;
	    Button mReadTxt;
	    Button mReadFlashDetails;
	    TextView mTvId;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.door_main);

        //JNI库初始化函数，app开启时调用;调用成功返回0,调用失败返回-1
        interactionjni init = new interactionjni();
        int a = init.a8HardwareControlInit();
        if (a == 0)
            Log.d("mjx_mainactivity", "初始化成功");
        else
            Log.d("mjx_mainactivity", "初始化失败");
        initView();
        initData();
        initListener();

    }
    
    private void initView() {
    	
    	mCameraLightOpen = (Button) findViewById(R.id.camera_light_open);
    	  mCameraLightClose = (Button) findViewById(R.id.camera_light_close);
 	     mKeyLightOpen = (Button) findViewById(R.id.key_light_open);
 	     mKeyLightClose = (Button) findViewById(R.id.key_light_close);
 	     
 	     mDoorLockOpen = (Button) findViewById(R.id.door_lock_open);
 	     mDoorLockClose = (Button) findViewById(R.id.door_lock_close);
 	     mSmartHomeOpen = (Button) findViewById(R.id.smart_home_open);
 	     mSmartHomeClose = (Button) findViewById(R.id.smart_home_close);
 	     
 	     mDooebelOpen = (Button) findViewById(R.id.dooebel_open);
 	     mDooebelClose = (Button) findViewById(R.id.dooebel_close);
 	     mLcdOpen = (Button) findViewById(R.id.lcd_open);
 	     mLcdClose = (Button) findViewById(R.id.lcd_close);
 	     
 	     mRestart = (Button) findViewById(R.id.restart);
 	     mGetFinger = (Button) findViewById(R.id.get_finger);
 	     mMakeFinger = (Button) findViewById(R.id.make_finger);
 	     mComposeFinger = (Button) findViewById(R.id.compose_finger);
 	     
 	     mMakeFinger2 = (Button) findViewById(R.id.make_finger_2);
 	     mSaveToFlash = (Button) findViewById(R.id.save_to_flash);
 	     mDeleteFingerFlash = (Button) findViewById(R.id.delete_finger_flash);
 	     mCompareFingers = (Button) findViewById(R.id.compare_fingers);
 	     
 	     mRead = (Button) findViewById(R.id.read);
 	     mFinish = (Button) findViewById(R.id.finish);
 	     mUploadClient = (Button) findViewById(R.id.upload_client);
 	     mUpdataFormCilent = (Button) findViewById(R.id.updata_form_cilent);
 	     
 	     mCompareFingers2 = (Button) findViewById(R.id.compare_fingers_2);
 	     mFingerMouldNum = (Button) findViewById(R.id.finger_mould_num);
 	     mFingerMouldDeleteChoice = (Button) findViewById(R.id.finger_mould_delete_choice);
 	     mReadSystemInformation = (Button) findViewById(R.id.read_system_information);
 	     
 	     mWriteTxt = (Button) findViewById(R.id.write_txt);
 	     mReadTxt = (Button) findViewById(R.id.read_txt);
 	     mReadFlashDetails = (Button) findViewById(R.id.read_flash_details);
 	    TextView mTvId = (TextView) findViewById(R.id.tv_id);
		
	}

	private void initData() {
        isTestFinger = false;
        makeFinger1 = false;
        makeFinger2 = false;
    }
    
    private void initListener() {
        mCameraLightOpen.setOnClickListener(this);
        mCameraLightClose.setOnClickListener(this);
        mKeyLightOpen.setOnClickListener(this);
        mKeyLightClose.setOnClickListener(this);
        mDoorLockOpen.setOnClickListener(this);
        mDoorLockClose.setOnClickListener(this);
        mSmartHomeOpen.setOnClickListener(this);
        mSmartHomeClose.setOnClickListener(this);
        mDooebelOpen.setOnClickListener(this);
        mDooebelClose.setOnClickListener(this);
        mLcdOpen.setOnClickListener(this);
        mLcdClose.setOnClickListener(this);
        mRestart.setOnClickListener(this);
        mGetFinger.setOnClickListener(this);
        mMakeFinger.setOnClickListener(this);
        mMakeFinger2.setOnClickListener(this);
        mComposeFinger.setOnClickListener(this);
        mSaveToFlash.setOnClickListener(this);
        mDeleteFingerFlash.setOnClickListener(this);
        mCompareFingers.setOnClickListener(this);
        mRead.setOnClickListener(this);
        mFinish.setOnClickListener(this);
        mCompareFingers2.setOnClickListener(this);
        mUploadClient.setOnClickListener(this);
        mUpdataFormCilent.setOnClickListener(this);
        mFingerMouldNum.setOnClickListener(this);
        mFingerMouldDeleteChoice.setOnClickListener(this);
        mReadSystemInformation.setOnClickListener(this);
        mWriteTxt.setOnClickListener(this);
        mReadTxt.setOnClickListener(this);
        mReadFlashDetails.setOnClickListener(this);
    }
    

    private void systemCallBack(byte[] Data) {
        if (Data.length == 0)
            return;

        switch (Data[0]) {
            case CallBackState.UI_INFRARED_DEVICE: //检测人体红外触发,1：人物靠近 0：人物离开

                if (Data[1] == 1)
                    Log.d("mainactivity", "检测人体红外触发 : 靠近");
                else
                    Log.d("mainactivity", "检测人体红外触发 : 离开");

                break;
            case CallBackState.UI_DOORCARD_DEVICE: //门卡
                for (int i = 0; i < Data.length; i++) {
                    Log.d("mainactivity", "门卡" + i + " : " + Data[i]);

                }
                //得到当前所刷的门卡的id
//                final int icCardID = ((Data[1]) & 0xff | ((Data[2] & 0xff) << 8) | ((Data[3] & 0xff) << 16) | ((Data[4] & 0xff) << 24));
                final int icCardID = ((Data[1] & 0xff)<<24) | ((Data[2] & 0xff) << 16) | ((Data[3] & 0xff) << 8) | (Data[4] & 0xff);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String strID = Integer.toHexString(icCardID);
                        if(strID.length() == 7)
                            strID = "0" + strID;
                        mTvId.setText("门卡ID : " + strID);
                    }
                });
                Log.d("mainactivity", "icCardID:" + icCardID);

                break;
            case CallBackState.UI_FACE_RECOGNITION: //检测到人脸识别数据
                for (int i = 0; i < Data.length; i++) {
                    Log.d("mainactivity", "人脸识别 : " + Data[i]);
                }

                break;
            case CallBackState.UI_FINGERPRINT_RECOGNITION:  //检测到指纹识别数据

                fingerBackData(Data);
                break;
            default:
                break;
        }
    }
    

    String STATE = "state";

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /**
             * 有线门铃
             */
            case R.id.dooebel_open:
                byte[] valve_dooebel = new byte[32];
                valve_dooebel[0] = 0x01;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_DOOEBEL, valve_dooebel, 1);
                break;
            case R.id.dooebel_close:
                byte[] valve_dooebel_colse = new byte[32];
                valve_dooebel_colse[0] = 0x00;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_DOOEBEL, valve_dooebel_colse, 1);
                break;
            /**
             * 智能家居IO
             */
            case R.id.smart_home_open:
                byte[] valve_smart_home = new byte[32];
                valve_smart_home[0] = 0x01;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_SMART_HOME, valve_smart_home, 1);
                break;
            case R.id.smart_home_close:
                byte[] valve_smart_home_close = new byte[32];
                valve_smart_home_close[0] = 0x00;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_SMART_HOME, valve_smart_home_close, 1);
                break;
            /**
             * 门锁
             */
            case R.id.door_lock_open:
                /*byte[] valve_door_lock = new byte[32];
                valve_door_lock[0] = 0x01;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_DOOR_LOCK, valve_door_lock, 1);*/
                new interactionjni().openDoor();
                break;
            case R.id.door_lock_close:
                byte[] valve_door_lock_close = new byte[32];
                valve_door_lock_close[0] = 0x00;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_DOOR_LOCK, valve_door_lock_close, 1);
                break;
            /**
             * 摄像头灯
             */
            case R.id.camera_light_open:
                byte[] valve_camera = new byte[32];
                valve_camera[0] = 0x01;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_CAMERA_LIGHT, valve_camera, 1);
                break;
            case R.id.camera_light_close:
                byte[] valve_camera_close = new byte[32];
                valve_camera_close[0] = 0x00;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_CAMERA_LIGHT, valve_camera_close, 1);
                break;
            /**
             * 键盘灯
             */
            case R.id.key_light_open:
                byte[] valve_key_open = new byte[32];
                valve_key_open[0] = 0x01;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_KEY_LIGHT, valve_key_open, 1);
                break;
            case R.id.key_light_close:
                byte[] valve_key_close = new byte[32];
                valve_key_close[0] = 0x00;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_KEY_LIGHT, valve_key_close, 1);
                break;
            /**
             * LCD背光灯
             */
            case R.id.lcd_open:
                byte[] valve_lcd_open = new byte[32];
                valve_lcd_open[0] = 0x01;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_LCD_BACKLIGHT, valve_lcd_open, 1);
                break;
            case R.id.lcd_close:
                byte[] valve_lcd_close = new byte[32];
                valve_lcd_close[0] = 0x00;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_LCD_BACKLIGHT, valve_lcd_close, 1);
                break;
            /**
             * 机器重启
             */
            case R.id.restart:
                byte[] valve_reatart = new byte[32];
                valve_reatart[0] = 0x01;
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_RESTART, valve_reatart, 1);
                break;
            /**
             * 指纹
             */
            case R.id.get_finger:
                Log.d("mainactivity", "点击获取指纹");

                if (isTestFinger)
                    break;
                isTestFinger = true;
                if (getFingerThread == null)
                	getFingerThread = new GetFingerThread();
                getFingerThread.start();

                break;
            case R.id.make_finger:
                if (isTestFinger)
                    break; //处于指纹采集状态 未得到callback值,所以不能生成特征码
                makeFinger1 = true;
                byte[] valve_make_finger = new byte[32];
                valve_make_finger[0] = 0x01; //（包标识）
                valve_make_finger[1] = 0x02; //（CMD）
                valve_make_finger[2] = 0x01; //（缓冲区号）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_make_finger, 3);
                break;
            case R.id.make_finger_2:
                if (isTestFinger)
                    break; //处于指纹采集状态 未得到callback值,所以不能生成特征码
                makeFinger2 = true;
                byte[] valve_make_finger2 = new byte[32];
                valve_make_finger2[0] = 0x01; //（包标识）
                valve_make_finger2[1] = 0x02; //（CMD）
                valve_make_finger2[2] = 0x02; //（缓冲区号）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_make_finger2, 3);
                break;
            case R.id.compose_finger:
                if (makeFinger1 && makeFinger2) {
                    byte[] valve_compose_finger = new byte[32];
                    valve_compose_finger[0] = 0x01; //（包标识）
                    valve_compose_finger[1] = 0x05; // (CMD）
                    new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_compose_finger, 2);
                } else {
                    Toast.makeText(this, "未录入手指或只录入一个手指,无法合成", Toast.LENGTH_LONG).show();
                }

                break;
            //存储合成后的数据
            case R.id.save_to_flash:
                int stateId = SPUtils.getInt(this, STATE, -1) + 1;
                byte[] valve_save_to_flash = new byte[32];
                valve_save_to_flash[0] = 0x01; //（包标识）
                valve_save_to_flash[1] = 0x06; //（CMD）
                valve_save_to_flash[2] = 0x01; // (缓冲区号) 0x01或0x02都可以
                valve_save_to_flash[3] = (byte) ((stateId >> 8) & 0xff);// (位置号[H])
                valve_save_to_flash[4] = (byte) (stateId & 0Xff); // (位置号[L])
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_save_to_flash, 5);
                SPUtils.putInt(this, STATE, stateId);
                Log.d("mainactivity", "存储到指纹数据库");
                break;
            case R.id.read: //从flash中读文件到特征缓存区
                int getStateId = SPUtils.getInt(this, STATE, -1);
                byte[] valve_read = new byte[32];
                valve_read[0] = 0x01; //（包标识）
                valve_read[1] = 0x07; //（CMD）
                valve_read[2] = 0x01; //（缓冲区号）
                valve_read[3] = (byte) ((getStateId >> 8) & 0xff); // (位置号[H])
                valve_read[4] = (byte) (getStateId & 0Xff); // (位置号[L])
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_read, 5);

                break;
            case R.id.upload_client:    //特征缓存区文件上传给主机
                byte[] valve_upload_client = new byte[32];
                valve_upload_client[0] = 0x01; //（包标识）
                valve_upload_client[1] = 0x08; //（CMD）
                valve_upload_client[2] = 0x01; //（缓存区号）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_upload_client, 3);

                break;
            case R.id.updata_form_cilent:
                byte[] valve_updata_form_cilent = new byte[32];
                valve_updata_form_cilent[0] = 0x01; //（包标识）
                valve_updata_form_cilent[1] = 0x09; //（CMD）
                valve_updata_form_cilent[2] = 0x01; //（缓存区号）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_updata_form_cilent, 3);

                break;
            case R.id.compare_fingers_2:    //以缓冲区1或缓冲区2中的特征文件搜索整个或部分指纹库。若搜索到,则返回页码
                byte[] valve_compare_fingers_2 = new byte[32];
                valve_compare_fingers_2[0] = 0x01; //（包标识）
                valve_compare_fingers_2[1] = 0x04; //（CMD）
                valve_compare_fingers_2[2] = 0x01; //（缓存区号）
                valve_compare_fingers_2[3] = 0x00; //(起始页[H])
                valve_compare_fingers_2[4] = 0x01; //(起始页[L])
                valve_compare_fingers_2[5] = 0x00; //(页数[H])
                valve_compare_fingers_2[6] = 0x01; //(页数[L])
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_compare_fingers_2, 7);

                break;
            case R.id.finger_mould_num: //读模块内已存储的指纹模板个数
                byte[] valve_finger_mould_num = new byte[32];
                valve_finger_mould_num[0] = 0x01; //（包标识）
                valve_finger_mould_num[1] = 0x1d; //（CMD）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_finger_mould_num, 2);

                break;
            case R.id.finger_mould_delete_choice:   //删除模块指纹库中指定的一段（指定ID号开始的N个指纹模板）模板
                byte[] valve_finger_mould_delete = new byte[32];
                valve_finger_mould_delete[0] = 0x01; //（包标识）
                valve_finger_mould_delete[1] = 0x0c; //（CMD）
                valve_finger_mould_delete[3] = 0x00;  //(位置号[H])
                valve_finger_mould_delete[4] = 0x01;  //(位置号[L])
                valve_finger_mould_delete[5] = 0x00;  //(删除个数[H])
                valve_finger_mould_delete[6] = 0x01;  //(删除个数[L])
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_finger_mould_delete, 7);
                SPUtils.delete(this, STATE);
                break;
            case R.id.read_system_information:  //读取模块的状态寄存器和系统基本配置参数（系统配置参数)
                byte[] valve_read_system_information = new byte[32];
                valve_read_system_information[0] = 0x01; //（包标识）
                valve_read_system_information[1] = 0x0f; //（CMD）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_read_system_information, 2);

                break;
            case R.id.compare_fingers:
                byte[] valve_compare_fingers = new byte[32];
                valve_compare_fingers[0] = 0x01; //（包标识）
                valve_compare_fingers[1] = 0x03; //（CMD）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_compare_fingers, 2);
                Log.d("mainactivity", "精确对比");
                break;
            case R.id.delete_finger_flash:
                byte[] valve_delete = new byte[32];
                valve_delete[0] = 0x01; //（包标识）
                valve_delete[1] = 0x0D; //（CMD）
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_delete, 2);
                SPUtils.delete(this, STATE);
                Log.d("mainactivity", "清空指纹库");
                break;
            case R.id.write_txt:
                //TODO 不懂什么意思
                byte[] valve_write_txt = new byte[32];
                valve_write_txt[0] = 0x01; //（包标识）
                valve_write_txt[1] = 0x18; //（CMD）
                valve_write_txt[2] = 0x01; // (位置：0~15)
                //                valve_write_txt[3]~valve_write_txt[34]; // (用户信息)
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_write_txt, 4);

                break;
            case R.id.read_txt:
                byte[] valve_read_txt = new byte[32];
                valve_read_txt[0] = 0x01; //（包标识）
                valve_read_txt[1] = 0x19; //（CMD）
                valve_read_txt[2] = 0x02; // (位置：0~15)
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_read_txt, 3);

                break;
            case R.id.read_flash_details:
                byte[] valve_read_flash_details = new byte[32];
                valve_read_flash_details[0] = 0x01;  //（包标识）
                valve_read_flash_details[1] = 0x01f; //（CMD）
                valve_read_flash_details[2] = 0x01;  //(位置：0~3)
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_read_flash_details, 3);

                break;
            case R.id.finish:
                finish();
                break;
            default:
                break;

        }
    }

    private void fingerBackData(byte[] data) {

        switch (data[1]) {
            case 0:
                if (isTestFinger) { // cmd == 1 时的返回
                    isTestFinger = false;
                    getFingerThread.interrupt();
                    getFingerThread = null;
                }
                ToastUtil(this, "成功");
                Log.d("mainactivity", "成功");
                break;
            case 0x01:
                ToastUtil(this, "数据包有错");
                Log.d("mainactivity", "数据包有错");
                break;
            case 0x02:
                ToastUtil(this, "传感器上无手指");
//                Log.d("mainactivity", "传感器上无手指");
                break;
            case 0x03:
                ToastUtil(this, "识别失败");
                Log.d("mainactivity", "识别失败");
                break;
            case 0x04:
                ToastUtil(this, "");
                Log.d("mainactivity", "0X04");
                break;
            case 0x05:
                ToastUtil(this, "");
                Log.d("mainactivity", "0x05");
                break;
            case 0x06:
                ToastUtil(this, "图像太乱，生成失败");
                Log.d("mainactivity", "图像太乱，生成失败");
                break;
            case 0x07:
                ToastUtil(this, "特征点太少，失败");
                Log.d("mainactivity", "特征点太少，失败");
                break;
            case 0x08:
                ToastUtil(this, "匹配不成功");
                Log.d("mainactivity", "匹配不成功");
                break;
            case 0x09:
                ToastUtil(this, "表示没搜到；此时页码与得分为0");
                Log.d("mainactivity", "表示没搜到；此时页码与得分为0");
                break;
            case 0x0A:
                ToastUtil(this, "两个缓冲区的数据差别太大（不是同一手指）");
                Log.d("mainactivity", "两个缓冲区的数据差别太大（不是同一手指）");
                break;
            case 0x0B:
                ToastUtil(this, "位置号超出范围");
                Log.d("mainactivity", "位置号超出范围");
                break;
            case 0x0C:
                ToastUtil(this, "模块失效，读取失败");
                Log.d("mainactivity", "模块失效，读取失败");
                break;
            case 0x0D:
                ToastUtil(this, "表示执行指令失败");
                Log.d("mainactivity", "表示执行指令失败");
                break;
            case 0x0E:
                ToastUtil(this, "表示不能接收数据包");
                Log.d("mainactivity", "表示不能接收数据包");
                break;
            case 0x0F:
                ToastUtil(this, "");
                Log.d("mainactivity", "0x0F");
                break;
            case 0x10:
                ToastUtil(this, "");
                Log.d("mainactivity", "0x10");
                break;
            case 0x11:
                ToastUtil(this, "清空失败");
                Log.d("mainactivity", "清空失败");
                break;
            case 0x12:
                ToastUtil(this, "");
                Log.d("mainactivity", "0x12");
                break;
            case 0x13:
                ToastUtil(this, "");
                Log.d("mainactivity", "0x13");
                break;
            case 0x14:
                ToastUtil(this, "");
                Log.d("mainactivity", "0x14");
                break;
            case 0x15:
                ToastUtil(this, "无有效原始图");
                Log.d("mainactivity", "无有效原始图");
                break;
            case 0x16:
                ToastUtil(this, "");
                Log.d("mainactivity", "0x16");
                break;
            case 0x17:
                ToastUtil(this, "0x17");
                Log.d("mainactivity", "0x17");
                break;
            case 0x18:
                ToastUtil(this, "写Flash出错");
                Log.d("mainactivity", "写Flash出错");
                break;

            default:
                break;
        }
        
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                buffer.append("{" + data[i] + ",");
            } else if (i == data.length - 1) {
                buffer.append(data[i] + "}");
            } else {
                buffer.append(data[i] + ",");
            }
        }
        Log.d("mainactivity", "指纹识别 : " + buffer.toString() + "-----data长度=" + data.length);
    }

    class GetFingerThread extends Thread {
        @Override
        public void run() {
            super.run();

            while (isTestFinger) {
                byte[] valve_finger = new byte[32];
                valve_finger[0] = 0x01; //包标识
                valve_finger[1] = 0x01; //CMD
                new interactionjni().a8SetKeyValue(controlHardwareCmd.E_FINGERPRINT, valve_finger, 2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //                Log.d("mainactivity", "循环");
            }
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //JNI库退出函数，在app退出时候调用; 调用成功返回0,调用失败返回-1
        int exitResult = new interactionjni().a8HardwareControlExit();
        if (exitResult == 0) {
            Log.d("mainactivity", "JNI库退出");
        } else if (exitResult == -1) {
            Log.d("mainactivity", "JNI库退出失败");
        }
    }

    private  void ToastUtil(final Context context, final String str){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
        
}
