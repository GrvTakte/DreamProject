package realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import io.realm.Realm;
import io.realm.RealmResults;
import model.Food;

/**
 * Created by gaurav on 31/05/17.
 */

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application){
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment){
        if(instance == null){
            instance = new RealmController(fragment.getActivity().getApplication());
        }

        return instance;
    }

    public static RealmController with(Activity activity){
        if(instance == null){
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application){
        if (instance == null){
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance(){
        return instance;
    }

    public Realm getRealm(){
        return realm;
    }

    public void refresh(){
        realm.refresh();
    }

    public void clearAll(){
        realm.beginTransaction();
        realm.clear(Food.class);
        realm.commitTransaction();
    }

    public RealmResults<Food> getFood(){
        return realm.where(Food.class).findAll();
    }

    public Food getFood(String id){
        return realm.where(Food.class).equalTo("id",id).findFirst();
    }

    public boolean hasFood(){
        return !realm.allObjects(Food.class).isEmpty();
    }

    public RealmResults<Food> queryedFood(){
        return  realm.where(Food.class)
                .contains("userName","userName0")
                .or()
                .contains("title","Realm")
                .findAll();
    }

}
