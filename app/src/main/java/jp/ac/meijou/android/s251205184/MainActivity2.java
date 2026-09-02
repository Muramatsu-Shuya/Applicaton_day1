package jp.ac.meijou.android.s251205184;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Optional;

import jp.ac.meijou.android.s251205184.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s251205184.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonA.setOnClickListener(view -> {
            var intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        });

        binding.buttonB.setOnClickListener(view -> {
            var intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.meijo-u.ac.jp"));
            startActivity(intent);
        });

        binding.buttonSend.setOnClickListener(view -> {
            String sentText = binding.editText.getText().toString();

            var intent = new Intent(this, MainActivity3.class);

            intent.putExtra("editText", sentText);
            startActivity(intent);
        });

        binding.buttonHappen.setOnClickListener(v -> {
            var intent = new Intent(this, MainActivity3.class);
            getActivityResult.launch(intent);
        });

    }

    private final ActivityResultLauncher<Intent> getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()){
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result:" + text)
                                .ifPresent(text -> binding.textView4.setText(text));
                        break;
                    case  RESULT_CANCELED:
                        binding.textView4.setText("Result: Canceled");
                        break;
                    default:
                        binding.textView4.setText("Resul: Unknown(" + result.getResultCode() + ")");
                        break;
                }
            }
    );
}