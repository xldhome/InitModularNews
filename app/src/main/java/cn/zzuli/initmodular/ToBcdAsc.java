package cn.zzuli.initmodular;
/**
 * Created by Hello on 2017/7/14.
 */

import java.io.UnsupportedEncodingException;

public class ToBcdAsc {
    /**
     * @功能: 字符串转成Asc
     * @结果: Asc码
     */
    public static String SumStrAscii(String str,int len){
        StringBuffer sb1 = new StringBuffer();
        String[] s1 = str.split("");
        String[] s2 = new String[len];
        System.arraycopy(s1, 0, s2, 0, s1.length);//处理空数组
        for(String sss:s2){
            if(sss==null){
                sb1.append(" ");
            }else{
                sb1.append(sss);
            }

        }
        byte[] bytestr = sb1.toString().getBytes();
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        System.out.println(bytestr.length);
        for(int i=0;i<bytestr.length;i++){
            if(!(i==bytestr.length-1)){
                sb.append(Integer.toHexString(bytestr[i]).toUpperCase());
                sb.append(" ");
            }else{
                sb.append(Integer.toHexString(bytestr[i]).toUpperCase());

            }
        }
        return sb.toString();
    }
    /**
     * 最新压缩BCD转码
     * @param asc
     * @return
     */
    public static String str2Bcd(String asc) {
        int len = asc.length();
        int mod = len % 2;
        if (mod != 0) {
            asc = asc+"0";
            len = asc.length();
        }
        byte abt[] = new byte[len];
        if (len >= 2) {
            len = len / 2;
        }
        byte bbt[] = new byte[len];
        abt = asc.getBytes();
        int j, k;
        for (int p = 0; p < asc.length() / 2; p++) {
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
                j = abt[2 * p] - '0';
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
                j = abt[2 * p] - 'a' + 0x0a;
            } else {
                j = abt[2 * p] - 'A' + 0x0a;
            }
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
                k = abt[2 * p + 1] - '0';
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
                k = abt[2 * p + 1] - 'a' + 0x0a;
            } else {
                k = abt[2 * p + 1] - 'A' + 0x0a;
            }
            int a = (j << 4) + k;
            byte b = (byte) a;
            //System.out.println(b+"^^^^"+Integer.toHexString(b)+"&&&"+p);
            bbt[p] = b;
        }
        StringBuffer sb = new StringBuffer();
        for(byte tt:bbt){
            String w = null;
            if(tt<0){
                w = Integer.toHexString(tt).substring(6);
            }else{
                w = Integer.toHexString(tt);
            }
            if(w.length()<2){
                w="0"+w;
                sb.append(w.toUpperCase());
                sb.append(" ");
            }else{
                sb.append(w.toUpperCase());
                sb.append(" ");

            }
        }
        return sb.toString();
    }

    /**
     * BCD
     * @param asc
     * @return
     */
    public static String strBcd(String asc) {
        int len = asc.length();
        int mod = len % 2;
        if (mod != 0) {
            asc = "0"+asc;
            len = asc.length();
        }
        byte abt[] = new byte[len];
        if (len >= 2) {
            len = len / 2;
        }
        byte bbt[] = new byte[len];
        abt = asc.getBytes();
        int j, k;
        for (int p = 0; p < asc.length() / 2; p++) {
            if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
                j = abt[2 * p] - '0';
            } else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
                j = abt[2 * p] - 'a' + 0x0a;
            } else {
                j = abt[2 * p] - 'A' + 0x0a;
            }
            if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
                k = abt[2 * p + 1] - '0';
            } else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
                k = abt[2 * p + 1] - 'a' + 0x0a;
            } else {
                k = abt[2 * p + 1] - 'A' + 0x0a;
            }
            int a = (j << 4) + k;
            byte b = (byte) a;
            //System.out.println(b+"^^^^"+Integer.toHexString(b)+"&&&"+p);
            bbt[p] = b;
        }
        StringBuffer sb = new StringBuffer();
        for(byte tt:bbt){
            String w = null;
            if(tt<0){
                w = Integer.toHexString(tt).substring(6);
            }else{
                w = Integer.toHexString(tt);
            }
            if(w.length()<2){
                w="0"+w;
                sb.append(w.toUpperCase());
                sb.append(" ");
            }else{
                sb.append(w.toUpperCase());
                sb.append(" ");

            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
    /**
     * 压缩BCD转换为String
     *
     * @param b
     * @return
     */
    public static String cbcd2string(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            int h = ((b[i] & 0xff) >> 4) + 48;
            sb.append((char) h);
            int l = (b[i] & 0x0f) + 48;
            sb.append((char) l);
        }
        return sb.toString();
    }



    /**
     * 数字转化为二进制
     *
     * @param
     * @return
     */
    public static String toTwo(int number) {
        int sum;
        String result = "";
        for (int i = number; i >= 1; i /= 2) {
            if (i % 2 == 0) {
                sum = 0;
            } else {
                sum = 1;
            }
            result = sum + result;
        }
        System.out.print(result);
        return result;
    }

    /**
     * 中文转换编码
     * @param s11
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String toGB2312(String s11, int len) {

        StringBuffer sb1 = new StringBuffer();
        byte[] src =  null;
        String[] s1 = s11.split("");
        String[] s2 = new String[len/2];
        System.arraycopy(s1, 0, s2, 0, s1.length);//处理空数组
        for(String sss:s2){
            if(sss==null){
                sb1.append("  ");
            }else{
                sb1.append(sss);
            }

        }
        byte[] sour;
        byte[] newtemp;
        String dest = null;
        try {
            sour=sb1.toString().getBytes("utf-8");
            newtemp=new String(sour,"utf-8").getBytes("gb2312");
            dest=new String(newtemp,"gb2312");
            src = dest.getBytes("gb2312");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();

        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v).toUpperCase();
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();

    }



    /**
     * int整数转换为4字节的byte数组
     * @param i
     * @return
     */
    public static byte[] intToByte4(int i) {
        byte[] targets = new byte[4];
        targets[3] = (byte) (i & 0xFF);
        targets[2] = (byte) (i >> 8 & 0xFF);
        targets[1] = (byte) (i >> 16 & 0xFF);
        targets[0] = (byte) (i >> 24 & 0xFF);
        return targets;
    }

    /**
     * 16转换为10
     * @param s
     * @return
     */
    public static int[] toint(String s[]){
        int num[] = new int[s.length];
        for(int i =0;i<s.length;i++)
            num[i] = Integer.parseInt(s[i], 16);
        return num;
    }

    /**
     * 转换16进制
     * @param bbb
     * @return
     */
    public static String Hexto(byte[] bbb){
        StringBuffer sb = new StringBuffer();
        for(byte tt:bbb){
            if(tt>=0&&tt<10){
                sb.append("0"+Integer.toHexString(tt).toUpperCase());
                sb.append(" ");
            }else{
                sb.append(Integer.toHexString(tt).toUpperCase());
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 二字节数组
     * @param i
     * @return
     */
    public static byte[] intToByte2(int i) {
        byte[] targets = new byte[2];
        targets[1] = (byte) (i & 0xFF);
        targets[0] = (byte) (i >> 8 & 0xFF);

        return targets;
    }

}