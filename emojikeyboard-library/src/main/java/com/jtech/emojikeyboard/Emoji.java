package com.jtech.emojikeyboard;

import java.util.ArrayList;
import java.util.List;

/**
 * 表情编码
 * Created by wuxubaiyang on 2017/5/7.
 */

class Emoji {

    public static final String[] emojiTitles = {"Emoticons", "Dingbats", "Transport"};

    public static List<int[]> getEmojiList() {
        List<int[]> emojiList = new ArrayList<>();
        emojiList.add(Emoji.Emoticons);
        emojiList.add(Emoji.Dingbats);
        emojiList.add(Emoji.Transport);
        return emojiList;
    }

    /**
     * 表情符号
     */
    public static final int[] Emoticons = {
            0x1F601,
            0x1F602,
            0x1F603,
            0x1F604,
            0x1F605,
            0x1F606,
            0x1F609,
            0x1F60A,
            0x1F60B,
            0x1F60C,
            0x1F60D,
            0x1F60F,
            0x1F612,
            0x1F613,
            0x1F614,
            0x1F616,
            0x1F618,
            0x1F61A,
            0x1F61C,
            0x1F61D,
            0x1F61E,
            0x1F620,
            0x1F621,
            0x1F622,
            0x1F623,
            0x1F624,
            0x1F625,
            0x1F628,
            0x1F629,
            0x1F62A,
            0x1F62B,
            0x1F62D,
            0x1F630,
            0x1F631,
            0x1F632,
            0x1F633,
            0x1F635,
            0x1F637,
            0x1F638,
            0x1F639,
            0x1F63A,
            0x1F63B,
            0x1F63C,
            0x1F63D,
            0x1F63E,
            0x1F63F,
            0x1F640,
            0x1F645,
            0x1F646,
            0x1F647,
            0x1F648,
            0x1F649,
            0x1F64A,
            0x1F64B,
            0x1F64C,
            0x1F64D,
            0x1F64E,
            0x1F64F
    };
    /**
     * 装饰表情
     */
    public static final int[] Dingbats = {
            0x2702,
            0x2705,
            0x2708,
            0x2709,
            0x270A,
            0x270B,
            0x270C,
            0x270F,
            0x2712,
            0x2714,
            0x2716,
            0x2728,
            0x2733,
            0x2734,
            0x2744,
            0x2747,
            0x274C,
            0x274E,
            0x2753,
            0x2754,
            0x2755,
            0x2757,
            0x2764,
            0x2795,
            0x2796,
            0x2797,
            0x27A1,
            0x27B0
    };
    /**
     * 交通
     */
    public static final int[] Transport = {
            0x1F680,
            0x1F683,
            0x1F684,
            0x1F685,
            0x1F687,
            0x1F689,
            0x1F68C,
            0x1F68F,
            0x1F691,
            0x1F692,
            0x1F693,
            0x1F695,
            0x1F697,
            0x1F699,
            0x1F69A,
            0x1F6A2,
            0x1F6A4,
            0x1F6A5,
            0x1F6A7,
            0x1F6A8,
            0x1F6A9,
            0x1F6AA,
            0x1F6AB,
            0x1F6AC,
            0x1F6AD,
            0x1F6B2,
            0x1F6B6,
            0x1F6B9,
            0x1F6BA,
            0x1F6BB,
            0x1F6BC,
            0x1F6BD,
            0x1F6BE,
            0x1F6C0
    };
}