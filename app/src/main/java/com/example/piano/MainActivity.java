package com.example.piano;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //private static final int REQUEST_ENABLE_BT = 1;

    private Button txtIsConnected;


    private BluetoothAdapter mBluetoothAdapter;
    private ConnectedThread mConnectedThread;
    private int volume=4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtIsConnected = (Button) findViewById(R.id.txtIsConnected);

        txtIsConnected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 获取蓝牙适配器
                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    Toast.makeText(getApplicationContext(), "该设备不支持蓝牙", Toast.LENGTH_SHORT).show();
                }

                //请求开启蓝牙


                //进入蓝牙设备连接界面
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), DevicesListActivity.class);
                startActivity(intent);
            }
        });

        SeekBar seekBar;
        seekBar=(SeekBar) findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override  //当滑块进度改变时，会执行该方法下的代码
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    volume=i;
                }

                @Override  //当开始滑动滑块时，会执行该方法下的代码
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override   //当结束滑动滑块时，会执行该方法下的代码
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });


        //点击【发送】按钮后，将文本框中的文本按照ASCII码发送到已连接的蓝牙设备
        Button lowC;
        lowC = (Button) findViewById(R.id.lowC);
        lowC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+1)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button lowD;
        lowD = (Button) findViewById(R.id.lowD);
        lowD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+2)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button lowE;
        lowE = (Button) findViewById(R.id.lowE);
        lowE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+3)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button lowF;
        lowF = (Button) findViewById(R.id.lowF);
        lowF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+4)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button lowG;
        lowG = (Button) findViewById(R.id.lowG);
        lowG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+5)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button lowA;
        lowA = (Button) findViewById(R.id.lowA);
        lowA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+6)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button lowB;
        lowB = (Button) findViewById(R.id.lowB);
        lowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+7)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button middleC;
        middleC = (Button) findViewById(R.id.middleC);
        middleC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+9)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button middleD;
        middleD = (Button) findViewById(R.id.middleD);
        middleD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+10)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button middleE;
        middleE = (Button) findViewById(R.id.middleE);
        middleE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+11)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button middleF;
        middleF = (Button) findViewById(R.id.middleF);
        middleF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+12)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button middleG;
        middleG = (Button) findViewById(R.id.middleG);
        middleG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+13)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button middleA;
        middleA = (Button) findViewById(R.id.middleA);
        middleA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+14)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button middleB;
        middleB = (Button) findViewById(R.id.middleB);
        middleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+15)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button highC;
        highC = (Button) findViewById(R.id.highC);
        highC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+17)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button highD;
        highD = (Button) findViewById(R.id.highD);
        highD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+18)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button highE;
        highE = (Button) findViewById(R.id.highE);
        highE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+19)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button highF;
        highF = (Button) findViewById(R.id.highF);
        highF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+20)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button highG;
        highG = (Button) findViewById(R.id.highG);
        highG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+21)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button highA;
        highA = (Button) findViewById(R.id.highA);
        highA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+22)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });
        Button highB;
        highB = (Button) findViewById(R.id.highB);
        highB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] myByte={(byte)(volume*32+23)};
                if(mConnectedThread!=null)
                    mConnectedThread.write(myByte);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        //回到主界面后检查是否已成功连接蓝牙设备
        if (BluetoothUtils.getBluetoothSocket() == null || mConnectedThread != null) {
            txtIsConnected.setText("未连接");
            return;
        }

        txtIsConnected.setText("已连接");

        //已连接蓝牙设备，则接收数据，并显示到接收区文本框
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                return false;
            }
        });

        //启动蓝牙数据收发线程
        mConnectedThread = new ConnectedThread(BluetoothUtils.getBluetoothSocket(), handler);
        mConnectedThread.start();

    }
}