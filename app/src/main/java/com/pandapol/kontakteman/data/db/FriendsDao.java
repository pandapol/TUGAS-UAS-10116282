package com.pandapol.kontakteman.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.pandapol.kontakteman.data.model.Friends;

import java.util.List;

/**
 Selasa, 6 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

@Dao
public interface FriendsDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addFriend(Friends... friends);

    @Delete
    void deleteFriend(Friends... friends);

    @Update
    void updateFriend(Friends... friends);

    @Query("SELECT * FROM friends ORDER BY nim")
    LiveData<List<Friends>> getAll();
}
