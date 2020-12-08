package com.zhengsr.opengldemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhengsr.opengldemo.R

/**
 * 曲棍球桌子
 */
class AirHockey : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //opengl 只能绘制点、直线以及三角形
        setContentView(R.layout.activity_air_hockey)
    }
}