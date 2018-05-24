package cn.zhaoliang5156.sensortest.activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.TextView;

import cn.zhaoliang5156.sensortest.R;
import cn.zhaoliang5156.sensortest.base.BaseActivity;

/**
 * 加速度传感器页面
 * 需求：获取加速度传感器的数据
 *
 * @author zhaoliang
 * @version 1.0
 */
public class AccActivity extends BaseActivity implements SensorEventListener {

    private static final String TAG = AccActivity.class.getSimpleName();
    private SensorManager mSensorManager;
    private Sensor mAccSensor;
    private TextView accTv;

    @Override
    protected void initData() {
        //需求： 获取传感器的值并显示
        // 1. 获取传感器管理类
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // 2. 获取传感器Sensor对象
        mAccSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        accTv = findViewById(R.id.tv_acc_data);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_acc;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 注册监听
        mSensorManager.registerListener(this, mAccSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解除注册监听
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        Log.i(TAG, "x:" + x + "y:" + y + "z:" + z);
        // 判断摇一摇逻辑
        accTv.setText("x:" + x + "y:" + y + "z:" + z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
