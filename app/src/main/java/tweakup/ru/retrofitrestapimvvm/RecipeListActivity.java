package tweakup.ru.retrofitrestapimvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class RecipeListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mProgressBar.getVisibility() == View.VISIBLE) {
                    showProgressBar(false);
                } else {
                    showProgressBar(true);
                }
            }
        });
    }
}