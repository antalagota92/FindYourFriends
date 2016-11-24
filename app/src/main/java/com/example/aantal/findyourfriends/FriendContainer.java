package com.example.aantal.findyourfriends;

import android.content.res.AssetManager;

import com.google.android.gms.maps.model.LatLng;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import static android.R.id.list;

/**
 * Created by AAntal on 17.11.2016.
 */

public class FriendContainer {

    public static Friend[] getFriends() {
        List<Friend> friends = new ArrayList<>();

        Friend friend1 = new Friend(new LatLng(40, 16), "Bori");
        Friend friend2 = new Friend(new LatLng(42, 16), "Bogyo");
        Friend friend3 = new Friend(new LatLng(41, 16), "Baboca");

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);

        Friend[] friendArray = friends.toArray(new Friend[0]);

        return friendArray;
    }
}
