package id.arieridwan.androidmvp.main;

import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import id.arieridwan.androidmvp.util.Constant;

/**
 * Created by ASUS on 25/10/2016.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(Constant.DB_NAME);

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void input(String title, String author, String year) {
        if(TextUtils.isEmpty(title) || TextUtils.isEmpty(author) || TextUtils.isEmpty(year)){
            mainView.showValidationError();
        }
        else {
            myRef.child(Constant.KEY_TITLE).setValue(title);
            myRef.child(Constant.KEY_AUTHOR).setValue(author);
            myRef.child(Constant.KEY_YEAR).setValue(year);
            myRef.push();
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mainView.inputuccess();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    mainView.inputError();
                    Log.e("onCancelled: ", databaseError.toString());
                }
            });
        }
    }
}
