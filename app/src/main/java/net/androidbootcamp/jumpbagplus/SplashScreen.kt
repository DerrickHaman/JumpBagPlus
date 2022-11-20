package net.androidbootcamp.jumpbagplus

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val image = findViewById<ImageView>(R.id.splashImageView)
        val text = findViewById<TextView>(R.id.txtSplashTitle)

        image.alpha = 0f
        text.alpha = 0f

        text.animate().setDuration(2000).alpha(1f)
        image.animate().setDuration(2000).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}