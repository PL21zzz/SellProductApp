package com.example.loginapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionViewFlipper();
    }

    private fun actionViewFlipper() {
        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        val banner = mutableListOf<String>()
        banner.add("https://marketingtoancau.com/files/product/thiet-ke-banner-chuyen-nghiep-cho-cua-hang-dien-thoai-nhat-nam-mobile-dqovvmz5.jpg")
        banner.add("https://baotinmobile.vn/uploads/2023/03/sl-iphone-14-promax.jpg.webp")
        banner.add("https://laptopbaominh.com/wp-content/uploads/2019/11/banner-web-2.jpg")

        for (i in banner.indices) {
            val imageView = ImageView(applicationContext)
            Glide.with(applicationContext).load(banner[i]).into(imageView)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            viewFlipper.addView(imageView)
        }

        viewFlipper.flipInterval = 3000
        viewFlipper.isAutoStart = true
        val slideIn = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_right)
        val slideOut = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_out_right)
        viewFlipper.inAnimation = slideIn
        viewFlipper.outAnimation = slideOut
    }

}