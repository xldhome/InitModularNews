package cn.zzuli.initmodular;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.LinearLayout.LayoutParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.attr.data;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;
import static cn.zzuli.initmodular.R.id.all;
import static cn.zzuli.initmodular.R.id.edit_1;
import static cn.zzuli.initmodular.ToBcdAsc.intToByte2;
import static cn.zzuli.initmodular.ToBcdAsc.toint;

public class MainActivity extends Activity {

	private static String TAG = "MainActivity";
	private EditText ip_et;
	private EditText port_et;
	private ToggleButton connect_tb;
	private TextView error_tv;
	private Context context;
	private LinearLayout mll_par;
	private ConnectTask connectTask;
	private ControlTask controlTask;
	private Button bn;
	private View view;
	public String st6;
	public String st15;


	private EditText OilstationNumber;//油站编码
	private EditText OilBusinessLen;//油站营业执照名称长度
	private EditText OilBusiness;//油站营业执照名称
	private EditText codeLen;//营业执照机构代码长度
	private EditText code;//营业执照机构代码
	private Spinner OilClass;//油站类别
	private EditText company;//所属子公司名称
	private EditText companycode;//所属子公司编码
	private EditText jls;//计量所名称
	private EditText xzcode;//油站省市县行政代码
	private EditText phone;//电话
	private EditText yjxl;//油机序列号
	private EditText yjxh;//油机型号
	private EditText yps;//油品数
	private Spinner byfs;//泵油方式
	private EditText xsms;//显示面数
	private EditText isIC;//1是 其他不是
	private EditText htgys;//后台管理系统供应商
	private EditText ccDate;//出厂日期
	private EditText cjmc;//厂家名称
	private EditText cjmccd;//厂家名称长度
	private EditText yjwb1;//油机外部枪号
	private EditText sktd1;//税控通道
	private EditText yjwb2;//油机外部枪号
	private EditText sktd2;
	private EditText yjwb3;//油机外部枪号
	private EditText sktd3;
	private EditText yjwb4;//油机外部枪号
	private EditText sktd4;
	private EditText yjwb5;//油机外部枪号
	private EditText sktd5;
	private EditText yjwb6;//油机外部枪号
	private EditText sktd6;
	private EditText yjwb7;//油机外部枪号
	private EditText sktd7;
	private EditText yjwb8;//油机外部枪号
	private EditText sktd8;







	// 当前命令
	private String curCmd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 控件
		bindView();
		// 数据
		initData();
		// 事件
		initEvent();


	}



	/**
	 * 初始化数据
	 */
	private void initData() {
		context = this;
		error_tv.setText("请点击连接！");
		ip_et.setText(Constant.IP);
		port_et.setText(String.valueOf(Constant.port));
	}

	/**
	 * 绑定控件
	 */
	private void bindView() {
		view = getLayoutInflater().inflate(R.layout.show_linear,null);
		ip_et = (EditText) findViewById(R.id.ip_et);
		mll_par = findViewById(R.layout.activity_main2);
		port_et = (EditText) findViewById(R.id.port_et);
		connect_tb = (ToggleButton) findViewById(R.id.connect_tb);
		error_tv = (TextView) findViewById(R.id.error_tv);
		connect_tb = (ToggleButton)findViewById(R.id.connect_tb);
		bn = (Button)view.findViewById(R.id.request);


		//跳转之后页面的输入框
		OilstationNumber = (EditText) view.findViewById(R.id.edit_1);//油站编码
		OilBusinessLen = (EditText)view.findViewById(R.id.edit_2);//油站营业执照名称长度
		OilBusiness = (EditText) view.findViewById(R.id.edit_3);//油站营业执照名称
		codeLen = (EditText) view.findViewById(R.id.edit_4);//油站营业执照构代码长度
		code = (EditText) view.findViewById(R.id.edit_5);//油站营业执照机构代码
		OilClass= (Spinner) view.findViewById(R.id.edit_6);//油站类别
		company= (EditText)view.findViewById(R.id.edit_7);//所属子公司名称
		companycode = (EditText)view.findViewById(R.id.edit_8);//所属子公司编码
		jls = (EditText) view.findViewById(R.id.edit_9);//所属计量所名称
		xzcode = (EditText)view.findViewById(R.id.edit_10);//油站省市县行政代码信息
		phone = (EditText) view.findViewById(R.id.edit_11);//电话
		yjxl = (EditText)view.findViewById(R.id.edit_02);//油机序列号
		yjxh = (EditText)view.findViewById(R.id.edit_03);//油机型号
		yps= (EditText) findViewById(R.id.edit_04);//油品数
		byfs = (Spinner)view.findViewById(R.id.edit_06);//泵油方式
		xsms= (EditText) view.findViewById(R.id.edit_07);//显示面数
		isIC = (EditText) view.findViewById(R.id.edit_08);//是否IC卡
		htgys = (EditText) view.findViewById(R.id.edit_09);//后台管理系统供应商
		ccDate = (EditText) view.findViewById(R.id.edit_010);//出厂日期
		cjmc= (EditText) view.findViewById(R.id.edit_011);//厂家名称长度
		cjmccd = (EditText) view.findViewById(R.id.edit_012);//厂家名称
		yjwb1= (EditText) view.findViewById(R.id.edit_014);//油机外部枪号1
		sktd1 = (EditText) view.findViewById(R.id.edit_015);//税控通道
		yjwb2= (EditText) view.findViewById(R.id.edit_016);//油机外部枪号2
		sktd2 = (EditText) view.findViewById(R.id.edit_017);//税控通道
		yjwb3= (EditText) view.findViewById(R.id.edit_018);//油机外部枪号3
		sktd3= (EditText) view.findViewById(R.id.edit_019);//税控通道
		yjwb4= (EditText) view.findViewById(R.id.edit_020);//油机外部枪号4
		sktd4 = (EditText) view.findViewById(R.id.edit_021);//税控通道
		yjwb5= (EditText) view.findViewById(R.id.edit_022);//油机外部枪号5
		sktd5 = (EditText) view.findViewById(R.id.edit_023);//税控通道
		yjwb6= (EditText) view.findViewById(R.id.edit_024);//油机外部枪号6
		sktd6 = (EditText) view.findViewById(R.id.edit_025);//税控通道
		yjwb7= (EditText) view.findViewById(R.id.edit_026);//油机外部枪号7
		sktd7 = (EditText) view.findViewById(R.id.edit_027);//税控通道
		yjwb8= (EditText) view.findViewById(R.id.edit_028);//油机外部枪号8
		sktd8 = (EditText) view.findViewById(R.id.edit_029);//税控通道


	}

	/**
	 * 按钮监听
	 */
	private void initEvent() {
		//final Intent intent = new Intent(MainActivity.this,Main2Activity.class);
		// 连接
		connect_tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					// 获取IP和端口
					String IP = ip_et.getText().toString().trim();
					String port = port_et.getText().toString().trim();
					if (checkIpPort(IP, port)) {
						Constant.IP = IP;
						Constant.port = Integer.parseInt(port);
					} else {
						Toast.makeText(context, "IP和端口输入不正确,请重输！", Toast.LENGTH_SHORT).show();
						return;
					}

					// 开启任务
					connectTask = new ConnectTask(context, error_tv);
					connectTask.execute();
                        try {
                            Thread.sleep(200);
                        }catch (Exception e){}
					if(Constant.state==1){
						Toast.makeText(context,"连接成功，进入初始化界面",Toast.LENGTH_LONG).show();
						setContentView(view);
						OilClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

							@Override
							public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
								String select = OilClass.getSelectedItem().toString();
								st6 = select.substring(0,1);
								Constant.value1 = Integer.parseInt(select.substring(0,1));
							}

							@Override
							public void onNothingSelected(AdapterView<?> adapterView) {

							}
						});

						byfs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
							@Override
							public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
								String select = OilClass.getSelectedItem().toString();
								Constant.value2 = Integer.parseInt(select.substring(0,1));

							}

							@Override
							public void onNothingSelected(AdapterView<?> adapterView) {

							}
						});

					}

				} else {
					// 取消任务
					if (connectTask != null && connectTask.getStatus() == AsyncTask.Status.RUNNING) {
						// 如果Task还在运行，则先取消它
						connectTask.setSTATU(false);
						connectTask.cancel(true);
                        Constant.state=0;
					}
					// 关闭socket
					if (ConnectTask.getmSocket() != null) {
						try {
							ConnectTask.getmSocket().close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					error_tv.setText("请点击连接！");
					error_tv.setTextColor(context.getResources().getColor(R.color.gray));
				}




			}

		});


		bn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				//List<Integer> a = new ArrayList<Integer>();
//				String s1 = "BB ";
//				String s2 = ToBcdAsc.Hexto(intToByte2(337));
//
//				String s3 = ToBcdAsc.str2Bcd("10");
//
//				String s4 = ToBcdAsc.Hexto(intToByte2(8));
//
//				String s5 = ToBcdAsc.Hexto(intToByte2(11));
//
//				String s6 = ToBcdAsc.SumStrAscii(ip_et.getText().toString().trim(),20);
//				String s7 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(port_et.getText().toString().trim())));
//
//				String str_1 = OilstationNumber.getText().toString().trim();//油站编号
//				String st1 = ToBcdAsc.SumStrAscii(str_1,10);
//
//				String str_2 = OilBusinessLen.getText().toString().trim();//油站营业执照名称长度
//				String st2 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_2)));
//
//
//
//				String str_3 = OilBusiness.getText().toString().trim();//油站营业执照名称
//				String st3 = ToBcdAsc.toGB2312(str_3,40);
//
//				String str_4 = codeLen.getText().toString().trim();//油站营业执照构代码长度
//				String st4 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_4)));
//
//
//				String str_5 = code.getText().toString().trim();//油站营业执照机构代码
//				String st5 = ToBcdAsc.SumStrAscii(str_5,20);





//				String str_7 = company.getText().toString().trim();//所属子公司名称
//				String st7 = ToBcdAsc.toGB2312(str_7,50);
//
//				String str_8 = companycode.getText().toString().trim();//所属子公司编码
//				String st8 = ToBcdAsc.str2Bcd(str_8);
//
//				String str_9 = jls.getText().toString().trim();//所属计量所名称
//				String st9 = ToBcdAsc.toGB2312(str_9,50);
//
//
//				String str_10 = xzcode.getText().toString().trim();//油站省市县行政代码信息
//				String st10 = ToBcdAsc.str2Bcd(str_10);
//
//				String str_11 = phone.getText().toString().trim();//电话
//				String st11 = ToBcdAsc.str2Bcd(str_11);
//
//				String str_12 = yjxl.getText().toString().trim();//油机序列号
//				String st12 = ToBcdAsc.SumStrAscii(str_12,20);
//
//				String str_13 = yjxh.getText().toString().trim();//油机型号
//				String st13 = ToBcdAsc.SumStrAscii(str_13,20);
//
//				String str_14 = yps.getText().toString().trim();//油品数
//				String st14 = ToBcdAsc.strBcd(str_14);



//				String str_16 = xsms.getText().toString().trim();//显示面数
//				String st16 = ToBcdAsc.strBcd(str_16);
//
//
//				String str_17 = isIC.getText().toString().trim();//是否IC卡
//				String st17 = ToBcdAsc.strBcd(str_17);//此处是BCD
//
//				String str_18 = htgys.getText().toString().trim();//后台管理系统供应商
//				String st18 = ToBcdAsc.toGB2312(str_18,10);
//
//				String str_19 = ccDate.getText().toString().trim();//出厂日期
//				String st19 = ToBcdAsc.strBcd(str_19);
//
//				String str_20 = cjmc.getText().toString().trim();//厂家名称长度
//				String st20 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_20)));
//
//				String str_21 = cjmccd.getText().toString().trim();//厂家名称
//				String st21 = ToBcdAsc.toGB2312(str_21,50);
//
//				String str_22 = yjwb1.getText().toString().trim();//油机外部枪号1
//				String st22 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_22)));
//
//				String str_23 = sktd1.getText().toString().trim();//税控通道
//				String st23 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_23)));
//
//				String str_24 = yjwb2.getText().toString().trim();//油机外部枪号2
//				String st24 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_24)));
//
//				String str_25 = sktd2.getText().toString().trim();//税控通道
//				String st25 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_25)));
//
//				String str_26 = yjwb3.getText().toString().trim();//油机外部枪号3
//				String st26 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_26)));
//
//				String str_27 = sktd3.getText().toString().trim();//税控通道
//				String st27 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_27)));
//
//				String str_28 = yjwb4.getText().toString().trim();//油机外部枪号4
//				String st28 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_28)));
//
//				String str_29 = sktd4.getText().toString().trim();//税控通道
//				String st29 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_29)));
//
//				String str_30 = yjwb5.getText().toString().trim();//油机外部枪号5
//				String st30 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_30)));
//
//				String str_31 = sktd5.getText().toString().trim();//税控通道
//				String st31 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_31)));
//
//				String str_32 = yjwb6.getText().toString().trim();//油机外部枪号6
//				String st32 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_32)));
//
//				String str_33 = sktd6.getText().toString().trim();//税控通道
//				String st33 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_33)));
//
//				String str_34 = yjwb7.getText().toString().trim();//油机外部枪号7
//				String st34 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_34)));
//
//				String str_35 = sktd7.getText().toString().trim();//税控通道
//				String st35 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_35)));
//
//				String str_36 = yjwb8.getText().toString().trim();//油机外部枪号8
//				String st36 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_36)));
//
//				String str_37 = sktd8.getText().toString().trim();//税控通道
//				String st37 = ToBcdAsc.Hexto(intToByte2(Integer.parseInt(str_37)));

				//参数
				/*String all_str = s3 + s4 + s5 + s6 + s7 + st1 + st2 +  st3 + st4 + st5 + st6 + st7 + st8 + st9
						+ st10 + st11 + st12 + st13 + st14 + st15 + st16 + st17 + st18 + st19 + st20 + st21 + st22 + st23 + st24
						+ st25 + st26 + st27 + st28 + st29 + st30 + st31 + st32 + st33 + st34 + st35 + st36 + st37;

				String[] array = all_str.split(" ");
				int a1[] = ToBcdAsc.toint(array);

				int x = a1[0];

				for (int i=1;i<a1.length;i++) {
					x = x ^ a1[i];
				}

				String xx = Integer.toHexString(x);

				//String ss = all_str + xx;//
				String cmd =s1 + s2 + all_str + xx;

				Toast.makeText(context,"666"+cmd, Toast.LENGTH_LONG).show();
				if(connectTask!=null && connectTask.getSTATU()){
					controlTask = new ControlTask(context,connectTask.getInputStream(),connectTask.getOutputStream()
							,Constant.ONE_CMD);
					connectTask.execute();
				}else {
					Toast.makeText(context, "发送命令失败", Toast.LENGTH_SHORT).show();
				}*/
				Toast.makeText(context,"公司："+Constant.value1+"方式："+Constant.value2,Toast.LENGTH_LONG).show();
			}
		});
	}



	/**
	 * IP地址可用端口号验证，可用端口号（1024-65536）
	 * 
	 * @param IP
	 * @param port
	 * @return
	 */
	private boolean checkIpPort(String IP, String port) {
		boolean isIpAddress = false;
		boolean isPort = false;

		if (IP == null || IP.length() < 7 || IP.length() > 15 || "".equals(IP) || port == null || port.length() < 4
				|| port.length() > 5) {
			return false;
		}
		// 判断IP格式和范围
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

		Pattern pat = Pattern.compile(rexp);

		Matcher mat = pat.matcher(IP);

		isIpAddress = mat.find();

		// 判断端口
		int portInt = Integer.parseInt(port);
		if (portInt > 1024 && portInt < 65536) {
			isPort = true;
		}

		return (isIpAddress && isPort);
	}

	@Override
	public void finish() {
		super.finish();
		try {
			// 取消任务
			if (connectTask != null && connectTask.getStatus() == AsyncTask.Status.RUNNING) {
				// 如果Task还在运行，则先取消它
				connectTask.cancel(true);
				connectTask.getmSocket().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
