package app.itakura.reirei.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    var second = 10
    val timer: CountDownTimer = object : CountDownTimer(10000, 1000) {
        override fun onFinish() {
            startButton.isVisible = true
            second = 10
            secondText.text = second.toString()
        }

        override fun onTick(p0: Long) {
            second = second - 1
            secondText.text = second.toString()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secondText.text = second.toString()

        startButton.setOnClickListener {
            startButton.isVisible = false

            timer.start()
        }

        var count = 0

        tapButton.setOnClickListener {
            count += 1
            when {
                15>count -> {
                    Log.d("count",count.toString())
                    imageView.setImageResource(R.drawable.level3)
                }
                30>count -> {
                    imageView.setImageResource(R.drawable.level2)
                }
                50>=count -> {
                    imageView.setImageResource(R.drawable.level4)
                }
                60>=count -> {
                    imageView.setImageResource(R.drawable.level6)
                }
                count > 60 -> {
                    imageView.setImageResource(R.drawable.level5)
                }
            }

        }
    }
}