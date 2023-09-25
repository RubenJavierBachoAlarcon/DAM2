import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import com.example.tiptime.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val costService = findViewById<TextView>(R.id.editTextText)
        val solution = findViewById<TextView>(R.id.textView3)
        val checkBox1 = findViewById<RadioButton>(R.id.option_twenty_percent)
        val checkBox2 = findViewById<RadioButton>(R.id.option_twenty_percent2)
        val checkBox3 = findViewById<RadioButton>(R.id.option_twenty_percent3)
        var solutionNum = 0.0  // Use a Double to store decimal values

        // Convert the text to a Double if it's a valid number
        val costText = costService.text.toString()
        val costValue = costText.toDoubleOrNull()

        if (costValue != null) {
            if (checkBox1.isChecked) {
                solutionNum = costValue * 0.2
            } else if (checkBox2.isChecked) {
                solutionNum = costValue * 0.18
            } else if (checkBox3.isChecked) {
                solutionNum = costValue * 0.15
            }
        } else {
            // Handle the case where the input is not a valid number
            // You might want to show an error message or take appropriate action
        }

        // Convert solutionNum to a String before setting it as the text
        solution.text = solutionNum.toString()
    }
}
