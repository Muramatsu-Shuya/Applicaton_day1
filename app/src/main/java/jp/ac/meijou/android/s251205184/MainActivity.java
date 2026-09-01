package jp.ac.meijou.android.s251205184;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
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
        prefDataStore = PrefDataStore.getInstance(this);
        prefDataStore.getString("name")
                .ifPresent(name -> {
                    if("a".equals(name)){
                        binding.textView.setText("Aの画像");
                        binding.imageView.setImageResource(R.drawable.outline_approval_delegation_24);
                    } else if ("b".equals(name)) {
                        binding.textView.setText("Bの画像");
                        binding.imageView.setImageResource(R.drawable.outline_approval_delegation_25);
                    } else if ("c".equals(name)) {
                        binding.textView.setText("Cの画像");
                        binding.imageView.setImageResource(R.drawable.outline_approval_delegation_26);
                    }else{
                        binding.textView.setText("知らない画像");
                        binding.imageView.setImageResource(R.drawable.baseline_block_24);
                    }
                });


        //binding.textView.setText("-");

        //binding.imageView.setImageResource(R.drawable.baseline_block_24);

        binding.button.setOnClickListener(view ->{
            var text = binding.editText.getText().toString();
            binding.textView.setText(text);
            binding.imageView.setImageResource(R.drawable.outline_approval_delegation_25);
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

        binding.SaveButton.setOnClickListener(view -> {
            var text = binding.editText.getText().toString();
            if("a".equals(text)){
                binding.imageView.setImageResource(R.drawable.outline_approval_delegation_24);
            }else if("b".equals(text)){
                binding.imageView.setImageResource(R.drawable.outline_approval_delegation_25);
            }else if("c".equals(text)) {
                binding.imageView.setImageResource(R.drawable.outline_approval_delegation_26);
            }else{
                binding.imageView.setImageResource(R.drawable.baseline_block_24);
            }
            prefDataStore.setString("name", text);
            //binding.imageView.setImageResource(R.drawable.outline_approval_delegation_24);
        });

        binding.DeleteButton.setOnClickListener(view -> {
            String text = null;
            binding.textView.setText(text);
            prefDataStore.setString("name", text);
        });

    }
}