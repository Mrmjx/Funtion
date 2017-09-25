package com.jirong.door.yj;


import android.util.Log;

import com.mo.bottommenu.activity.config.CallBackState;
import com.mo.bottommenu.activity.config.controlHardwareCmd;


public class interactionjni {

    static {
        try {
            System.loadLibrary("NativeHardwareSupport");
            Log.d("mainactivity", "loadLibrary成功");
        } catch (Exception e) {
            Log.d("mainactivity", "loadLibrary失败");
            e.printStackTrace();
        }
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
              /*  //得到当前所刷的门卡的id
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
                Log.d("mainactivity", "icCardID:" + icCardID);*/

                break;
            case CallBackState.UI_FACE_RECOGNITION: //检测到人脸识别数据
                for (int i = 0; i < Data.length; i++) {
                    Log.d("mainactivity", "人脸识别 : " + Data[i]);
                }

                break;
            case CallBackState.UI_FINGERPRINT_RECOGNITION:  //检测到指纹识别数据

               // fingerBackData(Data);
                break;
            default:
                break;
        }
    }

    public native int a8HardwareControlInit();

    public native int a8SetKeyValue(int key, byte[] valve, int valueLen);

    public native int a8HardwareControlExit();

    public void openDoor(){
        byte[] valve_door_lock = new byte[32];
        valve_door_lock[0] = 0x01;
        int result = a8SetKeyValue(controlHardwareCmd.E_DOOR_LOCK, valve_door_lock, 1);
        Log.e("mjx","``````unlock  result:"+result);
    }


}
          /*  case R.id.dooebel_open:
                byte[] valve_dooebel = new byte[32];
                valve_dooebel[0] = 0x01;
                a8SetKeyValue(controlHardwareCmd.E_DOOEBEL, valve_dooebel, 1);
                break;
            case R.id.dooebel_close:
                byte[] valve_dooebel_colse = new byte[32];
                valve_dooebel_colse[0] = 0x00;
                a8SetKeyValue(controlHardwareCmd.E_DOOEBEL, valve_dooebel_colse, 1);
                break;
            *//**
 * 门锁
 * <p>
 * 摄像头灯
 * <p>
 * 键盘灯
 * <p>
 * LCD背光灯
 * <p>
 * 机器重启
 *//*
            case R.id.door_lock_open:
                byte[] valve_door_lock = new byte[32];
                valve_door_lock[0] = 0x01;
                a8SetKeyValue(controlHardwareCmd.E_DOOR_LOCK, valve_door_lock, 1);
                break;
            case R.id.door_lock_close:
                byte[] valve_door_lock_close = new byte[32];
                valve_door_lock_close[0] = 0x00;
                a8SetKeyValue(controlHardwareCmd.E_DOOR_LOCK, valve_door_lock_close, 1);
                break;
            *//**
 * 摄像头灯
 *//*
            case R.id.camera_light_open:
                byte[] valve_camera = new byte[32];
                valve_camera[0] = 0x01;
                a8SetKeyValue(controlHardwareCmd.E_CAMERA_LIGHT, valve_camera, 1);
                break;
            case R.id.camera_light_close:
                byte[] valve_camera_close = new byte[32];
                valve_camera_close[0] = 0x00;
                a8SetKeyValue(controlHardwareCmd.E_CAMERA_LIGHT, valve_camera_close, 1);
                break;
            *//**
 * 键盘灯
 *//*
            case R.id.key_light_open:
                byte[] valve_key_open = new byte[32];
                valve_key_open[0] = 0x01;
                a8SetKeyValue(controlHardwareCmd.E_KEY_LIGHT, valve_key_open, 1);
                break;
            case R.id.key_light_close:
                byte[] valve_key_close = new byte[32];
                valve_key_close[0] = 0x00;
                a8SetKeyValue(controlHardwareCmd.E_KEY_LIGHT, valve_key_close, 1);
                break;
            *//**
 * LCD背光灯
 *//*
            case R.id.lcd_open:
                byte[] valve_lcd_open = new byte[32];
                valve_lcd_open[0] = 0x01;
                a8SetKeyValue(controlHardwareCmd.E_LCD_BACKLIGHT, valve_lcd_open, 1);
                break;
            case R.id.lcd_close:
                byte[] valve_lcd_close = new byte[32];
                valve_lcd_close[0] = 0x00;
                a8SetKeyValue(controlHardwareCmd.E_LCD_BACKLIGHT, valve_lcd_close, 1);
                break;
            *//**
 * 机器重启
 *//*
            case R.id.restart:
                byte[] valve_reatart = new byte[32];
                valve_reatart[0] = 0x01;
                a8SetKeyValue(controlHardwareCmd.E_RESTART, valve_reatart, 1);
                break;

            case R.id.finish:
                finish();
                break;
            default:
                break;
*/


        
