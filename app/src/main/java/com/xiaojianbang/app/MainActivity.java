package com.xiaojianbang.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.JavaMD5)).setOnClickListener(this);
        ((Button) findViewById(R.id.SHA)).setOnClickListener(this);
        ((Button) findViewById(R.id.MAC)).setOnClickListener(this);
        ((Button) findViewById(R.id.DES)).setOnClickListener(this);
        ((Button) findViewById(R.id.DESede)).setOnClickListener(this);
        ((Button) findViewById(R.id.AES)).setOnClickListener(this);
        ((Button) findViewById(R.id.RSA)).setOnClickListener(this);
        ((Button) findViewById(R.id.RSAHex)).setOnClickListener(this);
        ((Button) findViewById(R.id.helloFromC)).setOnClickListener(this);
        ((Button) findViewById(R.id.add)).setOnClickListener(this);

        ((Button) findViewById(R.id.CMD5)).setOnClickListener(this);
        ((Button) findViewById(R.id.showMap)).setOnClickListener(this);
        ((Button) findViewById(R.id.putong)).setOnClickListener(this);
        ((Button) findViewById(R.id.gouzao)).setOnClickListener(this);
        ((Button) findViewById(R.id.chongzai)).setOnClickListener(this);
        ((Button) findViewById(R.id.duixiang)).setOnClickListener(this);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("启动前打印：");
        stringBuilder.append(Utils.getCalc(1000, 2000));
        toastPrint(stringBuilder.toString());

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    public void toastPrint(String toShowString) {
        Toast.makeText(this, toShowString, Toast.LENGTH_SHORT).show();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            String str = BuildConfig.FLAVOR;
            case R.id.helloFromC:
                try {
                    Toast.makeText(this, NativeHelper.helloFromC(), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.add:
                try {
                    Toast.makeText(this, String.valueOf(NativeHelper.add(5, 6, 7)), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.JavaMD5:
                try {
                    //Toast.makeText(this, NativeHelper.encode("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, MD5.md5_1("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.SHA /*{ENCODED_INT: 2131230721}*/:
                try {
                    Toast.makeText(this, SHA.sha_1("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case R.id.MAC /*{ENCODED_INT: 2131230722}*/:
                try {
                    Toast.makeText(this, MAC.mac_1("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case R.id.DES /*{ENCODED_INT: 2131230723}*/:
                try {
                    Toast.makeText(this, DES.des_2("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            case R.id.DESede /*{ENCODED_INT: 2131230724}*/:
                try {
                    Toast.makeText(this, DESede.desede("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return;
                }
            case R.id.AES /*{ENCODED_INT: 2131230725}*/:
                try {
                    Toast.makeText(this, AES.aes("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case R.id.RSA /*{ENCODED_INT: 2131230726}*/:
                try {
                    Toast.makeText(this, RSA.rsa("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    return;
                }
            case R.id.RSAHex /*{ENCODED_INT: 2131230727}*/:
                try {
                    Toast.makeText(this, RSAHex.rsaHex("xiaojianbang"), Toast.LENGTH_SHORT).show();
                    return;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    return;
                }
            case R.id.chongzai:
                toastPrint(Utils.test(666));
                toastPrint(new Money(){
                    public String getInfo(){
                        return "匿名类被调用";
                    }
                }.getInfo());
                return;
            case R.id.duixiang:
                toastPrint(Utils.test(new Money("美元", 200)));
                toastPrint(new Utils().myPrint(new String[]{"资源共享吧", "官网", ":", "www.zygx8.com"}));
                return;
            case R.id.gouzao:
                toastPrint(Utils.getMoney().getInfo());
                toastPrint(new Money().name());
                return;
            case R.id.putong:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Utils.getCalc(2000, 2000));
                stringBuilder.append("str");
                toastPrint(stringBuilder.toString());
                //toastPrint(new innerClass("资源吧", 666).outPrint());
                return;
            case R.id.showMap:
                showMap_();
                return;
            default:
                return;
        }

    }

    private void showMap_() {
    }
}
