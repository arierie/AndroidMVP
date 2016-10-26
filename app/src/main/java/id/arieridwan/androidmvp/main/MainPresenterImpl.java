package id.arieridwan.androidmvp.main;

import android.text.TextUtils;

/**
 * Created by ASUS on 25/10/2016.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void input(String title, String author, String year) {
        if(TextUtils.isEmpty(title) || TextUtils.isEmpty(author) || TextUtils.isEmpty(year)){
            mainView.showValidationError();
        }
        else {
            // TODO input firebase
        }
    }
}
