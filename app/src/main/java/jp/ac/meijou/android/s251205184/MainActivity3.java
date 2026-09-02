package jp.ac.meijou.android.s251205184;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205184.databinding.ActivityMain3Binding;
import jp.ac.meijou.android.s251205184.databinding.ActivityMainBinding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String setText = intent.getStringExtra("editText");
        binding.result.setText(setText);

        binding.button0.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "0");
        });

        binding.button1.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "1");
        });

        binding.button2.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "2");
        });

        binding.button3.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "3");
        });

        binding.button4.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "4");
        });

        binding.button5.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "5");
        });

        binding.button6.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "6");
        });

        binding.button7.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "7");
        });

        binding.button8.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "8");
        });

        binding.button9.setOnClickListener(view -> {
            binding.result.setText(binding.result.getText().toString() + "9");
        });

        binding.buttonAC.setOnClickListener(v -> {
            binding.result.setText(null);
        });

        binding.buttonDiv.setOnClickListener(v -> {
            binding.result.setText(binding.result.getText().toString() + "÷");
        });

        binding.buttonMulti.setOnClickListener(v -> {
            binding.result.setText(binding.result.getText().toString() + "×");
        });

        binding.buttonSub.setOnClickListener(v -> {
            binding.result.setText(binding.result.getText().toString() + "-");
        });

        binding.buttonPlus.setOnClickListener(v -> {
            binding.result.setText(binding.result.getText().toString() + "+");
        });

        binding.buttonOK.setOnClickListener(view -> {
            var ok_intent = new Intent();
            ok_intent.putExtra("ret", "Ok");
            setResult(RESULT_OK, ok_intent);
            finish();
        });

        binding.buttonCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }


}