package cn.zhaoliang5156.sensortest.activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

import cn.zhaoliang5156.sensortest.R;
import cn.zhaoliang5156.sensortest.base.BaseActivity;

/**
 * 光传感器页面
 * 需求：获取光传感器的值
 *
 * @author zhaoliang
 * @version 1.0
 */
public class LightActivity extends BaseActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mLightSensor;
    private TextView tvLight;

    @Override
    protected void initData() {
        // 获取光传感器加速度的值
        // 1. 获取传感器管理类
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // 2. 获取光传感器
        mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        tvLight = findViewById(R.id.tv_light_data);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_light;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLightSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float light = event.values[0];
        tvLight.setText("光强度：" + light);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
