package id.arieridwan.androidmvp.main;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.arieridwan.androidmvp.R;

public class MainActivity extends AppCompatActivity implements MainView {

    TextView mTextTitle,mTextAuthor,mTextYear;
    Button mButtonInput;
    View mView;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mButtonInput.setOnClickListener(view -> {
            presenter.input(mTextTitle.getText().toString().trim()
                    ,mTextAuthor.getText().toString().trim()
                    ,mTextYear.getText().toString().trim());
        });
    }

    private void initView(){
        mTextTitle = (TextView) findViewById(R.id.mTextTitle);
        mTextAuthor = (TextView) findViewById(R.id.mTextAuthor);
        mTextYear = (TextView) findViewById(R.id.mTextYear);
        mButtonInput = (Button) findViewById(R.id.mButtonInput);
        mView = findViewById(R.id.view);
        presenter = new MainPresenterImpl(this);
    }

    @Override
    public void showValidationError() {
        Snackbar.make(mView,getResources().getString(R.string.input_not_valid),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void inputuccess() {
        Snackbar.make(mView,getResources().getString(R.string.input_succes),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void inputError() {
        Snackbar.make(mView,getResources().getString(R.string.input_error),Snackbar.LENGTH_SHORT).show();
    }
}
