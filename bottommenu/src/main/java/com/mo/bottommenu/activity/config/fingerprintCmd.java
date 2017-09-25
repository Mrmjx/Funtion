package com.mo.bottommenu.activity.config;

/**
 * Created by lijiarui on 2017/3/31.
 */
public class fingerprintCmd {

    public static final byte CHECK_FINGER__CMD = 0x01; // 检测手指，需要将手指放入指纹模块上，再检测。需循环调用，直到返回成功
    public static final byte GEN_CHAR_CMD = 0x02; // 图像生成特征+缓冲区号(1 || 2)
    public static final byte REG_MODEL_CMD = 0X05; // 特征合成模块
    public static final byte UP_CHAR_CMD = 0x08; // 从模块中获取特征数据到主机
    // +缓冲区号(1||2)
    public static final byte DOWN_CHAR_CMD = 0x09; // 下载特征模块数据到模块
    // +缓冲区号(1||2)
    public static final byte STORE_CMD = 0X06; // 将特征数据存储到模块的flash中
    // +缓冲区号(1||2) +位置号(0-999)
    public static final byte LOAD_CHAR_CMD = 0X07; // 将特征数据从flash中读到缓存区中 +
    // 缓冲区号(1||2)
    public static final byte DELTE_CHAR_CMD = 0X0C; // 删除flash中的特征数据
    // +位置号(0-999)+删除个数(0-999)
    public static final byte EMPTY_CHAR_CMD = 0X0D; // 清空flash
    public static final byte MATCH_CHAR_CMD = 0X03; // 对比缓冲区号(1和2)中的特征数据
    public static final byte SEARCH_CMD = 0X04; // 用缓存区（1||2）中的特征与整个模块数据（起始页+页数）进行匹配
    public static final byte READ_TEMPLETE_NUM = 0X1D; // 读有效模块个数
    public static final byte SET_SYS_PARA = 0X0E; // 设置系统参数 +(4:波特率：1-12
    // ;5:安全等级1-5;6：数据长度0-3)+数据内容
    public static final byte READ_SYS_PARA = 0X0F; // 读系统参数
    public static final byte WRITE_NOTEPAD = 0x18; // 写记事本+页码(0-15)+用户信息(32byte)
    public static final byte READ_NOTEPAD = 0x19; // 读用户信息+页码(0-15)
    public static final byte READ_FPFLASH = 0X1F; // 读指纹存储信息+页码(0-3);如读出数据为
    // 01 03 则知道 0 8 9
    // 存在指纹数据
    public static final byte GET_IMG_CMD = 0X0A;
}
