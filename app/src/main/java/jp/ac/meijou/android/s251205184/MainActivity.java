package jp.ac.meijou.android.s251205184;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205184.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        prefDataStore = PrefDataStore.getInstance((this));
        prefDataStore.getString("text")
                .ifPresent(text -> binding.textView.setText(text));

        binding.textView.setText("-");

        binding.imageView.setImageResource(R.drawable.baseline_block_24);

        binding.button.setOnClickListener(view ->{
            var text = binding.editText.getText().toString();
            binding.textView.setText(text);
            binding.imageView.setImageResource(R.drawable.outline_approval_delegation_24);
        });

        binding.SaveButton.setOnClickListener(view -> {
            var text = binding.editText.getText().toString();
            prefDataStore.setString("text", text);
            binding.imageView.setImageResource(R.drawable.outline_approval_delegation_24);
        });

        binding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                binding.textView.setText(text);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });


    }
}